package cn.song.mybatisplusdemo.service;

import java.util.List;
import java.util.Map;

/**
 * JdbcTemplate SQL 预览示例服务接口
 * 集中编写各种 JDBC SQL 写法，供 mybatis-plus-sql-visualizer 插件预览 SQL
 *
 * @author SongRenShuo
 */
public interface JdbcTemplateService {

    // ==================== 基础查询 ====================

    /**
     * 1. 基础查询：queryForList + 位置参数(?)
     */
    List<Map<String, Object>> queryForListWithPositionalParams(Integer status, Integer minAge);

    /**
     * 2. 命名参数查询：NamedParameterJdbcTemplate + :paramName
     */
    List<Map<String, Object>> queryForListWithNamedParams(String username, Integer roleId);

    /**
     * 3. 单对象查询：queryForObject
     */
    Map<String, Object> queryForObjectById(Integer id);

    // ==================== 动态 SQL ====================

    /**
     * 4. StringBuilder 动态拼接 SQL（模拟用户示例场景）
     */
    List<Map<String, Object>> dynamicSqlWithStringBuilder(String username, Integer status,
                                                          Integer roleId, Integer deptId);

    /**
     * 5. 动态 SQL：可选条件 + IN 子句
     */
    List<Map<String, Object>> dynamicSqlWithInClause(String keyword, List<Integer> roleIds,
                                                     List<Integer> deptIds);

    // ==================== JOIN 查询 ====================

    /**
     * 6. 多表 JOIN：INNER JOIN + LEFT JOIN
     */
    List<Map<String, Object>> multiTableJoin(Integer status);

    /**
     * 7. 复杂 JOIN：三表联查 + 聚合 + 分页
     */
    List<Map<String, Object>> complexJoinWithAggregation(Integer minAge, Integer pageNum, Integer pageSize);

    // ==================== 子查询 ====================

    /**
     * 8. EXISTS / NOT EXISTS 子查询
     */
    List<Map<String, Object>> subqueryWithExists(Integer status);

    /**
     * 9. IN 子查询
     */
    List<Map<String, Object>> subqueryWithIn();

    // ==================== 分组统计 ====================

    /**
     * 10. GROUP BY + HAVING + ORDER BY
     */
    List<Map<String, Object>> groupByWithHaving(Integer minCount);

    /**
     * 11. CASE WHEN 条件表达式
     */
    List<Map<String, Object>> caseWhenExpression();

    // ==================== 分页查询 ====================

    /**
     * 12. 分页查询：LIMIT + OFFSET
     */
    List<Map<String, Object>> paginationQuery(Integer status, Integer pageNum, Integer pageSize);

    /**
     * 13. 分页 + 总记录数
     */
    Map<String, Object> paginationWithTotalCount(String keyword, Integer pageNum, Integer pageSize);

    // ==================== 增删改操作 ====================

    /**
     * 14. INSERT 插入
     */
    int insertUser(String username, String password, Integer age, Integer roleId);

    /**
     * 15. UPDATE 更新
     */
    int updateUserStatus(Integer id, Integer status);

    /**
     * 16. DELETE 删除
     */
    int deleteUserById(Integer id);

    /**
     * 17. 批量插入：batchUpdate
     */
    int[] batchInsertUsers(List<Map<String, Object>> users);

    // ==================== 复杂业务场景 ====================

    /**
     * 18. 模拟用户示例：复杂动态 SQL + 多条件分支
     */
    List<Map<String, Object>> simulateComplexBusinessQuery(String flowKey, String curUser,
                                                           String curUserTenant, String lotNumber,
                                                           Integer pageNum, Integer pageSize);

    /**
     * 19. 嵌套子查询 + 聚合 + 排序
     */
    List<Map<String, Object>> nestedSubqueryWithAggregation();

    /**
     * 20. UNION 联合查询
     */
    List<Map<String, Object>> unionQuery(String keyword);
}
