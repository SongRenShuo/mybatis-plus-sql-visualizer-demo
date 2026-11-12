package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustManagerRel;
import cn.song.custmetadata.service.CustManagerRelQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户经理关系查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custmanagerrel/page</li>
 *   <li>GET /api/cust/custmanagerrel/detail</li>
 *   <li>POST /api/cust/custmanagerrel/query</li>
 * </ul>
 */
public class CustManagerRelController {

    private final CustManagerRelQueryService queryService;

    public CustManagerRelController(CustManagerRelQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustManagerRel> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustManagerRel> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustManagerRel> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustManagerRel> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
