package cn.song.mybatisplusdemo.controller;

import cn.song.mybatisplusdemo.entity.User;
import cn.song.mybatisplusdemo.mapper.UserMapper;
import cn.song.mybatisplusdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 控制台捕获 / 历史 / 屏蔽 / 徽章喂料语料（插件 R10/O-90/T-SqlSuppress/T-SqlLogPerf/R3 回归用）
 *
 * <p>端点分三类：
 * <ul>
 *   <li><b>真实执行喂料</b>（n1/heartbeat/storm/dateParam）——走 MyBatis/JdbcTemplate 真链路，
 *       StdOutImpl 日志与增强捕获双通道都能吃到；</li>
 *   <li><b>ShardingSphere 双段格式打印</b>（shardingSphere/ssCommaParam）——按插件
 *       ShardingSphereLogParser 实现的 5.x sql-show 文档形态打印（{@code Logic SQL:} 主行 +
 *       {@code Actual SQL: ds_x ::: ... ::: Parameters: [..]} 附注行），喂 R10 解析器骨架；
 *       插件侧注明真实语料未采样，若与真机格式有差以真机为准再校正本喂料。</li>
 * </ul>
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/logFeed")
public class LogFeederController {

    private static final Logger SS_LOG = LoggerFactory.getLogger("ShardingSphere-SQL");

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * N+1 同模板喂料（O-90 徽章）：循环 getById，同结构模板 ≥3 条后日志/历史面板应出现「×N 同模板」琥珀徽章
     */
    @GetMapping("/n1")
    public String n1(@RequestParam(defaultValue = "1,2,3,4,5") String ids) {
        StringBuilder sb = new StringBuilder();
        for (String s : ids.split(",")) {
            int id = Integer.parseInt(s.trim());
            User user = userService.getById(id);
            sb.append(id).append("->").append(user == null ? "null" : user.getUsername()).append("; ");
        }
        return sb.toString();
    }

    /**
     * 心跳 SQL 喂料（T-SqlSuppress 屏蔽）：循环 SELECT 1——右键「屏蔽此 SQL」后该行应即刻消失且计数递增
     */
    @GetMapping("/heartbeat")
    public String heartbeat(@RequestParam(defaultValue = "6") int times,
                            @RequestParam(defaultValue = "500") long intervalMs) throws InterruptedException {
        int bounded = Math.min(Math.max(times, 1), 60);
        long interval = Math.min(Math.max(intervalMs, 100L), 5000L);
        for (int i = 0; i < bounded; i++) {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            if (i < bounded - 1) {
                Thread.sleep(interval);
            }
        }
        return "heartbeat x" + bounded;
    }

    /**
     * 日志风暴喂料（T-SqlLogPerf 性能面）：同模板不同参数按目标 QPS 灌入——验证列表跟随滚动/停止跟随、历史加载
     *
     * <p>用 {@code queryForList} 而非 {@code queryForObject}：序号一路递增必然越过表中现存主键，
     * 命中 0 行时 queryForObject 抛 EmptyResultDataAccessException，会把控制台刷满异常栈
     * （录制/演示时两侧画面都被污染），而本端点只关心「同形状 SQL 按参数高频灌入」，
     * 结果集空不空不影响模拟。SQL 文本与占位符形态保持不变。
     */
    @GetMapping("/storm")
    public String storm(@RequestParam(defaultValue = "60") int qps,
                        @RequestParam(defaultValue = "3") int seconds) throws InterruptedException {
        int boundedQps = Math.min(Math.max(qps, 1), 200);
        int boundedSec = Math.min(Math.max(seconds, 1), 10);
        long paceMs = Math.max(1000L / boundedQps, 5L);
        int n = 0;
        long deadline = System.currentTimeMillis() + boundedSec * 1000L;
        while (System.currentTimeMillis() < deadline) {
            jdbcTemplate.queryForList("SELECT id FROM user WHERE id = ?", Integer.class, ++n);
            Thread.sleep(paceMs);
        }
        return "storm done, n=" + n;
    }

    /**
     * 日期族参数喂料（R3 ANSI 字面量还原）：Date/Timestamp/sql.Date 混型三参——
     * 日志还原链应渲染 DATE '…' / TIMESTAMP '…' 而非裸引号字符串
     */
    @GetMapping("/dateParam")
    public List<User> dateParam() {
        Date startTime = new Date(System.currentTimeMillis() - 365L * 24 * 3600 * 1000);
        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        java.sql.Date lastModified = java.sql.Date.valueOf("2026-01-01");
        return userMapper.selectByTimeRangeXml(startTime, endTime, lastModified);
    }

    /**
     * ShardingSphere 双段格式喂料（R10）：Logic SQL 主行 + 两分片 Actual SQL 附注行（方括号参数形态）
     */
    @GetMapping("/shardingSphere")
    public String shardingSphere(@RequestParam(defaultValue = "42") int userId) {
        ssLog("Logic SQL: SELECT id, order_no, amount FROM t_order WHERE user_id = ?");
        ssLog("Actual SQL: ds_0 ::: SELECT id, order_no, amount FROM t_order_0 WHERE user_id = ?"
                + " ::: Parameters: [" + userId + "]");
        ssLog("Actual SQL: ds_1 ::: SELECT id, order_no, amount FROM t_order_1 WHERE user_id = ?"
                + " ::: Parameters: [" + userId + "]");
        return "sharding-sphere logic+actual printed";
    }

    /**
     * SS 参数含 ", " 边界喂料：字符串值本身带逗号+空格——插件 TODO 登记的拆分边界形态，喂入后核对还原行为
     */
    @GetMapping("/ssCommaParam")
    public String ssCommaParam() {
        ssLog("Logic SQL: SELECT id FROM user WHERE real_name = ? AND dept_id = ?");
        ssLog("Actual SQL: ds_0 ::: SELECT id FROM user WHERE real_name = ? AND dept_id = ?"
                + " ::: Parameters: ['Smith, Jr.', 7]");
        return "sharding-sphere comma-param printed";
    }

    /** 打印行带 logback 风格前缀（时间/线程/级别）——喂线程路由与时间戳解析 */
    private void ssLog(String body) {
        SS_LOG.info("{} [{}] - {}", new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()),
                Thread.currentThread().getName(), body);
    }
}
