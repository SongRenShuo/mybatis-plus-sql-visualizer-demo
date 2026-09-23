# selfdev-shared-lib

`selfdev-framework-demo` E 组用例的 **JAR 态语料**子工程：一个普通 JAR（非 Spring Boot 应用），
被 demo 以依赖形式引入。它存在的唯一理由，是让「业务代码 / 平台内核代码」在运行期
**以依赖 JAR 的形态被加载**——因为插件 agent 的来源过滤（L1）正是按
`ProtectionDomain.codeSource` 判「JAR = 第三方、目录 = 用户代码」。

真实项目里这个形态很常见：公司公共库、平台扩展包、低代码引擎都以 JAR 出现在 classpath 上，
而它们的包名恰恰是用户在设置里登记的「源码捕获帧过滤前缀」。

| 类 | 包 | 角色 | 目录态同构类 |
|---|---|---|---|
| `SqlKernel` | `com.corp.platform` | 平台内核帧：真正 `executeQuery()` 的一层，**不登记前缀**时它就是全应用共享的缓存 key 提供者 | `cn.song.selfdevdemo.kernel.PlanTreeKernel` |
| `PlanTreeQueryBuilder` | `com.corp.shared.util` | 业务侧树构建器：SQL 执行点在业务工具类里（两处调用点），Service 只是它的调用方 | `cn.song.selfdevdemo.util.PlanTreeQueryBuilder` |

两对类**逐行等价**，唯一差异是打包形态——这就是 E 组实验的自变量。

## 构建与安装

```bash
# 仓库根目录（聚合构建会自动先建本模块再建 demo）
mvnd clean install -pl selfdev-shared-lib

# 或整体
mvnd clean install
```

## 走查「JAR 态」档位的必要条件（重要）

E29 / E30 / E31 要求 `com.corp.*` 这两帧**真的来自 JAR**。IDEA 的 Maven 集成默认做
workspace 解析：只要 `selfdev-shared-lib` 是同一 IDEA 工程里的模块，demo 依赖就会被替换成
兄弟模块的 `target/classes`（目录形态），此时 E29 会退化成与 E28 同形——**这个退化本身就是
可观察量**（同一份代码，目录形态跳得对、JAR 形态跳不对），但要看到 JAR 档位需二选一：

1. 仓库根 `mvnd install` 一次 → 在 IDEA 的 Maven 面板对 `selfdev-shared-lib` 执行
   **Unload Projects**（依赖随即回落到本地仓库的 JAR），走查完再重新 Load；
2. 或不用 IDEA 启动应用：`mvnd install -pl selfdev-shared-lib` 后
   `mvnd -pl selfdev-framework-demo spring-boot:run`（单模块 reactor ⇒ 依赖取本地仓库 JAR）。

对照验证：启动后访问 `GET /selfdev/index`，或直接看任一 SQL 的跳转落点是否停在 Service 的调用行。

## 边界

- 本工程不引任何框架依赖（含 Spring），避免把额外的框架帧带进 E 组的对照栈。
- 本工程不单独运行，也不产生 SQL 之外的行为；数据源由 demo 侧
  `SharedLibConfiguration` 在装配期注入 `SqlKernel.init(DataSource)`。
