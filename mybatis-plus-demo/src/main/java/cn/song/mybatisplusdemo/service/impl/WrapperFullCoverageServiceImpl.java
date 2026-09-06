package cn.song.mybatisplusdemo.service.impl;

import cn.song.mybatisplusdemo.entity.User;
import cn.song.mybatisplusdemo.mapper.UserMapper;
import cn.song.mybatisplusdemo.service.WrapperFullCoverageService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Wrapper 条件方法全覆盖服务实现类
 * 补齐 likeLeft/notLike 族、notBetween、isNotNull、geSql/ltSql、func、first/comment、
 * or 嵌套细节、多列 groupBy/orderBy、UpdateWrapper 全条件、LambdaDeleteWrapper 等形态
 *
 * @author SongRenShuo
 */
@Service
public class WrapperFullCoverageServiceImpl implements WrapperFullCoverageService {

    @Resource
    private UserMapper userMapper;

    /**
     * like 族补全：likeLeft（%前缀）/ notLike / notLikeLeft / notLikeRight
     */
    @Override
    public List<User> listByLikeFamily(String keyword) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeLeft("username", keyword);
        wrapper.notLike("email", "test");
        wrapper.notLikeRight(true, "password", "123");
        wrapper.notLikeLeft("remark", "tmp");
        return userMapper.selectList(wrapper);
    }

    /**
     * notBetween / isNotNull / ge / lt 基础条件补全
     */
    @Override
    public List<User> listByRangeConditions(Integer low, Integer high) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.ge(User::getId, 1);
        wrapper.lt(User::getAge, 200);
        wrapper.notBetween(User::getAge, low, high);
        wrapper.isNotNull(User::getEmail);
        wrapper.isNull(User::getRoleId);
        return userMapper.selectList(wrapper);
    }

    /**
     * geSql / ltSql（SQL 片段直拼补全）
     */
    @Override
    public List<User> listBySqlFragmentExt(String minAmount) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.geSql("id", "select user_id from t_order where amount >= " + minAmount);
        wrapper.ltSql("id", "select max(id) from user");
        return userMapper.selectList(wrapper);
    }

    /**
     * or 细粒度嵌套：or(Consumer) 与 or() 连缀混合
     */
    @Override
    public List<User> listByOrNesting(String username, Integer status) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getStatus, 1);
        wrapper.or(w -> w.eq(User::getUsername, username).like(User::getEmail, username));
        wrapper.or().gt(User::getAge, 60).lt(User::getAge, 18);
        wrapper.or(w -> w.in(User::getDeptId, 1, 2, 3).ne(User::getRoleId, 9));
        return userMapper.selectList(wrapper);
    }

    /**
     * func：多条件 consumer 批量接入（boolean 开关形态）
     */
    @Override
    public List<User> listByFuncConsumer(String username, Integer age) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getStatus, 1);
        wrapper.func(username != null, w -> w.likeRight(User::getUsername, username));
        wrapper.func(age != null, w -> w.ge(User::getAge, age).le(User::getAge, age + 30));
        return userMapper.selectList(wrapper);
    }

    /**
     * apply 多参数占位 {0}/{1} 与 exists {0} 参数化
     */
    @Override
    public List<User> listByApplyParams(Integer years, Integer roleId) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.apply("create_time > date_sub(now(), interval {0} year)", years);
        wrapper.apply("deleted = {0} and role_id = {1}", 0, roleId);
        wrapper.exists("select 1 from t_order o where o.user_id = id and o.amount > {0}", 100);
        return userMapper.selectList(wrapper);
    }

    /**
     * first / comment / last 三段直拼（3.5.3+）
     */
    @Override
    public List<User> listByFirstCommentLast(String keyword) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.first("DISTINCT");
        wrapper.comment("按用户名模糊检索");
        wrapper.like("username", keyword);
        wrapper.last("limit 20");
        return userMapper.selectList(wrapper);
    }

    /**
     * groupBy 多列 + having 多条件 + orderBy 多列混排
     */
    @Override
    public List<Map<String, Object>> groupByMultiColumn(Integer minAge) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("dept_id", "role_id", "count(*) as cnt", "avg(age) as avg_age");
        wrapper.ge("age", minAge);
        wrapper.groupBy("dept_id", "role_id");
        wrapper.having("count(*) > {0}", 1);
        wrapper.having("avg(age) >= 18");
        wrapper.orderByAsc("dept_id");
        wrapper.orderByDesc("role_id", "cnt");
        return userMapper.selectMaps(wrapper);
    }

    /**
     * UpdateWrapper 全条件形态：set 开关/setSql/in/notIn/between/notBetween/isNotNull 嵌套
     */
    @Override
    public int updateByFullConditions(List<Integer> roleIds, String emailSuffix) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set(true, "status", 2);
        wrapper.set("remark", "batch-updated");
        wrapper.setSql("update_time = now()");
        wrapper.in("role_id", roleIds);
        wrapper.notIn("dept_id", 99);
        wrapper.between("age", 18, 65);
        wrapper.notBetween("id", 1000, 2000);
        wrapper.isNotNull("email");
        wrapper.likeRight("email", emailSuffix);
        wrapper.eq("deleted", 0);
        return userMapper.update(null, wrapper);
    }

    /**
     * LambdaDeleteWrapper 显式形态（条件删除）
     */
    @Override
    public int deleteByLambdaDeleteWrapper(Integer status, String email) {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(User::getStatus, status);
        wrapper.like(User::getEmail, email);
        wrapper.and(w -> w.isNull(User::getRoleId).or().eq(User::getDeptId, 0));
        return userMapper.delete(wrapper);
    }
}
