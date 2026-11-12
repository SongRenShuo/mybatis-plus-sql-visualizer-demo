package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustContractItem;
import cn.song.custmetadata.example.CustContractItemExample;
import cn.song.custmetadata.mapper.CustContractItemMapper;
import cn.song.custmetadata.service.CustContractItemQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户合同明细 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustContractItemQueryServiceImpl implements CustContractItemQueryService {

    private final CustContractItemMapper custContractItemMapper;

    public CustContractItemQueryServiceImpl(CustContractItemMapper custContractItemMapper) {
        this.custContractItemMapper = custContractItemMapper;
    }

    public List<CustContractItem> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContractItem> result = new ArrayList<CustContractItem>();
        CustContractItemExample example01A = new CustContractItemExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContractItemMapper.selectByExample(example01A));
        CustContractItemExample example01B = new CustContractItemExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContractItemMapper.selectByExample(example01B));
        return result;
    }

    public List<CustContractItem> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContractItem> result = new ArrayList<CustContractItem>();
        CustContractItemExample example02A = new CustContractItemExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContractItemMapper.selectByExample(example02A));
        CustContractItemExample example02B = new CustContractItemExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContractItemMapper.selectByExample(example02B));
        return result;
    }

    public List<CustContractItem> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContractItem> result = new ArrayList<CustContractItem>();
        CustContractItemExample example03A = new CustContractItemExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContractItemMapper.selectByExample(example03A));
        CustContractItemExample example03B = new CustContractItemExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContractItemMapper.selectByExample(example03B));
        return result;
    }

    public List<CustContractItem> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContractItem> result = new ArrayList<CustContractItem>();
        CustContractItemExample example04A = new CustContractItemExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContractItemMapper.selectByExample(example04A));
        CustContractItemExample example04B = new CustContractItemExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContractItemMapper.selectByExample(example04B));
        return result;
    }

    public List<CustContractItem> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContractItem> result = new ArrayList<CustContractItem>();
        CustContractItemExample example05A = new CustContractItemExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContractItemMapper.selectByExample(example05A));
        CustContractItemExample example05B = new CustContractItemExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContractItemMapper.selectByExample(example05B));
        return result;
    }

    public List<CustContractItem> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContractItem> result = new ArrayList<CustContractItem>();
        CustContractItemExample example06A = new CustContractItemExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContractItemMapper.selectByExample(example06A));
        CustContractItemExample example06B = new CustContractItemExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContractItemMapper.selectByExample(example06B));
        return result;
    }

}
