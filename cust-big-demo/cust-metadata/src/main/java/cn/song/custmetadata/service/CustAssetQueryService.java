package cn.song.custmetadata.service;

import cn.song.custmetadata.entity.CustAsset;
import java.util.Date;
import java.util.List;

/**
 * 客户资产 查询服务契约。
 */
public interface CustAssetQueryService {

    List<CustAsset> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAsset> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAsset> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAsset> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAsset> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

    List<CustAsset> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime);

}
