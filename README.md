# mybatis-plus-sql-visualizer-demo

[mybatis-plus-sql-visualizer](https://gitee.com/SongRenShuo/mybatis-plus-sql-visualizer) 插件的测试用例 Demo 集合项目。

本仓库包含三个相互独立的 Spring Boot 子项目（Maven 多模块仓库，每个子项目可单独构建运行），
分别覆盖插件支持的三大 ORM 主题，为插件提供真实、丰富的 SQL 预览 / SQL 生成测试场景：

| 子项目 | 主题 | 说明 |
|--------|------|------|
| [mybatis-plus-demo](mybatis-plus-demo) | MyBatis-Plus | `QueryWrapper` / `LambdaQueryWrapper` / `UpdateWrapper` / `LambdaUpdateWrapper` / `LambdaDeleteWrapper`、XML 动态 SQL、注解 SQL、分页、批量操作 |
| [mybatis-plus-join-demo](mybatis-plus-join-demo) | MyBatis-Plus-Join (MPJ) | `MPJLambdaWrapper` 多表联查、`selectCollection`、`from` 子查询、`around`、`fill`、`updateJoin` / `deleteJoin` |
| [jpa-hibernate-demo](jpa-hibernate-demo) | JPA + Hibernate | Spring Data JPA 派生查询、`@Query` JPQL、`CriteriaQuery`、Hibernate HQL |

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

> 注意：三个子项目为独立 Maven 工程（非聚合父子结构），根 `pom.xml` 仅作仓库说明占位。
