package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustOrder;
import cn.song.custmetadata.example.CustOrderExample;
import cn.song.custmetadata.mapper.CustOrderMapper;
import cn.song.custmetadata.service.CustOrderQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户订单 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustOrderQueryServiceImpl implements CustOrderQueryService {

    private final CustOrderMapper custOrderMapper;

    public CustOrderQueryServiceImpl(CustOrderMapper custOrderMapper) {
        this.custOrderMapper = custOrderMapper;
    }

    public List<CustOrder> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustOrder> result = new ArrayList<CustOrder>();
        CustOrderExample example01A = new CustOrderExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custOrderMapper.selectByExample(example01A));
        CustOrderExample example01B = new CustOrderExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custOrderMapper.selectByExample(example01B));
        return result;
    }

    public List<CustOrder> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustOrder> result = new ArrayList<CustOrder>();
        CustOrderExample example02A = new CustOrderExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custOrderMapper.selectByExample(example02A));
        CustOrderExample example02B = new CustOrderExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custOrderMapper.selectByExample(example02B));
        return result;
    }

    public List<CustOrder> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustOrder> result = new ArrayList<CustOrder>();
        CustOrderExample example03A = new CustOrderExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custOrderMapper.selectByExample(example03A));
        CustOrderExample example03B = new CustOrderExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custOrderMapper.selectByExample(example03B));
        return result;
    }

    public List<CustOrder> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustOrder> result = new ArrayList<CustOrder>();
        CustOrderExample example04A = new CustOrderExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custOrderMapper.selectByExample(example04A));
        CustOrderExample example04B = new CustOrderExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custOrderMapper.selectByExample(example04B));
        return result;
    }

    public List<CustOrder> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustOrder> result = new ArrayList<CustOrder>();
        CustOrderExample example05A = new CustOrderExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custOrderMapper.selectByExample(example05A));
        CustOrderExample example05B = new CustOrderExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custOrderMapper.selectByExample(example05B));
        return result;
    }

    public List<CustOrder> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustOrder> result = new ArrayList<CustOrder>();
        CustOrderExample example06A = new CustOrderExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custOrderMapper.selectByExample(example06A));
        CustOrderExample example06B = new CustOrderExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custOrderMapper.selectByExample(example06B));
        return result;
    }

}
