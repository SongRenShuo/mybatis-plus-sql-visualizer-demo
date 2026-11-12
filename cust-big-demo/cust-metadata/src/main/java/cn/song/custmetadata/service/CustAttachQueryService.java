package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustAttach;
import java.util.Date;
import java.util.List;

/**
 * 客户附件 查询服务契约。
 */
public interface CustAttachQueryService {

    List<CustAttach> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAttach> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAttach> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAttach> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAttach> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAttach> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
