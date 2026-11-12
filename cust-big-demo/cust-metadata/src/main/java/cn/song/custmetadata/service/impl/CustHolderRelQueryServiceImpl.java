package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustHolderRel;
import cn.song.custmetadata.example.CustHolderRelExample;
import cn.song.custmetadata.mapper.CustHolderRelMapper;
import cn.song.custmetadata.service.CustHolderRelQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户持有人关系 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustHolderRelQueryServiceImpl implements CustHolderRelQueryService {

    private final CustHolderRelMapper custHolderRelMapper;

    public CustHolderRelQueryServiceImpl(CustHolderRelMapper custHolderRelMapper) {
        this.custHolderRelMapper = custHolderRelMapper;
    }

    public List<CustHolderRel> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustHolderRel> result = new ArrayList<CustHolderRel>();
        CustHolderRelExample example01A = new CustHolderRelExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custHolderRelMapper.selectByExample(example01A));
        CustHolderRelExample example01B = new CustHolderRelExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custHolderRelMapper.selectByExample(example01B));
        return result;
    }

    public List<CustHolderRel> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustHolderRel> result = new ArrayList<CustHolderRel>();
        CustHolderRelExample example02A = new CustHolderRelExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custHolderRelMapper.selectByExample(example02A));
        CustHolderRelExample example02B = new CustHolderRelExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custHolderRelMapper.selectByExample(example02B));
        return result;
    }

    public List<CustHolderRel> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustHolderRel> result = new ArrayList<CustHolderRel>();
        CustHolderRelExample example03A = new CustHolderRelExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custHolderRelMapper.selectByExample(example03A));
        CustHolderRelExample example03B = new CustHolderRelExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custHolderRelMapper.selectByExample(example03B));
        return result;
    }

    public List<CustHolderRel> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustHolderRel> result = new ArrayList<CustHolderRel>();
        CustHolderRelExample example04A = new CustHolderRelExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custHolderRelMapper.selectByExample(example04A));
        CustHolderRelExample example04B = new CustHolderRelExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custHolderRelMapper.selectByExample(example04B));
        return result;
    }

    public List<CustHolderRel> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustHolderRel> result = new ArrayList<CustHolderRel>();
        CustHolderRelExample example05A = new CustHolderRelExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custHolderRelMapper.selectByExample(example05A));
        CustHolderRelExample example05B = new CustHolderRelExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custHolderRelMapper.selectByExample(example05B));
        return result;
    }

    public List<CustHolderRel> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustHolderRel> result = new ArrayList<CustHolderRel>();
        CustHolderRelExample example06A = new CustHolderRelExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custHolderRelMapper.selectByExample(example06A));
        CustHolderRelExample example06B = new CustHolderRelExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custHolderRelMapper.selectByExample(example06B));
        return result;
    }

}
