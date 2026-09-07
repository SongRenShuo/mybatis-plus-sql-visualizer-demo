package cn.song.kotlindemo.controller

import cn.song.kotlindemo.entity.KOrder
import cn.song.kotlindemo.entity.KUser
import cn.song.kotlindemo.scenario.KotlinWrapperScenarios
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Kotlin 场景演示控制器
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/kotlin")
class KotlinDemoController(private val scenarios: KotlinWrapperScenarios) {

    /** 基础等值 + 模糊 */
    @GetMapping("/byUsername")
    fun byUsername(username: String): List<KUser> = scenarios.byUsername(username)

    /** 比较条件族 + 排序 */
    @GetMapping("/byAgeRange")
    fun byAgeRange(low: Int, high: Int): List<KUser> = scenarios.byAgeRange(low, high)

    /** 布尔开关 + last */
    @GetMapping("/byAgeConditional")
    fun byAgeConditional(age: Int?): List<KUser> = scenarios.byAgeConditional(age)

    /** like 左右族 */
    @GetMapping("/byLikeFamily")
    fun byLikeFamily(fragment: String): List<KUser> = scenarios.byLikeFamily(fragment)

    /** notIn + isNull */
    @GetMapping("/byNotInAndNull")
    fun byNotInAndNull(): List<KUser> = scenarios.byNotInAndNull(listOf(9, 10))

    /** groupBy + having 投影 */
    @GetMapping("/groupByDept")
    fun groupByDept(): List<KUser> = scenarios.groupByDept()

    /** apply 直拼 */
    @GetMapping("/byApply")
    fun byApply(minAge: Int): List<KUser> = scenarios.byApply(minAge)

    /** and/or 嵌套 */
    @GetMapping("/byOrNesting")
    fun byOrNesting(): List<KUser> = scenarios.byOrNesting()

    /** 反引号关键字 */
    @GetMapping("/byBacktickIn")
    fun byBacktickIn(): List<KUser> = scenarios.byBacktickIn(listOf(1, 2, 3))

    /** ktUpdate 重命名 */
    @PostMapping("/rename")
    fun rename(id: Int, username: String): Boolean = scenarios.renameById(id, username)

    /** ktUpdate 批量禁用 */
    @PostMapping("/batchDisable")
    fun batchDisable(): Boolean = scenarios.batchDisable(listOf(8, 9))

    /** ktUpdate 条件删除 */
    @PostMapping("/removeDisabled")
    fun removeDisabled(): Boolean = scenarios.removeDisabled()

    /** Lambda 包装直接构造 */
    @GetMapping("/lambdaDirect")
    fun lambdaDirect(status: Int): List<KUser> = scenarios.byLambdaQueryDirect(status)

    /** 字符串列包装直接构造 */
    @GetMapping("/stringDirect")
    fun stringDirect(username: String): List<KUser> = scenarios.byStringQueryDirect(username)

    /** Kt 系包装直接构造 */
    @GetMapping("/ktDirect")
    fun ktDirect(status: Int): List<KUser> = scenarios.byKtQueryDirect(status)

    /** 订单 ktQuery 链 */
    @GetMapping("/paidOrders")
    fun paidOrders(amountMin: Double): List<KOrder> = scenarios.paidOrdersAbove(amountMin)

    /** 订单 ktUpdate 链 */
    @PostMapping("/cancelOrders")
    fun cancelOrders(): Boolean = scenarios.cancelStaleOrders(listOf(100, 101))
}
