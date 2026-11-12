package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustRefund;
import cn.song.custmetadata.example.CustRefundExample;
import cn.song.custmetadata.mapper.CustRefundMapper;
import cn.song.custmetadata.service.CustRefundQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户退款 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustRefundQueryServiceImpl implements CustRefundQueryService {

    private final CustRefundMapper custRefundMapper;

    public CustRefundQueryServiceImpl(CustRefundMapper custRefundMapper) {
        this.custRefundMapper = custRefundMapper;
    }

    public List<CustRefund> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRefund> result = new ArrayList<CustRefund>();
        CustRefundExample example01A = new CustRefundExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custRefundMapper.selectByExample(example01A));
        CustRefundExample example01B = new CustRefundExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custRefundMapper.selectByExample(example01B));
        return result;
    }

    public List<CustRefund> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRefund> result = new ArrayList<CustRefund>();
        CustRefundExample example02A = new CustRefundExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custRefundMapper.selectByExample(example02A));
        CustRefundExample example02B = new CustRefundExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custRefundMapper.selectByExample(example02B));
        return result;
    }

    public List<CustRefund> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRefund> result = new ArrayList<CustRefund>();
        CustRefundExample example03A = new CustRefundExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custRefundMapper.selectByExample(example03A));
        CustRefundExample example03B = new CustRefundExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custRefundMapper.selectByExample(example03B));
        return result;
    }

    public List<CustRefund> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRefund> result = new ArrayList<CustRefund>();
        CustRefundExample example04A = new CustRefundExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custRefundMapper.selectByExample(example04A));
        CustRefundExample example04B = new CustRefundExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custRefundMapper.selectByExample(example04B));
        return result;
    }

    public List<CustRefund> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRefund> result = new ArrayList<CustRefund>();
        CustRefundExample example05A = new CustRefundExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custRefundMapper.selectByExample(example05A));
        CustRefundExample example05B = new CustRefundExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custRefundMapper.selectByExample(example05B));
        return result;
    }

    public List<CustRefund> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRefund> result = new ArrayList<CustRefund>();
        CustRefundExample example06A = new CustRefundExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custRefundMapper.selectByExample(example06A));
        CustRefundExample example06B = new CustRefundExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custRefundMapper.selectByExample(example06B));
        return result;
    }

}
