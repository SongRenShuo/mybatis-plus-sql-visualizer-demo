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

## 「lib 自带 resources 但无命名配置」档位（T-EmbeddedHostCascade，20261026 新增）

`src/main/resources/META-INF/jpa-jar-model-lib.properties` 是本模块 20261026 新增的**普通资源文件**
（真实 lib 常带 META-INF/mapper 等资源，但没有任何命名策略配置）。它把本模块从「无 resources 目录」
变成「有 resources、扫不到命名配置」——这正是插件嵌入列命名判定的第三档形态：

| 实体锚点形态 | 插件判定路径 | 结果 |
|---|---|---|
| JAR 态（依赖取 `~/.m2` JAR，锚点为 jar 条目） | 模块根不可知 → 工程级信号 | 宿主 `application.yml` 的 component-path 命中 |
| workspace 代换态（依赖替换为本模块目录，**无 resources**） | 模块无 resources → 回落工程级信号 | 同上命中 |
| **workspace 代换态 + 本模块有 resources（本档）** | 实体模块扫描 → 判不出 → **级联到查询宿主模块** | 宿主 component-path 命中（来源标签 `probe-hit-host`） |

第三档在 20261026 之前的版本会判成无前缀（`base_qty`），真库是 `qty_base_qty`。插件修复后按
「实体所在模块 → 查询宿主模块」级联（两档都判不出仍不回工程级扫描，多模块聚合根防兄弟配置外溢的
契约不变）。

### 本档走查步骤

1. 插件侧用含 T-EmbeddedHostCascade 修复的构建（master `b3970e1f`+）。
2. 保持默认 workspace 形态（无需 Unload Projects）——锚点为本模块源码/目录。
3. 在 `jpa-jar-model-demo` 的 `WmsInventoryJarQueryService#findAvailableJarInventory`（或
   `findAvailableJarInventoryByBuffer`）点预览图标。
4. 预期 SQL 嵌入列带前缀：`qty_base_qty` / `sku_inventory_status` / `item_key_lot_info_received_date`，
   表名 `wms_inventory_jar_demo`。
5. IDE 日志过滤 `[T-EmbeddedIdentify]`：应见
   `entity=WmsInventoryEntity field=qty naming=COMPONENT_PATH/probe-hit-host columns=[baseQty→qty_base_qty]`
   ——`probe-hit-host` 即宿主级联生效的直接证据；若显示 `probe-miss` 则命名档判定失败。

注意：改动了本模块 resources 后，若走 JAR 态走查需重新 `mvnd install` 让资源进 JAR；
workspace 代换态（默认）直接生效。
