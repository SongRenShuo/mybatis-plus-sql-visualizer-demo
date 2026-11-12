package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustSettlement;
import java.util.Date;
import java.util.List;

/**
 * 客户结算 查询服务契约。
 */
public interface CustSettlementQueryService {

    List<CustSettlement> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustSettlement> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustSettlement> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustSettlement> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustSettlement> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustSettlement> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
