package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustNote;
import cn.song.custmetadata.example.CustNoteExample;
import cn.song.custmetadata.mapper.CustNoteMapper;
import cn.song.custmetadata.service.CustNoteQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户备注 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustNoteQueryServiceImpl implements CustNoteQueryService {

    private final CustNoteMapper custNoteMapper;

    public CustNoteQueryServiceImpl(CustNoteMapper custNoteMapper) {
        this.custNoteMapper = custNoteMapper;
    }

    public List<CustNote> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustNote> result = new ArrayList<CustNote>();
        CustNoteExample example01A = new CustNoteExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custNoteMapper.selectByExample(example01A));
        CustNoteExample example01B = new CustNoteExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custNoteMapper.selectByExample(example01B));
        return result;
    }

    public List<CustNote> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustNote> result = new ArrayList<CustNote>();
        CustNoteExample example02A = new CustNoteExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custNoteMapper.selectByExample(example02A));
        CustNoteExample example02B = new CustNoteExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custNoteMapper.selectByExample(example02B));
        return result;
    }

    public List<CustNote> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustNote> result = new ArrayList<CustNote>();
        CustNoteExample example03A = new CustNoteExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custNoteMapper.selectByExample(example03A));
        CustNoteExample example03B = new CustNoteExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custNoteMapper.selectByExample(example03B));
        return result;
    }

    public List<CustNote> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustNote> result = new ArrayList<CustNote>();
        CustNoteExample example04A = new CustNoteExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custNoteMapper.selectByExample(example04A));
        CustNoteExample example04B = new CustNoteExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custNoteMapper.selectByExample(example04B));
        return result;
    }

    public List<CustNote> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustNote> result = new ArrayList<CustNote>();
        CustNoteExample example05A = new CustNoteExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custNoteMapper.selectByExample(example05A));
        CustNoteExample example05B = new CustNoteExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custNoteMapper.selectByExample(example05B));
        return result;
    }

    public List<CustNote> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustNote> result = new ArrayList<CustNote>();
        CustNoteExample example06A = new CustNoteExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custNoteMapper.selectByExample(example06A));
        CustNoteExample example06B = new CustNoteExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custNoteMapper.selectByExample(example06B));
        return result;
    }

}
