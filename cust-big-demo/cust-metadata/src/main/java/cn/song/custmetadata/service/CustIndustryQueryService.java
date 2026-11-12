package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustIndustry;
import java.util.Date;
import java.util.List;

/**
 * 客户行业 查询服务契约。
 */
public interface CustIndustryQueryService {

    List<CustIndustry> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustIndustry> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustIndustry> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustIndustry> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustIndustry> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustIndustry> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
