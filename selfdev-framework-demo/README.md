# selfdev-framework-demo

[Sql Visualizer](https://gitee.com/SongRenShuo/mybatis-plus-sql-visualizer) 插件设置项
**「源码捕获帧过滤前缀」（`Source capture frame skip prefixes`）** 的专用测试语料模块。

模拟公司**自研数据访问框架**（不经 MyBatis、无拦截点、只能靠 agent 字节码增强捕获），
用 27 个可运行端点覆盖多种业务调用形态，用于在 IDEA 中对照验证「登记前缀前 / 后」的跳转落点差异。

| 项 | 值 |
|---|---|
| 端口 | 8086 |
| 数据库 | `selfdev_demo`（`createDatabaseIfNotExist=true` 自建；`schema.sql` 每次启动重建） |
| 基线 | Spring Boot 2.6.3 / JDK 1.8 / 仅 `web` + `jdbc` + `mysql-connector-java` |
| 业务包 | `cn.song.selfdevdemo.*` |
| 模拟框架包 | `com.corp.engine.*`（引擎主体）、`com.corp.meta.*`（共享元数据/分页库） |

> 本模块与其他五个子项目的一处差异：启用了 `spring.sql.init`（含 `encoding: UTF-8`）自初始化建表，
> 目标是「起服务即可 curl」，不需要手工跑脚本。

---

## 一、为什么需要这个模块

插件的源码定位有两条链路：

1. **MyBatis 拦截器链路**（`CallerSourceLocator`）——只覆盖 MyBatis/MP 调用，**不消费**帧过滤前缀设置；
2. **agent 增强捕获链路**（`StackLocator`）——在 SQL 执行线程取栈快照，按「内置前缀名单 → 来源过滤 → 安全网」三层判定。

自研框架的场景下链路 1 没有拦截点，只剩链路 2。而 `StackLocator` 的内置名单**刻意不收公司自研包名**
（也刻意不收通用工具库），于是引擎帧全部进入候选池，主位置被判定为「最深的目录帧」= 引擎最深层方法——
现象就是**所有 SQL 的跳转都堆在框架的同一个方法上**。

「源码捕获帧过滤前缀」就是给用户登记这些引擎包名前缀，登记后引擎帧在 L2 即被剔除，主位置回到真实业务行。

## 二、模拟框架结构

```
com.corp.meta                    共享元数据 / 分页库（被引擎依赖）
├── FilterExpression / Q         条件树与条件工厂（业务只发条件、不写 SQL）
├── MetaRegistry / TableMeta     schemaCode → 表表达式 + 字段映射（JOIN 别名在此登记）
├── SqlRenderer                  条件树递归渲染 → WHERE + 命名参数
└── PaginSupport                 分页包装并执行 ← 分页路径的执行链最深层

com.corp.engine                  数据访问引擎主体
├── DataUpdateTool               静态门面（汇聚入口）
├── DataQueryTool                Spring Bean 门面
├── DataQuery                    链式构建器
├── LocalDbService               编排：元数据 → 渲染 → 执行
├── DmlRepository                执行层 ← 普通路径的执行链最深层
├── QueryContext / QueryCallback 回调模板
└── JdkProxyFactory              JDK 动态代理门面
```

SQL 执行时的调用栈（业务帧以下部分）：

```
com.corp.engine.DmlRepository#query            ← 普通路径：最深目录帧（未登记前缀时被选为主位置）
com.corp.engine.LocalDbService#queryList
com.corp.engine.DataUpdateTool#findByFilter    ← 汇聚门面
<业务帧>
```

分页路径再深一层，最深层落在 `com.corp.meta.PaginSupport#wrapAndQuery`。

## 三、验证配方（IDEA 内走查）

1. 用 IDEA 打开 demo 仓库，运行 `SelfDevFrameworkDemoApplication`（端口 8086）。
2. 确认插件**增强捕获已开启**（设置页 SQL 日志 → 增强捕获），并已应用。
3. 触发任一用例（浏览器 / curl / 直接调端点），在插件「SQL 日志」面板点该条记录的跳转。
4. 打开 **Settings → Tools → SQL Visualizer → SQL 日志 → 源码位置捕获 → 源码捕获帧过滤前缀**，
   填入 `com.corp.engine.` 后 Apply（**热下发，无需重启应用**），再触发同一用例，对比落点。

### 实测结果（本机实证，非推断）

下表由在引擎执行链上临时插桩、按插件 `StackLocator` 同款规则过滤栈帧得出（插桩代码已移除）：

| 场景 | 登记的帧过滤前缀 | 实测主位置 |
|---|---|---|
| `/style/static-call` | 无 | `com.corp.engine.DmlRepository#query` ← **缺陷现象** |
| `/style/static-call` | `com.corp.engine.` | `SourceCaptureStyleServiceImpl#staticCall`（业务帧，正确） |
| `/query/paged` | 无 | `com.corp.meta.PaginSupport#wrapAndQuery` |
| `/query/paged` | `com.corp.engine.` | `com.corp.meta.PaginSupport#wrapAndQuery` ← **仍不对** |
| `/query/paged` | `com.corp.engine.` + `com.corp.meta.` | `SourceCaptureQueryServiceImpl#paged`（业务帧，正确） |
| `/depth/deep-three` | `com.corp.engine.` | `DepthInnerServiceImpl#innerQuery`（最深业务帧，正确） |
| `/depth/deep-three` | `com.corp.engine.` + `cn.song.selfdevdemo.` | **候选池为空 → 无位置** ← 误用后果 |

三条结论：

- **前缀要覆盖整条引擎链**：分页用例最深层在 `com.corp.meta`，只登记 `com.corp.engine.` 不够，
  必须两行都填。这是本模块最值得走查的一点。
- **落点是「最深的业务帧」**：三层委托时落到最内层 `DepthInnerServiceImpl#innerQuery`，
  中间层与调用方作为候选帧留在候选列中。
- **切勿登记业务包**：把 `cn.song.selfdevdemo.` 也登记进去，真实业务帧被一并跳过，
  候选池被过滤为空，主位置判定失败——**跳转能力直接消失**（不是落到更外层调用者，而是完全无位置）。

## 四、端点清单（27 个用例 + 1 个索引）

`GET /selfdev/index` 返回同样的清单。四组维度：调用形态 × 委托深度 × 查询形态 × 写路径。

### A 组｜调用形态（`SourceCaptureStyleServiceImpl`）

| # | 端点 | 形态 |
|---|------|------|
| 1 | `GET /selfdev/style/static-call?status=1` | 静态门面直调 |
| 2 | `GET /selfdev/style/bean-call?status=1` | 注入的 Bean 门面 |
| 3 | `GET /selfdev/style/fluent-chain?owner=lisi&limit=5` | 链式构建器终结 |
| 4 | `GET /selfdev/style/lambda-callback?planId=PLAN_2026001` | lambda 回调模板 |
| 5 | `GET /selfdev/style/anonymous-callback?planId=PLAN_2026001` | 匿名内部类回调 |
| 6 | `GET /selfdev/style/jdk-proxy?status=1` | JDK 动态代理门面 |
| 7 | `GET /selfdev/style/reflection?planId=PLAN_2026001` | 反射调用门面 |
| 8 | `GET /selfdev/style/helper-wrapped?owner=lisi` | 业务层包装壳 |
| 9 | `GET /selfdev/style/async-future?status=1` | `CompletableFuture` 异线程 |
| 10 | `GET /selfdev/style/executor-pool?owner=lisi` | 自定义线程池（命名线程） |
| 11 | `POST /selfdev/style/batch-loop?planIds=PLAN_2026001,PLAN_2026002,PLAN_2026003` | 循环批量（同帧 key） |
| 12 | `GET /selfdev/style/combined-nested?planId=PLAN_2026001&owner=lisi` | 单方法两次调用（缓存合流回归） |

### B 组｜委托深度（`SourceCaptureDepthServiceImpl`）

| # | 端点 | 形态 |
|---|------|------|
| 13 | `GET /selfdev/depth/shallow?status=1` | 服务直连门面 |
| 14 | `GET /selfdev/depth/deep-three?planId=PLAN_2026001` | 三层业务委托 |
| 15 | `GET /selfdev/depth/cross-service?owner=lisi&limit=5` | 跨服务协作 |
| 16 | `GET /selfdev/depth/same-package-delegate?owner=lisi` | 业务包内委托壳（**负例**） |

### C 组｜查询形态（`SourceCaptureQueryServiceImpl`）

| # | 端点 | 形态 |
|---|------|------|
| 17 | `GET /selfdev/query/paged?owner=lisi&index=1&size=2` | 分页（需**两个**前缀） |
| 18 | `GET /selfdev/query/paged-deep?planId=PLAN_2026001&index=1&size=5` | 分页 + 三层委托 |
| 19 | `GET /selfdev/query/count?status=1` | 聚合计数 |
| 20 | `GET /selfdev/query/aggregate` | `GROUP BY` 分组聚合 |
| 21 | `GET /selfdev/query/join?planId=PLAN_2026001` | 两表 JOIN 动态 SQL |
| 22 | `GET /selfdev/query/in-condition?planIds=PLAN_2026001,PLAN_2026002` | `IN` 条件 |
| 23 | `GET /selfdev/query/or-nested?owner=zhangsan&status=1` | `OR` 嵌套条件树 |
| 24 | `GET /selfdev/query/order-limit?orderBy=amount%20desc&limit=3` | 排序 + 限制 |

### D 组｜写路径（`SourceCaptureWriteServiceImpl`）

| # | 端点 | 形态 |
|---|------|------|
| 25 | `POST /selfdev/write/update?planId=PLAN_2026005&projectName=quality-trace-updated` | 按条件更新 |
| 26 | `POST /selfdev/write/delete?planId=PLAN_NOT_EXIST` | 按条件删除 |
| 27 | `POST /selfdev/write/batch-update?planIds=PLAN_2026001,PLAN_2026002&status=1` | 循环更新 |

> 26 号默认传不存在的编号，避免破坏后续用例的数据；传真实编号即可实际删除。

## 五、构建与运行

```bash
# 单模块
cd selfdev-framework-demo && mvnd clean package

# 启动
java -jar target/selfdev-framework-demo-1.0.0.jar

# 全端点冒烟（28 项，期望 PASS=28 FAIL=0）
bash verify-endpoints.sh
```

`verify-endpoints.sh` 逐条打全部端点并打印 HTTP 状态与响应体片段，用于回归。

## 六、已知边界

- 帧过滤前缀**只对 agent 增强捕获链路生效**；MyBatis 拦截器链路（`CallerSourceLocator`）不消费该设置。
  因此本模块刻意不用 MyBatis，全部走原生 JDBC，避免两条链路混淆。
- 引擎类与业务类同处 `target/classes` 目录（真实项目「同工程多模块」形态）。
  若把引擎打成独立 JAR，`StackLocator` 的来源过滤（L1）会自行跳过它，前缀就不再必要——
  这也说明本模块的目录形态是复现该功能的必要条件。
- 本模块不测插件设置页的 UI 可见性（已由插件仓库守卫测试锁定）。
