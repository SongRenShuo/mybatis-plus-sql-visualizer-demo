-- jpa-embedded-prefix-demo：@Embedded 嵌入列前缀复现表（库 jpa_demo）
--
-- 列名是 Hibernate 组件路径命名策略（component-path）的产物，也是插件预览应当渲染出的名字：
--   moveTool.palletNo → move_tool_pallet_no
--   qty.baseQty       → qty_base_qty
--
-- 默认启动（ddl-auto=update）会自动建表/补列，本脚本供「手工初始化」与「对照真库列名」两用；
-- 自带 DROP，可重复执行（与仓库其它模块的 db/schema.sql 同约定）。

DROP TABLE IF EXISTS `wms_inventory_embed_demo`;

CREATE TABLE `wms_inventory_embed_demo`
(
    `id`                  bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    `warehouse_id`        varchar(32) DEFAULT NULL COMMENT '仓库ID（普通列，对照组）',
    `move_tool_pallet_no` varchar(64) DEFAULT NULL COMMENT '托盘号（@Embedded moveTool.palletNo）',
    `qty_base_qty`        bigint(20)  DEFAULT NULL COMMENT '基础数量（@Embedded qty.baseQty）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '嵌入列前缀复现表';

INSERT INTO `wms_inventory_embed_demo` (`warehouse_id`, `move_tool_pallet_no`, `qty_base_qty`)
VALUES ('W01', 'P001', 120);

INSERT INTO `wms_inventory_embed_demo` (`warehouse_id`, `move_tool_pallet_no`, `qty_base_qty`)
VALUES ('W01', 'P002', 0);
