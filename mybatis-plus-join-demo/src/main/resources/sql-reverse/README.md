# SQL → Java 反向转换粘贴语料（插件 T-SqlToJavaPromote / T-MapResultVo 走查用）

用法：把各文件的 SQL 粘贴进插件「SQL → Java」面板的输入区，按各文件头部注释的
「预期」核对生成形态（生成目标以 MPJ wrapper 为主）。

| 文件 | 覆盖形态 | 预期生成 |
|---|---|---|
| 01-groupby-having.sql | GROUP BY + HAVING + 聚合列 | `.groupBy(...)` + `.having("聚合表达式")` 原样；`COUNT(*) AS cnt` 走 `.select("expr AS alias")` 回落 |
| 02-distinct-forupdate.sql | SELECT DISTINCT + FOR UPDATE 与 LIMIT 并存 | `select("DISTINCT a, b")`；FOR UPDATE 与 LIMIT 合并为单条 `.last("LIMIT ... FOR UPDATE")` |
| 03-union.sql | UNION / UNION ALL 子查询 | SQL 层往返还原；Java 生成层降级为原文注释（MP core 无 union()） |
| 04-apply-param.sql | `DATE_FORMAT(...)= '…'` 参数化 + 算术/`<=>`/ILIKE | `apply("DATE_FORMAT(...) = {0}", "2024")`；无法静态映射的降级 `apply()` 透传 |
| 05-dialect-tolerant.sql | 双引号标识符 / `0x` 十六进制 / `'a\'b'` / `DATE·TIMESTAMP '…'` ANSI 字面量 | 方言宽容解析，各自映射为标识符/数值/字符串/日期参数 |
| 06-join-multi-delete.sql | 可 lambda 化 JOIN + 字符串 ON JOIN + 多表 DELETE | `leftJoin(Sub.class, 副::getX, 主::getY)` 与 `leftJoin("address t1 ON 原文")` 双形态；多表 DELETE 带 deleteTargets |
| 07-insert-null.sql | INSERT ... NULL 值 | Java `null` 字面量（此前报错） |
| 08-return-family.sql | 同一查询 + 三种返回类型 | 返回类型自由输入派生：`List<Map<String,Object>>` → selectJoinMaps 族；`List<Object>` → selectObjs 族；VO 类名 → selectJoinList |

走查补充（面板侧操作，无独立语料文件）：
- 08 的「返回类型」字段逐个键入 `List<Map<String, Object>>` / `List<Object>` /
  `cn.song.mpjdemo.dto.UserDTO` 三态再生成，核对调用族派发；
- LIMIT 语句生成 `page(new Page<>(c, s), wrapper)` / selectPage（见 02 的 LIMIT 变体）。
