package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustFollowUp;
import cn.song.custmetadata.example.CustFollowUpExample;
import cn.song.custmetadata.mapper.CustFollowUpMapper;
import cn.song.custmetadata.service.CustFollowUpQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户跟进 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustFollowUpQueryServiceImpl implements CustFollowUpQueryService {

    private final CustFollowUpMapper custFollowUpMapper;

    public CustFollowUpQueryServiceImpl(CustFollowUpMapper custFollowUpMapper) {
        this.custFollowUpMapper = custFollowUpMapper;
    }

    public List<CustFollowUp> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustFollowUp> result = new ArrayList<CustFollowUp>();
        CustFollowUpExample example01A = new CustFollowUpExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custFollowUpMapper.selectByExample(example01A));
        CustFollowUpExample example01B = new CustFollowUpExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custFollowUpMapper.selectByExample(example01B));
        return result;
    }

    public List<CustFollowUp> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustFollowUp> result = new ArrayList<CustFollowUp>();
        CustFollowUpExample example02A = new CustFollowUpExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custFollowUpMapper.selectByExample(example02A));
        CustFollowUpExample example02B = new CustFollowUpExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custFollowUpMapper.selectByExample(example02B));
        return result;
    }

    public List<CustFollowUp> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustFollowUp> result = new ArrayList<CustFollowUp>();
        CustFollowUpExample example03A = new CustFollowUpExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custFollowUpMapper.selectByExample(example03A));
        CustFollowUpExample example03B = new CustFollowUpExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custFollowUpMapper.selectByExample(example03B));
        return result;
    }

    public List<CustFollowUp> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustFollowUp> result = new ArrayList<CustFollowUp>();
        CustFollowUpExample example04A = new CustFollowUpExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custFollowUpMapper.selectByExample(example04A));
        CustFollowUpExample example04B = new CustFollowUpExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custFollowUpMapper.selectByExample(example04B));
        return result;
    }

    public List<CustFollowUp> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustFollowUp> result = new ArrayList<CustFollowUp>();
        CustFollowUpExample example05A = new CustFollowUpExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custFollowUpMapper.selectByExample(example05A));
        CustFollowUpExample example05B = new CustFollowUpExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custFollowUpMapper.selectByExample(example05B));
        return result;
    }

    public List<CustFollowUp> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustFollowUp> result = new ArrayList<CustFollowUp>();
        CustFollowUpExample example06A = new CustFollowUpExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custFollowUpMapper.selectByExample(example06A));
        CustFollowUpExample example06B = new CustFollowUpExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custFollowUpMapper.selectByExample(example06B));
        return result;
    }

}
