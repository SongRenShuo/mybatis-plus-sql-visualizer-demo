package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustContract;
import cn.song.custmetadata.example.CustContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_CONTRACT 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户合同。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustContractMapper {

    int countByExample(CustContractExample example);

    int deleteByExample(CustContractExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustContract record);

    int insertSelective(CustContract record);

    List<CustContract> selectByExample(CustContractExample example);

    CustContract selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustContract record, @Param("example") CustContractExample example);

    int updateByExample(@Param("record") CustContract record, @Param("example") CustContractExample example);

    int updateByPrimaryKeySelective(CustContract record);

    int updateByPrimaryKey(CustContract record);

}
