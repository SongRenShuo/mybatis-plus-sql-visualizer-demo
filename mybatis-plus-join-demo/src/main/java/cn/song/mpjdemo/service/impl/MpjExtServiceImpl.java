package cn.song.mpjdemo.service.impl;

import cn.song.mpjdemo.dto.UserDTO;
import cn.song.mpjdemo.entity.AddressDO;
import cn.song.mpjdemo.entity.AreaDO;
import cn.song.mpjdemo.entity.UserDO;
import cn.song.mpjdemo.mapper.UserMapper;
import cn.song.mpjdemo.service.MpjExtService;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.query.MPJQueryWrapper;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.github.yulichang.wrapper.enums.DefaultFuncEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MPJ 扩展写法服务实现类
 * MPJQueryWrapper 字符串 / selectAssociation / union / selectSub / distinct / 自定义 join / 逻辑删除开关 / 链式
 *
 * @author SongRenShuo
 */
@Service("mpjExtService")
public class MpjExtServiceImpl implements MpjExtService {

    @Resource
    private UserMapper userMapper;

    /**
     * MPJQueryWrapper 字符串写法
     * SELECT t.id, t.name, addr.tel, addr.address, a.province
     * FROM user t LEFT JOIN user_address addr ON t.id = addr.user_id
     * RIGHT JOIN area a ON addr.area_id = a.id
     * WHERE addr.tel LIKE '1%' AND a.province <= '1'
     */
    @Override
    public List<UserDTO> queryWrapperString() {
        MPJQueryWrapper<UserDO> wrapper = JoinWrappers.query(UserDO.class)
                .selectAll(UserDO.class)
                .select("addr.tel", "addr.address", "a.province")
                .leftJoin("user_address addr on t.id = addr.user_id")
                .rightJoin("area a on addr.area_id = a.id")
                .like("addr.tel", "1")
                .le("a.province", "1");
        return userMapper.selectJoinList(UserDTO.class, wrapper);
    }

    /**
     * selectAssociation 一对一映射（user → 默认地址）
     */
    @Override
    public List<UserDTO> selectAssociation() {
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .selectAssociation(AddressDO.class, UserDTO::getDefaultAddress)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .eq(UserDO::getId, 1);
        return userMapper.selectJoinList(UserDTO.class, wrapper);
    }

    /**
     * selectCollection 带 prefix + 关联表过滤条件
     */
    @Override
    public List<UserDTO> selectCollectionWithFilter() {
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .selectCollection("user_address", AddressDO.class, UserDTO::getAddressList)
                .leftJoin(AddressDO.class, on -> on
                        .eq(AddressDO::getUserId, UserDO::getId)
                        .eq(AddressDO::getStatus, 1))
                .eq(UserDO::getSex, 1)
                .orderByDesc(UserDO::getId);
        return userMapper.selectJoinList(UserDTO.class, wrapper);
    }

    /**
     * union / unionAll 合并查询
     */
    @Override
    public List<UserDTO> unionQuery() {
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .union(UserDO.class, union -> union
                        .selectAll(UserDO.class)
                        .eq(UserDO::getId, 2))
                .unionAll(UserDO.class, union -> union
                        .selectAll(UserDO.class)
                        .eq(UserDO::getId, 3))
                .eq(UserDO::getId, 1);
        return userMapper.selectJoinList(UserDTO.class, wrapper);
    }

    /**
     * selectSub 子查询列：SELECT (SELECT ... FROM user_address WHERE user_id = t.id) AS tel
     */
    @Override
    public List<UserDTO> selectSubQuery() {
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .selectSub(AddressDO.class, sub -> sub
                        .select(AddressDO::getTel)
                        .eq(AddressDO::getUserId, 1), UserDTO::getTel)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .eq(UserDO::getId, 1);
        return userMapper.selectJoinList(UserDTO.class, wrapper);
    }

    /**
     * distinct 去重 + selectFunc 聚合
     */
    @Override
    public List<Map<String, Object>> distinctAndFunc() {
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                .distinct()
                .select(UserDO::getSex)
                .selectFunc(DefaultFuncEnum.COUNT, UserDO::getId, "cnt")
                .selectFunc(DefaultFuncEnum.MAX, UserDO::getAge, "maxAge")
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .groupBy(UserDO::getSex)
                .having("count(*) > 1")
                .orderByAsc(UserDO::getSex);
        return userMapper.selectJoinMaps(wrapper);
    }

    /**
     * 自定义 join（join(keyWord, condition, joinSql, args)）+ last / apply
     */
    @Override
    public List<UserDTO> customJoinAndApply() {
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .select(AddressDO::getTel)
                .join("LEFT JOIN", true, "user_address addr ON addr.user_id = t.id")
                .apply("t.age > {0}", 18)
                .last("limit 10");
        return userMapper.selectJoinList(UserDTO.class, wrapper);
    }

    /**
     * 逻辑删除开关：disableLogicDel / disableSubLogicDel / logicDelToOn
     */
    @Override
    public List<UserDTO> logicDelSwitch() {
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .select(AddressDO::getTel)
                .disableLogicDel()
                .disableSubLogicDel()
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .logicDelToOn()
                .eq(UserDO::getId, 1);
        return userMapper.selectJoinList(UserDTO.class, wrapper);
    }

    /**
     * 链式 count / one / list / page（Chain 接口）
     */
    @Override
    public Map<String, Object> chainCountOneList(Integer id) {
        Map<String, Object> result = new HashMap<>();
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId);
        // 链式 count
        Long count = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .eq(UserDO::getId, id)
                .count();
        // 链式 one（返回 DTO）
        UserDTO one = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .select(AddressDO::getTel)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .eq(UserDO::getId, id)
                .one(UserDTO.class);
        // 链式 list
        List<UserDTO> list = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .select(AddressDO::getTel)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .list(UserDTO.class);
        // 链式 page
        Page<UserDTO> page = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .select(AddressDO::getTel)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .page(new Page<>(1, 10), UserDTO.class);

        result.put("count", count);
        result.put("one", one);
        result.put("listSize", list.size());
        result.put("pageTotal", page.getTotal());
        result.put("wrapperCount", wrapper.count());
        return result;
    }

    /**
     * 更多条件：allEq / and-or 嵌套 / exists / notExists / between / in
     */
    @Override
    public List<UserDTO> moreConditions(Map<SFunction<UserDO, ?>, Object> allEq, Integer minAge, Integer maxAge, List<Integer> ids) {
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .select(AddressDO::getTel)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .allEq(allEq, true)
                .between(UserDO::getAge, minAge, maxAge)
                .in(UserDO::getId, ids)
                .and(w -> w.eq(UserDO::getSex, 1).or().eq(UserDO::getSex, 2))
                .or(w -> w.like(UserDO::getName, "张").isNull(UserDO::getHeadImg))
                .exists("select 1 from user_address addr where addr.user_id = t.id")
                .notExists("select 1 from area a where a.id = t.id")
                .orderByAsc(UserDO::getId);
        return userMapper.selectJoinList(UserDTO.class, wrapper);
    }
}
