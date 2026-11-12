package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustManager;
import cn.song.custmetadata.service.CustManagerQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户经理查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custmanager/page</li>
 *   <li>GET /api/cust/custmanager/detail</li>
 *   <li>POST /api/cust/custmanager/query</li>
 * </ul>
 */
public class CustManagerController {

    private final CustManagerQueryService queryService;

    public CustManagerController(CustManagerQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustManager> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustManager> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustManager> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustManager> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
