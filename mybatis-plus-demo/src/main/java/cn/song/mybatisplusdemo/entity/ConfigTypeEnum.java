package cn.song.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 配置类型枚举（@EnumValue 演示：入库时取 code 值而非枚举名）
 *
 * @author SongRenShuo
 */
public enum ConfigTypeEnum {

    SYSTEM(1, "系统配置"),

    BUSINESS(2, "业务配置"),

    SECURITY(3, "安全配置");

    /**
     * 数据库存储值（@EnumValue 标记）
     */
    @EnumValue
    private final int code;

    private final String desc;

    ConfigTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
