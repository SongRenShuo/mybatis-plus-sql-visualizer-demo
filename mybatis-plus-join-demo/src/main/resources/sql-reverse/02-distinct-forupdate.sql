-- 02 SELECT DISTINCT + FOR UPDATE 与 LIMIT 并存（预期：select("DISTINCT a, b")；FOR UPDATE 与 LIMIT 合并为单条 last）
SELECT DISTINCT
    u.id,
    u.username
FROM `user` u
WHERE u.status = 1
ORDER BY u.id
LIMIT 5
FOR UPDATE
