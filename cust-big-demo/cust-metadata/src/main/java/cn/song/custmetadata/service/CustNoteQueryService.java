package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustNote;
import java.util.Date;
import java.util.List;

/**
 * 客户备注 查询服务契约。
 */
public interface CustNoteQueryService {

    List<CustNote> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustNote> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustNote> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustNote> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustNote> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustNote> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
