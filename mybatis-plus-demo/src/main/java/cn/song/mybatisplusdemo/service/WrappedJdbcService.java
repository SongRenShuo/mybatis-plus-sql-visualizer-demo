package cn.song.mybatisplusdemo.service;

import java.util.List;
import java.util.Map;

/**
 * 封装工具类的 JDBC SQL 预览示例服务接口
 * 演示 SQL 不直接调用 JdbcTemplate，而是通过 DbHelper/BeanCruder 等封装层执行
 *
 * @author SongRenShuo
 */
public interface WrappedJdbcService {

    /**
     * 1. 通过 DbHelper 查询列表（命名参数）
     */
    List<Map<String, Object>> queryUserByDbHelper(String username, Integer status);

    /**
     * 2. 通过 DbHelper 查询单条
     */
    Map<String, Object> queryOneUserByDbHelper(Integer id);

    /**
     * 3. 通过 DbHelper 动态 SQL 查询
     */
    List<Map<String, Object>> dynamicQueryByDbHelper(String keyword, List<Integer> roleIds);

    /**
     * 4. 通过 DbHelper 分页查询
     */
    Map<String, Object> paginationByDbHelper(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 5. 通过 DbHelper 插入
     */
    int insertByDbHelper(String username, String password, Integer age, Integer roleId);

    /**
     * 6. 通过 DbHelper 更新
     */
    int updateByDbHelper(Integer id, String email, Integer status);

    /**
     * 7. 通过 DbHelper 删除
     */
    int deleteByDbHelper(Integer id);

    /**
     * 8. 通过 DbHelper 批量插入
     */
    int[] batchInsertByDbHelper(List<List<Object>> users);

    /**
     * 9. 通过 DbHelper 复杂 JOIN 查询
     */
    List<Map<String, Object>> complexJoinByDbHelper(Integer minAge);

    /**
     * 10. 通过 DbHelper 分组统计
     */
    List<Map<String, Object>> groupByByDbHelper();
}
