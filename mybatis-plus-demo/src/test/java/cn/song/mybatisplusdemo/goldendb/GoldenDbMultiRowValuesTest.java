package cn.song.mybatisplusdemo.goldendb;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 多行 VALUES 批量插入用例（T-GoldenDbDemoCases 族 4）。
 *
 * <p>GoldenDB 支持「INSERT INTO ... VALUES (...),(...),(...)」多行 VALUES（开发支持手册 p66），
 * 对应 MyBatis-Plus 侧 insertBatchSomeColumn 注入方法生成的批量形态。
 * 同一 SQL 族在 MySQL 端点上跑通即为形态级对照。</p>
 *
 * @author T-GoldenDbDemoCases
 */
class GoldenDbMultiRowValuesTest {

    private static final String TABLE = "gdb_case_multirow";

    /** 单语句三行 VALUES：一次插入 3 行。 */
    @Test
    void multiRowValues_threeRowsSingleStatement() throws SQLException {
        try (Connection conn = GoldenDbTestEnv.any()) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                int affected;
                try (PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO `" + TABLE + "` (`device_name`, `storagedb`, `order`) VALUES "
                                + "(?, ?, 1), (?, ?, 2), (?, ?, 3)")) {
                    ps.setString(1, "dev-1");
                    ps.setString(2, "s-1");
                    ps.setString(3, "dev-2");
                    ps.setString(4, "s-2");
                    ps.setString(5, "dev-3");
                    ps.setString(6, "s-3");
                    affected = ps.executeUpdate();
                }
                assertEquals(3, affected, "单条多行 VALUES 语句应插入 3 行（手册 p66）");
                assertEquals(3, GoldenDbTestEnv.count(conn, TABLE));
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }

    /** 大批量（100 行）多行 VALUES：验证批量形态的规模面（对应 mpsv-walk-proj batch1000 的缩小版）。 */
    @Test
    void multiRowValues_hundredRows() throws SQLException {
        try (Connection conn = GoldenDbTestEnv.any()) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                StringBuilder sql = new StringBuilder(
                        "INSERT INTO `" + TABLE + "` (`device_name`, `storagedb`, `order`) VALUES ");
                for (int i = 1; i <= 100; i++) {
                    if (i > 1) {
                        sql.append(", ");
                    }
                    sql.append("('dev-").append(i).append("', 's-").append(i).append("', ").append(i).append(")");
                }
                int affected;
                try (PreparedStatement ps = conn.prepareStatement(sql.toString())) {
                    affected = ps.executeUpdate();
                }
                assertEquals(100, affected, "100 行多行 VALUES 应全部插入");
                assertEquals(100, GoldenDbTestEnv.count(conn, TABLE));
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }
}
