package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustGroupRel;
import cn.song.custmetadata.service.CustGroupRelQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户群组关系查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custgrouprel/page</li>
 *   <li>GET /api/cust/custgrouprel/detail</li>
 *   <li>POST /api/cust/custgrouprel/query</li>
 * </ul>
 */
public class CustGroupRelController {

    private final CustGroupRelQueryService queryService;

    public CustGroupRelController(CustGroupRelQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustGroupRel> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustGroupRel> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustGroupRel> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustGroupRel> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
