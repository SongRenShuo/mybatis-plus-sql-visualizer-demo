package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustRiskItem;
import java.util.Date;
import java.util.List;

/**
 * 客户风险项 查询服务契约。
 */
public interface CustRiskItemQueryService {

    List<CustRiskItem> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustRiskItem> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustRiskItem> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustRiskItem> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustRiskItem> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustRiskItem> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
