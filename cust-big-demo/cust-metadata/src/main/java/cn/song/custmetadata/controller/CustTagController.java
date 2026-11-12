package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustTag;
import cn.song.custmetadata.service.CustTagQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户标签查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custtag/page</li>
 *   <li>GET /api/cust/custtag/detail</li>
 *   <li>POST /api/cust/custtag/query</li>
 * </ul>
 */
public class CustTagController {

    private final CustTagQueryService queryService;

    public CustTagController(CustTagQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustTag> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustTag> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustTag> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustTag> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
