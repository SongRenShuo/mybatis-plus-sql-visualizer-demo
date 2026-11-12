package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustIndustry;
import cn.song.custmetadata.example.CustIndustryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_INDUSTRY 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户行业。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustIndustryMapper {

    int countByExample(CustIndustryExample example);

    int deleteByExample(CustIndustryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustIndustry record);

    int insertSelective(CustIndustry record);

    List<CustIndustry> selectByExample(CustIndustryExample example);

    CustIndustry selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustIndustry record, @Param("example") CustIndustryExample example);

    int updateByExample(@Param("record") CustIndustry record, @Param("example") CustIndustryExample example);

    int updateByPrimaryKeySelective(CustIndustry record);

    int updateByPrimaryKey(CustIndustry record);

}
