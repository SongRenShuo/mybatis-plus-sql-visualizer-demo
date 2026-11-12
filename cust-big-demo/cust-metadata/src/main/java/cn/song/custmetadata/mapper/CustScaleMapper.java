package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustScale;
import cn.song.custmetadata.example.CustScaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_SCALE 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户规模。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustScaleMapper {

    int countByExample(CustScaleExample example);

    int deleteByExample(CustScaleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustScale record);

    int insertSelective(CustScale record);

    List<CustScale> selectByExample(CustScaleExample example);

    CustScale selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustScale record, @Param("example") CustScaleExample example);

    int updateByExample(@Param("record") CustScale record, @Param("example") CustScaleExample example);

    int updateByPrimaryKeySelective(CustScale record);

    int updateByPrimaryKey(CustScale record);

}
