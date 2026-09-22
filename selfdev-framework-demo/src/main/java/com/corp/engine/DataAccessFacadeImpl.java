package com.corp.engine;

import com.corp.meta.FilterExpression;

import java.util.List;
import java.util.Map;

/**
 * {@link DataAccessFacade} 的默认实现：直通 {@link LocalDbService}。
 *
 * @author SongRenShuo
 */
public class DataAccessFacadeImpl implements DataAccessFacade {

    private final LocalDbService localDbService;

    public DataAccessFacadeImpl(LocalDbService localDbService) {
        this.localDbService = localDbService;
    }

    @Override
    public List<Map<String, Object>> findByFilter(String schemaCode, FilterExpression filter) {
        return localDbService.queryList(schemaCode, filter);
    }

    @Override
    public Map<String, Object> findOneByFilter(String schemaCode, FilterExpression filter) {
        return localDbService.queryOne(schemaCode, filter);
    }

    @Override
    public long countByFilter(String schemaCode, FilterExpression filter) {
        return localDbService.count(schemaCode, filter);
    }
}
