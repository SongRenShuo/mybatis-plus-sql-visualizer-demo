package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustTag;
import cn.song.custmetadata.example.CustTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_TAG 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户标签。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustTagMapper {

    int countByExample(CustTagExample example);

    int deleteByExample(CustTagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustTag record);

    int insertSelective(CustTag record);

    List<CustTag> selectByExample(CustTagExample example);

    CustTag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustTag record, @Param("example") CustTagExample example);

    int updateByExample(@Param("record") CustTag record, @Param("example") CustTagExample example);

    int updateByPrimaryKeySelective(CustTag record);

    int updateByPrimaryKey(CustTag record);

}
