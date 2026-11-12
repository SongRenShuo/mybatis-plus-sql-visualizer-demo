package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustSource;
import cn.song.custmetadata.example.CustSourceExample;
import cn.song.custmetadata.mapper.CustSourceMapper;
import cn.song.custmetadata.service.CustSourceQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户来源 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustSourceQueryServiceImpl implements CustSourceQueryService {

    private final CustSourceMapper custSourceMapper;

    public CustSourceQueryServiceImpl(CustSourceMapper custSourceMapper) {
        this.custSourceMapper = custSourceMapper;
    }

    public List<CustSource> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustSource> result = new ArrayList<CustSource>();
        CustSourceExample example01A = new CustSourceExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custSourceMapper.selectByExample(example01A));
        CustSourceExample example01B = new CustSourceExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custSourceMapper.selectByExample(example01B));
        return result;
    }

    public List<CustSource> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustSource> result = new ArrayList<CustSource>();
        CustSourceExample example02A = new CustSourceExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custSourceMapper.selectByExample(example02A));
        CustSourceExample example02B = new CustSourceExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custSourceMapper.selectByExample(example02B));
        return result;
    }

    public List<CustSource> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustSource> result = new ArrayList<CustSource>();
        CustSourceExample example03A = new CustSourceExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custSourceMapper.selectByExample(example03A));
        CustSourceExample example03B = new CustSourceExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custSourceMapper.selectByExample(example03B));
        return result;
    }

    public List<CustSource> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustSource> result = new ArrayList<CustSource>();
        CustSourceExample example04A = new CustSourceExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custSourceMapper.selectByExample(example04A));
        CustSourceExample example04B = new CustSourceExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custSourceMapper.selectByExample(example04B));
        return result;
    }

    public List<CustSource> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustSource> result = new ArrayList<CustSource>();
        CustSourceExample example05A = new CustSourceExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custSourceMapper.selectByExample(example05A));
        CustSourceExample example05B = new CustSourceExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custSourceMapper.selectByExample(example05B));
        return result;
    }

    public List<CustSource> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustSource> result = new ArrayList<CustSource>();
        CustSourceExample example06A = new CustSourceExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custSourceMapper.selectByExample(example06A));
        CustSourceExample example06B = new CustSourceExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custSourceMapper.selectByExample(example06B));
        return result;
    }

}
