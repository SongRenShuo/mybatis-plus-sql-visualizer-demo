package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustIndustryRel;
import java.util.Date;
import java.util.List;

/**
 * 客户行业关系 查询服务契约。
 */
public interface CustIndustryRelQueryService {

    List<CustIndustryRel> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustIndustryRel> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustIndustryRel> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustIndustryRel> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustIndustryRel> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustIndustryRel> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
