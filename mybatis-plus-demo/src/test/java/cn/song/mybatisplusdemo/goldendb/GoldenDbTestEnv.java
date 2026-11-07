package cn.song.mybatisplusdemo.goldendb;

import org.junit.jupiter.api.Assumptions;
import org.opentest4j.TestAbortedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 * GoldenDB demo 用例环境支撑（T-GoldenDbDemoCases）。
 *
 * <p>端点契约（全部来自环境变量，凭据不落代码，对照主仓 {@code .local/} 凭据纪律）：</p>
 * <ul>
 *     <li>GoldenDB 真机：{@code GOLDENDB_URL}（形如 {@code jdbc:goldendb://host:port/db}）+
 *         {@code GOLDENDB_USER} / {@code GOLDENDB_PASS}；未设置 ⇒ 整族用例显式 skip（AssumptionViolated），
 *         跳过原因写明缺哪个变量——与真机部署解耦，不假绿。</li>
 *     <li>MySQL 形态级对照：{@code GOLDENDB_MYSQL_URL}（形如 {@code jdbc:mysql://host:port/db}）+
 *         {@code GOLDENDB_MYSQL_USER} / {@code GOLDENDB_MYSQL_PASS}；GoldenDB 完全兼容 MySQL 客户端
 *         （手册 p37），同一套 SQL 族先在 MySQL 上跑通形态。</li>
 * </ul>
 *
 * <p>skip 只看「变量是否配置」：配置了但连不上 ⇒ 用例正常红（假端点不静默绿）。
 * 断言 GoldenDB 身份（连接元数据 / 保留字行为）的地方一律按端点类型分叉，
 * 见各用例的 {@code kind()} 分支。</p>
 *
 * @author T-GoldenDbDemoCases
 */
final class GoldenDbTestEnv {

    /** GoldenDB 真机 JDBC URL 环境变量名。 */
    static final String GOLDENDB_URL = "GOLDENDB_URL";
    static final String GOLDENDB_USER = "GOLDENDB_USER";
    static final String GOLDENDB_PASS = "GOLDENDB_PASS";
    /** MySQL 形态级对照端点（GoldenDB 兼容 MySQL 客户端，手册 p37）。 */
    static final String MYSQL_URL = "GOLDENDB_MYSQL_URL";
    static final String MYSQL_USER = "GOLDENDB_MYSQL_USER";
    static final String MYSQL_PASS = "GOLDENDB_MYSQL_PASS";

    /** GoldenDB 自研驱动 SPI 类名（调研册 §1.2.1）。 */
    static final String GOLDENDB_DRIVER = "com.goldendb.jdbc.Driver";

    private GoldenDbTestEnv() {
    }

    /** 端点描述：URL + 凭据 + 端点类型（身份断言按它分叉）。 */
    static final class Endpoint {
        final String url;
        final String user;
        final String pass;
        final String kind; // "goldendb" | "mysql"

        Endpoint(String url, String user, String pass) {
            this.url = url;
            this.user = user;
            this.pass = pass;
            this.kind = url.toLowerCase(Locale.ROOT).startsWith("jdbc:goldendb:") ? "goldendb" : "mysql";
        }
    }

    /** GoldenDB 端点已配置（未配置 ⇒ 调用方 skip）。 */
    static boolean goldendbConfigured() {
        return endpointOrNull(GOLDENDB_URL, GOLDENDB_USER, GOLDENDB_PASS) != null;
    }

    /** MySQL 对照端点已配置。 */
    static boolean mysqlConfigured() {
        return endpointOrNull(MYSQL_URL, MYSQL_USER, MYSQL_PASS) != null;
    }

    /** 任一端点已配置（GoldenDB 优先）。 */
    static boolean anyConfigured() {
        return goldendbConfigured() || mysqlConfigured();
    }

    /** GoldenDB 端点描述；未配置返回 null（不抛），由调用方决定 skip。 */
    static Endpoint goldendbEndpointOrNull() {
        return endpointOrNull(GOLDENDB_URL, GOLDENDB_USER, GOLDENDB_PASS);
    }

    /** MySQL 对照端点描述；未配置返回 null。 */
    static Endpoint mysqlEndpointOrNull() {
        return endpointOrNull(MYSQL_URL, MYSQL_USER, MYSQL_PASS);
    }

    /**
     * 连 GoldenDB 真机。未配置 URL ⇒ skip（写明缺的变量与补法）；
     * 已配置但连不上 ⇒ 抛 IllegalStateException，让用例红（假端点不静默绿）。
     */
    static Connection goldendb() throws SQLException {
        Endpoint ep = requireEndpoint(GOLDENDB_URL, GOLDENDB_USER, GOLDENDB_PASS,
                "GoldenDB 真机未接入：未设置环境变量 " + GOLDENDB_URL
                        + "（另需 " + GOLDENDB_USER + "/" + GOLDENDB_PASS + "）——本族用例与真机部署解耦，显式跳过");
        return connect(ep);
    }

    /** 连 MySQL 对照端点（形态级）。 */
    static Connection mysql() throws SQLException {
        Endpoint ep = requireEndpoint(MYSQL_URL, MYSQL_USER, MYSQL_PASS,
                "MySQL 对照端点未配置：未设置环境变量 " + MYSQL_URL
                        + "（另需 " + MYSQL_USER + "/" + MYSQL_PASS + "）——形态级对照显式跳过");
        return connect(ep);
    }

    /** 任一可用端点：GoldenDB 优先，缺哪个跳哪个，skip 原因把两条路都写清。 */
    static Connection any() throws SQLException {
        if (goldendbConfigured()) {
            return goldendb();
        }
        if (mysqlConfigured()) {
            return mysql();
        }
        // Spring Boot 2.6.3 托管 JUnit Jupiter 5.8.2，无 Assumptions.abort（5.9+），直接抛 TestAbortedException（同款语义）
        throw new TestAbortedException("无可用数据库端点：GoldenDB 真机（" + GOLDENDB_URL + "）与 MySQL 对照（"
                + MYSQL_URL + "）均未设置——本族用例与真机部署解耦，显式跳过；"
                + "配置任一端点后重跑即可覆盖（GoldenDB 真机或 MySQL 形态级对照）");
    }

    /** 连接时装载驱动；驱动类不在 classpath 说明 pom 的 goldendb-driver profile 未生效，配置了端点就属误配 ⇒ 红。 */
    static Connection connect(Endpoint ep) throws SQLException {
        if ("goldendb".equals(ep.kind)) {
            try {
                Class.forName(GOLDENDB_DRIVER);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException(
                        "驱动类 " + GOLDENDB_DRIVER + " 不在 classpath：pom 的 goldendb-driver profile 未生效"
                                + "（vendor jar 不在位或未传 -Dgoldendb.jdbc.jar=<path>），但端点已配置，属误配",
                        e);
            }
        }
        return DriverManager.getConnection(ep.url, ep.user, ep.pass);
    }

    private static Endpoint requireEndpoint(String urlKey, String userKey, String passKey, String skipReason) {
        Endpoint ep = endpointOrNull(urlKey, userKey, passKey);
        if (ep == null) {
            throw new TestAbortedException(skipReason);
        }
        return ep;
    }

    private static Endpoint endpointOrNull(String urlKey, String userKey, String passKey) {
        String url = env(urlKey);
        if (url == null || url.trim().isEmpty()) {
            return null;
        }
        return new Endpoint(url, envOr(userKey, ""), envOr(passKey, ""));
    }

    private static String env(String key) {
        String v = System.getenv(key);
        if (v == null || v.isEmpty()) {
            v = System.getProperty(key);
        }
        return (v == null || v.isEmpty()) ? null : v;
    }

    private static String envOr(String key, String def) {
        String v = env(key);
        return v == null ? def : v;
    }

    /**
     * 建族内自备表（含保留字列，主键自增 + device_name 唯一键），幂等：先 DROP。
     * 表名前缀 gdb_case_，用完由调用方 finally 里 {@link #dropTable} 回收。
     */
    static void createCaseDeviceTable(Connection conn, String table) throws SQLException {
        exec(conn, "DROP TABLE IF EXISTS `" + table + "`");
        exec(conn, "CREATE TABLE `" + table + "` ("
                + "`id` BIGINT NOT NULL AUTO_INCREMENT, "
                + "`device_name` VARCHAR(64) NOT NULL, "
                + "`storagedb` VARCHAR(64) DEFAULT NULL, "
                + "`order` INT DEFAULT NULL, "
                + "PRIMARY KEY (`id`), "
                + "UNIQUE KEY `uk_device_name` (`device_name`)"
                + ") ENGINE=InnoDB");
    }

    static void dropTable(Connection conn, String table) {
        try (Statement st = conn.createStatement()) {
            st.execute("DROP TABLE IF EXISTS `" + table + "`");
        } catch (SQLException ignored) {
            // 清理失败不影响用例结论（下一个用例会先 DROP IF EXISTS）
        }
    }

    static void exec(Connection conn, String sql) throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.execute(sql);
        }
    }

    /** 向 gdb_case_* 设备表插一行，返回自增 id。 */
    static long insertDevice(Connection conn, String table, String name, String storagedb, int order) throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("INSERT INTO `" + table + "` (`device_name`, `storagedb`, `order`) VALUES ("
                    + quote(name) + ", " + quote(storagedb) + ", " + order + ")",
                    Statement.RETURN_GENERATED_KEYS);
            try (java.sql.ResultSet keys = st.getGeneratedKeys()) {
                keys.next();
                return keys.getLong(1);
            }
        }
    }

    static int count(Connection conn, String table) throws SQLException {
        try (Statement st = conn.createStatement();
             java.sql.ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM `" + table + "`")) {
            rs.next();
            return rs.getInt(1);
        }
    }

    static String quote(String s) {
        return "'" + s.replace("'", "''") + "'";
    }
}
