-- 01 GROUP BY + HAVING + 聚合列（预期：groupBy() + having("...") 原样聚合表达式；COUNT(*) AS cnt 走 select("expr AS alias") 回落）
SELECT
    u.department_id,
    COUNT(*) AS cnt,
    MAX(o.amount) AS max_amount
FROM `user` u
JOIN t_order o ON o.user_id = u.id
WHERE u.deleted = 0
GROUP BY u.department_id
HAVING COUNT(*) > 3 AND MAX(o.amount) >= 100
ORDER BY cnt DESC
