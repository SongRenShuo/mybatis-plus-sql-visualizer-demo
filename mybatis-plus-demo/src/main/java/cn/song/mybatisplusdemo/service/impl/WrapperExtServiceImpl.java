package cn.song.mybatisplusdemo.service.impl;

import cn.song.mybatisplusdemo.common.PageQuery;
import cn.song.mybatisplusdemo.entity.User;
import cn.song.mybatisplusdemo.mapper.UserMapper;
import cn.song.mybatisplusdemo.service.UserService;
import cn.song.mybatisplusdemo.service.WrapperExtService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Wrapper 扩展写法服务实现类
 * 补充 eqSql/inSql/apply/allEq/not/nested/select 排除/链式/IService 等写法
 *
 * @author SongRenShuo
 */
@Service("wrapperExtService")
public class WrapperExtServiceImpl implements WrapperExtService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    /**
     * gtSql / geSql / ltSql / leSql / inSql：SQL 片段直拼（3 参 boolean 形式，注意 SQL 注入风险）
     * 注：eqSql 需 MP ≥ 3.5.6（已升级 3.5.7，见 WrapperFullCoverageServiceImpl#listBySqlFragmentExt），本方法保留 apply 等值直拼对照
     */
    @Override
    public List<User> listBySqlFragment(Integer minAge) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.apply("status = 1");
        wrapper.gtSql(true, User::getAge, String.valueOf(minAge));
        wrapper.leSql(true, User::getAge, "100");
        wrapper.apply("deleted = 0");
        wrapper.orderByDesc(User::getId);
        return userMapper.selectList(wrapper);
    }

    /**
     * inSql / notInSql：IN 子查询 SQL
     */
    @Override
    public List<User> listByInSql() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id", "select user_id from t_order where amount > 100");
        wrapper.notInSql("role_id", "select id from role where code = 'GUEST'");
        wrapper.eq("status", 1);
        return userMapper.selectList(wrapper);
    }

    /**
     * apply + last + exists / notExists（带参数）
     */
    @Override
    public List<User> listByApplyAndExists(String emailDomain) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.apply("date_format(create_time, '%Y') = {0}", 2026);
        wrapper.exists("select 1 from t_order o where o.user_id = user.id");
        wrapper.notExists("select 1 from user_role ur where ur.user_id = user.id");
        wrapper.likeRight(emailDomain != null, "email", emailDomain);
        wrapper.last("limit 10");
        return userMapper.selectList(wrapper);
    }

    /**
     * allEq：Map 等值条件（null2IsNull 参数）
     */
    @Override
    public List<User> listByAllEq(Map<String, Object> params) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 第二参 true：值为 null 时生成 IS NULL；false：跳过 null
        wrapper.allEq(params, true);
        return userMapper.selectList(wrapper);
    }

    /**
     * not + nested 多层嵌套
     */
    @Override
    public List<User> listByNotAndNested(String username, Integer roleId) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getStatus, 1);
        wrapper.not(w -> w.eq(User::getRoleId, 1).or().eq(User::getRoleId, 2));
        wrapper.nested(w -> w.like(User::getUsername, username).or().isNull(User::getEmail));
        wrapper.orderByAsc(User::getId);
        return userMapper.selectList(wrapper);
    }

    /**
     * select 排除字段（select(Class, Predicate)）+ selectObjs
     */
    @Override
    public List<Object> listObjsBySelectExclude() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // 排除 password 列，其余字段全部查询
        wrapper.select(User.class, field -> !"password".equals(field.getColumn()));
        wrapper.eq(User::getStatus, 1);
        return userMapper.selectObjs(wrapper);
    }

    /**
     * 链式 lambdaQuery：count / one
     */
    @Override
    public Long countByChain(String username) {
        return userService.lambdaQuery()
                .likeRight(User::getUsername, username)
                .eq(User::getStatus, 1)
                .count();
    }

    /**
     * 链式 lambdaUpdate：set + eq + update
     */
    @Override
    public boolean updateByChain(Integer id, Integer status) {
        return userService.lambdaUpdate()
                .set(User::getStatus, status)
                .set(User::getUpdateTime, null)
                .eq(User::getId, id)
                .update();
    }

    /**
     * 链式 lambdaUpdate：eq + remove（链式删除）
     */
    @Override
    public boolean removeByChain(Integer status) {
        return userService.lambdaUpdate()
                .eq(User::getStatus, status)
                .remove();
    }

    /**
     * 显式 LambdaDeleteWrapper
     */
    @Override
    public boolean removeByLambdaDelete(Integer maxAge, List<Integer> roleIds) {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.le(User::getAge, maxAge);
        wrapper.in(roleIds != null && !roleIds.isEmpty(), User::getRoleId, roleIds);
        wrapper.or(w -> w.eq(User::getStatus, 0).isNull(User::getEmail));
        return userService.remove(wrapper);
    }

    /**
     * IService 更多方法：saveOrUpdate / saveOrUpdateBatch / listByIds / listByMap / removeByIds
     */
    @Override
    public Map<String, Object> iserviceMore(User user, List<Integer> ids, Map<String, Object> columnMap) {
        Map<String, Object> result = new HashMap<>();
        result.put("saveOrUpdate", userService.saveOrUpdate(user));
        result.put("saveOrUpdateBatch", userService.saveOrUpdateBatch(Collections.singletonList(user)));
        result.put("listByIds", userService.listByIds(ids));
        result.put("listByMap", userService.listByMap(columnMap));
        result.put("removeByIds", userService.removeByIds(ids));
        result.put("getMap", userService.getMap(new QueryWrapper<User>().eq("id", 1)));
        result.put("getObj", userService.getObj(
                new QueryWrapper<User>().eq("id", 1).select("username"), obj -> obj));
        return result;
    }

    /**
     * getOne 不抛异常（多记录时返回 null）
     */
    @Override
    public User getOneSilent(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        return userService.getOne(wrapper, false);
    }

    /**
     * XML 一对多：用户 + 部门 + 订单列表（resultMap association + collection）
     */
    @Override
    public List<User> selectUserWithOrdersXml(Integer status) {
        return userMapper.selectUserWithOrdersXml(status);
    }

    /**
     * XML 自定义分页查询（IPage 参数自动分页）
     */
    @Override
    public IPage<User> pageByXml(PageQuery pageQuery, Integer status) {
        Page<User> page = new Page<>(pageQuery.getCurrent(), pageQuery.getSize());
        return userMapper.selectUserPageXml(page, status, pageQuery.getKeyword());
    }

    /**
     * XML 多参数查询（@Param 多个 + if）
     */
    @Override
    public List<User> selectByMultiParamXml(String username, Integer status, Integer minAge) {
        return userMapper.selectByMultiParamXml(username, status, minAge);
    }

    /**
     * XML Map 参数查询（Map 作为唯一参数）
     */
    @Override
    public List<User> selectByMapParamXml(Map<String, Object> params) {
        return userMapper.selectByMapParamXml(params);
    }
}
