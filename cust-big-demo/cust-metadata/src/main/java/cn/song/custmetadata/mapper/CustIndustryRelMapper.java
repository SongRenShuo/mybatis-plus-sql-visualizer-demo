package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustIndustryRel;
import cn.song.custmetadata.example.CustIndustryRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_INDUSTRY_REL 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户行业关系。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustIndustryRelMapper {

    int countByExample(CustIndustryRelExample example);

    int deleteByExample(CustIndustryRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustIndustryRel record);

    int insertSelective(CustIndustryRel record);

    List<CustIndustryRel> selectByExample(CustIndustryRelExample example);

    CustIndustryRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustIndustryRel record, @Param("example") CustIndustryRelExample example);

    int updateByExample(@Param("record") CustIndustryRel record, @Param("example") CustIndustryRelExample example);

    int updateByPrimaryKeySelective(CustIndustryRel record);

    int updateByPrimaryKey(CustIndustryRel record);

}
