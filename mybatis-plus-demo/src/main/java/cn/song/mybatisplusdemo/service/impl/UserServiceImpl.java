package cn.song.mybatisplusdemo.service.impl;

import cn.song.mybatisplusdemo.common.PageQuery;
import cn.song.mybatisplusdemo.entity.User;
import cn.song.mybatisplusdemo.mapper.UserMapper;
import cn.song.mybatisplusdemo.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 用户表(User)服务实现类
 * 集中编写各种 Wrapper 调用链，供 mybatis-plus-sql-visualizer 插件预览 SQL
 *
 * @author SongRenShuo
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * LambdaQueryWrapper 组合条件查询：eq/like/ge/le + orderByDesc
     */
    @Override
    public List<User> listByLambdaQuery(User query) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.hasText(query.getUsername()), User::getUsername, query.getUsername());
        queryWrapper.eq(query.getStatus() != null, User::getStatus, query.getStatus());
        queryWrapper.ge(query.getAge() != null, User::getAge, query.getAge());
        queryWrapper.orderByDesc(User::getId);
        return this.list(queryWrapper);
    }

    /**
     * LambdaQueryWrapper 嵌套 and/or：and(w -> w.xxx.or().xxx)
     */
    @Override
    public List<User> listByNestedCondition(String username, Integer minAge, Integer maxAge) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getStatus, 1);
        queryWrapper.and(w -> w.like(User::getUsername, username)
                .or()
                .between(User::getAge, minAge, maxAge));
        queryWrapper.or(w -> w.isNull(User::getEmail).ge(User::getAge, 18));
        return this.list(queryWrapper);
    }

    /**
     * QueryWrapper 字符串列名：select 指定列 + groupBy + having + orderBy
     */
    @Override
    public List<Map<String, Object>> listMapsByQueryWrapper(Integer roleId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("role_id", "count(*) as cnt", "max(age) as max_age");
        queryWrapper.eq("status", 1);
        queryWrapper.eq(roleId != null, "role_id", roleId);
        queryWrapper.groupBy("role_id");
        queryWrapper.having("count(*) > 1");
        queryWrapper.orderByDesc("cnt");
        return this.listMaps(queryWrapper);
    }

    /**
     * LambdaQueryWrapper 模糊/区间/IN：likeLeft/likeRight/between/in/notIn
     */
    @Override
    public List<User> listByLikeAndBetween(String keyword, Integer ageStart, Integer ageEnd, List<Integer> ids) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.likeRight(StringUtils.hasText(keyword), User::getUsername, keyword);
        queryWrapper.between(ageStart != null && ageEnd != null, User::getAge, ageStart, ageEnd);
        queryWrapper.in(ids != null && !ids.isEmpty(), User::getId, ids);
        queryWrapper.ne(User::getStatus, 0);
        queryWrapper.orderByAsc(User::getAge);
        return this.list(queryWrapper);
    }

    /**
     * QueryWrapper exists / notExists 子查询
     */
    @Override
    public List<User> listByExists(String emailDomain) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.exists("select 1 from t_order o where o.user_id = user.id");
        queryWrapper.notExists("select 1 from user_role ur where ur.user_id = user.id");
        queryWrapper.likeRight(StringUtils.hasText(emailDomain), "email", emailDomain);
        return this.list(queryWrapper);
    }

    /**
     * LambdaUpdateWrapper：set + setSql + in + and 嵌套条件
     */
    @Override
    public boolean updateByLambdaUpdateWrapper(Integer status, Integer minAge) {
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(User::getStatus, status);
        updateWrapper.set(User::getUpdateTime, null);
        updateWrapper.setSql("age = age + 1");
        updateWrapper.ge(minAge != null, User::getAge, minAge);
        updateWrapper.and(w -> w.eq(User::getRoleId, 1).or().isNull(User::getDeptId));
        return this.update(updateWrapper);
    }

    /**
     * UpdateWrapper 字符串列名更新
     */
    @Override
    public boolean updateByUpdateWrapper(String email, Integer roleId) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("email", email);
        updateWrapper.set("update_time", "now()");
        updateWrapper.eq("id", roleId);
        updateWrapper.in("status", Arrays.asList(0, 1));
        return this.update(updateWrapper);
    }

    /**
     * LambdaDeleteWrapper 删除（逻辑删除 + 嵌套条件）
     */
    @Override
    public boolean removeByLambdaDeleteWrapper(Integer status, Integer maxAge) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getStatus, status);
        queryWrapper.le(User::getAge, maxAge);
        queryWrapper.or(w -> w.eq(User::getRoleId, 9).isNull(User::getEmail));
        return this.remove(queryWrapper);
    }

    /**
     * Wrappers.lambdaQuery 链式：select + eq + last
     */
    @Override
    public List<User> listByWrappersLambda(String username) {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery()
                .select(User::getId, User::getUsername, User::getAge, User::getEmail)
                .eq(StringUtils.hasText(username), User::getUsername, username)
                .eq(User::getStatus, 1)
                .last("limit 20");
        return this.list(queryWrapper);
    }

    /**
     * lambdaQuery 链式（IService 提供）+ orderByDesc + last
     */
    @Override
    public List<User> listByChainLambda(String username) {
        return this.lambdaQuery()
                .likeRight(User::getUsername, username)
                .eq(User::getDeleted, 0)
                .orderByDesc(User::getCreateTime)
                .last("limit 10")
                .list();
    }

    /**
     * 分页查询：selectPage + LambdaQueryWrapper
     */
    @Override
    public IPage<User> pageByWrapper(PageQuery pageQuery, User query) {
        Page<User> page = new Page<>(pageQuery.getCurrent(), pageQuery.getSize());
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(query.getUsername()), User::getUsername, query.getUsername());
        queryWrapper.eq(query.getStatus() != null, User::getStatus, query.getStatus());
        queryWrapper.in(pageQuery.getIds() != null && !pageQuery.getIds().isEmpty(),
                User::getId, pageQuery.getIds());
        queryWrapper.orderByDesc(User::getCreateTime);
        return this.page(page, queryWrapper);
    }

    /**
     * selectCount 统计：count(User::getId) + 条件
     */
    @Override
    public long countByWrapper(String username, Integer status) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.hasText(username), User::getUsername, username);
        queryWrapper.eq(status != null, User::getStatus, status);
        return this.count(queryWrapper);
    }

    /**
     * selectOne 单条查询：last limit 1
     */
    @Override
    public User getOneByWrapper(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        queryWrapper.last("limit 1");
        return this.getOne(queryWrapper);
    }

    /**
     * 批量操作：saveBatch / updateBatchById
     */
    @Override
    public boolean batchSaveAndUpdate(List<User> users) {
        if (users == null || users.isEmpty()) {
            return false;
        }
        List<User> toInsert = Arrays.asList(users.get(0));
        List<User> toUpdate = users.subList(1, users.size());
        boolean saved = this.saveBatch(toInsert);
        boolean updated = this.updateBatchById(toUpdate);
        return saved && updated;
    }

    /**
     * 乐观锁更新：@Version 版本号控制
     */
    @Override
    public boolean updateWithVersion(User user) {
        User target = new User();
        target.setId(user.getId());
        target.setUsername(user.getUsername());
        target.setVersion(user.getVersion());
        return this.updateById(target);
    }

    /**
     * 注解 SQL：@Select 纯文本
     */
    @Override
    public User selectByAnnotationId(Integer id) {
        return this.baseMapper.selectByAnnotationId(id);
    }

    /**
     * XML 动态 SQL：where + if 组合查询
     */
    @Override
    public List<User> selectUserListByXml(String username, Integer status, Integer age) {
        return this.baseMapper.selectUserListByXml(username, status, age);
    }
}
