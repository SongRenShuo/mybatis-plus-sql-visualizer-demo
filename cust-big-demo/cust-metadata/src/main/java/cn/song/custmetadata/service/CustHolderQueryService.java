package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustHolder;
import java.util.Date;
import java.util.List;

/**
 * 客户持有人 查询服务契约。
 */
public interface CustHolderQueryService {

    List<CustHolder> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustHolder> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustHolder> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustHolder> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustHolder> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustHolder> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
