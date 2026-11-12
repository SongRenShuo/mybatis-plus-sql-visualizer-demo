package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustContractItem;
import cn.song.custmetadata.example.CustContractItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_CONTRACT_ITEM 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户合同明细。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustContractItemMapper {

    int countByExample(CustContractItemExample example);

    int deleteByExample(CustContractItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustContractItem record);

    int insertSelective(CustContractItem record);

    List<CustContractItem> selectByExample(CustContractItemExample example);

    CustContractItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustContractItem record, @Param("example") CustContractItemExample example);

    int updateByExample(@Param("record") CustContractItem record, @Param("example") CustContractItemExample example);

    int updateByPrimaryKeySelective(CustContractItem record);

    int updateByPrimaryKey(CustContractItem record);

}
