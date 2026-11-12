package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustScoreLog;
import cn.song.custmetadata.example.CustScoreLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_SCORE_LOG 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户评分日志。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustScoreLogMapper {

    int countByExample(CustScoreLogExample example);

    int deleteByExample(CustScoreLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustScoreLog record);

    int insertSelective(CustScoreLog record);

    List<CustScoreLog> selectByExample(CustScoreLogExample example);

    CustScoreLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustScoreLog record, @Param("example") CustScoreLogExample example);

    int updateByExample(@Param("record") CustScoreLog record, @Param("example") CustScoreLogExample example);

    int updateByPrimaryKeySelective(CustScoreLog record);

    int updateByPrimaryKey(CustScoreLog record);

}
