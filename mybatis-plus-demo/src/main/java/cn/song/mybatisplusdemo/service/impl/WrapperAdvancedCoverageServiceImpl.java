package cn.song.mybatisplusdemo.service.impl;

import cn.song.mybatisplusdemo.entity.User;
import cn.song.mybatisplusdemo.mapper.UserMapper;
import cn.song.mybatisplusdemo.service.WrapperAdvancedCoverageService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Wrapper 高级定位与补充形态服务实现类
 * 语料对照插件 WrapperLocator 高级识别形态与 QueryWrapperParser 补充方法
 *
 * @author SongRenShuo
 */
@Service("wrapperAdvancedCoverageService")
public class WrapperAdvancedCoverageServiceImpl implements WrapperAdvancedCoverageService {

    @Resource
    private UserMapper userMapper;

    /**
     * 跨方法工厂链
     * baseActiveUserWrapper() 返回 Wrappers 工厂链，调用方持变量续链
     */
    @Override
    public List<User> factoryChainAcrossMethods(Integer minAge) {
        LambdaQueryWrapper<User> wrapper = baseActiveUserWrapper();
        wrapper.ge(User::getAge, minAge);
        return userMapper.selectList(wrapper);
    }

    /**
     * 工厂方法本身也是一条可预览的链
     */
    private LambdaQueryWrapper<User> baseActiveUserWrapper() {
        return Wrappers.<User>lambdaQuery()
                .eq(User::getStatus, 1)
                .isNotNull(User::getEmail);
    }

    /**
     * helper 方法就地修改 wrapper：wrapper 作为实参传入，helper 内部续链
     */
    @Override
    public List<User> helperModifiedWrapper(String username, Integer roleId) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .select(User::getId, User::getUsername, User::getEmail);
        applyUsernameFilter(wrapper, username);
        wrapper.eq(User::getRoleId, roleId);
        return userMapper.selectList(wrapper);
    }

    /**
     * helper 内部条件被插件聚合进调用方的链
     */
    private void applyUsernameFilter(LambdaQueryWrapper<User> wrapper, String username) {
        wrapper.like(User::getUsername, username)
                .isNotNull(User::getEmail);
    }

    /**
     * clear() 截断：先挂一个作废条件，clear 后重建有效条件
     */
    @Override
    public List<User> clearThenRebuild(Integer status, Integer deptId) {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery()
                .eq(User::getStatus, 999);
        wrapper.clear();
        wrapper.eq(User::getStatus, status)
                .eq(User::getDeptId, deptId)
                .orderByAsc(User::getId);
        return userMapper.selectList(wrapper);
    }

    /**
     * if/else 互斥分支：插件预览取 then 分支条件
     */
    @Override
    public List<User> exclusiveBranchQuery(Integer status, Integer deptId) {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if (status != null) {
            wrapper.eq(User::getStatus, status)
                    .ge(User::getAge, 18);
        } else {
            wrapper.isNull(User::getEmail);
        }
        wrapper.eq(User::getDeptId, deptId);
        return userMapper.selectList(wrapper);
    }

    /**
     * 字符串版 wrapper.lambda() 转 lambda 续链
     */
    @Override
    public List<User> stringWrapperToLambda(Integer status, Integer minAge) {
        QueryWrapper<User> stringWrapper = new QueryWrapper<User>()
                .eq("status", status);
        LambdaQueryWrapper<User> lambdaWrapper = stringWrapper.lambda()
                .ge(User::getAge, minAge)
                .notLike(User::getUsername, "test")
                .orderByDesc(User::getId);
        return userMapper.selectList(lambdaWrapper);
    }

    /**
     * 分步续链：new 后逐句挂 select/in/eq/orderBy
     */
    @Override
    public List<User> stepByStepBuild(Integer deptId, List<Integer> roleIds) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id", "username", "email", "age");
        wrapper.in("role_id", roleIds);
        wrapper.eq("dept_id", deptId);
        wrapper.gt("age", 20);
        wrapper.orderByAsc("username");
        return userMapper.selectList(wrapper);
    }

    /**
     * select(Class, Predicate)：按字段谓词过滤列（MP 3.5.7 实测存在）
     */
    @Override
    public List<User> selectByFieldPredicate(Integer status) {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery()
                .select(User.class, field -> !"password".equals(field.getColumn()))
                .eq(User::getStatus, status)
                .last("LIMIT 20");
        return userMapper.selectList(wrapper);
    }

    /**
     * allEq(Map, boolean)：第二参 false 时 null 值不生成 IS NULL
     */
    @Override
    public List<User> allEqNullableOff(Map<String, Object> params) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .allEq(params, false);
        return userMapper.selectList(wrapper);
    }

    /**
     * 实体驱动 SET：update 首参实体的非空字段生成 SET 子句
     */
    @Override
    public int updateByEntitySet(Integer id, String email, Integer status) {
        User entity = new User()
                .setEmail(email)
                .setStatus(status);
        UpdateWrapper<User> wrapper = new UpdateWrapper<User>()
                .eq("id", id)
                .gt("age", 0);
        return userMapper.update(entity, wrapper);
    }

    /**
     * 实体驱动 SET：new UpdateWrapper<>(entity) 构造器形态
     */
    @Override
    public int updateByWrapperEntityConstructor(Integer id, Integer age) {
        User entity = new User().setAge(age);
        UpdateWrapper<User> wrapper = new UpdateWrapper<>(entity)
                .eq("id", id);
        return userMapper.update(null, wrapper);
    }

    /**
     * notLike / notLikeLeft / notLikeRight 三族
     */
    @Override
    public List<User> notLikeFamily(String fragment) {
        return userMapper.selectList(Wrappers.<User>lambdaQuery()
                .notLike(User::getUsername, fragment)
                .notLikeLeft(User::getEmail, fragment)
                .notLikeRight(User::getUsername, fragment));
    }

    /**
     * insertBatchSomeColumn：自定义注入器批量插入
     */
    @Override
    public int batchInsertSome(List<User> users) {
        return userMapper.insertBatchSomeColumn(users);
    }

    /**
     * 静态性能建议演示：LIKE 用**字面通配**（前导 %）+ 无 LIMIT 的 ORDER BY
     * —— 预览面板元信息行下应同时给出「LIKE 含前导通配符」与「ORDER BY 无 LIMIT」两条建议。
     * 注意 MP 的 `like()` **自己补两侧 `%`**，值里不要再写 `%`（写成 `"%张%"` 会渲染出
     * `LIKE '%%张%%'` 的双重通配）。
     * （给文档站「静态性能建议」配图用的稳定素材；其余 demo 链的 LIKE 值都是变量，
     * 渲染成 `LIKE ?` 看不出通配形态，触发不了该规则。）
     */
    public List<User> perfAdviceDemo() {
        return userMapper.selectList(Wrappers.<User>lambdaQuery()
                .like(User::getUsername, "张")
                .orderByDesc(User::getCreateTime));
    }
}
