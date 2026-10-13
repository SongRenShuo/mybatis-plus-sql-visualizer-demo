package cn.song.embedprefixdemo.service;

import cn.song.embedprefixdemo.dao.CommonDao;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 库存查询服务——**用户报障形态的复刻**。
 *
 * HQL 里两个嵌入段路径是本用例的关键：
 *  - `inv.moveTool.palletNo` → 真库列 `move_tool_pallet_no`
 *  - `inv.qty.baseQty`       → 真库列 `qty_base_qty`
 *
 * 调用形态也照搬报障：拼接 HQL + `new String[]{...}` / `new Object[]{...}` 双数组 + 分页参数
 * （插件侧走 CustomDaoHqlLocator 的 NAME_VALUE_ARRAYS 分支）。
 *
 * 插件预览应渲染出 `inv.move_tool_pallet_no` / `inv.qty_base_qty`；若渲染成
 * `inv.pallet_no` / `inv.base_qty` 即是本用例要复现的缺陷。
 *
 * 本类刻意备齐**三种 HQL 承载形态**（插件应全部支持，每种都应有预览图标）：
 *  1. {@link #findAvailableInventory}——拼接变量（`String hql = "…" + "…"`）；
 *  2. {@link #findAvailableInventoryByBuffer}——StringBuffer 逐句 append + `sb.toString()`；
 *  3. {@link #findAvailableInventoryViaHelper}——方法返回（`buildAvailableInventoryHql()`）。
 *
 * 其中第 3 种是用户报障点：首参写成方法调用时，插件一度既不亮图标、快捷键预览也失败
 * （`locate` 返回 null）。该形态已作为能力落地（T-HqlHelperReturn：跟随源码可见方法的
 * `return` 表达式聚合），插件仓门禁 `DemoEmbeddedPrefixReproAnchorTest` 钉住三者各恰 1 枚图标。
 *
 * @author SongRenShuo
 */
@Service
public class WmsInventoryQueryService {

    private final CommonDao commonDao;

    public WmsInventoryQueryService(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    /**
     * 按「仓库 + 托盘号 + 有库存」查可用库存——承载形态：**拼接变量**。
     */
    public List<?> findAvailableInventory(String warehouseId, String palletNo) {
        String hql = "from WmsInventoryEntity inv "
                + "where inv.warehouseId = :warehouseId "
                + "and inv.moveTool.palletNo = :palletNo "
                + "and inv.qty.baseQty > 0 "
                + "order by inv.id";
        return commonDao.findByQueryMaxNum(
                hql,
                new String[]{"warehouseId", "palletNo"},
                new Object[]{warehouseId, palletNo},
                0,
                10);
    }

    /**
     * 同上——承载形态：**StringBuffer 逐句 append + `sb.toString()`**（T-HqlBufConcat 形态）。
     */
    public List<?> findAvailableInventoryByBuffer(String warehouseId, String palletNo) {
        StringBuffer sb = new StringBuffer();
        sb.append("from WmsInventoryEntity inv ");
        sb.append("where inv.warehouseId = :warehouseId ");
        sb.append("and inv.moveTool.palletNo = :palletNo ");
        sb.append("and inv.qty.baseQty > 0 ");
        sb.append("order by inv.id");
        return commonDao.findByQueryMaxNum(
                sb.toString(),
                new String[]{"warehouseId", "palletNo"},
                new Object[]{warehouseId, palletNo},
                0,
                10);
    }

    /**
     * 同上——承载形态：**方法返回**（HQL 由 {@link #buildAvailableInventoryHql()} 拼好再传入）。
     */
    public List<?> findAvailableInventoryViaHelper(String warehouseId, String palletNo) {
        return commonDao.findByQueryMaxNum(
                buildAvailableInventoryHql(),
                new String[]{"warehouseId", "palletNo"},
                new Object[]{warehouseId, palletNo},
                0,
                10);
    }

    /**
     * HQL 拼装（被 {@link #findAvailableInventoryViaHelper} 的调用跟随取用）。
     */
    private String buildAvailableInventoryHql() {
        return "from WmsInventoryEntity inv "
                + "where inv.warehouseId = :warehouseId "
                + "and inv.moveTool.palletNo = :palletNo "
                + "and inv.qty.baseQty > 0 "
                + "order by inv.id";
    }
}
