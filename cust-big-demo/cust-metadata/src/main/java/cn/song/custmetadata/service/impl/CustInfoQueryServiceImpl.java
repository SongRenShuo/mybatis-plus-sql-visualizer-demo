package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustInfo;
import cn.song.custmetadata.example.CustInfoExample;
import cn.song.custmetadata.mapper.CustInfoMapper;
import cn.song.custmetadata.service.CustInfoQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户信息 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustInfoQueryServiceImpl implements CustInfoQueryService {

    private final CustInfoMapper custInfoMapper;

    public CustInfoQueryServiceImpl(CustInfoMapper custInfoMapper) {
        this.custInfoMapper = custInfoMapper;
    }

    public List<CustInfo> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample example01A = new CustInfoExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(example01A));
        CustInfoExample example01B = new CustInfoExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(example01B));
        return result;
    }

    public List<CustInfo> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample example02A = new CustInfoExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(example02A));
        CustInfoExample example02B = new CustInfoExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(example02B));
        return result;
    }

    public List<CustInfo> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample example03A = new CustInfoExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(example03A));
        CustInfoExample example03B = new CustInfoExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInfoMapper.selectByExample(example03B));
        return result;
    }

    public List<CustInfo> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample example04A = new CustInfoExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInfoMapper.selectByExample(example04A));
        CustInfoExample example04B = new CustInfoExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(example04B));
        return result;
    }

    public List<CustInfo> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample example05A = new CustInfoExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(example05A));
        CustInfoExample example05B = new CustInfoExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(example05B));
        return result;
    }

    public List<CustInfo> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample example06A = new CustInfoExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(example06A));
        CustInfoExample example06B = new CustInfoExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(example06B));
        return result;
    }

}
