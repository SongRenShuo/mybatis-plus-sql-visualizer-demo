package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustAuditLog;
import cn.song.custmetadata.example.CustAuditLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_AUDIT_LOG 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户审计日志。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustAuditLogMapper {

    int countByExample(CustAuditLogExample example);

    int deleteByExample(CustAuditLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustAuditLog record);

    int insertSelective(CustAuditLog record);

    List<CustAuditLog> selectByExample(CustAuditLogExample example);

    CustAuditLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustAuditLog record, @Param("example") CustAuditLogExample example);

    int updateByExample(@Param("record") CustAuditLog record, @Param("example") CustAuditLogExample example);

    int updateByPrimaryKeySelective(CustAuditLog record);

    int updateByPrimaryKey(CustAuditLog record);

}
