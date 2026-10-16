# jpa-jar-model-demo — 实体/嵌入类来自依赖 JAR 的嵌入列命名复现用例

> 端口 **8088** / 库 **jpa_demo**（与其它模块共用，表名独立：`wms_inventory_jar_demo`）
> Spring Boot 2.6.3 + Spring Data JPA（Hibernate 5.6.4）
> 实体、嵌入类、仓库接口全部在依赖 JAR [`jpa-jar-model-lib`](../jpa-jar-model-lib) 里，**本模块源码树没有它们**。

## 这个模块复现什么

用户工程的 `@Entity` / `@Embeddable` 都在依赖 JAR 里（无源码）。HQL 里
`inv.qty.baseQty` / `inv.sku.inventoryStatus` / `inv.itemKey.lotInfo.receivedDate`
这类嵌入段路径，插件预览列名**丢了嵌入段前缀**，而真库列名是组件路径命名策略
（`component-path`）的产物。

与同仓 [`jpa-embedded-prefix-demo`](../jpa-embedded-prefix-demo) 的差别在于**变量多了一层**：

| | jpa-embedded-prefix-demo | 本模块 |
|---|---|---|
| 实体源码 | 在模块里 | **在依赖 JAR 里** |
| 嵌入层级 | 一层（`qty.baseQty`） | 一层 + **二层嵌套**（`itemKey.lotInfo.receivedDate`） |
| 命名约定读得到吗 | 实体所在模块 = 本模块，配置可读 | 模块根不可知，只能退到**工程级信号** |

所以本模块是插件「实体来自 JAR 时退到工程级信号判命名约定」那条退路的验收宿主。三条工程级信号
本模块都真实存在：

1. `application.yml` 里的设置键 `spring.jpa.properties.hibernate.implicit_naming_strategy`（**当前生效**）；
2. 同一设置键的 Java 代码式配置形态（`config/CodeBasedNamingStrategyConfig`，profile 切换）；
3. Java 源码里出现类名 `ImplicitNamingStrategyComponentPathImpl`（就在上面那个 config 类里，
   无论 profile 是否激活，类名都在源码中）。

触发缺陷的三个条件与本模块的对应：

1. 实体用 `@Embedded` 引嵌入对象（`qty` / `sku` / `itemKey`）；
2. 嵌入类内部字段**没有** `@Column` / `@AttributeOverride`（列名只能由策略推得）；
3. 工程的隐式命名策略是 `component-path`（Hibernate 官方注册短名，指向
   `ImplicitNamingStrategyComponentPathImpl`；Hibernate 4 的 `DefaultComponentSafeNamingStrategy`
   是其前身，语义一致）。

## 两份命名配置，当前哪条生效、怎么切

两条路**同一模块内只能生效一条**，默认生效的是形态 A（yml）。

| 形态 | 落点 | 默认 | 怎么切过去 |
|---|---|---|---|
| A：设置键写短名 | `src/main/resources/application.yml` → `spring.jpa.properties.hibernate.implicit_naming_strategy: component-path` | **生效** | — |
| B：Java 代码式 | `src/main/java/cn/song/jarmodeldemo/config/CodeBasedNamingStrategyConfig.java`（`@Profile("code-naming")` + `HibernatePropertiesCustomizer`，`props.put(..., ImplicitNamingStrategyComponentPathImpl.class)`） | 不装配 | ① 把 yml 里那行注释掉；② 启动加 `--spring.profiles.active=code-naming` |

切换时**务必两步都做**：`HibernatePropertiesCustomizer` 在 yml 属性之后应用、会覆盖同名键，
两条同时在场时行为虽然等价（同一个实现类），但「哪条生效」就不可判读了，别留下这种状态。
`GET /jar-model/naming` 会回显生效值来自哪条（见验收清单第 3 条）。

## 跑起来

```bash
# 1) 先装 JAR 态语料（单模块构建/启动必须；聚合构建 -am 会自动带上）
D:/HuanJing/Maven/maven-mvnd-1.0.3/bin/mvnd.cmd -pl jpa-jar-model-lib install -o -DskipTests

# 2) 打包宿主（-o 离线走 ~/.m2）
D:/HuanJing/Maven/maven-mvnd-1.0.3/bin/mvnd.cmd -pl jpa-jar-model-demo package -o -DskipTests

# 3) 启动（需要本机 MySQL localhost:3306，ddl-auto=update 会自动建表/补列）
java -jar jpa-jar-model-demo/target/jpa-jar-model-demo-1.0.0.jar
#    切到代码式配置形态 B：
java -jar jpa-jar-model-demo/target/jpa-jar-model-demo-1.0.0.jar --spring.profiles.active=code-naming
```

## 验收清单

1. `GET http://localhost:8088/jar-model/columns` → 列清单里应出现
   `qty_base_qty`、`sku_inventory_status`、`item_key_lot_info_received_date`
   （真库真值，也是插件预览应该渲染出的名字）。
2. `GET http://localhost:8088/jar-model/query` → 返回 1 行（W01/IN_STOCK，`baseQty=120`）；
   seed 里 `baseQty=0` 那条被 HQL 的 `inv.qty.baseQty > 0` 过滤掉，符合预期。
   `?mode=buffer` 走 StringBuffer 承载形态，结果同上。
3. `GET http://localhost:8088/jar-model/naming` → 回显命名策略来源：
   - 形态 A 生效：`valueType = java.lang.String`（值来自 yml 的短名）；
   - 形态 B 生效：`valueType = java.lang.Class`（值来自 `HibernatePropertiesCustomizer`）。
4. **插件侧**：在 IDE 里打开本模块工程，`WmsInventoryJarQueryService` 两个方法里的
   `wmsJarCommonDao.findByQueryMaxNum(...)` 调用**各应亮 1 枚预览图标**：
   - `findAvailableJarInventory`——拼接变量（`String hql = "…" + "…"`）；
   - `findAvailableJarInventoryByBuffer`——StringBuffer + `sb.toString()`。

   预览产物应含 `inv.qty_base_qty`、`inv.sku_inventory_status`、
   `inv.item_key_lot_info_received_date`。渲染成 `inv.base_qty` / `inv.inventory_status` /
   `inv.received_date`（丢前缀）即复现了报障缺陷。

## 关于第三条列名（重要，与任务书原文有出入）

任务背景里把三条真库列名写成 `qty_base_qty` / `sku_inventory_status` / `lot_info_received_date`。
**实测第三条是 `item_key_lot_info_received_date`**，不是 `lot_info_received_date`。

原因在 Hibernate 5.6.4 源码里可以逐行核对：

- `BinderHelper.getRelativePath(propertyHolder, propertyName)` 给出的是**相对实体根的完整属性链**
  （`itemKey.lotInfo.receivedDate`），不是只有最内层那段；
- `ImplicitNamingStrategyComponentPathImpl.process()` 递归到 `parent` 并用 `_` 连接，**每一段都进列名**。

所以 `qty.baseQty` → `qty_base_qty`、`sku.inventoryStatus` → `sku_inventory_status` 是二段路径的结果，
而三层路径 `itemKey.lotInfo.receivedDate` 必然带出 `item_key_` 段。
`lot_info_received_date` 恰好是 `item_key_lot_info_received_date` 的**后缀子串**——按子串匹配能过，
按整列名精确匹配过不了。若确实需要列名恰为 `lot_info_received_date`，把实体第三嵌入字段改名为
`lotInfo`（即路径退成两段 `lotInfo.receivedDate`）即可；本模块按任务书的结构描述实现（三个
`@Embedded` 名为 `qty` / `sku` / `itemKey`，`WmsItemKey` 内含静态嵌套 `LotInfo`），未做该改动。

## 已实测（2026-10-16）

构建：

```text
mvnd -pl jpa-jar-model-lib install -o -DskipTests   → BUILD SUCCESS
mvnd -pl jpa-jar-model-demo package -o -DskipTests  → BUILD SUCCESS，产物 target/jpa-jar-model-demo-1.0.0.jar
java -jar target/jpa-jar-model-demo-1.0.0.jar        → 启动成功（Tomcat 8088）
```

启动日志里 Hibernate 真建的表（`ddl-auto=update`）——列名由命名策略推得，非人工指定：

```sql
create table wms_inventory_jar_demo (
   id bigint not null auto_increment,
    item_key_lot_info_received_date datetime(6),
    qty_base_qty bigint,
    sku_inventory_status varchar(255),
    warehouse_id varchar(32),
    primary key (id)
) engine=InnoDB
```

Hibernate 真跑的查询（证明列名在 SQL 层就带前缀）：

```sql
select
    wmsinvento0_.id as id1_0_,
    wmsinvento0_.item_key_lot_info_received_date as item_key2_0_,
    wmsinvento0_.qty_base_qty as qty_base3_0_,
    wmsinvento0_.sku_inventory_status as sku_inve4_0_,
    wmsinvento0_.warehouse_id as warehous5_0_
from wms_inventory_jar_demo wmsinvento0_ order by wmsinvento0_.id
```

端点真跑读数（形态 A，yml 生效）：

```text
GET /jar-model/naming  → {"activeProfiles":[],"codeNamingProfileActive":false,
                          "ymlProperty":"component-path","hibernateProperty":"component-path",
                          "valueType":"java.lang.String"}
GET /jar-model/columns → {"table":"wms_inventory_jar_demo",
                          "columns":["id","item_key_lot_info_received_date","qty_base_qty","sku_inventory_status","warehouse_id"]}
GET /jar-model/query          → mode=plain，rowCount=1
GET /jar-model/query?mode=buffer → mode=buffer，rowCount=1
```

形态 B 真跑读数（`--spring.profiles.active=code-naming`，yml 那行仍在场，customizer 覆盖之）：

```text
GET /jar-model/naming  → {"activeProfiles":["code-naming"],"codeNamingProfileActive":true,
                          "ymlProperty":"component-path",
                          "hibernateProperty":"class org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl",
                          "valueType":"java.lang.Class"}
GET /jar-model/columns → 同上，列名一致
GET /jar-model/query   → mode=plain，rowCount=1
```

即：实体侧零注解、且实体源码不在宿主模块，真库列名仍由工程级配置推得带前缀的名字——
插件预览产物应以这三个名字为准。

## 与其它模块的关系

本模块**不改动**任何既有模块的实体、配置或数据库表：命名策略是每个持久化单元（模块）各自的事，
本模块自带的 `application.yml` 只作用于自己。与 `jpa-embedded-prefix-demo` 的分工是：那边证
「一层嵌入 + 配置可读」，这边证「实体在 JAR 里 + 二层嵌套 + 只能靠工程级信号」。

## 待验证前提（实施前未证、实测后已落实）

- ~~三层路径 `itemKey.lotInfo.receivedDate` 的 component-path 产物是否只有两段前缀~~
  → 实测为三段前缀 `item_key_lot_info_received_date`（见上）。
- ~~`@EntityScan` / `@EnableJpaRepositories` 指向 JAR 包时 JAR 里的实体能否被正常登记~~
  → 实测可以：建表、seed、查询全部正常。
