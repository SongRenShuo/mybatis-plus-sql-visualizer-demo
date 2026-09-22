package com.corp.engine;

import com.corp.meta.FilterExpression;
import com.corp.meta.PaginQuery;
import com.corp.meta.PaginResult;
import com.corp.meta.SqlFragment;
import com.corp.meta.SqlRenderer;
import com.corp.meta.TableMeta;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 自研框架本地库服务：编排「元数据 → 条件渲染 → 仓储执行」的完整链路。
 *
 * <p>业务侧的一切读写都经此汇聚——所有 SQL 的调用栈在业务帧之下形如
 * {@code LocalDbService → DmlRepository → (PaginSupport) → JdbcTemplate → 驱动}，
 * 引擎帧对每一条语句都是同一批方法，这正是「跳转恒落框架方法」的成因。
 *
 * @author SongRenShuo
 */
public class LocalDbService {

    private final MetaDataService metaDataService;
    private final DmlRepository dmlRepository;

    public LocalDbService(MetaDataService metaDataService, DmlRepository dmlRepository) {
        this.metaDataService = metaDataService;
        this.dmlRepository = dmlRepository;
    }

    /** 查询列表。 */
    public List<Map<String, Object>> queryList(String schemaCode, FilterExpression filter) {
        TableMeta meta = metaDataService.resolve(schemaCode);
        SqlFragment where = SqlRenderer.render(meta, filter);
        return dmlRepository.query(selectSql(meta, where), where.getParams());
    }

    /** 查询单条。 */
    public Map<String, Object> queryOne(String schemaCode, FilterExpression filter) {
        TableMeta meta = metaDataService.resolve(schemaCode);
        SqlFragment where = SqlRenderer.render(meta, filter);
        return dmlRepository.queryOne(selectSql(meta, where), where.getParams());
    }

    /** 查询列表（排序 + 限制）。 */
    public List<Map<String, Object>> queryListOrdered(String schemaCode, FilterExpression filter,
                                                      String orderBy, int limit) {
        TableMeta meta = metaDataService.resolve(schemaCode);
        SqlFragment where = SqlRenderer.render(meta, filter);
        StringBuilder sql = new StringBuilder(selectSql(meta, where));
        if (orderBy != null && !orderBy.trim().isEmpty()) {
            sql.append(" ORDER BY ").append(orderColumn(meta, orderBy.trim()));
        }
        if (limit > 0) {
            sql.append(" LIMIT ").append(limit);
        }
        return dmlRepository.query(sql.toString(), where.getParams());
    }

    /** 计数。 */
    public long count(String schemaCode, FilterExpression filter) {
        TableMeta meta = metaDataService.resolve(schemaCode);
        SqlFragment where = SqlRenderer.render(meta, filter);
        String sql = "SELECT COUNT(*) FROM " + meta.getTableExpression() + whereSuffix(where);
        return dmlRepository.count(sql, where.getParams());
    }

    /** 按分组字段统计条数与金额合计。 */
    public List<Map<String, Object>> queryGroupSummary(String schemaCode, FilterExpression filter,
                                                       String groupField) {
        TableMeta meta = metaDataService.resolve(schemaCode);
        SqlFragment where = SqlRenderer.render(meta, filter);
        String groupColumn = meta.columnOf(groupField);
        StringBuilder sql = new StringBuilder("SELECT ")
                .append(groupColumn).append(" AS ").append(groupField)
                .append(", COUNT(*) AS cnt");
        if (meta.getColumns().containsKey("amount")) {
            sql.append(", SUM(").append(meta.columnOf("amount")).append(") AS total_amount");
        }
        sql.append(" FROM ").append(meta.getTableExpression())
                .append(whereSuffix(where))
                .append(" GROUP BY ").append(groupColumn)
                .append(" ORDER BY ").append(groupColumn);
        return dmlRepository.queryGroup(sql.toString(), where.getParams());
    }

    /** 分页查询（执行链最深帧落在 com.corp.meta.PaginSupport）。 */
    public <T> PaginResult<T> queryPage(String schemaCode, FilterExpression filter,
                                        PaginQuery page, Class<T> resultType) {
        TableMeta meta = metaDataService.resolve(schemaCode);
        SqlFragment where = SqlRenderer.render(meta, filter);
        StringBuilder sql = new StringBuilder(selectSql(meta, where));
        if (page != null && page.getOrderBy() != null && !page.getOrderBy().trim().isEmpty()) {
            sql.append(" ORDER BY ").append(orderColumn(meta, page.getOrderBy().trim()));
        }
        return dmlRepository.queryPaged(sql.toString(), where.getParams(),
                new BeanPropertyRowMapper<T>(resultType), page);
    }

    /** 按条件更新。 */
    public int update(String schemaCode, FilterExpression filter, Map<String, Object> values) {
        TableMeta meta = metaDataService.resolve(schemaCode);
        if (values == null || values.isEmpty()) {
            throw new EngineException("更新值为空");
        }
        SqlFragment where = SqlRenderer.render(meta, filter);
        Map<String, Object> params = new LinkedHashMap<String, Object>(where.getParams());
        StringBuilder sql = new StringBuilder("UPDATE ")
                .append(meta.getTableExpression()).append(" SET ");
        int seq = 0;
        boolean first = true;
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            if (!first) {
                sql.append(", ");
            }
            String name = "s" + seq++;
            sql.append(meta.columnOf(entry.getKey())).append(" = :").append(name);
            params.put(name, entry.getValue());
            first = false;
        }
        sql.append(whereSuffix(where));
        return dmlRepository.update(sql.toString(), params);
    }

    /** 按条件删除。 */
    public int delete(String schemaCode, FilterExpression filter) {
        TableMeta meta = metaDataService.resolve(schemaCode);
        SqlFragment where = SqlRenderer.render(meta, filter);
        if (where.getSql() == null || where.getSql().trim().isEmpty()) {
            throw new EngineException("删除条件为空，拒绝全表删除");
        }
        if (!meta.isDeletable()) {
            throw new EngineException("该 schema 为多表视图，不支持删除: " + schemaCode);
        }
        // MySQL 的 DELETE 不接受 DELETE FROM tbl p 形态的表别名，须用 DELETE p FROM tbl p
        String sql = meta.deleteFromClause() + whereSuffix(where);
        return dmlRepository.update(sql, where.getParams());
    }

    /** 已登记的可排序字段（防止 SQL 注入，与真实框架的字段白名单一致）。 */
    public List<String> orderableFields(String schemaCode) {
        return new ArrayList<String>(metaDataService.resolve(schemaCode).getColumns().keySet());
    }

    private String selectSql(TableMeta meta, SqlFragment where) {
        return "SELECT " + meta.selectColumns() + " FROM " + meta.getTableExpression() + whereSuffix(where);
    }

    private String whereSuffix(SqlFragment where) {
        String sql = where == null ? null : where.getSql();
        return (sql == null || sql.trim().isEmpty()) ? "" : " WHERE " + sql;
    }

    private String orderColumn(TableMeta meta, String orderBy) {
        String trimmed = orderBy.trim();
        boolean desc = false;
        String field = trimmed;
        int space = trimmed.lastIndexOf(' ');
        if (space > 0) {
            String tail = trimmed.substring(space + 1).trim();
            if ("desc".equalsIgnoreCase(tail) || "asc".equalsIgnoreCase(tail)) {
                desc = "desc".equalsIgnoreCase(tail);
                field = trimmed.substring(0, space).trim();
            }
        }
        String column = meta.columnOf(field);
        return desc ? column + " DESC" : column;
    }
}
