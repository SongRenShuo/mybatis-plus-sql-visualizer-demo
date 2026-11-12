package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustOrderItem;
import cn.song.custmetadata.example.CustOrderItemExample;
import cn.song.custmetadata.mapper.CustOrderItemMapper;
import cn.song.custmetadata.service.CustOrderItemQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户订单明细 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustOrderItemQueryServiceImpl implements CustOrderItemQueryService {

    private final CustOrderItemMapper custOrderItemMapper;

    public CustOrderItemQueryServiceImpl(CustOrderItemMapper custOrderItemMapper) {
        this.custOrderItemMapper = custOrderItemMapper;
    }

    public List<CustOrderItem> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustOrderItem> result = new ArrayList<CustOrderItem>();
        CustOrderItemExample example01A = new CustOrderItemExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custOrderItemMapper.selectByExample(example01A));
        CustOrderItemExample example01B = new CustOrderItemExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custOrderItemMapper.selectByExample(example01B));
        return result;
    }

    public List<CustOrderItem> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustOrderItem> result = new ArrayList<CustOrderItem>();
        CustOrderItemExample example02A = new CustOrderItemExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custOrderItemMapper.selectByExample(example02A));
        CustOrderItemExample example02B = new CustOrderItemExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custOrderItemMapper.selectByExample(example02B));
        return result;
    }

    public List<CustOrderItem> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustOrderItem> result = new ArrayList<CustOrderItem>();
        CustOrderItemExample example03A = new CustOrderItemExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custOrderItemMapper.selectByExample(example03A));
        CustOrderItemExample example03B = new CustOrderItemExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custOrderItemMapper.selectByExample(example03B));
        return result;
    }

    public List<CustOrderItem> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustOrderItem> result = new ArrayList<CustOrderItem>();
        CustOrderItemExample example04A = new CustOrderItemExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custOrderItemMapper.selectByExample(example04A));
        CustOrderItemExample example04B = new CustOrderItemExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custOrderItemMapper.selectByExample(example04B));
        return result;
    }

    public List<CustOrderItem> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustOrderItem> result = new ArrayList<CustOrderItem>();
        CustOrderItemExample example05A = new CustOrderItemExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custOrderItemMapper.selectByExample(example05A));
        CustOrderItemExample example05B = new CustOrderItemExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custOrderItemMapper.selectByExample(example05B));
        return result;
    }

    public List<CustOrderItem> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustOrderItem> result = new ArrayList<CustOrderItem>();
        CustOrderItemExample example06A = new CustOrderItemExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custOrderItemMapper.selectByExample(example06A));
        CustOrderItemExample example06B = new CustOrderItemExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custOrderItemMapper.selectByExample(example06B));
        return result;
    }

}
