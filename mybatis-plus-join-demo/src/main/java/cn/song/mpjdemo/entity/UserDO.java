package cn.song.mpjdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 用户表(User)实体（MPJ 主表）
 *
 * @author SongRenShuo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
// user 在达梦是保留字，统一带双引号引用；MySQL 侧由 jdbc url 的 sql_mode=ANSI_QUOTES 保证双引号同样按标识符解析
@TableName("\"user\"")
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private Integer sex;

    private String headImg;

    /**
     * 非表字段：fill 填充目标（一对多地址集合）
     */
    @TableField(exist = false)
    private List<AddressDO> addressList;
}
