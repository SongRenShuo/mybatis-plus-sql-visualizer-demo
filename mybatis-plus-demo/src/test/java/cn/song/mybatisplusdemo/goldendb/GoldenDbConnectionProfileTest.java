package cn.song.mybatisplusdemo.goldendb;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * GoldenDB 连接 profile 用例（T-GoldenDbDemoCases 族 1：连接配置）。
 *
 * <p>验证 {@code application-goldendb.yml} profile 的连接契约：driver {@code com.goldendb.jdbc.Driver}
 * （调研册 §1.2.1）、URL 模板 {@code jdbc:goldendb://host:port/db}、连接元数据里的 GoldenDB 身份。
 * 对照面：MySQL 端点（GOLDENDB_MYSQL_URL）连接元数据必须是 MySQL——同一套 profile 契约按端点类型分叉。</p>
 *
 * <p>skip 契约：未设置 {@code GOLDENDB_URL} ⇒ 全部 skip 且写明原因；设置了但连不上 ⇒ 红（假端点不静默绿）。</p>
 *
 * @author T-GoldenDbDemoCases
 */
class GoldenDbConnectionProfileTest {

    /**
     * GoldenDB 驱动类必须在 classpath（pom goldendb-driver system-scope profile 接入 vendor jar）。
     * 端点已配置但驱动缺席属误配，必须红。
     */
    @Test
    void goldendbDriverClass_loadable_whenEndpointConfigured() throws Exception {
        GoldenDbTestEnv.Endpoint ep = GoldenDbTestEnv.goldendbEndpointOrNull();
        Assumptions.assumeTrue(ep != null,
                () -> "GoldenDB 真机未接入：未设置环境变量 " + GoldenDbTestEnv.GOLDENDB_URL
                        + "——连接 profile 用例与真机部署解耦，显式跳过");
        Class<?> driverClass = Class.forName(GoldenDbTestEnv.GOLDENDB_DRIVER);
        assertNotNull(driverClass, "驱动类应可装载");
        assertTrue(java.sql.Driver.class.isAssignableFrom(driverClass),
                "驱动类应实现 java.sql.Driver（SPI 注册，调研册 §1.2.1）");
    }

    /**
     * 连接 GoldenDB：URL 模板可连、连接元数据带 GoldenDB 身份（方言标记按端点类型断言）。
     */
    @Test
    void goldendbConnection_metadataAssertsGoldenDbIdentity() throws Exception {
        GoldenDbTestEnv.Endpoint ep = GoldenDbTestEnv.goldendbEndpointOrNull();
        Assumptions.assumeTrue(ep != null,
                () -> "GoldenDB 真机未接入：未设置环境变量 " + GoldenDbTestEnv.GOLDENDB_URL
                        + "——连接 profile 用例与真机部署解耦，显式跳过");
        Connection conn = GoldenDbTestEnv.connect(ep);
        try {
            DatabaseMetaData meta = conn.getMetaData();
            String productName = meta.getDatabaseProductName();
            String driverName = meta.getDriverName();
            assertTrue(productName != null && productName.toLowerCase().contains("goldendb"),
                    "DatabaseProductName 应含 GoldenDB，实际=" + productName);
            assertTrue(driverName != null && driverName.toLowerCase().contains("goldendb"),
                    "DriverName 应含 GoldenDB（驱动常量 NAME=GoldenDB Connector Java，调研册 §1.2.1），实际=" + driverName);
            assertEquals("goldendb", ep.kind, "jdbc:goldendb: 前缀应识别为 goldendb 端点类型");
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery("SELECT 1")) {
                assertTrue(rs.next() && rs.getInt(1) == 1, "heartbeat SELECT 1 应可用");
            }
        } finally {
            conn.close();
        }
    }

    /**
     * MySQL 对照端点：连接元数据是 MySQL 身份（形态级对照，非 GoldenDB）。
     */
    @Test
    void mysqlComparisonEndpoint_metadataAssertsMysqlIdentity() throws Exception {
        GoldenDbTestEnv.Endpoint ep = GoldenDbTestEnv.mysqlEndpointOrNull();
        Assumptions.assumeTrue(ep != null,
                () -> "MySQL 对照端点未配置：未设置环境变量 " + GoldenDbTestEnv.MYSQL_URL
                        + "——形态级对照显式跳过");
        assertEquals("mysql", ep.kind, "jdbc:mysql: 前缀应识别为 mysql 端点类型");
        Connection conn = GoldenDbTestEnv.connect(ep);
        try {
            String productName = conn.getMetaData().getDatabaseProductName();
            assertTrue(productName != null && productName.contains("MySQL"),
                    "对照端点应为 MySQL 身份，实际=" + productName);
        } finally {
            conn.close();
        }
    }
}
