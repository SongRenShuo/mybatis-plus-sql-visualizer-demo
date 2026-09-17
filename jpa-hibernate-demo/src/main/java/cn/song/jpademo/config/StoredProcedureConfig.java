package cn.song.jpademo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 存储过程初始化配置
 * Spring 的 SQL 脚本初始化（schema.sql）按分号切分语句，无法承载含 BEGIN..END 的存储过程体，
 * 故经 JdbcTemplate.execute 以单条 JDBC 语句幂等创建，供 UserRepository 的 @Procedure 场景调用
 *
 * @author SongRenShuo
 */
@Configuration
public class StoredProcedureConfig {

    private static final Logger log = LoggerFactory.getLogger(StoredProcedureConfig.class);

    @Bean
    public CommandLineRunner countUsersProcedureInitializer(JdbcTemplate jdbcTemplate) {
        return args -> {
            try {
                jdbcTemplate.execute("DROP PROCEDURE IF EXISTS count_users_by_status");
                jdbcTemplate.execute("CREATE PROCEDURE count_users_by_status(IN p_status INT, OUT p_count INT) "
                        + "BEGIN SELECT COUNT(*) INTO p_count FROM `user` WHERE status = p_status; END");
                log.info("[StoredProcedureConfig] 存储过程 count_users_by_status 初始化完成");
            } catch (Exception e) {
                log.warn("[StoredProcedureConfig] 存储过程初始化失败（不影响其余功能）: {}", e.getMessage());
            }
        };
    }
}
