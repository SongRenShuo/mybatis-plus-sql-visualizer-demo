package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustCert;
import java.util.Date;
import java.util.List;

/**
 * 客户证件 查询服务契约。
 */
public interface CustCertQueryService {

    List<CustCert> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustCert> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustCert> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustCert> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustCert> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustCert> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
