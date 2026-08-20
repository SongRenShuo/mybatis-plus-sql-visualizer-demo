package cn.song.mybatisplusdemo.service;

import cn.song.mybatisplusdemo.common.PageQuery;
import cn.song.mybatisplusdemo.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Map;

/**
 * Wrapper 扩展写法服务层（补充各种写法和场景）
 *
 * @author SongRenShuo
 */
public interface WrapperExtService {

    /**
     * eqSql / neSql / gtSql / geSql / ltSql / leSql：SQL 片段直拼
     */
    List<User> listBySqlFragment(Integer minAge);

    /**
     * inSql / notInSql：IN 子查询 SQL
     */
    List<User> listByInSql();

    /**
     * apply + last + exists / notExists（带参数）
     */
    List<User> listByApplyAndExists(String emailDomain);

    /**
     * allEq：Map 等值条件（null2IsNull 参数）
     */
    List<User> listByAllEq(Map<String, Object> params);

    /**
     * not + nested 多层嵌套
     */
    List<User> listByNotAndNested(String username, Integer roleId);

    /**
     * select 排除字段 + selectObjs / selectMaps
     */
    List<Object> listObjsBySelectExclude();

    /**
     * 链式 lambdaQuery：count / list / one
     */
    Long countByChain(String username);

    /**
     * 链式 lambdaUpdate：set + eq + update
     */
    boolean updateByChain(Integer id, Integer status);

    /**
     * 链式 lambdaUpdate：eq + remove（替代 LambdaDeleteWrapper 的链式写法）
     */
    boolean removeByChain(Integer status);

    /**
     * 显式 LambdaDeleteWrapper
     */
    boolean removeByLambdaDelete(Integer maxAge, List<Integer> roleIds);

    /**
     * IService 更多方法：saveOrUpdate / saveOrUpdateBatch / listByIds / listByMap / removeByIds
     */
    Map<String, Object> iserviceMore(User user, List<Integer> ids, Map<String, Object> columnMap);

    /**
     * getOne 不抛异常（selectOne 多记录时）
     */
    User getOneSilent(String username);

    /**
     * XML 一对多：用户 + 部门 + 订单列表（resultMap association + collection）
     */
    List<User> selectUserWithOrdersXml(Integer status);

    /**
     * XML 自定义分页查询（IPage 参数自动分页）
     */
    IPage<User> pageByXml(PageQuery pageQuery, Integer status);

    /**
     * XML 多参数查询（@Param 多个 + if）
     */
    List<User> selectByMultiParamXml(String username, Integer status, Integer minAge);

    /**
     * XML Map 参数查询（Map 作为唯一参数）
     */
    List<User> selectByMapParamXml(Map<String, Object> params);
}
