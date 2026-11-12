package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustSettlement;
import cn.song.custmetadata.example.CustSettlementExample;
import cn.song.custmetadata.mapper.CustSettlementMapper;
import cn.song.custmetadata.service.CustSettlementQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户结算 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustSettlementQueryServiceImpl implements CustSettlementQueryService {

    private final CustSettlementMapper custSettlementMapper;

    public CustSettlementQueryServiceImpl(CustSettlementMapper custSettlementMapper) {
        this.custSettlementMapper = custSettlementMapper;
    }

    public List<CustSettlement> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustSettlement> result = new ArrayList<CustSettlement>();
        CustSettlementExample example01A = new CustSettlementExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custSettlementMapper.selectByExample(example01A));
        CustSettlementExample example01B = new CustSettlementExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custSettlementMapper.selectByExample(example01B));
        return result;
    }

    public List<CustSettlement> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustSettlement> result = new ArrayList<CustSettlement>();
        CustSettlementExample example02A = new CustSettlementExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custSettlementMapper.selectByExample(example02A));
        CustSettlementExample example02B = new CustSettlementExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custSettlementMapper.selectByExample(example02B));
        return result;
    }

    public List<CustSettlement> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustSettlement> result = new ArrayList<CustSettlement>();
        CustSettlementExample example03A = new CustSettlementExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custSettlementMapper.selectByExample(example03A));
        CustSettlementExample example03B = new CustSettlementExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custSettlementMapper.selectByExample(example03B));
        return result;
    }

    public List<CustSettlement> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustSettlement> result = new ArrayList<CustSettlement>();
        CustSettlementExample example04A = new CustSettlementExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custSettlementMapper.selectByExample(example04A));
        CustSettlementExample example04B = new CustSettlementExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custSettlementMapper.selectByExample(example04B));
        return result;
    }

    public List<CustSettlement> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustSettlement> result = new ArrayList<CustSettlement>();
        CustSettlementExample example05A = new CustSettlementExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custSettlementMapper.selectByExample(example05A));
        CustSettlementExample example05B = new CustSettlementExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custSettlementMapper.selectByExample(example05B));
        return result;
    }

    public List<CustSettlement> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustSettlement> result = new ArrayList<CustSettlement>();
        CustSettlementExample example06A = new CustSettlementExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custSettlementMapper.selectByExample(example06A));
        CustSettlementExample example06B = new CustSettlementExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custSettlementMapper.selectByExample(example06B));
        return result;
    }

}
