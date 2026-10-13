# jpa-embedded-prefix-demo — `@Embedded` 嵌入列前缀复现用例

> 端口 **8087** / 库 **jpa_demo**（与其它模块共用，表名独立：`wms_inventory_embed_demo`）
> Spring Boot 2.6.3 + Spring Data JPA（Hibernate 5.6）

## 这个模块复现什么

用户报障：实体里 `@Embedded` 嵌入对象的字段，插件把预览列名渲染成 `inv.base_qty`，
而**真库列是 `qty_base_qty`**——丢的是嵌入对象那一段前缀（`inv.moveTool.palletNo` 同款）。

触发条件有三个，本模块把三个条件**同时**备齐，所以能稳定复现：

1. 实体用 `@Embedded` 引嵌入对象（`WmsInventoryEntity.moveTool` / `.qty`）；
2. 嵌入对象内部字段上**没有** `@Column` / `@AttributeOverride`（列名只能由命名策略推导）；
3. 工程的 Hibernate 隐式命名策略是**组件路径**（`component-path`，见 `application.yml`）——
   策略把属性路径并进列名：`qty.baseQty` → `qty_base_qty`、`moveTool.palletNo` → `move_tool_pallet_no`。

`implicit_naming_strategy: component-path` 是 Hibernate 官方注册的短名
（`StrategySelectorBuilder` 注册 → `ImplicitNamingStrategyComponentPathImpl`，
Hibernate 4 的 `DefaultComponentSafeNamingStrategy` 是其前身，语义一致）。

> 与 `jpa-hibernate-demo` 的区别是**故意**的：那边走 JPA 默认「无前缀」
> （`updateInfo.createdTime` → `created_time`）。两个模块共存，正好用来验证插件的
> 嵌入列命名探测是**按实体所在模块**取配置、兄弟模块之间互不外溢。

## 跑起来

```bash
# 本机无独立 maven，用 mvnd（多模块构建；-o 离线走 ~/.m2）
D:/HuanJing/Maven/maven-mvnd-1.0.3/bin/mvnd.cmd -q -pl jpa-embedded-prefix-demo -am compile -o -DskipTests

# 启动（需要本机 MySQL localhost:3306，ddl-auto=update 会自动建表/补列）
D:/HuanJing/Maven/maven-mvnd-1.0.3/bin/mvnd.cmd -pl jpa-embedded-prefix-demo spring-boot:run -o
```

## 验收清单

1. `GET http://localhost:8087/embed-prefix/naming` → `implicitNamingStrategy = component-path`。
2. `GET http://localhost:8087/embed-prefix/columns` → 列清单里应出现
   **`qty_base_qty`** 与 **`move_tool_pallet_no`**（这是真库真值，也是插件预览应该渲染出的名字）。
3. `GET http://localhost:8087/embed-prefix/query` → 返回 1 行（W01/P001，`baseQty=120`）；
   另一条 seed 数据 `baseQty=0` 被 HQL 的 `inv.qty.baseQty > 0` 过滤掉，符合预期。
   `?mode=buffer` 走 StringBuffer 承载形态，结果同上。
4. **插件侧**：在 IDE 里打开本模块工程，三个方法里的 `commonDao.findByQueryMaxNum(...)` 调用
   **都应各亮 1 枚预览图标**（本模块刻意备齐三种 HQL 承载形态）：
   - `findAvailableInventory`——拼接变量（`String hql = "…" + "…"`）；
   - `findAvailableInventoryByBuffer`——StringBuffer + `sb.toString()`；
   - `findAvailableInventoryViaHelper`——**方法返回**（`buildAvailableInventoryHql()`）。

   预览产物应含 `inv.move_tool_pallet_no` 与 `inv.qty_base_qty`。
   - 若渲染成 `inv.pallet_no` / `inv.base_qty`，即复现了报障缺陷；
   - 插件侧的嵌入列命名档位见 设置 → 表名映射 → **嵌入列命名**（自动 / 无前缀 / 组件路径前缀），
     本模块在「自动」下应由配置探测命中；探测不到时手动切「组件路径前缀」应等价修复。

> 第三种形态（方法返回）是**用户报障点**，现已是插件能力：首参写成方法调用时，插件会跟随到
> 那个**源码可见**的方法、聚合其 `return` 表达式（T-HqlHelperReturn，深度上限 3 层、多分支返回
> 内容不一致时不猜、返回非 String 不认领）。插件仓门禁 `DemoEmbeddedPrefixReproAnchorTest`
> 加载本文件并断言「3 个调用各恰 1 枚图标」，另有「返回非 String → 0 图标」的反向断言。
> 复现这段历史：本用例第一版把 HQL 抽进方法，**当时**插件不认该形态 → 图标与快捷键预览同时失效
> （用户真机实测报障），随后才补上这条能力。

> 打开方式建议：**以本模块目录为工程打开**。以仓库聚合根打开时，插件按实体所在模块取配置，
> 行为同样正确，但本模块的 `component-path` 不应影响同仓其它模块的嵌入列命名。

## 已实测（2026-10-13）

```text
mvnd -q -pl jpa-embedded-prefix-demo package -o -DskipTests   → 通过，产物 target/*.jar
java -jar target/jpa-embedded-prefix-demo-1.0.0.jar           → 启动成功（8087）
```

启动日志里 Hibernate 真建的表（`ddl-auto=update`）——**列名由命名策略推得，非人工指定**：

```sql
create table wms_inventory_embed_demo (
    id bigint not null auto_increment,
    move_tool_pallet_no varchar(255),
    qty_base_qty bigint,
    warehouse_id varchar(32),
    primary key (id)
) engine=InnoDB
```

端点真跑读数（三档承载形态都验过）：

```text
GET /embed-prefix/naming                     → {"implicitNamingStrategy":"component-path"}
GET /embed-prefix/columns                    → ["id","move_tool_pallet_no","qty_base_qty","warehouse_id"]
GET /embed-prefix/query                      → mode=plain ，rowCount=1
GET /embed-prefix/query?mode=buffer          → mode=buffer，rowCount=1
GET /embed-prefix/query?mode=helper          → mode=helper，rowCount=1
```

即：实体侧零注解，真库列名就是 `qty_base_qty` / `move_tool_pallet_no`——插件预览产物应以
这两个名字为准（渲染成 `base_qty` / `pallet_no` 即缺陷复现）。

> 踩过的坑（已修，记录备查）：演示数据 seed 最初写成启动类里的 `@Bean CommandLineRunner` +
> `@Transactional`——事务对 lambda 不生效，`persist` 抛 `TransactionRequiredException` 直接启动失败。
> 现独立成 `config/DemoDataSeeder`（`@Component`，`@Transactional` 挂在其 `run` 方法上）才真正生效。

## 与其它模块的关系

本模块**不改动**任何既有模块的实体、配置或数据库表：命名策略是每个持久化单元（模块）各自的事，
本模块自带的 `application.yml` 只作用于自己。新增它的原因是：复现上述第 3 个条件必须让 Hibernate
真的按组件路径命名，而把该策略加到 `jpa-hibernate-demo` 会改变那边既有嵌入语料
（`updateInfo.createdTime` → `created_time`）的前提，属于破坏性改动。
