-- =============================================================
-- mybatis-plus-demo 初始化脚本
-- 数据库：MySQL 5.7+ / 8.0
-- 使用前先创建库：CREATE DATABASE IF NOT EXISTS mp_demo DEFAULT CHARSET utf8mb4;
-- 执行：mysql -uroot -p mp_demo < schema.sql
-- =============================================================

USE mp_demo;

DROP TABLE IF EXISTS t_order;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS sys_config;

-- 用户表
CREATE TABLE `user` (
    `id`          INT          NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username`    VARCHAR(64)  NOT NULL COMMENT '姓名',
    `password`    VARCHAR(128) DEFAULT NULL COMMENT '密码',
    `age`         INT          DEFAULT NULL COMMENT '年龄',
    `email`       VARCHAR(128) DEFAULT NULL COMMENT '邮箱',
    `role_id`     INT          DEFAULT NULL COMMENT '角色ID',
    `dept_id`     INT          DEFAULT NULL COMMENT '部门ID',
    `status`      TINYINT      DEFAULT 1 COMMENT '状态（0禁用 1启用）',
    `create_time` DATETIME     DEFAULT NULL COMMENT '创建时间',
    `update_time` DATETIME     DEFAULT NULL COMMENT '更新时间',
    `deleted`     TINYINT      DEFAULT 0 COMMENT '逻辑删除（0未删除 1已删除）',
    `version`     INT          DEFAULT 0 COMMENT '乐观锁版本号',
    PRIMARY KEY (`id`),
    KEY `idx_username` (`username`),
    KEY `idx_role_id` (`role_id`),
    KEY `idx_dept_id` (`dept_id`)
) ENGINE = InnoDB COMMENT = '用户表';

-- 角色表
CREATE TABLE `role` (
    `id`          INT         NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`        VARCHAR(64) NOT NULL COMMENT '角色名称',
    `code`        VARCHAR(32) DEFAULT NULL COMMENT '角色编码',
    `description` VARCHAR(255) DEFAULT NULL COMMENT '角色描述',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '角色表';

-- 部门表
CREATE TABLE `department` (
    `id`        INT         NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`      VARCHAR(64) NOT NULL COMMENT '部门名称',
    `code`      VARCHAR(32) DEFAULT NULL COMMENT '部门编码',
    `parent_id` INT         DEFAULT NULL COMMENT '上级部门ID',
    `sort`      INT         DEFAULT 0 COMMENT '排序号',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '部门表';

-- 订单表
CREATE TABLE `t_order` (
    `id`          INT           NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_no`    VARCHAR(64)   NOT NULL COMMENT '订单编号',
    `user_id`     INT           DEFAULT NULL COMMENT '用户ID',
    `amount`      DECIMAL(10, 2) DEFAULT NULL COMMENT '订单金额',
    `status`      TINYINT       DEFAULT 0 COMMENT '状态（0待支付 1已支付 2已取消）',
    `create_time` DATETIME      DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_user_id` (`user_id`)
) ENGINE = InnoDB COMMENT = '订单表';

-- 系统配置表
CREATE TABLE `sys_config` (
    `id`           INT          NOT NULL AUTO_INCREMENT COMMENT '主键',
    `config_key`   VARCHAR(128) NOT NULL COMMENT '配置键',
    `config_value` VARCHAR(255) DEFAULT NULL COMMENT '配置值',
    `config_type`  INT          DEFAULT NULL COMMENT '配置类型（1系统配置 2业务配置 3安全配置，对应 ConfigTypeEnum @EnumValue code）',
    `remark`       VARCHAR(255) DEFAULT NULL COMMENT '备注',
    `sort_no`      INT          DEFAULT 0 COMMENT '排序号（@OrderBy 默认倒序）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '系统配置表';

-- 初始数据
INSERT INTO `role` (`id`, `name`, `code`, `description`) VALUES
(1, '管理员', 'ADMIN', '系统管理员'),
(2, '普通用户', 'USER', '普通用户'),
(3, '访客', 'GUEST', '游客');

INSERT INTO `department` (`id`, `name`, `code`, `parent_id`, `sort`) VALUES
(1, '技术部', 'TECH', NULL, 1),
(2, '产品部', 'PROD', NULL, 2),
(3, '前端组', 'FE', 1, 1);

INSERT INTO `user` (`id`, `username`, `password`, `age`, `email`, `role_id`, `dept_id`, `status`, `create_time`, `update_time`, `deleted`, `version`) VALUES
(1, 'admin', '123456', 30, 'admin@example.com', 1, 1, 1, NOW(), NOW(), 0, 0),
(2, 'zhangsan', '123456', 22, 'zhangsan@qq.com', 2, 1, 1, NOW(), NOW(), 0, 0),
(3, 'lisi', '123456', 25, 'lisi@163.com', 2, 2, 1, NOW(), NOW(), 0, 0),
(4, 'wangwu', '123456', 18, NULL, 3, 3, 0, NOW(), NOW(), 0, 0);

INSERT INTO `t_order` (`id`, `order_no`, `user_id`, `amount`, `status`, `create_time`) VALUES
(1, 'NO20260101001', 1, 199.90, 1, NOW()),
(2, 'NO20260101002', 1, 59.00, 0, NOW()),
(3, 'NO20260102001', 2, 299.00, 1, NOW()),
(4, 'NO20260102002', 3, 120.50, 2, NOW());

INSERT INTO `sys_config` (`id`, `config_key`, `config_value`, `config_type`, `remark`, `sort_no`) VALUES
(1, 'site.name', 'mp-demo', 1, '站点名称', 3),
(2, 'order.payTimeout', '30', 2, '订单支付超时时间（分钟）', 2),
(3, 'password.minLength', '6', 3, '密码最小长度', 1);
