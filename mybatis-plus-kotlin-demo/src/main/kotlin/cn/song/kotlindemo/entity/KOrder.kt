package cn.song.kotlindemo.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.math.BigDecimal

/**
 * Kotlin 订单表实体
 *
 * @author SongRenShuo
 */
@TableName("k_order")
data class KOrder(
    /** 主键 */
    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null,
    /** 订单号 */
    var orderNo: String? = null,
    /** 下单用户ID */
    var userId: Int? = null,
    /** 金额 */
    var amount: BigDecimal? = null,
    /** 状态（0待支付 1已支付 2已取消） */
    var status: Int? = null,
)
