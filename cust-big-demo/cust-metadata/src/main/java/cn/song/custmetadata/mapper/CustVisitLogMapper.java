package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustVisitLog;
import cn.song.custmetadata.example.CustVisitLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_VISIT_LOG 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户拜访记录。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustVisitLogMapper {

    int countByExample(CustVisitLogExample example);

    int deleteByExample(CustVisitLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustVisitLog record);

    int insertSelective(CustVisitLog record);

    List<CustVisitLog> selectByExample(CustVisitLogExample example);

    CustVisitLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustVisitLog record, @Param("example") CustVisitLogExample example);

    int updateByExample(@Param("record") CustVisitLog record, @Param("example") CustVisitLogExample example);

    int updateByPrimaryKeySelective(CustVisitLog record);

    int updateByPrimaryKey(CustVisitLog record);

}
