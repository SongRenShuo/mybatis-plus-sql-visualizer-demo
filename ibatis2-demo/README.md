# ibatis2-demo

iBatis 2.x（sqlMap 2.0 DTD）语料工程，供插件 **「iBatis 2 静态渲染」** 做人工验收与回归。

## 形态要点

- 只依赖 `org.apache.ibatis:ibatis-sqlmap:2.3.4.726` 一个框架 jar（另有 `mysql-connector-java` 只为对齐兄弟模块口径，本模块不连库）。
- 包名是 `com.ibatis.*`（iBatis 2），**不是** MyBatis 3 的 `org.apache.ibatis.*`；两者不是同一个产品。
- 配置入口 `src/main/resources/sqlmap-config.xml`（`sqlMapConfig` 2.0 DTD），语句在 `src/main/resources/sqlmap/User.xml`（`sqlMap` 2.0 DTD）。
- 没有 Spring、没有 `@SpringBootApplication`、没有数据源；`Ibatis2Main` 只调 `SqlMapClientBuilder.buildSqlMapClient` 解析配置后逐条渲染 SQL。

## 语料清单（语句 → 覆盖的 iBatis 2 语法 → 对应用户可感的插件能力）

| 语句 | 语法形态 | 插件侧应覆盖的能力 |
|---|---|---|
| `selectAll` | 静态 SELECT，无占位符；`resultMap` | 静态 SQL 原样渲染；resultMap 列映射（属性 ← 列名） |
| `selectById` | `#id#` 简单占位符 | `#x#` → `?`，参数名序列 `[id]` |
| `selectTwoSegment` | `#username:VARCHAR#` | 两段式：jdbcType 单独声明 |
| `selectThreeSegment` | `#age:INTEGER:0#`（nullValue） | 三段式：`nullValue` 进参数映射元数据 |
| `selectVarcharNullValue` | `#email:VARCHAR:0#`（三段式 VARCHAR） | 三段式判定只看冒号段数，与 jdbcType 名无关 |
| `selectAdvancedSyntax` | `#id,jdbcType=INTEGER#` | 无冒号的高级语法（`,`/`=` 键值对） |
| `selectOrderBy` | `$orderColumn$` | 字符串直替（无参数映射；null 时 iBatis 静默丢弃该值） |
| `selectEscapes` | `##` / `$$` | 转义字面量：渲染结果必须是单个 `#` / `$` |
| `selectByCondition` | `<dynamic prepend="WHERE">` + `<isNotNull>` / `<isNotEmpty>` / `<isEqual compareValue>` / `<isGreaterThan>` | 父 prepend 吃掉第一个子 prepend；条件裁剪；`$username$` 与 `#id#` 混用 |
| `selectPrependNoSpace` | 同样的 dynamic，但 `prepend="AND"`（无尾随空格） | **复刻坑**：iBatis 真实输出是 `ANDUSER_NAME` 粘连，渲染器不能补空格 |
| `selectByIterate` | `<iterate property="ids" open close conjunction>` + `#ids[]#` | 循环展开成 `(ID = ? OR ID = ? OR ID = ?)`，参数名 `ids[0]/ids[1]/...` |
| `selectNullParamBranch` | `<isNull>` / `<isNotNull>` 二选一 | `parameterObject == null` 时 `<isNull>` 为真；空参数与半填充两态渲染 |
| `insertUser` | `<insert>` + `<selectKey type="pre">` | 主键前置语句（生成独立 statement `User.insertUser-SelectKey`）；insert 体内 nullValue |
| `viaParameterMapRawHash` | `<statement parameterMap="userParamMap">` 手写 `?`，体内故意保留 `#username#` | **关键分支**：声明了 `parameterMap` ⇒ `#` 不转 `?`，真正生效的是手写 `?` |
| `callUserProcedure` | `<procedure>` + `parameterMap` | 存储过程语法形态（不要求可执行） |
| `selectByInclude` | `<sql id>` + `<include refid>`（同 namespace） | 片段在配置期内联；`useStatementNamespaces=true` 时 refid 走 namespace 回退 |
| `selectByDeptId` | 被 `resultMap deptWithUsers` 的嵌套 `<result select=...>` 引用 | N+1 形态：父 `groupBy` + 带 `select` 的 result 映射 |

另有 `resultMap userResult`（`<result property column jdbcType/>`）与 `parameterMap userParamMap`（`<parameter property javaType jdbcType nullValue mode/>`，被 `viaParameterMapRawHash` / `callUserProcedure` 真正引用）。

## 离线自检（本模块的价值锚点）

`buildSqlMapClient` 会做 DTD 校验与全量配置解析；它跑通就机器证明语料**语法合法**。随后 `Ibatis2Main` 用
`MappedStatement#getSql` / `ParameterMap#getParameterObjectValues` 打出每条语句的真实渲染 SQL、参数名序列与参数值。

运行（Windows + JDK 8；jar 取自插件仓调研目录）：

```bash
cd ibatis2-demo
JAR="F:/code/Java/Gitee/SongRenShuo/_ibatis-research/jars/ibatis-sqlmap-2.3.4.726.jar"
javac -encoding UTF-8 -cp "$JAR" -d target/probe $(find src/main/java -name "*.java")
cp -r src/main/resources/* target/probe/
# Git Bash 会把 classpath 里的 ; 当路径列表转换，必须关掉 MSYS 参数转换
MSYS2_ARG_CONV_EXCL='*' java -cp "target/probe;$JAR" cn.song.ibatis2demo.Ibatis2Main
```

PowerShell 等价写法（无需处理 MSYS）：

```powershell
$jar = 'F:/code/Java/Gitee/SongRenShuo/_ibatis-research/jars/ibatis-sqlmap-2.3.4.726.jar'
javac -encoding UTF-8 -cp $jar -d target/probe (Get-ChildItem -Recurse src/main/java -Filter *.java).FullName
Copy-Item -Recurse -Force src/main/resources/* target/probe/
java -cp "target/probe;$jar" cn.song.ibatis2demo.Ibatis2Main
```

退出码：全部语句渲染成功为 0，任一失败为 1（可直接当门禁用）。

### 实测读数（2026-11-09，JDK 1.8.0_181 + ibatis-sqlmap-2.3.4.726）

`buildSqlMapClient` 成功，注册 17 条语句（`<selectKey>` 生成的 `User.insertUser-SelectKey` 挂在 insert 上，不单列在 delegate 的语句表里），20 次渲染全部通过、退出码 0。节选真实输出：

```
--- User.selectAll   [静态无占位符，null 参数]
    params = []
    SQL    = SELECT ID, USER_NAME, EMAIL, AGE, STATUS FROM T_USER ORDER BY ID

--- User.selectEscapes   [## 与 $$ 转义字面量，null 参数]
    SQL    = SELECT 'A#B' AS SHARP_LITERAL, 'C$D' AS DOLLAR_LITERAL FROM T_USER WHERE 1 = 1

--- User.selectTwoSegment   [#username:VARCHAR# 两段式]
    SQL    = SELECT ID, USER_NAME, EMAIL, AGE, STATUS FROM T_USER WHERE USER_NAME = ?
    params = [username:VARCHAR]

--- User.selectThreeSegment   [#age:INTEGER:0# 三段式（age 为 null，观察 nullValue 生效）]
    SQL    = SELECT ID, USER_NAME, EMAIL, AGE, STATUS FROM T_USER WHERE AGE = ?
    params = [age:INTEGER(nullValue=0)]
    values = [null]

--- User.selectVarcharNullValue   [#email:VARCHAR:0# 三段式 VARCHAR（email 为 null）]
    SQL    = SELECT ID, USER_NAME, EMAIL, AGE, STATUS FROM T_USER WHERE EMAIL = ?
    params = [email:VARCHAR(nullValue=0)]
    values = [null]

--- User.selectAdvancedSyntax   [#id,jdbcType=INTEGER# 高级语法]
    params = [id:INTEGER]

--- User.selectOrderBy   [$orderColumn$ 字符串直替]
    SQL    = SELECT ID, USER_NAME, EMAIL, AGE, STATUS FROM T_USER ORDER BY USER_NAME DESC
    params = []

--- User.selectByCondition   [dynamic 四条件全命中（父 prepend 吃掉第一个 AND）]
    SQL    = SELECT ID, USER_NAME, EMAIL, AGE, STATUS FROM T_USER WHERE ID = ? AND USER_NAME LIKE '%alice%' AND STATUS = ? AND AGE > ? ORDER BY ID
    params = [id, status, age]

--- User.selectByCondition   [同一语句半填充：只命中 id 与 status]
    SQL    = SELECT ID, USER_NAME, EMAIL, AGE, STATUS FROM T_USER WHERE ID = ? AND STATUS = ? ORDER BY ID
    params = [id, status]

--- User.selectPrependNoSpace   [prepend 不补空格坑：真实输出 ANDUSER_NAME 粘连]
    SQL    = SELECT ID, USER_NAME, EMAIL, AGE, STATUS FROM T_USER WHERE ID = ? ANDUSER_NAME = ?

--- User.selectByIterate   [iterate + #ids[]#]
    SQL    = SELECT ID, USER_NAME, EMAIL, AGE, STATUS FROM T_USER WHERE ( ID = ? OR ID = ? OR ID = ? )
    params = [ids[0], ids[1], ids[2]]

--- User.selectNullParamBranch   [null 参数：<isNull> 为真 -> USER_NAME IS NULL]
    SQL    = SELECT ID, USER_NAME, EMAIL, AGE, STATUS FROM T_USER WHERE USER_NAME IS NULL

--- User.insertUser   [insert + selectKey type=pre，email/age 走 nullValue]
    SQL    = INSERT INTO T_USER (ID, USER_NAME, EMAIL, AGE) VALUES (?, ?, ?, ?)
    params = [id, username, email:VARCHAR(nullValue=unknown), age:INTEGER(nullValue=0)]

--- User.viaParameterMapRawHash   [声明 parameterMap：手写 ? 生效，#username# 原样保留]
    SQL    = SELECT #username# AS RAW_HASH_KEPT, ? AS POSITIONAL FROM T_USER WHERE USER_NAME = ? AND EMAIL = ?
    params = [username:VARCHAR, email:VARCHAR(nullValue=none@example.com), age:INTEGER]

--- User.callUserProcedure   [procedure 语法形态]
    SQL    = { call PKG_USER.SYNC_USER(?, ?, ?) }
```

## 语料里刻意保留的坑（改语料时勿"修好"）

1. **`prepend` 不补空格**：`selectPrependNoSpace` 的真实输出是 `ANDUSER_NAME`。iBatis 2 只把 `prepend` 属性原文拼上去，插件渲染器必须复刻该输出；补空格就等于与真引擎不一致。
2. **声明 `parameterMap` 的语句 `#` 不转 `?`**：`viaParameterMapRawHash` 里 `#username#` 原样留在 SQL 中，真正生效的是手写 `?`。渲染器必须按「有 parameterMap ⇒ `#` 保留」处理。
3. **`nullValue` 是绑定期哨兵，不在渲染值里体现**：`#age:INTEGER:0#` 的映射带 `nullValue=0`，但 `getParameterObjectValues` 对 null 仍返回 `null`；替换发生在 JDBC 绑定 null 时。
4. **`<sql>` 必须声明在引用它的语句之前**：`include` 是配置期按文档顺序内联，片段放后面会让 `buildSqlMapClient` 直接抛 "Could not find SQL statement to include with refid"。语料当前把两个片段放在最前，勿下移。
5. **`$x$` 为 null 时静默丢弃**：`selectOrderBy` 不传 `orderColumn` 时 `ORDER BY ` 后面为空，iBatis 不会报错也不会补默认值。

## 构建状态

- **javac 直编译 + 真跑：通过**（上面的实测读数）。
- **Maven 未验证**：本机离线仓缺 `org.apache.ibatis:ibatis-sqlmap:2.3.4.726`（`C:\Users\USER\.m2\repository` 无此坐标），`mvnd -o -f ibatis2-demo/pom.xml compile` 报
  `Cannot access central ... in offline mode and the artifact ... has not been downloaded from it before`。
  按纪律不联网补件；语料合法性已由第 1 条覆盖。
- 另：根目录聚合 `mvnd -o -pl ibatis2-demo -am compile` 当前**读不动**——`mybatis-plus-demo/pom.xml` 存在既有的
  `Duplicated tag: 'profiles'` 解析错误（与本模块无关，不在本任务改动范围）。

## 已知边界

- `callUserProcedure` 只覆盖语法形态，不连库、不验证 `{call ...}` 的驱动兼容性。
- `deptWithUsers` 的 N+1 只在配置期解析（渲染自检不执行结果映射），嵌套 `select` 的执行链未验证。
- 未覆盖 `<isParameterPresent>` / `<isNotParameterPresent>` / `<isPropertyAvailable>` / `<isNotPropertyAvailable>` / `<isLessThan>` 等其余条件标签（机制与已覆盖的 `isNull`/`isNotEmpty`/`isEqual` 同族，本轮按计划清单取四类代表）。如需扩容，直接在同文件加语句并在 `Ibatis2Main` 加一行 render 即可。
