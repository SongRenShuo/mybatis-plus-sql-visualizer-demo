package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustHolderRel;
import cn.song.custmetadata.service.CustHolderRelQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户持有人关系查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custholderrel/page</li>
 *   <li>GET /api/cust/custholderrel/detail</li>
 *   <li>POST /api/cust/custholderrel/query</li>
 * </ul>
 */
public class CustHolderRelController {

    private final CustHolderRelQueryService queryService;

    public CustHolderRelController(CustHolderRelQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustHolderRel> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustHolderRel> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustHolderRel> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustHolderRel> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
