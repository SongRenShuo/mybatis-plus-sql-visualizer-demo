package cn.song.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.OrderBy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 系统配置表(SysConfig)实体类
 * 实体注解演示：@KeySequence（序列主键，Oracle/PG 场景）、@OrderBy（默认排序，MP 3.5.3.1 属性为 asc/sort）、
 * @EnumValue（见 ConfigTypeEnum）；@SqlCondition 注解 MP 3.5.4+ 才有，本版本仅有常量类，
 * 同时继承 Model 演示 ActiveRecord 形态
 *
 * @author SongRenShuo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_config")
@KeySequence("seq_sys_config")
public class SysConfig extends Model<SysConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 配置键
     */
    private String configKey;

    /**
     * 配置值
     */
    private String configValue;

    /**
     * 配置类型（@EnumValue 枚举入库）
     */
    private ConfigTypeEnum configType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序号（@OrderBy：无显式排序时默认按此列倒序；asc 默认 true，sort 控制多注解顺序）
     */
    @OrderBy(asc = false, sort = 1)
    private Integer sortNo;

    /**
     * ActiveRecord 形态：insert（依赖 Model 基类，执行后回填主键）
     */
    public boolean insertByActiveRecord() {
        return insert();
    }

    /**
     * ActiveRecord 形态：按主键更新（要求主键非空）
     */
    public boolean updateByActiveRecord() {
        return updateById();
    }

    /**
     * ActiveRecord 形态：按主键删除
     */
    public boolean deleteByActiveRecord() {
        return deleteById();
    }
}
