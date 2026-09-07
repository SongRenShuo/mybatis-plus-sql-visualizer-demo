package cn.song.kotlindemo.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableLogic
import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.Version

/**
 * Kotlin 用户表实体（data class + 可空默认值，MP 反射实例化友好）
 *
 * @author SongRenShuo
 */
@TableName("k_user")
data class KUser(
    /** 主键 */
    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null,
    /** 用户名 */
    var username: String? = null,
    /** 邮箱 */
    var email: String? = null,
    /** 年龄 */
    var age: Int? = null,
    /** 部门ID */
    var deptId: Int? = null,
    /** 状态（0禁用 1启用） */
    var status: Int? = null,
    /** 逻辑删除标记 */
    @TableLogic
    var deleted: Int? = null,
    /** 乐观锁版本号 */
    @Version
    var version: Int? = null,
)
