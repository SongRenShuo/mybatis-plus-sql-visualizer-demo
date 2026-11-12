package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustAssetDetail;
import cn.song.custmetadata.example.CustAssetDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_ASSET_DETAIL 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户资产明细。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustAssetDetailMapper {

    int countByExample(CustAssetDetailExample example);

    int deleteByExample(CustAssetDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustAssetDetail record);

    int insertSelective(CustAssetDetail record);

    List<CustAssetDetail> selectByExample(CustAssetDetailExample example);

    CustAssetDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustAssetDetail record, @Param("example") CustAssetDetailExample example);

    int updateByExample(@Param("record") CustAssetDetail record, @Param("example") CustAssetDetailExample example);

    int updateByPrimaryKeySelective(CustAssetDetail record);

    int updateByPrimaryKey(CustAssetDetail record);

}
