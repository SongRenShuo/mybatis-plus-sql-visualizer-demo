# mybatis-plus-sql-visualizer-demo

[Sql Visualizer](https://gitee.com/SongRenShuo/mybatis-plus-sql-visualizer) 插件的测试用例 Demo 集合项目。

本仓库双平台同步：**Gitee 是主仓**，**GitHub 是镜像**（[github.com/SongRenShuo/mybatis-plus-sql-visualizer-demo](https://github.com/SongRenShuo/mybatis-plus-sql-visualizer-demo)）。两边内容一致，克隆哪个都行；插件仓库的测试脚本默认按 Gitee 地址检出，换镜像时改 clone 命令即可。

这个仓库的用途是给插件测试当语料，不是教程或脚手架：每个子项目都刻意写成「插件应该识别、或曾经识别错」的形态，所以代码里会有一些看起来别扭的写法（比如手工拼接 SQL、把 Wrapper 拆到私有方法里续链）。这些是测试输入，不是推荐用法。

贡献说明与测试门槛见插件仓库的 [CONTRIBUTING.md](https://gitee.com/songrenshuo/mybatis-plus-sql-visualizer/blob/dev/CONTRIBUTING.md)。使用问题与功能建议请走[官网需求池](https://sql-visualizer.jvtools.cn/about/feedback)。

本仓库包含多个相互独立的 Spring Boot 子项目（Maven 多模块仓库，每个子项目可单独构建运行），
外加一个 JAR 态语料子工程（`selfdev-shared-lib`，非 Boot 应用），
覆盖插件支持的各 ORM 主题与 SQL 来源形态，为插件提供真实、丰富的 SQL 预览 / SQL 生成测试场景：

| 子项目 | 端口 / 数据库 | 主题 | 说明 |
|--------|------|------|------|
| [mybatis-plus-demo](mybatis-plus-demo) | 8081 / mp_demo | MyBatis-Plus 3.5.7 | `QueryWrapper` / `LambdaQueryWrapper` / `UpdateWrapper` / `LambdaUpdateWrapper`、`eqSql`/`inSql` 族、Wrappers 工厂 / Db kit / ActiveRecord、XML 动态 SQL、注解 SQL、分页、批量操作；`JdbcTemplate` / `NamedParameterJdbcTemplate` 字符串 SQL、自研 DAO 壳（`DbHelper` / `BeanCruder`） |
| [mybatis-plus-join-demo](mybatis-plus-join-demo) | 8082 / mpj_demo | MyBatis-Plus-Join（MP 3.5.2 + MPJ 1.5.8） | `MPJLambdaWrapper` 多表联查、聚合族、`selectCollection`、子查询条件族、`fill`、`updateJoin` / `deleteJoin`、`MPJQueryWrapper` 字符串链 |
| [jpa-hibernate-demo](jpa-hibernate-demo) | 8083 / jpa_demo | JPA + Hibernate（Spring Boot 2.6.3） | Spring Data JPA 派生查询、`@Query` JPQL、`CriteriaQuery`、Hibernate HQL、`HibernateTemplate` / `HibernateDaoSupport` 通用 DAO、hbm.xml 遗留实体、JPA 写路径（save / `@Modifying` / `CriteriaUpdate`·`Delete` / Specification / QBE / 锁读） |
| [jpa-embedded-prefix-demo](jpa-embedded-prefix-demo) | 8087 / jpa_demo | JPA + Hibernate（Spring Boot 2.6.3） | `@Embedded` 嵌入列前缀复现用例：命名策略取 Hibernate 组件路径（`component-path`），实体与 `@Embeddable` 上**不写** `@Column`/`@AttributeOverride`，故 `qty.baseQty` → 列 `qty_base_qty`、`moveTool.palletNo` → 列 `move_tool_pallet_no`；配 `CommonDao` 自定义 DAO 的拼接 HQL + 双数组传参调用（用户报障同款），用于验证插件预览列名与真库一致 |
| [mybatis-plus-kotlin-demo](mybatis-plus-kotlin-demo) | 8084 / kotlin_demo | MyBatis-Plus Kotlin（1.9.25 + MP 3.5.7） | `ktQuery()` / `ktUpdate()` 扩展链、Kotlin 直接构造 Wrapper（插件 KtWrapperDetector 语料） |
| [multi-orm-demo](multi-orm-demo) | 8085 / orm_demo | 其它 ORM 四家（插件 M44 识别器） | Querydsl（Q 类表达式树）、MyBatis Dynamic SQL（DSL 构建）、xbatis（Chain 链）、Easy-Query（proxy 链） |
| [selfdev-framework-demo](selfdev-framework-demo) | 8086 / selfdev_demo | 自研框架帧过滤前缀（设置项专用语料） | 模拟不经 MyBatis 的自研数据访问引擎（`com.corp.engine` / `com.corp.meta`），34 端点覆盖 12 种调用形态 × 4 类查询/写形态 × 3 档委托深度 × 2 种帧来源（目录/JAR），用于验证「源码捕获帧过滤前缀」登记前后的跳转落点差异 |
| [selfdev-shared-lib](selfdev-shared-lib) | — / —（非 Boot 应用） | 上面的 JAR 态语料 | 普通 JAR：`com.corp.platform.SqlKernel` + `com.corp.shared.util.PlanTreeQueryBuilder`，与 demo 侧目录态两个类逐行同构，唯一差异是「运行期来自依赖 JAR」——复现「SQL 执行点在 JAR 里的业务工具类 → 跳转上顶到调用方 Service」 |
| [jpa-jar-model-demo](jpa-jar-model-demo) | 8088 / jpa_demo | 实体/嵌入类来自依赖 JAR 的嵌入列命名复现 | 实体、`@Embeddable`、仓库接口全在依赖 JAR [`jpa-jar-model-lib`](jpa-jar-model-lib) 里，宿主模块**无实体源码**（模块根不可知，命名约定只能靠工程级信号：`application.yml` 设置键 / Java 源码里的 `ImplicitNamingStrategyComponentPathImpl` 类名）；三个 `@Embedded` 零注解 + 二层嵌套（`itemKey.lotInfo.receivedDate`），配自定义 DAO 的拼接 HQL 与 StringBuffer 两种承载形态 |
| [jpa-jar-model-lib](jpa-jar-model-lib) | — / —（非 Boot 应用） | 上面的 JAR 态语料 | 普通 JAR：`cn.song.jarlib.entity` 的 `WmsInventoryEntity` + `WmsInventoryQty`/`WmsSku`/`WmsItemKey`（内含静态嵌套 `LotInfo`）+ Spring Data 仓库接口，全部以依赖 JAR 形态加载，宿主无源码 |

## 环境要求

- JDK 1.8
- Maven 3.6+（或 mvnd）
- MySQL 5.7+ / 8.0（可选，仅运行需要；代码解析类测试不依赖数据库）

## 构建

```bash
# 多模块方式：根目录直接构建全部子项目（根 pom 为聚合 POM，各子项目相互独立，无父子继承关系）
mvn clean compile

# 单项目构建
cd mybatis-plus-demo && mvn clean compile
```

> 根目录 `pom.xml` 为**聚合 POM**（packaging=pom，仅含 `<modules>`），作用是让 IDEA 能以多模块形式打开整个目录、以及提供统一的构建入口。
> 各子项目是**独立 Maven 工程**：各自以 `spring-boot-starter-parent` 作为 parent，互不关联，也不继承根 pom 的任何依赖或属性。
>
> 例外：`selfdev-framework-demo` 以依赖形式引用 `selfdev-shared-lib`（E 组 JAR 态语料）。
> 根目录聚合构建会自动按依赖顺序先建后者；**单模块**构建 demo 前需先 `mvn install -pl selfdev-shared-lib`。

## 数据库初始化

运行（而非仅代码解析）时需要 MySQL，各子项目用独立库，建表脚本随仓库维护，与实体类逐列对齐：

| 数据库 | 脚本 | 初始化方式 |
|--------|------|------|
| mp_demo | `mybatis-plus-demo/src/main/resources/db/schema.sql` | 手工执行 |
| mpj_demo | `mybatis-plus-join-demo/src/main/resources/db/schema.sql` | 手工执行 |
| jpa_demo | `jpa-hibernate-demo/src/main/resources/db/schema.sql` | 手工执行 |
| kotlin_demo | `mybatis-plus-kotlin-demo/src/main/resources/db/schema.sql` | 手工执行 |
| orm_demo | `multi-orm-demo/src/main/resources/db/schema.sql` | 手工执行 |
| selfdev_demo | `selfdev-framework-demo/src/main/resources/db/schema.sql` | **自动**（`spring.sql.init`，每次启动重建） |

脚本可重复执行（自带 DROP TABLE），含初始化数据；实体新增表时须同步维护对应脚本。

> `selfdev-framework-demo` 以「起服务即可 curl」为目标启用了自动初始化，且显式声明 `spring.sql.init.encoding: UTF-8`——
> 不声明时按平台默认字符集读取脚本，Windows 下（GBK）会把脚本里的中文写成乱码。

## 目录结构约定（参考 easy-code-demo）

```
src/main/java/cn/song/<demo>/
├── config/       配置类（MyBatis-Plus 分页插件 / JPA 配置）
├── common/       通用类（统一返回、异常等）
├── entity/       实体类
├── mapper/       MyBatis-Plus Mapper 接口 / JPA Repository
├── service/      服务层（Service 接口 + impl 实现）
├── controller/   REST 控制器
└── utils/        工具类
src/main/resources/
├── application.yml / application-dev.yml
├── mapper/*.xml  MyBatis XML 动态 SQL
└── db/schema.sql 建表脚本
```

每个子项目的 `service` 实现类中集中编写了插件可识别的各种 Wrapper / Criteria / JPQL 调用链，
可直接在 IDEA 中打开项目并使用插件查看 SQL 预览效果。

`mybatis-plus-demo` 另含「自研框架字符串 SQL」场景（2026-09-06 新增，对齐用户真实项目反馈）：
`common/BeanCruder` / `common/BeanQuery`（模拟自研 DAO 层）+ `StringSqlDaoDemoServiceImpl`——

| 形态 | 方法 | 插件入口 |
|------|------|---------|
| 方法内拼接 SQL 变量 + `beanCruder.selectList(Class, sql, 名值对...)` | `getScheduleList` | `selectList` 调用行 / `getScheduleList` 方法定义名行 gutter，点击或快捷键（`Ctrl+Alt+S`）预览拼接展开 SQL（`:CUR_USER` 命名参数进参数面板） |
| 分页包装层（Class + sql + paramMap → PaginQuery → 委托） | `selectListPagination` | 方法定义名行 gutter / 方法体内快捷键 |
| 聚合统计 + `beanCruder.selectOne` | `selectOneSummary` | 同形态一 |

## 场景覆盖清单（2026-09-10 按插件 2026.9.9 能力重新对照）

以下为按插件覆盖矩阵逐项补齐的场景，新增代码集中在各模块 `WrapperFullCoverage*` / `WrapperFactoryCoverage*` / `MpjFullCoverage*` / `JpaFullCoverage*` 服务及其 Controller，均可在 IDEA 打开后直接用插件预览。

### mybatis-plus-demo（MP 3.5.7）

| 场景 | 位置 |
|------|------|
| likeLeft/notLike 族、notBetween、isNotNull、geSql/ltSql、func、apply 多占位、first/comment/last、or 嵌套、多列 groupBy/orderBy | `WrapperFullCoverageServiceImpl` |
| eqSql/inSql/notInSql 等 SQL 片段直拼（eqSql 需 MP ≥ 3.5.6）、allEq/not/nested/select 排除、链式、IService | `WrapperExtServiceImpl` |
| Wrappers 8 工厂形态、ChainWrappers 终结点（list/one/count/exists/page）、Db kit 静态 CRUD、SimpleQuery（keyMap/map/list）、ActiveRecord（Model） | `WrapperFactoryCoverageServiceImpl` |
| selectMapsPage/exists/deleteByMap/update(wrapper) 等 CRUD 补形态 | 同上 |
| **裸工厂链 + 带参 `exists` 子查询**（T-ExistsChainTerminal 复现用例）：裸工厂链 / 分页消费 / 变量声明对照 / `notExists` 对照四形态应产出同一份 SQL | `WrapperFactoryCoverageServiceImpl#listByBareFactoryChainExists`（`/config/factory/bareChainExists`） |
| JdbcTemplate / NamedParameterJdbcTemplate 字符串 SQL：位置参数、命名参数 `:name`、StringBuilder 动态拼接、IN 子句、多表 JOIN、三表聚合分页、EXISTS/IN 子查询 | `JdbcTemplateServiceImpl` |
| 自研 DAO 壳 `DbHelper` 的 queryForList/queryForMap/insert/update/delete/batchUpdate（Map 参数与变长实参双形态） | `WrappedJdbcServiceImpl` + `common/DbHelper` |
| @KeySequence/@EnumValue/@OrderBy 实体注解 | `SysConfig` / `ConfigTypeEnum` |
| `${ew.customSqlSegment}` 展开（含 join 场景）、foreach/where/having 动态 SQL | `OrderMapper.xml` + `OrderMapper` |
| choose/set/子查询+foreach | `DepartmentMapper.xml` |
| sql 片段 include 复用 + 批量 insert foreach | `RoleMapper.xml` |
| Provider 族注解 SQL | `UserMapper` + `UserSqlProvider` |
| 自研 maintainPage XML（`<pages><maintainPage>` + CDATA SQL + 列元数据） | `resources/pages/user-maintain.xml` |

> JdbcTemplate / 自研 DAO 字符串 SQL 对应插件 psource 系列（命名参数回填、StringBuilder append 分片聚合、DbHelper 专属识别）与 T-DaoSql（`beanCruder.selectList(Class, sql, ...)` 调用行图标 + 方法定义锚点）；运行期多行 JDBC 日志捕获（含 TLog 前缀）由 T-JdbcMultiline 覆盖。

> 版本说明（2026-09-07 升级勘误，经本地 jar javap 逐版核实）：`mybatis-plus-demo` 与 `mybatis-plus-kotlin-demo` 已升级 **MP 3.5.7**，`mybatis-plus-join-demo` 保留 **MP 3.5.2 + MPJ 1.5.8** 作为旧版本对照基线。3.5.4 相对 3.5.3.1 对本语料无增量；`eqSql`、`setIncrBy/setDecrBy` 实际落地于 **MP 3.5.6**（升 3.5.7 解锁，语料已补）。勘误三条：`selectIgnore` 为 MPJ 字符串链（MPJQueryWrapper）专属方法、`LambdaDeleteWrapper` 类在 MP 任何版本均不存在（插件构造名映射为防御性条目），条件删除用 remove(updateWrapper) 惯用法；`SqlCondition` 在 MP 中始终是常量类而非注解，字段级条件拼接的正确用法是 `@TableField(condition = SqlCondition.LIKE)`（已在 `SysConfig` 演示）。**MPJ 维持 1.5.8 不升级**：与 1.5.9 全类方法级比对，插件识别面（Wrapper/Service 链 API）零增量，但 1.5.9 运行期基建已迁移至 MP 3.5.9+ 新架构包（强配 MP 3.5.17+）；聚合族（selectSum/Max/Min/Avg/Len）与 selectIgnore 均为 1.5.8 已有能力、语料已补齐；插件用户使用 1.5.9+ 不受影响（识别按方法名超集，与 classpath 无关），详见《[MPJ升级评估-调研报告](docs/调研报告/20260907-0846-MPJ升级评估-调研报告.md)》。
>
> Kotlin 兼容性注记：MP 3.5.6 起 orderBy 族新增 Kotlin 变长重载，与单列形态在 Kotlin 中产生重载二义——Kotlin 语料一律显式多列排序（`byAgeRange` 等 4 处已按此修正）。

### mybatis-plus-join-demo（MPJ 1.5.8）

| 场景 | 位置 |
|------|------|
| innerJoin/rightJoin、on-lambda 多条件 + apply、ext MFunction 扩展 ON；4 参别名、5 参 rightAlias | `MpjFullCoverageServiceImpl#joinKindsAndOverloads` / `#onLambdaApply` |
| 子查询条件族 `(col, Class, wrapper)`：in/notIn/exists | `#subqueryConditions` |
| IfExists 族：eqIfExists/gtIfExists/likeIfExists/betweenIfExists/notBetweenIfExists/inIfNotEmpty/notInIfNotEmpty | `#ifExistsFamily` |
| selectCount/聚合族 selectSum/Max/Min/Avg（各 3 重载，1.5.8 已有）/selectFunc 字符串模板 `%s` 占位（CHAR_LENGTH/IFNULL） | `#aggregateExt` |
| updateJoin：setUpdateEntity/set 副表列/setIncrBy/setDecrBy/setApply（列占位 `%s`）/setIfExists | `#updateJoinExt` |
| deleteJoin：主表删除/delete(Class...) 显式指定删除表 | `#deleteJoinExt` |
| MPJQueryWrapper 字符串链：selectAll+selectIgnore/聚合子查询列/IN 子查询/having 占位/分页 | `#queryStringExt` |
| selectCollection（含 filter 条件版）/selectAssociation/from 子查询/around 首尾包裹/setTableName 动态表名（`user_2026` 表已建）/fill 三种形态 | `UserServiceImpl` |
| MPJQueryWrapper 字符串基础链、union、distinct+func、自定义 join SQL + apply、逻辑删除开关、链式 count/one/list | `MpjExtServiceImpl` |

> 运行期实跑勘误（2026-09-10，全部 33 个接口 200 通过）：`selectCollection` 首参 prefix 是 join 表别名而非列前缀，默认别名场景用 2 参版；`selectJoinCount`/链式 count 复用 `sqlSelect`，count 必须用不带 select 列的独立 wrapper；`selectFunc`/`setApply` 的列占位经 String.format 渲染，必须 `%s`（`{0}` 会字面进 SQL）；MySQL 无 FULL JOIN、无 LEN 函数（用 `CHAR_LENGTH(%s)`）；GROUP BY 场景 select 非分组非聚合列触发 only_full_group_by（selectAsClass/selectFilter 与分组不兼容已移出）；`fill` 的源/回填字段 SFunction 类必须与结果 DTO 一致；join 参与实体必须有 `MPJBaseMapper`（Address/Area/StationInfo 三个 Mapper 已补）。

### jpa-hibernate-demo（Spring Boot 2.6.3）

| 场景 | 位置 |
|------|------|
| 派生关键字补充：Not/IsNotNull/NotIn/NotContaining/StartsWith/True/False | `UserRepository` / `LegacyItemRepository` |
| 遗留 hbm.xml 实体（POJO + 映射 + `<query>`/`<sql-query>` 命名查询），经 `spring.jpa.mapping-resources` 注册 | `LegacyItem` + `resources/hbm/LegacyItem.hbm.xml` |
| createNamedQuery（实体 @NamedQuery 与 hbm `<query>` 双来源） | `JpaFullCoverageServiceImpl#queryByNamedQuery` |
| createNativeQuery 位置参数 ?1 | `#queryNativePositional` |
| hbm 实体 HQL（createQuery/createNamedQuery） | `#queryHqlOnLegacyEntity` / `LegacyItemDaoImpl` |
| HibernateTemplate.iterate（命名参数重载） | `#iterateLegacyItems` |
| @Query 构造器表达式 SELECT NEW dto | `UserRepository#findLiteByStatus` + `UserLiteDTO` |
| JPA 写路径：save/saveAll/findById/existsById/count/delete/deleteAllInBatch、@Modifying UPDATE JPQL、em.persist/merge/remove/find、CriteriaUpdate/CriteriaDelete、Specification、QBE（Example.of）、悲观锁读 FOR UPDATE | `UserWriteServiceImpl`（方法 KDoc 挂插件任务号 T-J1/T-J2/T-J5/T-J6/T-J20） |
| HibernateTemplate/HibernateDaoSupport 通用 DAO：get/load/lock、save/saveOrUpdate/update/merge/delete、findByExample（ValueBean）、doInHibernate 分页、命名与位置参数 HQL | `HibernateTemplateDemoServiceImpl` + `CommonDaoHibernateImpl`（WMS 表 wms_asn/wms_dock_booking） |

> 插件自 M39（JPA/Hibernate 覆盖矩阵 J1~J23）起写路径与 HibernateTemplate 均已支持，原「插件盲区不造语料」条目作废；`UserRepository` 既有的 UPDATE JPQL 保留。定位误报守卫：PartTree 方法仅在 Repository 接口产出 gutter 标记。

### mybatis-plus-kotlin-demo（Kotlin 1.9.25 + MP 3.5.7，2026-09-07 新增）

插件 KtWrapperDetector（ktQuery/ktUpdate 扩展链 + Kotlin 直接构造，文本正则 MVP）的专用语料模块，场景集中在 `KotlinWrapperScenarios`：

| 场景 | 方法 |
|------|------|
| ktQuery：eq/ne/gt/le、like 三族、notLike、between、isNull/isNotNull、notIn、select 多列、groupBy/having、apply、last、布尔开关重载、and/or 嵌套 | `byUsername` ~ `byOrNesting` |
| ktUpdate：set（含开关）/setSql/notIn/update、链式 remove | `renameById` / `batchDisable` / `removeDisabled` |
| 直接构造：Lambda 系查询/更新、字符串列 Query/Update、Kt 系包装（类名含 QueryWrapper 子串的识别边界用例） | `byLambdaQueryDirect` ~ `updateByKtDirect` |
| 第二实体订单链（k_order） | `paidOrdersAbove` / `cancelStaleOrders` |

**Kotlin 语料书写约束**（源自检测器逐行正则实现，新增用例必须遵守）：
1. 链起点与链上调用必须**单行**书写，跨行续链只认起点行；
2. and/or 嵌套用带括号 lambda `.and({ w -> ... })`，尾随 lambda 无括号正则不识别；
3. 注释不要出现「包装类名 + `(` 或 `<`」字样（检测器只跳过 `//` 行，块注释体会误触发）；
4. 已知 MVP 边界：Kotlin 关键字 `in` 反引号调用（`byBacktickIn`）、尾随 lambda、跨行链不被识别，语料中保留作 PSI 深化后回归。

> 版本说明：本模块随 2026-09-07 升级使用 MP 3.5.7。勘误：`LambdaDeleteWrapper` 类在 MP 任何版本均不存在（插件构造名映射为防御性条目），条件删除用 remove(updateWrapper) 惯用法；MPJ Kotlin 扩展插件侧为 🟡 未立项，本模块不含 MPJ 场景。MP 3.5.6+ orderBy 族 Kotlin 变长重载与单列调用二义，语料统一显式多列排序。

## 场景覆盖清单增补（2026-09-18 对照插件 2026.9.18-beta.4 能力全方位补齐）

开发计划见《[20260918-0415-插件测试语料全方位补齐-开发计划](docs/开发计划/20260918-0415-插件测试语料全方位补齐-开发计划.md)》。

### mybatis-plus-demo 增补

| 场景 | 位置 |
|------|------|
| Wrapper 定位器高级形态：跨方法工厂链（私有工厂方法返回 wrapper、调用方续链）、helper 方法就地修改 wrapper、`clear()` 截断重建、if/else 互斥分支（插件只取 then）、字符串版 `wrapper.lambda()` 转换、分步续链（new 后逐句挂条件） | `WrapperAdvancedCoverageServiceImpl` |
| `select(Class, Predicate)` 字段谓词过滤、`allEq(Map, boolean)`、实体驱动 SET 双形态（update(entity, wrapper) 与 `new UpdateWrapper<>(entity)`）、`notLike/notLikeLeft/notLikeRight` | 同上 |
| `insertBatchSomeColumn` 自定义 SQL 注入器（`MybatisPlusConfig#defaultSqlInjector` 追加，javap 核实 3.5.7 为三参 `getMethodList(Configuration, Class, TableInfo)`） | `MybatisPlusConfig` + `UserMapper` + `WrapperAdvancedCoverageServiceImpl#batchInsertSome` |
| JdbcTemplate 方法面补形态：`queryForMap` / `queryForRowSet` / `queryForStream` / `execute` DDL | `JdbcTemplateServiceImpl`（21~24 号场景）。Spring 5.3 的 JdbcTemplate 无 `queryForLong/queryForInt/delete/insert` 方法，javap 实证不写 |
| 负例边界语料：注释内链文本、字符串内链文本、撞名 qualifier（自定义 FakeWrappers.lambdaQuery）、泛型实参位、lambda 参数位调用、非 Repository 接口的 findByXxx——IDEA 打开应零 gutter | `common/BoundaryNegativeCases` + `common/FakeUserRepository` |

### mybatis-plus-join-demo 增补

| 场景 | 位置 |
|------|------|
| `MPJWrappers.lambdaJoin()/queryJoin()` 工厂链（vs JoinWrappers）；`JoinWrappers.update()` 工厂 + `setIncrBy` + `set(col, null)` + `updateAndNull` 终结 | `MpjLocatorCoverageServiceImpl` |
| Chain 终结点：`first(Class)` / `one(Class)` / `count()` / `mapOne` / `mapFirst` / `mapList` / `mapPage` | 同上 |
| 构造别名 `new MPJLambdaWrapper<>(UserDO.class, "u")`；字符串 join `{0}` 参数绑定（`leftJoin(String, Object...)`） | 同上 |

### jpa-hibernate-demo 增补

| 场景 | 位置 |
|------|------|
| `@Procedure` 存储过程（过程由 `StoredProcedureConfig` 经 JdbcTemplate 幂等创建，绕开 schema.sql 分号切分限制；注解位于 `org.springframework.data.jpa.repository.query.Procedure`） | `StoredProcedureConfig` + `UserRepository#countUsersByStatusProcedure` + `JpaDeepCoverageServiceImpl#procedureCountByStatus` |
| Criteria 深水区：`cb.exists` 子查询、`coalesce/concat/length` 表达式函数、`fetch` join | `JpaDeepCoverageServiceImpl`（/jpa/deep/*） |
| Specification 组合器 `where/and/or/not`；`@NamedQueries` 容器注解（OrderEntity） | 同上 + `OrderEntity` |
| HibernateTemplate 补形态：`bulkUpdate`（?1 起算序号参数）、`findByNamedQueryAndNamedParam` | `HibernateTemplateDemoServiceImpl`（形态 14/15）。Spring 5.3 已删 `executeFind`，javap 实证不写 |

### multi-orm-demo（新增第五子项目，Boot 2.6.3 + JDK 1.8，端口 8085 / 库 orm_demo）

插件 M44「其它 ORM 第一批」四家识别器的专用语料模块，共用 orm_member 表（同一 JPA 实体三用：@Entity / Querydsl Q 类 / Easy-Query proxy）：

| ORM | 场景 | 位置 |
|------|------|------|
| Querydsl 5.0.0（javax 线） | Q 类表达式树 selectFrom/where/orderBy/fetch、BooleanBuilder、聚合 groupBy、JPAUpdateClause / JPADeleteClause | `QuerydslServiceImpl`（/orm/querydsl/*） |
| MyBatis Dynamic SQL 1.5.2 | SqlTable/SqlColumn 常量、SelectDSL/UpdateDSL/DeleteDSL、`render(SPRING_NAMED_PARAMETER)` 后经 NamedParameterJdbcTemplate 执行 | `MdsServiceImpl`（/orm/mds/*） |
| xbatis 1.10.9（原 mybatis-mp） | `QueryChain.of(mapper)`/`of(mapper, entityClass)`、`gte/lte`、`like(LikeMode, ...)`、`andNested` 嵌套组、UpdateChain/DeleteChain | `XbatisServiceImpl`（/orm/xbatis/*） |
| Easy-Query 3.2.16 | `easyEntityQuery.queryable(X.class).where(o -> o.xxx().eq(...))` proxy 链、语句块 lambda 多条件、insertable / updatable(entity)+setColumns / deletable | `EasyQueryServiceImpl`（/orm/easy/*） |

落地勘误（javap + 实跑实证）：
1. easy-query 的 sql-processor 注解处理器只监听 `@EntityProxy`（不读 @Table 触发生成），且与 Lombok 同轮处理会因 getter 未生成而静默跳过——本模块实体弃用 Lombok 显式写 getter/setter；主键须 `@Column(primaryKey = true)` 否则实体更新报 not found primary key；谓词 eq/ge 返回 void，多条件用语句块 lambda 顺序语句。
2. 生成物为 `entity/proxy/MemberEntityProxy`（非 Table 后缀），实体需 `implements ProxyEntityAvailable<实体, 生成proxy>`。
3. xbatis `QueryChain.create()` 无实体上下文，count 会抛 you need specify entityType，count 场景用 `of(mapper, entityClass)`。
4. MDS `render(SPRING_NAMED_PARAMETER)` 产出 `:p1` 命名参数，必须经 NamedParameterJdbcTemplate 执行（JdbcTemplate 位置参数会 Parameter index out of range）。

### 版本墙（javap 本地 jar 实证，不写语料）

| API | 要求 | demo 基线 |
|------|------|----------|
| `applyFunc` | MP 3.5.9+（3.5.7 Compare/Func/Join/Nested 均无） | mp-demo 3.5.7 |
| `eqOrIsNull` | MP 3.5.17+ | mp-demo 3.5.7 |
| `MPJLambdaQueryWrapper` / `pageByMain` / `around` | MPJ 1.5.9+（join-demo 锁 1.5.8） | mpj-demo 1.5.8 |
| `Specification.allOf/anyOf` | Spring Data JPA 3.x | jpa-demo 2.6.3 |
| `HibernateTemplate.executeFind` | Spring 4.x（5.3 已删） | jpa-demo 5.3 |

> 注意：各子项目为独立 Maven 工程（非聚合父子结构），根 `pom.xml` 仅作聚合入口；新增 `selfdev-framework-demo` 后为六个 Boot 子项目，
> 2026-09-23 再加其 JAR 态语料子工程 `selfdev-shared-lib`（非 Boot 应用），2026-10-16 再加 JPA 的 JAR 态语料对
> `jpa-jar-model-lib` + `jpa-jar-model-demo`（前者非 Boot 应用），聚合模块共 9 个。
>
> 例外二：`jpa-jar-model-demo` 以依赖形式引用 `jpa-jar-model-lib`（实体/嵌入类/仓库接口都在 JAR 里）。
> 根目录聚合构建会自动按依赖顺序先建后者；**单模块**构建 demo 前需先 `mvn install -pl jpa-jar-model-lib`。

## 场景覆盖清单增补（2026-09-22 自研框架帧过滤前缀专用语料）

开发计划见《[20260922-0832-自研框架帧过滤前缀测试子项目-开发计划](docs/开发计划/20260922-0832-自研框架帧过滤前缀测试子项目-开发计划.md)》。

### selfdev-framework-demo（新增第六子项目，Boot 2.6.3 + JDK 1.8，端口 8086 / 库 selfdev_demo）

插件设置项**「源码捕获帧过滤前缀」**的专用语料。模拟公司自研数据访问框架——不经 MyBatis、无拦截点、
SQL 只在运行期由 agent 增强捕获可见，正是该设置项要解决的场景。

| 维度 | 覆盖 |
|------|------|
| 模拟框架 | `com.corp.engine`（静态门面 `DataUpdateTool` / Bean 门面 `DataQueryTool` / 链式 `DataQuery` / 编排 `LocalDbService` / 执行 `DmlRepository` / 代理工厂）、`com.corp.meta`（条件树 `FilterExpression`+`Q`、渲染 `SqlRenderer`、元数据 `MetaRegistry`、分页 `PaginSupport`） |
| A 调用形态（12） | 静态直调 / Bean 门面 / 链式终结 / lambda 回调 / 匿名内部类 / JDK 代理 / 反射 / 业务包装壳 / `CompletableFuture` 异线程 / 命名线程池 / 循环批量 / 单方法两次调用 |
| B 委托深度（4） | 浅层直连 / 三层委托 / 跨服务协作 / 业务包内委托壳（负例） |
| C 查询形态（8） | 分页 / 分页+三层委托 / 计数 / 分组聚合 / 两表 JOIN / IN 条件 / OR 嵌套条件树 / 排序限制 |
| D 写路径（3） | 按条件更新 / 按条件删除 / 循环更新 |

**实测结论（插桩实证，非推断）**：

| 场景 | 登记前缀 | 实测主位置 |
|---|---|---|
| 普通查询 | 无 | `com.corp.engine.DmlRepository#query`（缺陷现象：落框架方法） |
| 普通查询 | `com.corp.engine.` | 业务帧（正确） |
| 分页查询 | `com.corp.engine.` | `com.corp.meta.PaginSupport#wrapAndQuery`（**仍不对**） |
| 分页查询 | `com.corp.engine.` + `com.corp.meta.` | 业务帧（正确） |
| 三层委托 | `com.corp.engine.` | 最内层业务帧 `DepthInnerServiceImpl#innerQuery` |
| 三层委托 | 再加 `cn.song.selfdevdemo.` | **候选池为空 → 无位置**（误用业务包导致跳转能力消失） |

三条要点：**前缀须覆盖整条引擎链**（分页用例最深层在 `com.corp.meta`，必须两行都填）；
**落点是最深业务帧**（外层调用者留在候选列）；**切勿登记业务包**（会把真实业务帧一并跳过）。
完整配方与端点清单见模块 [README](selfdev-framework-demo/README.md)。

## 场景覆盖清单增补（2026-09-23 执行点在业务工具类 / JAR 态帧来源）

开发计划见《[20260923-1520-执行点在业务工具类跳转上顶场景-开发计划](docs/开发计划/20260923-1520-执行点在业务工具类跳转上顶场景-开发计划.md)》。

补一条真实反馈的形状：**SQL 的执行点在业务自己的工具/构建类里，Service 只是它的调用方**；
用户登记了公司工具库包名作帧过滤前缀，但「跳转到 Java」落到的是上层 Service 里「调用该工具类」的那一行。
在 `selfdev-framework-demo` 增 E 组 7 端点（28~34）+ 新子工程 `selfdev-shared-lib`，做成控制变量实验：

| 自变量 | 档位 | 由什么承载 |
|---|---|---|
| 帧来源 | 目录 `target/classes` / 依赖 JAR | 同一对类写两遍：`com.corp.platform.SqlKernel` ↔ `cn.song.selfdevdemo.kernel.PlanTreeKernel`；`com.corp.shared.util.PlanTreeQueryBuilder` ↔ `cn.song.selfdevdemo.util.PlanTreeQueryBuilder`（逐行同构，SQL 文本一致） |
| 调用方是否唯一 | 单 Service / 两个 Service 共用同一构建器方法 | 28·29 单调用方；30→31、32→33 成对触发 |
| 业务与内核的来源组合 | 全目录 / 全 JAR / **业务在目录 + 内核在 JAR** | 34 号：同一 Service 方法先直发一条 SQL、再调目录态工具类发第二条（**真实现场形状**） |

实测（在 stub JDBC 执行边界取真实栈、逐字套用 agent `StackLocator` **当前版本 v2026.9.23** 的三层判定与判定缓存，非推断）：

| 结论 | 证据 |
|---|---|
| **机制 A（未修）**：业务代码打进 JAR 运行时，L1 来源过滤把它判成第三方帧，主位置沿栈上顶到调用方 Service——不登记前缀就已发生、登记前缀也救不回（前缀只有「跳过」语义，没有「提升为业务帧」的反向语义） | 28（目录态）落 `util/PlanTreeQueryBuilder.java:52` / `:67` 两处调用行，正确；29（JAR 态、同构代码）P0/P1/P2 三档均落 `SourceCaptureToolSiteServiceImpl.java:66` |
| **机制 B′（未修，用户现场主因）**：判定缓存的「身份在场」只比 `class#method`，而**先直发 SQL 的那个 Service 方法是其后每条栈的祖先帧、必然在场** ⇒ 主位置被浅帧钉住，行号按当前栈现算＝「调用工具类」那一行 | 34 号（业务在目录 + 内核在 JAR）P0 档：SQL① 落 `...ServiceImpl.java:129` 正确，SQL② 落 `:132`＝调用工具类行，真执行点 `util/PlanTreeQueryBuilder.java:96` 只在候选列第 3 项；**同用例登记 `com.corp.platform.` 后落 `:96` 正确** ⇒ 补登记平台引擎包名是用户侧可立即用的缓解 |
| **真执行点其实躺在候选列里**，但 IDE 侧 `EntryJumpResolver` 只在主位置解析失败时才查候选，回退链被短路 | 29 的候选首项即 `com/corp/shared/util/PlanTreeQueryBuilder.java:38`（SQL② 为 `:53`）；34 号 SQL② 的候选含 `util/PlanTreeQueryBuilder.java:96` |
| **同身份行号互相冻结这一子面已在 v2026.9.23 根治**（T-AgentSourceLocateStale T-01：只缓存判定 + 行号按当前栈现算 + 身份在场校验）；E30/31 与 28 的两处调用点转为该修复的**回归护栏** | 30→31 各落 `…ServiceImpl.java:82` / `:94`；32→33 各落 `util/PlanTreeQueryBuilder.java:106` / `:112`。**旧版对照**（≤ v2026.9.18 的整帧缓存，行号取当时编译产物）：31 会被跳到 **30 的调用行**、28 的 SQL② 会被冻在 **SQL① 的行号** |

> 真机核对落点前先确认插件版本：串位那半部分是已修的旧缺陷，别当新问题查。
> 另：`logLevel` 是 agent 的启动参数（插件注入时固定 `logLevel=warn`，无设置项、无覆盖口），
> info 档的 pool 打点在真机不可达；当前版本改用与档位无关的一次性摘要
> `[T-AgentSourceLocateStale] 入口键非业务帧…`，在应用控制台 grep 即可。
> 真实项目取到的一条（名称已脱敏）显示 `entry=<平台引擎的字典服务帧>#search…`、
> `primary=<业务工具类>:309 (<工具类>#convert…)`、`via=L1` —— 该条落点本身正确，
> 但直接证明了 **entryKey 是平台引擎的共享帧**，即 34 号（机制 B′）成立的前提。

> 走查 JAR 档位需绕开 IDEA 的 Maven workspace 解析（它会把兄弟模块还原成目录形态），
> 配方见 [`selfdev-shared-lib/README.md`](selfdev-shared-lib/README.md)。

## 场景覆盖清单增补（2026-10-10 对照插件 2026.10.6 → 2026.10.13 四版新能力）

开发计划见《[20261010-插件202610新能力语料补齐-开发计划](docs/开发计划/20261010-插件202610新能力语料补齐-开发计划.md)》。
版本墙提前 javap 实证：`Page(long,long,boolean)` MP 3.5.7 在位；`jakarta.persistence-api` 用 **3.0.0**（major 52；3.1.0 是 major 55 与 JDK8 冲突）；
Spring Data `@Embedded.Nullable/Empty` 在 Boot 2.6.3 线不存在，jpa-demo 以**同 FQN 桩注解**承载（升级 Boot 3 须删桩换真依赖）。

### mybatis-plus-demo 增补

| 语料 | 位置 | 覆盖的插件能力（版本） |
|---|---|---|
| `PageSimController` 八端点：注解 IPage / XML 手写 LIMIT 不重复追加 / searchCount 三参四参 / selectList·selectMaps 消费 | `controller/PageSimController` | 分页拦截器模拟 R12 + COUNT 独立开关 T-CountSimToggle（2026.10.13） |
| `LogFeederController`：`/logFeed/n1`（同模板 N+1）、`/heartbeat`（SELECT 1）、`/storm`（可调 QPS）、`/dateParam`（Date/Timestamp/sql.Date 混参）、`/shardingSphere`、`/ssCommaParam` | `controller/LogFeederController` | N+1 同模板徽章 O-90、SQL 屏蔽 T-SqlSuppress、日志性能 T-SqlLogPerf、ShardingSphere 双段解析 R10、日期族 ANSI 字面量还原 R3（2026.10.6/10.13） |
| 混合注解实体 `MixedProfile`（@TableName + jakarta @Embeddable 值对象展平列） | `service/impl/MixedEntityServiceImpl`（**纯静态预览，无端点**——MP 运行期不认 jakarta 注解，勿 curl） | @Embedded 混合注解实体 G3（2026.10.6） |
| `inline-xml/report-view.xml`（异根 + WITH CTA + CDATA）、`inline-xml/legacy-replace.xml`（纯文本 REPLACE） | `resources/inline-xml/` | 通用 XML 内嵌兜底认领词表变体（O-72） |
| `application-pg.yml` PG profile | `resources/` | PG 语句面织入 attach 验收（T-PgWeave，2026.10.13；起服务后 `/logFeed/heartbeat` 即可验证事件到达） |

### mybatis-plus-join-demo 增补

- `MpjLocatorCoverageService#pageSearchCountForms`：`selectJoinMapsPage` / `selectJoinPage` 的 Page 第三参 searchCount=false 对照（R12 Wrapper 面）。
- `resources/sql-reverse/` 八件粘贴语料 + `README.md` 预期清单：GROUP BY·HAVING / DISTINCT·FOR UPDATE / UNION / apply 参数化 / 方言宽容（双引号标识符、0x、`'a\'b'`、DATE·TIMESTAMP 字面量）/ JOIN 双形态·多表 DELETE / INSERT NULL / 返回类型族——喂「SQL → Java」面板（T-SqlToJavaPromote / T-MapResultVo，2026.10.9）。

### jpa-hibernate-demo 增补

- 嵌套嵌入深水区实体组 `Zipcode`→`Address`→`CustomerEntity`：字段级相对点路径覆写 `zipcode.zip → cust_zip`、类级根点路径 `address.street → cust_street`、SD 桩 `@Embedded(prefix="biz_")` 双嵌入防撞、`@Embedded.Nullable` / `@Embedded.Empty` 捷径（G1/G2，2026.10.6）；走查入口 `/embedded/**`（派生查询列面不得出伪列）。
- `inline/hq-widget.xml`（type="hql" + `?`）、`inline/jp-widget.xml`（type="jpql" + 命名参数）：通用 XML 内嵌走 HQL 转换管道（O-72）。
- SD 桩注解：`org.springframework.data.relational.core.mapping.Embedded`（本地同 FQN，`@Embedded(prefix/Nullable/Empty)` 语料形态）。

### 运行期环境语料（无代码，走查口径）

- EXPLAIN 结构化渲染 / Oracle·SQL Server EXPLAIN / OceanBase·openGauss 方言渲染：需对应真库或多方言切换操作——同一条 `PageSim` / `sql-reverse` 语句在设置页切换方言逐档核对（openGauss 的 upsert 是 MySQL 形态 `ON DUPLICATE KEY UPDATE`、`LIMIT 1,2` 会被 PG 语义错解，均真机实证在案）。
