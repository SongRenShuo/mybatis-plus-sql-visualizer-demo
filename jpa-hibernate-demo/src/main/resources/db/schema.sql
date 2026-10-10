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
DROP TABLE IF EXISTS wms_asn;
DROP TABLE IF EXISTS wms_dock_booking;
DROP TABLE IF EXISTS legacy_item;

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

-- 预约单表（WmsAsn，HQL LEFT JOIN 关联目标）
CREATE TABLE `wms_asn` (
    `id`           BIGINT      NOT NULL AUTO_INCREMENT COMMENT '主键（join键）',
    `asn_code`     VARCHAR(64) DEFAULT NULL COMMENT '预约单号',
    `warehouse_id` VARCHAR(32) DEFAULT NULL COMMENT '仓库ID',
    `create_time`  DATETIME    DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '预约单表';

-- 入库预约单表（WmsDockBooking，含 @Embedded 内嵌列 created_time）
CREATE TABLE `wms_dock_booking` (
    `id`              BIGINT      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `related_bill_id` BIGINT      DEFAULT NULL COMMENT '关联单据ID（LEFT JOIN WmsAsn 的关联键）',
    `warehouse_id`    VARCHAR(32) DEFAULT NULL COMMENT '仓库ID',
    `status`          VARCHAR(8)  DEFAULT NULL COMMENT '状态（F=已完成 P=进行中）',
    `type`            VARCHAR(8)  DEFAULT NULL COMMENT '类型（R=入库）',
    `arrival_time`    DATETIME    DEFAULT NULL COMMENT '到达时间',
    `initial_eta`     DATETIME    DEFAULT NULL COMMENT '初始预计到达时间',
    `latest_eta`      DATETIME    DEFAULT NULL COMMENT '最新预计到达时间',
    `atd`             DATETIME    DEFAULT NULL COMMENT '实际发车时间',
    `created_time`    DATETIME    DEFAULT NULL COMMENT '最后更新时间（内嵌 updateInfo.createdTime）',
    PRIMARY KEY (`id`),
    KEY `idx_wdb_related_bill_id` (`related_bill_id`)
) ENGINE = InnoDB COMMENT = '入库预约单表';

-- 遗留库存项表（LegacyItem，hbm.xml 映射，见 resources/hbm/LegacyItem.hbm.xml）
CREATE TABLE `legacy_item` (
    `id`         BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `item_code`  VARCHAR(64)  DEFAULT NULL COMMENT '物料编码',
    `item_name`  VARCHAR(128) DEFAULT NULL COMMENT '物料名称',
    `quantity`   INT          DEFAULT NULL COMMENT '库存数量',
    `deprecated` TINYINT(1)   DEFAULT NULL COMMENT '是否已废弃',
    `in_time`    DATETIME     DEFAULT NULL COMMENT '入库时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '遗留库存项表';

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

INSERT INTO `wms_asn` (`id`, `asn_code`, `warehouse_id`, `create_time`) VALUES
(1, 'ASN20260101001', 'WH01', NOW()),
(2, 'ASN20260101002', 'WH01', NOW()),
(3, 'ASN20260102001', 'WH02', NOW());

INSERT INTO `wms_dock_booking` (`id`, `related_bill_id`, `warehouse_id`, `status`, `type`, `arrival_time`, `initial_eta`, `latest_eta`, `atd`, `created_time`) VALUES
(1, 1, 'WH01', 'F', 'R', NOW(), NOW(), NOW(), NOW(), NOW()),
(2, 2, 'WH01', 'P', 'R', NULL, NOW(), NOW(), NULL, NOW()),
(3, NULL, 'WH02', 'P', 'R', NULL, NOW(), NOW(), NULL, NOW());

INSERT INTO `legacy_item` (`id`, `item_code`, `item_name`, `quantity`, `deprecated`, `in_time`) VALUES
(1, 'MAT001', '螺栓', 100, 0, NOW()),
(2, 'MAT002', '垫片', 5, 0, NOW()),
(3, 'MAT003', '旧款支架', 0, 1, NOW());

-- 嵌套嵌入深水区实体（T-Embedded G1/G2 语料）：列面=覆写/前缀口径（cust_street/cust_zip/biz_*/fallback_*）
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
    `id`                 BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`               VARCHAR(64)  DEFAULT NULL COMMENT '名称',
    `cust_street`        VARCHAR(128) DEFAULT NULL COMMENT '地址街道（类级根点路径覆写 address.street）',
    `cust_zip`           VARCHAR(16)  DEFAULT NULL COMMENT '邮编（字段级相对点路径覆写 zipcode.zip）',
    `area_code`          VARCHAR(16)  DEFAULT NULL COMMENT '区域代码（嵌套裸列兜底）',
    `biz_street`         VARCHAR(128) DEFAULT NULL COMMENT '经营地址街道（SD prefix=biz_）',
    `biz_zip`            VARCHAR(16)  DEFAULT NULL COMMENT '经营地址邮编（SD prefix=biz_）',
    `biz_area_code`      VARCHAR(16)  DEFAULT NULL COMMENT '经营地址区域代码（SD prefix=biz_）',
    `created_time`       DATETIME     DEFAULT NULL COMMENT '联系信息更新时间（@Embedded.Nullable 捷径）',
    `zip`                VARCHAR(16)  DEFAULT NULL COMMENT '兜底邮编（@Embedded.Empty 捷径）',
    `fallback_area_code` VARCHAR(16)  DEFAULT NULL COMMENT '兜底区域代码（@Embedded.Empty 捷径，JPA 覆写防撞）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = '嵌套嵌入深水区语料';

INSERT INTO `customer` (`id`, `name`, `cust_street`, `cust_zip`, `area_code`, `biz_street`, `biz_zip`, `biz_area_code`, `created_time`, `zip`, `fallback_area_code`) VALUES
(1, '客户A', '南京东路 1 号', '200001', '021', '中山东一路 3 号', '200002', '021', NOW(), '200001', '021'),
(2, '客户B', '延安西路 100 号', '200040', '021', '静安寺 5 号', '200040', '021', NULL, NULL, '021');
