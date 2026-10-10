package cn.song.mpjdemo.service;

import cn.song.mpjdemo.dto.UserDTO;

import java.util.List;
import java.util.Map;

/**
 * MPJ 定位器与终结点覆盖服务层
 * 对应插件 WrapperLocator 工厂识别（MPJWrappers / JoinWrappers.update·delete）与 Chain 终结点（first/one/mapOne/mapFirst/mapList/mapPage/count）、
 * 构造别名、字符串 join {0} 参数替换
 *
 * @author SongRenShuo
 */
public interface MpjLocatorCoverageService {

    /**
     * MPJWrappers.lambdaJoin 工厂链（vs JoinWrappers.lambda）
     */
    List<UserDTO> mpjWrappersLambdaJoin();

    /**
     * MPJWrappers.queryJoin 工厂链（字符串列）
     */
    List<Map<String, Object>> mpjWrappersQueryJoin();

    /**
     * JoinWrappers.update 工厂 + setIncrBy + updateAndNull 终结
     */
    int updateJoinAndNull(Integer userId);

    /**
     * Chain 终结点：first(Class) / one() / count()
     */
    Map<String, Object> terminalFirstOneCount(Integer userId);

    /**
     * Chain 终结点：mapOne / mapFirst / mapList
     */
    List<Map<String, Object>> terminalMapFamily(Integer maxAge);

    /**
     * Chain 终结点：mapPage 分页
     */
    com.baomidou.mybatisplus.extension.plugins.pagination.Page<Map<String, Object>> terminalMapPage(long current, long size);

    /**
     * 构造别名：new MPJLambdaWrapper<>(UserDO.class, "u")
     */
    List<UserDTO> constructorAlias();

    /**
     * 字符串 join {0} 参数替换（leftJoin(String, Object...)）
     */
    List<UserDTO> joinWithPlaceholder(String tel);

    /**
     * 分页 searchCount 布尔形态（插件 R12 Wrapper 面）：selectJoinMapsPage /
     * selectJoinPage 的 Page 构造器第三参布尔识别——false 时不产 COUNT 包裹语句
     */
    Map<String, Object> pageSearchCountForms(long current, long size);
}
