# mybatis-plus-sql-visualizer-demo

[Sql Visualizer](https://gitee.com/SongRenShuo/mybatis-plus-sql-visualizer) 插件的测试用例 Demo 集合项目。

本仓库包含四个相互独立的 Spring Boot 子项目（Maven 多模块仓库，每个子项目可单独构建运行），
覆盖插件支持的各 ORM 主题与 SQL 来源形态，为插件提供真实、丰富的 SQL 预览 / SQL 生成测试场景：

| 子项目 | 端口 / 数据库 | 主题 | 说明 |
|--------|------|------|------|
| [mybatis-plus-demo](mybatis-plus-demo) | 8081 / mp_demo | MyBatis-Plus 3.5.7 | `QueryWrapper` / `LambdaQueryWrapper` / `UpdateWrapper` / `LambdaUpdateWrapper`、`eqSql`/`inSql` 族、Wrappers 工厂 / Db kit / ActiveRecord、XML 动态 SQL、注解 SQL、分页、批量操作；`JdbcTemplate` / `NamedParameterJdbcTemplate` 字符串 SQL、自研 DAO 壳（`DbHelper` / `BeanCruder`） |
| [mybatis-plus-join-demo](mybatis-plus-join-demo) | 8082 / mpj_demo | MyBatis-Plus-Join（MP 3.5.2 + MPJ 1.5.8） | `MPJLambdaWrapper` 多表联查、聚合族、`selectCollection`、子查询条件族、`fill`、`updateJoin` / `deleteJoin`、`MPJQueryWrapper` 字符串链 |
| [jpa-hibernate-demo](jpa-hibernate-demo) | 8083 / jpa_demo | JPA + Hibernate（Spring Boot 2.6.3） | Spring Data JPA 派生查询、`@Query` JPQL、`CriteriaQuery`、Hibernate HQL、`HibernateTemplate` / `HibernateDaoSupport` 通用 DAO、hbm.xml 遗留实体、JPA 写路径（save / `@Modifying` / `CriteriaUpdate`·`Delete` / Specification / QBE / 锁读） |
| [mybatis-plus-kotlin-demo](mybatis-plus-kotlin-demo) | 8084 / kotlin_demo | MyBatis-Plus Kotlin（1.9.25 + MP 3.5.7） | `ktQuery()` / `ktUpdate()` 扩展链、Kotlin 直接构造 Wrapper（插件 KtWrapperDetector 语料） |

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
> 四个子项目是**独立 Maven 工程**：各自以 `spring-boot-starter-parent` 作为 parent，互不关联，也不继承根 pom 的任何依赖或属性。

## 数据库初始化

运行（而非仅代码解析）时需要 MySQL，四个子项目各用独立库，建表脚本随仓库维护，与实体类逐列对齐：

| 数据库 | 脚本 |
|--------|------|
| mp_demo | `mybatis-plus-demo/src/main/resources/db/schema.sql` |
| mpj_demo | `mybatis-plus-join-demo/src/main/resources/db/schema.sql` |
| jpa_demo | `jpa-hibernate-demo/src/main/resources/db/schema.sql` |
| kotlin_demo | `mybatis-plus-kotlin-demo/src/main/resources/db/schema.sql` |

脚本可重复执行（自带 DROP TABLE），含初始化数据；实体新增表时须同步维护对应脚本。

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

> 注意：四个子项目为独立 Maven 工程（非聚合父子结构），根 `pom.xml` 仅作仓库说明占位。
