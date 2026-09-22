package cn.song.selfdevdemo.common;

/**
 * 业务侧 schemaCode 常量（与自研框架元数据登记保持一致）。
 *
 * <p>真实项目里这些常量通常来自业务字典或配置中心，业务代码只认字符串、不认 SQL。
 *
 * @author SongRenShuo
 */
public final class SchemaCodes {

    /** 项目计划单表。 */
    public static final String PROJECT_PLAN = "SCHEMA_CODE_PROJECT_PLAN";

    /** 项目计划 + 成员 JOIN 视图。 */
    public static final String PROJECT_PLAN_MEMBER = "SCHEMA_CODE_PROJECT_PLAN_MEMBER";

    private SchemaCodes() {
    }
}
