# agent-premain-hostile-loader-repro

复现「javaagent 增强捕获 + JRebel 形态的第三方类加载器」导致 `premain` 崩溃的独立子工程。
对应主仓问题：`-javaagent` 启动即 `FATAL ERROR: processing of -javaagent failed`，栈顶落在
`DriverRegistry.isStatementWeavable:61 → AgentMain.retransformLoadedDrivers:95 → install:65 → premain:37`。

本工程不改主仓任何代码，只**只读引用**主仓已构建的
`sub-projects/sql-visualizer-agent/build/dist/mps-sql-agent.jar`。

## 一条命令跑完

```powershell
cd F:\code\Java\Gitee\SongRenShuo\mybatis-plus-sql-visualizer-demo\agent-premain-hostile-loader-repro
powershell -NoProfile -ExecutionPolicy Bypass -File run.ps1
```

可选参数：`-AgentJar <path>`（默认自动找主仓产物）、`-Jdk <jdk-home>`（默认优先 Corretto 21）、
`-OutDir <dir>`（默认 `build/reports`）。

退出码 `0` = 全部格符合预期；`1` = 有格与预期不符。每格的完整输出落在 `build/reports/<cell>.log`，
汇总在 `build/reports/summary.txt`。

> 为什么是 `.ps1`：本机 Git Bash 会把 `/X` 形式的参数当路径改写，且命令行写中文会乱码。
> 脚本已做 UTF-8 BOM + `[Console]::OutputEncoding` + `-Dstdout.encoding=UTF-8` 三处对齐，
> 控制台和日志文件都不会出现乱码。

## 环境（实测读数出自这里）

| 项 | 值 |
|---|---|
| JDK | Amazon Corretto **21.0.12.1**（用户报的是 21.0.5，同主版本、不同补丁） |
| 备选 JDK | Microsoft OpenJDK 21.0.11 |
| agent jar | 主仓 `build/dist/mps-sql-agent.jar`，345070 字节，137 个条目 |
| JRebel | **未参与**（原因见下文「边界声明」） |

---

## 判据有效性前提（必读，这是最容易踩的假绿坑）

`AgentMain.retransformLoadedDrivers` 遍历 `inst.getAllLoadedClasses()`，对每个类判
`isWeavable || isStatementWeavable || isPrepareWeavable`。因此复现装置必须满足：

1. `getAllLoadedClasses()` **不能是空数组**——空了循环一次都不进，三连谓词从不被调用，
   `premain` 必然正常返回。此时「没崩」是**假绿**，不是「不会崩」。
2. 其中至少一个类的名字**命中登记表**，否则循环会跑但 `matched=0`，同样走不到目标断言点。

本工程的做法：`FakeInstrumentation.withStatementStub()` 返回
`com.mysql.cj.jdbc.StatementImpl`（`StatementWeaver.SPECS` 里的类名，本仓库内只有名字、无行为）
+ `java.lang.String`。asm 可见时实测 `matched=1 wove=1`，与主控独立实测读数一致。

并且每个关键格都加了**装置有效性断言**：

- `A1.control-reached-retransform-loop(matched>=1)`：`retransformCalls>=1`
- `C.装置有效: 栈帧证明循环走到了 isStatementWeavable`：失败的最内层 agent 帧必须是
  `isStatementWeavable`——它只可能由「for 循环 + 三连谓词」产生
- `C.装置有效: getAllLoadedClasses 含登记表桩类`

注意一个反直觉点：在 asm 不可见的路径上，失败发生在**谓词内部**，`retransformClasses` 还没被调用，
所以 `retransformCalls` 必然为 `0`。**不能**拿 `retransformCalls>=1` 当「循环走到了谓词」的证明，
只能用栈帧证明。这一条我第一版写错过，已改正。

---

## 各格说明与实测读数

### recon0 —— jar 静态取证（不加载 agent 类）

```powershell
java -cp build\classes cn.song.sqlvis.repro.ReproMain recon0 <agentJar>
```

用自写的 class 文件解析器（`ClassFileModel`，无第三方依赖——本工程要证的正是「ASM 运行期不可见」，
不能拿 ASM 当测量工具），做常量池引用**闭包**分析，区分「活引用」与「死条目」。

预期：所有 `[PASS]`。

实测（全 PASS）：

```
[NOTE] jar-entries-total = 137
[NOTE] jar-entries-original-asm-prefix = 0
[NOTE] StatementWeaver.interfaces = [cn/song/mybatisplus/sqlvis/agent/asm/Opcodes]
[NOTE] StatementWeaver.live-asm-classRefs = [asm/ClassReader, asm/ClassWriter, asm/Opcodes,
        asm/tree/AbstractInsnNode, asm/tree/ClassNode, asm/tree/FrameNode, asm/tree/InsnList,
        asm/tree/InsnNode, asm/tree/LdcInsnNode, asm/tree/MethodInsnNode,
        asm/tree/MethodNode, asm/tree/VarInsnNode]
[NOTE] StatementWeaver.dead-original-asm-entries = [org/objectweb/asm/... 共 12 个]
[NOTE] StatementWeaver.live-memberRefs-on-Opcodes =
        [asm/Opcodes.DOUBLE:Ljava/lang/Integer;, asm/Opcodes.LONG:Ljava/lang/Integer;,
         asm/Opcodes.TOP:Ljava/lang/Integer;]
[NOTE] Opcodes-memberref-holders(methods) = [patchFrames (MethodNode;IIILjava/lang/String;)V]
[NOTE] ConnectWeaver.interfaces = [cn/song/mybatisplus/sqlvis/agent/asm/Opcodes]
```

两个值得记住的读数：

- **jar 里 `Opcodes.class` 在**（`jar-entries-total=137`，7 个必需条目全 present）。
  所以不是打包漏类，而是**加载期该加载器看不见它**。
- **`StatementWeaver.class` 里同时存在重定位后和未重定位两套 ASM 前缀**：
  `cn/song/.../asm/*` 是活引用；`org/objectweb/asm/*` 有 12 个 Class 项但**全部落在引用闭包之外**
  （`ClassWriter(ClassReader, flags)` 拷贝原常量池留下的死条目，永不解析）。
  这解释了为什么用 grep 数 `org/objectweb/asm` 会得到完全错误的结论。

### javap 复核（与主控独立读数对照）

```bash
# 解出 agent 类
cd /tmp && mkdir reconx && cd reconx
unzip -q <agentJar> 'cn/song/mybatisplus/sqlvis/agent/*.class' -d .
J=/c/Users/USER/.jdks/corretto-21.0.12.1/bin/javap

# StatementWeaver：类头 1 处 + 方法体 6 处
$J -p -c -v cn/song/mybatisplus/sqlvis/agent/StatementWeaver.class | grep -n "getstatic.*asm/Opcodes\."
$J -p -c -v cn/song/mybatisplus/sqlvis/agent/StatementWeaver.class | grep -n "^public final class"

# ConnectWeaver：类头 1 处 + 方法体 0 处
$J -p -c -v cn/song/mybatisplus/sqlvis/agent/ConnectWeaver.class | grep -c "getstatic.*asm/Opcodes\."
```

实测计数（JDK 21.0.12.1 的 javap）：

| 类 | 类头 `implements` | 方法体 `getstatic ...asm/Opcodes.` | 字段类型 |
|---|---|---|---|
| `StatementWeaver` | 1 处 | **6 处** | `Ljava/lang/Integer;`（装箱静态字段） |
| `ConnectWeaver` | 1 处 | **0 处** | 无引用（int 常量已被 javac 内联） |

`StatementWeaver` 6 处的具体位置（全在 `patchFrames`）：

```
72:  getstatic #521  // asm/Opcodes.LONG:Ljava/lang/Integer;
80:  getstatic #522  // asm/Opcodes.DOUBLE:Ljava/lang/Integer;
105: getstatic #523  // asm/Opcodes.TOP:Ljava/lang/Integer;
122: getstatic #521  // asm/Opcodes.LONG:Ljava/lang/Integer;
142: getstatic #523  // asm/Opcodes.TOP:Ljava/lang/Integer;
182: getstatic #523  // asm/Opcodes.TOP:Ljava/lang/Integer;
```

**与主控结论一致。** 原因是这些字段在 ASM 里声明为 `public static final Integer LONG/DOUBLE/TOP`——
是**对象**而非 `int` 基本类型常量，javac 无法内联，必须运行期 `getstatic` 解析。

### reproA —— 核心复现（hostile ClassLoader + 反射 premain）

```powershell
java -cp build\classes cn.song.sqlvis.repro.ReproMain reproA <agentJar>
```

装置：`HostileLoader`（child-first，parent = platform loader）对
`cn.song.mybatisplus.sqlvis.agent.asm.*` 抛 `ClassNotFoundException`，其余 agent 类从 jar 自己 define；
`FakeInstrumentation` 提供 `getAllLoadedClasses()`（含登记表桩类）、`isModifiableClass→true`、
`retransformClasses` 空实现；args 用 `port=<空闲端口>` 使 `AgentArgs.parse` 通过。

**A1 正对照（asm 可见）** 预期 `premain` 正常返回：

```
[SqlVisAgent] attach retransform: matched=1 wove=1 unmodifiable=0 failed=0 | transformer: ...
[NOTE] premain returned normally
[PASS] A1.control-premain-returns-normally
[PASS] A1.control-reached-retransform-loop(matched>=1)  -> retransformCalls=1
```

**A2 现场形态（asm 不可见）** 预期抛异常，且异常链与栈帧同现场：

```
[HostileLoader] DENY cn.song.mybatisplus.sqlvis.agent.asm.Opcodes
[PASS] A2.premain-throws  -> java.lang.reflect.InvocationTargetException
[NOTE] target exception = java.lang.NoClassDefFoundError: cn/song/mybatisplus/sqlvis/agent/asm/Opcodes
[NOTE] target cause = java.lang.ClassNotFoundException: cn.song.mybatisplus.sqlvis.agent.asm.Opcodes
[PASS] A2.cause-is-NoClassDefFoundError
[PASS] A2.message-names-asm/Opcodes
[NOTE] agent stack frames:
        DriverRegistry.isStatementWeavable(DriverRegistry.java:61)
        AgentMain.retransformLoadedDrivers(AgentMain.java:95)
        AgentMain.install(AgentMain.java:65)
        AgentMain.premain(AgentMain.java:37)
[PASS] A2.innermost-agent-frame-is-isStatementWeavable
[PASS] A2.static-block-DriverRegistry-init-succeeded
```

**与用户现场四帧逐行一致（含行号）**。JRebel 只是把 NCDFE 包成自己的 `com.zeroturnaround.javarebel.yo`
类型，本质不变。

顺带证实了「第一现场被吞掉」的机制：`AgentMain` 静态块里的
`Class.forName(DriverRegistry.class.getName(), true, ...)` 包在 `catch (Throwable ignore) {}` 里，
而 `DriverRegistry.<clinit>` 只碰 `HashSet`/`Collections`、**不含任何 ASM 依赖**，所以它必然成功——
失败被推到 `premain` 主路径上才炸出来。

### linkage —— 「链接期就要可见」的机制对照（不依赖 agent jar）

```powershell
java -cp build\classes cn.song.sqlvis.repro.ReproMain linkage
```

装置：一个最小 fixture（`fixture.Holder`），其中 `untouched(String)` 与不可见类型毫无关系，
`usesInvisible(Invisible)` 才会用到它。用「看不见 Invisible」的加载器 define `Holder`，然后
**只调 `untouched`**。

实测：

```
[PASS] M1.holder-loads-without-invisible  -> defineClass 成功（类型检查延迟到链接期）
[PASS] M1.untouched-method-still-fails  -> java.lang.NoClassDefFoundError: .../fixture/Invisible
[NOTE] M1 root = java.lang.ClassNotFoundException: cn.song.sqlvis.repro.fixture.Invisible
```

结论：**只要类里任一处引用不可见类型，整个类的链接就要求它可见，与调用哪个方法无关。**
这正是现场的形状：`isStatementWeavable` 只查一个 `HashMap`，却因为 `StatementWeaver` 这个类
整体链接不过而抛 NCDFE。

### hypothesis —— 实测证伪「删掉 `implements Opcodes` 就能解耦」

```powershell
java -cp build\classes cn.song.sqlvis.repro.ReproMain hypothesis <agentJar>
```

做法：不改主仓源码，用 `InterfaceStripper` 在**本工程 build 目录**里造一份
`StatementWeaver` 的 `interfaces_count=0` 副本（常量池不动，只删接口表），跑同一套 premain 装置。

实测：

```
[PASS] H0.stripped-interfaces-count-is-zero  -> interfaces=[]
[PASS] H0.stripped-still-references-Opcodes-fields
        -> [asm/Opcodes.LONG:Ljava/lang/Integer;, asm/Opcodes.DOUBLE:..., TOP:...]
[PASS] H1.falsified: premain STILL throws after removing implements
        -> 仍抛 ClassNotFoundException: ...asm.ClassVisitor（假设不成立）
[NOTE] H1 agent stack frames:
        DriverRegistry.isStatementWeavable(DriverRegistry.java:61)
        AgentMain.retransformLoadedDrivers(AgentMain.java:95)
        AgentMain.install(AgentMain.java:65)
        AgentMain.premain(AgentMain.java:37)
[PASS] H1.failure-stays-in-premain-at-same-call-site
[PASS] H2.weave-also-fails-on-asm  -> CNFE: ...asm.ClassVisitor
```

**主控的 P-3 假设（删接口 → 失败点后移到 `weave()`）不成立，且我的读数比主控的更细一步：**

删掉 `implements Opcodes` 后，`premain` **仍然在同一调用点 `isStatementWeavable` 抛异常**，
只是被拒的 ASM 类名从 `Opcodes` 换成了**另一个** ASM 类型。我两次独立跑到的名字不同——
一次 `AbstractInsnNode`、一次 `ClassVisitor`——取决于 JVM 当时的类型解析顺序。这一点比
「失败点后移到 `weave()`」的结论更严格：**删接口连「后移」都做不到，只是换了个替死鬼**。

机制解释由 `linkage` 格给出：`StatementWeaver` 的方法体/描述符/StackMapTable 帧里到处是
`MethodNode`、`FrameNode`、`AbstractInsnNode`、`ClassVisitor` 等 ASM 类型，类链接一旦开始
就要逐个解析它们。`implements` 只是清单里最先被解析的那一项，删掉它，下一个不可见的 ASM 类型
立刻顶上。

**所以「删 `implements Opcodes`」不是修复方案，连缓解都不是。** 真正的分割只有两条：
把 ASM 需求整类隔离到「按需加载 + 失败降级」的路径上，或者让 `premain` 整体不允许外抛。

### reproB1 —— 负对照：无第三方加载器时真 `-javaagent` 正常启动

```powershell
java -javaagent:<agentJar>=port=45871 -cp build\classes cn.song.sqlvis.repro.MinimalMain
```

实测（exit 0）：

```
[SqlVisAgent] attach retransform: matched=0 wove=0 unmodifiable=0 failed=0 | ...
[MinimalMain] started, java=21.0.12.1, systemClassLoader=jdk.internal.loader.ClassLoaders$AppClassLoader
[MinimalMain] exiting normally
```

`matched=0` 是因为最小宿主确实没加载任何 JDBC 驱动/语句类——这里**不是**缺陷，
B1 只证明「没有第三方加载器介入时，`-javaagent` 不会崩」。

### reproB2 —— 缺 `Opcodes.class` 的 jar 副本，真 JVM 复现现场原文

```powershell
java -javaagent:build\tmp\hypothesis\mps-sql-agent-no-opcodes.jar=port=45872 -cp build\classes cn.song.sqlvis.repro.MinimalMain
```

（jar 副本由 `run.ps1` 生成：只删 `cn/song/mybatisplus/sqlvis/agent/asm/Opcodes.class`，其余原样。
**不写主仓目录**——第一版误写到主仓 `build/dist/`，已删除并改正。）

实测（exit 1）：

```
Caused by: java.lang.NoClassDefFoundError: cn/song/mybatisplus/sqlvis/agent/asm/Opcodes
	at cn.song.mybatisplus.sqlvis.agent.DriverRegistry.isStatementWeavable(DriverRegistry.java:61)
	at cn.song.mybatisplus.sqlvis.agent.AgentMain.retransformLoadedDrivers(AgentMain.java:95)
	at cn.song.mybatisplus.sqlvis.agent.AgentMain.install(AgentMain.java:65)
	at cn.song.mybatisplus.sqlvis.agent.AgentMain.premain(AgentMain.java:37)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(...)
	at java.instrument/sun.instrument.InstrumentationImpl.loadClassAndStartAgent(...)
	at java.instrument/sun.instrument.InstrumentationImpl.loadClassAndCallPremain(...)
*** java.lang.instrument ASSERTION FAILED ***: "result" with message agent load/premain call failed
FATAL ERROR in native method: processing of -javaagent failed, processJavaStart failed
```

这是本工程**最贴近现场**的一格：真 JVM、真 `-javaagent`、真 JPLIS、真 `FATAL ERROR`，
连 `InstallationImpl.loadClassAndCallPremain` 那几帧都在。与用户日志逐字相同（用户那里
多一个 `reorder.b.start → _jrLoadClassAndStartAgent` 转发帧，见「边界声明」）。

### reproB3 —— 自定义 system class loader（`-Djava.system.class.loader`）

```powershell
java -Djava.system.class.loader=cn.song.sqlvis.repro.HostileSystemLoader -javaagent:<agentJar>=port=45873 -cp build\classes cn.song.sqlvis.repro.MinimalMain
```

实测（exit 1）：

```
[HostileSystemLoader] DENY cn.song.mybatisplus.sqlvis.agent.asm.Opcodes
Caused by: java.lang.ClassCircularityError: cn/song/mybatisplus/sqlvis/agent/StatementWeaver
	at cn.song.mybatisplus.sqlvis.agent.DriverRegistry.isStatementWeavable(DriverRegistry.java:61)
	... 同上四帧
FATAL ERROR in native method: processing of -javaagent failed, processJavaStart failed
```

**异常类型与 A2/B2 不同**（`ClassCircularityError` 而非 `NoClassDefFoundError`）：JPLIS 在同一
system loader 上重入加载时，JDK 把「正在加载的类又要求加载自己」判成环度错误。**失败点完全一致**
（`isStatementWeavable:61`），进程同样起不来。这一格的价值是证明「换一种加载器实现方式，
致命性不变」，所以 `run.ps1` 里只断言「同一失败点 + FATAL ERROR」，不断言异常类型。

踩坑记录：自定义 system loader 必须实现 `public void appendToClassPathForInstrumentation(String)`，
否则 JVM 直接
`FATAL ERROR ... the system class loader does not define the appendToClassPathForInstrumentation method`
——这个失败发生在 agent 自己的代码之前，看不出任何 agent 痕迹。第一版就是这么踩的。

### reproC —— 守卫形态（C-before 现状红 / C-after 修复后判据）

```powershell
java -cp build\classes cn.song.sqlvis.repro.ReproMain reproC <agentJar>
```

分两半，避免「断言 premain 正常返回」在装置无效时天然成立（那样没有任何鉴别力）：

**C-before（现状，预期红）**——先证明装置真的有鉴别力：

```
[PASS] C.装置有效: 栈帧证明循环走到了 isStatementWeavable
        -> innermost=DriverRegistry.isStatementWeavable(DriverRegistry.java:61)；getAllLoadedClasses=2 个
[PASS] C.装置有效: getAllLoadedClasses 含登记表桩类
[PASS] C-before.premain-目前外抛  -> java.lang.ClassNotFoundException: ...asm.Opcodes
[PASS] C-before.异常是-NoClassDefFoundError
[PASS] C-before.消息含-asm.Opcodes
```

**C-after（修复后必须变绿）**——现状为红，这是本格存在的意义：

```
[FAIL] [C-after] premain-must-not-throw  -> 现状外抛 ...asm.Opcodes → 修复后此处应变绿
[FAIL] [C-after] stderr-should-have-degradation-notice  -> 抛异常时根本走不到降级路径 → 修复后此处应变绿
RESULT[reproC] = KNOWN-FAIL(expected)  failedChecks=2
```

`run.ps1` 把 `KNOWN-FAIL` 当作**符合预期**（`[assert] C 现状外抛（预期）→ PASS(as-designed)`），
所以整个脚本不会因为这格而失败。

**修复落地后要做两件事**，否则这条用例就失去了鉴别力：

1. 把 `ReproMain.reproC` 里的 `assertBeforeFix` 改成 `false`（或删掉 C-before 分支）；
2. **反向验证**：把修复摘掉，`C-after` 必须变红。只做正向（修复后变绿）不算验证过。

---

## 与主控读数的对照

| 项 | 主控读数 | 本工程读数 | 是否一致 |
|---|---|---|---|
| asm 可见 | `matched=1 wove=1` → 正常返回 | `matched=1 wove=1` → 正常返回 | 一致 |
| asm 不可见 | NCDFE `asm/Opcodes`，cause CNFE | 同 | 一致 |
| 失败栈 | `isStatementWeavable:61 → retransformLoadedDrivers:95 → install:65 → premain:37` | 同（四帧含行号） | 一致 |
| `StatementWeaver` 的 `Opcodes` 引用 | 类头 1 + 方法体 6 | 类头 1 + 方法体 6（全在 `patchFrames`） | 一致 |
| `ConnectWeaver` 的 `Opcodes` 引用 | 仅类头 1 | 仅类头 1，方法体 0 | 一致 |
| 删 `implements` 的效果 | 无效 | 无效，且**仍在同一调用点**，只换了被拒的 ASM 类名 | 一致，且更细一步 |

### 我改了哪些（相对主控同步前的版本）

1. **补上了假绿坑的防护**：第一版 `FakeInstrumentation.withNeutralClasses()` 只给
   `String`/`FakeInstrumentation`，两者都不在登记表里 → 循环虽然进了但 `matched=0`。
   现改为 `withStatementStub()`（含 `com.mysql.cj.jdbc.StatementImpl` 桩）并加 `matched>=1` 断言。
2. **Corretto 21.0.12.1 替代 ms-21.0.11 作为主环境**（`run.ps1` 的 JDK 优先级已调整）。
3. **Repro C 按新的判据收紧**：加了装置有效性断言、C-before/C-after 分离，并去掉了
   「`retransformCalls>=1` 才有效」这个错误代理指标（该路径上它必然为 0，见「判据有效性前提」）。
4. **hypothesis 格改成断言实测结论**（原先断言的是主控假设，会把「假设被证伪」报成 FAIL）。

## 边界声明

- **没有复刻 JRebel 那条路径本身。** 本机在役的 JRebel（2026.3.2 / 2026.4.0）都是 native agent：
  `-javaagent:jrebel.jar` 只打印「改用 `-agentpath:jrebel64.dll`」并让 JVM 退出；`-agentpath` 叠加
  我们的 agent 则正常启动（`matched=0`）。用户栈里的 `reorder.b.start → _jrLoadClassAndStartAgent`
  属纯 Java 转发路径，本机版本到不了。
  **本工程复刻的是那条路径的必要条件——「重定位后的 asm 包在加载 agent 类的那个加载器里不可见」**，
  不是 JRebel 的转发机制本身。
- **用户环境是 Corretto 21.0.5，本机是 21.0.12.1**（同主版本不同补丁）。本工程所有读数都出自
  21.0.12.1，README 与日志中已明确标注。JDK 21.0.11 上也跑过，结论相同。
- **`com.mysql.cj.jdbc.StatementImpl` 是空壳桩**（只有类名，无 JDBC 行为）。复现只需要类名命中
  登记表；`retransformClasses` 在替身里是空实现，不涉及真实织入。
- **未覆盖**：真实 Spring Boot + MyBatis 宿主下的同一崩溃（本工程用 5 行 `MinimalMain` 即可，
  因为崩溃发生在 `premain` 阶段，宿主是否 Spring 无关）。若后续要验「宿主内行为」再另立工程。

## 目录结构

```
agent-premain-hostile-loader-repro/
├─ run.ps1                                   一键入口（编译 + 8 格 + 汇总）
├─ pom.xml                                   仅为 IDE 识别源码根；不引任何第三方依赖
└─ src/main/java/
   ├─ cn/song/sqlvis/repro/
   │  ├─ ReproMain.java                      各格调度 + 断言
   │  ├─ AgentJarProbe.java                  recon0：jar 取证
   │  ├─ ClassFileModel.java                 自写 class 解析器 + 引用闭包
   │  ├─ InterfaceStripper.java              hypothesis：无损删接口
   │  ├─ HostileLoader.java                  reproA：进程内 child-first 加载器
   │  ├─ HostileSystemLoader.java            reproB3：-Djava.system.class.loader
   │  ├─ FakeInstrumentation.java            Instrumentation 替身（语句面桩）
   │  ├─ LinkageProbe.java                   linkage：链接期可见性对照
   │  ├─ MinimalMain.java                    reproB：5 行宿主
   │  └─ fixture/{Holder,Invisible}.java     linkage 的最小 fixture
   └─ com/mysql/cj/jdbc/StatementImpl.java   登记表桩（只有类名）
```
