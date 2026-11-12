package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustScoreLog;
import java.util.Date;
import java.util.List;

/**
 * 客户评分日志 查询服务契约。
 */
public interface CustScoreLogQueryService {

    List<CustScoreLog> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustScoreLog> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustScoreLog> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustScoreLog> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustScoreLog> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustScoreLog> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
