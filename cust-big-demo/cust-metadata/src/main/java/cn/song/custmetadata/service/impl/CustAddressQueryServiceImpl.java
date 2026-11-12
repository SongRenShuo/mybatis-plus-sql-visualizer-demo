package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustAddress;
import cn.song.custmetadata.example.CustAddressExample;
import cn.song.custmetadata.mapper.CustAddressMapper;
import cn.song.custmetadata.service.CustAddressQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户地址 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustAddressQueryServiceImpl implements CustAddressQueryService {

    private final CustAddressMapper custAddressMapper;

    public CustAddressQueryServiceImpl(CustAddressMapper custAddressMapper) {
        this.custAddressMapper = custAddressMapper;
    }

    public List<CustAddress> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample example01A = new CustAddressExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(example01A));
        CustAddressExample example01B = new CustAddressExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(example01B));
        return result;
    }

    public List<CustAddress> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample example02A = new CustAddressExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(example02A));
        CustAddressExample example02B = new CustAddressExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(example02B));
        return result;
    }

    public List<CustAddress> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample example03A = new CustAddressExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(example03A));
        CustAddressExample example03B = new CustAddressExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAddressMapper.selectByExample(example03B));
        return result;
    }

    public List<CustAddress> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample example04A = new CustAddressExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAddressMapper.selectByExample(example04A));
        CustAddressExample example04B = new CustAddressExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(example04B));
        return result;
    }

    public List<CustAddress> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample example05A = new CustAddressExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(example05A));
        CustAddressExample example05B = new CustAddressExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(example05B));
        return result;
    }

    public List<CustAddress> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample example06A = new CustAddressExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(example06A));
        CustAddressExample example06B = new CustAddressExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(example06B));
        return result;
    }

}
