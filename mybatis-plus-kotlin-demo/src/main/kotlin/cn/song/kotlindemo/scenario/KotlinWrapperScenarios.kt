package cn.song.kotlindemo.scenario

import cn.song.kotlindemo.entity.KOrder
import cn.song.kotlindemo.entity.KUser
import cn.song.kotlindemo.mapper.KUserMapper
import cn.song.kotlindemo.service.KOrderService
import cn.song.kotlindemo.service.KUserService
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateWrapper
import org.springframework.stereotype.Service

/**
 * Kotlin Wrapper 链场景全覆盖（插件 KtWrapperDetector 逐行正则 MVP 语料基座）。
 *
 * 书写约束（与检测器实现强相关，改动前先读插件源码）：
 * 1. 链起点与链上调用必须写在同一行——检测器按行扫描，跨行续链只认起点行；
 * 2. 注释不要出现「包装类名 + 左括号/尖括号」字样——检测器只跳过双斜杠行，块注释体会误触发；
 * 3. and/or 嵌套用带括号 lambda 形态（尾随 lambda 无括号，正则不识别）；
 * 4. Kotlin 关键字 in 需反引号调用，MVP 正则不识别，保留该行供 PSI 深化后回归。
 *
 * @author SongRenShuo
 */
@Service
class KotlinWrapperScenarios(
    private val userService: KUserService,
    private val orderService: KOrderService,
    private val userMapper: KUserMapper,
) {

    // ---------------- ktQuery 扩展链（IService 入口，LAMBDA_QUERY 形态） ----------------

    /** 基础等值 + 模糊 */
    fun byUsername(username: String): List<KUser> =
        userService.ktQuery().eq(KUser::username, username).like(KUser::email, "@qq.com").list()

    /** 比较条件族 + 排序 */
    fun byAgeRange(low: Int, high: Int): List<KUser> =
        userService.ktQuery().ne(KUser::status, 0).gt(KUser::age, low).le(KUser::age, high).orderByDesc(KUser::id).list()

    /** 布尔开关重载 + 非空 + last 直拼 */
    fun byAgeConditional(age: Int?): List<KUser> =
        userService.ktQuery().eq(age != null, KUser::age, age).isNotNull(KUser::email).last("limit 10").list()

    /** like 左右变体 + notLike + between */
    fun byLikeFamily(fragment: String): List<KUser> =
        userService.ktQuery().likeLeft(KUser::username, fragment).notLike(KUser::email, "test").between(KUser::age, 18, 65).count().let { c ->
            userService.ktQuery().likeRight(KUser::email, fragment).ge(KUser::id, c.toInt()).list()
        }

    /** notIn + isNull */
    fun byNotInAndNull(deptIds: List<Int>): List<KUser> =
        userService.ktQuery().notIn(KUser::deptId, deptIds).isNull(KUser::email).list()

    /** select 多列 + groupBy + having（投影行） */
    fun groupByDept(): List<KUser> =
        userService.ktQuery().select(KUser::deptId).groupBy(KUser::deptId).having("count(*) > {0}", 1).list()

    /** apply 直拼 + 升序 */
    fun byApply(minAge: Int): List<KUser> =
        userService.ktQuery().apply("age > {0}", minAge).orderByAsc(KUser::deptId).list()

    /** and/or 带括号 lambda 嵌套（尾随 lambda 无括号不匹配正则，务必保留括号写法） */
    fun byOrNesting(): List<KUser> =
        userService.ktQuery().and({ w -> w.eq(KUser::status, 1).or().eq(KUser::status, 2) }).or({ w -> w.isNull(KUser::email) }).list()

    /** 反引号关键字调用（插件 MVP 正则不识别该行，留作 PSI 深化回归用例） */
    fun byBacktickIn(deptIds: List<Int>): List<KUser> =
        userService.ktQuery().`in`(KUser::deptId, deptIds).eq(KUser::status, 1).list()

    // ---------------- ktUpdate 扩展链（IService 入口，LAMBDA_UPDATE 形态） ----------------

    /** set + eq 更新 */
    fun renameById(id: Int, username: String): Boolean =
        userService.ktUpdate().set(KUser::username, username).eq(KUser::id, id).update()

    /** set 开关重载 + setSql + notIn */
    fun batchDisable(deptIds: List<Int>): Boolean =
        userService.ktUpdate().set(KUser::status != null, KUser::status, 0).setSql("version = version + 1").notIn(KUser::deptId, deptIds).update()

    /** 条件删除（链式 remove） */
    fun removeDisabled(): Boolean =
        userService.ktUpdate().eq(KUser::status, 0).isNull(KUser::email).remove()

    // ---------------- 直接构造形态（构造类名行内识别） ----------------

    /** Lambda 查询包装直接构造（构造行 + 条件同行） */
    fun byLambdaQueryDirect(status: Int): List<KUser> {
        val queryWrapper = LambdaQueryWrapper<KUser>().eq(KUser::status, status).isNotNull(KUser::email).orderByDesc(KUser::id)
        return userMapper.selectList(queryWrapper)
    }

    /** Lambda 更新包装直接构造 */
    fun updateByLambdaDirect(id: Int, age: Int): Int {
        val updateWrapper = LambdaUpdateWrapper<KUser>().set(KUser::age, age).setSql("version = version + 1").eq(KUser::id, id)
        return userMapper.update(null, updateWrapper)
    }

    /** 字符串列形态查询包装直接构造 */
    fun byStringQueryDirect(username: String): List<KUser> {
        val queryWrapper = QueryWrapper<KUser>().eq("username", username).likeRight("email", "song").orderByAsc("id")
        return userMapper.selectList(queryWrapper)
    }

    /** 字符串列形态更新包装直接构造 */
    fun updateByStringDirect(id: Int): Int {
        val updateWrapper = UpdateWrapper<KUser>().set("status", 2).setSql("version = version + 1").eq("id", id)
        return userMapper.update(null, updateWrapper)
    }

    /** Kt 系查询包装直接构造（类名含 QueryWrapper 子串，插件按字符串版形态识别——子串匹配边界用例） */
    fun byKtQueryDirect(status: Int): List<KUser> {
        val queryWrapper = KtQueryWrapper(KUser::class.java).eq(KUser::status, status).ge(KUser::age, 18)
        return userMapper.selectList(queryWrapper)
    }

    /** Kt 系更新包装直接构造 */
    fun updateByKtDirect(id: Int): Int {
        val updateWrapper = KtUpdateWrapper(KUser::class.java).set(KUser::status, 1).eq(KUser::id, id)
        return userMapper.update(null, updateWrapper)
    }

    /** 订单链：另一实体的 ktQuery（金额下限 + 已支付状态） */
    fun paidOrdersAbove(amountMin: Double): List<KOrder> =
        orderService.ktQuery().eq(KOrder::status, 1).ge(KOrder::amount, amountMin).orderByDesc(KOrder::id).list()

    /** 订单链：条件更新（取消传入订单，反引号关键字形态） */
    fun cancelStaleOrders(orderIds: List<Int>): Boolean =
        orderService.ktUpdate().set(KOrder::status, 2).`in`(KOrder::id, orderIds).update()
}
