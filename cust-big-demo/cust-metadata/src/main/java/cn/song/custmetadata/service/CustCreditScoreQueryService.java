package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustCreditScore;
import java.util.Date;
import java.util.List;

/**
 * 客户信用评分 查询服务契约。
 */
public interface CustCreditScoreQueryService {

    List<CustCreditScore> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustCreditScore> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustCreditScore> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustCreditScore> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustCreditScore> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustCreditScore> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
