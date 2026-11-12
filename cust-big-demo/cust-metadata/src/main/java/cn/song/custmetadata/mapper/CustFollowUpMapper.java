package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustFollowUp;
import cn.song.custmetadata.example.CustFollowUpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_FOLLOW_UP 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户跟进。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustFollowUpMapper {

    int countByExample(CustFollowUpExample example);

    int deleteByExample(CustFollowUpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustFollowUp record);

    int insertSelective(CustFollowUp record);

    List<CustFollowUp> selectByExample(CustFollowUpExample example);

    CustFollowUp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustFollowUp record, @Param("example") CustFollowUpExample example);

    int updateByExample(@Param("record") CustFollowUp record, @Param("example") CustFollowUpExample example);

    int updateByPrimaryKeySelective(CustFollowUp record);

    int updateByPrimaryKey(CustFollowUp record);

}
