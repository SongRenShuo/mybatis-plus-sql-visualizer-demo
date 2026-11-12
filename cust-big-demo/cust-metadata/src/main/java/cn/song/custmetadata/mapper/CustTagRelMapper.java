package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustTagRel;
import cn.song.custmetadata.example.CustTagRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_TAG_REL 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户标签关系。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustTagRelMapper {

    int countByExample(CustTagRelExample example);

    int deleteByExample(CustTagRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustTagRel record);

    int insertSelective(CustTagRel record);

    List<CustTagRel> selectByExample(CustTagRelExample example);

    CustTagRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustTagRel record, @Param("example") CustTagRelExample example);

    int updateByExample(@Param("record") CustTagRel record, @Param("example") CustTagRelExample example);

    int updateByPrimaryKeySelective(CustTagRel record);

    int updateByPrimaryKey(CustTagRel record);

}
