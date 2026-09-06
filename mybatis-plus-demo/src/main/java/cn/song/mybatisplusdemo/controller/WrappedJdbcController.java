package cn.song.mybatisplusdemo.controller;

import cn.song.mybatisplusdemo.service.WrappedJdbcService;
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

import java.util.List;
import java.util.Map;

/**
 * 封装工具类的 JDBC SQL 预览示例控制器
 * 演示 SQL 不直接调用 JdbcTemplate，而是通过 DbHelper 封装层执行
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/wrappedJdbc")
public class WrappedJdbcController {

    @Autowired
    private WrappedJdbcService wrappedJdbcService;

    /**
     * 1. 通过 DbHelper 查询列表
     * GET /wrappedJdbc/queryList?username=admin&status=1
     */
    @GetMapping("/queryList")
    public List<Map<String, Object>> queryUserByDbHelper(@RequestParam(required = false) String username,
                                                         @RequestParam(required = false) Integer status) {
        return wrappedJdbcService.queryUserByDbHelper(username, status);
    }

    /**
     * 2. 通过 DbHelper 查询单条
     * GET /wrappedJdbc/queryOne/1
     */
    @GetMapping("/queryOne/{id}")
    public Map<String, Object> queryOneUserByDbHelper(@PathVariable Integer id) {
        return wrappedJdbcService.queryOneUserByDbHelper(id);
    }

    /**
     * 3. 通过 DbHelper 动态 SQL 查询
     * GET /wrappedJdbc/dynamicQuery?keyword=test&roleIds=1,2,3
     */
    @GetMapping("/dynamicQuery")
    public List<Map<String, Object>> dynamicQueryByDbHelper(@RequestParam(required = false) String keyword,
                                                            @RequestParam(required = false) List<Integer> roleIds) {
        return wrappedJdbcService.dynamicQueryByDbHelper(keyword, roleIds);
    }

    /**
     * 4. 通过 DbHelper 分页查询
     * GET /wrappedJdbc/pagination?keyword=admin&pageNum=1&pageSize=10
     */
    @GetMapping("/pagination")
    public Map<String, Object> paginationByDbHelper(@RequestParam(required = false) String keyword,
                                                    @RequestParam(defaultValue = "1") Integer pageNum,
                                                    @RequestParam(defaultValue = "10") Integer pageSize) {
        return wrappedJdbcService.paginationByDbHelper(keyword, pageNum, pageSize);
    }

    /**
     * 5. 通过 DbHelper 插入
     * POST /wrappedJdbc/insert?username=test&password=123456&age=25&roleId=2
     */
    @PostMapping("/insert")
    public int insertByDbHelper(@RequestParam String username,
                                @RequestParam String password,
                                @RequestParam Integer age,
                                @RequestParam Integer roleId) {
        return wrappedJdbcService.insertByDbHelper(username, password, age, roleId);
    }

    /**
     * 6. 通过 DbHelper 更新
     * PUT /wrappedJdbc/update/1?email=test@example.com&status=1
     */
    @PutMapping("/update/{id}")
    public int updateByDbHelper(@PathVariable Integer id,
                                @RequestParam String email,
                                @RequestParam Integer status) {
        return wrappedJdbcService.updateByDbHelper(id, email, status);
    }

    /**
     * 7. 通过 DbHelper 删除
     * DELETE /wrappedJdbc/delete/1
     */
    @DeleteMapping("/delete/{id}")
    public int deleteByDbHelper(@PathVariable Integer id) {
        return wrappedJdbcService.deleteByDbHelper(id);
    }

    /**
     * 8. 通过 DbHelper 批量插入
     * POST /wrappedJdbc/batchInsert
     */
    @PostMapping("/batchInsert")
    public int[] batchInsertByDbHelper(@RequestBody List<List<Object>> users) {
        return wrappedJdbcService.batchInsertByDbHelper(users);
    }

    /**
     * 9. 通过 DbHelper 复杂 JOIN 查询
     * GET /wrappedJdbc/complexJoin?minAge=18
     */
    @GetMapping("/complexJoin")
    public List<Map<String, Object>> complexJoinByDbHelper(@RequestParam(required = false) Integer minAge) {
        return wrappedJdbcService.complexJoinByDbHelper(minAge);
    }

    /**
     * 10. 通过 DbHelper 分组统计
     * GET /wrappedJdbc/groupBy
     */
    @GetMapping("/groupBy")
    public List<Map<String, Object>> groupByByDbHelper() {
        return wrappedJdbcService.groupByByDbHelper();
    }
}
