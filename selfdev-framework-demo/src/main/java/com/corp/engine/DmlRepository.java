package com.corp.engine;

import com.corp.meta.PaginQuery;
import com.corp.meta.PaginResult;
import com.corp.meta.PaginSupport;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import java.util.List;
import java.util.Map;

/**
 * 自研框架 DML 仓储层：SQL 文本 + 命名参数 → JDBC 执行。
 *
 * <p>普通查询路径的**最深层**（其下即 Spring JdbcTemplate / 驱动等框架帧，均被内置名单跳过），
 * 因此登记 {@code com.corp.engine.} 前缀后主位置即落到业务帧；分页路径再深一层委托
 * {@link PaginSupport}，故需两个前缀。
 *
 * @author SongRenShuo
 */
public class DmlRepository {

    private final NamedParameterJdbcTemplate template;

    public DmlRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    /** 查询列表（Map 行）。 */
    public List<Map<String, Object>> query(String sql, Map<String, Object> params) {
        return template.queryForList(sql, params);
    }

    /** 查询单条（Map 行），无记录返回 null。 */
    public Map<String, Object> queryOne(String sql, Map<String, Object> params) {
        List<Map<String, Object>> rows = template.queryForList(sql, params);
        return rows.isEmpty() ? null : rows.get(0);
    }

    /** 计数。 */
    public long count(String sql, Map<String, Object> params) {
        Long value = template.queryForObject(sql, params, Long.class);
        return value == null ? 0L : value;
    }

    /** 分组统计（列名由 SQL 的 AS 决定）。 */
    public List<Map<String, Object>> queryGroup(String sql, Map<String, Object> params) {
        return template.queryForList(sql, params);
    }

    /** 更新/删除，返回受影响行数。 */
    public int update(String sql, Map<String, Object> params) {
        return template.update(sql, params);
    }

    /** 分页查询：委托 {@link PaginSupport} 包装总数与 LIMIT（执行链最深层在该类）。 */
    public <T> PaginResult<T> queryPaged(String sql, Map<String, Object> params,
                                         RowMapper<T> rowMapper, PaginQuery page) {
        return PaginSupport.wrapAndQuery(template, sql, params, rowMapper, page);
    }
}
