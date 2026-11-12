package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustPayment;
import cn.song.custmetadata.service.CustPaymentQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户付款查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custpayment/page</li>
 *   <li>GET /api/cust/custpayment/detail</li>
 *   <li>POST /api/cust/custpayment/query</li>
 * </ul>
 */
public class CustPaymentController {

    private final CustPaymentQueryService queryService;

    public CustPaymentController(CustPaymentQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustPayment> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustPayment> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustPayment> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustPayment> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
