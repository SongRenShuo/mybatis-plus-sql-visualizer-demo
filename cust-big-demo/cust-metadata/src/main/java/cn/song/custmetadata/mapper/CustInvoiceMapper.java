package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustInvoice;
import cn.song.custmetadata.example.CustInvoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_INVOICE 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户发票。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustInvoiceMapper {

    int countByExample(CustInvoiceExample example);

    int deleteByExample(CustInvoiceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustInvoice record);

    int insertSelective(CustInvoice record);

    List<CustInvoice> selectByExample(CustInvoiceExample example);

    CustInvoice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustInvoice record, @Param("example") CustInvoiceExample example);

    int updateByExample(@Param("record") CustInvoice record, @Param("example") CustInvoiceExample example);

    int updateByPrimaryKeySelective(CustInvoice record);

    int updateByPrimaryKey(CustInvoice record);

}
