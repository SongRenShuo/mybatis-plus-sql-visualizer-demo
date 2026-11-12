package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustOrderItem;
import cn.song.custmetadata.example.CustOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_ORDER_ITEM 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户订单明细。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustOrderItemMapper {

    int countByExample(CustOrderItemExample example);

    int deleteByExample(CustOrderItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustOrderItem record);

    int insertSelective(CustOrderItem record);

    List<CustOrderItem> selectByExample(CustOrderItemExample example);

    CustOrderItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustOrderItem record, @Param("example") CustOrderItemExample example);

    int updateByExample(@Param("record") CustOrderItem record, @Param("example") CustOrderItemExample example);

    int updateByPrimaryKeySelective(CustOrderItem record);

    int updateByPrimaryKey(CustOrderItem record);

}
