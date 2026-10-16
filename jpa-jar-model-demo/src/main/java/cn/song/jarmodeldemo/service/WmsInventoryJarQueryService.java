package cn.song.jarmodeldemo.service;

import cn.song.jarmodeldemo.dao.WmsJarCommonDao;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 库存查询服务——**宿主模块里唯一的 HQL 出处**（实体本身在依赖 JAR 里）。
 *
 * <p>HQL 里三条嵌入段路径是本用例的关键，真库列名由组件路径命名策略（component-path）
 * 推导（实测读数见模块 README）：
 * <ul>
 *   <li>{@code inv.qty.baseQty} → 列 {@code qty_base_qty}</li>
 *   <li>{@code inv.sku.inventoryStatus} → 列 {@code sku_inventory_status}</li>
 *   <li>{@code inv.itemKey.lotInfo.receivedDate} → 列 {@code item_key_lot_info_received_date}</li>
 * </ul>
 *
 * <p>插件预览应渲染出上面三个带前缀的列名；若渲染成 {@code base_qty} /
 * {@code inventory_status} / {@code received_date}（丢掉嵌入段前缀），即复现了报障缺陷——
 * 而且这里比 {@code jpa-embedded-prefix-demo} 更刁：实体源码不在本模块，插件拿不到模块根。
 *
 * <p>两种 HQL 承载形态各一条（插件应各亮一枚预览图标）：
 * <ol>
 *   <li>{@link #findAvailableJarInventory}——拼接变量（{@code String hql = "…" + "…"}）；</li>
 *   <li>{@link #findAvailableJarInventoryByBuffer}——StringBuffer 逐句 append + {@code sb.toString()}。</li>
 * </ol>
 *
 * @author SongRenShuo
 */
@Service
public class WmsInventoryJarQueryService {

    private final WmsJarCommonDao wmsJarCommonDao;

    public WmsInventoryJarQueryService(WmsJarCommonDao wmsJarCommonDao) {
        this.wmsJarCommonDao = wmsJarCommonDao;
    }

    /**
     * 按「仓库 + 库存状态 + 有基础数量 + 有收货时间」查可用库存——承载形态：**拼接变量**。
     */
    public List<?> findAvailableJarInventory(String warehouseId, String inventoryStatus) {
        String hql = "from WmsInventoryEntity inv "
                + "where inv.warehouseId = :warehouseId "
                + "and inv.sku.inventoryStatus = :inventoryStatus "
                + "and inv.qty.baseQty > 0 "
                + "and inv.itemKey.lotInfo.receivedDate is not null "
                + "order by inv.id";
        return wmsJarCommonDao.findByQueryMaxNum(
                hql,
                new String[]{"warehouseId", "inventoryStatus"},
                new Object[]{warehouseId, inventoryStatus},
                0,
                10);
    }

    /**
     * 同上——承载形态：**StringBuffer 逐句 append + {@code sb.toString()}**（对照用）。
     */
    public List<?> findAvailableJarInventoryByBuffer(String warehouseId, String inventoryStatus) {
        StringBuffer sb = new StringBuffer();
        sb.append("from WmsInventoryEntity inv ");
        sb.append("where inv.warehouseId = :warehouseId ");
        sb.append("and inv.sku.inventoryStatus = :inventoryStatus ");
        sb.append("and inv.qty.baseQty > 0 ");
        sb.append("and inv.itemKey.lotInfo.receivedDate is not null ");
        sb.append("order by inv.id");
        return wmsJarCommonDao.findByQueryMaxNum(
                sb.toString(),
                new String[]{"warehouseId", "inventoryStatus"},
                new Object[]{warehouseId, inventoryStatus},
                0,
                10);
    }
}
