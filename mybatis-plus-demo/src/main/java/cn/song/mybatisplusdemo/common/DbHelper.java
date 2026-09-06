package cn.song.mybatisplusdemo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 数据库操作工具类（封装 JdbcTemplate）
 * 模拟实际项目中团队自研的 DB 工具层，SQL 定义在此处而非 Service 直接调用 JdbcTemplate
 *
 * @author SongRenShuo
 */
@Component
public class DbHelper {

    private static final Logger log = LoggerFactory.getLogger(DbHelper.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * 查询列表（命名参数）
     */
    public List<Map<String, Object>> queryForList(String sql, Map<String, Object> paramMap) {
        log.info("[DbHelper] queryForList SQL: {}", sql);
        return namedParameterJdbcTemplate.queryForList(sql, paramMap);
    }

    /**
     * 查询列表（位置参数）
     */
    public List<Map<String, Object>> queryForList(String sql, Object... args) {
        log.info("[DbHelper] queryForList SQL: {}", sql);
        return jdbcTemplate.queryForList(sql, args);
    }

    /**
     * 查询单条记录
     */
    public Map<String, Object> queryForMap(String sql, Map<String, Object> paramMap) {
        log.info("[DbHelper] queryForMap SQL: {}", sql);
        return namedParameterJdbcTemplate.queryForMap(sql, paramMap);
    }

    /**
     * 查询单条记录（位置参数）
     */
    public Map<String, Object> queryForMap(String sql, Object... args) {
        log.info("[DbHelper] queryForMap SQL: {}", sql);
        return jdbcTemplate.queryForMap(sql, args);
    }

    /**
     * 插入操作
     */
    public int insert(String sql, Map<String, Object> paramMap) {
        log.info("[DbHelper] insert SQL: {}", sql);
        return namedParameterJdbcTemplate.update(sql, paramMap);
    }

    /**
     * 更新操作
     */
    public int update(String sql, Map<String, Object> paramMap) {
        log.info("[DbHelper] update SQL: {}", sql);
        return namedParameterJdbcTemplate.update(sql, paramMap);
    }

    /**
     * 删除操作
     */
    public int delete(String sql, Map<String, Object> paramMap) {
        log.info("[DbHelper] delete SQL: {}", sql);
        return namedParameterJdbcTemplate.update(sql, paramMap);
    }

    /**
     * 批量执行
     */
    public int[] batchUpdate(String sql, List<Object[]> batchArgs) {
        log.info("[DbHelper] batchUpdate SQL: {}", sql);
        return jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    /**
     * 查询总数
     */
    public int queryForInt(String sql, Map<String, Object> paramMap) {
        log.info("[DbHelper] queryForInt SQL: {}", sql);
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }
}
