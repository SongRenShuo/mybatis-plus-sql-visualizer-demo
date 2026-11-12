package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustGroup;
import cn.song.custmetadata.service.CustGroupQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户群组查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custgroup/page</li>
 *   <li>GET /api/cust/custgroup/detail</li>
 *   <li>POST /api/cust/custgroup/query</li>
 * </ul>
 */
public class CustGroupController {

    private final CustGroupQueryService queryService;

    public CustGroupController(CustGroupQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustGroup> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustGroup> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustGroup> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustGroup> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
