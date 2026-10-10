-- 07 INSERT 含 NULL 值（预期：NULL 建模生成 Java null，不再报错）
INSERT INTO t_order (order_no, user_id, amount, remark, discount_id)
VALUES ('NO-2024-001', 1, 99.90, NULL, NULL)
