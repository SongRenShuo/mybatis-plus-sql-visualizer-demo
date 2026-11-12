package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustGroupRel;
import cn.song.custmetadata.example.CustGroupRelExample;
import cn.song.custmetadata.mapper.CustGroupRelMapper;
import cn.song.custmetadata.service.CustGroupRelQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户群组关系 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustGroupRelQueryServiceImpl implements CustGroupRelQueryService {

    private final CustGroupRelMapper custGroupRelMapper;

    public CustGroupRelQueryServiceImpl(CustGroupRelMapper custGroupRelMapper) {
        this.custGroupRelMapper = custGroupRelMapper;
    }

    public List<CustGroupRel> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustGroupRel> result = new ArrayList<CustGroupRel>();
        CustGroupRelExample example01A = new CustGroupRelExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custGroupRelMapper.selectByExample(example01A));
        CustGroupRelExample example01B = new CustGroupRelExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custGroupRelMapper.selectByExample(example01B));
        return result;
    }

    public List<CustGroupRel> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustGroupRel> result = new ArrayList<CustGroupRel>();
        CustGroupRelExample example02A = new CustGroupRelExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custGroupRelMapper.selectByExample(example02A));
        CustGroupRelExample example02B = new CustGroupRelExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custGroupRelMapper.selectByExample(example02B));
        return result;
    }

    public List<CustGroupRel> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustGroupRel> result = new ArrayList<CustGroupRel>();
        CustGroupRelExample example03A = new CustGroupRelExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custGroupRelMapper.selectByExample(example03A));
        CustGroupRelExample example03B = new CustGroupRelExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custGroupRelMapper.selectByExample(example03B));
        return result;
    }

    public List<CustGroupRel> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustGroupRel> result = new ArrayList<CustGroupRel>();
        CustGroupRelExample example04A = new CustGroupRelExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custGroupRelMapper.selectByExample(example04A));
        CustGroupRelExample example04B = new CustGroupRelExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custGroupRelMapper.selectByExample(example04B));
        return result;
    }

    public List<CustGroupRel> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustGroupRel> result = new ArrayList<CustGroupRel>();
        CustGroupRelExample example05A = new CustGroupRelExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custGroupRelMapper.selectByExample(example05A));
        CustGroupRelExample example05B = new CustGroupRelExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custGroupRelMapper.selectByExample(example05B));
        return result;
    }

    public List<CustGroupRel> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustGroupRel> result = new ArrayList<CustGroupRel>();
        CustGroupRelExample example06A = new CustGroupRelExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custGroupRelMapper.selectByExample(example06A));
        CustGroupRelExample example06B = new CustGroupRelExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custGroupRelMapper.selectByExample(example06B));
        return result;
    }

}
