package cn.song.mybatisplusdemo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自研框架模拟壳：BeanCruder（对齐用户真实项目中 beanCruder 的调用形态）
 * <p>
 * 典型形态：首参实体 Class、第 2 参 SQL 字符串（Java 拼接构造）、其后为命名参数的
 * 名值对序列（paramName1, value1, paramName2, value2, ...）。
 * SQL 预览插件由此覆盖「自研 DAO 层 + 字符串 SQL 实参」场景（调用行 + 所属方法定义行）。
 *
 * @author SongRenShuo
 */
@Component
public class BeanCruder {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询列表：(Class, sql, 名值对...)
     */
    public <T> List<T> selectList(Class<T> classType, String sql, Object... nameValuePairs) {
        Object[] values = nameValues(nameValuePairs);
        return jdbcTemplate.query(sql, values, new BeanPropertyRowMapper<>(classType));
    }

    /**
     * 查询单条：(Class, sql, 名值对...)
     */
    public <T> T selectOne(Class<T> classType, String sql, Object... nameValuePairs) {
        Object[] values = nameValues(nameValuePairs);
        return jdbcTemplate.queryForObject(sql, values, new BeanPropertyRowMapper<>(classType));
    }

    /**
     * 计数：(Class, sql, 名值对...)
     */
    public <T> int selectCount(Class<T> classType, String sql, Object... nameValuePairs) {
        Object[] values = nameValues(nameValuePairs);
        Integer count = jdbcTemplate.queryForObject(sql, values, Integer.class);
        return count == null ? 0 : count;
    }

    /**
     * 更新：(sql, 名值对...)
     */
    public int update(String sql, Object... nameValuePairs) {
        Object[] values = nameValues(nameValuePairs);
        return jdbcTemplate.update(sql, values);
    }

    /**
     * 名值对平铺序列按序抽取值：("CUR_USER", 1L, "STATUS", 0) → [1L, 0]
     */
    private Object[] nameValues(Object[] nameValuePairs) {
        if (nameValuePairs == null || nameValuePairs.length == 0) {
            return new Object[0];
        }
        int count = nameValuePairs.length / 2;
        Object[] values = new Object[count];
        for (int i = 0; i < count; i++) {
            values[i] = nameValuePairs[i * 2 + 1];
        }
        return values;
    }
}
