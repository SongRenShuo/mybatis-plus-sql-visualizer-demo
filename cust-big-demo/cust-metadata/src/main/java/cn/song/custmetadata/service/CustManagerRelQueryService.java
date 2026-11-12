package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustManagerRel;
import java.util.Date;
import java.util.List;

/**
 * 客户经理关系 查询服务契约。
 */
public interface CustManagerRelQueryService {

    List<CustManagerRel> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustManagerRel> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustManagerRel> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustManagerRel> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustManagerRel> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustManagerRel> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
