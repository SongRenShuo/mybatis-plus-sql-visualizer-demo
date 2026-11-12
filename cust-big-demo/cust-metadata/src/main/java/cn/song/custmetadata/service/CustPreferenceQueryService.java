package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustPreference;
import java.util.Date;
import java.util.List;

/**
 * 客户偏好 查询服务契约。
 */
public interface CustPreferenceQueryService {

    List<CustPreference> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustPreference> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustPreference> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustPreference> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustPreference> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustPreference> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
