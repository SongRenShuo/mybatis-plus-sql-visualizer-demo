package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustFollowUp;
import java.util.Date;
import java.util.List;

/**
 * 客户跟进 查询服务契约。
 */
public interface CustFollowUpQueryService {

    List<CustFollowUp> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustFollowUp> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustFollowUp> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustFollowUp> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustFollowUp> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustFollowUp> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
