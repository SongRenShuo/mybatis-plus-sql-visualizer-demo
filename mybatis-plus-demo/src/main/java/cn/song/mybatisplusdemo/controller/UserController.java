package cn.song.mybatisplusdemo.controller;

import cn.song.mybatisplusdemo.common.PageQuery;
import cn.song.mybatisplusdemo.entity.User;
import cn.song.mybatisplusdemo.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户管理
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * LambdaQueryWrapper 组合条件查询
     */
    @GetMapping("/list")
    public List<User> list(User query) {
        return userService.listByLambdaQuery(query);
    }

    /**
     * 嵌套 and/or 条件查询
     */
    @GetMapping("/nested")
    public List<User> nested(String username, Integer minAge, Integer maxAge) {
        return userService.listByNestedCondition(username, minAge, maxAge);
    }

    /**
     * 字符串列名分组统计查询
     */
    @GetMapping("/group")
    public List<java.util.Map<String, Object>> group(Integer roleId) {
        return userService.listMapsByQueryWrapper(roleId);
    }

    /**
     * 分页查询
     */
    @GetMapping("/page")
    public IPage<User> page(PageQuery pageQuery, User query) {
        return userService.pageByWrapper(pageQuery, query);
    }

    /**
     * 通过主键查询单条数据（selectById）
     */
    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    /**
     * 新增数据（save / insert）
     */
    @PostMapping
    public boolean save(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * 修改数据（updateById）
     */
    @PutMapping
    public boolean update(@RequestBody User user) {
        return userService.updateById(user);
    }

    /**
     * LambdaUpdateWrapper 条件更新（controller 内联演示）
     */
    @PutMapping("/updateByWrapper")
    public boolean updateByWrapper(Integer id, Integer status) {
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(User::getId, id).set(User::getStatus, status);
        return userService.update(updateWrapper);
    }

    /**
     * 删除数据（removeById / LambdaQueryWrapper 逻辑删除）
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId, id);
        return userService.remove(queryWrapper);
    }
}
