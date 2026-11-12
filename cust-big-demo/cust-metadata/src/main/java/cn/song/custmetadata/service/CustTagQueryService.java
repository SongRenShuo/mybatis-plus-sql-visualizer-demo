package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustTag;
import java.util.Date;
import java.util.List;

/**
 * 客户标签 查询服务契约。
 */
public interface CustTagQueryService {

    List<CustTag> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustTag> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustTag> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustTag> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustTag> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustTag> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
