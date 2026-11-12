package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustGroup;
import cn.song.custmetadata.example.CustGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_GROUP 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户群组。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustGroupMapper {

    int countByExample(CustGroupExample example);

    int deleteByExample(CustGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustGroup record);

    int insertSelective(CustGroup record);

    List<CustGroup> selectByExample(CustGroupExample example);

    CustGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustGroup record, @Param("example") CustGroupExample example);

    int updateByExample(@Param("record") CustGroup record, @Param("example") CustGroupExample example);

    int updateByPrimaryKeySelective(CustGroup record);

    int updateByPrimaryKey(CustGroup record);

}
