package cn.song.custcenter.mapper;

import cn.song.custcenter.entity.CustInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 客户信息 Mapper（MyBatis-Plus BaseMapper + 少量自定义 SQL）。
 */
public interface CustInfoMapper extends BaseMapper<CustInfo> {

    /** 查询租户下最近的客户（自定义 SQL） */
    List<CustInfo> selectTopCustomers(@Param("tenantId") Long tenantId, @Param("limit") Integer limit);

}
