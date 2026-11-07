package cn.song.mybatisplusdemo.goldendb;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 事务用例（T-GoldenDbDemoCases 族 7：START TRANSACTION / COMMIT / ROLLBACK）。
 *
 * <p>GoldenDB 事务入口 {@code START TRANSACTION}（开发支持手册 p83），提交/回滚语义与 MySQL 一致。
 * 同一 SQL 族在 MySQL 端点上跑通即为形态级对照。demo 模块侧对应
 * {@code GoldenDbDialectDemoServiceImpl#txDemo}（Spring @Transactional 由连接层映射同一事务边界）。</p>
 *
 * @author T-GoldenDbDemoCases
 */
class GoldenDbTransactionTest {

    private static final String TABLE = "gdb_case_tx";

    /** START TRANSACTION → INSERT → ROLLBACK：行不落库（手册 p83 事务入口 + 回滚语义）。 */
    @Test
    void startTransaction_rollback_discardsInsert() throws SQLException {
        try (Connection conn = GoldenDbTestEnv.any()) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                GoldenDbTestEnv.exec(conn, "START TRANSACTION");
                try {
                    GoldenDbTestEnv.insertDevice(conn, TABLE, "tx-rollback", "r", 1);
                } finally {
                    GoldenDbTestEnv.exec(conn, "ROLLBACK");
                }
                assertEquals(0, GoldenDbTestEnv.count(conn, TABLE), "回滚后插入不应落库");
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }

    /** START TRANSACTION → INSERT → COMMIT：行落库；且不受前一条回滚事务污染。 */
    @Test
    void startTransaction_commit_persistsInsert() throws SQLException {
        try (Connection conn = GoldenDbTestEnv.any()) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                GoldenDbTestEnv.exec(conn, "START TRANSACTION");
                GoldenDbTestEnv.insertDevice(conn, TABLE, "tx-commit", "c", 2);
                GoldenDbTestEnv.exec(conn, "COMMIT");
                assertEquals(1, GoldenDbTestEnv.count(conn, TABLE), "提交后插入应落库");

                GoldenDbTestEnv.exec(conn, "START TRANSACTION");
                try {
                    GoldenDbTestEnv.insertDevice(conn, TABLE, "tx-again", "a", 3);
                } finally {
                    GoldenDbTestEnv.exec(conn, "ROLLBACK");
                }
                assertEquals(1, GoldenDbTestEnv.count(conn, TABLE), "第二个事务回滚不应影响已提交行");
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }

    /** 回滚后连接仍可用（事务边界干净）：再插一行并立即可见。 */
    @Test
    void connectionUsableAfterRollback() throws SQLException {
        try (Connection conn = GoldenDbTestEnv.any()) {
            GoldenDbTestEnv.createCaseDeviceTable(conn, TABLE);
            try {
                GoldenDbTestEnv.exec(conn, "START TRANSACTION");
                GoldenDbTestEnv.insertDevice(conn, TABLE, "tx-ghost", "g", 9);
                GoldenDbTestEnv.exec(conn, "ROLLBACK");
                GoldenDbTestEnv.insertDevice(conn, TABLE, "tx-live", "l", 10);
                try (java.sql.Statement st = conn.createStatement();
                     java.sql.ResultSet rs = st.executeQuery(
                             "SELECT COUNT(*) FROM `" + TABLE + "` WHERE `device_name` = 'tx-live'")) {
                    assertTrue(rs.next() && rs.getInt(1) == 1, "回滚后连接应可继续正常执行");
                }
            } finally {
                GoldenDbTestEnv.dropTable(conn, TABLE);
            }
        }
    }
}
