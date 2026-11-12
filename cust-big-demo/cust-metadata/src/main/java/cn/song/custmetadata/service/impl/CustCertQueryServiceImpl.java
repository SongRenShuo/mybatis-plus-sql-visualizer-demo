package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustCert;
import cn.song.custmetadata.example.CustCertExample;
import cn.song.custmetadata.mapper.CustCertMapper;
import cn.song.custmetadata.service.CustCertQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户证件 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustCertQueryServiceImpl implements CustCertQueryService {

    private final CustCertMapper custCertMapper;

    public CustCertQueryServiceImpl(CustCertMapper custCertMapper) {
        this.custCertMapper = custCertMapper;
    }

    public List<CustCert> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample example01A = new CustCertExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCertMapper.selectByExample(example01A));
        CustCertExample example01B = new CustCertExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCertMapper.selectByExample(example01B));
        return result;
    }

    public List<CustCert> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample example02A = new CustCertExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCertMapper.selectByExample(example02A));
        CustCertExample example02B = new CustCertExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCertMapper.selectByExample(example02B));
        return result;
    }

    public List<CustCert> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample example03A = new CustCertExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCertMapper.selectByExample(example03A));
        CustCertExample example03B = new CustCertExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custCertMapper.selectByExample(example03B));
        return result;
    }

    public List<CustCert> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample example04A = new CustCertExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custCertMapper.selectByExample(example04A));
        CustCertExample example04B = new CustCertExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCertMapper.selectByExample(example04B));
        return result;
    }

    public List<CustCert> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample example05A = new CustCertExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCertMapper.selectByExample(example05A));
        CustCertExample example05B = new CustCertExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCertMapper.selectByExample(example05B));
        return result;
    }

    public List<CustCert> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample example06A = new CustCertExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCertMapper.selectByExample(example06A));
        CustCertExample example06B = new CustCertExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCertMapper.selectByExample(example06B));
        return result;
    }

}
