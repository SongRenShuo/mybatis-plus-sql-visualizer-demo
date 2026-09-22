package com.corp.engine;

import com.corp.meta.FilterExpression;

import java.util.List;
import java.util.Map;

/**
 * 自研框架链式查询构建器：{@code DataUpdateTool.query(schema).where(...).orderBy(...).limit(n).list()}。
 *
 * <p>SQL 在终结方法（list/one/count）才真正发出——调用栈的形态与直调门面一致，
 * 但业务帧位置不同（链式终结行），用于验证前缀登记后落点仍精确到业务行。
 *
 * @author SongRenShuo
 */
public final class DataQuery {

    private final String schemaCode;
    private FilterExpression filter;
    private String orderBy;
    private int limit = -1;

    DataQuery(String schemaCode) {
        this.schemaCode = schemaCode;
    }

    public DataQuery where(FilterExpression expression) {
        this.filter = expression;
        return this;
    }

    public DataQuery orderBy(String orderByField) {
        this.orderBy = orderByField;
        return this;
    }

    public DataQuery limit(int limit) {
        this.limit = limit;
        return this;
    }

    public List<Map<String, Object>> list() {
        return DataUpdateTool.findByFilterOrdered(schemaCode, filter, orderBy, limit);
    }

    public Map<String, Object> one() {
        return DataUpdateTool.findOneByFilter(schemaCode, filter);
    }

    public long count() {
        return DataUpdateTool.countByFilter(schemaCode, filter);
    }
}
