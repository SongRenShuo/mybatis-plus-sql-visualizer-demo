# 复现用例：带 @ 的 iBatis 语句名，快捷键预览误报找不到 SQL（T-IbatisAtShapeGate，2026-11-17）

## 现象

iBatis 2 语料里一条语句名形如 `组名@命名空间.语句id`，`@` 属于 namespace 段（站点自研框架的路由约定，
不是分隔符）。真实报障语句名全文：

```
cQAccountTypeByAccountType@custmg.qAccountTypeByAccountType
```

同一行调用上：点左侧 gutter 预览图标**能**打开预览；按 `Alt+Shift+Q` 却弹
「未在光标处找到可预览的 SQL 源」。

## 复现文件

| 文件 | 位置 | 内容 |
|---|---|---|
| `ibatis2-demo/src/main/resources/sqlmap/AccountType.xml` | L15 | `<sqlMap namespace="cQAccountTypeByAccountType@custmg">` |
| 同上 | L18-L22 | `<select id="qAccountTypeByAccountType" resultClass="java.util.HashMap">`，SQL 为 `SELECT ACCOUNT_TYPE, FLAG, SHOW_FLAG FROM T_ACCOUNT_TYPE WHERE ACCOUNT_TYPE = #accountType#`（iBatis 2 的 `#x#` 占位符） |
| `ibatis2-demo/src/main/resources/sqlmap-config.xml` | L41 | `<sqlMap resource="sqlmap/AccountType.xml"/>`（L37 的 `User.xml` 保留） |
| `ibatis2-demo/src/main/java/cn/song/ibatis2demo/UserDao.java` | L95 | `Object queryAccountTypeByAccountType(java.util.Map<String, Object> inMap)` |
| `ibatis2-demo/src/main/java/cn/song/ibatis2demo/UserDaoImpl.java` | L25、L27-L30 | 新增字段 `baseDao`（`SqlMapClient` 类型，与 `client` 在构造器里一并赋值） |
| 同上 | L144-L148 | 方法体：`baseDao.queryForObject("cQAccountTypeByAccountType@custmg.qAccountTypeByAccountType", inMap)` |

两处刻意形态，别顺手改：语句名里的 `@`，以及接收者叫 `baseDao`（真机里接收者就是这个名字，
它会命中插件侧「DAO 名后缀」的家族排除）。

## 复现步骤

1. 用装了本插件的 IDE 打开 demo 工程，定位到 `ibatis2-demo` 模块；
2. 打开 `UserDaoImpl.java`，把光标放进 `queryAccountTypeByAccountType` 方法体里那行语句名
   **字符串字面量内部**（L147）；
3. 按 `Alt+Shift+Q`；
4. 对照：同一行点左侧 gutter 的 SQL 预览图标。

## 预期

| 版本 | Alt+Shift+Q 结果 |
|---|---|
| 修复前 | 弹出「未在光标处找到可预览的 SQL 源」 |
| 修复后 | 弹出与 gutter 图标一致的预览：SQL 含 `FROM T_ACCOUNT_TYPE`，参数面板里 `accountType` 未解析 |

根因（已定位，本用例只做回归）：快捷键回落链的 iBatis 形状正则不放行 `@`，把调用让给了 JDBC 通道；
JDBC 认出后判定「不是 SQL」返回空，于是走了错源提示。gutter 图标走的是另一条识别链，所以不受影响。

## 环境备注

数据不连库也能预览——预览是静态渲染，只解析 XML 与语句名，不建立 JDBC 连接。
`AccountType.xml` 里的 `T_ACCOUNT_TYPE` 不需要在数据库里存在。

## 与主执行链的关系

`Ibatis2Main` / `Ibatis2ExecMain` 只跑 `User.xml` 的语句；`AccountType.xml` 只服务本用例的预览判定，
新增的接口方法也不被这两个入口调用。