package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustContact;
import cn.song.custmetadata.example.CustContactExample;
import cn.song.custmetadata.mapper.CustContactMapper;
import cn.song.custmetadata.service.CustContactQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户联系方式 查询服务实现（热点表压力档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustContactExportQueryServiceImpl implements CustContactQueryService {

    private final CustContactMapper custContactMapper;

    public CustContactExportQueryServiceImpl(CustContactMapper custContactMapper) {
        this.custContactMapper = custContactMapper;
    }

    public List<CustContact> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample example01A = new CustContactExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(example01A));
        CustContactExample example01B = new CustContactExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(example01B));
        return result;
    }

    public List<CustContact> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample example02A = new CustContactExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(example02A));
        CustContactExample example02B = new CustContactExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(example02B));
        return result;
    }

    public List<CustContact> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample example03A = new CustContactExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(example03A));
        CustContactExample example03B = new CustContactExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContactMapper.selectByExample(example03B));
        return result;
    }

    public List<CustContact> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample example04A = new CustContactExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContactMapper.selectByExample(example04A));
        CustContactExample example04B = new CustContactExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(example04B));
        return result;
    }

    public List<CustContact> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample example05A = new CustContactExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(example05A));
        CustContactExample example05B = new CustContactExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(example05B));
        return result;
    }

    public List<CustContact> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample example06A = new CustContactExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(example06A));
        CustContactExample example06B = new CustContactExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(example06B));
        return result;
    }

    public List<CustContact> queryBatch01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample batch0101 = new CustContactExample();
        batch0101.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(batch0101));
        CustContactExample batch0102 = new CustContactExample();
        batch0102.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(batch0102));
        CustContactExample batch0103 = new CustContactExample();
        batch0103.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContactMapper.selectByExample(batch0103));
        return result;
    }

    public List<CustContact> queryBatch02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample batch0201 = new CustContactExample();
        batch0201.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(batch0201));
        CustContactExample batch0202 = new CustContactExample();
        batch0202.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContactMapper.selectByExample(batch0202));
        CustContactExample batch0203 = new CustContactExample();
        batch0203.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(batch0203));
        return result;
    }

    public List<CustContact> queryBatch03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample batch0301 = new CustContactExample();
        batch0301.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContactMapper.selectByExample(batch0301));
        CustContactExample batch0302 = new CustContactExample();
        batch0302.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(batch0302));
        CustContactExample batch0303 = new CustContactExample();
        batch0303.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(batch0303));
        return result;
    }

    public List<CustContact> queryBatch04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample batch0401 = new CustContactExample();
        batch0401.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(batch0401));
        CustContactExample batch0402 = new CustContactExample();
        batch0402.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(batch0402));
        CustContactExample batch0403 = new CustContactExample();
        batch0403.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(batch0403));
        return result;
    }

    public List<CustContact> queryBatch05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample batch0501 = new CustContactExample();
        batch0501.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(batch0501));
        CustContactExample batch0502 = new CustContactExample();
        batch0502.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(batch0502));
        CustContactExample batch0503 = new CustContactExample();
        batch0503.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContactMapper.selectByExample(batch0503));
        return result;
    }

    public List<CustContact> queryBatch06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample batch0601 = new CustContactExample();
        batch0601.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(batch0601));
        CustContactExample batch0602 = new CustContactExample();
        batch0602.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContactMapper.selectByExample(batch0602));
        CustContactExample batch0603 = new CustContactExample();
        batch0603.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(batch0603));
        return result;
    }

    public List<CustContact> queryBatch07(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample batch0701 = new CustContactExample();
        batch0701.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContactMapper.selectByExample(batch0701));
        CustContactExample batch0702 = new CustContactExample();
        batch0702.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(batch0702));
        CustContactExample batch0703 = new CustContactExample();
        batch0703.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(batch0703));
        return result;
    }

    public List<CustContact> queryBatch08(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample batch0801 = new CustContactExample();
        batch0801.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(batch0801));
        CustContactExample batch0802 = new CustContactExample();
        batch0802.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(batch0802));
        CustContactExample batch0803 = new CustContactExample();
        batch0803.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(batch0803));
        return result;
    }

    public List<CustContact> queryBatch09(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample batch0901 = new CustContactExample();
        batch0901.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(batch0901));
        CustContactExample batch0902 = new CustContactExample();
        batch0902.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(batch0902));
        CustContactExample batch0903 = new CustContactExample();
        batch0903.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContactMapper.selectByExample(batch0903));
        return result;
    }

    public List<CustContact> queryBatch10(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample batch1001 = new CustContactExample();
        batch1001.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(batch1001));
        CustContactExample batch1002 = new CustContactExample();
        batch1002.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContactMapper.selectByExample(batch1002));
        CustContactExample batch1003 = new CustContactExample();
        batch1003.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(batch1003));
        return result;
    }

    public List<CustContact> queryBatch11(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample batch1101 = new CustContactExample();
        batch1101.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContactMapper.selectByExample(batch1101));
        CustContactExample batch1102 = new CustContactExample();
        batch1102.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(batch1102));
        CustContactExample batch1103 = new CustContactExample();
        batch1103.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(batch1103));
        return result;
    }

    public List<CustContact> queryBatch12(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample batch1201 = new CustContactExample();
        batch1201.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(batch1201));
        CustContactExample batch1202 = new CustContactExample();
        batch1202.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(batch1202));
        CustContactExample batch1203 = new CustContactExample();
        batch1203.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(batch1203));
        return result;
    }

    public List<CustContact> queryBatch13(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample batch1301 = new CustContactExample();
        batch1301.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(batch1301));
        CustContactExample batch1302 = new CustContactExample();
        batch1302.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(batch1302));
        CustContactExample batch1303 = new CustContactExample();
        batch1303.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContactMapper.selectByExample(batch1303));
        return result;
    }

    public List<CustContact> queryBatch14(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample batch1401 = new CustContactExample();
        batch1401.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(batch1401));
        CustContactExample batch1402 = new CustContactExample();
        batch1402.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContactMapper.selectByExample(batch1402));
        CustContactExample batch1403 = new CustContactExample();
        batch1403.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(batch1403));
        return result;
    }

    public List<CustContact> queryBatch15(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample batch1501 = new CustContactExample();
        batch1501.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custContactMapper.selectByExample(batch1501));
        CustContactExample batch1502 = new CustContactExample();
        batch1502.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(batch1502));
        CustContactExample batch1503 = new CustContactExample();
        batch1503.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(batch1503));
        return result;
    }

    public List<CustContact> queryBatch16(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustContact> result = new ArrayList<CustContact>();
        CustContactExample batch1601 = new CustContactExample();
        batch1601.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custContactMapper.selectByExample(batch1601));
        CustContactExample batch1602 = new CustContactExample();
        batch1602.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custContactMapper.selectByExample(batch1602));
        CustContactExample batch1603 = new CustContactExample();
        batch1603.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custContactMapper.selectByExample(batch1603));
        return result;
    }

}
