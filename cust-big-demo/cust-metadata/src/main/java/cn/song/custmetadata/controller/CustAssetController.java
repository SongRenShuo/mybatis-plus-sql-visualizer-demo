package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustAsset;
import cn.song.custmetadata.service.CustAssetQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户资产查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custasset/page</li>
 *   <li>GET /api/cust/custasset/detail</li>
 *   <li>POST /api/cust/custasset/query</li>
 * </ul>
 */
public class CustAssetController {

    private final CustAssetQueryService queryService;

    public CustAssetController(CustAssetQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustAsset> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustAsset> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustAsset> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustAsset> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
