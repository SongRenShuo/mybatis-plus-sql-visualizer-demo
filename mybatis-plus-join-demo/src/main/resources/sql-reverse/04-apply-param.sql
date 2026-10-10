-- 04 参数化 apply 与降级形态（预期：DATE_FORMAT 参数化 apply("... = {0}", "2024")；算术/<=>/ILIKE 无法静态映射的降级 apply() 透传）
SELECT
    id,
    order_no,
    amount
FROM t_order
WHERE DATE_FORMAT(create_time, '%Y') = '2024'
  AND amount * 1.1 > 200
  AND remark <=> ''
  AND title ILIKE '%vip%'
  AND user_id IN (1, 2, 3)
