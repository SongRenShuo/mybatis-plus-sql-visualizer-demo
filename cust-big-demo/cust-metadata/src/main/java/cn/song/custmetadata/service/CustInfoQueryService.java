package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustInfo;
import java.util.Date;
import java.util.List;

/**
 * 客户信息 查询服务契约。
 */
public interface CustInfoQueryService {

    List<CustInfo> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustInfo> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustInfo> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustInfo> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustInfo> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustInfo> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
