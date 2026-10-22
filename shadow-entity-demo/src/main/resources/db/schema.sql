-- shadow-entity-demo：同包同名影子实体复现用例的建表/造数脚本（库 jpa_demo）
--
-- 只建**宿主影子版**的表 wms_task_project。JAR 版（shadow-entity-lib 里的
-- com.example.shadow.model.WmsTask，表 wms_task_jar）**刻意不建**：
-- 同 FQN 的类以工程输出（target/classes）为准，JAR 里那份运行期不生效，
-- 所以运行期只会用到 wms_task_project——这张表是否存在，本身就是「影子类生效」的证据。
--
-- 列清单与宿主影子类逐列对齐（对照插件预览应渲染出的列名）：
--   id / task_no / status / task_type / remark
-- 其中 task_type 是影子版把 JAR 版的 type 列改名后的结果，remark 是影子版独有的列。
--
-- 默认启动（ddl-auto=update）会自动建表/补列，本脚本供「手工初始化」与「对照真库列名」两用；
-- 自带 DROP，可重复执行（与仓库其它模块的 db/schema.sql 同约定）。

DROP TABLE IF EXISTS `wms_task_project`;

CREATE TABLE `wms_task_project`
(
    `id`        bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    `task_no`   varchar(64) DEFAULT NULL COMMENT '任务号',
    `status`    varchar(32) DEFAULT NULL COMMENT '状态（OP/PA/…）',
    `task_type` varchar(32) DEFAULT NULL COMMENT '任务类型（影子版把 JAR 版的 type 列改名而来）',
    `remark`    varchar(255) DEFAULT NULL COMMENT '备注（影子版独有列，JAR 版没有）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '影子实体复现表（宿主工程版）';

INSERT INTO `wms_task_project` (`task_no`, `status`, `task_type`, `remark`)
VALUES ('T001', 'OP', 'PU', 'seed：影子版一行，供三个调用点真跑返回 1 行');
