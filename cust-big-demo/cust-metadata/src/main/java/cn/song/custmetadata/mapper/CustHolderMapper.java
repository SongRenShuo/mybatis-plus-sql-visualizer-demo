package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustHolder;
import cn.song.custmetadata.example.CustHolderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_HOLDER 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户持有人。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustHolderMapper {

    int countByExample(CustHolderExample example);

    int deleteByExample(CustHolderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustHolder record);

    int insertSelective(CustHolder record);

    List<CustHolder> selectByExample(CustHolderExample example);

    CustHolder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustHolder record, @Param("example") CustHolderExample example);

    int updateByExample(@Param("record") CustHolder record, @Param("example") CustHolderExample example);

    int updateByPrimaryKeySelective(CustHolder record);

    int updateByPrimaryKey(CustHolder record);

}
