-- jdk16_demo：JDK 1.6 + Spring Boot 1.5 语料库（与实体列逐列对齐，可重复执行）
-- Boot 1.x 对外部库也会在启动时执行本脚本（spring.datasource.initialize 默认 true，2.0 起才默认仅嵌入式库）
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
    `id`           BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`         VARCHAR(50)  NOT NULL COMMENT '姓名',
    `email`        VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
    `age`          INT          DEFAULT NULL COMMENT '年龄',
    `status`       TINYINT      NOT NULL DEFAULT 0 COMMENT '状态：0-正常 1-停用',
    `created_time` DATETIME     DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表（JDK 1.6 语料）';

-- 种子数据：两个 status 各一条，供列表 / 计数断言
INSERT INTO `user` (`name`, `email`, `age`, `status`, `created_time`) VALUES
    ('张三', 'zhangsan@example.com', 28, 0, NOW()),
    ('李四', 'lisi@example.com', 35, 1, NOW());
