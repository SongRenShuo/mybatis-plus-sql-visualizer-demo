package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustAssetDetail;
import java.util.Date;
import java.util.List;

/**
 * 客户资产明细 查询服务契约。
 */
public interface CustAssetDetailQueryService {

    List<CustAssetDetail> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAssetDetail> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAssetDetail> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAssetDetail> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAssetDetail> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAssetDetail> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
