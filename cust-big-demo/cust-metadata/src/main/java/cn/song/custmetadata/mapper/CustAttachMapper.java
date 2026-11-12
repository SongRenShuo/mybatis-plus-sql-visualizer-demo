package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustAttach;
import cn.song.custmetadata.example.CustAttachExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_ATTACH 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户附件。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustAttachMapper {

    int countByExample(CustAttachExample example);

    int deleteByExample(CustAttachExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustAttach record);

    int insertSelective(CustAttach record);

    List<CustAttach> selectByExample(CustAttachExample example);

    CustAttach selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustAttach record, @Param("example") CustAttachExample example);

    int updateByExample(@Param("record") CustAttach record, @Param("example") CustAttachExample example);

    int updateByPrimaryKeySelective(CustAttach record);

    int updateByPrimaryKey(CustAttach record);

}
