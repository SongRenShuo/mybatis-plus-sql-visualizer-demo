package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustOrderItem;
import cn.song.custmetadata.service.CustOrderItemQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户订单明细查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custorderitem/page</li>
 *   <li>GET /api/cust/custorderitem/detail</li>
 *   <li>POST /api/cust/custorderitem/query</li>
 * </ul>
 */
public class CustOrderItemController {

    private final CustOrderItemQueryService queryService;

    public CustOrderItemController(CustOrderItemQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustOrderItem> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustOrderItem> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustOrderItem> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustOrderItem> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
