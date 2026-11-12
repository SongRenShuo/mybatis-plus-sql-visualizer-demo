package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustChannel;
import cn.song.custmetadata.example.CustChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_CHANNEL 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户渠道。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustChannelMapper {

    int countByExample(CustChannelExample example);

    int deleteByExample(CustChannelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustChannel record);

    int insertSelective(CustChannel record);

    List<CustChannel> selectByExample(CustChannelExample example);

    CustChannel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustChannel record, @Param("example") CustChannelExample example);

    int updateByExample(@Param("record") CustChannel record, @Param("example") CustChannelExample example);

    int updateByPrimaryKeySelective(CustChannel record);

    int updateByPrimaryKey(CustChannel record);

}
