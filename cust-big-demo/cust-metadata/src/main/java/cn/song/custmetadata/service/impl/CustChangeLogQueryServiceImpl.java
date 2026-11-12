package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustChangeLog;
import cn.song.custmetadata.example.CustChangeLogExample;
import cn.song.custmetadata.mapper.CustChangeLogMapper;
import cn.song.custmetadata.service.CustChangeLogQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户变更日志 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustChangeLogQueryServiceImpl implements CustChangeLogQueryService {

    private final CustChangeLogMapper custChangeLogMapper;

    public CustChangeLogQueryServiceImpl(CustChangeLogMapper custChangeLogMapper) {
        this.custChangeLogMapper = custChangeLogMapper;
    }

    public List<CustChangeLog> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustChangeLog> result = new ArrayList<CustChangeLog>();
        CustChangeLogExample example01A = new CustChangeLogExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custChangeLogMapper.selectByExample(example01A));
        CustChangeLogExample example01B = new CustChangeLogExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custChangeLogMapper.selectByExample(example01B));
        return result;
    }

    public List<CustChangeLog> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustChangeLog> result = new ArrayList<CustChangeLog>();
        CustChangeLogExample example02A = new CustChangeLogExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custChangeLogMapper.selectByExample(example02A));
        CustChangeLogExample example02B = new CustChangeLogExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custChangeLogMapper.selectByExample(example02B));
        return result;
    }

    public List<CustChangeLog> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustChangeLog> result = new ArrayList<CustChangeLog>();
        CustChangeLogExample example03A = new CustChangeLogExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custChangeLogMapper.selectByExample(example03A));
        CustChangeLogExample example03B = new CustChangeLogExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custChangeLogMapper.selectByExample(example03B));
        return result;
    }

    public List<CustChangeLog> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustChangeLog> result = new ArrayList<CustChangeLog>();
        CustChangeLogExample example04A = new CustChangeLogExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custChangeLogMapper.selectByExample(example04A));
        CustChangeLogExample example04B = new CustChangeLogExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custChangeLogMapper.selectByExample(example04B));
        return result;
    }

    public List<CustChangeLog> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustChangeLog> result = new ArrayList<CustChangeLog>();
        CustChangeLogExample example05A = new CustChangeLogExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custChangeLogMapper.selectByExample(example05A));
        CustChangeLogExample example05B = new CustChangeLogExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custChangeLogMapper.selectByExample(example05B));
        return result;
    }

    public List<CustChangeLog> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustChangeLog> result = new ArrayList<CustChangeLog>();
        CustChangeLogExample example06A = new CustChangeLogExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custChangeLogMapper.selectByExample(example06A));
        CustChangeLogExample example06B = new CustChangeLogExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custChangeLogMapper.selectByExample(example06B));
        return result;
    }

}
