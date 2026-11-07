package cn.song.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * GoldenDB 方言演示设备表实体（T-GoldenDbDemoCases）。
 *
 * <p>这张表的列名刻意踩 GoldenDB 保留字（调研册 {@code docs/开发计划/20261107-0901-T-GoldenDbDialect-*}
 * §1.2.3，保留字清单含 {@code storagedb} 等中兴自有词，手册 p351-355），
 * {@code @TableField} 的值直接带反引号包裹——反引号标识符是 MySQL 系方言的引用形态（手册 p320），
 * MyBatis-Plus 生成 SQL 时原样使用，借此验证「保留字列名 + 反引号包裹」在插件预览与真机上的一致性。
 * 对照面：{@code storagedb} 不是 MySQL 保留字，同一张表在 MySQL 端点不加反引号也能执行（形态级对照）。</p>
 *
 * @author T-GoldenDbDemoCases
 */
@Data
@Accessors(chain = true)
@TableName("`gdb_device`")
public class GoldenDbDevice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;

    /**
     * 设备名
     */
    @TableField("`device_name`")
    private String deviceName;

    /**
     * 保留字列名（GoldenDB 保留字清单，手册 p351-355；MySQL 非保留，作对照）
     */
    @TableField("`storagedb`")
    private String storagedb;

    /**
     * 保留字列名（MySQL 与 GoldenDB 共同保留，必须反引号包裹，手册 p320）
     */
    @TableField("`order`")
    private Integer order;
}
