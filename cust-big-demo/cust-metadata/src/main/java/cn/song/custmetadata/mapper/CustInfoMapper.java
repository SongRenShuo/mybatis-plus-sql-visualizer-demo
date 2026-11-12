package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustInfo;
import cn.song.custmetadata.example.CustInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_INFO 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户信息。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustInfoMapper {

    int countByExample(CustInfoExample example);

    int deleteByExample(CustInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustInfo record);

    int insertSelective(CustInfo record);

    List<CustInfo> selectByExample(CustInfoExample example);

    CustInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustInfo record, @Param("example") CustInfoExample example);

    int updateByExample(@Param("record") CustInfo record, @Param("example") CustInfoExample example);

    int updateByPrimaryKeySelective(CustInfo record);

    int updateByPrimaryKey(CustInfo record);

}
