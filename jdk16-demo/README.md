# jdk16-demo —— JDK 1.6 时代栈语料

Sql Visualizer 插件的「老栈」语料子项目：真 JDK 1.6 上编译、测试与运行的最小 SpringBoot + MyBatis 全链路，
覆盖「接口 + 实现类 + 实体类」的经典分层形态。插件侧用途：老字节码/老容器环境下的 SQL 捕获与预览回归宿主。

## 技术栈（全部实测在真 JDK 6 上跑通）

| 组件 | 版本 | 说明 |
|------|------|------|
| JDK | 1.6.0-119（Zulu 6.22.0.3 win64，`D:/HuanJing/Java/jdk1.6.0_119`） | 经 Maven toolchains 指定，编译与测试 JVM 都落在它上 |
| Spring Boot | 1.5.22.RELEASE（1.5 线最后一版） | 官方口径默认 Java 7，Java 6 属官方支持的「additional configuration」 |
| 内嵌容器 | Tomcat 7.0.109（Servlet 3.0 / Java 6+） | 官方 howto §73.16「Use Tomcat 7」配方：`tomcat.version` 覆盖 + 单独补 `tomcat-juli` |
| MyBatis | 3.4.6 + mybatis-spring 1.3.2 | 不用 starter 自动装配，手写 `SqlSessionFactoryBean`（原因见下） |
| JDBC 驱动 | Connector/J 5.1.49 | 8.x 驱动要 Java 8；本机 root 为 `mysql_native_password`，5.1 可直连 MySQL 8.0.12 |
| 连接池 | tomcat-jdbc 7.0.109 | Boot 1.x 默认池（不是 Hikari），Java 6 兼容 |
| 端口 / 库 | 8090 / jdk16_demo | 库已按 `utf8`（utf8mb3）建好；`db/schema.sql` 随启动自动重建 |

## 形态要点（与其它模块的差异）

- **Java 6 语法**：无 lambda、无 try-with-resources、无菱形推断；实体手写 getter/setter，无 Lombok。
- **老式路由**：`@RequestMapping(method = ...)`，不用 4.3 新出的 `@GetMapping` 简写。
- **手写 MyBatis 装配**（`config/MyBatisConfig`）：`SqlSessionFactoryBean` + `@MapperScan`，2012~2014 时代标准形态。
  不用 mybatis-spring-boot-starter 的实测原因：其自动装配的构造器注入（`ObjectProvider<Interceptor[]>` 等）在
  宿主 JDK 17 跑构建时实例化失败（`ObjectProvider` 泛型被解析成裸 `Object`，`NoUniqueBeanDefinitionException`
  报 4 候选）；同代码 JDK 8 宿主对照通过——触发随 JVM 版本变化，语料不需要赌它。
- **XML 动态 SQL + 一条注解 SQL 并存**：`<where>/<if>`、`<set>/<if>`、`<choose>/<otherwise>`、`<foreach>` IN、
  `<sql>/<include>`、resultMap 与 `map-underscore-to-camel-case` 双形态对照。
- **schema 自动执行**：Boot 1.x 对外部库也默认执行 `spring.datasource.schema`（2.0 起才默认仅嵌入式库），
  `sql-script-encoding: UTF-8` 防止 Windows GBK 把脚本中文读坏；脚本自带 DROP，可重复执行。

## 端点

| 方法 | 路径 | 覆盖 |
|------|------|------|
| GET | `/users?name=&status=&age=` | `<where>/<if>` 动态列表 |
| GET | `/users/{id}` | resultMap 单查（404 时回 NOT_FOUND） |
| POST | `/users` | INSERT + `useGeneratedKeys` 主键回填 |
| PUT | `/users/{id}` | `<set>/<if>` 只更新非空字段 |
| DELETE | `/users/{id}` | DELETE 影响行数 |
| GET | `/users/search?keyword=&ids=1,2` | `<choose>` 分支 + `<foreach>` IN |
| GET | `/users/count?status=` | 注解 SQL `@Select` 计数 |

## 构建前提（缺一不可）

1. `~/.m2/toolchains.xml` 提供 JDK 6 toolchain 实体（本机已配好；换机器照抄并改路径）：

```xml
<toolchain>
  <type>jdk</type>
  <provides><version>1.6</version></provides>
  <configuration><jdkHome>D:/HuanJing/Java/jdk1.6.0_119</jdkHome></configuration>
</toolchain>
```

2. 本机 MySQL（root/root）可达。没有 toolchain 实体时本模块构建**直接失败**——刻意设计，
   JDK 6 语料不允许被高版本 javac 静默代编。

## 构建 / 运行

```bash
# 编译 + 测试（mvnd 宿主是 JDK 17 也没关系：toolchain 管 javac 与测试 JVM）
mvnd -f jdk16-demo/pom.xml test

# 打可执行 fat jar（java -jar 用 JDK 6 的 java 启动）
mvnd -f jdk16-demo/pom.xml package -DskipTests
D:/HuanJing/Java/jdk1.6.0_119/bin/java.exe -XX:MaxPermSize=256m -jar target/jdk16-demo-1.0.0.jar
```

mvnd 非 TTY 输出只有摘要行，测试读数以 `target/surefire-reports/` 为准。

## 验证记录（2026-11-21 实测，非推断）

1. **编译**：`Toolchain in compiler-plugin: JDK[D:/HuanJing/Java/jdk1.6.0_119]`；产物 class 经 javap 实测 major 50。
2. **测试**：surefire fork 的测试 JVM 实测 `java.version=1.6.0-119`（vendor Azul Systems，surefire XML 为证）；
   `Tests run: 3, Failures: 0, Errors: 0`（HTTP 全链路 2 例 + 服务面 1 例，内嵌 Tomcat 7 随机端口起服）。
3. **运行**：真 JDK 6 `java -jar` 起服后 curl 全通——GET `/users` 中文种子正常、POST 主键回填、
   注解 SQL 计数、LIKE 动态搜索，MyBatis `==> Preparing/Parameters` 日志在控制台可见。
4. **全 classpath 字节码**：逐 jar javap 抽样，除一处休眠例外全部 ≤ major 50——
   jackson-databind 2.8 线是 major 51 → `jackson.version` 锁 2.7.9；assertj-core 2.6.0 major 51 →
   从 starter-test 排除；**tomcat-annotations-api 7.0.109（major 52）必须保留**：
   Tomcat 7 在 JDK 6 下启动要查 `javax.annotation.security.DeclareRoles`，JDK 6 的 rt.jar 没有它
   （排除后实测 `NoClassDefFoundError`、上下文起不来）；该 jar 只是注解声明壳，注解类型不被真正加载时
   JDK 6 无感（major 52 类不加载就不触发 UnsupportedClassVersionError），JDK 6 `java -jar` 冒烟全通为证。

## 踩坑记录（都是实测，换环境复现时先查这里）

- **jackson-databind 2.8 整条线是 Java 7 字节码**（2.8.0/2.8.9/2.8.11 实测均 major 51），2.7.9 是最后一条 Java 6 线；
  走 Boot 的 `jackson.version` → jackson-bom 属性入口全线降级。
- **surefire 2.18.1（Boot 1.5 parent 默认）不把 toolchain 落到 fork 的测试 JVM**——fork 的是宿主 JVM
  （mvnd 下即 17），surefire XML 里 java.version 一眼可辨；升 2.22.2 后 fork 正确落在 JDK 6。
- **宿主 JDK 17 + mybatis-spring-boot-starter 1.3.x 自动装配**构造器注入失败（见上），JDK 8 对照通过。
- **URL 中文查询参数**：预编码的 `%E7..` 会被 RestTemplate 的 URI 模板展开**二次编码**成 `%25E7..`，
  服务端拿到的是字面 `%E7%8E%8B`；HTTP 面搜索用例改走 ASCII 邮箱关键词，中文形态由 POST 中文体与
  直连库「李」搜索覆盖。`server.tomcat.uri-encoding: UTF-8` 保留，给真实 curl 中文参数兜底。
- **tomcat-annotations-api 不能排除**：Tomcat 7 启动要 `javax.annotation.security.DeclareRoles`，
  JDK 6 的 rt.jar 没有这个包（Java 7/8 才自带）——排除后 Tomcat 起不来（实测），带着它是休眠例外（见验证记录 4）。
- **Connector/J 5.1 直连 MySQL 8 的前提**：账号认证插件是 `mysql_native_password`
  （`SELECT plugin FROM mysql.user WHERE user='root'` 可查）；caching_sha2 账号 5.1 驱动连不上。
- **JDK 6 是 PermGen 时代**：surefire argLine 带 `-XX:MaxPermSize=256m`；`-Dfile.encoding=UTF-8` 防控制台乱码。
