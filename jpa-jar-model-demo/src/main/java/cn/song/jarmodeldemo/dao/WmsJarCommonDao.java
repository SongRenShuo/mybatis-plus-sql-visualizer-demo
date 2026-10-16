package cn.song.jarmodeldemo.dao;

import java.util.List;

/**
 * 老式自定义 DAO 接口（无 Spring Data 注解）——实体在 JAR 里，SQL 却在宿主模块源码里，
 * 这正是插件「自定义 DAO HQL 识别」要处理的形态：qualifier 变量名以 Dao 结尾 +
 * 方法名含 Query 关键字 + 首参内容像 HQL。
 *
 * @author SongRenShuo
 */
public interface WmsJarCommonDao {

    /**
     * 查询列表（name-value 交替传参）。
     */
    <T> List<T> findByQuery(String hql, Object... params);

    /**
     * 分页查询（名字数组 + 值数组双数组传参）。
     *
     * @param hql         HQL 查询语句
     * @param paramNames  参数名数组
     * @param paramValues 参数值数组
     * @param start       起始行（&lt;=0 表示不设）
     * @param max         最大行数（&lt;=0 表示不设）
     */
    List<?> findByQueryMaxNum(String hql, String[] paramNames, Object[] paramValues, int start, int max);

    /**
     * 保存（供演示数据 seed 用）。
     */
    void save(Object entity);
}
