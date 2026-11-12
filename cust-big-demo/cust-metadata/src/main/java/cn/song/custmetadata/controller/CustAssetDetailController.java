package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustAssetDetail;
import cn.song.custmetadata.service.CustAssetDetailQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户资产明细查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custassetdetail/page</li>
 *   <li>GET /api/cust/custassetdetail/detail</li>
 *   <li>POST /api/cust/custassetdetail/query</li>
 * </ul>
 */
public class CustAssetDetailController {

    private final CustAssetDetailQueryService queryService;

    public CustAssetDetailController(CustAssetDetailQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustAssetDetail> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustAssetDetail> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustAssetDetail> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustAssetDetail> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
