package cn.song.mybatisplusdemo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自研框架模拟壳：BeanCruder（对齐用户真实项目中 beanCruder 的调用形态）
 * <p>
 * 典型形态：首参实体 Class、第 2 参 SQL 字符串（Java 拼接构造）、其后为命名参数的
 * 名值对序列（paramName1, value1, paramName2, value2, ...）。
 * SQL 预览插件由此覆盖「自研 DAO 层 + 字符串 SQL 实参」场景（调用行 + 方法定义名行）。
 *
 * @author SongRenShuo
 */
@Component
public class BeanCruder {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * 查询列表：(Class, sql, 名值对...)
     */
    public <T> List<T> selectList(Class<T> classType, String sql, Object... nameValuePairs) {
        Map<String, Object> paramMap = nameValues(nameValuePairs);
        return namedParameterJdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(classType));
    }

    /**
     * 查询单条：(Class, sql, 名值对...)，无记录返回 null
     */
    public <T> T selectOne(Class<T> classType, String sql, Object... nameValuePairs) {
        List<T> rows = selectList(classType, sql, nameValuePairs);
        return rows.isEmpty() ? null : rows.get(0);
    }

    /**
     * 计数：(Class, sql, 名值对...)
     */
    public <T> int selectCount(Class<T> classType, String sql, Object... nameValuePairs) {
        Map<String, Object> paramMap = nameValues(nameValuePairs);
        Integer count = namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        return count == null ? 0 : count;
    }

    /**
     * 更新：(sql, 名值对...)
     */
    public int update(String sql, Object... nameValuePairs) {
        Map<String, Object> paramMap = nameValues(nameValuePairs);
        return namedParameterJdbcTemplate.update(sql, paramMap);
    }

    /**
     * 名值对平铺序列转命名参数 Map：("CUR_USER", 1L, "STATUS", 0) → {CUR_USER=1L, STATUS=0}
     */
    private Map<String, Object> nameValues(Object[] nameValuePairs) {
        Map<String, Object> paramMap = new HashMap<>();
        if (nameValuePairs == null || nameValuePairs.length == 0) {
            return paramMap;
        }
        int count = nameValuePairs.length / 2;
        for (int i = 0; i < count; i++) {
            paramMap.put(String.valueOf(nameValuePairs[i * 2]), nameValuePairs[i * 2 + 1]);
        }
        return paramMap;
    }
}
