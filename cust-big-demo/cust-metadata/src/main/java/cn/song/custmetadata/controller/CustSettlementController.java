package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustSettlement;
import cn.song.custmetadata.service.CustSettlementQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户结算查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custsettlement/page</li>
 *   <li>GET /api/cust/custsettlement/detail</li>
 *   <li>POST /api/cust/custsettlement/query</li>
 * </ul>
 */
public class CustSettlementController {

    private final CustSettlementQueryService queryService;

    public CustSettlementController(CustSettlementQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustSettlement> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustSettlement> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustSettlement> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustSettlement> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
