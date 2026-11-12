package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustChannel;
import java.util.Date;
import java.util.List;

/**
 * 客户渠道 查询服务契约。
 */
public interface CustChannelQueryService {

    List<CustChannel> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustChannel> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustChannel> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustChannel> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustChannel> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustChannel> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
