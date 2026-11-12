package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustOrder;
import cn.song.custmetadata.example.CustOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_ORDER 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户订单。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustOrderMapper {

    int countByExample(CustOrderExample example);

    int deleteByExample(CustOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustOrder record);

    int insertSelective(CustOrder record);

    List<CustOrder> selectByExample(CustOrderExample example);

    CustOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustOrder record, @Param("example") CustOrderExample example);

    int updateByExample(@Param("record") CustOrder record, @Param("example") CustOrderExample example);

    int updateByPrimaryKeySelective(CustOrder record);

    int updateByPrimaryKey(CustOrder record);

}
