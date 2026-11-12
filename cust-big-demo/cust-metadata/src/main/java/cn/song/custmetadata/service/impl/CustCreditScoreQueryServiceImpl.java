package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustCreditScore;
import cn.song.custmetadata.example.CustCreditScoreExample;
import cn.song.custmetadata.mapper.CustCreditScoreMapper;
import cn.song.custmetadata.service.CustCreditScoreQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户信用评分 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustCreditScoreQueryServiceImpl implements CustCreditScoreQueryService {

    private final CustCreditScoreMapper custCreditScoreMapper;

    public CustCreditScoreQueryServiceImpl(CustCreditScoreMapper custCreditScoreMapper) {
        this.custCreditScoreMapper = custCreditScoreMapper;
    }

    public List<CustCreditScore> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCreditScore> result = new ArrayList<CustCreditScore>();
        CustCreditScoreExample example01A = new CustCreditScoreExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCreditScoreMapper.selectByExample(example01A));
        CustCreditScoreExample example01B = new CustCreditScoreExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCreditScoreMapper.selectByExample(example01B));
        return result;
    }

    public List<CustCreditScore> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCreditScore> result = new ArrayList<CustCreditScore>();
        CustCreditScoreExample example02A = new CustCreditScoreExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCreditScoreMapper.selectByExample(example02A));
        CustCreditScoreExample example02B = new CustCreditScoreExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCreditScoreMapper.selectByExample(example02B));
        return result;
    }

    public List<CustCreditScore> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCreditScore> result = new ArrayList<CustCreditScore>();
        CustCreditScoreExample example03A = new CustCreditScoreExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCreditScoreMapper.selectByExample(example03A));
        CustCreditScoreExample example03B = new CustCreditScoreExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custCreditScoreMapper.selectByExample(example03B));
        return result;
    }

    public List<CustCreditScore> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCreditScore> result = new ArrayList<CustCreditScore>();
        CustCreditScoreExample example04A = new CustCreditScoreExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custCreditScoreMapper.selectByExample(example04A));
        CustCreditScoreExample example04B = new CustCreditScoreExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCreditScoreMapper.selectByExample(example04B));
        return result;
    }

    public List<CustCreditScore> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCreditScore> result = new ArrayList<CustCreditScore>();
        CustCreditScoreExample example05A = new CustCreditScoreExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCreditScoreMapper.selectByExample(example05A));
        CustCreditScoreExample example05B = new CustCreditScoreExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCreditScoreMapper.selectByExample(example05B));
        return result;
    }

    public List<CustCreditScore> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCreditScore> result = new ArrayList<CustCreditScore>();
        CustCreditScoreExample example06A = new CustCreditScoreExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCreditScoreMapper.selectByExample(example06A));
        CustCreditScoreExample example06B = new CustCreditScoreExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCreditScoreMapper.selectByExample(example06B));
        return result;
    }

}
