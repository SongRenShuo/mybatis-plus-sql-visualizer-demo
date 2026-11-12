package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustInvoice;
import cn.song.custmetadata.example.CustInvoiceExample;
import cn.song.custmetadata.mapper.CustInvoiceMapper;
import cn.song.custmetadata.service.CustInvoiceQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户发票 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustInvoiceQueryServiceImpl implements CustInvoiceQueryService {

    private final CustInvoiceMapper custInvoiceMapper;

    public CustInvoiceQueryServiceImpl(CustInvoiceMapper custInvoiceMapper) {
        this.custInvoiceMapper = custInvoiceMapper;
    }

    public List<CustInvoice> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInvoice> result = new ArrayList<CustInvoice>();
        CustInvoiceExample example01A = new CustInvoiceExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInvoiceMapper.selectByExample(example01A));
        CustInvoiceExample example01B = new CustInvoiceExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInvoiceMapper.selectByExample(example01B));
        return result;
    }

    public List<CustInvoice> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInvoice> result = new ArrayList<CustInvoice>();
        CustInvoiceExample example02A = new CustInvoiceExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInvoiceMapper.selectByExample(example02A));
        CustInvoiceExample example02B = new CustInvoiceExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInvoiceMapper.selectByExample(example02B));
        return result;
    }

    public List<CustInvoice> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInvoice> result = new ArrayList<CustInvoice>();
        CustInvoiceExample example03A = new CustInvoiceExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInvoiceMapper.selectByExample(example03A));
        CustInvoiceExample example03B = new CustInvoiceExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInvoiceMapper.selectByExample(example03B));
        return result;
    }

    public List<CustInvoice> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInvoice> result = new ArrayList<CustInvoice>();
        CustInvoiceExample example04A = new CustInvoiceExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInvoiceMapper.selectByExample(example04A));
        CustInvoiceExample example04B = new CustInvoiceExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInvoiceMapper.selectByExample(example04B));
        return result;
    }

    public List<CustInvoice> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInvoice> result = new ArrayList<CustInvoice>();
        CustInvoiceExample example05A = new CustInvoiceExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInvoiceMapper.selectByExample(example05A));
        CustInvoiceExample example05B = new CustInvoiceExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInvoiceMapper.selectByExample(example05B));
        return result;
    }

    public List<CustInvoice> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInvoice> result = new ArrayList<CustInvoice>();
        CustInvoiceExample example06A = new CustInvoiceExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInvoiceMapper.selectByExample(example06A));
        CustInvoiceExample example06B = new CustInvoiceExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInvoiceMapper.selectByExample(example06B));
        return result;
    }

}
