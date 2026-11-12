package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustRiskItem;
import cn.song.custmetadata.example.CustRiskItemExample;
import cn.song.custmetadata.mapper.CustRiskItemMapper;
import cn.song.custmetadata.service.CustRiskItemQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户风险项 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustRiskItemQueryServiceImpl implements CustRiskItemQueryService {

    private final CustRiskItemMapper custRiskItemMapper;

    public CustRiskItemQueryServiceImpl(CustRiskItemMapper custRiskItemMapper) {
        this.custRiskItemMapper = custRiskItemMapper;
    }

    public List<CustRiskItem> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRiskItem> result = new ArrayList<CustRiskItem>();
        CustRiskItemExample example01A = new CustRiskItemExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custRiskItemMapper.selectByExample(example01A));
        CustRiskItemExample example01B = new CustRiskItemExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custRiskItemMapper.selectByExample(example01B));
        return result;
    }

    public List<CustRiskItem> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRiskItem> result = new ArrayList<CustRiskItem>();
        CustRiskItemExample example02A = new CustRiskItemExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custRiskItemMapper.selectByExample(example02A));
        CustRiskItemExample example02B = new CustRiskItemExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custRiskItemMapper.selectByExample(example02B));
        return result;
    }

    public List<CustRiskItem> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRiskItem> result = new ArrayList<CustRiskItem>();
        CustRiskItemExample example03A = new CustRiskItemExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custRiskItemMapper.selectByExample(example03A));
        CustRiskItemExample example03B = new CustRiskItemExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custRiskItemMapper.selectByExample(example03B));
        return result;
    }

    public List<CustRiskItem> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRiskItem> result = new ArrayList<CustRiskItem>();
        CustRiskItemExample example04A = new CustRiskItemExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custRiskItemMapper.selectByExample(example04A));
        CustRiskItemExample example04B = new CustRiskItemExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custRiskItemMapper.selectByExample(example04B));
        return result;
    }

    public List<CustRiskItem> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRiskItem> result = new ArrayList<CustRiskItem>();
        CustRiskItemExample example05A = new CustRiskItemExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custRiskItemMapper.selectByExample(example05A));
        CustRiskItemExample example05B = new CustRiskItemExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custRiskItemMapper.selectByExample(example05B));
        return result;
    }

    public List<CustRiskItem> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustRiskItem> result = new ArrayList<CustRiskItem>();
        CustRiskItemExample example06A = new CustRiskItemExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custRiskItemMapper.selectByExample(example06A));
        CustRiskItemExample example06B = new CustRiskItemExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custRiskItemMapper.selectByExample(example06B));
        return result;
    }

}
