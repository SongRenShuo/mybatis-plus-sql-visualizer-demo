package com.corp.meta;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * 自研框架分页支撑：包一层总数查询 + 分页查询并组装 {@link PaginResult}。
 *
 * <p>本类是引擎执行链的**最深层**（普通路径最深层在 {@code com.corp.engine.DmlRepository}），
 * 因此分页场景要落到业务帧，帧过滤前缀必须同时覆盖 {@code com.corp.engine.} 与 {@code com.corp.meta.} 两个包根——
 * 这是「前缀需覆盖整条引擎链」的可复现证据。
 *
 * @author SongRenShuo
 */
public final class PaginSupport {

    private PaginSupport() {
    }

    /**
     * 分页执行：baseSql 已含 SELECT / FROM / WHERE / ORDER BY，本方法负责总数与 LIMIT 包装。
     */
    public static <T> PaginResult<T> wrapAndQuery(NamedParameterJdbcTemplate template, String baseSql,
                                                  Map<String, Object> params, RowMapper<T> rowMapper,
                                                  PaginQuery page) {
        PaginResult<T> result = new PaginResult<T>();
        if (page == null || page.getSize() <= 0) {
            List<T> all = template.query(baseSql, params, rowMapper);
            result.setDataList(all);
            result.setIndex(0);
            result.setSize(0);
            result.setRowCount(all.size());
            result.setTotalRowCount(all.size());
            result.setPageCount(1);
            return result;
        }

        Long total = template.queryForObject(
                "SELECT COUNT(*) FROM (" + baseSql + ") cnt", params, Long.class);
        long totalRowCount = total == null ? 0L : total;

        String pagedSql = baseSql + " LIMIT " + page.offset() + ", " + page.getSize();
        List<T> rows = template.query(pagedSql, params, rowMapper);

        result.setDataList(rows);
        result.setIndex(page.getIndex());
        result.setSize(page.getSize());
        result.setRowCount(rows.size());
        result.setTotalRowCount(totalRowCount);
        result.setPageCount(page.getSize() <= 0 ? 1
                : (totalRowCount + page.getSize() - 1) / page.getSize());
        return result;
    }
}
