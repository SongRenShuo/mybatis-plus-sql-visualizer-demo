package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustTagRel;
import cn.song.custmetadata.example.CustTagRelExample;
import cn.song.custmetadata.mapper.CustTagRelMapper;
import cn.song.custmetadata.service.CustTagRelQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户标签关系 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustTagRelQueryServiceImpl implements CustTagRelQueryService {

    private final CustTagRelMapper custTagRelMapper;

    public CustTagRelQueryServiceImpl(CustTagRelMapper custTagRelMapper) {
        this.custTagRelMapper = custTagRelMapper;
    }

    public List<CustTagRel> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTagRel> result = new ArrayList<CustTagRel>();
        CustTagRelExample example01A = new CustTagRelExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagRelMapper.selectByExample(example01A));
        CustTagRelExample example01B = new CustTagRelExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagRelMapper.selectByExample(example01B));
        return result;
    }

    public List<CustTagRel> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTagRel> result = new ArrayList<CustTagRel>();
        CustTagRelExample example02A = new CustTagRelExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagRelMapper.selectByExample(example02A));
        CustTagRelExample example02B = new CustTagRelExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagRelMapper.selectByExample(example02B));
        return result;
    }

    public List<CustTagRel> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTagRel> result = new ArrayList<CustTagRel>();
        CustTagRelExample example03A = new CustTagRelExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagRelMapper.selectByExample(example03A));
        CustTagRelExample example03B = new CustTagRelExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagRelMapper.selectByExample(example03B));
        return result;
    }

    public List<CustTagRel> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTagRel> result = new ArrayList<CustTagRel>();
        CustTagRelExample example04A = new CustTagRelExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagRelMapper.selectByExample(example04A));
        CustTagRelExample example04B = new CustTagRelExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagRelMapper.selectByExample(example04B));
        return result;
    }

    public List<CustTagRel> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTagRel> result = new ArrayList<CustTagRel>();
        CustTagRelExample example05A = new CustTagRelExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagRelMapper.selectByExample(example05A));
        CustTagRelExample example05B = new CustTagRelExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagRelMapper.selectByExample(example05B));
        return result;
    }

    public List<CustTagRel> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTagRel> result = new ArrayList<CustTagRel>();
        CustTagRelExample example06A = new CustTagRelExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagRelMapper.selectByExample(example06A));
        CustTagRelExample example06B = new CustTagRelExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagRelMapper.selectByExample(example06B));
        return result;
    }

}
