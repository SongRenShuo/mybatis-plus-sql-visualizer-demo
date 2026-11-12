package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustCert;
import cn.song.custmetadata.example.CustCertExample;
import cn.song.custmetadata.mapper.CustCertMapper;
import cn.song.custmetadata.service.CustCertQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户证件 查询服务实现（热点表压力档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustCertPageQueryServiceImpl implements CustCertQueryService {

    private final CustCertMapper custCertMapper;

    public CustCertPageQueryServiceImpl(CustCertMapper custCertMapper) {
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

    public List<CustCert> queryBatch01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample batch0101 = new CustCertExample();
        batch0101.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCertMapper.selectByExample(batch0101));
        CustCertExample batch0102 = new CustCertExample();
        batch0102.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCertMapper.selectByExample(batch0102));
        CustCertExample batch0103 = new CustCertExample();
        batch0103.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custCertMapper.selectByExample(batch0103));
        return result;
    }

    public List<CustCert> queryBatch02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample batch0201 = new CustCertExample();
        batch0201.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCertMapper.selectByExample(batch0201));
        CustCertExample batch0202 = new CustCertExample();
        batch0202.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custCertMapper.selectByExample(batch0202));
        CustCertExample batch0203 = new CustCertExample();
        batch0203.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCertMapper.selectByExample(batch0203));
        return result;
    }

    public List<CustCert> queryBatch03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample batch0301 = new CustCertExample();
        batch0301.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custCertMapper.selectByExample(batch0301));
        CustCertExample batch0302 = new CustCertExample();
        batch0302.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCertMapper.selectByExample(batch0302));
        CustCertExample batch0303 = new CustCertExample();
        batch0303.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCertMapper.selectByExample(batch0303));
        return result;
    }

    public List<CustCert> queryBatch04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample batch0401 = new CustCertExample();
        batch0401.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCertMapper.selectByExample(batch0401));
        CustCertExample batch0402 = new CustCertExample();
        batch0402.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCertMapper.selectByExample(batch0402));
        CustCertExample batch0403 = new CustCertExample();
        batch0403.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCertMapper.selectByExample(batch0403));
        return result;
    }

    public List<CustCert> queryBatch05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample batch0501 = new CustCertExample();
        batch0501.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCertMapper.selectByExample(batch0501));
        CustCertExample batch0502 = new CustCertExample();
        batch0502.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCertMapper.selectByExample(batch0502));
        CustCertExample batch0503 = new CustCertExample();
        batch0503.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custCertMapper.selectByExample(batch0503));
        return result;
    }

    public List<CustCert> queryBatch06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample batch0601 = new CustCertExample();
        batch0601.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCertMapper.selectByExample(batch0601));
        CustCertExample batch0602 = new CustCertExample();
        batch0602.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custCertMapper.selectByExample(batch0602));
        CustCertExample batch0603 = new CustCertExample();
        batch0603.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCertMapper.selectByExample(batch0603));
        return result;
    }

    public List<CustCert> queryBatch07(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample batch0701 = new CustCertExample();
        batch0701.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custCertMapper.selectByExample(batch0701));
        CustCertExample batch0702 = new CustCertExample();
        batch0702.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCertMapper.selectByExample(batch0702));
        CustCertExample batch0703 = new CustCertExample();
        batch0703.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCertMapper.selectByExample(batch0703));
        return result;
    }

    public List<CustCert> queryBatch08(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample batch0801 = new CustCertExample();
        batch0801.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCertMapper.selectByExample(batch0801));
        CustCertExample batch0802 = new CustCertExample();
        batch0802.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCertMapper.selectByExample(batch0802));
        CustCertExample batch0803 = new CustCertExample();
        batch0803.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCertMapper.selectByExample(batch0803));
        return result;
    }

    public List<CustCert> queryBatch09(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample batch0901 = new CustCertExample();
        batch0901.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCertMapper.selectByExample(batch0901));
        CustCertExample batch0902 = new CustCertExample();
        batch0902.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCertMapper.selectByExample(batch0902));
        CustCertExample batch0903 = new CustCertExample();
        batch0903.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custCertMapper.selectByExample(batch0903));
        return result;
    }

    public List<CustCert> queryBatch10(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample batch1001 = new CustCertExample();
        batch1001.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCertMapper.selectByExample(batch1001));
        CustCertExample batch1002 = new CustCertExample();
        batch1002.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custCertMapper.selectByExample(batch1002));
        CustCertExample batch1003 = new CustCertExample();
        batch1003.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCertMapper.selectByExample(batch1003));
        return result;
    }

    public List<CustCert> queryBatch11(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample batch1101 = new CustCertExample();
        batch1101.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custCertMapper.selectByExample(batch1101));
        CustCertExample batch1102 = new CustCertExample();
        batch1102.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCertMapper.selectByExample(batch1102));
        CustCertExample batch1103 = new CustCertExample();
        batch1103.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCertMapper.selectByExample(batch1103));
        return result;
    }

    public List<CustCert> queryBatch12(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample batch1201 = new CustCertExample();
        batch1201.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCertMapper.selectByExample(batch1201));
        CustCertExample batch1202 = new CustCertExample();
        batch1202.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCertMapper.selectByExample(batch1202));
        CustCertExample batch1203 = new CustCertExample();
        batch1203.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCertMapper.selectByExample(batch1203));
        return result;
    }

    public List<CustCert> queryBatch13(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample batch1301 = new CustCertExample();
        batch1301.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCertMapper.selectByExample(batch1301));
        CustCertExample batch1302 = new CustCertExample();
        batch1302.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCertMapper.selectByExample(batch1302));
        CustCertExample batch1303 = new CustCertExample();
        batch1303.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custCertMapper.selectByExample(batch1303));
        return result;
    }

    public List<CustCert> queryBatch14(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample batch1401 = new CustCertExample();
        batch1401.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCertMapper.selectByExample(batch1401));
        CustCertExample batch1402 = new CustCertExample();
        batch1402.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custCertMapper.selectByExample(batch1402));
        CustCertExample batch1403 = new CustCertExample();
        batch1403.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCertMapper.selectByExample(batch1403));
        return result;
    }

    public List<CustCert> queryBatch15(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample batch1501 = new CustCertExample();
        batch1501.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custCertMapper.selectByExample(batch1501));
        CustCertExample batch1502 = new CustCertExample();
        batch1502.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCertMapper.selectByExample(batch1502));
        CustCertExample batch1503 = new CustCertExample();
        batch1503.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCertMapper.selectByExample(batch1503));
        return result;
    }

    public List<CustCert> queryBatch16(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustCert> result = new ArrayList<CustCert>();
        CustCertExample batch1601 = new CustCertExample();
        batch1601.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custCertMapper.selectByExample(batch1601));
        CustCertExample batch1602 = new CustCertExample();
        batch1602.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custCertMapper.selectByExample(batch1602));
        CustCertExample batch1603 = new CustCertExample();
        batch1603.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custCertMapper.selectByExample(batch1603));
        return result;
    }

}
