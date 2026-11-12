package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustAssetDetail;
import cn.song.custmetadata.example.CustAssetDetailExample;
import cn.song.custmetadata.mapper.CustAssetDetailMapper;
import cn.song.custmetadata.service.CustAssetDetailQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户资产明细 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustAssetDetailQueryServiceImpl implements CustAssetDetailQueryService {

    private final CustAssetDetailMapper custAssetDetailMapper;

    public CustAssetDetailQueryServiceImpl(CustAssetDetailMapper custAssetDetailMapper) {
        this.custAssetDetailMapper = custAssetDetailMapper;
    }

    public List<CustAssetDetail> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAssetDetail> result = new ArrayList<CustAssetDetail>();
        CustAssetDetailExample example01A = new CustAssetDetailExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAssetDetailMapper.selectByExample(example01A));
        CustAssetDetailExample example01B = new CustAssetDetailExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAssetDetailMapper.selectByExample(example01B));
        return result;
    }

    public List<CustAssetDetail> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAssetDetail> result = new ArrayList<CustAssetDetail>();
        CustAssetDetailExample example02A = new CustAssetDetailExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAssetDetailMapper.selectByExample(example02A));
        CustAssetDetailExample example02B = new CustAssetDetailExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAssetDetailMapper.selectByExample(example02B));
        return result;
    }

    public List<CustAssetDetail> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAssetDetail> result = new ArrayList<CustAssetDetail>();
        CustAssetDetailExample example03A = new CustAssetDetailExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAssetDetailMapper.selectByExample(example03A));
        CustAssetDetailExample example03B = new CustAssetDetailExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAssetDetailMapper.selectByExample(example03B));
        return result;
    }

    public List<CustAssetDetail> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAssetDetail> result = new ArrayList<CustAssetDetail>();
        CustAssetDetailExample example04A = new CustAssetDetailExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAssetDetailMapper.selectByExample(example04A));
        CustAssetDetailExample example04B = new CustAssetDetailExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAssetDetailMapper.selectByExample(example04B));
        return result;
    }

    public List<CustAssetDetail> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAssetDetail> result = new ArrayList<CustAssetDetail>();
        CustAssetDetailExample example05A = new CustAssetDetailExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAssetDetailMapper.selectByExample(example05A));
        CustAssetDetailExample example05B = new CustAssetDetailExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAssetDetailMapper.selectByExample(example05B));
        return result;
    }

    public List<CustAssetDetail> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAssetDetail> result = new ArrayList<CustAssetDetail>();
        CustAssetDetailExample example06A = new CustAssetDetailExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAssetDetailMapper.selectByExample(example06A));
        CustAssetDetailExample example06B = new CustAssetDetailExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAssetDetailMapper.selectByExample(example06B));
        return result;
    }

}
