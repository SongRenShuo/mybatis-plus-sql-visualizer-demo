package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustAuditLog;
import cn.song.custmetadata.service.CustAuditLogQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户审计日志查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custauditlog/page</li>
 *   <li>GET /api/cust/custauditlog/detail</li>
 *   <li>POST /api/cust/custauditlog/query</li>
 * </ul>
 */
public class CustAuditLogController {

    private final CustAuditLogQueryService queryService;

    public CustAuditLogController(CustAuditLogQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustAuditLog> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustAuditLog> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustAuditLog> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustAuditLog> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
