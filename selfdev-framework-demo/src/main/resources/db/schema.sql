-- selfdev-framework-demo 建表脚本（selfdev_demo 库，可重复执行）
-- 供模拟自研引擎（com.corp.engine / com.corp.meta）经原生 JDBC 读写

DROP TABLE IF EXISTS `biz_project_plan`;
CREATE TABLE `biz_project_plan` (
  `id`           BIGINT        NOT NULL AUTO_INCREMENT COMMENT '主键',
  `plan_id`      VARCHAR(64)   NOT NULL COMMENT '计划编号',
  `schema_code`  VARCHAR(64)   NOT NULL COMMENT '业务对象编码（模拟自研框架的 schemaCode）',
  `project_name` VARCHAR(128)  NOT NULL COMMENT '项目名称',
  `owner`        VARCHAR(64)   DEFAULT NULL COMMENT '负责人',
  `status`       TINYINT       NOT NULL DEFAULT 1 COMMENT '状态（0停用 1进行中 2已完成）',
  `amount`       DECIMAL(18,2) DEFAULT 0.00 COMMENT '金额',
  `create_time`  BIGINT        NOT NULL DEFAULT 0 COMMENT '创建时间（Unix 秒）',
  `update_time`  BIGINT        NOT NULL DEFAULT 0 COMMENT '更新时间（Unix 秒）',
  PRIMARY KEY (`id`),
  KEY `idx_plan_schema_code` (`schema_code`),
  KEY `idx_plan_status` (`status`),
  KEY `idx_plan_plan_id` (`plan_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = '项目计划表（模拟自研框架主表）';

DROP TABLE IF EXISTS `biz_project_member`;
CREATE TABLE `biz_project_member` (
  `id`          BIGINT      NOT NULL AUTO_INCREMENT COMMENT '主键',
  `plan_id`     VARCHAR(64) NOT NULL COMMENT '所属计划编号',
  `member_name` VARCHAR(64) DEFAULT NULL COMMENT '成员姓名',
  `role`        VARCHAR(32) DEFAULT NULL COMMENT '角色（OWNER 负责人 / DEV 开发 / QA 测试）',
  `status`      TINYINT     NOT NULL DEFAULT 1 COMMENT '状态（0停用 1启用）',
  PRIMARY KEY (`id`),
  KEY `idx_member_plan_id` (`plan_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = '项目成员表（JOIN 用例从表）';

INSERT INTO `biz_project_plan`
  (`id`, `plan_id`, `schema_code`, `project_name`, `owner`, `status`, `amount`, `create_time`, `update_time`) VALUES
(1, 'PLAN_2026001', 'SCHEMA_CODE_PROJECT_PLAN', '智能制造产线升级',   'zhangsan', 1, 1280000.00, 1758412800, 1758412800),
(2, 'PLAN_2026002', 'SCHEMA_CODE_PROJECT_PLAN', '供应链协同平台',     'lisi',     1,  860000.00, 1758416400, 1758416400),
(3, 'PLAN_2026003', 'SCHEMA_CODE_PROJECT_PLAN', '园区能耗监测',       'wangwu',   2,  320000.00, 1758420000, 1758420000),
(4, 'PLAN_2026004', 'SCHEMA_CODE_PROJECT_PLAN', '仓储自动化改造',     'zhaoliu',  1, 2140000.00, 1758423600, 1758423600),
(5, 'PLAN_2026005', 'SCHEMA_CODE_PROJECT_PLAN', '质量追溯体系',       'sunqi',    0,  150000.00, 1758427200, 1758427200),
(6, 'PLAN_2026006', 'SCHEMA_CODE_PROJECT_PLAN', '设备预测性维护',     'zhouba',   1,  980000.00, 1758430800, 1758430800);

INSERT INTO `biz_project_member` (`id`, `plan_id`, `member_name`, `role`, `status`) VALUES
(1, 'PLAN_2026001', 'zhangsan', 'OWNER', 1),
(2, 'PLAN_2026001', 'lisi',     'DEV',   1),
(3, 'PLAN_2026002', 'lisi',     'OWNER', 1),
(4, 'PLAN_2026002', 'wangwu',   'QA',    1),
(5, 'PLAN_2026004', 'zhaoliu',  'OWNER', 1),
(6, 'PLAN_2026006', 'zhouba',   'OWNER', 0);
