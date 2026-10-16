# jpa-jar-model-lib — 「实体/嵌入类来自依赖 JAR」的 JAR 态语料

> 非 Boot 应用的普通 JAR（`packaging=jar`），不单独运行，只被 `jpa-jar-model-demo` 以依赖形式引入。

## 它存在的唯一理由

真实用户工程里，`@Entity` / `@Embeddable` 常常在公司的公共领域模型库里（以 JAR 出现在
classpath 上），业务工程只有调用方代码、没有实体源码。插件这时**拿不到实体所在的模块根**
（读不到那个模块自己的 `application.yml`），也就没法按「实体所在模块的配置」判嵌入列命名约定
——只能退到工程级信号（宿主工程的 `application.yml` / 任意文件里的 `implicit_naming_strategy`
设置键 / Java 源码里出现的 `ImplicitNamingStrategyComponentPathImpl`、
`DefaultComponentSafeNamingStrategy` 类名）。

本模块就是那份「JAR 态语料」：把复现所需的实体、嵌入类、Spring Data 仓库接口全部打包进 JAR。

| 类 | 包 | 角色 |
|---|---|---|
| `WmsInventoryEntity` | `cn.song.jarlib.entity` | `@Entity`，表 `wms_inventory_jar_demo`；三个 `@Embedded`（`qty` / `sku` / `itemKey`）+ 一个普通列 `warehouseId` |
| `WmsInventoryQty` | `cn.song.jarlib.entity` | `@Embeddable`，字段 `baseQty` |
| `WmsSku` | `cn.song.jarlib.entity` | `@Embeddable`，字段 `inventoryStatus` |
| `WmsItemKey` | `cn.song.jarlib.entity` | `@Embeddable`，内含 `@Embedded LotInfo lotInfo`；`WmsItemKey.LotInfo` 是**静态嵌套** `@Embeddable`，字段 `receivedDate` |
| `WmsInventoryJarRepository` | `cn.song.jarlib.repository` | Spring Data JPA 仓库（宿主 `@EnableJpaRepositories` 的扫描目标） |

**嵌入类内部一律不写 `@Column` / `@AttributeOverride`**——这是复现前提：列名只能由工程的
隐式命名策略推导，插件推错就露馅。

## 构建与安装

```bash
# 仓库根目录
D:/HuanJing/Maven/maven-mvnd-1.0.3/bin/mvnd.cmd -pl jpa-jar-model-lib install -o -DskipTests
```

`jpa-jar-model-demo` **单模块**构建/启动前必须先装本模块（依赖要落到本地 `~/.m2`）；
以仓库根做聚合构建（`-pl jpa-jar-model-demo -am`）时 Maven 会按依赖顺序自动先建它。

## 走查「实体源码不在宿主模块」档位的必要条件（重要）

与 `selfdev-shared-lib` 同一类坑：IDEA 的 Maven workspace 解析只要发现本模块在同一个工程里，
就会把 `jpa-jar-model-demo` 的依赖替换成兄弟模块的 `target/classes`（**目录形态**）。此时插件
仍可能顺着目录找到模块根，走查「模块根不可知」档位需二选一：

1. 根目录 `mvnd install` 一次 → IDEA 的 Maven 面板对本模块执行 **Unload Projects**
   （依赖随即回落到本地仓库的 JAR），走查完再重新 Load；
2. 或不用 IDEA 启动应用：`mvnd install -pl jpa-jar-model-lib` 后
   `mvnd -pl jpa-jar-model-demo spring-boot:run -o`（单模块 reactor ⇒ 依赖取本地仓库 JAR）。

## 边界

- 不引 Hibernate / Spring 的实现依赖：`spring-boot-starter-data-jpa` 声明为 `provided`，
  本 JAR 只承载模型类与注解，运行期实现由宿主工程提供。
- 不声明 `META-INF/persistence.xml`：宿主是 Spring Boot JPA 引导，多一份 persistence.xml
  会改变持久化单元的装配路径（属于额外变量，不是本用例要复现的形态）。
