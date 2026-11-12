package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustRefund;
import java.util.Date;
import java.util.List;

/**
 * 客户退款 查询服务契约。
 */
public interface CustRefundQueryService {

    List<CustRefund> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustRefund> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustRefund> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustRefund> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustRefund> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustRefund> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
