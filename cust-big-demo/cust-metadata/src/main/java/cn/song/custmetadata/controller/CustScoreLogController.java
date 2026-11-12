package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustScoreLog;
import cn.song.custmetadata.service.CustScoreLogQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户评分日志查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custscorelog/page</li>
 *   <li>GET /api/cust/custscorelog/detail</li>
 *   <li>POST /api/cust/custscorelog/query</li>
 * </ul>
 */
public class CustScoreLogController {

    private final CustScoreLogQueryService queryService;

    public CustScoreLogController(CustScoreLogQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustScoreLog> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustScoreLog> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustScoreLog> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustScoreLog> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
