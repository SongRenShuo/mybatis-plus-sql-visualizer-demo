package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustScale;
import cn.song.custmetadata.service.CustScaleQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户规模查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custscale/page</li>
 *   <li>GET /api/cust/custscale/detail</li>
 *   <li>POST /api/cust/custscale/query</li>
 * </ul>
 */
public class CustScaleController {

    private final CustScaleQueryService queryService;

    public CustScaleController(CustScaleQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustScale> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustScale> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustScale> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustScale> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
