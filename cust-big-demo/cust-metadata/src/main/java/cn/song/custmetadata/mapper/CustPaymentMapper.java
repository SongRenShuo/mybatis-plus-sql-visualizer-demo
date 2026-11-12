package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustPayment;
import cn.song.custmetadata.example.CustPaymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_PAYMENT 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户付款。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustPaymentMapper {

    int countByExample(CustPaymentExample example);

    int deleteByExample(CustPaymentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustPayment record);

    int insertSelective(CustPayment record);

    List<CustPayment> selectByExample(CustPaymentExample example);

    CustPayment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustPayment record, @Param("example") CustPaymentExample example);

    int updateByExample(@Param("record") CustPayment record, @Param("example") CustPaymentExample example);

    int updateByPrimaryKeySelective(CustPayment record);

    int updateByPrimaryKey(CustPayment record);

}
