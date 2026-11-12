package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustSource;
import java.util.Date;
import java.util.List;

/**
 * 客户来源 查询服务契约。
 */
public interface CustSourceQueryService {

    List<CustSource> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustSource> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustSource> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustSource> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustSource> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustSource> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
