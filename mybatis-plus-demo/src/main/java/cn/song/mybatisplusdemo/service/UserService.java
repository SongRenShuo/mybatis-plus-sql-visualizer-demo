package cn.song.mybatisplusdemo.service;

import cn.song.mybatisplusdemo.common.PageQuery;
import cn.song.mybatisplusdemo.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 用户表(User)服务层
 *
 * @author SongRenShuo
 */
public interface UserService extends IService<User> {

    /**
     * LambdaQueryWrapper 组合条件查询
     */
    List<User> listByLambdaQuery(User query);

    /**
     * LambdaQueryWrapper 嵌套 and/or 条件查询
     */
    List<User> listByNestedCondition(String username, Integer minAge, Integer maxAge);

    /**
     * QueryWrapper 字符串列名查询（select/groupBy/having/orderBy）
     */
    List<Map<String, Object>> listMapsByQueryWrapper(Integer roleId);

    /**
     * LambdaQueryWrapper 模糊/区间/IN 查询
     */
    List<User> listByLikeAndBetween(String keyword, Integer ageStart, Integer ageEnd, List<Integer> ids);

    /**
     * QueryWrapper exists / notExists 子查询
     */
    List<User> listByExists(String emailDomain);

    /**
     * LambdaUpdateWrapper 动态更新（set + setSql + 条件）
     */
    boolean updateByLambdaUpdateWrapper(Integer status, Integer minAge);

    /**
     * UpdateWrapper 字符串列名更新
     */
    boolean updateByUpdateWrapper(String email, Integer roleId);

    /**
     * LambdaDeleteWrapper 删除（含嵌套条件）
     */
    boolean removeByLambdaDeleteWrapper(Integer status, Integer maxAge);

    /**
     * Wrappers.lambdaQuery 链式查询
     */
    List<User> listByWrappersLambda(String username);

    /**
     * lambdaQuery 链式 + last 分页截断
     */
    List<User> listByChainLambda(String username);

    /**
     * 分页查询（selectPage）
     */
    IPage<User> pageByWrapper(PageQuery pageQuery, User query);

    /**
     * selectCount 统计
     */
    long countByWrapper(String username, Integer status);

    /**
     * selectOne 单条查询
     */
    User getOneByWrapper(String username);

    /**
     * 批量操作：批量插入 / 批量更新
     */
    boolean batchSaveAndUpdate(List<User> users);

    /**
     * 乐观锁更新（@Version）
     */
    boolean updateWithVersion(User user);

    /**
     * 注解 SQL 查询
     */
    User selectByAnnotationId(Integer id);

    /**
     * XML 动态 SQL 查询
     */
    List<User> selectUserListByXml(String username, Integer status, Integer age);
}
