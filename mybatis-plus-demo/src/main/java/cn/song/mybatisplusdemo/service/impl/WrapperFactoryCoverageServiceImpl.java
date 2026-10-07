package cn.song.mybatisplusdemo.service.impl;

import cn.song.mybatisplusdemo.entity.SysConfig;
import cn.song.mybatisplusdemo.entity.User;
import cn.song.mybatisplusdemo.mapper.SysConfigMapper;
import cn.song.mybatisplusdemo.mapper.UserMapper;
import cn.song.mybatisplusdemo.service.WrapperFactoryCoverageService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.ChainWrappers;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Wrapper 工厂/链式/工具类形态全覆盖服务实现类
 *
 * @author SongRenShuo
 */
@Service
public class WrapperFactoryCoverageServiceImpl implements WrapperFactoryCoverageService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private SysConfigMapper sysConfigMapper;

    /**
     * Wrappers 工厂族：query()/query(T)/lambdaQuery()/lambdaQuery(T)/lambdaQuery(Class)/update(T)/lambdaUpdate(Class)/emptyWrapper
     */
    @Override
    public Map<String, Object> listByWrappersFactory(String username) {
        Map<String, Object> result = new HashMap<>();
        result.put("query", userMapper.selectList(Wrappers.query()));
        result.put("queryEntity", userMapper.selectList(Wrappers.query(new User().setUsername(username))));
        result.put("lambdaQuery", userMapper.selectList(Wrappers.lambdaQuery()));
        result.put("lambdaQueryEntity", userMapper.selectList(Wrappers.lambdaQuery(new User().setStatus(1))));
        result.put("lambdaQueryClass", userMapper.selectList(
                Wrappers.<User>lambdaQuery(User.class).like(User::getUsername, username)));
        result.put("updateEntity", userMapper.update(new User().setStatus(2),
                Wrappers.update(new User().setRoleId(1))));
        result.put("lambdaUpdateClass", userMapper.update(null,
                Wrappers.<User>lambdaUpdate(User.class).set(User::getPassword, "x").eq(User::getId, 1)));
        result.put("empty", userMapper.selectCount(Wrappers.emptyWrapper()));
        return result;
    }

    /**
     * ChainWrappers 链式：queryChain(Class)/lambdaQueryChain(Class)/updateChain(Class)/lambdaUpdateChain(mapper)
     * 终结点：list/one/count/exists/page
     */
    @Override
    public Map<String, Object> listByChainWrappers(String username) {
        Map<String, Object> result = new HashMap<>();
        result.put("queryChainList", ChainWrappers.queryChain(User.class)
                .eq("status", 1).like("username", username).list());
        result.put("lambdaQueryChainOne", ChainWrappers.lambdaQueryChain(User.class)
                .eq(User::getUsername, username).one());
        result.put("lambdaQueryChainCount", ChainWrappers.lambdaQueryChain(userMapper)
                .gt(User::getAge, 18).count());
        result.put("lambdaQueryChainExists", ChainWrappers.lambdaQueryChain(User.class)
                .eq(User::getDeptId, 1).exists());
        result.put("queryChainPage", ChainWrappers.queryChain(User.class)
                .orderByDesc("id").page(new Page<>(1, 10)));
        result.put("updateChain", ChainWrappers.updateChain(User.class)
                .set("status", 0).eq("id", 100).update());
        result.put("lambdaUpdateChain", ChainWrappers.lambdaUpdateChain(userMapper)
                .set(User::getPassword, "chain").eq(User::getId, 101).update());
        return result;
    }

    /**
     * Db kit 静态 CRUD（3.5.3+，无需注入 mapper）：
     * list/getById/save/removeById/updateById/lambdaQuery/lambdaUpdate/count
     */
    @Override
    public Map<String, Object> crudByDbKit(String username) {
        Map<String, Object> result = new HashMap<>();
        result.put("list", Db.list(Wrappers.<User>lambdaQuery(User.class).eq(User::getStatus, 1)));
        result.put("getById", Db.getById(1, User.class));
        result.put("count", Db.count(Wrappers.<User>lambdaQuery(User.class).like(User::getUsername, username)));
        result.put("lambdaQueryList", Db.lambdaQuery(User.class).gt(User::getAge, 30).list());
        result.put("lambdaQueryPage", Db.lambdaQuery(User.class).orderByDesc(User::getId).page(new Page<>(1, 5)));

        User user = new User().setUsername(username).setStatus(1);
        result.put("save", Db.save(user));
        user.setId(999);
        result.put("updateById", Db.updateById(user));
        result.put("removeById", Db.removeById(999, User.class));

        result.put("lambdaUpdate", Db.lambdaUpdate(User.class)
                .set(User::getStatus, 0).eq(User::getId, 998).update());
        return result;
    }

    /**
     * SimpleQuery 三形态：keyMap（主键→实体）/ map（键→值）/ list（单列列表）
     */
    @Override
    public Map<String, Object> queryBySimpleQuery(String keyword) {
        Map<String, Object> result = new HashMap<>();
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery(User.class)
                .like(User::getUsername, keyword).eq(User::getStatus, 1);
        result.put("keyMap", SimpleQuery.keyMap(wrapper, User::getId));
        result.put("map", SimpleQuery.map(wrapper, User::getId, User::getUsername));
        result.put("list", SimpleQuery.list(wrapper, User::getEmail));
        return result;
    }

    /**
     * ActiveRecord 形态（Model 基类）：insert/updateById/deleteById
     */
    @Override
    public Map<String, Object> crudByActiveRecord(SysConfig config) {
        Map<String, Object> result = new HashMap<>();
        result.put("insert", config.insert());
        config.setId(1);
        result.put("updateById", config.updateById());
        result.put("deleteById", config.deleteById());

        SysConfig query = new SysConfig().setConfigKey("init");
        // AR 形态 selectOne 需显式传 Wrapper（3.5.3+ 签名变更）
        result.put("selectOne", query.selectOne(Wrappers.<SysConfig>lambdaQuery()
                .eq(SysConfig::getConfigKey, query.getConfigKey())));
        result.put("selectAll", query.selectAll());
        return result;
    }

    /**
     * BaseMapper/IService CRUD 补形态：selectMapsPage/selectCount/exists/update(wrapper)/removeByMap/page
     */
    @Override
    public Map<String, Object> crudMapperMoreForms(String keyword) {
        Map<String, Object> result = new HashMap<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().like("username", keyword);
        IPage<Map<String, Object>> mapsPage = userMapper.selectMapsPage(new Page<>(1, 10), queryWrapper);
        result.put("selectMapsPage", mapsPage);
        result.put("selectCount", userMapper.selectCount(queryWrapper));
        result.put("exists", userMapper.exists(Wrappers.<User>lambdaQuery(User.class).eq(User::getId, 1)));

        LambdaQueryWrapper<User> updateWrapper = Wrappers.<User>lambdaQuery(User.class).eq(User::getId, 2);
        result.put("update", userMapper.update(new User().setStatus(3), updateWrapper));

        Map<String, Object> byMap = new HashMap<>();
        byMap.put("dept_id", 2);
        result.put("removeByMap", userMapper.deleteByMap(byMap));

        result.put("page", userMapper.selectPage(new Page<>(1, 10),
                new QueryWrapper<User>().eq("status", 1).orderByAsc("id")));
        return result;
    }

    /**
     * 裸工厂链 + 带参 exists 子查询（T-ExistsChainTerminal 复现用例，2026-10-07）
     *
     * 复现的缺陷形态：`Wrappers.<User>lambdaQuery(...)` 链**直接作 mapper 方法实参**（链内没有
     * one/list/count/page 等真终结点）时，带参 `exists(...)` 会被插件定位层的终结点判定误判为链终结点
     * ——`exists` 在 MP 里同时是条件方法（`Join.exists(String, Object...)`）与链终结点（`ChainQuery.exists()` 无参）。
     *
     * 静态预览验收清单（光标落在各 `Wrappers.<User>lambdaQuery` 链上触发预览）：
     *   ① 裸工厂链形态（本用例的缺陷形态）：应含
     *      `WHERE username LIKE ? AND EXISTS (select 1 from t_order o where o.user_id = user.id) AND status = 1`
     *      ——修复前为 `SELECT EXISTS (SELECT ... WHERE status = 1)`：EXISTS 条件整条丢失，且整链被误包
     *   ② 裸工厂链 + 分页消费（T-M25.2 用户报障原始形态 `service.page(page, wrapper)`）：与 ① 同 SQL
     *      （分页终结点在 service 侧，wrapper 链内同样没有真终结点，缺陷同源）
     *   ③ 变量声明形态（对照）：修复前后均正确，与 ①② 产出同一份 SQL
     *   ④ 裸工厂链 notExists（对照）：修复前后均正确（`notExists` 不在终结点名单，不对称是有意为之）
     *
     * 注：`var w = Wrappers.<User>lambdaQuery(...)...exists(...)` 形态同属修复面（曾因同一名单被拒为
     * wrapper 变量），但本 demo 模块为 Java 8（maven.compiler.source=8）无法表达 `var`——
     * 该形态的回归由插件侧金样矩阵 S95 覆盖。
     *
     * 运行时：GET /config/factory/bareChainExists?username=admin
     */
    @Override
    public Map<String, Object> listByBareFactoryChainExists(String username) {
        Map<String, Object> result = new HashMap<>();

        // ① 缺陷形态：裸工厂链直接作实参，链内无真终结点
        result.put("bareFactoryChain", userMapper.selectList(
                Wrappers.<User>lambdaQuery(User.class)
                        .like(StringUtils.hasText(username), User::getUsername, username)
                        .exists("select 1 from t_order o where o.user_id = user.id")
                        .eq(User::getStatus, 1)
                        .orderByDesc(User::getId)));

        // ② 裸工厂链 + 分页消费（T-M25.2 用户报障原始形态：wrapper 是裸工厂链、分页终结点在 service 侧）
        result.put("bareFactoryChainPaged", userMapper.selectPage(new Page<>(1, 10),
                Wrappers.<User>lambdaQuery(User.class)
                        .like(StringUtils.hasText(username), User::getUsername, username)
                        .exists("select 1 from t_order o where o.user_id = user.id")
                        .eq(User::getStatus, 1)
                        .orderByDesc(User::getId)));

        // ③ 变量声明形态（对照）
        LambdaQueryWrapper<User> variableWrapper = Wrappers.<User>lambdaQuery(User.class)
                .like(StringUtils.hasText(username), User::getUsername, username)
                .exists("select 1 from t_order o where o.user_id = user.id")
                .eq(User::getStatus, 1)
                .orderByDesc(User::getId);
        result.put("variableDeclared", userMapper.selectList(variableWrapper));

        // ④ notExists 对照：不在终结点名单，本就不受影响
        result.put("bareFactoryChainNotExists", userMapper.selectList(
                Wrappers.<User>lambdaQuery(User.class)
                        .like(StringUtils.hasText(username), User::getUsername, username)
                        .notExists("select 1 from t_order o where o.user_id = user.id")
                        .eq(User::getStatus, 1)
                        .orderByDesc(User::getId)));

        return result;
    }
}
