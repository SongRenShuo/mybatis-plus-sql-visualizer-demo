package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustComplaint;
import cn.song.custmetadata.service.CustComplaintQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户投诉查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custcomplaint/page</li>
 *   <li>GET /api/cust/custcomplaint/detail</li>
 *   <li>POST /api/cust/custcomplaint/query</li>
 * </ul>
 */
public class CustComplaintController {

    private final CustComplaintQueryService queryService;

    public CustComplaintController(CustComplaintQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustComplaint> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustComplaint> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustComplaint> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustComplaint> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
