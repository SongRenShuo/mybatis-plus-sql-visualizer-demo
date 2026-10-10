-- 05 方言宽容（预期：双引号标识符按标识符解析；0x 十六进制为数值；'a\'b' 反斜杠转义字符串；DATE/TIMESTAMP ANSI 类型字面量）
SELECT
    "member".id,
    "member".name
FROM "member"
WHERE "member".flag = 0x1F
  AND "member".memo = 'a\'b'
  AND "member".created >= DATE '2024-01-01'
  AND "member".updated >= TIMESTAMP '2024-06-01 09:30:00'
