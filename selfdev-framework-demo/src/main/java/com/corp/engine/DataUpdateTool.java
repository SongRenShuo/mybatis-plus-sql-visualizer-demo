package com.corp.engine;

import com.corp.meta.FilterExpression;
import com.corp.meta.PaginQuery;
import com.corp.meta.PaginResult;

import java.util.List;
import java.util.Map;

/**
 * 自研框架数据访问门面（**汇聚入口**）：业务侧全部 SQL 都经此发出。
 *
 * <p>本类是「跳转恒落框架方法」现象的核心——它在调用栈中位于业务帧之下、引擎帧之上，
 * 且所有业务调用共用同一批方法名，因此成为最显眼的误选目标。
 * 在插件设置「源码捕获帧过滤前缀」登记 {@code com.corp.engine.} 后，本类与引擎其余帧一并被跳过，
 * 主位置回到真实业务调用行。
 *
 * <p>刻意做成静态门面（而非 Spring Bean）：真实自研框架的入口常是静态工具类，
 * 也让「不经 MyBatis、无拦截点、只能靠 agent 增强捕获」这一前提成立。
 *
 * @author SongRenShuo
 */
public final class DataUpdateTool {

    private static volatile EngineHolder holder;

    private DataUpdateTool() {
    }

    /** 由框架装配期注入引擎（{@code EngineConfiguration} 调用）。 */
    public static void init(EngineHolder engineHolder) {
        holder = engineHolder;
    }

    private static LocalDbService db() {
        EngineHolder current = holder;
        if (current == null) {
            throw new EngineException("引擎未初始化：请确认 EngineConfiguration 已装配");
        }
        return current.getLocalDbService();
    }

    // ==================== 查询 ====================

    /** 按条件查询列表。 */
    public static List<Map<String, Object>> findByFilter(String schemaCode, FilterExpression filter) {
        return db().queryList(schemaCode, filter);
    }

    /** 按条件查询单条。 */
    public static Map<String, Object> findOneByFilter(String schemaCode, FilterExpression filter) {
        return db().queryOne(schemaCode, filter);
    }

    /** 按条件计数。 */
    public static long countByFilter(String schemaCode, FilterExpression filter) {
        return db().count(schemaCode, filter);
    }

    /** 按条件查询（排序 + 限制）。 */
    public static List<Map<String, Object>> findByFilterOrdered(String schemaCode, FilterExpression filter,
                                                                String orderBy, int limit) {
        return db().queryListOrdered(schemaCode, filter, orderBy, limit);
    }

    /** 按分组字段统计。 */
    public static List<Map<String, Object>> groupSummary(String schemaCode, FilterExpression filter,
                                                         String groupField) {
        return db().queryGroupSummary(schemaCode, filter, groupField);
    }

    /** 按条件分页查询。 */
    public static <T> PaginResult<T> findByFilterPaged(String schemaCode, FilterExpression filter,
                                                       PaginQuery page, Class<T> resultType) {
        return db().queryPage(schemaCode, filter, page, resultType);
    }

    // ==================== 链式 / 回调 ====================

    /** 链式查询起点。 */
    public static DataQuery query(String schemaCode) {
        return new DataQuery(schemaCode);
    }

    /** 回调模板：把 schema 上下文交给业务回调（lambda / 匿名内部类两种写法）。 */
    public static <T> T executeInSchema(String schemaCode, QueryCallback<T> callback) {
        return callback.apply(new QueryContext(schemaCode, db()));
    }

    /** 取门面接口（JDK 动态代理形态）。 */
    public static DataAccessFacade facade() {
        EngineHolder current = holder;
        if (current == null) {
            throw new EngineException("引擎未初始化：请确认 EngineConfiguration 已装配");
        }
        return current.getFacade();
    }

    // ==================== 写入 ====================

    /** 按条件更新。 */
    public static int updateByFilter(String schemaCode, FilterExpression filter,
                                     Map<String, Object> values) {
        return db().update(schemaCode, filter, values);
    }

    /** 按条件删除。 */
    public static int deleteByFilter(String schemaCode, FilterExpression filter) {
        return db().delete(schemaCode, filter);
    }
}
