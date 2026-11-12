package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustFollowUp;
import cn.song.custmetadata.service.CustFollowUpQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户跟进查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custfollowup/page</li>
 *   <li>GET /api/cust/custfollowup/detail</li>
 *   <li>POST /api/cust/custfollowup/query</li>
 * </ul>
 */
public class CustFollowUpController {

    private final CustFollowUpQueryService queryService;

    public CustFollowUpController(CustFollowUpQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustFollowUp> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustFollowUp> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustFollowUp> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustFollowUp> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
