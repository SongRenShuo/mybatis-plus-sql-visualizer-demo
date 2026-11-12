package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustAddress;
import cn.song.custmetadata.service.CustAddressQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户地址查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custaddress/page</li>
 *   <li>GET /api/cust/custaddress/detail</li>
 *   <li>POST /api/cust/custaddress/query</li>
 * </ul>
 */
public class CustAddressController {

    private final CustAddressQueryService queryService;

    public CustAddressController(CustAddressQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustAddress> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustAddress> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustAddress> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustAddress> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
