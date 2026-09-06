package cn.song.mybatisplusdemo.mapper;

import cn.song.mybatisplusdemo.entity.Order;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 订单表(Order)数据库访问层
 *
 * @author SongRenShuo
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * XML 动态 SQL：${ew.customSqlSegment} 展开（Wrapper 条件段拼接进自定义 SQL）
     */
    List<Order> selectByCustomSqlSegment(@Param("ew") Wrapper<Order> ew);

    /**
     * XML 动态 SQL：${ew.customSqlSegment} + join 联表（ew 条件段用于主表过滤）
     */
    List<Map<String, Object>> selectOrderWithUserByEw(@Param("ew") Wrapper<Order> ew);

    /**
     * XML 动态 SQL：where + if 多条件 + foreach 状态集合
     */
    List<Order> selectOrdersByCondition(@Param("orderNo") String orderNo,
                                        @Param("minAmount") BigDecimal minAmount,
                                        @Param("statusList") List<Integer> statusList);

    /**
     * XML 动态 SQL：group by + having 聚合统计
     */
    List<Map<String, Object>> statOrderAmountByUser(@Param("minAmount") BigDecimal minAmount);
}
