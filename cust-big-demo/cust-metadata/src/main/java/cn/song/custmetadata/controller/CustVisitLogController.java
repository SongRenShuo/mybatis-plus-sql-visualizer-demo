package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustVisitLog;
import cn.song.custmetadata.service.CustVisitLogQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户拜访记录查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custvisitlog/page</li>
 *   <li>GET /api/cust/custvisitlog/detail</li>
 *   <li>POST /api/cust/custvisitlog/query</li>
 * </ul>
 */
public class CustVisitLogController {

    private final CustVisitLogQueryService queryService;

    public CustVisitLogController(CustVisitLogQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustVisitLog> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustVisitLog> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustVisitLog> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustVisitLog> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
