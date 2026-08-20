package cn.song.jpademo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单统计 DTO（JPQL NEW 构造表达式用例）
 *
 * @author SongRenShuo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long customerId;

    private Long orderCount;

    private BigDecimal totalAmount;
}
