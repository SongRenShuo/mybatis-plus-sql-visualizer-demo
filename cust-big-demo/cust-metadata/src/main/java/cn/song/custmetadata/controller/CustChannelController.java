package cn.song.custmetadata.controller;

import cn.song.custmetadata.entity.CustChannel;
import cn.song.custmetadata.service.CustChannelQueryService;
import java.util.Date;
import java.util.List;

/**
 * 客户渠道查询入口（Controller 层）。
 *
 * <p>路由约定：
 * <ul>
 *   <li>GET /api/cust/custchannel/page</li>
 *   <li>GET /api/cust/custchannel/detail</li>
 *   <li>POST /api/cust/custchannel/query</li>
 * </ul>
 */
public class CustChannelController {

    private final CustChannelQueryService queryService;

    public CustChannelController(CustChannelQueryService queryService) {
        this.queryService = queryService;
    }

    public List<CustChannel> page01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition01(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustChannel> page02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition02(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustChannel> page03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition03(tenantId, custNo, custName, status, startTime, endTime);
    }

    public List<CustChannel> page04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        return queryService.queryByCondition04(tenantId, custNo, custName, status, startTime, endTime);
    }

}
