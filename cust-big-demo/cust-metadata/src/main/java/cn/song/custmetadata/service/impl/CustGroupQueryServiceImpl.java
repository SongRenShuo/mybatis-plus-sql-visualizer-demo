package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustGroup;
import cn.song.custmetadata.example.CustGroupExample;
import cn.song.custmetadata.mapper.CustGroupMapper;
import cn.song.custmetadata.service.CustGroupQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户群组 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustGroupQueryServiceImpl implements CustGroupQueryService {

    private final CustGroupMapper custGroupMapper;

    public CustGroupQueryServiceImpl(CustGroupMapper custGroupMapper) {
        this.custGroupMapper = custGroupMapper;
    }

    public List<CustGroup> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustGroup> result = new ArrayList<CustGroup>();
        CustGroupExample example01A = new CustGroupExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custGroupMapper.selectByExample(example01A));
        CustGroupExample example01B = new CustGroupExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custGroupMapper.selectByExample(example01B));
        return result;
    }

    public List<CustGroup> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustGroup> result = new ArrayList<CustGroup>();
        CustGroupExample example02A = new CustGroupExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custGroupMapper.selectByExample(example02A));
        CustGroupExample example02B = new CustGroupExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custGroupMapper.selectByExample(example02B));
        return result;
    }

    public List<CustGroup> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustGroup> result = new ArrayList<CustGroup>();
        CustGroupExample example03A = new CustGroupExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custGroupMapper.selectByExample(example03A));
        CustGroupExample example03B = new CustGroupExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custGroupMapper.selectByExample(example03B));
        return result;
    }

    public List<CustGroup> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustGroup> result = new ArrayList<CustGroup>();
        CustGroupExample example04A = new CustGroupExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custGroupMapper.selectByExample(example04A));
        CustGroupExample example04B = new CustGroupExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custGroupMapper.selectByExample(example04B));
        return result;
    }

    public List<CustGroup> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustGroup> result = new ArrayList<CustGroup>();
        CustGroupExample example05A = new CustGroupExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custGroupMapper.selectByExample(example05A));
        CustGroupExample example05B = new CustGroupExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custGroupMapper.selectByExample(example05B));
        return result;
    }

    public List<CustGroup> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustGroup> result = new ArrayList<CustGroup>();
        CustGroupExample example06A = new CustGroupExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custGroupMapper.selectByExample(example06A));
        CustGroupExample example06B = new CustGroupExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custGroupMapper.selectByExample(example06B));
        return result;
    }

}
