package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustIndustry;
import cn.song.custmetadata.service.CustIndustryQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户行业查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custindustry/page</li>
 *   <li>GET /api/cust/custindustry/detail</li>
 *   <li>POST /api/cust/custindustry/query</li>
 * </ul>
 */
public class CustIndustryController {

    private final CustIndustryQueryService queryService;

    public CustIndustryController(CustIndustryQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustIndustry> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustIndustry> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustIndustry> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustIndustry> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
