package cn.song.jpademo.dao;

import java.util.List;

/**
 * 老式自定义 DAO 接口（无 Spring Data 注解）。
 *
 * 插件 SQL Visualizer 的「自定义 DAO HQL 识别」针对此形态：
 * qualifier 变量名以 Dao/DaoImpl/CommonDao 等结尾 + 方法名含 Query/Hql/execute 关键字
 * + 首参 HQL 内容匹配（SELECT…FROM / UPDATE…SET / DELETE…FROM / FROM Entity）。
 *
 * @author SongRenShuo
 */
public interface CommonDao {

    /**
     * 查询唯一结果（名字数组 + 值数组双数组传参）。
     *
     * 对应 Spring 老代码 `findByQueryUniqueResult(hql, new String[]{...}, new Object[]{...})`，
     * 插件以 NAME_VALUE_ARRAYS 模式解析参数名与值。
     *
     * @param hql        HQL 查询语句
     * @param paramNames 参数名数组
     * @param paramValues 参数值数组
     * @return 唯一结果（Object[] 行或单值）
     */
    Object findByQueryUniqueResult(String hql, String[] paramNames, Object[] paramValues);

    /**
     * 查询列表（变长参数：name-value 交替传参或位置传参）。
     *
     * @param hql    HQL 查询语句
     * @param params (name1, value1, name2, value2) 交替 或 位置值序列
     * @param <T>    行类型
     * @return 结果列表
     */
    <T> List<T> findByQuery(String hql, Object... params);

    /**
     * HQL UPDATE/DELETE 执行（name-value 交替传参）。
     *
     * @param hql    HQL 更新/删除语句
     * @param params (name1, value1, name2, value2) 交替
     * @return 受影响行数
     */
    int execute(String hql, Object... params);

    /**
     * 命名参数查询（名字数组 + 值数组，HibernateTemplate.findByNamedParam 风格）。
     *
     * @param hql        HQL 查询语句
     * @param paramNames 参数名数组
     * @param paramValues 参数值数组
     * @return 结果列表
     */
    List<?> findByNamedParam(String hql, String[] paramNames, Object[] paramValues);
}