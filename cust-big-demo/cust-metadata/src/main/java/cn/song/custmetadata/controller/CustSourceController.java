package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustSource;
import cn.song.custmetadata.service.CustSourceQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户来源查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custsource/page</li>
 *   <li>GET /api/cust/custsource/detail</li>
 *   <li>POST /api/cust/custsource/query</li>
 * </ul>
 */
public class CustSourceController {

    private final CustSourceQueryService queryService;

    public CustSourceController(CustSourceQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustSource> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustSource> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustSource> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustSource> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
