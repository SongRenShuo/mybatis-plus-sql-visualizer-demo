package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustVisitLog;
import cn.song.custmetadata.example.CustVisitLogExample;
import cn.song.custmetadata.mapper.CustVisitLogMapper;
import cn.song.custmetadata.service.CustVisitLogQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户拜访记录 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustVisitLogQueryServiceImpl implements CustVisitLogQueryService {

    private final CustVisitLogMapper custVisitLogMapper;

    public CustVisitLogQueryServiceImpl(CustVisitLogMapper custVisitLogMapper) {
        this.custVisitLogMapper = custVisitLogMapper;
    }

    public List<CustVisitLog> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustVisitLog> result = new ArrayList<CustVisitLog>();
        CustVisitLogExample example01A = new CustVisitLogExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custVisitLogMapper.selectByExample(example01A));
        CustVisitLogExample example01B = new CustVisitLogExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custVisitLogMapper.selectByExample(example01B));
        return result;
    }

    public List<CustVisitLog> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustVisitLog> result = new ArrayList<CustVisitLog>();
        CustVisitLogExample example02A = new CustVisitLogExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custVisitLogMapper.selectByExample(example02A));
        CustVisitLogExample example02B = new CustVisitLogExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custVisitLogMapper.selectByExample(example02B));
        return result;
    }

    public List<CustVisitLog> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustVisitLog> result = new ArrayList<CustVisitLog>();
        CustVisitLogExample example03A = new CustVisitLogExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custVisitLogMapper.selectByExample(example03A));
        CustVisitLogExample example03B = new CustVisitLogExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custVisitLogMapper.selectByExample(example03B));
        return result;
    }

    public List<CustVisitLog> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustVisitLog> result = new ArrayList<CustVisitLog>();
        CustVisitLogExample example04A = new CustVisitLogExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custVisitLogMapper.selectByExample(example04A));
        CustVisitLogExample example04B = new CustVisitLogExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custVisitLogMapper.selectByExample(example04B));
        return result;
    }

    public List<CustVisitLog> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustVisitLog> result = new ArrayList<CustVisitLog>();
        CustVisitLogExample example05A = new CustVisitLogExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custVisitLogMapper.selectByExample(example05A));
        CustVisitLogExample example05B = new CustVisitLogExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custVisitLogMapper.selectByExample(example05B));
        return result;
    }

    public List<CustVisitLog> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustVisitLog> result = new ArrayList<CustVisitLog>();
        CustVisitLogExample example06A = new CustVisitLogExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custVisitLogMapper.selectByExample(example06A));
        CustVisitLogExample example06B = new CustVisitLogExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custVisitLogMapper.selectByExample(example06B));
        return result;
    }

}
