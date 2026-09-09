-- =============================================================
-- mybatis-plus-kotlin-demo 初始化脚本
-- 数据库：MySQL 5.7+ / 8.0
-- 使用前先创建库：CREATE DATABASE IF NOT EXISTS kotlin_demo DEFAULT CHARSET utf8mb4;
-- 执行：mysql -uroot -p kotlin_demo < schema.sql
-- =============================================================

USE kotlin_demo;

DROP TABLE IF EXISTS k_order;
DROP TABLE IF EXISTS k_user;

-- 用户表
CREATE TABLE `k_user` (
    `id`       INT          NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username` VARCHAR(64)  NOT NULL COMMENT '用户名',
    `email`    VARCHAR(128) DEFAULT NULL COMMENT '邮箱',
    `age`      INT          DEFAULT NULL COMMENT '年龄',
    `dept_id`  INT          DEFAULT NULL COMMENT '部门ID',
    `status`   TINYINT      DEFAULT 1 COMMENT '状态（0禁用 1启用）',
    `deleted`  TINYINT      DEFAULT 0 COMMENT '逻辑删除（0未删除 1已删除）',
    `version`  INT          DEFAULT 0 COMMENT '乐观锁版本号',
    PRIMARY KEY (`id`),
    KEY `idx_username` (`username`),
    KEY `idx_dept_id` (`dept_id`)
) ENGINE = InnoDB COMMENT = '用户表';

-- 订单表
CREATE TABLE `k_order` (
    `id`       INT            NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_no` VARCHAR(64)    NOT NULL COMMENT '订单号',
    `user_id`  INT            DEFAULT NULL COMMENT '下单用户ID',
    `amount`   DECIMAL(10, 2) DEFAULT NULL COMMENT '金额',
    `status`   TINYINT        DEFAULT 0 COMMENT '状态（0待支付 1已支付 2已取消）',
    PRIMARY KEY (`id`),
    KEY `idx_user_id` (`user_id`)
) ENGINE = InnoDB COMMENT = '订单表';

-- 初始数据（覆盖场景分支：禁用且无邮箱用户供 removeDisabled、部门重复供 groupByDept having、
-- 9/10 号部门供 notIn 排除、test.com 邮箱供 notLike、多状态订单供 paidOrdersAbove）
INSERT INTO `k_user` (`id`, `username`, `email`, `age`, `dept_id`, `status`, `deleted`, `version`) VALUES
(1, 'admin',    'admin@example.com', 30, 1,  1, 0, 0),
(2, 'zhangsan', 'zhangsan@qq.com',   22, 1,  1, 0, 0),
(3, 'lisi',     'lisi@163.com',      25, 2,  1, 0, 0),
(4, 'wangwu',   NULL,                18, 3,  0, 0, 0),
(5, 'zhaoliu',  'zhaoliu@qq.com',    28, 2,  1, 0, 0),
(6, 'songqi',   'songqi@test.com',   35, 3,  1, 0, 0),
(7, 'sunba',    NULL,                40, 9,  1, 0, 0),
(8, 'zhoujiu',  'zhoujiu@qq.com',    16, 10, 1, 0, 0);

INSERT INTO `k_order` (`id`, `order_no`, `user_id`, `amount`, `status`) VALUES
(1, 'NO20260101001', 1, 199.90, 1),
(2, 'NO20260101002', 1, 59.00,  0),
(3, 'NO20260102001', 2, 299.00, 1),
(4, 'NO20260102002', 3, 120.50, 2),
(5, 'NO20260103001', 5, 88.88,  1),
(6, 'NO20260103002', 6, 1000.00, 1),
(7, 'NO20260104001', 7, 45.00,  2);
