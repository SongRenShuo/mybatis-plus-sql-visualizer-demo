package com.corp.meta;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 自研框架元数据注册表：schemaCode → {@link TableMeta}。
 *
 * <p>真实项目中这张表来自配置中心或数据库元数据表；此处内联登记两个 schema：
 * <ul>
 *   <li>{@code SCHEMA_CODE_PROJECT_PLAN}：单表 {@code biz_project_plan}；</li>
 *   <li>{@code SCHEMA_CODE_PROJECT_PLAN_MEMBER}：与 {@code biz_project_member} 的 LEFT JOIN 视图。</li>
 * </ul>
 *
 * @author SongRenShuo
 */
public final class MetaRegistry {

    public static final String SCHEMA_PROJECT_PLAN = "SCHEMA_CODE_PROJECT_PLAN";
    public static final String SCHEMA_PROJECT_PLAN_MEMBER = "SCHEMA_CODE_PROJECT_PLAN_MEMBER";

    private static final Map<String, TableMeta> REGISTRY = new ConcurrentHashMap<String, TableMeta>();

    static {
        register(new TableMeta(
                SCHEMA_PROJECT_PLAN,
                "biz_project_plan p",
                "id",
                planColumns("p."),
                "p",
                true));

        Map<String, String> joinColumns = planColumns("p.");
        joinColumns.put("member_name", "m.member_name");
        joinColumns.put("member_role", "m.role");
        register(new TableMeta(
                SCHEMA_PROJECT_PLAN_MEMBER,
                "biz_project_plan p LEFT JOIN biz_project_member m ON p.plan_id = m.plan_id",
                "id",
                joinColumns,
                null,
                false));
    }

    private MetaRegistry() {
    }

    public static void register(TableMeta meta) {
        REGISTRY.put(meta.getSchemaCode(), meta);
    }

    /** 按 schemaCode 取元数据；未登记返回 null（由上层抛框架异常）。 */
    public static TableMeta resolve(String schemaCode) {
        return schemaCode == null ? null : REGISTRY.get(schemaCode);
    }

    private static Map<String, String> planColumns(String prefix) {
        Map<String, String> columns = new LinkedHashMap<String, String>();
        columns.put("id", prefix + "id");
        columns.put("plan_id", prefix + "plan_id");
        columns.put("schema_code", prefix + "schema_code");
        columns.put("project_name", prefix + "project_name");
        columns.put("owner", prefix + "owner");
        columns.put("status", prefix + "status");
        columns.put("amount", prefix + "amount");
        columns.put("create_time", prefix + "create_time");
        columns.put("update_time", prefix + "update_time");
        return columns;
    }
}
