package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustOrder;
import java.util.Date;
import java.util.List;

/**
 * 客户订单 查询服务契约。
 */
public interface CustOrderQueryService {

    List<CustOrder> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustOrder> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustOrder> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustOrder> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustOrder> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustOrder> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
