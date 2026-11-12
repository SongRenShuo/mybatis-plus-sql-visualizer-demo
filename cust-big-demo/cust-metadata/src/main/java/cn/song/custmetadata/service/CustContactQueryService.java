package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustContact;
import java.util.Date;
import java.util.List;

/**
 * 客户联系方式 查询服务契约。
 */
public interface CustContactQueryService {

    List<CustContact> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustContact> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustContact> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustContact> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustContact> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustContact> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
