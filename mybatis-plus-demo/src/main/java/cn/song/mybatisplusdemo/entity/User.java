package cn.song.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户表(User)表实体类
 *
 * @author SongRenShuo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 部门ID
     */
    private Integer deptId;

    /**
     * 状态（0禁用 1启用）
     */
    private Integer status;

    /**
     * 创建时间（自动填充）
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新时间（自动填充）
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 逻辑删除（0未删除 1已删除）
     */
    @TableLogic
    private Integer deleted;

    /**
     * 乐观锁版本号
     */
    @Version
    private Integer version;

    /**
     * 非表字段：角色名称（联查填充）
     */
    @TableField(exist = false)
    private String roleName;

    /**
     * 非表字段：部门（一对多/多对一 XML resultMap association 演示）
     */
    @TableField(exist = false)
    private Department department;

    /**
     * 非表字段：订单列表（一对多 XML resultMap collection 演示）
     */
    @TableField(exist = false)
    private java.util.List<Order> orders;
}
