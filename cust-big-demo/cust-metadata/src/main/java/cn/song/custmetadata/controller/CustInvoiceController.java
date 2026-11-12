package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustInvoice;
import cn.song.custmetadata.service.CustInvoiceQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户发票查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custinvoice/page</li>
 *   <li>GET /api/cust/custinvoice/detail</li>
 *   <li>POST /api/cust/custinvoice/query</li>
 * </ul>
 */
public class CustInvoiceController {

    private final CustInvoiceQueryService queryService;

    public CustInvoiceController(CustInvoiceQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustInvoice> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustInvoice> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustInvoice> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustInvoice> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
