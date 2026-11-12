package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustHolderRel;
import cn.song.custmetadata.example.CustHolderRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_HOLDER_REL 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户持有人关系。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustHolderRelMapper {

    int countByExample(CustHolderRelExample example);

    int deleteByExample(CustHolderRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustHolderRel record);

    int insertSelective(CustHolderRel record);

    List<CustHolderRel> selectByExample(CustHolderRelExample example);

    CustHolderRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustHolderRel record, @Param("example") CustHolderRelExample example);

    int updateByExample(@Param("record") CustHolderRel record, @Param("example") CustHolderRelExample example);

    int updateByPrimaryKeySelective(CustHolderRel record);

    int updateByPrimaryKey(CustHolderRel record);

}
