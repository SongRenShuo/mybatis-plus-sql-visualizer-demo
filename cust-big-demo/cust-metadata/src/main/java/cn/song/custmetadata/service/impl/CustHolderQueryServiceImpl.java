package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustHolder;
import cn.song.custmetadata.example.CustHolderExample;
import cn.song.custmetadata.mapper.CustHolderMapper;
import cn.song.custmetadata.service.CustHolderQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户持有人 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustHolderQueryServiceImpl implements CustHolderQueryService {

    private final CustHolderMapper custHolderMapper;

    public CustHolderQueryServiceImpl(CustHolderMapper custHolderMapper) {
        this.custHolderMapper = custHolderMapper;
    }

    public List<CustHolder> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustHolder> result = new ArrayList<CustHolder>();
        CustHolderExample example01A = new CustHolderExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custHolderMapper.selectByExample(example01A));
        CustHolderExample example01B = new CustHolderExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custHolderMapper.selectByExample(example01B));
        return result;
    }

    public List<CustHolder> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustHolder> result = new ArrayList<CustHolder>();
        CustHolderExample example02A = new CustHolderExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custHolderMapper.selectByExample(example02A));
        CustHolderExample example02B = new CustHolderExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custHolderMapper.selectByExample(example02B));
        return result;
    }

    public List<CustHolder> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustHolder> result = new ArrayList<CustHolder>();
        CustHolderExample example03A = new CustHolderExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custHolderMapper.selectByExample(example03A));
        CustHolderExample example03B = new CustHolderExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custHolderMapper.selectByExample(example03B));
        return result;
    }

    public List<CustHolder> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustHolder> result = new ArrayList<CustHolder>();
        CustHolderExample example04A = new CustHolderExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custHolderMapper.selectByExample(example04A));
        CustHolderExample example04B = new CustHolderExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custHolderMapper.selectByExample(example04B));
        return result;
    }

    public List<CustHolder> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustHolder> result = new ArrayList<CustHolder>();
        CustHolderExample example05A = new CustHolderExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custHolderMapper.selectByExample(example05A));
        CustHolderExample example05B = new CustHolderExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custHolderMapper.selectByExample(example05B));
        return result;
    }

    public List<CustHolder> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustHolder> result = new ArrayList<CustHolder>();
        CustHolderExample example06A = new CustHolderExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custHolderMapper.selectByExample(example06A));
        CustHolderExample example06B = new CustHolderExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custHolderMapper.selectByExample(example06B));
        return result;
    }

}
