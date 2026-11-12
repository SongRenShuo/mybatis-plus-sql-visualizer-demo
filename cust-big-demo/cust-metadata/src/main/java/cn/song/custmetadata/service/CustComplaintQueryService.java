package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustComplaint;
import java.util.Date;
import java.util.List;

/**
 * 客户投诉 查询服务契约。
 */
public interface CustComplaintQueryService {

    List<CustComplaint> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustComplaint> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustComplaint> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustComplaint> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustComplaint> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustComplaint> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
