package cn.song.mybatisplusdemo.service;

import cn.song.mybatisplusdemo.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Wrapper 条件方法全覆盖服务（补齐 WrapperExtService 未覆盖的 API 形态）
 *
 * @author SongRenShuo
 */
public interface WrapperFullCoverageService {

    /**
     * like 族补全：likeLeft / notLike / notLikeLeft / notLikeRight
     */
    List<User> listByLikeFamily(String keyword);

    /**
     * notBetween / isNotNull / ge / lt 基础条件补全
     */
    List<User> listByRangeConditions(Integer low, Integer high);

    /**
     * geSql / ltSql（SQL 片段直拼补全）
     */
    List<User> listBySqlFragmentExt(String minAmount);

    /**
     * or 细粒度嵌套：or(Consumer) 与 or() 连缀混合
     */
    List<User> listByOrNesting(String username, Integer status);

    /**
     * func：多条件 consumer 批量接入（boolean 开关形态）
     */
    List<User> listByFuncConsumer(String username, Integer age);

    /**
     * applyFunc：列占位 %s + 参数 {0} 直拼（MP AbstractWrapper 无此 API，改用 MPJ 场景演示；
     * 此处演示 apply 多参数占位 {0}/{1} 与 exists {0} 参数化）
     */
    List<User> listByApplyParams(Integer years, Integer roleId);

    /**
     * first / comment / last 三段直拼（3.5.3+）
     */
    List<User> listByFirstCommentLast(String keyword);

    /**
     * groupBy 多列 + having 多条件 + orderBy 多列混排
     */
    List<Map<String, Object>> groupByMultiColumn(Integer minAge);

    /**
     * UpdateWrapper 全条件形态：set(set true 开关)/setSql/in/notIn/between/notBetween/isNotNull 嵌套
     */
    int updateByFullConditions(List<Integer> roleIds, String emailSuffix);

    /**
     * LambdaDeleteWrapper 显式形态（条件删除）
     */
    int deleteByLambdaDeleteWrapper(Integer status, String email);
}
