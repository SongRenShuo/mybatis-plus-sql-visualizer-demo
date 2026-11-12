package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustRiskItem;
import cn.song.custmetadata.example.CustRiskItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_RISK_ITEM 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户风险项。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustRiskItemMapper {

    int countByExample(CustRiskItemExample example);

    int deleteByExample(CustRiskItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustRiskItem record);

    int insertSelective(CustRiskItem record);

    List<CustRiskItem> selectByExample(CustRiskItemExample example);

    CustRiskItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustRiskItem record, @Param("example") CustRiskItemExample example);

    int updateByExample(@Param("record") CustRiskItem record, @Param("example") CustRiskItemExample example);

    int updateByPrimaryKeySelective(CustRiskItem record);

    int updateByPrimaryKey(CustRiskItem record);

}
