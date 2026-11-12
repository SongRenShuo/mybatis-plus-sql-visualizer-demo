package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustAuditLog;
import cn.song.custmetadata.example.CustAuditLogExample;
import cn.song.custmetadata.mapper.CustAuditLogMapper;
import cn.song.custmetadata.service.CustAuditLogQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户审计日志 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustAuditLogQueryServiceImpl implements CustAuditLogQueryService {

    private final CustAuditLogMapper custAuditLogMapper;

    public CustAuditLogQueryServiceImpl(CustAuditLogMapper custAuditLogMapper) {
        this.custAuditLogMapper = custAuditLogMapper;
    }

    public List<CustAuditLog> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAuditLog> result = new ArrayList<CustAuditLog>();
        CustAuditLogExample example01A = new CustAuditLogExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAuditLogMapper.selectByExample(example01A));
        CustAuditLogExample example01B = new CustAuditLogExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAuditLogMapper.selectByExample(example01B));
        return result;
    }

    public List<CustAuditLog> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAuditLog> result = new ArrayList<CustAuditLog>();
        CustAuditLogExample example02A = new CustAuditLogExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAuditLogMapper.selectByExample(example02A));
        CustAuditLogExample example02B = new CustAuditLogExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAuditLogMapper.selectByExample(example02B));
        return result;
    }

    public List<CustAuditLog> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAuditLog> result = new ArrayList<CustAuditLog>();
        CustAuditLogExample example03A = new CustAuditLogExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAuditLogMapper.selectByExample(example03A));
        CustAuditLogExample example03B = new CustAuditLogExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAuditLogMapper.selectByExample(example03B));
        return result;
    }

    public List<CustAuditLog> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAuditLog> result = new ArrayList<CustAuditLog>();
        CustAuditLogExample example04A = new CustAuditLogExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAuditLogMapper.selectByExample(example04A));
        CustAuditLogExample example04B = new CustAuditLogExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAuditLogMapper.selectByExample(example04B));
        return result;
    }

    public List<CustAuditLog> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAuditLog> result = new ArrayList<CustAuditLog>();
        CustAuditLogExample example05A = new CustAuditLogExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAuditLogMapper.selectByExample(example05A));
        CustAuditLogExample example05B = new CustAuditLogExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAuditLogMapper.selectByExample(example05B));
        return result;
    }

    public List<CustAuditLog> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAuditLog> result = new ArrayList<CustAuditLog>();
        CustAuditLogExample example06A = new CustAuditLogExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAuditLogMapper.selectByExample(example06A));
        CustAuditLogExample example06B = new CustAuditLogExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAuditLogMapper.selectByExample(example06B));
        return result;
    }

}
