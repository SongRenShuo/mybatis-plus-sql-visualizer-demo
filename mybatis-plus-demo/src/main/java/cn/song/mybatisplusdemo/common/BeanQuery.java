package cn.song.mybatisplusdemo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * 自研框架模拟壳：BeanQuery（对齐用户真实项目中 beanQuery 的分页委托链形态）
 * <p>
 * 消费形态：{@code beanQuery.selectListPagination(Class, sql, paramMap, index, size)} →
 * 组装 {@link PaginQuery}（{@code query.setQuery(sql)}）→ 委托
 * {@code selectListPagination(PaginQuery, RowMapper)} → {@code query.getQuery()} 取出 SQL
 * 交 JdbcTemplate 执行。SQL 全程以「方法参数 → 对象字段」形态流转，静态不可见，
 * SQL 预览插件由「方法定义锚点」在此类方法名行提供入口。
 *
 * @author SongRenShuo
 */
@Component
public class BeanQuery {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * 分页查询入口：(Class, sql, paramMap, index, size)
     */
    public <T> PaginResult<T> selectListPagination(Class<T> classType, String sql,
                                                   java.util.Map<String, ?> paramMap, int index, int size) {
        if (paramMap == null) {
            paramMap = new java.util.HashMap<>();
        }
        PaginQuery query = new PaginQuery();
        query.setQuery(sql);
        query.setParameterMap(paramMap);
        query.setIndex(index);
        query.setSize(size);
        return selectListPagination(classType, query);
    }

    /**
     * 分页查询委托：(Class, PaginQuery)
     */
    public <T> PaginResult<T> selectListPagination(Class<T> classType, PaginQuery query) {
        return selectListPagination(query, new BeanPropertyRowMapper<>(classType));
    }

    /**
     * 分页查询执行层：query.getQuery() 取出 SQL → JdbcTemplate 执行
     */
    public <T> PaginResult<T> selectListPagination(PaginQuery query, RowMapper<T> rowMapper) {
        String sql = query.getQuery();
        java.util.Map<String, ?> parameterMap = query.getParameterMap();

        PaginResult<T> result = new PaginResult<>();
        if (query.getSize() > 0) {
            String paginationSql = pagination(sql, query.getIndex(), query.getSize());
            result.setDataList(jdbcTemplate.query(paginationSql, parameterMap, rowMapper));
            result.setIndex(query.getIndex());
            result.setSize(query.getSize());
        } else {
            result.setDataList(jdbcTemplate.query(sql, parameterMap, rowMapper));
            result.setIndex(0);
            result.setSize(0);
        }
        if (result.getDataList() == null) {
            result.setDataList(new java.util.ArrayList<>());
        }
        result.setRowCount(result.getDataList().size());
        result.setTotalRowCount(result.getRowCount());
        result.setPageCount(1);
        return result;
    }

    /**
     * 简化分页包装（真实项目按数据库方言选择分页策略）
     */
    private String pagination(String sql, int index, int size) {
        int offset = Math.max(index - 1, 0) * size;
        return sql + " LIMIT " + offset + ", " + size;
    }
}
