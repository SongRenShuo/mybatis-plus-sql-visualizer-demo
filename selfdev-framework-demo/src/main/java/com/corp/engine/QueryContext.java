package com.corp.engine;

import com.corp.meta.FilterExpression;

import java.util.List;
import java.util.Map;

/**
 * 自研框架回调上下文：把当前 schemaCode 与引擎服务打包交给业务回调，
 * 使业务在 {@code executeInSchema(schemaCode, ctx -> ...)} 中直接发条件、不感知引擎内部。
 *
 * @author SongRenShuo
 */
public final class QueryContext {

    private final String schemaCode;
    private final LocalDbService localDbService;

    QueryContext(String schemaCode, LocalDbService localDbService) {
        this.schemaCode = schemaCode;
        this.localDbService = localDbService;
    }

    public String getSchemaCode() {
        return schemaCode;
    }

    public List<Map<String, Object>> findByFilter(FilterExpression filter) {
        return localDbService.queryList(schemaCode, filter);
    }

    public Map<String, Object> findOneByFilter(FilterExpression filter) {
        return localDbService.queryOne(schemaCode, filter);
    }

    public long countByFilter(FilterExpression filter) {
        return localDbService.count(schemaCode, filter);
    }
}
