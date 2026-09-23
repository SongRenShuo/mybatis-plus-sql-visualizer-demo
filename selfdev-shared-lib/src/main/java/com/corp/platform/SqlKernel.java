package com.corp.platform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

/**
 * 平台 SQL 内核（**运行期来自依赖 JAR**）：自研框架真正触碰 JDBC 的最深一层。
 *
 * <p>与 demo 侧的目录态同构类 {@code cn.song.selfdevdemo.kernel.PlanTreeKernel} 逐行等价，
 * 唯一差异是打包形态（JAR vs {@code target/classes} 目录）——这个差异正是 E 组用例的自变量：
 * 插件 agent 的 L1 来源过滤按 {@code ProtectionDomain.codeSource} 判「JAR = 第三方」，
 * 于是本类及其上层帧会被整条跳过，主位置一路向上顶到第一个目录帧。
 *
 * <p>本类**刻意不登记进**「源码捕获帧过滤前缀」，用来复现真实项目里
 * 「用户只登记了公司工具库包名，平台内核包名仍在候选池中」的现场：
 * 此时缓存 key（首个非框架帧的 {@code class#method}）在全应用范围内共享同一个值。
 *
 * @author SongRenShuo
 */
public final class SqlKernel {

    private static volatile DataSource dataSource;

    private SqlKernel() {
    }

    /** 由应用装配期注入数据源（模拟框架自带的 auto-configuration）。 */
    public static void init(DataSource target) {
        dataSource = target;
    }

    /**
     * 按负责人查询计划列表。
     *
     * <p>E29 构建器的第一个调用点。
     */
    public static List<Map<String, Object>> queryPlansByOwner(String owner) {
        String sql = "SELECT p.plan_id, p.project_name, p.owner, p.status, p.amount"
                + " FROM biz_project_plan p WHERE p.owner = ? AND p.status <> 0 ORDER BY p.amount DESC";
        return execute(sql, Collections.<Object>singletonList(owner));
    }

    /**
     * 按计划编号集合批量查询成员。
     *
     * <p>E29 构建器的第二个调用点——与上一个调用点同处一个业务方法内，
     * 用于观察「同一 key 下两条 SQL」的落点是否互相串位。
     */
    public static List<Map<String, Object>> queryMembersByPlanIds(List<String> planIds) {
        if (planIds == null || planIds.isEmpty()) {
            return Collections.emptyList();
        }
        StringBuilder sql = new StringBuilder("SELECT m.plan_id, m.member_name, m.role"
                + " FROM biz_project_member m WHERE m.plan_id IN (");
        appendPlaceholders(sql, planIds.size()).append(") ORDER BY m.id");
        return execute(sql.toString(), new ArrayList<Object>(planIds));
    }

    /**
     * 按编号集合批量查询计划。
     *
     * <p>E30 / E31 两个**不同调用方**共用的入口：两条链在此处的栈形完全同构，
     * 因此「首个非框架帧」的 {@code class#method} 相同——整帧缓存即在此处把先触发者的
     * 位置服务给后触发者。
     */
    public static List<Map<String, Object>> queryPlansByIds(List<String> planIds) {
        if (planIds == null || planIds.isEmpty()) {
            return Collections.emptyList();
        }
        StringBuilder sql = new StringBuilder("SELECT p.plan_id, p.project_name, p.owner, p.status"
                + " FROM biz_project_plan p WHERE p.plan_id IN (");
        appendPlaceholders(sql, planIds.size()).append(") ORDER BY p.id");
        return execute(sql.toString(), new ArrayList<Object>(planIds));
    }

    private static StringBuilder appendPlaceholders(StringBuilder sql, int count) {
        for (int i = 0; i < count; i++) {
            sql.append(i == 0 ? "?" : ", ?");
        }
        return sql;
    }

    /**
     * 执行查询并逐行转 Map。
     *
     * <p>{@code executeQuery()} 在本方法内发出，故<b>本类本方法才是 SQL 执行时刻的最深 JAR 帧</b>——
     * 真实平台内核同样是「一个共享 execute」。其后果见类注释：三个入口在内核未登记前缀时共用
     * 同一个缓存 key，E29/E30/E31 在该档位下会互相串位（合流缺陷的放大器，非语料缺陷）。
     */
    private static List<Map<String, Object>> execute(String sql, List<Object> args) {
        DataSource current = dataSource;
        if (current == null) {
            throw new IllegalStateException("SqlKernel 未初始化：请确认 SharedLibConfiguration 已装配");
        }
        try (Connection connection = current.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < args.size(); i++) {
                statement.setObject(i + 1, args.get(i));
            }
            try (ResultSet rs = statement.executeQuery()) {
                return toRows(rs);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("平台内核执行失败: " + e.getMessage(), e);
        }
    }

    private static List<Map<String, Object>> toRows(ResultSet rs) throws SQLException {
        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
        ResultSetMetaData meta = rs.getMetaData();
        int columns = meta.getColumnCount();
        while (rs.next()) {
            Map<String, Object> row = new LinkedHashMap<String, Object>();
            for (int i = 1; i <= columns; i++) {
                row.put(meta.getColumnLabel(i), rs.getObject(i));
            }
            rows.add(row);
        }
        return rows;
    }
}
