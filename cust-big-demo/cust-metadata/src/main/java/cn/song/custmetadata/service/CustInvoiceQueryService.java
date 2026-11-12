package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustInvoice;
import java.util.Date;
import java.util.List;

/**
 * 客户发票 查询服务契约。
 */
public interface CustInvoiceQueryService {

    List<CustInvoice> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustInvoice> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustInvoice> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustInvoice> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustInvoice> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustInvoice> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
