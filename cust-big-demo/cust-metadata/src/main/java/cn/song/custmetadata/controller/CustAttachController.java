package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustAttach;
import cn.song.custmetadata.service.CustAttachQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户附件查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custattach/page</li>
 *   <li>GET /api/cust/custattach/detail</li>
 *   <li>POST /api/cust/custattach/query</li>
 * </ul>
 */
public class CustAttachController {

    private final CustAttachQueryService queryService;

    public CustAttachController(CustAttachQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustAttach> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustAttach> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustAttach> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustAttach> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
