package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustRiskEval;
import cn.song.custmetadata.example.CustRiskEvalExample;
import cn.song.custmetadata.mapper.CustRiskEvalMapper;
import cn.song.custmetadata.service.CustRiskEvalQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户风险评估 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustRiskEvalQueryServiceImpl implements CustRiskEvalQueryService {

    private final CustRiskEvalMapper custRiskEvalMapper;

    public CustRiskEvalQueryServiceImpl(CustRiskEvalMapper custRiskEvalMapper) {
        this.custRiskEvalMapper = custRiskEvalMapper;
    }

    public List<CustRiskEval> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRiskEval> result = new ArrayList<CustRiskEval>();
        CustRiskEvalExample example01A = new CustRiskEvalExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custRiskEvalMapper.selectByExample(example01A));
        CustRiskEvalExample example01B = new CustRiskEvalExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custRiskEvalMapper.selectByExample(example01B));
        return result;
    }

    public List<CustRiskEval> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRiskEval> result = new ArrayList<CustRiskEval>();
        CustRiskEvalExample example02A = new CustRiskEvalExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custRiskEvalMapper.selectByExample(example02A));
        CustRiskEvalExample example02B = new CustRiskEvalExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custRiskEvalMapper.selectByExample(example02B));
        return result;
    }

    public List<CustRiskEval> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRiskEval> result = new ArrayList<CustRiskEval>();
        CustRiskEvalExample example03A = new CustRiskEvalExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custRiskEvalMapper.selectByExample(example03A));
        CustRiskEvalExample example03B = new CustRiskEvalExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custRiskEvalMapper.selectByExample(example03B));
        return result;
    }

    public List<CustRiskEval> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRiskEval> result = new ArrayList<CustRiskEval>();
        CustRiskEvalExample example04A = new CustRiskEvalExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custRiskEvalMapper.selectByExample(example04A));
        CustRiskEvalExample example04B = new CustRiskEvalExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custRiskEvalMapper.selectByExample(example04B));
        return result;
    }

    public List<CustRiskEval> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRiskEval> result = new ArrayList<CustRiskEval>();
        CustRiskEvalExample example05A = new CustRiskEvalExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custRiskEvalMapper.selectByExample(example05A));
        CustRiskEvalExample example05B = new CustRiskEvalExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custRiskEvalMapper.selectByExample(example05B));
        return result;
    }

    public List<CustRiskEval> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRiskEval> result = new ArrayList<CustRiskEval>();
        CustRiskEvalExample example06A = new CustRiskEvalExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custRiskEvalMapper.selectByExample(example06A));
        CustRiskEvalExample example06B = new CustRiskEvalExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custRiskEvalMapper.selectByExample(example06B));
        return result;
    }

}
