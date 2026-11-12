package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustNote;
import cn.song.custmetadata.service.CustNoteQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户备注查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custnote/page</li>
 *   <li>GET /api/cust/custnote/detail</li>
 *   <li>POST /api/cust/custnote/query</li>
 * </ul>
 */
public class CustNoteController {

    private final CustNoteQueryService queryService;

    public CustNoteController(CustNoteQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustNote> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustNote> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustNote> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustNote> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
