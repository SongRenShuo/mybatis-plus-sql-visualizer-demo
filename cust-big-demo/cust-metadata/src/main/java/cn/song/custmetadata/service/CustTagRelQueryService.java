package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustTagRel;
import java.util.Date;
import java.util.List;

/**
 * 客户标签关系 查询服务契约。
 */
public interface CustTagRelQueryService {

    List<CustTagRel> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustTagRel> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustTagRel> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustTagRel> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustTagRel> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustTagRel> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
