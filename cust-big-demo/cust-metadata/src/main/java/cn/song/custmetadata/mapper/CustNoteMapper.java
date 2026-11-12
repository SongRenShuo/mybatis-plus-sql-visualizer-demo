package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustNote;
import cn.song.custmetadata.example.CustNoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_NOTE 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户备注。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustNoteMapper {

    int countByExample(CustNoteExample example);

    int deleteByExample(CustNoteExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustNote record);

    int insertSelective(CustNote record);

    List<CustNote> selectByExample(CustNoteExample example);

    CustNote selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustNote record, @Param("example") CustNoteExample example);

    int updateByExample(@Param("record") CustNote record, @Param("example") CustNoteExample example);

    int updateByPrimaryKeySelective(CustNote record);

    int updateByPrimaryKey(CustNote record);

}
