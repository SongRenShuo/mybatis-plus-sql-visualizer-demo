package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustTagRel;
import cn.song.custmetadata.service.CustTagRelQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户标签关系查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custtagrel/page</li>
 *   <li>GET /api/cust/custtagrel/detail</li>
 *   <li>POST /api/cust/custtagrel/query</li>
 * </ul>
 */
public class CustTagRelController {

    private final CustTagRelQueryService queryService;

    public CustTagRelController(CustTagRelQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustTagRel> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustTagRel> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustTagRel> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustTagRel> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
