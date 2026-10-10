-- 03 UNION / UNION ALL 子查询（预期：SQL 层往返还原；Java 生成层降级为原文注释——MP core 无 union()）
SELECT id, username, 'user' AS src FROM `user` WHERE status = 1
UNION
SELECT id, name AS username, 'admin' AS src FROM sys_admin WHERE enabled = 1
UNION ALL
SELECT id, nickname AS username, 'vip' AS src FROM vip_member WHERE level >= 3
ORDER BY id
