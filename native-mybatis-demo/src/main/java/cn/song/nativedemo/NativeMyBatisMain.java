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
            try (SqlSession session = factory.openSession()) {
                NativeUserMapper mapper = session.getMapper(NativeUserMapper.class);
                List<NativeUser> users = mapper.selectByStatus(1);
                System.out.println("selectByStatus(1) -> " + users.size() + " rows");
                for (NativeUser user : users) {
                    System.out.println("  " + user);
                }
                int count = mapper.countByStatus(1);
                System.out.println("countByStatus(1) -> " + count);
            }
        }
    }

    private NativeMyBatisMain() {
    }
}
