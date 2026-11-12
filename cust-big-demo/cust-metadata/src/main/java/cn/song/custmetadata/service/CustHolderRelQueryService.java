package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustHolderRel;
import java.util.Date;
import java.util.List;

/**
 * 客户持有人关系 查询服务契约。
 */
public interface CustHolderRelQueryService {

    List<CustHolderRel> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustHolderRel> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustHolderRel> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustHolderRel> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustHolderRel> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustHolderRel> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
