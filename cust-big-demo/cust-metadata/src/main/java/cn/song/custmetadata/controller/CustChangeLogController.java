package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustChangeLog;
import cn.song.custmetadata.service.CustChangeLogQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户变更日志查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custchangelog/page</li>
 *   <li>GET /api/cust/custchangelog/detail</li>
 *   <li>POST /api/cust/custchangelog/query</li>
 * </ul>
 */
public class CustChangeLogController {

    private final CustChangeLogQueryService queryService;

    public CustChangeLogController(CustChangeLogQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustChangeLog> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustChangeLog> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustChangeLog> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustChangeLog> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
