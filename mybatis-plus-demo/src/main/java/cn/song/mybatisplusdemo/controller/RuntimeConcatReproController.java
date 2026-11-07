package cn.song.mybatisplusdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 运行期拼接 SQL 的预览复现用例（T-RuntimeConcatAndDeleteNull，发行 v2026.11.6-beta.2）
 *
 * <p><b>用户原例</b>（InfluxDB / InfluxQL，插件把 Java 源码当成了活 SQL）：
 * <pre>
 * StringBuilder idStr = new StringBuilder();
 * for (int k = 0; k &lt; ids.size(); k++) {
 *     idStr.append(k == 0 ? "id='" + ids.get(k) + "' " : "or id='" + ids.get(k) + "' ");
 * }
 * String sql = "SELECT * FROM hplt.autogen.calpoint " +
 *     " WHERE (" + idStr + ") and time >= '" + startTime + "' tz('Asia/Shanghai')";
 * </pre>
 *
 * <p><b>修复前的预览</b>：三元表达式原文被当成活 SQL；运行期片段被包成「当场闭合的块注释 + 原样 Java 源码 +
 * 悬空结束符」，源码里的引号再把词法器带偏——{@code WHERE (...)} 的右括号与引号被吃掉，预览不可执行。
 *
 * <p><b>修复后的预期</b>：运行期片段收口为一条合法块注释（形如 {@code 运行时值: 清洗后表达式}），注释不外溢、
 * 不出现悬空结束符；{@code WHERE (...)} 的括号与引号完整；循环内 append 降级为「运行时重复执行」占位；
 * 三元表达式按常量条件取分支 / 两支同文折叠 / 其余单占位。
 *
 * <p><b>怎么复现</b>：打开本文件，在 {@link #listByLoopTernary} 的 {@code String sql = ...} 行（或
 * {@code jdbcTemplate.queryForList(sql)} 行）看左侧 gutter 的预览图标 → 打开预览；对照上面两段预期。
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/runtimeConcat")
public class RuntimeConcatReproController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 用例 1：用户原例骨架——循环 + 三元 append + 括号内拼接 + 末尾字面量条件。
     *
     * <p>预览关注点：循环里的 ternary append 不再以源码形态出现在 SQL 中；{@code WHERE (...)} 的右括号
     * 与后面的 {@code and create_time >= ...} 之间的空白/括号完整。
     *
     * <p>GET /runtimeConcat/loopTernary?ids=1,2&startTime=2026-01-01%2000:00:00
     *
     * <p><b>填值后期望 SQL</b>（循环值 `1,2,3`、startTime `2026-01-01 00:00:00`）：
     * {@code WHERE (id='1' or id='2' or id='3' ) and create_time >= '2026-01-01 00:00:00'}，
     * 无残留占位注释。
     */
    @GetMapping("/loopTernary")
    public List<Map<String, Object>> listByLoopTernary(@RequestParam List<Long> ids,
                                                       @RequestParam(required = false) String startTime) {
        StringBuilder idStr = new StringBuilder();
        for (int k = 0; k < ids.size(); k++) {
            idStr.append(k == 0 ? "id='" + ids.get(k) + "' " : "or id='" + ids.get(k) + "' ");
        }
        String sql = "SELECT id, order_no, user_id, amount, create_time FROM t_order " +
                " WHERE (" + idStr + ") and create_time >= '" + startTime + "'";
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 用例 2：字符串层面的三元分支（不是 append，而是 {@code String + ternary} 的拼接形态）。
     *
     * <p>预览关注点：{@code status == null ? "" : " AND status = " + status} 不被原样当 SQL，而是取分支或占位；
     * 后面的 {@code ORDER BY} 与 LIKE 条件保持完整。
     *
     * <p>GET /runtimeConcat/ternaryBranch?keyword=NO&status=1
     *
     * <p><b>填值后期望 SQL</b>（选「假分支」、status `1`、keyword `NO`）：
     * {@code WHERE 1 = 1 AND status = 1 AND order_no LIKE '%NO%'}；参数区**不应**出现 `#param1`
     * ——三元占位注释里的 `?` 是 Java 问号，不是 JDBC 占位符（T-RuntimeSlotOptionalFill）。
     */
    @GetMapping("/ternaryBranch")
    public List<Map<String, Object>> listByTernaryBranch(@RequestParam String keyword,
                                                         @RequestParam(required = false) Integer status) {
        String sql = "SELECT id, order_no, status FROM t_order WHERE 1 = 1 " +
                (status == null ? "" : " AND status = " + status) +
                " AND order_no LIKE '%" + keyword + "%' " +
                " ORDER BY id DESC";
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 用例 3：StringBuilder + 可选 if 片段（控制流感知：条件不成立时不把片段当必选拼进去）。
     *
     * <p>预览关注点：可选条件以注释标记呈现，不与被跳过的分支线性拼接；末尾 {@code ORDER BY} 不被吞。
     *
     * <p>GET /runtimeConcat/optionalIf?keyword=NO&minAmount=100
     *
     * <p><b>填值后期望 SQL</b>（勾选两段、keyword `111`、minAmount `111`）：
     * {@code WHERE deleted = 0 AND order_no LIKE '%111%' AND amount >= 111}——keyword 落在模板引号内
     * 只转义不补外层引号，minAmount 就地填值、**不得**出现 `AND amount >=` 悬空/重复行；
     * 取消「包含这段」→ 对应整段消失，`ORDER BY` 仍在（T-RuntimeSlotOptionalFill）。
     */
    @GetMapping("/optionalIf")
    public List<Map<String, Object>> listByOptionalIf(@RequestParam(required = false) String keyword,
                                                      @RequestParam(required = false) Integer minAmount) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, order_no, amount FROM t_order WHERE deleted = 0 ");
        if (keyword != null && !keyword.isEmpty()) {
            sql.append("AND order_no LIKE '%").append(keyword).append("%' ");
        }
        if (minAmount != null) {
            sql.append("AND amount >= ").append(minAmount).append(" ");
        }
        sql.append("ORDER BY id DESC");
        return jdbcTemplate.queryForList(sql.toString());
    }
}
