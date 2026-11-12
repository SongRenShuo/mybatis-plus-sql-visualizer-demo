package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustRiskEval;
import java.util.Date;
import java.util.List;

/**
 * 客户风险评估 查询服务契约。
 */
public interface CustRiskEvalQueryService {

    List<CustRiskEval> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustRiskEval> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustRiskEval> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustRiskEval> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustRiskEval> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustRiskEval> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
