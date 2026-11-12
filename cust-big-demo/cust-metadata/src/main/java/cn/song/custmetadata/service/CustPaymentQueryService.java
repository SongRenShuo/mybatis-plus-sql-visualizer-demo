package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustPayment;
import java.util.Date;
import java.util.List;

/**
 * 客户付款 查询服务契约。
 */
public interface CustPaymentQueryService {

    List<CustPayment> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustPayment> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustPayment> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustPayment> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustPayment> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustPayment> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
