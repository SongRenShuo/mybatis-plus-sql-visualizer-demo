package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustIndustryRel;
import cn.song.custmetadata.example.CustIndustryRelExample;
import cn.song.custmetadata.mapper.CustIndustryRelMapper;
import cn.song.custmetadata.service.CustIndustryRelQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户行业关系 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustIndustryRelQueryServiceImpl implements CustIndustryRelQueryService {

    private final CustIndustryRelMapper custIndustryRelMapper;

    public CustIndustryRelQueryServiceImpl(CustIndustryRelMapper custIndustryRelMapper) {
        this.custIndustryRelMapper = custIndustryRelMapper;
    }

    public List<CustIndustryRel> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustIndustryRel> result = new ArrayList<CustIndustryRel>();
        CustIndustryRelExample example01A = new CustIndustryRelExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custIndustryRelMapper.selectByExample(example01A));
        CustIndustryRelExample example01B = new CustIndustryRelExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custIndustryRelMapper.selectByExample(example01B));
        return result;
    }

    public List<CustIndustryRel> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustIndustryRel> result = new ArrayList<CustIndustryRel>();
        CustIndustryRelExample example02A = new CustIndustryRelExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custIndustryRelMapper.selectByExample(example02A));
        CustIndustryRelExample example02B = new CustIndustryRelExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custIndustryRelMapper.selectByExample(example02B));
        return result;
    }

    public List<CustIndustryRel> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustIndustryRel> result = new ArrayList<CustIndustryRel>();
        CustIndustryRelExample example03A = new CustIndustryRelExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custIndustryRelMapper.selectByExample(example03A));
        CustIndustryRelExample example03B = new CustIndustryRelExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custIndustryRelMapper.selectByExample(example03B));
        return result;
    }

    public List<CustIndustryRel> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustIndustryRel> result = new ArrayList<CustIndustryRel>();
        CustIndustryRelExample example04A = new CustIndustryRelExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custIndustryRelMapper.selectByExample(example04A));
        CustIndustryRelExample example04B = new CustIndustryRelExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custIndustryRelMapper.selectByExample(example04B));
        return result;
    }

    public List<CustIndustryRel> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustIndustryRel> result = new ArrayList<CustIndustryRel>();
        CustIndustryRelExample example05A = new CustIndustryRelExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custIndustryRelMapper.selectByExample(example05A));
        CustIndustryRelExample example05B = new CustIndustryRelExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custIndustryRelMapper.selectByExample(example05B));
        return result;
    }

    public List<CustIndustryRel> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustIndustryRel> result = new ArrayList<CustIndustryRel>();
        CustIndustryRelExample example06A = new CustIndustryRelExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custIndustryRelMapper.selectByExample(example06A));
        CustIndustryRelExample example06B = new CustIndustryRelExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custIndustryRelMapper.selectByExample(example06B));
        return result;
    }

}
