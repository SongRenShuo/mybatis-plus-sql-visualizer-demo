# shadow-entity-lib — 「DAO/HQL/实体都在 JAR 里」的 JAR 态语料

> 非 Boot 应用的普通 JAR（`packaging=jar`），不单独运行，只被 `shadow-entity-demo` 以依赖形式引入。

## 它存在的唯一理由

用户报障形态：**HQL、执行 HQL 的 DAO 方法、以及 HQL 引用的实体类三者都在依赖 JAR 里**，
而工程（项目源码）里后来新增了一份**同包同名、字段有差异**的「影子类」。此时插件拿不到实体所在的
模块上下文（平台语义：库文件的 `ProjectFileIndex.getModuleForFile` 恒为 null），同 FQN 的两份
候选不被消解，实体解析退化成「两个候选 → 都不选 → 降级」，预览产出
`SELECT task.* /* 实体不可解析，降级为 task.* */`。

本模块就是那份「JAR 态语料」：把复现所需的实体、DAO、带 HQL 字面量的方法体全部打包进 JAR，
并**刻意配了 `-sources.jar` 打包**（「sources jar 附加」走查形态要用它）。

| 类 | 包 | 角色 |
|---|---|---|
| `WmsTask` | `com.example.shadow.model` | **JAR 版实体**，`@Entity` + `@Table(name = "wms_task_jar")`；列 `id` / `task_no` / `status` / `type` |
| `CommonDao` | `com.example.shadow.dao` | 老式自定义 DAO 接口：`<T> List<T> findByQuery(String hql, String[] paramNames, Object[] values)`（双数组传参，报障同款签名） |
| `CommonDaoImpl` | `com.example.shadow.dao.impl` | `CommonDao` 的 EntityManager 实现（运行期由宿主扫描装配） |
| `WmsTaskJarDao` | `com.example.shadow.dao` | **JAR 内 DAO 类**：方法体内含 HQL 字面量（缺陷触发点之一） |
| `WmsTaskJarService` | `com.example.shadow.service` | **JAR 内 service 类**：`beAllocateSuccess` 报障同款形态（缺陷触发点之二） |

`WmsTask` 与宿主里的影子类**同包同名**——两者各自编各自的 JAR/模块，互不引用。

## 构建与安装

```bash
# 仓库根目录
D:/HuanJing/Maven/maven-mvnd-1.0.3/bin/mvnd.cmd -pl shadow-entity-lib install -o -DskipTests
```

`shadow-entity-demo` **单模块**构建/启动前必须先装本模块（依赖要落到本地 `~/.m2`）；
以仓库根做聚合构建（`-pl shadow-entity-demo -am`）时 Maven 会按依赖顺序自动先建它。

## 产物

`target/` 下会同时出现两个 JAR——「sources jar 附加」形态靠的就是第二个：

| 文件 | 用途 |
|---|---|
| `shadow-entity-lib-1.0.0.jar` | 主 JAR（`.class` + 注解）——「反编译视图」形态看它 |
| `shadow-entity-lib-1.0.0-sources.jar` | 源码 JAR（`maven-source-plugin` 的 `jar-no-fork`）——「sources jar 附加」形态看它 |

要**刻意不产出** sources jar（做第二形态走查）时，加一个开关即可：

```bash
mvnd.cmd -pl shadow-entity-lib install -o -DskipTests -Dmaven.source.skip=true
```

实测该开关会打印 `Skipping source per configuration.` 且不再产出 sources jar；
但它**只让本次构建不再产出**，不会清掉上次已装进 `~/.m2` 的 sources jar——
走查第二形态（无源码）时要把
`~/.m2/repository/cn/song/shadow-entity-lib/1.0.0/shadow-entity-lib-1.0.0-sources.jar` 一并删掉再让 IDE 重新解析，
具体步骤见 [`shadow-entity-demo/README.md`](../shadow-entity-demo/README.md) 的「形态二」。

## 走查「宿主真的在 JAR 内」档位的必要条件（重要）

与 `selfdev-shared-lib` / `jpa-jar-model-lib` 同一类坑：IDEA 的 Maven workspace 解析只要发现本模块
在同一个工程里，就会把 `shadow-entity-demo` 的依赖替换成兄弟模块的 `target/classes`（**目录形态**）。
**目录形态下本用例复现不出缺陷**——DAO 与 HQL 成了「模块内容」，平台拿得到模块上下文，同 FQN
双份按 classpath 序正常消解。走查前必须先让依赖以真 JAR 形态出现：

1. 根目录 `mvnd install -pl shadow-entity-lib` 一次 → IDEA 的 Maven 面板对本模块执行
   **Unload Projects**（依赖随即回落到本地仓库的 JAR），走查完再重新 Load；
2. 或不以聚合形式打开：单独以 `shadow-entity-demo/pom.xml` 打开工程。

## 边界

- 不引 Hibernate / Spring 的实现依赖：`spring-boot-starter-data-jpa` 声明为 `provided`，
  本 JAR 只承载模型类、DAO 类与带 HQL 的方法体，运行期实现由宿主工程提供。
- 不声明 `META-INF/persistence.xml`：宿主是 Spring Boot JPA 引导，多一份 persistence.xml
  会改变持久化单元的装配路径（属于额外变量，不是本用例要复现的形态）。
- **不建 `wms_task_jar` 表**：同 FQN 的类以工程输出（`target/classes`）为准，本 JAR 里的实体
  运行期不生效；这张表是否存在，本身就是「影子类生效」的证据（见宿主模块 README）。
