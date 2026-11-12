package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustRefund;
import cn.song.custmetadata.example.CustRefundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_REFUND 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户退款。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustRefundMapper {

    int countByExample(CustRefundExample example);

    int deleteByExample(CustRefundExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustRefund record);

    int insertSelective(CustRefund record);

    List<CustRefund> selectByExample(CustRefundExample example);

    CustRefund selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustRefund record, @Param("example") CustRefundExample example);

    int updateByExample(@Param("record") CustRefund record, @Param("example") CustRefundExample example);

    int updateByPrimaryKeySelective(CustRefund record);

    int updateByPrimaryKey(CustRefund record);

}
