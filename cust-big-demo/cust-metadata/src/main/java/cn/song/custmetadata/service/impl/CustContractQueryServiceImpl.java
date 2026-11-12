package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustContract;
import cn.song.custmetadata.example.CustContractExample;
import cn.song.custmetadata.mapper.CustContractMapper;
import cn.song.custmetadata.service.CustContractQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户合同 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustContractQueryServiceImpl implements CustContractQueryService {

    private final CustContractMapper custContractMapper;

    public CustContractQueryServiceImpl(CustContractMapper custContractMapper) {
        this.custContractMapper = custContractMapper;
    }

    public List<CustContract> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContract> result = new ArrayList<CustContract>();
        CustContractExample example01A = new CustContractExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContractMapper.selectByExample(example01A));
        CustContractExample example01B = new CustContractExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContractMapper.selectByExample(example01B));
        return result;
    }

    public List<CustContract> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContract> result = new ArrayList<CustContract>();
        CustContractExample example02A = new CustContractExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContractMapper.selectByExample(example02A));
        CustContractExample example02B = new CustContractExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContractMapper.selectByExample(example02B));
        return result;
    }

    public List<CustContract> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContract> result = new ArrayList<CustContract>();
        CustContractExample example03A = new CustContractExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContractMapper.selectByExample(example03A));
        CustContractExample example03B = new CustContractExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContractMapper.selectByExample(example03B));
        return result;
    }

    public List<CustContract> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContract> result = new ArrayList<CustContract>();
        CustContractExample example04A = new CustContractExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContractMapper.selectByExample(example04A));
        CustContractExample example04B = new CustContractExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContractMapper.selectByExample(example04B));
        return result;
    }

    public List<CustContract> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContract> result = new ArrayList<CustContract>();
        CustContractExample example05A = new CustContractExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContractMapper.selectByExample(example05A));
        CustContractExample example05B = new CustContractExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContractMapper.selectByExample(example05B));
        return result;
    }

    public List<CustContract> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContract> result = new ArrayList<CustContract>();
        CustContractExample example06A = new CustContractExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContractMapper.selectByExample(example06A));
        CustContractExample example06B = new CustContractExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContractMapper.selectByExample(example06B));
        return result;
    }

}
