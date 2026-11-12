package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustManager;
import cn.song.custmetadata.example.CustManagerExample;
import cn.song.custmetadata.mapper.CustManagerMapper;
import cn.song.custmetadata.service.CustManagerQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户经理 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustManagerQueryServiceImpl implements CustManagerQueryService {

    private final CustManagerMapper custManagerMapper;

    public CustManagerQueryServiceImpl(CustManagerMapper custManagerMapper) {
        this.custManagerMapper = custManagerMapper;
    }

    public List<CustManager> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustManager> result = new ArrayList<CustManager>();
        CustManagerExample example01A = new CustManagerExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custManagerMapper.selectByExample(example01A));
        CustManagerExample example01B = new CustManagerExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custManagerMapper.selectByExample(example01B));
        return result;
    }

    public List<CustManager> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustManager> result = new ArrayList<CustManager>();
        CustManagerExample example02A = new CustManagerExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custManagerMapper.selectByExample(example02A));
        CustManagerExample example02B = new CustManagerExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custManagerMapper.selectByExample(example02B));
        return result;
    }

    public List<CustManager> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustManager> result = new ArrayList<CustManager>();
        CustManagerExample example03A = new CustManagerExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custManagerMapper.selectByExample(example03A));
        CustManagerExample example03B = new CustManagerExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custManagerMapper.selectByExample(example03B));
        return result;
    }

    public List<CustManager> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustManager> result = new ArrayList<CustManager>();
        CustManagerExample example04A = new CustManagerExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custManagerMapper.selectByExample(example04A));
        CustManagerExample example04B = new CustManagerExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custManagerMapper.selectByExample(example04B));
        return result;
    }

    public List<CustManager> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustManager> result = new ArrayList<CustManager>();
        CustManagerExample example05A = new CustManagerExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custManagerMapper.selectByExample(example05A));
        CustManagerExample example05B = new CustManagerExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custManagerMapper.selectByExample(example05B));
        return result;
    }

    public List<CustManager> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustManager> result = new ArrayList<CustManager>();
        CustManagerExample example06A = new CustManagerExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custManagerMapper.selectByExample(example06A));
        CustManagerExample example06B = new CustManagerExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custManagerMapper.selectByExample(example06B));
        return result;
    }

}
