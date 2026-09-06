package cn.song.mybatisplusdemo.service.impl;

import cn.song.mybatisplusdemo.service.JdbcTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JdbcTemplate SQL 预览示例服务实现类
 * 集中编写各种 JDBC SQL 写法，供 mybatis-plus-sql-visualizer 插件预览 SQL
 *
 * @author SongRenShuo
 */
@Service("jdbcTemplateService")
public class JdbcTemplateServiceImpl implements JdbcTemplateService {

    private static final Logger log = LoggerFactory.getLogger(JdbcTemplateServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // ==================== 基础查询 ====================

    /**
     * 1. 基础查询：queryForList + 位置参数(?)
     * 演示最基础的 JdbcTemplate 用法，使用 ? 占位符
     */
    @Override
    public List<Map<String, Object>> queryForListWithPositionalParams(Integer status, Integer minAge) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, username, age, email, role_id, status, create_time ");
        sql.append("FROM user ");
        sql.append("WHERE 1 = 1 ");

        List<Object> params = new ArrayList<>();
        if (status != null) {
            sql.append("AND status = ? ");
            params.add(status);
        }
        if (minAge != null) {
            sql.append("AND age >= ? ");
            params.add(minAge);
        }
        sql.append("ORDER BY id DESC");

        log.info("[JdbcTemplate] 基础查询 SQL: {}", sql);
        return jdbcTemplate.queryForList(sql.toString(), params.toArray());
    }

    /**
     * 2. 命名参数查询：NamedParameterJdbcTemplate + :paramName
     * 使用 Map 传递命名参数，语义更清晰
     */
    @Override
    public List<Map<String, Object>> queryForListWithNamedParams(String username, Integer roleId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, username, age, email, role_id, status ");
        sql.append("FROM user ");
        sql.append("WHERE 1 = 1 ");

        Map<String, Object> paramMap = new HashMap<>();
        if (StringUtils.hasText(username)) {
            sql.append("AND username LIKE :username ");
            paramMap.put("username", "%" + username + "%");
        }
        if (roleId != null) {
            sql.append("AND role_id = :roleId ");
            paramMap.put("roleId", roleId);
        }
        sql.append("ORDER BY id ASC");

        log.info("[JdbcTemplate] 命名参数查询 SQL: {}", sql);
        return namedParameterJdbcTemplate.queryForList(sql.toString(), paramMap);
    }

    /**
     * 3. 单对象查询：queryForObject
     * 查询单条记录，结果映射为 Map
     */
    @Override
    public Map<String, Object> queryForObjectById(Integer id) {
        String sql = "SELECT id, username, age, email, role_id, dept_id, status, create_time " +
                "FROM user WHERE id = ?";

        log.info("[JdbcTemplate] 单对象查询 SQL: {}", sql);
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Map<String, Object> row = new HashMap<>();
            row.put("id", rs.getInt("id"));
            row.put("username", rs.getString("username"));
            row.put("age", rs.getInt("age"));
            row.put("email", rs.getString("email"));
            row.put("role_id", rs.getInt("role_id"));
            row.put("dept_id", rs.getInt("dept_id"));
            row.put("status", rs.getInt("status"));
            row.put("create_time", rs.getTimestamp("create_time"));
            return row;
        }, id);
    }

    // ==================== 动态 SQL ====================

    /**
     * 4. StringBuilder 动态拼接 SQL（模拟用户示例场景）
     * 根据条件动态组装 WHERE 子句
     */
    @Override
    public List<Map<String, Object>> dynamicSqlWithStringBuilder(String username, Integer status,
                                                                  Integer roleId, Integer deptId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT u.id, u.username, u.age, u.email, u.status, ");
        sql.append("       r.name AS role_name, d.name AS dept_name ");
        sql.append("FROM user u ");
        sql.append("LEFT JOIN role r ON u.role_id = r.id ");
        sql.append("LEFT JOIN department d ON u.dept_id = d.id ");
        sql.append("WHERE u.deleted = 0 ");

        if (StringUtils.hasText(username)) {
            sql.append("AND u.username LIKE '%").append(username).append("%' ");
        }
        if (status != null) {
            sql.append("AND u.status = ").append(status).append(" ");
        }
        if (roleId != null) {
            sql.append("AND u.role_id = ").append(roleId).append(" ");
        }
        if (deptId != null) {
            sql.append("AND u.dept_id = ").append(deptId).append(" ");
        }
        sql.append("ORDER BY u.id DESC");

        log.info("[JdbcTemplate] 动态拼接 SQL: {}", sql);
        return jdbcTemplate.queryForList(sql.toString());
    }

    /**
     * 5. 动态 SQL：可选条件 + IN 子句
     * 使用 NamedParameterJdbcTemplate 处理 IN 子句
     */
    @Override
    public List<Map<String, Object>> dynamicSqlWithInClause(String keyword, List<Integer> roleIds,
                                                             List<Integer> deptIds) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, username, age, role_id, dept_id, status ");
        sql.append("FROM user ");
        sql.append("WHERE deleted = 0 ");

        Map<String, Object> paramMap = new HashMap<>();
        if (StringUtils.hasText(keyword)) {
            sql.append("AND (username LIKE :keyword OR email LIKE :keyword) ");
            paramMap.put("keyword", "%" + keyword + "%");
        }
        if (roleIds != null && !roleIds.isEmpty()) {
            sql.append("AND role_id IN (:roleIds) ");
            paramMap.put("roleIds", roleIds);
        }
        if (deptIds != null && !deptIds.isEmpty()) {
            sql.append("AND dept_id IN (:deptIds) ");
            paramMap.put("deptIds", deptIds);
        }
        sql.append("ORDER BY create_time DESC");

        log.info("[JdbcTemplate] 动态 IN 子句 SQL: {}", sql);
        return namedParameterJdbcTemplate.queryForList(sql.toString(), paramMap);
    }

    // ==================== JOIN 查询 ====================

    /**
     * 6. 多表 JOIN：INNER JOIN + LEFT JOIN
     * 用户表关联角色表和部门表
     */
    @Override
    public List<Map<String, Object>> multiTableJoin(Integer status) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  u.id, u.username, u.age, u.email, ");
        sql.append("  r.name AS role_name, r.code AS role_code, ");
        sql.append("  d.name AS dept_name, d.code AS dept_code ");
        sql.append("FROM user u ");
        sql.append("INNER JOIN role r ON u.role_id = r.id ");
        sql.append("LEFT JOIN department d ON u.dept_id = d.id ");
        sql.append("WHERE u.deleted = 0 ");

        List<Object> params = new ArrayList<>();
        if (status != null) {
            sql.append("AND u.status = ? ");
            params.add(status);
        }
        sql.append("ORDER BY u.id ASC");

        log.info("[JdbcTemplate] 多表 JOIN SQL: {}", sql);
        return jdbcTemplate.queryForList(sql.toString(), params.toArray());
    }

    /**
     * 7. 复杂 JOIN：三表联查 + 聚合 + 分页
     * 用户 + 角色 + 订单，统计每个用户的订单总金额
     */
    @Override
    public List<Map<String, Object>> complexJoinWithAggregation(Integer minAge, Integer pageNum, Integer pageSize) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  u.id, u.username, u.age, ");
        sql.append("  r.name AS role_name, ");
        sql.append("  COUNT(o.id) AS order_count, ");
        sql.append("  IFNULL(SUM(o.amount), 0) AS total_amount, ");
        sql.append("  MAX(o.create_time) AS last_order_time ");
        sql.append("FROM user u ");
        sql.append("INNER JOIN role r ON u.role_id = r.id ");
        sql.append("LEFT JOIN t_order o ON u.id = o.user_id ");
        sql.append("WHERE u.deleted = 0 ");

        List<Object> params = new ArrayList<>();
        if (minAge != null) {
            sql.append("AND u.age >= ? ");
            params.add(minAge);
        }
        sql.append("GROUP BY u.id, u.username, u.age, r.name ");
        sql.append("ORDER BY total_amount DESC ");
        sql.append("LIMIT ? OFFSET ? ");
        params.add(pageSize);
        params.add((pageNum - 1) * pageSize);

        log.info("[JdbcTemplate] 复杂 JOIN + 聚合 SQL: {}", sql);
        return jdbcTemplate.queryForList(sql.toString(), params.toArray());
    }

    // ==================== 子查询 ====================

    /**
     * 8. EXISTS / NOT EXISTS 子查询
     * 查询有订单的用户 / 没有订单的用户
     */
    @Override
    public List<Map<String, Object>> subqueryWithExists(Integer status) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT u.id, u.username, u.age, u.email ");
        sql.append("FROM user u ");
        sql.append("WHERE u.deleted = 0 ");
        sql.append("AND EXISTS ( ");
        sql.append("  SELECT 1 FROM t_order o WHERE o.user_id = u.id ");
        sql.append(") ");
        sql.append("AND NOT EXISTS ( ");
        sql.append("  SELECT 1 FROM t_order o2 ");
        sql.append("  WHERE o2.user_id = u.id AND o2.status = 2 ");
        sql.append(") ");

        List<Object> params = new ArrayList<>();
        if (status != null) {
            sql.append("AND u.status = ? ");
            params.add(status);
        }
        sql.append("ORDER BY u.id");

        log.info("[JdbcTemplate] EXISTS 子查询 SQL: {}", sql);
        return jdbcTemplate.queryForList(sql.toString(), params.toArray());
    }

    /**
     * 9. IN 子查询
     * 查询订单金额大于平均金额的用户
     */
    @Override
    public List<Map<String, Object>> subqueryWithIn() {
        String sql = "SELECT u.id, u.username, u.age, u.email, u.role_id " +
                "FROM user u " +
                "WHERE u.deleted = 0 " +
                "AND u.id IN ( " +
                "  SELECT o.user_id " +
                "  FROM t_order o " +
                "  WHERE o.amount > (SELECT AVG(amount) FROM t_order WHERE status = 1) " +
                "  AND o.status = 1 " +
                ") " +
                "ORDER BY u.id DESC";

        log.info("[JdbcTemplate] IN 子查询 SQL: {}", sql);
        return jdbcTemplate.queryForList(sql);
    }

    // ==================== 分组统计 ====================

    /**
     * 10. GROUP BY + HAVING + ORDER BY
     * 按角色分组统计用户数量
     */
    @Override
    public List<Map<String, Object>> groupByWithHaving(Integer minCount) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  r.id AS role_id, ");
        sql.append("  r.name AS role_name, ");
        sql.append("  COUNT(u.id) AS user_count, ");
        sql.append("  AVG(u.age) AS avg_age, ");
        sql.append("  MAX(u.age) AS max_age, ");
        sql.append("  MIN(u.age) AS min_age ");
        sql.append("FROM role r ");
        sql.append("LEFT JOIN user u ON r.id = u.role_id AND u.deleted = 0 ");
        sql.append("GROUP BY r.id, r.name ");

        List<Object> params = new ArrayList<>();
        if (minCount != null) {
            sql.append("HAVING COUNT(u.id) >= ? ");
            params.add(minCount);
        }
        sql.append("ORDER BY user_count DESC");

        log.info("[JdbcTemplate] GROUP BY + HAVING SQL: {}", sql);
        return jdbcTemplate.queryForList(sql.toString(), params.toArray());
    }

    /**
     * 11. CASE WHEN 条件表达式
     * 使用 CASE WHEN 进行条件分类
     */
    @Override
    public List<Map<String, Object>> caseWhenExpression() {
        String sql = "SELECT " +
                "  id, username, age, status, " +
                "  CASE " +
                "    WHEN age < 18 THEN '未成年' " +
                "    WHEN age BETWEEN 18 AND 30 THEN '青年' " +
                "    WHEN age BETWEEN 31 AND 50 THEN '中年' " +
                "    ELSE '老年' " +
                "  END AS age_group, " +
                "  CASE status " +
                "    WHEN 0 THEN '禁用' " +
                "    WHEN 1 THEN '启用' " +
                "    ELSE '未知' " +
                "  END AS status_name, " +
                "  IFNULL(email, '未填写') AS email_display " +
                "FROM user " +
                "WHERE deleted = 0 " +
                "ORDER BY age DESC";

        log.info("[JdbcTemplate] CASE WHEN SQL: {}", sql);
        return jdbcTemplate.queryForList(sql);
    }

    // ==================== 分页查询 ====================

    /**
     * 12. 分页查询：LIMIT + OFFSET
     */
    @Override
    public List<Map<String, Object>> paginationQuery(Integer status, Integer pageNum, Integer pageSize) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, username, age, email, role_id, status, create_time ");
        sql.append("FROM user ");
        sql.append("WHERE deleted = 0 ");

        List<Object> params = new ArrayList<>();
        if (status != null) {
            sql.append("AND status = ? ");
            params.add(status);
        }
        sql.append("ORDER BY id DESC ");
        sql.append("LIMIT ? OFFSET ? ");
        params.add(pageSize);
        params.add((pageNum - 1) * pageSize);

        log.info("[JdbcTemplate] 分页查询 SQL: {}", sql);
        return jdbcTemplate.queryForList(sql.toString(), params.toArray());
    }

    /**
     * 13. 分页 + 总记录数
     * 返回分页数据和总记录数
     */
    @Override
    public Map<String, Object> paginationWithTotalCount(String keyword, Integer pageNum, Integer pageSize) {
        StringBuilder whereSql = new StringBuilder();
        whereSql.append("WHERE deleted = 0 ");

        List<Object> params = new ArrayList<>();
        if (StringUtils.hasText(keyword)) {
            whereSql.append("AND (username LIKE ? OR email LIKE ?) ");
            params.add("%" + keyword + "%");
            params.add("%" + keyword + "%");
        }

        // 查询总记录数
        String countSql = "SELECT COUNT(*) FROM user " + whereSql;
        log.info("[JdbcTemplate] 分页总数 SQL: {}", countSql);
        Integer total = jdbcTemplate.queryForObject(countSql, Integer.class, params.toArray());

        // 查询分页数据
        StringBuilder dataSql = new StringBuilder();
        dataSql.append("SELECT id, username, age, email, role_id, status, create_time ");
        dataSql.append("FROM user ");
        dataSql.append(whereSql);
        dataSql.append("ORDER BY id DESC ");
        dataSql.append("LIMIT ? OFFSET ? ");
        params.add(pageSize);
        params.add((pageNum - 1) * pageSize);

        log.info("[JdbcTemplate] 分页数据 SQL: {}", dataSql);
        List<Map<String, Object>> dataList = jdbcTemplate.queryForList(dataSql.toString(), params.toArray());

        Map<String, Object> result = new HashMap<>();
        result.put("total", total);
        result.put("pageNum", pageNum);
        result.put("pageSize", pageSize);
        result.put("dataList", dataList);
        return result;
    }

    // ==================== 增删改操作 ====================

    /**
     * 14. INSERT 插入
     */
    @Override
    public int insertUser(String username, String password, Integer age, Integer roleId) {
        String sql = "INSERT INTO user (username, password, age, role_id, status, create_time, update_time, deleted, version) " +
                "VALUES (?, ?, ?, ?, 1, NOW(), NOW(), 0, 0)";

        log.info("[JdbcTemplate] INSERT SQL: {}", sql);
        return jdbcTemplate.update(sql, username, password, age, roleId);
    }

    /**
     * 15. UPDATE 更新
     */
    @Override
    public int updateUserStatus(Integer id, Integer status) {
        String sql = "UPDATE user SET status = ?, update_time = NOW() WHERE id = ? AND deleted = 0";

        log.info("[JdbcTemplate] UPDATE SQL: {}", sql);
        return jdbcTemplate.update(sql, status, id);
    }

    /**
     * 16. DELETE 删除
     */
    @Override
    public int deleteUserById(Integer id) {
        String sql = "UPDATE user SET deleted = 1, update_time = NOW() WHERE id = ?";

        log.info("[JdbcTemplate] DELETE (逻辑删除) SQL: {}", sql);
        return jdbcTemplate.update(sql, id);
    }

    /**
     * 17. 批量插入：batchUpdate + BatchPreparedStatementSetter
     */
    @Override
    public int[] batchInsertUsers(List<Map<String, Object>> users) {
        String sql = "INSERT INTO user (username, password, age, role_id, status, create_time, update_time, deleted, version) " +
                "VALUES (?, ?, ?, ?, 1, NOW(), NOW(), 0, 0)";

        log.info("[JdbcTemplate] 批量插入 SQL: {}", sql);
        return jdbcTemplate.batchUpdate(sql, new org.springframework.jdbc.core.BatchPreparedStatementSetter() {
            @Override
            public void setValues(java.sql.PreparedStatement ps, int i) throws java.sql.SQLException {
                Map<String, Object> row = users.get(i);
                ps.setString(1, (String) row.get("username"));
                ps.setString(2, (String) row.get("password"));
                ps.setInt(3, (Integer) row.get("age"));
                ps.setInt(4, (Integer) row.get("roleId"));
            }

            @Override
            public int getBatchSize() {
                return users.size();
            }
        });
    }

    // ==================== 复杂业务场景 ====================

    /**
     * 18. 模拟用户示例：复杂动态 SQL + 多条件分支
     * 模拟实际业务中复杂的动态 SQL 拼接场景
     */
    @Override
    public List<Map<String, Object>> simulateComplexBusinessQuery(String flowKey, String curUser,
                                                                   String curUserTenant, String lotNumber,
                                                                   Integer pageNum, Integer pageSize) {
        StringBuilder sql = new StringBuilder();
        String querySelect = "SELECT " +
                "  u.id AS user_id, " +
                "  u.username, " +
                "  u.age, " +
                "  u.email, " +
                "  r.name AS role_name, " +
                "  d.name AS dept_name, " +
                "  COUNT(o.id) AS order_count, " +
                "  IFNULL(SUM(o.amount), 0) AS total_amount " +
                "FROM user u " +
                "INNER JOIN role r ON u.role_id = r.id " +
                "LEFT JOIN department d ON u.dept_id = d.id " +
                "LEFT JOIN t_order o ON u.id = o.user_id ";

        String changeTable = "LEFT JOIN (SELECT user_id, COUNT(*) AS cnt FROM t_order GROUP BY user_id) oc ON u.id = oc.user_id ";

        String queryWhere = "WHERE u.deleted = 0 " +
                "  AND u.status = :status " +
                "  AND ( " +
                "    (:flowKey = 'ALL') " +
                "    OR (:flowKey = 'HAS_ORDER' AND o.id IS NOT NULL) " +
                "    OR (:flowKey = 'NO_ORDER' AND o.id IS NULL) " +
                "  ) ";

        String changeWhere = "AND oc.cnt = :lotNumber ";

        String groupSql = "GROUP BY u.id, u.username, u.age, u.email, r.name, d.name ";

        String orderSql = "ORDER BY u.total_amount DESC ";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("status", 1);
        paramMap.put("flowKey", flowKey);

        if (StringUtils.hasText(lotNumber)) {
            sql.append(querySelect).append(changeTable).append(queryWhere).append(changeWhere).append(groupSql).append(orderSql);
            paramMap.put("lotNumber", Integer.parseInt(lotNumber));
        } else {
            sql.append(querySelect).append(queryWhere).append(groupSql).append(orderSql);
        }

        sql.append("LIMIT :limit OFFSET :offset ");
        paramMap.put("limit", pageSize);
        paramMap.put("offset", (pageNum - 1) * pageSize);

        log.info("[JdbcTemplate] 复杂业务 SQL: {}", sql);
        return namedParameterJdbcTemplate.queryForList(sql.toString(), paramMap);
    }

    /**
     * 19. 嵌套子查询 + 聚合 + 排序
     * 查询每个部门中年龄最大的用户
     */
    @Override
    public List<Map<String, Object>> nestedSubqueryWithAggregation() {
        String sql = "SELECT " +
                "  d.id AS dept_id, " +
                "  d.name AS dept_name, " +
                "  u.id AS user_id, " +
                "  u.username, " +
                "  u.age, " +
                "  u.email, " +
                "  sub.max_age " +
                "FROM department d " +
                "INNER JOIN ( " +
                "  SELECT " +
                "    dept_id, " +
                "    MAX(age) AS max_age " +
                "  FROM user " +
                "  WHERE deleted = 0 AND dept_id IS NOT NULL " +
                "  GROUP BY dept_id " +
                ") sub ON d.id = sub.dept_id " +
                "INNER JOIN user u ON u.dept_id = d.id AND u.age = sub.max_age AND u.deleted = 0 " +
                "ORDER BY d.id ASC";

        log.info("[JdbcTemplate] 嵌套子查询 SQL: {}", sql);
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 20. UNION 联合查询
     * 合并用户和角色的名称列表
     */
    @Override
    public List<Map<String, Object>> unionQuery(String keyword) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT 'user' AS source, id, username AS name, email, create_time ");
        sql.append("FROM user ");
        sql.append("WHERE deleted = 0 ");

        Map<String, Object> paramMap = new HashMap<>();
        if (StringUtils.hasText(keyword)) {
            sql.append("AND username LIKE :keyword ");
            paramMap.put("keyword", "%" + keyword + "%");
        }

        sql.append("UNION ALL ");

        sql.append("SELECT 'role' AS source, id, name, code AS email, NULL AS create_time ");
        sql.append("FROM role ");
        sql.append("WHERE 1 = 1 ");

        if (StringUtils.hasText(keyword)) {
            sql.append("AND name LIKE :keyword2 ");
            paramMap.put("keyword2", "%" + keyword + "%");
        }

        sql.append("ORDER BY source, id");

        log.info("[JdbcTemplate] UNION 联合查询 SQL: {}", sql);
        return namedParameterJdbcTemplate.queryForList(sql.toString(), paramMap);
    }
}
