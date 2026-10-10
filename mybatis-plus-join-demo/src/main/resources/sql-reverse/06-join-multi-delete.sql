-- 06 JOIN 双形态 + 多表 DELETE（预期：可 lambda 化走 leftJoin(Sub.class, 副::getX, 主::getY)；字符串 ON 走 leftJoin("address t1 ON 原文")；多表 DELETE 带 deleteTargets）
SELECT
    u.id,
    u.username,
    a.tel
FROM `user` u
LEFT JOIN user_address a ON a.user_id = u.id
LEFT JOIN user_area t1 ON t1.user_pin = CONCAT(u.username, '@p')

-- 多表 DELETE：别名清单应进 deleteTargets，不丢表
DELETE u, a
FROM `user` u
JOIN user_address a ON a.user_id = u.id
WHERE u.status = 9
