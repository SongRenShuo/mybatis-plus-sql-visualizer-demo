package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustCreditScore;
import cn.song.custmetadata.service.CustCreditScoreQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户信用评分查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custcreditscore/page</li>
 *   <li>GET /api/cust/custcreditscore/detail</li>
 *   <li>POST /api/cust/custcreditscore/query</li>
 * </ul>
 */
public class CustCreditScoreController {

    private final CustCreditScoreQueryService queryService;

    public CustCreditScoreController(CustCreditScoreQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustCreditScore> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustCreditScore> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustCreditScore> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustCreditScore> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
