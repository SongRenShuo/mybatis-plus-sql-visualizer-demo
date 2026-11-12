package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustIndustryRel;
import cn.song.custmetadata.service.CustIndustryRelQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户行业关系查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custindustryrel/page</li>
 *   <li>GET /api/cust/custindustryrel/detail</li>
 *   <li>POST /api/cust/custindustryrel/query</li>
 * </ul>
 */
public class CustIndustryRelController {

    private final CustIndustryRelQueryService queryService;

    public CustIndustryRelController(CustIndustryRelQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustIndustryRel> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustIndustryRel> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustIndustryRel> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustIndustryRel> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
