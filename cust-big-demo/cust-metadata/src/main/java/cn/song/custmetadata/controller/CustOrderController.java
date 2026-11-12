package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustOrder;
import cn.song.custmetadata.service.CustOrderQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户订单查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custorder/page</li>
 *   <li>GET /api/cust/custorder/detail</li>
 *   <li>POST /api/cust/custorder/query</li>
 * </ul>
 */
public class CustOrderController {

    private final CustOrderQueryService queryService;

    public CustOrderController(CustOrderQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustOrder> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustOrder> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustOrder> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustOrder> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
