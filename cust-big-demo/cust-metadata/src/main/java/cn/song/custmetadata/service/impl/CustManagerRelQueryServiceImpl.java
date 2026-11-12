package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustManagerRel;
import cn.song.custmetadata.example.CustManagerRelExample;
import cn.song.custmetadata.mapper.CustManagerRelMapper;
import cn.song.custmetadata.service.CustManagerRelQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户经理关系 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustManagerRelQueryServiceImpl implements CustManagerRelQueryService {

    private final CustManagerRelMapper custManagerRelMapper;

    public CustManagerRelQueryServiceImpl(CustManagerRelMapper custManagerRelMapper) {
        this.custManagerRelMapper = custManagerRelMapper;
    }

    public List<CustManagerRel> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustManagerRel> result = new ArrayList<CustManagerRel>();
        CustManagerRelExample example01A = new CustManagerRelExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custManagerRelMapper.selectByExample(example01A));
        CustManagerRelExample example01B = new CustManagerRelExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custManagerRelMapper.selectByExample(example01B));
        return result;
    }

    public List<CustManagerRel> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustManagerRel> result = new ArrayList<CustManagerRel>();
        CustManagerRelExample example02A = new CustManagerRelExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custManagerRelMapper.selectByExample(example02A));
        CustManagerRelExample example02B = new CustManagerRelExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custManagerRelMapper.selectByExample(example02B));
        return result;
    }

    public List<CustManagerRel> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustManagerRel> result = new ArrayList<CustManagerRel>();
        CustManagerRelExample example03A = new CustManagerRelExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custManagerRelMapper.selectByExample(example03A));
        CustManagerRelExample example03B = new CustManagerRelExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custManagerRelMapper.selectByExample(example03B));
        return result;
    }

    public List<CustManagerRel> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustManagerRel> result = new ArrayList<CustManagerRel>();
        CustManagerRelExample example04A = new CustManagerRelExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custManagerRelMapper.selectByExample(example04A));
        CustManagerRelExample example04B = new CustManagerRelExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custManagerRelMapper.selectByExample(example04B));
        return result;
    }

    public List<CustManagerRel> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustManagerRel> result = new ArrayList<CustManagerRel>();
        CustManagerRelExample example05A = new CustManagerRelExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custManagerRelMapper.selectByExample(example05A));
        CustManagerRelExample example05B = new CustManagerRelExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custManagerRelMapper.selectByExample(example05B));
        return result;
    }

    public List<CustManagerRel> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustManagerRel> result = new ArrayList<CustManagerRel>();
        CustManagerRelExample example06A = new CustManagerRelExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custManagerRelMapper.selectByExample(example06A));
        CustManagerRelExample example06B = new CustManagerRelExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custManagerRelMapper.selectByExample(example06B));
        return result;
    }

}
