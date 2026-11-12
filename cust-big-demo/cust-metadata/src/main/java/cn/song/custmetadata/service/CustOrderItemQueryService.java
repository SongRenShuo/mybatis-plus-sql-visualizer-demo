package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustOrderItem;
import java.util.Date;
import java.util.List;

/**
 * 客户订单明细 查询服务契约。
 */
public interface CustOrderItemQueryService {

    List<CustOrderItem> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustOrderItem> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustOrderItem> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustOrderItem> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustOrderItem> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustOrderItem> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
