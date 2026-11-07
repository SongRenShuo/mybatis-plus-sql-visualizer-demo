package cn.song.mybatisplusdemo.goldendb;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * REPLACE INTO 用例（T-GoldenDbDemoCases 族 8）。
 *
 * <p>GoldenDB 手册把 {@code REPLACE INTO} 与 {@code MERGE INTO} 并列在 p281-282；
 * REPLACE INTO 与 MySQL 语义一致（唯一键命中 = 先删后插，affected=2），MySQL 端点可跑形态级对照。
 * MERGE INTO 是否被 GoldenDB 接受按真机实测后再补断言（本用例不冒进）。</p>
 *
 * @author T-GoldenDbDemoCases
 */
class GoldenDbReplaceIntoTest {

    private static final String TABLE = "gdb_case_replace";

    /** REPLACE INTO 命中唯一键：先删后插（affected=2），值替换，行数不变。 */
    @Test
    void replaceInto_hitPath_replacesRow() throws SQLException {
        try (Connection conn = GoldenDbTestEnv.any()) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                GoldenDbTestEnv.insertDevice(conn, TABLE, "dev-r", "old", 1);
                int affected;
                try (Statement st = conn.createStatement()) {
                    affected = st.executeUpdate(
                            "REPLACE INTO `" + TABLE + "` (`device_name`, `storagedb`, `order`) "
                                    + "VALUES ('dev-r', 'new', 2)");
                }
                assertEquals(2, affected, "REPLACE INTO 命中唯一键应删 1 插 1（affected=2，手册 p281-282）");
                assertEquals(1, GoldenDbTestEnv.count(conn, TABLE), "替换后行数不变");
                try (Statement st = conn.createStatement();
                     ResultSet rs = st.executeQuery(
                             "SELECT `storagedb`, `order` FROM `" + TABLE + "` WHERE `device_name` = 'dev-r'")) {
                    rs.next();
                    assertEquals("new", rs.getString(1), "REPLACE 后应取新值");
                    assertEquals(2, rs.getInt(2));
                }
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }

    /** REPLACE INTO 未命中：等同普通插入（affected=1）。 */
    @Test
    void replaceInto_missPath_insertsRow() throws SQLException {
        try (Connection conn = GoldenDbTestEnv.any()) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                int affected;
                try (Statement st = conn.createStatement()) {
                    affected = st.executeUpdate(
                            "REPLACE INTO `" + TABLE + "` (`device_name`, `storagedb`, `order`) "
                                    + "VALUES ('dev-r2', 'v', 3)");
                }
                assertEquals(1, affected, "未命中路径应为普通插入（affected=1）");
                assertEquals(1, GoldenDbTestEnv.count(conn, TABLE));
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }
}
