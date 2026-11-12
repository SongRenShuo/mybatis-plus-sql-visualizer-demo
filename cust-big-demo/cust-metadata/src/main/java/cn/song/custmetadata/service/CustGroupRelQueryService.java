package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustGroupRel;
import java.util.Date;
import java.util.List;

/**
 * 客户群组关系 查询服务契约。
 */
public interface CustGroupRelQueryService {

    List<CustGroupRel> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustGroupRel> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustGroupRel> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustGroupRel> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustGroupRel> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustGroupRel> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
