package cn.song.kotlindemo.scenario

import cn.song.kotlindemo.entity.KUser

/*
 * Lambda 系包装（LambdaQueryWrapper/LambdaUpdateWrapper）的 SFunction 位置只接受
 * 「方法名可被 MP 解析成属性名」的方法引用。Kotlin 属性引用（KUser::status）经 SAM 适配
 * 后编译为 byXxx$lambda$N 合成方法，MP LambdaUtils.extract 拿到的 implMethodName 无法还原
 * 属性名，OGNL 渲染 sqlSegment 时抛「Didn't start with 'is', 'get' or 'set'」；
 * 在实体里直接声明 getId() 又与 var id 自动生成的 getter 签名冲突（Platform declaration clash）。
 * 顶层函数 + @JvmName 把 JVM 方法名编译成 getXxx，方法引用即可被 MP 正常解析出列名。
 * ktQuery/ktUpdate 链走 Kt 系包装（按属性 name 查列缓存），继续用属性引用，无需此绕行。
 */

@JvmName("getId")
fun userId(u: KUser): Int? = u.id

@JvmName("getUsername")
fun username(u: KUser): String? = u.username

@JvmName("getEmail")
fun userEmail(u: KUser): String? = u.email

@JvmName("getAge")
fun userAge(u: KUser): Int? = u.age

@JvmName("getDeptId")
fun userDeptId(u: KUser): Int? = u.deptId

@JvmName("getStatus")
fun userStatus(u: KUser): Int? = u.status
