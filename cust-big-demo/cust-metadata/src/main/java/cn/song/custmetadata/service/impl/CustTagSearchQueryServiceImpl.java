package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustTag;
import cn.song.custmetadata.example.CustTagExample;
import cn.song.custmetadata.mapper.CustTagMapper;
import cn.song.custmetadata.service.CustTagQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户标签 查询服务实现（热点表压力档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustTagSearchQueryServiceImpl implements CustTagQueryService {

    private final CustTagMapper custTagMapper;

    public CustTagSearchQueryServiceImpl(CustTagMapper custTagMapper) {
        this.custTagMapper = custTagMapper;
    }

    public List<CustTag> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample example01A = new CustTagExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(example01A));
        CustTagExample example01B = new CustTagExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(example01B));
        return result;
    }

    public List<CustTag> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample example02A = new CustTagExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(example02A));
        CustTagExample example02B = new CustTagExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(example02B));
        return result;
    }

    public List<CustTag> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample example03A = new CustTagExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(example03A));
        CustTagExample example03B = new CustTagExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagMapper.selectByExample(example03B));
        return result;
    }

    public List<CustTag> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample example04A = new CustTagExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagMapper.selectByExample(example04A));
        CustTagExample example04B = new CustTagExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(example04B));
        return result;
    }

    public List<CustTag> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample example05A = new CustTagExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(example05A));
        CustTagExample example05B = new CustTagExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(example05B));
        return result;
    }

    public List<CustTag> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample example06A = new CustTagExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(example06A));
        CustTagExample example06B = new CustTagExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(example06B));
        return result;
    }

    public List<CustTag> queryBatch01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample batch0101 = new CustTagExample();
        batch0101.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(batch0101));
        CustTagExample batch0102 = new CustTagExample();
        batch0102.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(batch0102));
        CustTagExample batch0103 = new CustTagExample();
        batch0103.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagMapper.selectByExample(batch0103));
        return result;
    }

    public List<CustTag> queryBatch02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample batch0201 = new CustTagExample();
        batch0201.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(batch0201));
        CustTagExample batch0202 = new CustTagExample();
        batch0202.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagMapper.selectByExample(batch0202));
        CustTagExample batch0203 = new CustTagExample();
        batch0203.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(batch0203));
        return result;
    }

    public List<CustTag> queryBatch03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample batch0301 = new CustTagExample();
        batch0301.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagMapper.selectByExample(batch0301));
        CustTagExample batch0302 = new CustTagExample();
        batch0302.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(batch0302));
        CustTagExample batch0303 = new CustTagExample();
        batch0303.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(batch0303));
        return result;
    }

    public List<CustTag> queryBatch04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample batch0401 = new CustTagExample();
        batch0401.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(batch0401));
        CustTagExample batch0402 = new CustTagExample();
        batch0402.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(batch0402));
        CustTagExample batch0403 = new CustTagExample();
        batch0403.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(batch0403));
        return result;
    }

    public List<CustTag> queryBatch05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample batch0501 = new CustTagExample();
        batch0501.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(batch0501));
        CustTagExample batch0502 = new CustTagExample();
        batch0502.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(batch0502));
        CustTagExample batch0503 = new CustTagExample();
        batch0503.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagMapper.selectByExample(batch0503));
        return result;
    }

    public List<CustTag> queryBatch06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample batch0601 = new CustTagExample();
        batch0601.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(batch0601));
        CustTagExample batch0602 = new CustTagExample();
        batch0602.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagMapper.selectByExample(batch0602));
        CustTagExample batch0603 = new CustTagExample();
        batch0603.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(batch0603));
        return result;
    }

    public List<CustTag> queryBatch07(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample batch0701 = new CustTagExample();
        batch0701.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagMapper.selectByExample(batch0701));
        CustTagExample batch0702 = new CustTagExample();
        batch0702.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(batch0702));
        CustTagExample batch0703 = new CustTagExample();
        batch0703.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(batch0703));
        return result;
    }

    public List<CustTag> queryBatch08(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample batch0801 = new CustTagExample();
        batch0801.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(batch0801));
        CustTagExample batch0802 = new CustTagExample();
        batch0802.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(batch0802));
        CustTagExample batch0803 = new CustTagExample();
        batch0803.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(batch0803));
        return result;
    }

    public List<CustTag> queryBatch09(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample batch0901 = new CustTagExample();
        batch0901.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(batch0901));
        CustTagExample batch0902 = new CustTagExample();
        batch0902.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(batch0902));
        CustTagExample batch0903 = new CustTagExample();
        batch0903.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagMapper.selectByExample(batch0903));
        return result;
    }

    public List<CustTag> queryBatch10(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample batch1001 = new CustTagExample();
        batch1001.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(batch1001));
        CustTagExample batch1002 = new CustTagExample();
        batch1002.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagMapper.selectByExample(batch1002));
        CustTagExample batch1003 = new CustTagExample();
        batch1003.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(batch1003));
        return result;
    }

    public List<CustTag> queryBatch11(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample batch1101 = new CustTagExample();
        batch1101.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagMapper.selectByExample(batch1101));
        CustTagExample batch1102 = new CustTagExample();
        batch1102.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(batch1102));
        CustTagExample batch1103 = new CustTagExample();
        batch1103.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(batch1103));
        return result;
    }

    public List<CustTag> queryBatch12(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample batch1201 = new CustTagExample();
        batch1201.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(batch1201));
        CustTagExample batch1202 = new CustTagExample();
        batch1202.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(batch1202));
        CustTagExample batch1203 = new CustTagExample();
        batch1203.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(batch1203));
        return result;
    }

    public List<CustTag> queryBatch13(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample batch1301 = new CustTagExample();
        batch1301.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(batch1301));
        CustTagExample batch1302 = new CustTagExample();
        batch1302.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(batch1302));
        CustTagExample batch1303 = new CustTagExample();
        batch1303.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagMapper.selectByExample(batch1303));
        return result;
    }

    public List<CustTag> queryBatch14(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample batch1401 = new CustTagExample();
        batch1401.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(batch1401));
        CustTagExample batch1402 = new CustTagExample();
        batch1402.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagMapper.selectByExample(batch1402));
        CustTagExample batch1403 = new CustTagExample();
        batch1403.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(batch1403));
        return result;
    }

    public List<CustTag> queryBatch15(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample batch1501 = new CustTagExample();
        batch1501.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custTagMapper.selectByExample(batch1501));
        CustTagExample batch1502 = new CustTagExample();
        batch1502.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(batch1502));
        CustTagExample batch1503 = new CustTagExample();
        batch1503.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(batch1503));
        return result;
    }

    public List<CustTag> queryBatch16(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustTag> result = new ArrayList<CustTag>();
        CustTagExample batch1601 = new CustTagExample();
        batch1601.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custTagMapper.selectByExample(batch1601));
        CustTagExample batch1602 = new CustTagExample();
        batch1602.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custTagMapper.selectByExample(batch1602));
        CustTagExample batch1603 = new CustTagExample();
        batch1603.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custTagMapper.selectByExample(batch1603));
        return result;
    }

}
