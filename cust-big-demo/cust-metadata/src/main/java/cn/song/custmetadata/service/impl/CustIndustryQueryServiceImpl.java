package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustIndustry;
import cn.song.custmetadata.example.CustIndustryExample;
import cn.song.custmetadata.mapper.CustIndustryMapper;
import cn.song.custmetadata.service.CustIndustryQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户行业 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustIndustryQueryServiceImpl implements CustIndustryQueryService {

    private final CustIndustryMapper custIndustryMapper;

    public CustIndustryQueryServiceImpl(CustIndustryMapper custIndustryMapper) {
        this.custIndustryMapper = custIndustryMapper;
    }

    public List<CustIndustry> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustIndustry> result = new ArrayList<CustIndustry>();
        CustIndustryExample example01A = new CustIndustryExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custIndustryMapper.selectByExample(example01A));
        CustIndustryExample example01B = new CustIndustryExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custIndustryMapper.selectByExample(example01B));
        return result;
    }

    public List<CustIndustry> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustIndustry> result = new ArrayList<CustIndustry>();
        CustIndustryExample example02A = new CustIndustryExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custIndustryMapper.selectByExample(example02A));
        CustIndustryExample example02B = new CustIndustryExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custIndustryMapper.selectByExample(example02B));
        return result;
    }

    public List<CustIndustry> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustIndustry> result = new ArrayList<CustIndustry>();
        CustIndustryExample example03A = new CustIndustryExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custIndustryMapper.selectByExample(example03A));
        CustIndustryExample example03B = new CustIndustryExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custIndustryMapper.selectByExample(example03B));
        return result;
    }

    public List<CustIndustry> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustIndustry> result = new ArrayList<CustIndustry>();
        CustIndustryExample example04A = new CustIndustryExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custIndustryMapper.selectByExample(example04A));
        CustIndustryExample example04B = new CustIndustryExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custIndustryMapper.selectByExample(example04B));
        return result;
    }

    public List<CustIndustry> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustIndustry> result = new ArrayList<CustIndustry>();
        CustIndustryExample example05A = new CustIndustryExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custIndustryMapper.selectByExample(example05A));
        CustIndustryExample example05B = new CustIndustryExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custIndustryMapper.selectByExample(example05B));
        return result;
    }

    public List<CustIndustry> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustIndustry> result = new ArrayList<CustIndustry>();
        CustIndustryExample example06A = new CustIndustryExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custIndustryMapper.selectByExample(example06A));
        CustIndustryExample example06B = new CustIndustryExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custIndustryMapper.selectByExample(example06B));
        return result;
    }

}
