package cn.song.jdk16demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.song.jdk16demo.entity.User;
import cn.song.jdk16demo.service.UserService;

/**
 * 用户 REST 控制器（@RequestMapping(method=...) 老式路由，不用 4.3 新出的 @GetMapping 简写）。
 * 端点列表见模块 README。
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /** GET /users?name=&amp;status=&amp;age= —— 条件列表（无匹配条件时查全表） */
    @RequestMapping(method = RequestMethod.GET)
    public List<User> list(User query) {
        return userService.list(query);
    }

    /** GET /users/{id} —— 按 id 查，不存在回 404 */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> get(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /** POST /users —— 新增，返回带回填主键的实体 */
    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    /** PUT /users/{id} —— 按 id 更新非空字段 */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable("id") Long id, @RequestBody User user) {
        user.setId(id);
        return userService.update(user);
    }

    /** DELETE /users/{id} —— 按 id 删，返回影响行数 */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("deleted", Integer.valueOf(userService.deleteById(id)));
        return result;
    }

    /** GET /users/search?keyword=&amp;ids=1,2 —— &lt;choose&gt; 分支 + &lt;foreach&gt; IN 展开 */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<User> search(@RequestParam("keyword") String keyword,
                             @RequestParam(value = "ids", required = false) List<Long> ids) {
        return userService.search(keyword, ids);
    }

    /** GET /users/count?status=0 —— 注解 SQL 计数 */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public int count(@RequestParam("status") Integer status) {
        return userService.countByStatus(status);
    }
}
