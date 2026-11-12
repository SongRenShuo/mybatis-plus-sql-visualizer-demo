package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustAddress;
import java.util.Date;
import java.util.List;

/**
 * 客户地址 查询服务契约。
 */
public interface CustAddressQueryService {

    List<CustAddress> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAddress> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAddress> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAddress> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAddress> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAddress> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
