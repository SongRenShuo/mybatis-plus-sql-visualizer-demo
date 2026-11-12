package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustPayment;
import cn.song.custmetadata.example.CustPaymentExample;
import cn.song.custmetadata.mapper.CustPaymentMapper;
import cn.song.custmetadata.service.CustPaymentQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户付款 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustPaymentQueryServiceImpl implements CustPaymentQueryService {

    private final CustPaymentMapper custPaymentMapper;

    public CustPaymentQueryServiceImpl(CustPaymentMapper custPaymentMapper) {
        this.custPaymentMapper = custPaymentMapper;
    }

    public List<CustPayment> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustPayment> result = new ArrayList<CustPayment>();
        CustPaymentExample example01A = new CustPaymentExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custPaymentMapper.selectByExample(example01A));
        CustPaymentExample example01B = new CustPaymentExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custPaymentMapper.selectByExample(example01B));
        return result;
    }

    public List<CustPayment> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustPayment> result = new ArrayList<CustPayment>();
        CustPaymentExample example02A = new CustPaymentExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custPaymentMapper.selectByExample(example02A));
        CustPaymentExample example02B = new CustPaymentExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custPaymentMapper.selectByExample(example02B));
        return result;
    }

    public List<CustPayment> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustPayment> result = new ArrayList<CustPayment>();
        CustPaymentExample example03A = new CustPaymentExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custPaymentMapper.selectByExample(example03A));
        CustPaymentExample example03B = new CustPaymentExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custPaymentMapper.selectByExample(example03B));
        return result;
    }

    public List<CustPayment> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustPayment> result = new ArrayList<CustPayment>();
        CustPaymentExample example04A = new CustPaymentExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custPaymentMapper.selectByExample(example04A));
        CustPaymentExample example04B = new CustPaymentExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custPaymentMapper.selectByExample(example04B));
        return result;
    }

    public List<CustPayment> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustPayment> result = new ArrayList<CustPayment>();
        CustPaymentExample example05A = new CustPaymentExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custPaymentMapper.selectByExample(example05A));
        CustPaymentExample example05B = new CustPaymentExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custPaymentMapper.selectByExample(example05B));
        return result;
    }

    public List<CustPayment> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustPayment> result = new ArrayList<CustPayment>();
        CustPaymentExample example06A = new CustPaymentExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custPaymentMapper.selectByExample(example06A));
        CustPaymentExample example06B = new CustPaymentExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custPaymentMapper.selectByExample(example06B));
        return result;
    }

}
