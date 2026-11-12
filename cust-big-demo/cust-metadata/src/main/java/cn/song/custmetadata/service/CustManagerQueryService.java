package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustManager;
import java.util.Date;
import java.util.List;

/**
 * 客户经理 查询服务契约。
 */
public interface CustManagerQueryService {

    List<CustManager> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustManager> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustManager> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustManager> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustManager> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustManager> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
