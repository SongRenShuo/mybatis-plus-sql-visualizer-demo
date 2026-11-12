package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustScale;
import java.util.Date;
import java.util.List;

/**
 * 客户规模 查询服务契约。
 */
public interface CustScaleQueryService {

    List<CustScale> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustScale> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustScale> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustScale> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustScale> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustScale> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
