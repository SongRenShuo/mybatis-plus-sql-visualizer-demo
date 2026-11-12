package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustGroup;
import java.util.Date;
import java.util.List;

/**
 * 客户群组 查询服务契约。
 */
public interface CustGroupQueryService {

    List<CustGroup> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustGroup> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustGroup> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustGroup> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustGroup> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustGroup> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
