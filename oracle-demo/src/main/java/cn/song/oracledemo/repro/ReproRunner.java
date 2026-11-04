package cn.song.oracledemo.repro;

import cn.song.oracledemo.entity.DemoUser;
import cn.song.oracledemo.mapper.DemoUserMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 复现脚本：一条 DDL（plain Statement）+ 四条 MyBatis-Plus 业务 SQL（PreparedStatement）。
 *
 * <p>判读口径（配合增强捕获）：
 * <ul>
 *   <li>缺陷态：只看到连接校验 `select 1 from dual` 与建表 DDL，<b>四条业务 SQL 一条不出</b>；</li>
 *   <li>修复态：五条全出，且 insert/select/update 三条带绑定参数。</li>
 * </ul>
 * 打印的 REPRO 行只是给宿主控制台一个进度锚点，判据以 agent 事件为准。
 */
@Component
public class ReproRunner implements CommandLineRunner {

    private final DemoUserMapper mapper;
    private final DataSource dataSource;

    public ReproRunner(DemoUserMapper mapper, DataSource dataSource) {
        this.mapper = mapper;
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        resetTable();

        mapper.insert(new DemoUser(1L, "alice", 30));
        System.out.println("REPRO 1/4 insert done");

        DemoUser one = mapper.selectById(1L);
        System.out.println("REPRO 2/4 selectById -> " + one);

        System.out.println("REPRO 3/4 selectList size -> " + mapper.selectList(null).size());

        mapper.updateById(new DemoUser(1L, "alice2", 31));
        System.out.println("REPRO 4/4 updateById done");

        System.out.println("REPRO DONE —— 以上 4 条 MyBatis-Plus 语句都应出现在增强捕获里");

        // agent 的事件发送是异步的（EventBus → sender 线程）：应用若立刻退出，队列里未发出的帧会丢。
        // 留 2 秒给发送线程排空，否则复现时会误判成「后面几条没采到」。
        Thread.sleep(2000L);
    }

    /** 建表走原生 JDBC（不复用 MyBatis），避免把夹具准备语句混进判读样本。 */
    private void resetTable() throws SQLException {
        try (Connection c = dataSource.getConnection(); Statement st = c.createStatement()) {
            try {
                st.executeUpdate("drop table DEMO_USER");
            } catch (SQLException ignore) {
                // 首次不存在
            }
            st.executeUpdate("create table DEMO_USER ("
                    + "ID number(10) primary key, "
                    + "NAME varchar2(64), "
                    + "AGE number(3))");
        }
    }
}
