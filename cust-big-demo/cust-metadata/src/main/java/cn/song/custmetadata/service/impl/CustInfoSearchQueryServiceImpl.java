package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustInfo;
import cn.song.custmetadata.example.CustInfoExample;
import cn.song.custmetadata.mapper.CustInfoMapper;
import cn.song.custmetadata.service.CustInfoQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户信息 查询服务实现（热点表压力档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustInfoSearchQueryServiceImpl implements CustInfoQueryService {

    private final CustInfoMapper custInfoMapper;

    public CustInfoSearchQueryServiceImpl(CustInfoMapper custInfoMapper) {
        this.custInfoMapper = custInfoMapper;
    }

    public List<CustInfo> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample example01A = new CustInfoExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(example01A));
        CustInfoExample example01B = new CustInfoExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(example01B));
        return result;
    }

    public List<CustInfo> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample example02A = new CustInfoExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(example02A));
        CustInfoExample example02B = new CustInfoExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(example02B));
        return result;
    }

    public List<CustInfo> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample example03A = new CustInfoExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(example03A));
        CustInfoExample example03B = new CustInfoExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInfoMapper.selectByExample(example03B));
        return result;
    }

    public List<CustInfo> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample example04A = new CustInfoExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInfoMapper.selectByExample(example04A));
        CustInfoExample example04B = new CustInfoExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(example04B));
        return result;
    }

    public List<CustInfo> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample example05A = new CustInfoExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(example05A));
        CustInfoExample example05B = new CustInfoExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(example05B));
        return result;
    }

    public List<CustInfo> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample example06A = new CustInfoExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(example06A));
        CustInfoExample example06B = new CustInfoExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(example06B));
        return result;
    }

    public List<CustInfo> queryBatch01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample batch0101 = new CustInfoExample();
        batch0101.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(batch0101));
        CustInfoExample batch0102 = new CustInfoExample();
        batch0102.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(batch0102));
        CustInfoExample batch0103 = new CustInfoExample();
        batch0103.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInfoMapper.selectByExample(batch0103));
        return result;
    }

    public List<CustInfo> queryBatch02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample batch0201 = new CustInfoExample();
        batch0201.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(batch0201));
        CustInfoExample batch0202 = new CustInfoExample();
        batch0202.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInfoMapper.selectByExample(batch0202));
        CustInfoExample batch0203 = new CustInfoExample();
        batch0203.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(batch0203));
        return result;
    }

    public List<CustInfo> queryBatch03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample batch0301 = new CustInfoExample();
        batch0301.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInfoMapper.selectByExample(batch0301));
        CustInfoExample batch0302 = new CustInfoExample();
        batch0302.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(batch0302));
        CustInfoExample batch0303 = new CustInfoExample();
        batch0303.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(batch0303));
        return result;
    }

    public List<CustInfo> queryBatch04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample batch0401 = new CustInfoExample();
        batch0401.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(batch0401));
        CustInfoExample batch0402 = new CustInfoExample();
        batch0402.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(batch0402));
        CustInfoExample batch0403 = new CustInfoExample();
        batch0403.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(batch0403));
        return result;
    }

    public List<CustInfo> queryBatch05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample batch0501 = new CustInfoExample();
        batch0501.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(batch0501));
        CustInfoExample batch0502 = new CustInfoExample();
        batch0502.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(batch0502));
        CustInfoExample batch0503 = new CustInfoExample();
        batch0503.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInfoMapper.selectByExample(batch0503));
        return result;
    }

    public List<CustInfo> queryBatch06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample batch0601 = new CustInfoExample();
        batch0601.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(batch0601));
        CustInfoExample batch0602 = new CustInfoExample();
        batch0602.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInfoMapper.selectByExample(batch0602));
        CustInfoExample batch0603 = new CustInfoExample();
        batch0603.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(batch0603));
        return result;
    }

    public List<CustInfo> queryBatch07(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample batch0701 = new CustInfoExample();
        batch0701.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInfoMapper.selectByExample(batch0701));
        CustInfoExample batch0702 = new CustInfoExample();
        batch0702.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(batch0702));
        CustInfoExample batch0703 = new CustInfoExample();
        batch0703.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(batch0703));
        return result;
    }

    public List<CustInfo> queryBatch08(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample batch0801 = new CustInfoExample();
        batch0801.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(batch0801));
        CustInfoExample batch0802 = new CustInfoExample();
        batch0802.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(batch0802));
        CustInfoExample batch0803 = new CustInfoExample();
        batch0803.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(batch0803));
        return result;
    }

    public List<CustInfo> queryBatch09(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample batch0901 = new CustInfoExample();
        batch0901.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(batch0901));
        CustInfoExample batch0902 = new CustInfoExample();
        batch0902.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(batch0902));
        CustInfoExample batch0903 = new CustInfoExample();
        batch0903.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInfoMapper.selectByExample(batch0903));
        return result;
    }

    public List<CustInfo> queryBatch10(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample batch1001 = new CustInfoExample();
        batch1001.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(batch1001));
        CustInfoExample batch1002 = new CustInfoExample();
        batch1002.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInfoMapper.selectByExample(batch1002));
        CustInfoExample batch1003 = new CustInfoExample();
        batch1003.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(batch1003));
        return result;
    }

    public List<CustInfo> queryBatch11(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample batch1101 = new CustInfoExample();
        batch1101.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInfoMapper.selectByExample(batch1101));
        CustInfoExample batch1102 = new CustInfoExample();
        batch1102.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(batch1102));
        CustInfoExample batch1103 = new CustInfoExample();
        batch1103.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(batch1103));
        return result;
    }

    public List<CustInfo> queryBatch12(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample batch1201 = new CustInfoExample();
        batch1201.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(batch1201));
        CustInfoExample batch1202 = new CustInfoExample();
        batch1202.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(batch1202));
        CustInfoExample batch1203 = new CustInfoExample();
        batch1203.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(batch1203));
        return result;
    }

    public List<CustInfo> queryBatch13(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample batch1301 = new CustInfoExample();
        batch1301.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(batch1301));
        CustInfoExample batch1302 = new CustInfoExample();
        batch1302.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(batch1302));
        CustInfoExample batch1303 = new CustInfoExample();
        batch1303.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInfoMapper.selectByExample(batch1303));
        return result;
    }

    public List<CustInfo> queryBatch14(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample batch1401 = new CustInfoExample();
        batch1401.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(batch1401));
        CustInfoExample batch1402 = new CustInfoExample();
        batch1402.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInfoMapper.selectByExample(batch1402));
        CustInfoExample batch1403 = new CustInfoExample();
        batch1403.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(batch1403));
        return result;
    }

    public List<CustInfo> queryBatch15(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample batch1501 = new CustInfoExample();
        batch1501.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custInfoMapper.selectByExample(batch1501));
        CustInfoExample batch1502 = new CustInfoExample();
        batch1502.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(batch1502));
        CustInfoExample batch1503 = new CustInfoExample();
        batch1503.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(batch1503));
        return result;
    }

    public List<CustInfo> queryBatch16(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustInfo> result = new ArrayList<CustInfo>();
        CustInfoExample batch1601 = new CustInfoExample();
        batch1601.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custInfoMapper.selectByExample(batch1601));
        CustInfoExample batch1602 = new CustInfoExample();
        batch1602.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custInfoMapper.selectByExample(batch1602));
        CustInfoExample batch1603 = new CustInfoExample();
        batch1603.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custInfoMapper.selectByExample(batch1603));
        return result;
    }

}
