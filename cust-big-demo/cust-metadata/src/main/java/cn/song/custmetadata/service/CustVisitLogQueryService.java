package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustVisitLog;
import java.util.Date;
import java.util.List;

/**
 * 客户拜访记录 查询服务契约。
 */
public interface CustVisitLogQueryService {

    List<CustVisitLog> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustVisitLog> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustVisitLog> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustVisitLog> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustVisitLog> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustVisitLog> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
