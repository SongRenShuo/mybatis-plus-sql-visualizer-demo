package cn.song.mybatisplusdemo.controller;

import cn.song.mybatisplusdemo.service.JdbcTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * JdbcTemplate SQL 预览示例控制器
 * 提供接口触发各种 JDBC SQL 写法，供插件预览
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/jdbc")
public class JdbcTemplateController {

    @Autowired
    private JdbcTemplateService jdbcTemplateService;

    // ==================== 基础查询 ====================

    /**
     * 1. 基础查询：queryForList + 位置参数(?)
     * GET /jdbc/queryForList?status=1&minAge=18
     */
    @GetMapping("/queryForList")
    public List<Map<String, Object>> queryForListWithPositionalParams(@RequestParam(required = false) Integer status,
                                                                      @RequestParam(required = false) Integer minAge) {
        return jdbcTemplateService.queryForListWithPositionalParams(status, minAge);
    }

    /**
     * 2. 命名参数查询：NamedParameterJdbcTemplate + :paramName
     * GET /jdbc/queryForListNamed?username=admin&roleId=1
     */
    @GetMapping("/queryForListNamed")
    public List<Map<String, Object>> queryForListWithNamedParams(@RequestParam(required = false) String username,
                                                                 @RequestParam(required = false) Integer roleId) {
        return jdbcTemplateService.queryForListWithNamedParams(username, roleId);
    }

    /**
     * 3. 单对象查询：queryForObject
     * GET /jdbc/queryForObject/1
     */
    @GetMapping("/queryForObject/{id}")
    public Map<String, Object> queryForObjectById(@PathVariable Integer id) {
        return jdbcTemplateService.queryForObjectById(id);
    }

    // ==================== 动态 SQL ====================

    /**
     * 4. StringBuilder 动态拼接 SQL
     * GET /jdbc/dynamicSql?username=admin&status=1&roleId=1&deptId=1
     */
    @GetMapping("/dynamicSql")
    public List<Map<String, Object>> dynamicSqlWithStringBuilder(@RequestParam(required = false) String username,
                                                                 @RequestParam(required = false) Integer status,
                                                                 @RequestParam(required = false) Integer roleId,
                                                                 @RequestParam(required = false) Integer deptId) {
        return jdbcTemplateService.dynamicSqlWithStringBuilder(username, status, roleId, deptId);
    }

    /**
     * 5. 动态 SQL：可选条件 + IN 子句
     * GET /jdbc/dynamicIn?keyword=test&roleIds=1,2,3&deptIds=1,2
     */
    @GetMapping("/dynamicIn")
    public List<Map<String, Object>> dynamicSqlWithInClause(@RequestParam(required = false) String keyword,
                                                            @RequestParam(required = false) List<Integer> roleIds,
                                                            @RequestParam(required = false) List<Integer> deptIds) {
        return jdbcTemplateService.dynamicSqlWithInClause(keyword, roleIds, deptIds);
    }

    // ==================== JOIN 查询 ====================

    /**
     * 6. 多表 JOIN：INNER JOIN + LEFT JOIN
     * GET /jdbc/multiJoin?status=1
     */
    @GetMapping("/multiJoin")
    public List<Map<String, Object>> multiTableJoin(@RequestParam(required = false) Integer status) {
        return jdbcTemplateService.multiTableJoin(status);
    }

    /**
     * 7. 复杂 JOIN：三表联查 + 聚合 + 分页
     * GET /jdbc/complexJoin?minAge=18&pageNum=1&pageSize=10
     */
    @GetMapping("/complexJoin")
    public List<Map<String, Object>> complexJoinWithAggregation(@RequestParam(required = false) Integer minAge,
                                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                                @RequestParam(defaultValue = "10") Integer pageSize) {
        return jdbcTemplateService.complexJoinWithAggregation(minAge, pageNum, pageSize);
    }

    // ==================== 子查询 ====================

    /**
     * 8. EXISTS / NOT EXISTS 子查询
     * GET /jdbc/exists?status=1
     */
    @GetMapping("/exists")
    public List<Map<String, Object>> subqueryWithExists(@RequestParam(required = false) Integer status) {
        return jdbcTemplateService.subqueryWithExists(status);
    }

    /**
     * 9. IN 子查询
     * GET /jdbc/inSubquery
     */
    @GetMapping("/inSubquery")
    public List<Map<String, Object>> subqueryWithIn() {
        return jdbcTemplateService.subqueryWithIn();
    }

    // ==================== 分组统计 ====================

    /**
     * 10. GROUP BY + HAVING + ORDER BY
     * GET /jdbc/groupBy?minCount=1
     */
    @GetMapping("/groupBy")
    public List<Map<String, Object>> groupByWithHaving(@RequestParam(required = false) Integer minCount) {
        return jdbcTemplateService.groupByWithHaving(minCount);
    }

    /**
     * 11. CASE WHEN 条件表达式
     * GET /jdbc/caseWhen
     */
    @GetMapping("/caseWhen")
    public List<Map<String, Object>> caseWhenExpression() {
        return jdbcTemplateService.caseWhenExpression();
    }

    // ==================== 分页查询 ====================

    /**
     * 12. 分页查询：LIMIT + OFFSET
     * GET /jdbc/pagination?status=1&pageNum=1&pageSize=10
     */
    @GetMapping("/pagination")
    public List<Map<String, Object>> paginationQuery(@RequestParam(required = false) Integer status,
                                                     @RequestParam(defaultValue = "1") Integer pageNum,
                                                     @RequestParam(defaultValue = "10") Integer pageSize) {
        return jdbcTemplateService.paginationQuery(status, pageNum, pageSize);
    }

    /**
     * 13. 分页 + 总记录数
     * GET /jdbc/pageWithTotal?keyword=admin&pageNum=1&pageSize=10
     */
    @GetMapping("/pageWithTotal")
    public Map<String, Object> paginationWithTotalCount(@RequestParam(required = false) String keyword,
                                                        @RequestParam(defaultValue = "1") Integer pageNum,
                                                        @RequestParam(defaultValue = "10") Integer pageSize) {
        return jdbcTemplateService.paginationWithTotalCount(keyword, pageNum, pageSize);
    }

    // ==================== 增删改操作 ====================

    /**
     * 14. INSERT 插入
     * POST /jdbc/insert?username=test&password=123456&age=25&roleId=2
     */
    @PostMapping("/insert")
    public int insertUser(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam Integer age,
                          @RequestParam Integer roleId) {
        return jdbcTemplateService.insertUser(username, password, age, roleId);
    }

    /**
     * 15. UPDATE 更新
     * PUT /jdbc/update/1?status=0
     */
    @PutMapping("/update/{id}")
    public int updateUserStatus(@PathVariable Integer id, @RequestParam Integer status) {
        return jdbcTemplateService.updateUserStatus(id, status);
    }

    /**
     * 16. DELETE 删除
     * DELETE /jdbc/delete/1
     */
    @DeleteMapping("/delete/{id}")
    public int deleteUserById(@PathVariable Integer id) {
        return jdbcTemplateService.deleteUserById(id);
    }

    /**
     * 17. 批量插入：batchUpdate
     * POST /jdbc/batchInsert
     */
    @PostMapping("/batchInsert")
    public int[] batchInsertUsers(@RequestBody List<Map<String, Object>> users) {
        return jdbcTemplateService.batchInsertUsers(users);
    }

    // ==================== 复杂业务场景 ====================

    /**
     * 18. 模拟用户示例：复杂动态 SQL + 多条件分支
     * GET /jdbc/complexBusiness?flowKey=ALL&lotNumber=2&pageNum=1&pageSize=10
     */
    @GetMapping("/complexBusiness")
    public List<Map<String, Object>> simulateComplexBusinessQuery(@RequestParam String flowKey,
                                                                   @RequestParam String curUser,
                                                                   @RequestParam String curUserTenant,
                                                                   @RequestParam(required = false) String lotNumber,
                                                                   @RequestParam(defaultValue = "1") Integer pageNum,
                                                                   @RequestParam(defaultValue = "10") Integer pageSize) {
        return jdbcTemplateService.simulateComplexBusinessQuery(flowKey, curUser, curUserTenant, lotNumber, pageNum, pageSize);
    }

    /**
     * 19. 嵌套子查询 + 聚合 + 排序
     * GET /jdbc/nestedSubquery
     */
    @GetMapping("/nestedSubquery")
    public List<Map<String, Object>> nestedSubqueryWithAggregation() {
        return jdbcTemplateService.nestedSubqueryWithAggregation();
    }

    /**
     * 20. UNION 联合查询
     * GET /jdbc/union?keyword=admin
     */
    @GetMapping("/union")
    public List<Map<String, Object>> unionQuery(@RequestParam(required = false) String keyword) {
        return jdbcTemplateService.unionQuery(keyword);
    }
}
