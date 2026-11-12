package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustPreference;
import cn.song.custmetadata.service.CustPreferenceQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户偏好查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custpreference/page</li>
 *   <li>GET /api/cust/custpreference/detail</li>
 *   <li>POST /api/cust/custpreference/query</li>
 * </ul>
 */
public class CustPreferenceController {

    private final CustPreferenceQueryService queryService;

    public CustPreferenceController(CustPreferenceQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustPreference> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustPreference> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustPreference> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustPreference> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
