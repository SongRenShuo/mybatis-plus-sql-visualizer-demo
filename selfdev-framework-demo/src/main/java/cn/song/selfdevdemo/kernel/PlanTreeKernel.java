package cn.song.selfdevdemo.kernel;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 平台 SQL 内核的<b>目录态同构类</b>（E28 控制组）。
 *
 * <p>与 JAR 态的 {@code com.corp.platform.SqlKernel} 逐行等价，唯一差异是打包形态：
 * 本类随应用编译进 {@code target/classes}，其 {@code ProtectionDomain.codeSource} 是目录。
 *
 * <p>两相对照即可把「主位置为什么会上顶到调用方」的自变量收敛到唯一一个：
 * <b>帧来源是目录还是 JAR</b>——与包名、与是否登记前缀都无关。
 *
 * <p>本类属业务工程内的编排层，形态上仍是「框架帧」：验证时应把它（包根
 * {@code cn.song.selfdevdemo.kernel.}）登记进「源码捕获帧过滤前缀」，
 * 与 JAR 组登记 {@code com.corp.platform.} 保持对称。
 *
 * @author SongRenShuo
 */
@Component
public class PlanTreeKernel {

    private final DataSource dataSource;

    @Autowired
    public PlanTreeKernel(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 按负责人查询计划列表。
     *
     * <p>E28 构建器的第一个调用点。
     */
    public List<Map<String, Object>> queryPlansByOwner(String owner) {
        String sql = "SELECT p.plan_id, p.project_name, p.owner, p.status, p.amount"
                + " FROM biz_project_plan p WHERE p.owner = ? AND p.status <> 0 ORDER BY p.amount DESC";
        return execute(sql, Collections.<Object>singletonList(owner));
    }

    /**
     * 按计划编号集合批量查询成员。
     *
     * <p>E28 构建器的第二个调用点——与上一个调用点同处一个业务方法内，
     * 用于观察「同一 key 下两条 SQL」的落点是否互相串位。
     */
    public List<Map<String, Object>> queryMembersByPlanIds(List<String> planIds) {
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
     * <p>目录态的「多调用方共用入口」，与 {@code SqlKernel#queryPlansByIds} 同构——
     * 登记 {@code cn.song.selfdevdemo.kernel.} 后与 E30/E31 对照，
     * 可看出合流是否只发生在 JAR 侧（答案是否：与来源无关，只与 key 粒度有关）。
     */
    public List<Map<String, Object>> queryPlansByIds(List<String> planIds) {
        if (planIds == null || planIds.isEmpty()) {
            return Collections.emptyList();
        }
        StringBuilder sql = new StringBuilder("SELECT p.plan_id, p.project_name, p.owner, p.status"
                + " FROM biz_project_plan p WHERE p.plan_id IN (");
        appendPlaceholders(sql, planIds.size()).append(") ORDER BY p.id");
        return execute(sql.toString(), new ArrayList<Object>(planIds));
    }

    /**
     * 执行查询并逐行转 Map。
     *
     * <p>{@code executeQuery()} 在本方法内发出，故<b>本方法才是 SQL 执行时刻的最深帧</b>——
     * 三个公开入口共享同一个「首个非框架帧」（未登记本包前缀时），合流面因此覆盖全应用。
     */
    private List<Map<String, Object>> execute(String sql, List<Object> args) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < args.size(); i++) {
                statement.setObject(i + 1, args.get(i));
            }
            try (ResultSet rs = statement.executeQuery()) {
                return toRows(rs);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("目录态内核执行失败: " + e.getMessage(), e);
        }
    }

    private List<Map<String, Object>> toRows(ResultSet rs) throws SQLException {
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

    private static StringBuilder appendPlaceholders(StringBuilder sql, int count) {
        for (int i = 0; i < count; i++) {
            sql.append(i == 0 ? "?" : ", ?");
        }
        return sql;
    }
}
