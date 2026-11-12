package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustGroupRel;
import cn.song.custmetadata.example.CustGroupRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_GROUP_REL 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户群组关系。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustGroupRelMapper {

    int countByExample(CustGroupRelExample example);

    int deleteByExample(CustGroupRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustGroupRel record);

    int insertSelective(CustGroupRel record);

    List<CustGroupRel> selectByExample(CustGroupRelExample example);

    CustGroupRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustGroupRel record, @Param("example") CustGroupRelExample example);

    int updateByExample(@Param("record") CustGroupRel record, @Param("example") CustGroupRelExample example);

    int updateByPrimaryKeySelective(CustGroupRel record);

    int updateByPrimaryKey(CustGroupRel record);

}
