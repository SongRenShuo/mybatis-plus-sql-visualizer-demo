package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustContract;
import java.util.Date;
import java.util.List;

/**
 * 客户合同 查询服务契约。
 */
public interface CustContractQueryService {

    List<CustContract> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustContract> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustContract> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustContract> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustContract> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustContract> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
