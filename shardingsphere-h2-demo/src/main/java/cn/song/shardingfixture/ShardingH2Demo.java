package cn.song.shardingfixture;

import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.driver.jdbc.core.datasource.ShardingSphereDataSource;
import org.apache.shardingsphere.infra.algorithm.core.config.AlgorithmConfiguration;
import org.apache.shardingsphere.infra.config.mode.ModeConfiguration;
import org.apache.shardingsphere.mode.repository.standalone.StandalonePersistRepositoryConfiguration;
import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.strategy.sharding.StandardShardingStrategyConfiguration;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/** 独立运行；不读取环境变量、系统属性、YAML 或宿主 application 配置。 */
public final class ShardingH2Demo {
    private static final String SHARD_0 = "jdbc:h2:mem:ui_shard_0;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false;MODE=MySQL";
    private static final String SHARD_1 = "jdbc:h2:mem:ui_shard_1;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false;MODE=MySQL";
    private static final String METADATA = "jdbc:h2:mem:ui_ss_metadata;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false;MODE=MySQL";
    private static final String BY_ID = "SELECT order_id, reference_code FROM ui_order WHERE order_id = ? AND reference_code = ?";
    private static final String ALL = "SELECT order_id, reference_code FROM ui_order WHERE state_code = ? ORDER BY order_id";

    private ShardingH2Demo() { }

    public static void main(String[] args) throws Exception {
        if (args.length > 1 || (args.length == 1 && !"--interactive".equals(args[0]) && !"--once".equals(args[0]))) {
            throw new IllegalArgumentException("Only --once or --interactive is supported; no URL arguments accepted");
        }
        boolean interactive = args.length == 0 || "--interactive".equals(args[0]);
        Map<String, DataSource> sources = new LinkedHashMap<>();
        sources.put("ds_0", memorySource(SHARD_0));
        sources.put("ds_1", memorySource(SHARD_1));
        seed(sources.get("ds_0"), "ui_order_0", 100L, "BOOK,100");
        seed(sources.get("ds_1"), "ui_order_1", 101L, "BOOK,101");
        System.out.println("MEMORY_ONLY shard0=" + SHARD_0);
        System.out.println("MEMORY_ONLY shard1=" + SHARD_1);
        System.out.println("MEMORY_ONLY metadata=" + METADATA);

        Properties repository = new Properties();
        repository.setProperty("provider", "H2");
        repository.setProperty("jdbc_url", METADATA);
        repository.setProperty("username", "sa");
        repository.setProperty("password", "");
        ModeConfiguration mode = new ModeConfiguration("Standalone",
                new StandalonePersistRepositoryConfiguration("JDBC", repository));
        Properties props = new Properties();
        props.setProperty("sql-show", "true");
        props.setProperty("kernel-executor-size", "2");
        try (ShardingSphereDataSource sharding = (ShardingSphereDataSource)
                ShardingSphereDataSourceFactory.createDataSource("ui_fixture", mode, sources, List.of(rules()), props)) {
            verifyAll(sharding);
            if (interactive) {
                interact(sharding);
            }
        }
        System.out.println("CLOSED: in-memory fixture completed");
    }

    private static JdbcDataSource memorySource(String url) throws SQLException {
        // 精确白名单，不能把此入口改作任意 JDBC URL 适配器。
        if (!SHARD_0.equals(url) && !SHARD_1.equals(url) && !METADATA.equals(url)) {
            throw new IllegalArgumentException("Not a fixture memory database");
        }
        JdbcDataSource source = new JdbcDataSource();
        source.setURL(url);
        source.setUser("sa");
        source.setPassword("");
        try (Connection connection = source.getConnection()) {
            if (!connection.getMetaData().getURL().startsWith("jdbc:h2:mem:")) {
                throw new AssertionError("Expected an in-memory connection");
            }
        }
        return source;
    }

    private static void seed(DataSource source, String table, long id, String reference) throws SQLException {
        if (!"ui_order_0".equals(table) && !"ui_order_1".equals(table)) {
            throw new IllegalArgumentException("Not a fixture table");
        }
        try (Connection connection = source.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE " + table
                    + " (order_id BIGINT PRIMARY KEY, reference_code VARCHAR(64), state_code INT)");
            try (PreparedStatement insert = connection.prepareStatement("INSERT INTO " + table + " VALUES (?, ?, ?)")) {
                insert.setLong(1, id);
                insert.setString(2, reference);
                insert.setInt(3, 1);
                if (insert.executeUpdate() != 1) {
                    throw new AssertionError("Expected one seed row");
                }
            }
        }
    }

    private static ShardingRuleConfiguration rules() {
        ShardingRuleConfiguration rule = new ShardingRuleConfiguration();
        ShardingTableRuleConfiguration table = new ShardingTableRuleConfiguration("ui_order", "ds_0.ui_order_0,ds_1.ui_order_1");
        table.setDatabaseShardingStrategy(new StandardShardingStrategyConfiguration("order_id", "db_inline"));
        table.setTableShardingStrategy(new StandardShardingStrategyConfiguration("order_id", "table_inline"));
        rule.getTables().add(table);
        rule.getShardingAlgorithms().put("db_inline", inline("ds_${order_id % 2}"));
        rule.getShardingAlgorithms().put("table_inline", inline("ui_order_${order_id % 2}"));
        return rule;
    }

    private static AlgorithmConfiguration inline(String expression) {
        Properties properties = new Properties();
        properties.setProperty("algorithm-expression", expression);
        return new AlgorithmConfiguration("INLINE", properties);
    }

    private static void verifyAll(DataSource source) throws SQLException {
        verifyRoute(source, 100L);
        verifyRoute(source, 101L);
        verifyCrossShard(source);
        System.out.println("PASS all: routed 100/101 plus cross-shard 2 rows; comma parameters preserved");
    }

    private static void verifyRoute(DataSource source, long id) throws SQLException {
        List<String> rows = new ArrayList<>();
        try (Connection connection = source.getConnection(); PreparedStatement query = connection.prepareStatement(BY_ID)) {
            query.setLong(1, id);
            query.setString(2, "BOOK," + id);
            try (ResultSet result = query.executeQuery()) {
                while (result.next()) {
                    rows.add(result.getLong("order_id") + ":" + result.getString("reference_code"));
                }
            }
        }
        expect("route " + id, rows, List.of(id + ":BOOK," + id));
    }

    private static void verifyCrossShard(DataSource source) throws SQLException {
        List<String> rows = new ArrayList<>();
        try (Connection connection = source.getConnection(); PreparedStatement query = connection.prepareStatement(ALL)) {
            query.setInt(1, 1);
            try (ResultSet result = query.executeQuery()) {
                while (result.next()) {
                    rows.add(result.getLong("order_id") + ":" + result.getString("reference_code"));
                }
            }
        }
        expect("cross-shard", rows, List.of("100:BOOK,100", "101:BOOK,101"));
    }

    private static void expect(String label, List<String> actual, List<String> expected) {
        // 显式断言而非 Java assert，未加 -ea 也会在错误时以非零退出。
        if (!actual.equals(expected)) {
            throw new AssertionError(label + " expected=" + expected + " actual=" + actual);
        }
        System.out.println("PASS " + label + " rows=" + actual);
    }

    private static void interact(DataSource source) throws Exception {
        System.out.println("READY: enter 100, 101, all, both (or empty line); quit to close. EOF also closes.");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String line;
        // 阻塞读取控制台输入，不使用 sleep、定时器或忙轮询。
        while ((line = input.readLine()) != null) {
            switch (line.trim()) {
                case "100": verifyRoute(source, 100L); break;
                case "101": verifyRoute(source, 101L); break;
                case "all": verifyCrossShard(source); break;
                case "":
                case "both": verifyAll(source); break;
                case "quit": return;
                default: System.out.println("Commands: 100 | 101 | all | both | quit");
            }
        }
    }
}
