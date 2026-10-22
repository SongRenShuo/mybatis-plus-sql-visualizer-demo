package com.example.shadow.dao;

import java.util.List;

/**
 * 老式自定义 DAO 接口（无 Spring Data 注解）——<b>接口本身在 JAR 里</b>。
 *
 * <p>方法签名照搬用户报障形态：{@code <T> List<T> findByQuery(String hql, String[] paramNames, Object[] values)}
 * ——名字数组 + 值数组双数组传参。插件 SQL Visualizer 的「自定义 DAO HQL 识别」按
 * 「qualifier 变量名以 Dao 结尾 + 方法名含 Query 关键字 + 首参内容像 HQL」认领这条调用。
 *
 * @author SongRenShuo
 */
public interface CommonDao {

    /**
     * 查询列表（名字数组 + 值数组双数组传参）。
     *
     * @param hql         HQL 查询语句
     * @param paramNames  参数名数组
     * @param paramValues 参数值数组
     */
    <T> List<T> findByQuery(String hql, String[] paramNames, Object[] values);
}
