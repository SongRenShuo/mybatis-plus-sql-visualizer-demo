package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustTag;
import cn.song.custmetadata.example.CustTagExample;
import cn.song.custmetadata.mapper.CustTagMapper;
import cn.song.custmetadata.service.CustTagQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户标签 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustTagQueryServiceImpl implements CustTagQueryService {

    private final CustTagMapper custTagMapper;

    public CustTagQueryServiceImpl(CustTagMapper custTagMapper) {
        this.custTagMapper = custTagMapper;
    }

    public List<CustTag> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample example01A = new CustTagExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(example01A));
        CustTagExample example01B = new CustTagExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(example01B));
        return result;
    }

    public List<CustTag> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample example02A = new CustTagExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(example02A));
        CustTagExample example02B = new CustTagExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(example02B));
        return result;
    }

    public List<CustTag> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample example03A = new CustTagExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(example03A));
        CustTagExample example03B = new CustTagExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagMapper.selectByExample(example03B));
        return result;
    }

    public List<CustTag> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample example04A = new CustTagExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagMapper.selectByExample(example04A));
        CustTagExample example04B = new CustTagExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(example04B));
        return result;
    }

    public List<CustTag> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample example05A = new CustTagExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(example05A));
        CustTagExample example05B = new CustTagExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(example05B));
        return result;
    }

    public List<CustTag> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample example06A = new CustTagExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(example06A));
        CustTagExample example06B = new CustTagExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(example06B));
        return result;
    }

}
