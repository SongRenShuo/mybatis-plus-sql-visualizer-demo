package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustSource;
import cn.song.custmetadata.example.CustSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_SOURCE 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户来源。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustSourceMapper {

    int countByExample(CustSourceExample example);

    int deleteByExample(CustSourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustSource record);

    int insertSelective(CustSource record);

    List<CustSource> selectByExample(CustSourceExample example);

    CustSource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustSource record, @Param("example") CustSourceExample example);

    int updateByExample(@Param("record") CustSource record, @Param("example") CustSourceExample example);

    int updateByPrimaryKeySelective(CustSource record);

    int updateByPrimaryKey(CustSource record);

}
