package cn.song.custcenter.config;

/**
 * 逻辑删除配置。
 */
public class LogicDeleteConfig {

    /** 逻辑删除字段。 */
    public String logicDeleteField() {
        return "delFlag";
    }
}
