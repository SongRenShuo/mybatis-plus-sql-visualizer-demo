package cn.song.mybatisplusdemo.goldendb;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 分页 LIMIT 用例（T-GoldenDbDemoCases 族 2：分页）。
 *
 * <p>GoldenDB 分页 {@code LIMIT [offset,] count}，<b>offset 0 起算</b>（开发支持手册 p73）；
 * 与 {@code LIMIT count} 两种形态都要跑通。同一 SQL 族在 MySQL 端点上跑通即为形态级对照
 * （GoldenDB 完全兼容 MySQL 客户端，手册 p37）；身份级断言只在 GoldenDB 端点上做（本族无）。</p>
 *
 * @author T-GoldenDbDemoCases
 */
class GoldenDbPaginationLimitTest {

    private static final String TABLE = "gdb_case_page";

    /** LIMIT count：取前 N 条。 */
    @Test
    void limitCount_returnsFirstN() throws SQLException {
        try (Connection conn = GoldenDbTestEnv.any()) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                seed(conn, 5);
                List<Long> ids = queryIds(conn, "SELECT `id` FROM `" + TABLE + "` ORDER BY `id` LIMIT 3");
                assertEquals(java.util.Arrays.asList(1L, 2L, 3L), ids, "LIMIT 3 应取前 3 条（id 1..3）");
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }

    /** LIMIT offset,count：offset 0 起算（手册 p73），LIMIT 2,3 应取第 3~5 条。 */
    @Test
    void limitOffsetCount_offsetIsZeroBased() throws SQLException {
        try (Connection conn = GoldenDbTestEnv.any()) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                seed(conn, 5);
                List<Long> commaForm = queryIds(conn,
                        "SELECT `id` FROM `" + TABLE + "` ORDER BY `id` LIMIT 2, 3");
                assertEquals(java.util.Arrays.asList(3L, 4L, 5L), commaForm,
                        "LIMIT 2,3：offset=2 为 0 起算，应取第 3~5 条（手册 p73）");
                List<Long> offsetForm = queryIds(conn,
                        "SELECT `id` FROM `" + TABLE + "` ORDER BY `id` LIMIT 3 OFFSET 2");
                assertEquals(commaForm, offsetForm, "LIMIT 3 OFFSET 2 与 LIMIT 2,3 应等价");
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }

    /** 越界 offset：offset 超过行数时返回空集（0 起算语义的边界形态）。 */
    @Test
    void limitOffsetBeyondRows_returnsEmpty() throws SQLException {
        try (Connection conn = GoldenDbTestEnv.any()) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                seed(conn, 3);
                List<Long> ids = queryIds(conn,
                        "SELECT `id` FROM `" + TABLE + "` ORDER BY `id` LIMIT 10, 3");
                assertTrue(ids.isEmpty(), "offset 10 越过全部 3 行，应返回空集");
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }

    private static void seed(Connection conn, int n) throws SQLException {
        for (int i = 1; i <= n; i++) {
            GoldenDbTestEnv.insertDevice(conn, TABLE, "dev-" + i, "s-" + i, i);
        }
    }

    private static List<Long> queryIds(Connection conn, String sql) throws SQLException {
        List<Long> ids = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ids.add(rs.getLong(1));
            }
        }
        return ids;
    }
}
