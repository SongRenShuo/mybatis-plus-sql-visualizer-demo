package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustCert;
import cn.song.custmetadata.example.CustCertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_CERT 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户证件。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustCertMapper {

    int countByExample(CustCertExample example);

    int deleteByExample(CustCertExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustCert record);

    int insertSelective(CustCert record);

    List<CustCert> selectByExample(CustCertExample example);

    CustCert selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustCert record, @Param("example") CustCertExample example);

    int updateByExample(@Param("record") CustCert record, @Param("example") CustCertExample example);

    int updateByPrimaryKeySelective(CustCert record);

    int updateByPrimaryKey(CustCert record);

}
