package cn.song.mybatisplusdemo.service.impl;

import cn.song.mybatisplusdemo.common.DbHelper;
import cn.song.mybatisplusdemo.service.WrappedJdbcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装工具类的 JDBC SQL 预览示例服务实现类
 * 演示 SQL 不直接调用 JdbcTemplate，而是通过 DbHelper 封装层执行
 * 模拟实际项目中团队自研 DB 工具类的场景
 *
 * @author SongRenShuo
 */
@Service("wrappedJdbcService")
public class WrappedJdbcServiceImpl implements WrappedJdbcService {


    @Autowired
    private DbHelper dbHelper;

    // ==================== 基础查询 ====================

    /**
     * 1. 通过 DbHelper 查询列表（命名参数）
     * SQL 在 Service 中定义，通过 DbHelper 执行
     */
    @Override
    public List<Map<String, Object>> queryUserByDbHelper(String username, Integer status) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, username, age, email, role_id, status, create_time ");
        sql.append("FROM user ");
        sql.append("WHERE deleted = 0 ");

        Map<String, Object> paramMap = new HashMap<>();
        if (StringUtils.hasText(username)) {
            sql.append("AND username LIKE :username ");
            paramMap.put("username", "%" + username + "%");
        }
        if (status != null) {
            sql.append("AND status = :status ");
            paramMap.put("status", status);
        }
        sql.append("ORDER BY id DESC");

        return dbHelper.queryForList(sql.toString(), paramMap);
    }

    /**
     * 2. 通过 DbHelper 查询单条
     */
    @Override
    public Map<String, Object> queryOneUserByDbHelper(Integer id) {
        String sql = "SELECT id, username, age, email, role_id, dept_id, status, create_time " +
                "FROM user WHERE id = :id AND deleted = 0";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);

        return dbHelper.queryForMap(sql, paramMap);
    }

    /**
     * 3. 通过 DbHelper 动态 SQL 查询
     * 多条件动态拼接 + IN 子句
     */
    @Override
    public List<Map<String, Object>> dynamicQueryByDbHelper(String keyword, List<Integer> roleIds) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT u.id, u.username, u.age, u.email, r.name AS role_name ");
        sql.append("FROM user u ");
        sql.append("LEFT JOIN role r ON u.role_id = r.id ");
        sql.append("WHERE u.deleted = 0 ");

        Map<String, Object> paramMap = new HashMap<>();
        if (StringUtils.hasText(keyword)) {
            sql.append("AND (u.username LIKE :keyword OR u.email LIKE :keyword) ");
            paramMap.put("keyword", "%" + keyword + "%");
        }
        if (roleIds != null && !roleIds.isEmpty()) {
            sql.append("AND u.role_id IN (:roleIds) ");
            paramMap.put("roleIds", roleIds);
        }
        sql.append("ORDER BY u.id DESC");

        return dbHelper.queryForList(sql.toString(), paramMap);
    }

    // ==================== 分页查询 ====================

    /**
     * 4. 通过 DbHelper 分页查询
     * 包含总数查询 + 分页数据查询
     */
    @Override
    public Map<String, Object> paginationByDbHelper(String keyword, Integer pageNum, Integer pageSize) {
        StringBuilder whereSql = new StringBuilder();
        whereSql.append("WHERE deleted = 0 ");

        Map<String, Object> paramMap = new HashMap<>();
        if (StringUtils.hasText(keyword)) {
            whereSql.append("AND (username LIKE :keyword OR email LIKE :keyword) ");
            paramMap.put("keyword", "%" + keyword + "%");
        }

        // 查询总数
        String countSql = "SELECT COUNT(*) FROM user " + whereSql;
        int total = dbHelper.queryForInt(countSql, paramMap);

        // 查询分页数据
        StringBuilder dataSql = new StringBuilder();
        dataSql.append("SELECT id, username, age, email, role_id, status, create_time ");
        dataSql.append("FROM user ");
        dataSql.append(whereSql);
        dataSql.append("ORDER BY id DESC ");
        dataSql.append("LIMIT :limit OFFSET :offset ");
        paramMap.put("limit", pageSize);
        paramMap.put("offset", (pageNum - 1) * pageSize);

        List<Map<String, Object>> dataList = dbHelper.queryForList(dataSql.toString(), paramMap);

        Map<String, Object> result = new HashMap<>();
        result.put("total", total);
        result.put("pageNum", pageNum);
        result.put("pageSize", pageSize);
        result.put("dataList", dataList);
        return result;
    }

    // ==================== 增删改操作 ====================

    /**
     * 5. 通过 DbHelper 插入
     */
    @Override
    public int insertByDbHelper(String username, String password, Integer age, Integer roleId) {
        String sql = "INSERT INTO user (username, password, age, role_id, status, create_time, update_time, deleted, version) " +
                "VALUES (:username, :password, :age, :roleId, 1, NOW(), NOW(), 0, 0)";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        paramMap.put("password", password);
        paramMap.put("age", age);
        paramMap.put("roleId", roleId);

        return dbHelper.insert(sql, paramMap);
    }

    /**
     * 6. 通过 DbHelper 更新
     */
    @Override
    public int updateByDbHelper(Integer id, String email, Integer status) {
        String sql = "UPDATE user SET email = :email, status = :status, update_time = NOW() " +
                "WHERE id = :id AND deleted = 0";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("email", email);
        paramMap.put("status", status);

        return dbHelper.update(sql, paramMap);
    }

    /**
     * 7. 通过 DbHelper 删除（逻辑删除）
     */
    @Override
    public int deleteByDbHelper(Integer id) {
        String sql = "UPDATE user SET deleted = 1, update_time = NOW() WHERE id = :id";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);

        return dbHelper.delete(sql, paramMap);
    }

    /**
     * 8. 通过 DbHelper 批量插入
     */
    @Override
    public int[] batchInsertByDbHelper(List<List<Object>> users) {
        String sql = "INSERT INTO user (username, password, age, role_id, status, create_time, update_time, deleted, version) " +
                "VALUES (?, ?, ?, ?, 1, NOW(), NOW(), 0, 0)";

        List<Object[]> batchArgs = new ArrayList<>();
        for (List<Object> user : users) {
            batchArgs.add(user.toArray());
        }

        return dbHelper.batchUpdate(sql, batchArgs);
    }

    // ==================== 复杂查询 ====================

    /**
     * 9. 通过 DbHelper 复杂 JOIN 查询
     * 三表联查 + 聚合函数
     */
    @Override
    public List<Map<String, Object>> complexJoinByDbHelper(Integer minAge) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  u.id, u.username, u.age, ");
        sql.append("  r.name AS role_name, ");
        sql.append("  d.name AS dept_name, ");
        sql.append("  COUNT(o.id) AS order_count, ");
        sql.append("  IFNULL(SUM(o.amount), 0) AS total_amount ");
        sql.append("FROM user u ");
        sql.append("INNER JOIN role r ON u.role_id = r.id ");
        sql.append("LEFT JOIN department d ON u.dept_id = d.id ");
        sql.append("LEFT JOIN t_order o ON u.id = o.user_id ");
        sql.append("WHERE u.deleted = 0 ");

        Map<String, Object> paramMap = new HashMap<>();
        if (minAge != null) {
            sql.append("AND u.age >= :minAge ");
            paramMap.put("minAge", minAge);
        }
        sql.append("GROUP BY u.id, u.username, u.age, r.name, d.name ");
        sql.append("ORDER BY total_amount DESC");

        return dbHelper.queryForList(sql.toString(), paramMap);
    }

    /**
     * 10. 通过 DbHelper 分组统计
     * GROUP BY + HAVING + CASE WHEN
     */
    @Override
    public List<Map<String, Object>> groupByByDbHelper() {
        String sql = "SELECT " +
                "  d.id AS dept_id, " +
                "  d.name AS dept_name, " +
                "  COUNT(u.id) AS user_count, " +
                "  AVG(u.age) AS avg_age, " +
                "  SUM(CASE WHEN u.status = 1 THEN 1 ELSE 0 END) AS active_count, " +
                "  SUM(CASE WHEN u.status = 0 THEN 1 ELSE 0 END) AS inactive_count " +
                "FROM department d " +
                "LEFT JOIN user u ON d.id = u.dept_id AND u.deleted = 0 " +
                "GROUP BY d.id, d.name " +
                "HAVING COUNT(u.id) > 0 " +
                "ORDER BY user_count DESC";

        return dbHelper.queryForList(sql, new HashMap<>());
    }
}
