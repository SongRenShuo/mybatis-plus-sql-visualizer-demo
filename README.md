# mybatis-plus-sql-visualizer-demo

[mybatis-plus-sql-visualizer](https://gitee.com/SongRenShuo/mybatis-plus-sql-visualizer) 插件的测试用例 Demo 集合项目。

本仓库包含三个相互独立的 Spring Boot 子项目（Maven 多模块仓库，每个子项目可单独构建运行），
分别覆盖插件支持的三大 ORM 主题，为插件提供真实、丰富的 SQL 预览 / SQL 生成测试场景：

| 子项目 | 主题 | 说明 |
|--------|------|------|
| [mybatis-plus-demo](mybatis-plus-demo) | MyBatis-Plus | `QueryWrapper` / `LambdaQueryWrapper` / `UpdateWrapper` / `LambdaUpdateWrapper` / `LambdaDeleteWrapper`、XML 动态 SQL、注解 SQL、分页、批量操作 |
| [mybatis-plus-join-demo](mybatis-plus-join-demo) | MyBatis-Plus-Join (MPJ) | `MPJLambdaWrapper` 多表联查、`selectCollection`、`from` 子查询、`around`、`fill`、`updateJoin` / `deleteJoin` |
| [jpa-hibernate-demo](jpa-hibernate-demo) | JPA + Hibernate | Spring Data JPA 派生查询、`@Query` JPQL、`CriteriaQuery`、Hibernate HQL |
| [mybatis-plus-kotlin-demo](mybatis-plus-kotlin-demo) | MyBatis-Plus Kotlin | `ktQuery()` / `ktUpdate()` 扩展链、Kotlin 直接构造 Wrapper（插件 KtWrapperDetector 语料） |

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
> 三个子项目是**独立 Maven 工程**：各自以 `spring-boot-starter-parent` 作为 parent，互不关联，也不继承根 pom 的任何依赖或属性。

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

## 场景覆盖清单（2026-09-07 插件能力对照补齐）

以下为按插件覆盖矩阵逐项补齐的场景，新增代码集中在各模块 `WrapperFullCoverage*` / `WrapperFactoryCoverage*` / `MpjFullCoverage*` / `JpaFullCoverage*` 服务及其 Controller，均可在 IDEA 打开后直接用插件预览。

### mybatis-plus-demo（MP 3.5.3.1）

| 场景 | 位置 |
|------|------|
| likeLeft/notLike 族、notBetween、isNotNull、geSql/ltSql、func、apply 多占位、first/comment/last、or 嵌套、多列 groupBy/orderBy | `WrapperFullCoverageServiceImpl` |
| Wrappers 8 工厂形态、ChainWrappers 终结点（list/one/count/exists/page）、Db kit 静态 CRUD、SimpleQuery（keyMap/map/list）、ActiveRecord（Model） | `WrapperFactoryCoverageServiceImpl` |
| selectMapsPage/exists/deleteByMap/update(wrapper) 等 CRUD 补形态 | 同上 |
| @KeySequence/@EnumValue/@OrderBy 实体注解 | `SysConfig` / `ConfigTypeEnum` |
| `${ew.customSqlSegment}` 展开（含 join 场景）、foreach/where/having 动态 SQL | `OrderMapper.xml` + `OrderMapper` |
| choose/set/子查询+foreach | `DepartmentMapper.xml` |
| sql 片段 include 复用 + 批量 insert foreach | `RoleMapper.xml` |
| Provider 族注解 SQL | `UserMapper` + `UserSqlProvider` |
| 自研 maintainPage XML（`<pages><maintainPage>` + CDATA SQL + 列元数据） | `resources/pages/user-maintain.xml` |

> 版本说明（2026-09-07 升级勘误，经本地 jar javap 逐版核实）：`mybatis-plus-demo` 与 `mybatis-plus-kotlin-demo` 已升级 **MP 3.5.7**，`mybatis-plus-join-demo` 保留 **MP 3.5.2 + MPJ 1.5.8** 作为旧版本对照基线。3.5.4 相对 3.5.3.1 对本语料无增量；`eqSql`、`setIncrBy/setDecrBy` 实际落地于 **MP 3.5.6**（升 3.5.7 解锁，语料已补）。勘误三条：`selectIgnore` 为 MPJ 字符串链（MPJQueryWrapper）专属方法、`LambdaDeleteWrapper` 类在 MP 任何版本均不存在（插件构造名映射为防御性条目），条件删除用 remove(updateWrapper) 惯用法；`SqlCondition` 在 MP 中始终是常量类而非注解，字段级条件拼接的正确用法是 `@TableField(condition = SqlCondition.LIKE)`（已在 `SysConfig` 演示）。**MPJ 维持 1.5.8 不升级**：经与 1.5.9 三重全量比对（类清单/Query 接口/MPJQueryWrapper 方法）零 API 增量，且 1.5.9 配对口径面向 MP 3.5.17+，聚合族（selectSum/Max/Min/Avg/Len）与 selectIgnore 均为 1.5.8 已有能力、语料已补齐，详见《[MPJ升级评估-调研报告](docs/调研报告/20260907-0846-MPJ升级评估-调研报告.md)》。
>
> Kotlin 兼容性注记：MP 3.5.6 起 orderBy 族新增 Kotlin 变长重载，与单列形态在 Kotlin 中产生重载二义——Kotlin 语料一律显式多列排序（`byAgeRange` 等 4 处已按此修正）。

### mybatis-plus-join-demo（MPJ 1.5.8）

| 场景 | 位置 |
|------|------|
| innerJoin/rightJoin/fullJoin、4 参别名、5 参 rightAlias、on-lambda 多条件 + apply、ext MFunction 扩展 ON | `MpjFullCoverageServiceImpl#joinKindsAndOverloads` / `#onLambdaApply` |
| 子查询条件族 `(col, Class, wrapper)`：in/notIn/exists | `#subqueryConditions` |
| IfExists 族：eqIfExists/gtIfExists/likeIfExists/betweenIfExists/notBetweenIfExists/inIfNotEmpty/notInIfNotEmpty | `#ifExistsFamily` |
| selectAsClass/selectCount/聚合族 selectSum/Max/Min/Avg/Len（各 3 重载）/selectFunc 字符串模板 {0}/selectFilter | `#aggregateExt` |
| updateJoin：setUpdateEntity/set 副表列/setIncrBy/setDecrBy/setApply | `#updateJoinExt` |
| deleteJoin：主表删除/delete 指定表 | `#deleteJoinExt` |
| MPJQueryWrapper 字符串链：selectAll+selectIgnore/聚合子查询列/IN 子查询/分页 | `#queryStringExt` |

> 版本墙：`selectSum/Max/Min/Avg/Len` 需 MPJ ≥ 1.5.9，本地为 1.5.8，暂缺。

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

> 插件盲区不造语料：UPDATE JPQL、CriteriaUpdate/Delete、裸 findAll 系 CRUD、Specification/QBE 等插件不支持形态未新增（`UserRepository` 既有的 UPDATE JPQL 为历史用例，保留作反向验证）。

### mybatis-plus-kotlin-demo（Kotlin 1.9.25 + MP 3.5.3.1，2026-09-07 新增）

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

> 注意：三个子项目为独立 Maven 工程（非聚合父子结构），根 `pom.xml` 仅作仓库说明占位。
