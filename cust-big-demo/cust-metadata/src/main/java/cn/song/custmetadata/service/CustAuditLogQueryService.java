package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustAuditLog;
import java.util.Date;
import java.util.List;

/**
 * 客户审计日志 查询服务契约。
 */
public interface CustAuditLogQueryService {

    List<CustAuditLog> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAuditLog> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAuditLog> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAuditLog> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAuditLog> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAuditLog> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
