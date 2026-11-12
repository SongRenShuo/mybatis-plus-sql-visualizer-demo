package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustRiskEval;
import cn.song.custmetadata.service.CustRiskEvalQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户风险评估查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custriskeval/page</li>
 *   <li>GET /api/cust/custriskeval/detail</li>
 *   <li>POST /api/cust/custriskeval/query</li>
 * </ul>
 */
public class CustRiskEvalController {

    private final CustRiskEvalQueryService queryService;

    public CustRiskEvalController(CustRiskEvalQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustRiskEval> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustRiskEval> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustRiskEval> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustRiskEval> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
