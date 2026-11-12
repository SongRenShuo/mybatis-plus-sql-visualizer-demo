package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustAttach;
import cn.song.custmetadata.example.CustAttachExample;
import cn.song.custmetadata.mapper.CustAttachMapper;
import cn.song.custmetadata.service.CustAttachQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户附件 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustAttachQueryServiceImpl implements CustAttachQueryService {

    private final CustAttachMapper custAttachMapper;

    public CustAttachQueryServiceImpl(CustAttachMapper custAttachMapper) {
        this.custAttachMapper = custAttachMapper;
    }

    public List<CustAttach> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAttach> result = new ArrayList<CustAttach>();
        CustAttachExample example01A = new CustAttachExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAttachMapper.selectByExample(example01A));
        CustAttachExample example01B = new CustAttachExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAttachMapper.selectByExample(example01B));
        return result;
    }

    public List<CustAttach> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAttach> result = new ArrayList<CustAttach>();
        CustAttachExample example02A = new CustAttachExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAttachMapper.selectByExample(example02A));
        CustAttachExample example02B = new CustAttachExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAttachMapper.selectByExample(example02B));
        return result;
    }

    public List<CustAttach> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAttach> result = new ArrayList<CustAttach>();
        CustAttachExample example03A = new CustAttachExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAttachMapper.selectByExample(example03A));
        CustAttachExample example03B = new CustAttachExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAttachMapper.selectByExample(example03B));
        return result;
    }

    public List<CustAttach> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAttach> result = new ArrayList<CustAttach>();
        CustAttachExample example04A = new CustAttachExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAttachMapper.selectByExample(example04A));
        CustAttachExample example04B = new CustAttachExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAttachMapper.selectByExample(example04B));
        return result;
    }

    public List<CustAttach> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAttach> result = new ArrayList<CustAttach>();
        CustAttachExample example05A = new CustAttachExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAttachMapper.selectByExample(example05A));
        CustAttachExample example05B = new CustAttachExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAttachMapper.selectByExample(example05B));
        return result;
    }

    public List<CustAttach> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAttach> result = new ArrayList<CustAttach>();
        CustAttachExample example06A = new CustAttachExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAttachMapper.selectByExample(example06A));
        CustAttachExample example06B = new CustAttachExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAttachMapper.selectByExample(example06B));
        return result;
    }

}
