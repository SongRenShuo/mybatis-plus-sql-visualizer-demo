-- jpa-jar-model-demo：实体/嵌入类来自依赖 JAR 的嵌入列命名复现表（库 jpa_demo）
--
-- 列名是 Hibernate 组件路径命名策略（component-path）的产物，也是插件预览应当渲染出的名字：
--   qty.baseQty                       → qty_base_qty
--   sku.inventoryStatus               → sku_inventory_status
--   itemKey.lotInfo.receivedDate      → item_key_lot_info_received_date
--
-- 注意第三条：component-path 会把**每一段**属性路径都并进列名（Hibernate 5.6.4 源码
-- ImplicitNamingStrategyComponentPathImpl.process() 递归到 parent 并用 '_' 连接；
-- 路径本身来自 BinderHelper.getRelativePath()，是相对实体根的完整链），
-- 所以是 item_key_lot_info_received_date，而不是 lot_info_received_date。
--
-- 默认启动（ddl-auto=update）会自动建表/补列，本脚本供「手工初始化」与「对照真库列名」两用；
-- 自带 DROP，可重复执行（与仓库其它模块的 db/schema.sql 同约定）。

DROP TABLE IF EXISTS `wms_inventory_jar_demo`;

CREATE TABLE `wms_inventory_jar_demo`
(
    `id`                             bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    `warehouse_id`                   varchar(32) DEFAULT NULL COMMENT '仓库ID（普通列，对照组）',
    `qty_base_qty`                   bigint(20)  DEFAULT NULL COMMENT '基础数量（@Embedded qty.baseQty）',
    `sku_inventory_status`           varchar(255) DEFAULT NULL COMMENT '库存状态（@Embedded sku.inventoryStatus）',
    `item_key_lot_info_received_date` datetime(6) DEFAULT NULL COMMENT '收货时间（@Embedded itemKey.lotInfo.receivedDate，二层嵌套）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '实体来自依赖 JAR 的嵌入列命名复现表';

INSERT INTO `wms_inventory_jar_demo`
(`warehouse_id`, `qty_base_qty`, `sku_inventory_status`, `item_key_lot_info_received_date`)
VALUES ('W01', 120, 'IN_STOCK', '2026-01-01 08:30:00');

INSERT INTO `wms_inventory_jar_demo`
(`warehouse_id`, `qty_base_qty`, `sku_inventory_status`, `item_key_lot_info_received_date`)
VALUES ('W01', 0, 'IN_STOCK', '2026-01-01 08:30:00');

INSERT INTO `wms_inventory_jar_demo`
(`warehouse_id`, `qty_base_qty`, `sku_inventory_status`, `item_key_lot_info_received_date`)
VALUES ('W02', 55, 'FROZEN', '2026-01-01 08:30:00');
