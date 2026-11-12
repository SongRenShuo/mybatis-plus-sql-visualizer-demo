package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustRiskItem;
import cn.song.custmetadata.service.CustRiskItemQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户风险项查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custriskitem/page</li>
 *   <li>GET /api/cust/custriskitem/detail</li>
 *   <li>POST /api/cust/custriskitem/query</li>
 * </ul>
 */
public class CustRiskItemController {

    private final CustRiskItemQueryService queryService;

    public CustRiskItemController(CustRiskItemQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustRiskItem> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustRiskItem> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustRiskItem> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustRiskItem> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
