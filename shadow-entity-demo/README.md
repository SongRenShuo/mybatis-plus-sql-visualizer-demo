# shadow-entity-demo — 同包同名影子实体复现用例（jar 内宿主叠加工程同 FQN 影子实体）

> 端口 **8089** / 库 **jpa_demo**（与其它 JPA 模块共用库，表名独立：`wms_task_project`）
> Spring Boot 2.6.3 + Spring Data JPA（Hibernate 5.6.4）
> JAR 版实体 + 自定义 DAO + 带 HQL 的方法体全在依赖 JAR [`shadow-entity-lib`](../shadow-entity-lib) 里；
> 本模块源码树里**另有一份**同包同名（同 FQN）的 `com.example.shadow.model.WmsTask`——「影子类」。

## 这个模块复现什么

用户报障：HQL 场景下，**方法在 jar 中、HQL 也在 jar 中、实体类也在 jar 中**；后来在项目下新增了一个
同包名同类名的类并调整了字段。此时插件无法识别实体，预览显示为 `实体不可解析，降级为 task.*`。

产出物形态（第一档降级注释，出处 `SelectClauseExpander.renderColumns`）：

```sql
select task.* /* 实体不可解析，降级为 task.* */ from unknown_table task where ...
```

三个条件同时满足才触发，本模块逐条对上：

1. **HQL 与执行 HQL 的 DAO 方法都在 JAR 内**（`shadow-entity-lib` 里的 `WmsTaskJarDao` /
   `WmsTaskJarService` 方法体）；
2. **HQL 引用的实体也在同一个 JAR 内**（JAR 版 `com.example.shadow.model.WmsTask`）；
3. **工程里又有一份同包名同类名的「影子类」**（本模块源码里的 `com.example.shadow.model.WmsTask`，
   字段与 JAR 版有差异）。

机理一句话：HQL 所在方法在 JAR 里 ⇒ 平台 `ProjectFileIndex.getModuleForFile` 恒为 null ⇒ 搜索作用域
退到全工程 ⇒ 同 FQN 的两份候选不被消解 ⇒ 多候选即解析失败（fail closed）⇒ 降级。

## 两版实体差异（走查判据）

两版**刻意只在表名与列清单上不同**，且 HQL 引用到的字段名（`status` / `type` / `taskNo`）两版一致——
这样「插件取到了哪一版」的差异**只会**体现在表名与列清单上，不会被第二种降级原因（字段名对不上）污染。

| | JAR 版（`shadow-entity-lib`） | 宿主影子版（本模块源码） |
|---|---|---|
| 表名 | `wms_task_jar` | **`wms_task_project`** |
| 列清单 | `id` / `task_no` / `status` / `type` | `id` / `task_no` / `status` / **`task_type`** / **`remark`** |
| `type` 字段的物理列 | `type` | `task_type`（改名） |
| 额外列 | — | `remark`（影子版独有） |

运行期实际生效的是**影子版**：工程输出目录（`target/classes`）在 classpath 上先于依赖 JAR，
同 FQN 的类以工程那份为准。所以**正确读数应当是 `wms_task_project`**。

## 三个调用点（走查对象）

| 调用点 | 所在位置 | HQL 所在方法在 | 预期 |
|---|---|---|---|
| `WmsTaskJarDao#findByStatusAndType` | JAR 内 DAO 类 | **JAR 内** | **复现缺陷**（触发点一，任务书要求的 DAO 内 HQL 形态） |
| `WmsTaskJarService#beAllocateSuccess` | JAR 内 service 类 | **JAR 内** | **复现缺陷**（触发点二，报障 `beAllocateSuccess` 同款） |
| `ShadowTaskQueryService#findByStatusAndType` | 本模块源码（工程内容） | **工程内** | **不复现**（对照组：工程内宿主时同 FQN 按 classpath 序正常消解） |

三处调用形态都是 `xxxDao.findByQuery(hql, new String[]{...}, new Object[]{...})` 双数组传参。
对照组用来把变量锁死：缺陷的必要条件是「HQL 所在方法落在 JAR 里」，不是调用形态、类名或包名。

## 跑起来（也可仅做静态走查，不必启动）

```bash
# 1) 先装 JAR 态语料（单模块构建/启动必须；聚合构建 -am 会自动带上）
D:/HuanJing/Maven/maven-mvnd-1.0.3/bin/mvnd.cmd -pl shadow-entity-lib install -o -DskipTests

# 2) 打包宿主（-o 离线走 ~/.m2）
D:/HuanJing/Maven/maven-mvnd-1.0.3/bin/mvnd.cmd -pl shadow-entity-demo package -o -DskipTests

# 3) 启动（需要本机 MySQL localhost:3306，ddl-auto=update 会自动建表）
java -jar shadow-entity-demo/target/shadow-entity-demo-1.0.0.jar
```

## 运行期真值（先跑一遍，确认影子类生效）

| 端点 | 读到什么 | 期望 |
|---|---|---|
| `GET /shadow/entity` | 运行期 `WmsTask.class` 的 `@Table` 表名 + code source 路径 | `tableName = wms_task_project`，`codeSource` 指向本模块 `target/classes`（而非依赖 JAR） |
| `GET /shadow/columns` | `information_schema` 里 `wms_task_project` 的列清单 | `id / task_no / status / task_type / remark` |
| `GET /shadow/columns?table=wms_task_jar` | JAR 版的表 | **空**——JAR 版表运行期不会被创建（影子类生效的反证） |
| `GET /shadow/hql?mode=jar-dao` | 真跑 JAR 内 DAO 方法 | `rowCount = 1`（SQL 打的是 `wms_task_project`） |
| `GET /shadow/hql?mode=jar-service` | 真跑 JAR 内 service 方法 | 同上 |
| `GET /shadow/hql?mode=host-service` | 真跑工程内调用方 | 同上 |

三个 `mode` 都返回 1 行，即运行期实体解析到影子版——这就是插件预览**应当**渲染出的那一版。

## 走查前必做：让依赖真的以 JAR 形态出现（否则本用例形同虚设）

与 `jpa-jar-model-lib` 同一类坑：IDEA 的 Maven workspace 解析只要发现 `shadow-entity-lib`
在同一个工程里，就会把 `shadow-entity-demo` 的依赖替换成兄弟模块的 `target/classes`（**目录形态**）。

> **20261023 更新（推荐走形态三）**：本模块依赖已改为 **system scope 指向
> `src/main/resources/lib/shadow-entity-lib-1.0.0.jar`**（本地 JAR 文件），不再走兄弟模块依赖。
> 这是最干净的「非依赖场景」：该 JAR 在 IDE 里**只以 Library 出现**，与聚合工程里有哪些模块无关。
> 下面形态一 / 形态二的 Maven Unload 前置条件因此**可以跳过**。

**重要**：workspace 目录形态**不是**「缺陷消失」，而是**换成了另一种缺陷**（20261023 用户实测）——
此时宿主 DAO 属于 lib 模块内容、实体只在下游 demo 模块，依赖方向 demo→lib ⇒ lib 侧解析不到实体
⇒ **零候选** ⇒ 同样降级为 `task.*`。该形态已由插件侧 W3「零候选拓宽」修复（`91400a3e`）。

自查方法：在 IDEA 里看 `WmsTaskJarDao` / `WmsTaskJarService` 打开的是哪个文件——
路径指向 `shadow-entity-lib/target/classes` 或兄弟模块 `src/main/java` 就是目录形态；
指向 `shadow-entity-demo/src/main/resources/lib/shadow-entity-lib-1.0.0.jar`（或 `target/classes/lib/`
的拷贝）才是形态三；指向 `~/.m2` 里的 `-sources.jar` 则是形态一。

## 走查：三种 jar 形态都要测

用户明确要求各种 jar 形态都能正常识别。

### 形态三：本地 JAR 文件（推荐，非依赖场景）

依赖声明为 system scope，jar 文件在 `src/main/resources/lib/`：

```xml
<dependency>
    <groupId>cn.song</groupId><artifactId>shadow-entity-lib</artifactId><version>1.0.0</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/src/main/resources/lib/shadow-entity-lib-1.0.0.jar</systemPath>
</dependency>
```

操作：

1. Maven 面板 **Reload All Maven Projects**（让 IDEA 重新解析出这个 Library）；
2. **可选但更纯粹**：Maven 面板对 `shadow-entity-lib` 执行 **Unload Projects**——本模块不再需要它，
   工程里只剩一个 Library 条目；
3. 在 **External Libraries** 里展开 `shadow-entity-lib-1.0.0.jar`（或它旁边的 sources jar），
   双击 `WmsTaskJarService`，光标放到 `beAllocateSuccess` 里的 `commonDao.findByQuery(...)` 调用行；
4. 看预览产物的表名与列清单。

> 想更新这个本地 JAR（例如改了 `shadow-entity-lib` 的源码）：
> `mvnd.cmd -pl shadow-entity-lib -DskipTests install`，然后把 `shadow-entity-lib/target/` 下新的
> `shadow-entity-lib-1.0.0.jar` 与 `-sources.jar` 覆盖到本模块 `src/main/resources/lib/`。

### 形态一：sources jar 附加（走兄弟模块依赖时）

`shadow-entity-lib` 已配 `maven-source-plugin`，`install` 后 `~/.m2` 里同时有
`shadow-entity-lib-1.0.0.jar` 与 `shadow-entity-lib-1.0.0-sources.jar`；IDEA 会自动挂上源码。

操作：

1. 在 IDE 里 **Project 视图 / External Libraries** 展开依赖 `shadow-entity-lib-1.0.0.jar`，
   双击 `WmsTask`（JAR 版实体）或 `WmsTaskJarDao` / `WmsTaskJarService`，打开的是 **`.java` 源码**；
2. 光标放到 `WmsTaskJarDao#findByStatusAndType`（或 `WmsTaskJarService#beAllocateSuccess`）方法体里
   那行 `commonDao.findByQuery(hql, ...)` 调用上——调用行应亮 1 枚预览图标（gutter），
   或就地按快捷键预览；
3. 看预览产物里的表名与列清单。

### 形态二：无源码反编译视图

要让 IDE **只挂 class、不挂 sources**，任选一种：

- **A（推荐）**：File → Project Structure → Libraries，找到 `Maven: cn.song:shadow-entity-lib:1.0.0`，
  删掉其中的 `shadow-entity-lib-1.0.0-sources.jar` 条目（只留主 JAR），Apply；若源码仍被缓存，
  右键该 jar → Detach Sources / 或 File → Invalidate Caches 后重启；
- **B**：先把本地仓库里**已装的** sources jar 删掉——
  `rm ~/.m2/repository/cn/song/shadow-entity-lib/1.0.0/shadow-entity-lib-1.0.0-sources.jar`
  （只加构建开关不够：开关只让本次构建不再产出，不会清掉上次装进去的），
  再用 `mvnd.cmd -pl shadow-entity-lib install -o -DskipTests -Dmaven.source.skip=true` 重装
  （已实测该开关会打印 `Skipping source per configuration.` 且不再产出 sources jar），
  最后在 Maven 面板 Reload All Maven Projects；
- **C**：等价于 B 的删文件那一步（删 `~/.m2` 里的 sources jar）后 Reload，不改构建开关也行。

操作：同样双击 JAR 里的 `WmsTask` / `WmsTaskJarDao`，这次打开的是 **反编译视图**
（编辑器顶部有 `/* decompiled ... */` 提示，或标为 decompiled）；在该视图里把光标放到
`commonDao.findByQuery(...)` 调用行，看图标是否出现、预览产物是否与形态一一致。

> 反编译视图下的 PSI 来自平台的 mirror（`ClsFileImpl.getMirror()` 经
> `PsiFileFactory.createFileFromText` 造出的真 Java PSI），宿主元素同样不在 content 里 ⇒
> **两种形态落在同一条降级链上**，这正是本用例要覆盖的第二形态。

### 三种形态的预期读数

| 形态 | 修复前 | 修复后（预期正确） |
|---|---|---|
| 形态三 本地 JAR 文件 | `select task.* /* 实体不可解析，降级为 task.* */` + `from unknown_table task` | `select task.id, task.task_no, task.status, task.task_type, task.remark from wms_task_project task where ...` |
| 形态一 sources jar 附加 | 同上（并弹一次实体名歧义气球，候选清单出现两条相同 FQN） | 同上 |
| 形态二 无源码反编译视图 | 同上 | 同上 |

三种形态的**目标读数一致**：表名 `wms_task_project`、列清单含 `task_type` 与 `remark`。
若渲染成 `wms_task_jar` + `type`（无 `remark`），说明取的是 JAR 版——同样是错的（运行期生效的是影子版）。

对照组的读数：`ShadowTaskQueryService#findByStatusAndType`（工程内容里的调用点）**各种形态下都**应
正常渲染 `wms_task_project`，即「工程内宿主不复现」。

## 与其它模块的关系

本模块与 `jpa-jar-model-demo` 都属「实体在依赖 JAR 里」的形态，但复现的是**两类不同的缺陷**：

| | jpa-jar-model-demo | 本模块 |
|---|---|---|
| JAR 里有什么 | 实体 / 嵌入类 / 仓库接口 | 实体 + **自定义 DAO + HQL 方法体** |
| 宿主里有什么 | 只有调用方（无实体源码） | 调用方 + **同 FQN 的影子实体源码** |
| 复现的缺陷 | 嵌入列名丢前缀（拿不到模块根 → 命名策略退到工程级信号） | **实体不可解析，降级为 `task.*`**（同 FQN 双份不被消解） |

本模块自带 `application.yml`，只作用于自己；不使用 `component-path` 命名策略（那是另一用例的变量），
表名列名全部由实体上的 `@Table` / `@Column` 显式给出，避免引入无关变量。

## 已实测（2026-10-22）与未实测

**已实测**（本机 mvnd，JDK 1.8）：

```text
mvnd -pl shadow-entity-lib,shadow-entity-demo -o -DskipTests install  → BUILD SUCCESS
```

产物：`shadow-entity-lib/target/shadow-entity-lib-1.0.0.jar` + `-sources.jar`，
`shadow-entity-demo/target/shadow-entity-demo-1.0.0.jar`。
**未实测**：未启动应用（未连本地 MySQL）、未在 runIde 沙盒里走查两种 jar 形态、未核对
`/shadow/*` 端点读数与插件预览产物——这几项留给真机走查，读数按上面两张表登记。
