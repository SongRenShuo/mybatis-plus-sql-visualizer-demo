package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustComplaint;
import cn.song.custmetadata.example.CustComplaintExample;
import cn.song.custmetadata.mapper.CustComplaintMapper;
import cn.song.custmetadata.service.CustComplaintQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户投诉 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustComplaintQueryServiceImpl implements CustComplaintQueryService {

    private final CustComplaintMapper custComplaintMapper;

    public CustComplaintQueryServiceImpl(CustComplaintMapper custComplaintMapper) {
        this.custComplaintMapper = custComplaintMapper;
    }

    public List<CustComplaint> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustComplaint> result = new ArrayList<CustComplaint>();
        CustComplaintExample example01A = new CustComplaintExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custComplaintMapper.selectByExample(example01A));
        CustComplaintExample example01B = new CustComplaintExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custComplaintMapper.selectByExample(example01B));
        return result;
    }

    public List<CustComplaint> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustComplaint> result = new ArrayList<CustComplaint>();
        CustComplaintExample example02A = new CustComplaintExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custComplaintMapper.selectByExample(example02A));
        CustComplaintExample example02B = new CustComplaintExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custComplaintMapper.selectByExample(example02B));
        return result;
    }

    public List<CustComplaint> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustComplaint> result = new ArrayList<CustComplaint>();
        CustComplaintExample example03A = new CustComplaintExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custComplaintMapper.selectByExample(example03A));
        CustComplaintExample example03B = new CustComplaintExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custComplaintMapper.selectByExample(example03B));
        return result;
    }

    public List<CustComplaint> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustComplaint> result = new ArrayList<CustComplaint>();
        CustComplaintExample example04A = new CustComplaintExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custComplaintMapper.selectByExample(example04A));
        CustComplaintExample example04B = new CustComplaintExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custComplaintMapper.selectByExample(example04B));
        return result;
    }

    public List<CustComplaint> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustComplaint> result = new ArrayList<CustComplaint>();
        CustComplaintExample example05A = new CustComplaintExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custComplaintMapper.selectByExample(example05A));
        CustComplaintExample example05B = new CustComplaintExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custComplaintMapper.selectByExample(example05B));
        return result;
    }

    public List<CustComplaint> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustComplaint> result = new ArrayList<CustComplaint>();
        CustComplaintExample example06A = new CustComplaintExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custComplaintMapper.selectByExample(example06A));
        CustComplaintExample example06B = new CustComplaintExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custComplaintMapper.selectByExample(example06B));
        return result;
    }

}
