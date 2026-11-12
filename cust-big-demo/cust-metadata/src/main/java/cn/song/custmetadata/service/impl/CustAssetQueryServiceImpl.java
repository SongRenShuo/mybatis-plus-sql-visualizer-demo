package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustAsset;
import cn.song.custmetadata.example.CustAssetExample;
import cn.song.custmetadata.mapper.CustAssetMapper;
import cn.song.custmetadata.service.CustAssetQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户资产 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustAssetQueryServiceImpl implements CustAssetQueryService {

    private final CustAssetMapper custAssetMapper;

    public CustAssetQueryServiceImpl(CustAssetMapper custAssetMapper) {
        this.custAssetMapper = custAssetMapper;
    }

    public List<CustAsset> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAsset> result = new ArrayList<CustAsset>();
        CustAssetExample example01A = new CustAssetExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAssetMapper.selectByExample(example01A));
        CustAssetExample example01B = new CustAssetExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAssetMapper.selectByExample(example01B));
        return result;
    }

    public List<CustAsset> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAsset> result = new ArrayList<CustAsset>();
        CustAssetExample example02A = new CustAssetExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAssetMapper.selectByExample(example02A));
        CustAssetExample example02B = new CustAssetExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAssetMapper.selectByExample(example02B));
        return result;
    }

    public List<CustAsset> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAsset> result = new ArrayList<CustAsset>();
        CustAssetExample example03A = new CustAssetExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAssetMapper.selectByExample(example03A));
        CustAssetExample example03B = new CustAssetExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAssetMapper.selectByExample(example03B));
        return result;
    }

    public List<CustAsset> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAsset> result = new ArrayList<CustAsset>();
        CustAssetExample example04A = new CustAssetExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAssetMapper.selectByExample(example04A));
        CustAssetExample example04B = new CustAssetExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAssetMapper.selectByExample(example04B));
        return result;
    }

    public List<CustAsset> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAsset> result = new ArrayList<CustAsset>();
        CustAssetExample example05A = new CustAssetExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAssetMapper.selectByExample(example05A));
        CustAssetExample example05B = new CustAssetExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAssetMapper.selectByExample(example05B));
        return result;
    }

    public List<CustAsset> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAsset> result = new ArrayList<CustAsset>();
        CustAssetExample example06A = new CustAssetExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAssetMapper.selectByExample(example06A));
        CustAssetExample example06B = new CustAssetExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAssetMapper.selectByExample(example06B));
        return result;
    }

}
