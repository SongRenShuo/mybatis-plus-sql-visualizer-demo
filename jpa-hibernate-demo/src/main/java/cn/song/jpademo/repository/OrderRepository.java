package cn.song.jpademo.repository;

import cn.song.jpademo.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单 Repository（自定义表名 t_order 派生查询 / JPQL 用例）
 *
 * @author SongRenShuo
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    /**
     * 派生查询：订单号等值
     */
    List<OrderEntity> findByOrderNo(String orderNo);

    /**
     * 派生查询：金额区间 + 客户
     */
    List<OrderEntity> findByCustomerIdAndTotalAmountBetween(Long customerId, BigDecimal min, BigDecimal max);

    /**
     * JPQL：自定义表名映射（OrderEntity → t_order）
     */
    @Query("SELECT o FROM OrderEntity o WHERE o.totalAmount >= :minAmount ORDER BY o.totalAmount DESC")
    List<OrderEntity> findByMinAmount(@Param("minAmount") BigDecimal minAmount);

    /**
     * JPQL：NEW DTO 构造表达式
     */
    @Query("SELECT NEW cn.song.jpademo.dto.OrderStatDTO(o.customerId, COUNT(o), SUM(o.totalAmount)) " +
            "FROM OrderEntity o GROUP BY o.customerId HAVING COUNT(o) > 1")
    List<cn.song.jpademo.dto.OrderStatDTO> statByCustomer();
}
