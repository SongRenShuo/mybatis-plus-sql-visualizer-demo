package cn.song.embedprefixdemo.service;

import cn.song.embedprefixdemo.dao.CommonDao;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 库位/库存查询服务——**用户报障形态的复刻**。
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
 * @author SongRenShuo
 */
@Service
public class WmsInventoryQueryService {

    private final CommonDao commonDao;

    public WmsInventoryQueryService(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    /**
     * 模块 README 验收清单第 1 步要预览的就是本方法里的这条 HQL。
     */
    public String buildAvailableInventoryHql() {
        return "from WmsInventoryEntity inv "
                + "where inv.warehouseId = :warehouseId "
                + "and inv.moveTool.palletNo = :palletNo "
                + "and inv.qty.baseQty > 0 "
                + "order by inv.id";
    }

    /**
     * 按「仓库 + 托盘号 + 有库存」查可用库存（复刻用户报障调用）。
     */
    public List<?> findAvailableInventory(String warehouseId, String palletNo) {
        return commonDao.findByQueryMaxNum(
                buildAvailableInventoryHql(),
                new String[]{"warehouseId", "palletNo"},
                new Object[]{warehouseId, palletNo},
                0,
                10);
    }
}
