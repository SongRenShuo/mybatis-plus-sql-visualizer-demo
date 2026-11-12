package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustManager;
import cn.song.custmetadata.example.CustManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_MANAGER 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户经理。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustManagerMapper {

    int countByExample(CustManagerExample example);

    int deleteByExample(CustManagerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustManager record);

    int insertSelective(CustManager record);

    List<CustManager> selectByExample(CustManagerExample example);

    CustManager selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustManager record, @Param("example") CustManagerExample example);

    int updateByExample(@Param("record") CustManager record, @Param("example") CustManagerExample example);

    int updateByPrimaryKeySelective(CustManager record);

    int updateByPrimaryKey(CustManager record);

}
