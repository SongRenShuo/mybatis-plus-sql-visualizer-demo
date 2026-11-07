package cn.song.mybatisplusdemo.goldendb;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * upsert 用例（T-GoldenDbDemoCases 族 3：ON DUPLICATE KEY UPDATE）。
 *
 * <p>GoldenDB upsert 形态 {@code INSERT ... ON DUPLICATE KEY UPDATE}（开发支持手册 p66），
 * 两条路径都要覆盖：冲突未命中（新插入）与冲突命中（更新既有行）。
 * 同一 SQL 族在 MySQL 端点上跑通即为形态级对照；受影响行数语义（1=插入 / 2=更新）按 MySQL 协议断言。</p>
 *
 * @author T-GoldenDbDemoCases
 */
class GoldenDbUpsertDuplicateKeyTest {

    private static final String TABLE = "gdb_case_upsert";

    /** 新插入路径：唯一键未冲突，只插入（affected=1）。 */
    @Test
    void upsert_missPath_insertsNewRow() throws SQLException {
        try (Connection conn = GoldenDbTestEnv.any()) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                int affected = upsert(conn, "dev-a", "v1");
                assertEquals(1, affected, "未冲突路径应插入 1 行（affected=1）");
                assertEquals(1, GoldenDbTestEnv.count(conn, TABLE));
                assertEquals("v1", selectStoragedb(conn, "dev-a"));
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }

    /** 冲突更新路径：唯一键命中，更新既有行（affected=2，MySQL 协议语义）。 */
    @Test
    void upsert_hitPath_updatesExistingRow() throws SQLException {
        try (Connection conn = GoldenDbTestEnv.any()) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                GoldenDbTestEnv.insertDevice(conn, TABLE, "dev-a", "old", 1);
                int affected = upsert(conn, "dev-a", "new");
                assertEquals(2, affected, "冲突更新路径 affected 应为 2（MySQL 协议 upsert 语义）");
                assertEquals(1, GoldenDbTestEnv.count(conn, TABLE), "命中路径不应新增行");
                assertEquals("new", selectStoragedb(conn, "dev-a"), "冲突路径应更新 storagedb 列值");
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }

    /** 连续两次 upsert 同一键：先插后更，行数保持 1 且值取最后写入。 */
    @Test
    void upsert_twiceSameKey_singleRowWithLatestValue() throws SQLException {
        try (Connection conn = GoldenDbTestEnv.any()) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                upsert(conn, "dev-a", "first");
                upsert(conn, "dev-a", "second");
                assertEquals(1, GoldenDbTestEnv.count(conn, TABLE));
                assertEquals("second", selectStoragedb(conn, "dev-a"));
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }

    private static int upsert(Connection conn, String name, String storagedb) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO `" + TABLE + "` (`device_name`, `storagedb`, `order`) VALUES (?, ?, 1) "
                        + "ON DUPLICATE KEY UPDATE `storagedb` = VALUES(`storagedb`)")) {
            ps.setString(1, name);
            ps.setString(2, storagedb);
            return ps.executeUpdate();
        }
    }

    private static String selectStoragedb(Connection conn, String name) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT `storagedb` FROM `" + TABLE + "` WHERE `device_name` = ?")) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getString(1);
            }
        }
    }
}
