package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustChannel;
import cn.song.custmetadata.example.CustChannelExample;
import cn.song.custmetadata.mapper.CustChannelMapper;
import cn.song.custmetadata.service.CustChannelQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户渠道 查询服务实现（基础档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustChannelQueryServiceImpl implements CustChannelQueryService {

    private final CustChannelMapper custChannelMapper;

    public CustChannelQueryServiceImpl(CustChannelMapper custChannelMapper) {
        this.custChannelMapper = custChannelMapper;
    }

    public List<CustChannel> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustChannel> result = new ArrayList<CustChannel>();
        CustChannelExample example01A = new CustChannelExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custChannelMapper.selectByExample(example01A));
        CustChannelExample example01B = new CustChannelExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custChannelMapper.selectByExample(example01B));
        return result;
    }

    public List<CustChannel> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustChannel> result = new ArrayList<CustChannel>();
        CustChannelExample example02A = new CustChannelExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custChannelMapper.selectByExample(example02A));
        CustChannelExample example02B = new CustChannelExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custChannelMapper.selectByExample(example02B));
        return result;
    }

    public List<CustChannel> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustChannel> result = new ArrayList<CustChannel>();
        CustChannelExample example03A = new CustChannelExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custChannelMapper.selectByExample(example03A));
        CustChannelExample example03B = new CustChannelExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custChannelMapper.selectByExample(example03B));
        return result;
    }

    public List<CustChannel> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustChannel> result = new ArrayList<CustChannel>();
        CustChannelExample example04A = new CustChannelExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custChannelMapper.selectByExample(example04A));
        CustChannelExample example04B = new CustChannelExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custChannelMapper.selectByExample(example04B));
        return result;
    }

    public List<CustChannel> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustChannel> result = new ArrayList<CustChannel>();
        CustChannelExample example05A = new CustChannelExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custChannelMapper.selectByExample(example05A));
        CustChannelExample example05B = new CustChannelExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custChannelMapper.selectByExample(example05B));
        return result;
    }

    public List<CustChannel> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustChannel> result = new ArrayList<CustChannel>();
        CustChannelExample example06A = new CustChannelExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custChannelMapper.selectByExample(example06A));
        CustChannelExample example06B = new CustChannelExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custChannelMapper.selectByExample(example06B));
        return result;
    }

}
