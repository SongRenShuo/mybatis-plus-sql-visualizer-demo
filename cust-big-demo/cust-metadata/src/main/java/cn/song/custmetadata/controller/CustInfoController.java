package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustInfo;
import cn.song.custmetadata.service.CustInfoQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户信息查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custinfo/page</li>
 *   <li>GET /api/cust/custinfo/detail</li>
 *   <li>POST /api/cust/custinfo/query</li>
 * </ul>
 */
public class CustInfoController {

    private final CustInfoQueryService queryService;

    public CustInfoController(CustInfoQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustInfo> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustInfo> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustInfo> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustInfo> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
