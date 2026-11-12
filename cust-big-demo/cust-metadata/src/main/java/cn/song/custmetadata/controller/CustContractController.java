package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustContract;
import cn.song.custmetadata.service.CustContractQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户合同查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custcontract/page</li>
 *   <li>GET /api/cust/custcontract/detail</li>
 *   <li>POST /api/cust/custcontract/query</li>
 * </ul>
 */
public class CustContractController {

    private final CustContractQueryService queryService;

    public CustContractController(CustContractQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustContract> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustContract> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustContract> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustContract> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
