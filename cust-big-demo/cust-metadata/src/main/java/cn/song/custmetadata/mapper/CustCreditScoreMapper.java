package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustCreditScore;
import cn.song.custmetadata.example.CustCreditScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_CREDIT_SCORE 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户信用评分。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustCreditScoreMapper {

    int countByExample(CustCreditScoreExample example);

    int deleteByExample(CustCreditScoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustCreditScore record);

    int insertSelective(CustCreditScore record);

    List<CustCreditScore> selectByExample(CustCreditScoreExample example);

    CustCreditScore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustCreditScore record, @Param("example") CustCreditScoreExample example);

    int updateByExample(@Param("record") CustCreditScore record, @Param("example") CustCreditScoreExample example);

    int updateByPrimaryKeySelective(CustCreditScore record);

    int updateByPrimaryKey(CustCreditScore record);

}
