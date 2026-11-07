package cn.song.mybatisplusdemo.goldendb;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * DELETE ... ORDER BY ... LIMIT n 用例（T-GoldenDbDemoCases 族 5）。
 *
 * <p>GoldenDB DELETE 文法带 ORDER BY / LIMIT 子句（开发支持手册 p274 文法，p276 示例
 * 「DELETE FROM ... ORDER BY ... LIMIT n」），对应 demo 模块
 * {@code GoldenDbDeviceMapper#deleteNewest} 的注解 SQL 形态。
 * 同一 SQL 族在 MySQL 端点上跑通即为形态级对照。</p>
 *
 * @author T-GoldenDbDemoCases
 */
class GoldenDbDeleteOrderLimitTest {

    private static final String TABLE = "gdb_case_del_limit";

    /** 删最新 2 条（id 最大者）：剩 3 条，且被删的正是 id 5、4（手册 p276 示例形态）。 */
    @Test
    void deleteOrderLimitDesc_removesNewestN() throws SQLException {
        try (Connection conn = GoldenDbTestEnv.any()) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                for (int i = 1; i <= 5; i++) {
                    GoldenDbTestEnv.insertDevice(conn, TABLE, "dev-" + i, "s-" + i, i);
                }
                int deleted;
                try (java.sql.Statement st = conn.createStatement()) {
                    deleted = st.executeUpdate(
                            "DELETE FROM `" + TABLE + "` ORDER BY `id` DESC LIMIT 2");
                }
                assertEquals(2, deleted, "DELETE ... ORDER BY id DESC LIMIT 2 应删 2 行（手册 p276）");
                assertEquals(3, GoldenDbTestEnv.count(conn, TABLE));
                assertEquals(3, maxId(conn), "剩余最大 id 应为 3（id 5、4 被删）");
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }

    /** LIMIT 超过行数：删到尽，不报错。 */
    @Test
    void deleteOrderLimit_overCount_deletesAll() throws SQLException {
        try (Connection conn = GoldenDbTestEnv.any()) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                GoldenDbTestEnv.insertDevice(conn, TABLE, "dev-a", "s-a", 1);
                GoldenDbTestEnv.insertDevice(conn, TABLE, "dev-b", "s-b", 2);
                int deleted;
                try (java.sql.Statement st = conn.createStatement()) {
                    deleted = st.executeUpdate(
                            "DELETE FROM `" + TABLE + "` ORDER BY `id` DESC LIMIT 10");
                }
                assertEquals(2, deleted, "LIMIT 10 > 行数 2，应删全部且不报错");
                assertEquals(0, GoldenDbTestEnv.count(conn, TABLE));
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }

    private static int maxId(Connection conn) throws SQLException {
        try (java.sql.Statement st = conn.createStatement();
             java.sql.ResultSet rs = st.executeQuery("SELECT IFNULL(MAX(`id`), 0) FROM `" + TABLE + "`")) {
            rs.next();
            return rs.getInt(1);
        }
    }
}
