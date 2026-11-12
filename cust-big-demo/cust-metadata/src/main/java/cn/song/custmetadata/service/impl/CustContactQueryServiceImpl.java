package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustContact;
import cn.song.custmetadata.example.CustContactExample;
import cn.song.custmetadata.mapper.CustContactMapper;
import cn.song.custmetadata.service.CustContactQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户联系方式 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustContactQueryServiceImpl implements CustContactQueryService {

    private final CustContactMapper custContactMapper;

    public CustContactQueryServiceImpl(CustContactMapper custContactMapper) {
        this.custContactMapper = custContactMapper;
    }

    public List<CustContact> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample example01A = new CustContactExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(example01A));
        CustContactExample example01B = new CustContactExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(example01B));
        return result;
    }

    public List<CustContact> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample example02A = new CustContactExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(example02A));
        CustContactExample example02B = new CustContactExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(example02B));
        return result;
    }

    public List<CustContact> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample example03A = new CustContactExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(example03A));
        CustContactExample example03B = new CustContactExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContactMapper.selectByExample(example03B));
        return result;
    }

    public List<CustContact> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample example04A = new CustContactExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContactMapper.selectByExample(example04A));
        CustContactExample example04B = new CustContactExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(example04B));
        return result;
    }

    public List<CustContact> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample example05A = new CustContactExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(example05A));
        CustContactExample example05B = new CustContactExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(example05B));
        return result;
    }

    public List<CustContact> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample example06A = new CustContactExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(example06A));
        CustContactExample example06B = new CustContactExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(example06B));
        return result;
    }

}
