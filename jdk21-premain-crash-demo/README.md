# jdk21-premain-crash-demo

在 **JDK 21** 上复现并验证「第三方 agent 让插件重定位 ASM 不可见 → premain 致命」的最小 demo。
对应主仓问题：`-javaagent` 启动即
`FATAL ERROR in native method: processing of -javaagent failed, processJavaStart failed`，
栈顶落在 `DriverRegistry.isStatementWeavable:61 → retransformLoadedDrivers:95 → install:65 → premain:37`。

本工程不改主仓、不改插件，只**只读**地拿插件已打包的 agent jar 做实验。

## 一条命令

```powershell
cd F:\code\Java\Gitee\SongRenShuo\mybatis-plus-sql-visualizer-demo\jdk21-premain-crash-demo
powershell -NoProfile -ExecutionPolicy Bypass -File run.ps1
```

退出码 `0` = 三格全部符合预期。

默认会自动找：
- **JDK**：`~/.jdks/` 下带 `21` 的目录（优先 Corretto）；
- **agent jar**：日常 IDEA 已装插件的 `plugins/mpsv-agent/mps-sql-agent-*.jar`
  （注意是 `AppData\Local`，不是 `Roaming`）；
- **MySQL 驱动**：`~/.m2` 下的 **8.x**（预热目标是 `com.mysql.cj.jdbc.*`，5.1.x 包名不同）。

任一找不到时可用参数显式指定：

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File run.ps1 `
  -Jdk       "C:\Users\YOU\.jdks\corretto-21.0.12.1" `
  -AgentJar  "C:\Users\YOU\AppData\Local\JetBrains\IntelliJIdea2026.2\plugins\mpsv-agent\mps-sql-agent-XXXX.jar" `
  -MysqlJar  "C:\Users\YOU\.m2\repository\mysql\mysql-connector-java\8.0.28\mysql-connector-java-8.0.28.jar"
```

## 它复刻的是什么

用户现场里，JRebel 接管 premain 的类加载后，插件 jar 内
`cn/song/mybatisplus/sqlvis/agent/asm/Opcodes` 在那个加载器里解析不到。

本 demo 用最确定的方式造出同一条件：**把该类从 agent jar 里删掉**。对 JVM 而言两者等价
（都是「这个类在此加载器不存在」），但不依赖 JRebel 授权、完全可重放。

## 三格的含义

| 格 | 构造 | 期望（修复版） | 期望（旧版） |
|---|---|---|---|
| 1 | 完整 agent + 预热语句类 | 正常启动 | 正常启动 |
| 2 | **缺 `asm/Opcodes`** + 预热语句类 | **正常启动** | **FATAL，起不来** |
| 3 | 缺 `asm/Opcodes` + **不预热** | 正常启动 | **FATAL，起不来** |

第 2 格是核心：`transformFailed=1` 说明那次织入确实失败了，但应用仍然活着——这正是兜底在起作用。

第 3 格固化了一条**曾被误判的事实**：

> `matched=0` **不等于**谓词没被调用。

`retransformLoadedDrivers` 会对**每一个**已加载类依次调用
`isWeavable / isStatementWeavable / isPrepareWeavable`，`matched` 只在命中后才 +1。
所以只要三个谓词里任一次执行触发了 `StatementWeaver` 类初始化，旧版就崩——与「有没有类命中」无关。
早期我用「不预热就不崩」当判据，被这一格实测推翻。

## 为什么要预热语句类

插件只在 `getAllLoadedClasses()` 里出现登记表内的语句/驱动类时才有意义；干净启动的小应用
常常 `matched=0`。`WarmupAgent` 在自己的 premain 里先 `Class.forName("com.mysql.cj.jdbc.StatementImpl")`，
把目标类「暖」进 JVM，让后续插件的 premain 必然命中——这样第 1、2 格才有鉴别力。

## 怎么用它验收你的插件版本

```powershell
# 用你装的那个 agent
powershell -NoProfile -ExecutionPolicy Bypass -File run.ps1 -AgentJar <你的 mps-sql-agent-*.jar>
```

- 三格全 PASS → 该 agent 已含修复（脚本会读 jar 里有无 `WeaveSpecs.class` 判定 `hasFix`）。
- 第 2、3 格 FAIL 且日志出现 `FATAL ERROR ... processJavaStart failed` → 该版本未修复。

脚本会在开头打印 `agent 含 WeaveSpecs(修复标志) = true/false`，可直接确认。

## 输出

每格完整输出落在 `build/reports/<cell>.log`（可用 `-OutDir` 改）。关键行：

- `[SqlVisAgent] attach retransform: matched=N ... transformFailed=M`
- `[App] started, java=...`（应用活着）
- `Caused by: java.lang.NoClassDefFoundError: ...asm/Opcodes`（缺失类，预期在旧版出现）
- `FATAL ERROR in native method: processing of -javaagent failed, processJavaStart failed`

## 编码注意

`run.ps1` 必须保存为 **UTF-8 with BOM**。Windows PowerShell 5.1 在无 BOM 时按系统代码页（本机 GBK）
解析脚本，中文会乱码并触发「字符串缺少终止符」「数组索引无效」等一串假语法错误。

## 与同仓 `agent-premain-hostile-loader-repro` 的分工

| 工程 | 手段 | 特点 |
|---|---|---|
| `agent-premain-hostile-loader-repro` | 敌意 `ClassLoader` + 反射调 premain | 可控实验，能细分到每个方法跳 |
| 本工程 | 真 `-javaagent` + 真子进程 + jar 内删类 | 真机形态，更贴近用户现场 |

两者互补：要定位「哪一跳炸了」用前者，要回答「真实启动会不会死」用后者。
