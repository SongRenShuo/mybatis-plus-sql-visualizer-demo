package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustCert;
import cn.song.custmetadata.service.CustCertQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户证件查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custcert/page</li>
 *   <li>GET /api/cust/custcert/detail</li>
 *   <li>POST /api/cust/custcert/query</li>
 * </ul>
 */
public class CustCertController {

    private final CustCertQueryService queryService;

    public CustCertController(CustCertQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustCert> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustCert> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustCert> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustCert> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
