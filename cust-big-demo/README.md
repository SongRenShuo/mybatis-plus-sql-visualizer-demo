# cust-big-demo — 大工程压力语料

用于复现 SQL Visualizer 在真实客户主数据项目中的规模问题（表 1000+、实体类上万、
打开预览即卡死）。本目录是一个**独立的 Maven 聚合工程**，不在 demo 仓根 `pom.xml`
的 modules 里，单独打开/构建即可。

## 模块与 ORM 形态

| 模块 | 表数（默认） | ORM 形态 | 生成物 |
| --- | --- | --- | --- |
| `cust-metadata` | 1200 | 原生 MyBatis + MBG 三件套（Entity / Mapper 接口 / Example + Criteria） | 每表 8 个 Java 类 + 1 个 mapper XML |
| `cust-center` | 800 | MyBatis-Plus（`@TableName`/`@TableId`/`@TableLogic` + `BaseMapper` + `QueryWrapper`/`LambdaQueryWrapper`） | 每表 5 个 Java 类 + 1 个 mapper XML |
| `cust-order` | 300 | iBatis 2.3（`sqlMap` XML + `SqlMapClient`） | 每表 4 个 Java 类 + 1 个 sqlMap XML |
| `cust-report` | 200 | JPA 注解实体（`javax.persistence` 2.2）+ `JdbcTemplate` 字符串 SQL | 每表 3 个 Java 类 |
| `cust-gateway` | 无业务表 | 网关：路由/注册表 | 12 组跨模块同名类（短名多候选解析面） |

合计 2500 张表。`cust-metadata` + `cust-center` 的 mapper XML 共 2000 个（内置
`select`/`insert`/`update`/`delete` 四类语句与 `<if>`/`<foreach>`/`<choose>`）；
`cust-order` 另有 300 个 iBatis 2 的 `sqlMap` XML。

`cust-order` 的 XML 走 iBatis 2.3 的真实 DTD：动态标签是
`isNotNull` / `isNotEmpty` / `isEqual` / `iterate`，2.x 没有 MyBatis 3 的
`<if>/<foreach>/<choose>`，这是 ORM 代际差异，不是偷懒降级。

仓内另有既有的 `cn.song.cust*` 语料（40 套 MBG 三件套、`selectByExample` 调用点、
一个方法两条链的缺陷夹具），本生成器不碰它，只在 `com.demo.cust.*` 下新增。

## 生成器（脚本化、可重放、可参数化）

`tools/gen_big_demo.py`，纯 Python 标准库，不联网。所有随机性来自
`random.Random("<seed>|<module>")`，同一 seed 两次生成逐字节一致。

```bash
# 全量（默认 1200/800/300/200）
python tools/gen_big_demo.py --root .

# 缩小规模做快速验证（表数、类数、XML 数同比例缩小）
python tools/gen_big_demo.py --root . \
    --tables-per-module "metadata=25,center=15,order=6,report=4"

# 只重生成某几个模块
python tools/gen_big_demo.py --root . --modules metadata,center

# 只打印表数分配
python tools/gen_big_demo.py --root . --print-plan

# 删除全部生成物（只删带生成标记的文件，不碰手写代码）
python tools/gen_big_demo.py --root . --clean
```

可选参数：

- `--root`：`cust-big-demo` 根目录（默认脚本上级目录）
- `--seed`：随机种子，默认 `20261113`
- `--tables-per-module`：`metadata=1200,center=800,order=300,report=200`
- `--modules`：`metadata,center,order,report,gateway`
- `--clean` / `--print-plan`

生成物每个文件头部都带 `tools/gen_big_demo.py` 标记；`--clean` 按标记删除，
因此反复重生成不会残留旧表，也不会误删 `cn.song.*` 手写语料。

`tools/generated-summary.json` 记录本次生成的表数与文件数，用于比对重放结果。

## 依赖口径（离线可编）

- `cust-metadata`：`org.mybatis:mybatis:3.5.19`
- `cust-center`：`com.baomidou:mybatis-plus:3.5.7`（非 boot-starter，避免拖 spring-boot）
- `cust-order`：`org.apache.ibatis:ibatis-sqlmap:2.3.4.726`（本机 `~/.m2` 已有，无传递依赖）
- `cust-report`：`javax.persistence:javax.persistence-api:2.2` +
  `org.springframework:spring-jdbc:5.3.31`（传递 core/beans/tx/jcl 本机均有）
- `cust-gateway`：只用 JDK，`spring-boot-starter-web` 保持注释

以上均为本机 `~/.m2/repository` 已有构件，`mvn -o` 离线可解析。若换到没有这些
构件的机器，按报错把对应模块降级（例如 report 去掉 spring-jdbc，改成纯 JDBC
`Connection.prepareStatement` 字符串 SQL），不要留编译不过的 import。

## 构建

```bash
# Windows / Git Bash
JAVA_HOME=D:/HuanJing/Java/jdk1.8.0_181 \
  D:/HuanJing/Maven/maven-mvnd-1.0.3/mvn/bin/mvn.cmd -o -DskipTests compile
```

## 规模自检口径

- 各模块 Java 文件数 / mapper XML 数：`find <模块> -name '*.java' | wc -l`
- 调用点：`rg -c "selectByExample\(" cust-metadata`、
  `rg -c "LambdaQueryWrapper" cust-center`、`rg -c "new QueryWrapper" cust-center`
- 最大单文件行数：`find . -name '*.java' | xargs wc -l | sort -n | tail -1`
- 同名类组数：同名类分布在 `cust-gateway` 与业务模块的 `com.demo.cust.<模块>.contract`
  （见 `tools/gen_big_demo.py` 的 `GATEWAY_GROUPS`）
