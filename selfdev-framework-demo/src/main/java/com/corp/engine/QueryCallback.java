package com.corp.engine;

/**
 * 自研框架查询回调（函数式接口）：lambda 与匿名内部类两种书写形态共用。
 *
 * @author SongRenShuo
 * @param <T> 回调返回值类型
 */
@FunctionalInterface
public interface QueryCallback<T> {

    /** 在指定 schema 上下文中执行。 */
    T apply(QueryContext context);
}
