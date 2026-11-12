package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustComplaint;
import cn.song.custmetadata.example.CustComplaintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_COMPLAINT 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户投诉。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustComplaintMapper {

    int countByExample(CustComplaintExample example);

    int deleteByExample(CustComplaintExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustComplaint record);

    int insertSelective(CustComplaint record);

    List<CustComplaint> selectByExample(CustComplaintExample example);

    CustComplaint selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustComplaint record, @Param("example") CustComplaintExample example);

    int updateByExample(@Param("record") CustComplaint record, @Param("example") CustComplaintExample example);

    int updateByPrimaryKeySelective(CustComplaint record);

    int updateByPrimaryKey(CustComplaint record);

}
