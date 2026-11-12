package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustScoreLog;
import cn.song.custmetadata.example.CustScoreLogExample;
import cn.song.custmetadata.mapper.CustScoreLogMapper;
import cn.song.custmetadata.service.CustScoreLogQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户评分日志 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustScoreLogQueryServiceImpl implements CustScoreLogQueryService {

    private final CustScoreLogMapper custScoreLogMapper;

    public CustScoreLogQueryServiceImpl(CustScoreLogMapper custScoreLogMapper) {
        this.custScoreLogMapper = custScoreLogMapper;
    }

    public List<CustScoreLog> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustScoreLog> result = new ArrayList<CustScoreLog>();
        CustScoreLogExample example01A = new CustScoreLogExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custScoreLogMapper.selectByExample(example01A));
        CustScoreLogExample example01B = new CustScoreLogExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custScoreLogMapper.selectByExample(example01B));
        return result;
    }

    public List<CustScoreLog> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustScoreLog> result = new ArrayList<CustScoreLog>();
        CustScoreLogExample example02A = new CustScoreLogExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custScoreLogMapper.selectByExample(example02A));
        CustScoreLogExample example02B = new CustScoreLogExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custScoreLogMapper.selectByExample(example02B));
        return result;
    }

    public List<CustScoreLog> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustScoreLog> result = new ArrayList<CustScoreLog>();
        CustScoreLogExample example03A = new CustScoreLogExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custScoreLogMapper.selectByExample(example03A));
        CustScoreLogExample example03B = new CustScoreLogExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custScoreLogMapper.selectByExample(example03B));
        return result;
    }

    public List<CustScoreLog> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustScoreLog> result = new ArrayList<CustScoreLog>();
        CustScoreLogExample example04A = new CustScoreLogExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custScoreLogMapper.selectByExample(example04A));
        CustScoreLogExample example04B = new CustScoreLogExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custScoreLogMapper.selectByExample(example04B));
        return result;
    }

    public List<CustScoreLog> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustScoreLog> result = new ArrayList<CustScoreLog>();
        CustScoreLogExample example05A = new CustScoreLogExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custScoreLogMapper.selectByExample(example05A));
        CustScoreLogExample example05B = new CustScoreLogExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custScoreLogMapper.selectByExample(example05B));
        return result;
    }

    public List<CustScoreLog> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustScoreLog> result = new ArrayList<CustScoreLog>();
        CustScoreLogExample example06A = new CustScoreLogExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custScoreLogMapper.selectByExample(example06A));
        CustScoreLogExample example06B = new CustScoreLogExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custScoreLogMapper.selectByExample(example06B));
        return result;
    }

}
