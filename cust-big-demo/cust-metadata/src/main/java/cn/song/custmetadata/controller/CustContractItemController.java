package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustContractItem;
import cn.song.custmetadata.service.CustContractItemQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户合同明细查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custcontractitem/page</li>
 *   <li>GET /api/cust/custcontractitem/detail</li>
 *   <li>POST /api/cust/custcontractitem/query</li>
 * </ul>
 */
public class CustContractItemController {

    private final CustContractItemQueryService queryService;

    public CustContractItemController(CustContractItemQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustContractItem> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustContractItem> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustContractItem> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustContractItem> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
