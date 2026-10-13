package cn.song.embedprefixdemo.dao;

import java.util.List;

/**
 * 老式自定义 DAO 接口（无 Spring Data 注解）——与 jpa-hibernate-demo 的 CommonDao 同形态。
 *
 * 插件 SQL Visualizer 的「自定义 DAO HQL 识别」针对此形态：qualifier 变量名以
 * Dao/DaoImpl/CommonDao 等结尾 + 方法名含 Query 关键字 + 首参 HQL 内容匹配。
 *
 * @author SongRenShuo
 */
public interface CommonDao {

    /**
     * 查询列表（name-value 交替传参）。
     */
    <T> List<T> findByQuery(String hql, Object... params);

    /**
     * 分页查询（名字数组 + 值数组双数组传参）——**用户报障调用的同款形态**：
     * `commonDao.findByQueryMaxNum(hql, new String[]{...}, new Object[]{...}, 0, 10)`。
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
