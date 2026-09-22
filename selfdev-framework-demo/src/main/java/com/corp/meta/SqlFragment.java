package com.corp.meta;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 自研框架 SQL 片段：一段 SQL 文本 + 其命名参数（顺序保留，便于日志与调试）。
 *
 * @author SongRenShuo
 */
public final class SqlFragment {

    private final String sql;
    private final Map<String, Object> params;

    public SqlFragment(String sql, Map<String, Object> params) {
        this.sql = sql;
        this.params = params == null ? new LinkedHashMap<String, Object>() : params;
    }

    public String getSql() {
        return sql;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    @Override
    public String toString() {
        return sql + " " + params;
    }
}
