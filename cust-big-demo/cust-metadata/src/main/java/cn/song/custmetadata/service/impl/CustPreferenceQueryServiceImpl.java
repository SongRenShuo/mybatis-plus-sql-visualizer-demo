package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustPreference;
import cn.song.custmetadata.example.CustPreferenceExample;
import cn.song.custmetadata.mapper.CustPreferenceMapper;
import cn.song.custmetadata.service.CustPreferenceQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户偏好 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustPreferenceQueryServiceImpl implements CustPreferenceQueryService {

    private final CustPreferenceMapper custPreferenceMapper;

    public CustPreferenceQueryServiceImpl(CustPreferenceMapper custPreferenceMapper) {
        this.custPreferenceMapper = custPreferenceMapper;
    }

    public List<CustPreference> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustPreference> result = new ArrayList<CustPreference>();
        CustPreferenceExample example01A = new CustPreferenceExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custPreferenceMapper.selectByExample(example01A));
        CustPreferenceExample example01B = new CustPreferenceExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custPreferenceMapper.selectByExample(example01B));
        return result;
    }

    public List<CustPreference> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustPreference> result = new ArrayList<CustPreference>();
        CustPreferenceExample example02A = new CustPreferenceExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custPreferenceMapper.selectByExample(example02A));
        CustPreferenceExample example02B = new CustPreferenceExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custPreferenceMapper.selectByExample(example02B));
        return result;
    }

    public List<CustPreference> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustPreference> result = new ArrayList<CustPreference>();
        CustPreferenceExample example03A = new CustPreferenceExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custPreferenceMapper.selectByExample(example03A));
        CustPreferenceExample example03B = new CustPreferenceExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custPreferenceMapper.selectByExample(example03B));
        return result;
    }

    public List<CustPreference> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustPreference> result = new ArrayList<CustPreference>();
        CustPreferenceExample example04A = new CustPreferenceExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custPreferenceMapper.selectByExample(example04A));
        CustPreferenceExample example04B = new CustPreferenceExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custPreferenceMapper.selectByExample(example04B));
        return result;
    }

    public List<CustPreference> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustPreference> result = new ArrayList<CustPreference>();
        CustPreferenceExample example05A = new CustPreferenceExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custPreferenceMapper.selectByExample(example05A));
        CustPreferenceExample example05B = new CustPreferenceExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custPreferenceMapper.selectByExample(example05B));
        return result;
    }

    public List<CustPreference> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustPreference> result = new ArrayList<CustPreference>();
        CustPreferenceExample example06A = new CustPreferenceExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custPreferenceMapper.selectByExample(example06A));
        CustPreferenceExample example06B = new CustPreferenceExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custPreferenceMapper.selectByExample(example06B));
        return result;
    }

}
