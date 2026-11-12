package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustBankAcct;
import cn.song.custmetadata.service.CustBankAcctQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户银行账户查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custbankacct/page</li>
 *   <li>GET /api/cust/custbankacct/detail</li>
 *   <li>POST /api/cust/custbankacct/query</li>
 * </ul>
 */
public class CustBankAcctController {

    private final CustBankAcctQueryService queryService;

    public CustBankAcctController(CustBankAcctQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustBankAcct> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustBankAcct> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustBankAcct> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustBankAcct> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
