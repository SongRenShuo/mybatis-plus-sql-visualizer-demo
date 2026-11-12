package cn.song.custmetadata.service.impl;

import cn.song.custmetadata.entity.CustAddress;
import cn.song.custmetadata.example.CustAddressExample;
import cn.song.custmetadata.mapper.CustAddressMapper;
import cn.song.custmetadata.service.CustAddressQueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户地址 查询服务实现（热点表压力档）。
 *
 * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，
 * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。
 */
public class CustAddressExportQueryServiceImpl implements CustAddressQueryService {

    private final CustAddressMapper custAddressMapper;

    public CustAddressExportQueryServiceImpl(CustAddressMapper custAddressMapper) {
        this.custAddressMapper = custAddressMapper;
    }

    public List<CustAddress> queryByCondition01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample example01A = new CustAddressExample();
        example01A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(example01A));
        CustAddressExample example01B = new CustAddressExample();
        example01B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(example01B));
        return result;
    }

    public List<CustAddress> queryByCondition02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample example02A = new CustAddressExample();
        example02A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(example02A));
        CustAddressExample example02B = new CustAddressExample();
        example02B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(example02B));
        return result;
    }

    public List<CustAddress> queryByCondition03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample example03A = new CustAddressExample();
        example03A.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(example03A));
        CustAddressExample example03B = new CustAddressExample();
        example03B.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAddressMapper.selectByExample(example03B));
        return result;
    }

    public List<CustAddress> queryByCondition04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample example04A = new CustAddressExample();
        example04A.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAddressMapper.selectByExample(example04A));
        CustAddressExample example04B = new CustAddressExample();
        example04B.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(example04B));
        return result;
    }

    public List<CustAddress> queryByCondition05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample example05A = new CustAddressExample();
        example05A.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(example05A));
        CustAddressExample example05B = new CustAddressExample();
        example05B.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(example05B));
        return result;
    }

    public List<CustAddress> queryByCondition06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample example06A = new CustAddressExample();
        example06A.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(example06A));
        CustAddressExample example06B = new CustAddressExample();
        example06B.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(example06B));
        return result;
    }

    public List<CustAddress> queryBatch01(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample batch0101 = new CustAddressExample();
        batch0101.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(batch0101));
        CustAddressExample batch0102 = new CustAddressExample();
        batch0102.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(batch0102));
        CustAddressExample batch0103 = new CustAddressExample();
        batch0103.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAddressMapper.selectByExample(batch0103));
        return result;
    }

    public List<CustAddress> queryBatch02(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample batch0201 = new CustAddressExample();
        batch0201.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(batch0201));
        CustAddressExample batch0202 = new CustAddressExample();
        batch0202.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAddressMapper.selectByExample(batch0202));
        CustAddressExample batch0203 = new CustAddressExample();
        batch0203.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(batch0203));
        return result;
    }

    public List<CustAddress> queryBatch03(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample batch0301 = new CustAddressExample();
        batch0301.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAddressMapper.selectByExample(batch0301));
        CustAddressExample batch0302 = new CustAddressExample();
        batch0302.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(batch0302));
        CustAddressExample batch0303 = new CustAddressExample();
        batch0303.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(batch0303));
        return result;
    }

    public List<CustAddress> queryBatch04(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample batch0401 = new CustAddressExample();
        batch0401.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(batch0401));
        CustAddressExample batch0402 = new CustAddressExample();
        batch0402.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(batch0402));
        CustAddressExample batch0403 = new CustAddressExample();
        batch0403.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(batch0403));
        return result;
    }

    public List<CustAddress> queryBatch05(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample batch0501 = new CustAddressExample();
        batch0501.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(batch0501));
        CustAddressExample batch0502 = new CustAddressExample();
        batch0502.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(batch0502));
        CustAddressExample batch0503 = new CustAddressExample();
        batch0503.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAddressMapper.selectByExample(batch0503));
        return result;
    }

    public List<CustAddress> queryBatch06(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample batch0601 = new CustAddressExample();
        batch0601.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(batch0601));
        CustAddressExample batch0602 = new CustAddressExample();
        batch0602.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAddressMapper.selectByExample(batch0602));
        CustAddressExample batch0603 = new CustAddressExample();
        batch0603.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(batch0603));
        return result;
    }

    public List<CustAddress> queryBatch07(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample batch0701 = new CustAddressExample();
        batch0701.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAddressMapper.selectByExample(batch0701));
        CustAddressExample batch0702 = new CustAddressExample();
        batch0702.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(batch0702));
        CustAddressExample batch0703 = new CustAddressExample();
        batch0703.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(batch0703));
        return result;
    }

    public List<CustAddress> queryBatch08(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample batch0801 = new CustAddressExample();
        batch0801.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(batch0801));
        CustAddressExample batch0802 = new CustAddressExample();
        batch0802.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(batch0802));
        CustAddressExample batch0803 = new CustAddressExample();
        batch0803.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(batch0803));
        return result;
    }

    public List<CustAddress> queryBatch09(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample batch0901 = new CustAddressExample();
        batch0901.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(batch0901));
        CustAddressExample batch0902 = new CustAddressExample();
        batch0902.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(batch0902));
        CustAddressExample batch0903 = new CustAddressExample();
        batch0903.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAddressMapper.selectByExample(batch0903));
        return result;
    }

    public List<CustAddress> queryBatch10(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample batch1001 = new CustAddressExample();
        batch1001.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(batch1001));
        CustAddressExample batch1002 = new CustAddressExample();
        batch1002.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAddressMapper.selectByExample(batch1002));
        CustAddressExample batch1003 = new CustAddressExample();
        batch1003.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(batch1003));
        return result;
    }

    public List<CustAddress> queryBatch11(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample batch1101 = new CustAddressExample();
        batch1101.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAddressMapper.selectByExample(batch1101));
        CustAddressExample batch1102 = new CustAddressExample();
        batch1102.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(batch1102));
        CustAddressExample batch1103 = new CustAddressExample();
        batch1103.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(batch1103));
        return result;
    }

    public List<CustAddress> queryBatch12(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample batch1201 = new CustAddressExample();
        batch1201.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(batch1201));
        CustAddressExample batch1202 = new CustAddressExample();
        batch1202.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(batch1202));
        CustAddressExample batch1203 = new CustAddressExample();
        batch1203.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(batch1203));
        return result;
    }

    public List<CustAddress> queryBatch13(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample batch1301 = new CustAddressExample();
        batch1301.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(batch1301));
        CustAddressExample batch1302 = new CustAddressExample();
        batch1302.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(batch1302));
        CustAddressExample batch1303 = new CustAddressExample();
        batch1303.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAddressMapper.selectByExample(batch1303));
        return result;
    }

    public List<CustAddress> queryBatch14(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample batch1401 = new CustAddressExample();
        batch1401.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(batch1401));
        CustAddressExample batch1402 = new CustAddressExample();
        batch1402.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAddressMapper.selectByExample(batch1402));
        CustAddressExample batch1403 = new CustAddressExample();
        batch1403.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(batch1403));
        return result;
    }

    public List<CustAddress> queryBatch15(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample batch1501 = new CustAddressExample();
        batch1501.createCriteria().andCustNoEqualTo(custNo).andDelFlagEqualTo("0");
        result.addAll(custAddressMapper.selectByExample(batch1501));
        CustAddressExample batch1502 = new CustAddressExample();
        batch1502.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(batch1502));
        CustAddressExample batch1503 = new CustAddressExample();
        batch1503.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(batch1503));
        return result;
    }

    public List<CustAddress> queryBatch16(Long tenantId, String custNo, String custName, String status, Date startTime, Date endTime) {
        List<CustAddress> result = new ArrayList<CustAddress>();
        CustAddressExample batch1601 = new CustAddressExample();
        batch1601.createCriteria().andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo);
        result.addAll(custAddressMapper.selectByExample(batch1601));
        CustAddressExample batch1602 = new CustAddressExample();
        batch1602.createCriteria().andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status);
        result.addAll(custAddressMapper.selectByExample(batch1602));
        CustAddressExample batch1603 = new CustAddressExample();
        batch1603.createCriteria().andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime);
        result.addAll(custAddressMapper.selectByExample(batch1603));
        return result;
    }

}
