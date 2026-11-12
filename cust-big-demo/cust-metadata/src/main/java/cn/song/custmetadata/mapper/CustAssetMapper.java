package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustAsset;
import cn.song.custmetadata.example.CustAssetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_ASSET 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户资产。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustAssetMapper {

    int countByExample(CustAssetExample example);

    int deleteByExample(CustAssetExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustAsset record);

    int insertSelective(CustAsset record);

    List<CustAsset> selectByExample(CustAssetExample example);

    CustAsset selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustAsset record, @Param("example") CustAssetExample example);

    int updateByExample(@Param("record") CustAsset record, @Param("example") CustAssetExample example);

    int updateByPrimaryKeySelective(CustAsset record);

    int updateByPrimaryKey(CustAsset record);

}
