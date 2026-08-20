-- =============================================================
-- jpa-hibernate-demo 初始化脚本
-- 数据库：MySQL 5.7+ / 8.0
-- 使用前先创建库：CREATE DATABASE IF NOT EXISTS jpa_demo DEFAULT CHARSET utf8mb4;
-- 执行：mysql -uroot -p jpa_demo < schema.sql
-- 提示：application.yml 配置了 spring.jpa.hibernate.ddl-auto=update，
--       表结构可由 Hibernate 自动生成；本脚本用于显式建表 + 初始化数据。
-- =============================================================

USE jpa_demo;

DROP TABLE IF EXISTS t_order;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS department;

-- 用户表
CREATE TABLE `user` (
    `id`            BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username`      VARCHAR(64)  NOT NULL COMMENT '用户名',
    `email`         VARCHAR(128) DEFAULT NULL COMMENT '邮箱',
    `first_name`    VARCHAR(64)  DEFAULT NULL COMMENT '姓',
    `last_name`     VARCHAR(64)  DEFAULT NULL COMMENT '名',
    `age`           INT          DEFAULT NULL COMMENT '年龄',
    `status`        TINYINT      DEFAULT 1 COMMENT '状态（0禁用 1启用）',
    `department_id` BIGINT       DEFAULT NULL COMMENT '部门ID',
    `create_time`   DATETIME     DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_username` (`username`),
    KEY `idx_department_id` (`department_id`)
) ENGINE = InnoDB COMMENT = '用户表';

-- 部门表
CREATE TABLE `department` (
    `id`        BIGINT      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`      VARCHAR(64) NOT NULL COMMENT '部门名称',
    `code`      VARCHAR(32) DEFAULT NULL COMMENT '部门编码',
    `parent_id` BIGINT      DEFAULT NULL COMMENT '上级部门ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '部门表';

-- 订单表（自定义表名 t_order）
CREATE TABLE `t_order` (
    `id`           BIGINT         NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_no`     VARCHAR(64)    NOT NULL COMMENT '订单编号',
    `customer_id`  BIGINT         DEFAULT NULL COMMENT '客户ID',
    `total_amount` DECIMAL(10, 2) DEFAULT NULL COMMENT '订单总金额',
    `create_time`  DATETIME       DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_customer_id` (`customer_id`)
) ENGINE = InnoDB COMMENT = '订单表';

-- 初始数据
INSERT INTO `department` (`id`, `name`, `code`, `parent_id`) VALUES
(1, '技术部', 'TECH', NULL),
(2, '产品部', 'PROD', NULL),
(3, '市场部', 'MKT', NULL);

INSERT INTO `user` (`id`, `username`, `email`, `first_name`, `last_name`, `age`, `status`, `department_id`, `create_time`) VALUES
(1, 'admin', 'admin@example.com', '管', '理员', 30, 1, 1, NOW()),
(2, 'zhangsan', 'zhangsan@qq.com', '张', '三', 22, 1, 1, NOW()),
(3, 'lisi', 'lisi@163.com', '李', '四', 25, 1, 2, NOW()),
(4, 'wangwu', NULL, '王', '五', 18, 0, 3, NOW()),
(5, 'zhaoliu', 'zhaoliu@qq.com', '赵', '六', 35, 1, 2, NOW());

INSERT INTO `t_order` (`id`, `order_no`, `customer_id`, `total_amount`, `create_time`) VALUES
(1, 'JP20260101001', 1, 199.90, NOW()),
(2, 'JP20260101002', 2, 599.00, NOW()),
(3, 'JP20260102001', 2, 59.00, NOW()),
(4, 'JP20260102002', 3, 899.00, NOW());
