package com.corp.engine;

import com.corp.meta.FilterExpression;
import com.corp.meta.PaginQuery;
import com.corp.meta.PaginResult;

import java.util.List;
import java.util.Map;

/**
 * 自研框架数据查询门面（**Spring Bean 形态**）：与静态门面 {@link DataUpdateTool} 同语义，
 * 但由业务以 {@code @Autowired} 注入后实例调用。
 *
 * <p>两种门面形态的引擎帧完全相同，差别只在业务帧的书写位置——用于验证前缀登记对
 * 「Bean 门面 vs 静态门面」两种调用形态一视同仁。
 *
 * @author SongRenShuo
 */
public class DataQueryTool {

    private final LocalDbService localDbService;

    public DataQueryTool(LocalDbService localDbService) {
        this.localDbService = localDbService;
    }

    public List<Map<String, Object>> findByFilter(String schemaCode, FilterExpression filter) {
        return localDbService.queryList(schemaCode, filter);
    }

    public Map<String, Object> findOneByFilter(String schemaCode, FilterExpression filter) {
        return localDbService.queryOne(schemaCode, filter);
    }

    public long countByFilter(String schemaCode, FilterExpression filter) {
        return localDbService.count(schemaCode, filter);
    }

    public List<Map<String, Object>> findByFilterOrdered(String schemaCode, FilterExpression filter,
                                                         String orderBy, int limit) {
        return localDbService.queryListOrdered(schemaCode, filter, orderBy, limit);
    }

    public List<Map<String, Object>> groupSummary(String schemaCode, FilterExpression filter,
                                                  String groupField) {
        return localDbService.queryGroupSummary(schemaCode, filter, groupField);
    }

    public <T> PaginResult<T> findByFilterPaged(String schemaCode, FilterExpression filter,
                                                PaginQuery page, Class<T> resultType) {
        return localDbService.queryPage(schemaCode, filter, page, resultType);
    }
}
