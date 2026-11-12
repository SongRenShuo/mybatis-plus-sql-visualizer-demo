package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustChangeLog;
import java.util.Date;
import java.util.List;

/**
 * 客户变更日志 查询服务契约。
 */
public interface CustChangeLogQueryService {

    List<CustChangeLog> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustChangeLog> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustChangeLog> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustChangeLog> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustChangeLog> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustChangeLog> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
