package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustContractItem;
import java.util.Date;
import java.util.List;

/**
 * 客户合同明细 查询服务契约。
 */
public interface CustContractItemQueryService {

    List<CustContractItem> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustContractItem> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustContractItem> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustContractItem> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustContractItem> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustContractItem> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
