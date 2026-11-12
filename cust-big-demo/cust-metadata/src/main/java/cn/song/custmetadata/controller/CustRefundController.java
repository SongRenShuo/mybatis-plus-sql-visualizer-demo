package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustRefund;
import cn.song.custmetadata.service.CustRefundQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户退款查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custrefund/page</li>
 *   <li>GET /api/cust/custrefund/detail</li>
 *   <li>POST /api/cust/custrefund/query</li>
 * </ul>
 */
public class CustRefundController {

    private final CustRefundQueryService queryService;

    public CustRefundController(CustRefundQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustRefund> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustRefund> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustRefund> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustRefund> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
