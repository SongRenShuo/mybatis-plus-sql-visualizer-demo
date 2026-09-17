package cn.song.mpjdemo.service.impl;

import cn.song.mpjdemo.dto.UserDTO;
import cn.song.mpjdemo.entity.AddressDO;
import cn.song.mpjdemo.entity.AreaDO;
import cn.song.mpjdemo.entity.UserDO;
import cn.song.mpjdemo.mapper.UserMapper;
import cn.song.mpjdemo.service.MpjLocatorCoverageService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.query.MPJQueryWrapper;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MPJ 定位器与终结点覆盖服务实现类
 * 语料对照插件 WrapperLocator 工厂注册表（JoinWrappers/MPJWrappers）与 Chain/UpdateChain 终结点
 *
 * @author SongRenShuo
 */
@Service("mpjLocatorCoverageService")
public class MpjLocatorCoverageServiceImpl implements MpjLocatorCoverageService {

    @Resource
    private UserMapper userMapper;

    /**
     * MPJWrappers.lambdaJoin 工厂链
     * SELECT t.id, t.name, addr.tel FROM user t LEFT JOIN user_address addr ON t.id = addr.user_id
     */
    @Override
    public List<UserDTO> mpjWrappersLambdaJoin() {
        return MPJWrappers.lambdaJoin(UserDO.class)
                .select(UserDO::getId, UserDO::getName)
                .selectAs(AddressDO::getTel, UserDTO::getTel)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .eq(UserDO::getSex, 1)
                .list(UserDTO.class);
    }

    /**
     * MPJWrappers.queryJoin 工厂链（字符串列）
     */
    @Override
    public List<Map<String, Object>> mpjWrappersQueryJoin() {
        MPJQueryWrapper<UserDO> wrapper = MPJWrappers.queryJoin(UserDO.class)
                .select("t.id", "t.name", "addr.tel")
                .leftJoin("user_address addr on t.id = addr.user_id")
                .like("t.name", "a");
        return userMapper.selectJoinMaps(wrapper);
    }

    /**
     * JoinWrappers.update 工厂 + setIncrBy + updateAndNull 终结
     * UPDATE user t LEFT JOIN user_address addr ON t.id = addr.user_id
     * SET t.age = t.age + 1, addr.status = NULL WHERE t.id = ?
     */
    @Override
    public int updateJoinAndNull(Integer userId) {
        return JoinWrappers.update(UserDO.class)
                .innerJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .setIncrBy(UserDO::getAge, 1)
                .set(AddressDO::getStatus, null)
                .eq(UserDO::getId, userId)
                .updateAndNull();
    }

    /**
     * Chain 终结点：first(Class) / one() / count()
     */
    @Override
    public Map<String, Object> terminalFirstOneCount(Integer userId) {
        Map<String, Object> result = new HashMap<>(3);
        UserDTO first = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .eq(UserDO::getId, userId)
                .first(UserDTO.class);
        result.put("first", first);

        UserDTO one = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .eq(UserDO::getId, userId)
                .one(UserDTO.class);
        result.put("one", one);

        Long count = JoinWrappers.lambda(UserDO.class)
                .innerJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .eq(UserDO::getSex, 1)
                .count();
        result.put("count", count);
        return result;
    }

    /**
     * Chain 终结点：mapOne / mapFirst / mapList（Map 形态，无需 DTO）
     */
    @Override
    public List<Map<String, Object>> terminalMapFamily(Integer maxAge) {
        Map<String, Object> mapOne = JoinWrappers.lambda(UserDO.class)
                .select(UserDO::getId, UserDO::getName)
                .le(UserDO::getAge, maxAge)
                .mapOne();

        Map<String, Object> mapFirst = JoinWrappers.lambda(UserDO.class)
                .select(UserDO::getId, UserDO::getName)
                .le(UserDO::getAge, maxAge)
                .orderByDesc(UserDO::getId)
                .mapFirst();

        List<Map<String, Object>> mapList = JoinWrappers.lambda(UserDO.class)
                .select(UserDO::getId, UserDO::getName, UserDO::getAge)
                .le(UserDO::getAge, maxAge)
                .mapList();

        mapList.add(0, mapOne);
        mapList.add(1, mapFirst);
        return mapList;
    }

    /**
     * Chain 终结点：mapPage
     */
    @Override
    public Page<Map<String, Object>> terminalMapPage(long current, long size) {
        return JoinWrappers.lambda(UserDO.class)
                .select(UserDO::getId, UserDO::getName)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .ge(UserDO::getAge, 18)
                .mapPage(new Page<>(current, size));
    }

    /**
     * 构造别名：new MPJLambdaWrapper<>(UserDO.class, "u")，生成列前缀为 u
     */
    @Override
    public List<UserDTO> constructorAlias() {
        MPJLambdaWrapper<UserDO> wrapper = new MPJLambdaWrapper<>(UserDO.class, "u")
                .selectAll(UserDO.class)
                .selectAs(AddressDO::getTel, UserDTO::getTel)
                .selectAs(AreaDO::getProvince, UserDTO::getProvince)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .leftJoin(AreaDO.class, AreaDO::getId, AddressDO::getAreaId)
                .isNotNull(UserDO::getHeadImg);
        return userMapper.selectJoinList(UserDTO.class, wrapper);
    }

    /**
     * 字符串 join {0} 参数替换（leftJoin(String, Object...)，{0} 走参数绑定）
     */
    @Override
    public List<UserDTO> joinWithPlaceholder(String tel) {
        MPJQueryWrapper<UserDO> wrapper = JoinWrappers.query(UserDO.class)
                .selectAll(UserDO.class)
                .select("addr.tel")
                .leftJoin("user_address addr on t.id = addr.user_id and addr.tel = {0}", tel)
                .le("t.age", 60);
        return userMapper.selectJoinList(UserDTO.class, wrapper);
    }
}
