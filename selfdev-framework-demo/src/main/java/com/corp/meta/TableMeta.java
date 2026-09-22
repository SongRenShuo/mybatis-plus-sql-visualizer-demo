package com.corp.meta;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 自研框架表元数据：一个 schemaCode 对应的表表达式、逻辑字段到限定列的映射与主键。
 *
 * <p>业务侧写条件时只用逻辑字段名（{@code "status"}），由 {@link SqlRenderer} 依本映射
 * 翻成带表别名的限定列（{@code "p.status"}）——JOIN 场景因此无需业务感知表别名。
 *
 * <p>{@link #getAlias()} 与 {@link #isDeletable()} 供写路径构造合法 SQL：
 * MySQL 的 {@code DELETE} 不接受 {@code DELETE FROM tbl p} 形态的表别名，必须写成
 * {@code DELETE p FROM tbl p}（多表删除语法）；多表 JOIN 视图则直接拒绝删除。
 *
 * @author SongRenShuo
 */
public final class TableMeta {

    private final String schemaCode;
    /** 表表达式：单表名或 JOIN 表达式（可带别名）。 */
    private final String tableExpression;
    private final String idColumn;
    /** 逻辑字段名 → 限定列名（插入顺序即 SELECT 列顺序）。 */
    private final Map<String, String> columns;
    /** 单表别名；多表视图为 null。 */
    private final String alias;
    /** 是否支持按条件删除（多表视图不支持）。 */
    private final boolean deletable;

    public TableMeta(String schemaCode, String tableExpression, String idColumn,
                     Map<String, String> columns, String alias, boolean deletable) {
        this.schemaCode = schemaCode;
        this.tableExpression = tableExpression;
        this.idColumn = idColumn;
        this.columns = Collections.unmodifiableMap(new LinkedHashMap<String, String>(columns));
        this.alias = alias;
        this.deletable = deletable;
    }

    public String getSchemaCode() {
        return schemaCode;
    }

    public String getTableExpression() {
        return tableExpression;
    }

    public String getIdColumn() {
        return idColumn;
    }

    public Map<String, String> getColumns() {
        return columns;
    }

    public String getAlias() {
        return alias;
    }

    public boolean isDeletable() {
        return deletable;
    }

    /** 逻辑字段 → 限定列名；未登记字段原样返回（交由数据库报错，与真实框架一致）。 */
    public String columnOf(String logicalField) {
        String column = columns.get(logicalField);
        return column == null ? logicalField : column;
    }

    /** SELECT 列清单。 */
    public String selectColumns() {
        StringBuilder sb = new StringBuilder();
        for (String column : columns.values()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(column);
        }
        return sb.toString();
    }

    /** 主键限定列名（COUNT/DELETE 用）。 */
    public String idColumnOf() {
        return columnOf(idColumn);
    }

    /**
     * DELETE 语句的 FROM 片段：单表带别名时用 {@code DELETE p FROM tbl p}（MySQL 多表删除语法），
     * 无别名时用标准 {@code DELETE FROM tbl}。
     */
    public String deleteFromClause() {
        if (alias == null || alias.trim().isEmpty()) {
            return "DELETE FROM " + tableExpression;
        }
        return "DELETE " + alias + " FROM " + tableExpression;
    }
}
