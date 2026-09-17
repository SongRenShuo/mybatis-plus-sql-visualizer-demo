-- multi-orm-demo 建表脚本（orm_demo 库，可重复执行）
DROP TABLE IF EXISTS `orm_member`;
CREATE TABLE `orm_member` (
  `id`     BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name`   VARCHAR(64)  NOT NULL COMMENT '成员名',
  `age`    INT          DEFAULT NULL COMMENT '年龄',
  `city`   VARCHAR(64)  DEFAULT NULL COMMENT '城市',
  `status` TINYINT      NOT NULL DEFAULT 1 COMMENT '状态（0禁用 1启用）',
  PRIMARY KEY (`id`),
  KEY `idx_orm_member_status` (`status`),
  KEY `idx_orm_member_city` (`city`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = '多 ORM 共用成员表';

INSERT INTO `orm_member` (`id`, `name`, `age`, `city`, `status`) VALUES
(1, 'zhangsan', 28, 'hangzhou', 1),
(2, 'lisi',     35, 'shanghai', 1),
(3, 'wangwu',   22, 'beijing',  0),
(4, 'zhaoliu',  41, 'shenzhen', 1);
