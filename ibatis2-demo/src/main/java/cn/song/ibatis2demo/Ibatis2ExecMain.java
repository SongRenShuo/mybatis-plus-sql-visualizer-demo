package cn.song.ibatis2demo;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import cn.song.ibatis2demo.model.User;

/**
 * iBatis 2 **真实执行**入口（区别于 {@link Ibatis2Main} 的离线渲染自检）：
 *
 * <ol>
 *   <li>启动前自举：连接本地 MySQL，确保 T_USER 表与种子数据在位（幂等）；</li>
 *   <li>buildSqlMapClient（此时 DTD 校验 + 配置解析，sqlmap-config.xml 已声明
 *       transactionManager/dataSource 指向同一个库）；</li>
 *   <li>循环走 {@link UserDaoImpl} 的各条语句——SQL 会经 iBatis 的 JDBC 日志代理打到控制台
 *       （`{conn-N}` / `{pstm-N}` 三行一组，log4j2.xml 已把 java.sql 开到 DEBUG），
 *       插件的 SQL 捕获（控制台桥 + 增强捕获 agent）就从这些行里采。</li>
 * </ol>
 *
 * <p>运行方式：在 IDE 里直接 Run 本类（增强捕获测试须从 IDE 里启动，外部进程挂不上 agent）。
 * 需要 MySQL localhost:3306/mp_demo（root/root，与其他 demo 模块同一约定）。</p>
 *
 * <p>预期：可执行语句（各 SELECT + insertUser 的 INSERT 主体）正常往返；三条**形态语料**
 * （selectKey 的 Oracle 序列、viaParameterMapRawHash 的裸 #、callUserProcedure 的 {call}）
 * 各自抛错并被逐条捕获打印——错误内容本身就是验收判据。</p>
 */
public class Ibatis2ExecMain {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mp_demo"
        + "?useUnicode=true&characterEncoding=utf8&useSSL=false"
        + "&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root";

    public static void main(String[] args) throws Exception {
        bootstrap();

        Reader reader = Resources.getResourceAsReader("sqlmap-config.xml");
        SqlMapClient client = SqlMapClientBuilder.buildSqlMapClient(reader);
        reader.close();
        System.out.println("[ibatis2] SqlMapClient 构建成功（DTD 校验 + 配置解析通过）");

        UserDao dao = new UserDaoImpl(client);

        int rounds = Integer.parseInt(
            System.getProperty("ibatis2demo.rounds", System.getenv().getOrDefault("IBATIS2_ROUNDS", "3")));
        System.out.println("[ibatis2] 开始 " + rounds + " 轮真实调用（每轮 17 条语句逐条走，每条间隔 1.5s）");

        for (int round = 1; round <= rounds; round++) {
            System.out.println("========== round " + round + " ==========");
            runRound(dao, round);
            Thread.sleep(1500);
        }
        System.out.println("[ibatis2] 全部轮次完成，退出");
    }

    /** 幂等自举：建表 + 种子（已存在则跳过）。 */
    private static void bootstrap() throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             Statement st = conn.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS T_USER ("
                + "ID INT PRIMARY KEY,"
                + "USER_NAME VARCHAR(64),"
                + "EMAIL VARCHAR(128),"
                + "AGE INT,"
                + "STATUS INT,"
                + "DEPT_ID INT)");
            try (ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM T_USER")) {
                rs.next();
                if (rs.getInt(1) == 0) {
                    st.execute("INSERT INTO T_USER VALUES (1,'alice','alice@demo',30,1,10)");
                    st.execute("INSERT INTO T_USER VALUES (2,'bob','bob@demo',41,1,10)");
                    st.execute("INSERT INTO T_USER VALUES (3,'carol','carol@demo',19,0,20)");
                    System.out.println("[ibatis2] T_USER 已建表并灌入 3 行种子");
                }
            }
        }
    }

    private static void runRound(UserDao dao, int round) {
        User filled = new User();
        filled.setId(1);
        filled.setUsername("111");
        filled.setEmail("111");
        filled.setAge(1);
        filled.setStatus(1);
        filled.setDeptId(10);
        filled.setOrderColumn("ID");
        filled.setIds(Arrays.asList("X1", "X2", "X3"));

        runStep("selectAll", () -> dao.selectAll());
        runStep("selectById(1)", () -> dao.selectById(1));
        runStep("selectTwoSegment(alice)", () -> dao.selectTwoSegment("alice"));
        runStep("selectThreeSegment(age=30)", () -> dao.selectThreeSegment(30));
        runStep("selectVarcharNullValue(x)", () -> dao.selectVarcharNullValue("x"));
        runStep("selectByInclude(filled)", () -> dao.selectByInclude(filled));
        runStep("selectAdvancedSyntax(1)", () -> dao.selectAdvancedSyntax(1));
        runStep("selectOrderBy(ID)", () -> dao.selectOrderBy("ID"));
        runStep("selectEscapes", () -> dao.selectEscapes());
        runStep("selectByCondition(filled)", () -> dao.selectByCondition(filled));
        runStep("selectPrependNoSpace(filled)", () -> dao.selectPrependNoSpace(filled));
        runStep("selectByIterate(X1,X2,X3)", () -> dao.selectByIterate(Arrays.asList("X1", "X2", "X3")));
        runStep("selectPrependWithSpace(filled)", () -> dao.selectPrependWithSpace(filled));
        runStep("updateUser(filled)", () -> dao.updateUser(filled));
        runStep("insertUser(selectKey=Oracle序列,MySQL上预期失败)", () -> dao.insertUser(filled));
        runStep("viaParameterMapRawHash(裸#,MySQL上预期失败)", () -> dao.viaParameterMapRawHash(filled));
        runStep("selectNullParamBranch(null参数)", () -> dao.selectNullParamBranch());
        runStep("selectNullParamBranch(filled)", () -> dao.selectNullParamBranch(filled));
        runStep("selectByDeptId(10)", () -> dao.selectByDeptId(10));
        runStep("callUserProcedure(无包,预期失败)", () -> {
            dao.callUserProcedure(filled);
            return "void";
        });
    }

    private interface Step {
        Object run() throws Exception;
    }

    /** 逐条执行 + 每步 try/catch：形态语料的失败本身就是判据，不中断整轮。 */
    private static void runStep(String label, Step step) {
        long start = System.currentTimeMillis();
        try {
            Object out = step.run();
            String brief = String.valueOf(out);
            System.out.println("[OK] " + label + " (" + (System.currentTimeMillis() - start) + "ms) -> "
                + (brief.length() > 120 ? brief.substring(0, 120) + "…" : brief));
        } catch (Throwable t) {
            System.out.println("[EXPECT-FAIL] " + label + " (" + (System.currentTimeMillis() - start) + "ms) -> "
                + t.getClass().getSimpleName() + ": " + String.valueOf(t.getMessage()).substring(0,
                    Math.min(160, String.valueOf(t.getMessage()).length())));
        }
    }
}
