package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustContact;
import cn.song.custmetadata.example.CustContactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_CONTACT 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户联系方式。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustContactMapper {

    int countByExample(CustContactExample example);

    int deleteByExample(CustContactExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustContact record);

    int insertSelective(CustContact record);

    List<CustContact> selectByExample(CustContactExample example);

    CustContact selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustContact record, @Param("example") CustContactExample example);

    int updateByExample(@Param("record") CustContact record, @Param("example") CustContactExample example);

    int updateByPrimaryKeySelective(CustContact record);

    int updateByPrimaryKey(CustContact record);

}
