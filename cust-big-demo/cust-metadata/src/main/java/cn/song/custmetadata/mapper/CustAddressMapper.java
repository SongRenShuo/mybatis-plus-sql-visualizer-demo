package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustAddress;
import cn.song.custmetadata.example.CustAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_ADDRESS 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户地址。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustAddressMapper {

    int countByExample(CustAddressExample example);

    int deleteByExample(CustAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustAddress record);

    int insertSelective(CustAddress record);

    List<CustAddress> selectByExample(CustAddressExample example);

    CustAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustAddress record, @Param("example") CustAddressExample example);

    int updateByExample(@Param("record") CustAddress record, @Param("example") CustAddressExample example);

    int updateByPrimaryKeySelective(CustAddress record);

    int updateByPrimaryKey(CustAddress record);

}
