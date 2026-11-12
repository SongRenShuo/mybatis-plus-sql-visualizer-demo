package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustChangeLog;
import cn.song.custmetadata.example.CustChangeLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_CHANGE_LOG 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户变更日志。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustChangeLogMapper {

    int countByExample(CustChangeLogExample example);

    int deleteByExample(CustChangeLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustChangeLog record);

    int insertSelective(CustChangeLog record);

    List<CustChangeLog> selectByExample(CustChangeLogExample example);

    CustChangeLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustChangeLog record, @Param("example") CustChangeLogExample example);

    int updateByExample(@Param("record") CustChangeLog record, @Param("example") CustChangeLogExample example);

    int updateByPrimaryKeySelective(CustChangeLog record);

    int updateByPrimaryKey(CustChangeLog record);

}
