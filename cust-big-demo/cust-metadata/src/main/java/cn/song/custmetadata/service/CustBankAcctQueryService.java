package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustBankAcct;
import java.util.Date;
import java.util.List;

/**
 * 客户银行账户 查询服务契约。
 */
public interface CustBankAcctQueryService {

    List<CustBankAcct> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustBankAcct> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustBankAcct> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustBankAcct> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustBankAcct> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustBankAcct> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
