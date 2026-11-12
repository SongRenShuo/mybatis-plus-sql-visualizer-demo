package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustBankAcct;
import cn.song.custmetadata.example.CustBankAcctExample;
import cn.song.custmetadata.mapper.CustBankAcctMapper;
import cn.song.custmetadata.service.CustBankAcctQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户银行账户 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustBankAcctQueryServiceImpl implements CustBankAcctQueryService {

    private final CustBankAcctMapper custBankAcctMapper;

    public CustBankAcctQueryServiceImpl(CustBankAcctMapper custBankAcctMapper) {
        this.custBankAcctMapper = custBankAcctMapper;
    }

    public List<CustBankAcct> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustBankAcct> result = new ArrayList<CustBankAcct>();
        CustBankAcctExample example01A = new CustBankAcctExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custBankAcctMapper.selectByExample(example01A));
        CustBankAcctExample example01B = new CustBankAcctExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custBankAcctMapper.selectByExample(example01B));
        return result;
    }

    public List<CustBankAcct> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustBankAcct> result = new ArrayList<CustBankAcct>();
        CustBankAcctExample example02A = new CustBankAcctExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custBankAcctMapper.selectByExample(example02A));
        CustBankAcctExample example02B = new CustBankAcctExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custBankAcctMapper.selectByExample(example02B));
        return result;
    }

    public List<CustBankAcct> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustBankAcct> result = new ArrayList<CustBankAcct>();
        CustBankAcctExample example03A = new CustBankAcctExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custBankAcctMapper.selectByExample(example03A));
        CustBankAcctExample example03B = new CustBankAcctExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custBankAcctMapper.selectByExample(example03B));
        return result;
    }

    public List<CustBankAcct> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustBankAcct> result = new ArrayList<CustBankAcct>();
        CustBankAcctExample example04A = new CustBankAcctExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custBankAcctMapper.selectByExample(example04A));
        CustBankAcctExample example04B = new CustBankAcctExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custBankAcctMapper.selectByExample(example04B));
        return result;
    }

    public List<CustBankAcct> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustBankAcct> result = new ArrayList<CustBankAcct>();
        CustBankAcctExample example05A = new CustBankAcctExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custBankAcctMapper.selectByExample(example05A));
        CustBankAcctExample example05B = new CustBankAcctExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custBankAcctMapper.selectByExample(example05B));
        return result;
    }

    public List<CustBankAcct> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustBankAcct> result = new ArrayList<CustBankAcct>();
        CustBankAcctExample example06A = new CustBankAcctExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custBankAcctMapper.selectByExample(example06A));
        CustBankAcctExample example06B = new CustBankAcctExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custBankAcctMapper.selectByExample(example06B));
        return result;
    }

}
