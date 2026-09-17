package cn.song.mybatisplusdemo.service;

import cn.song.mybatisplusdemo.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Wrapper 高级定位与补充形态服务层
 * 对应插件 WrapperLocator 高级识别形态（跨方法工厂链 / helper 就地修改 / clear 截断 / if-else 互斥分支 / lambda 转换）
 * 与 MP 3.5.7 解锁语料（select 谓词过滤 / allEq boolean 重载 / 实体驱动 SET / notLike 族）
 *
 * @author SongRenShuo
 */
public interface WrapperAdvancedCoverageService {

    /**
     * 跨方法工厂链：私有工厂方法返回 Wrapper，调用方续链终结
     */
    List<User> factoryChainAcrossMethods(Integer minAge);

    /**
     * helper 方法就地修改 wrapper：实参传入 helper 内续链
     */
    List<User> helperModifiedWrapper(String username, Integer roleId);

    /**
     * clear() 截断后重建条件
     */
    List<User> clearThenRebuild(Integer status, Integer deptId);

    /**
     * if/else 互斥分支挂条件（插件只取 then 分支）
     */
    List<User> exclusiveBranchQuery(Integer status, Integer deptId);

    /**
     * 字符串版 wrapper.lambda() 转 lambda 续链
     */
    List<User> stringWrapperToLambda(Integer status, Integer minAge);

    /**
     * 分步续链：new 后分句 select/in/eq/orderBy
     */
    List<User> stepByStepBuild(Integer deptId, List<Integer> roleIds);

    /**
     * select(Class, Predicate)：字段谓词过滤（排除 password 列）
     */
    List<User> selectByFieldPredicate(Integer status);

    /**
     * allEq(Map, boolean)：null 值不生成 IS NULL
     */
    List<User> allEqNullableOff(Map<String, Object> params);

    /**
     * 实体驱动 SET：update(entity, wrapper) 非空字段生成 SET 子句
     */
    int updateByEntitySet(Integer id, String email, Integer status);

    /**
     * 实体驱动 SET：new UpdateWrapper<>(entity) 构造器形态
     */
    int updateByWrapperEntityConstructor(Integer id, Integer age);

    /**
     * notLikeLeft / notLikeRight / notLike 三族
     */
    List<User> notLikeFamily(String fragment);

    /**
     * insertBatchSomeColumn：自定义注入器批量插入（调用点语料）
     */
    int batchInsertSome(List<User> users);
}
