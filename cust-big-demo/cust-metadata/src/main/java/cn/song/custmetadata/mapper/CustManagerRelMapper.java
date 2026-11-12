package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustManagerRel;
import cn.song.custmetadata.example.CustManagerRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_MANAGER_REL 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户经理关系。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustManagerRelMapper {

    int countByExample(CustManagerRelExample example);

    int deleteByExample(CustManagerRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustManagerRel record);

    int insertSelective(CustManagerRel record);

    List<CustManagerRel> selectByExample(CustManagerRelExample example);

    CustManagerRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustManagerRel record, @Param("example") CustManagerRelExample example);

    int updateByExample(@Param("record") CustManagerRel record, @Param("example") CustManagerRelExample example);

    int updateByPrimaryKeySelective(CustManagerRel record);

    int updateByPrimaryKey(CustManagerRel record);

}
