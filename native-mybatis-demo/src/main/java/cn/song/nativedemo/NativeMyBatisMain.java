package cn.song.nativedemo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * 原生 MyBatis 启动入口（SqlSessionFactoryBuilder 直读 mybatis-config.xml，无 Spring）。
 *
 * 用途：
 *  - 插件 3.25 验收的宿主——在 IDEA 里对本工程触发「SQL 日志 → 自动注入源码捕获拦截器」后，
 *    生成的 SqlVisualizerNativePlugin 会经 mybatis-config.xml 的 &lt;plugins&gt; 挂进拦截器链；
 *  - 运行后控制台输出 ==&gt; Preparing 日志，供 SQL 日志面板控制台通道与源码位置跳转走查。
 *
 * 数据源指向本机 mp_demo（root/root，与 demo 仓其它模块一致）。
 */
public final class NativeMyBatisMain {

    public static void main(String[] args) throws Exception {
        try (InputStream in = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            // 首轮 SQL（进程初始、无 agent）：基线
            runQueries(factory, "round-1");
            // 验收 3.27「对已启动应用 attach」：保持进程存活 45s，供沙盒在应用运行期间开启
            // 增强捕获（settings-rescan 扫描在跑 JVM 进程主动 attach，无需重启应用）。
            System.out.println("== 保持存活 45s 供 attach 复验… 请此时在插件设置开启增强捕获 ==");
            Thread.sleep(45_000L);
            // 次轮 SQL（attach 后）：验证存量进程被挂载后下一次执行即被捕获
            runQueries(factory, "round-2");
        }
    }

    private static void runQueries(SqlSessionFactory factory, String tag) {
        try (SqlSession session = factory.openSession()) {
            NativeUserMapper mapper = session.getMapper(NativeUserMapper.class);
            List<NativeUser> users = mapper.selectByStatus(1);
            System.out.println("[" + tag + "] selectByStatus(1) -> " + users.size() + " rows");
            for (NativeUser user : users) {
                System.out.println("  " + user);
            }
            int count = mapper.countByStatus(1);
            System.out.println("[" + tag + "] countByStatus(1) -> " + count);
        }
    }

    private NativeMyBatisMain() {
    }
}
