package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustRiskEval;
import cn.song.custmetadata.example.CustRiskEvalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_RISK_EVAL 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户风险评估。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustRiskEvalMapper {

    int countByExample(CustRiskEvalExample example);

    int deleteByExample(CustRiskEvalExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustRiskEval record);

    int insertSelective(CustRiskEval record);

    List<CustRiskEval> selectByExample(CustRiskEvalExample example);

    CustRiskEval selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustRiskEval record, @Param("example") CustRiskEvalExample example);

    int updateByExample(@Param("record") CustRiskEval record, @Param("example") CustRiskEvalExample example);

    int updateByPrimaryKeySelective(CustRiskEval record);

    int updateByPrimaryKey(CustRiskEval record);

}
