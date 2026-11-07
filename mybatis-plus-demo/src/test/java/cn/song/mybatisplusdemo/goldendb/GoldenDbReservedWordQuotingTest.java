package cn.song.mybatisplusdemo.goldendb;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 反引号标识符 + 保留字列名用例（T-GoldenDbDemoCases 族 6）。
 *
 * <p>反引号是 MySQL 系方言的引用形态（开发支持手册 p320）；GoldenDB 保留字清单含中兴自有词
 * {@code storagedb} 等（手册 p351-355），{@code order} 是 MySQL/GoldenDB 共同保留字。
 * 本族用例同时是方言身份断言面，按端点类型分叉：</p>
 * <ul>
 *     <li>两库共同保留字 {@code order}：不加反引号必报语法错（golden/mysql 两端点都断言红形态）；</li>
 *     <li>GoldenDB 特有保留字 {@code storagedb}：GoldenDB 端点不加反引号应报错（p351-355），
 *         MySQL 端点非保留、不加反引号也能执行——这一差异即 GoldenDB 身份证据。</li>
 * </ul>
 *
 * @author T-GoldenDbDemoCases
 */
class GoldenDbReservedWordQuotingTest {

    private static final String TABLE = "gdb_case_reserved";

    /** 反引号包裹全部保留字列：插入与回读可执行（手册 p320 引用形态）。 */
    @Test
    void backtickQuoted_reservedWordColumns_workOnAnyEndpoint() throws SQLException {
        try (Connection conn = GoldenDbTestEnv.any()) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                GoldenDbTestEnv.insertDevice(conn, TABLE, "dev-1", "sv", 7);
                try (Statement st = conn.createStatement();
                     ResultSet rs = st.executeQuery(
                             "SELECT `storagedb`, `order` FROM `" + TABLE + "` WHERE `order` = 7")) {
                    assertTrue(rs.next());
                    assertEquals("sv", rs.getString(1));
                    assertEquals(7, rs.getInt(2));
                }
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }

    /** 共同保留字 order：不加反引号必红（两端点一致，p320/保留字清单）。 */
    @Test
    void unquotedOrder_failsOnAnyEndpoint() throws SQLException {
        try (Connection conn = GoldenDbTestEnv.any()) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                assertThrows(SQLException.class,
                        () -> GoldenDbTestEnv.exec(conn,
                                "SELECT " + TABLE + ".order FROM `" + TABLE + "`"),
                        "order 是 MySQL/GoldenDB 共同保留字，不加反引号应语法错");
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }

    /**
     * GoldenDB 特有保留字 storagedb：GoldenDB 端点不加反引号应报错（p351-355 身份证据）；
     * MySQL 端点非保留、应执行成功（形态级对照的反向证据）。
     */
    @Test
    void unquotedStoragedb_branchesByEndpointKind() throws SQLException {
        GoldenDbTestEnv.Endpoint ep = GoldenDbTestEnv.goldendbEndpointOrNull();
        if (ep == null) {
            ep = GoldenDbTestEnv.mysqlEndpointOrNull();
        }
        org.junit.jupiter.api.Assumptions.assumeTrue(ep != null,
                () -> "无可用数据库端点（GOLDENDB_URL / GOLDENDB_MYSQL_URL 均未设置）——与真机部署解耦，显式跳过");
        try (Connection conn = GoldenDbTestEnv.connect(ep)) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                if ("goldendb".equals(ep.kind)) {
                    assertThrows(SQLException.class,
                            () -> GoldenDbTestEnv.exec(conn,
                                    "SELECT storagedb FROM `" + TABLE + "`"),
                            "storagedb 是 GoldenDB 保留字（手册 p351-355），不加反引号应报错"
                                    + "——若该断言红了但报错信息显示并非保留字问题，请对照真机版本更新调研册");
                } else {
                    // MySQL 非保留字：能执行，即「storagedb 是 GoldenDB 特有保留字」的对照证据
                    GoldenDbTestEnv.exec(conn, "SELECT storagedb FROM `" + TABLE + "`");
                    GoldenDbTestEnv.exec(conn,
                            "INSERT INTO `" + TABLE + "` (device_name, storagedb, `order`) VALUES ('dev-x', 'sv', 1)");
                    assertEquals(1, GoldenDbTestEnv.count(conn, TABLE));
                }
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }
}
