package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustContact;
import cn.song.custmetadata.service.CustContactQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户联系方式查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custcontact/page</li>
 *   <li>GET /api/cust/custcontact/detail</li>
 *   <li>POST /api/cust/custcontact/query</li>
 * </ul>
 */
public class CustContactController {

    private final CustContactQueryService queryService;

    public CustContactController(CustContactQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustContact> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustContact> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustContact> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustContact> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
