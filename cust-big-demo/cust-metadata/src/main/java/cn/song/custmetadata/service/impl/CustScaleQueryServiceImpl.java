package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustScale;
import cn.song.custmetadata.example.CustScaleExample;
import cn.song.custmetadata.mapper.CustScaleMapper;
import cn.song.custmetadata.service.CustScaleQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户规模 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustScaleQueryServiceImpl implements CustScaleQueryService {

    private final CustScaleMapper custScaleMapper;

    public CustScaleQueryServiceImpl(CustScaleMapper custScaleMapper) {
        this.custScaleMapper = custScaleMapper;
    }

    public List<CustScale> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustScale> result = new ArrayList<CustScale>();
        CustScaleExample example01A = new CustScaleExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custScaleMapper.selectByExample(example01A));
        CustScaleExample example01B = new CustScaleExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custScaleMapper.selectByExample(example01B));
        return result;
    }

    public List<CustScale> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustScale> result = new ArrayList<CustScale>();
        CustScaleExample example02A = new CustScaleExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custScaleMapper.selectByExample(example02A));
        CustScaleExample example02B = new CustScaleExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custScaleMapper.selectByExample(example02B));
        return result;
    }

    public List<CustScale> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustScale> result = new ArrayList<CustScale>();
        CustScaleExample example03A = new CustScaleExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custScaleMapper.selectByExample(example03A));
        CustScaleExample example03B = new CustScaleExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custScaleMapper.selectByExample(example03B));
        return result;
    }

    public List<CustScale> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustScale> result = new ArrayList<CustScale>();
        CustScaleExample example04A = new CustScaleExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custScaleMapper.selectByExample(example04A));
        CustScaleExample example04B = new CustScaleExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custScaleMapper.selectByExample(example04B));
        return result;
    }

    public List<CustScale> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustScale> result = new ArrayList<CustScale>();
        CustScaleExample example05A = new CustScaleExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custScaleMapper.selectByExample(example05A));
        CustScaleExample example05B = new CustScaleExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custScaleMapper.selectByExample(example05B));
        return result;
    }

    public List<CustScale> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustScale> result = new ArrayList<CustScale>();
        CustScaleExample example06A = new CustScaleExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custScaleMapper.selectByExample(example06A));
        CustScaleExample example06B = new CustScaleExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custScaleMapper.selectByExample(example06B));
        return result;
    }

}
