package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustHolder;
import cn.song.custmetadata.service.CustHolderQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户持有人查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custholder/page</li>
 *   <li>GET /api/cust/custholder/detail</li>
 *   <li>POST /api/cust/custholder/query</li>
 * </ul>
 */
public class CustHolderController {

    private final CustHolderQueryService queryService;

    public CustHolderController(CustHolderQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustHolder> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustHolder> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustHolder> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustHolder> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
