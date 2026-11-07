package cn.song.mybatisplusdemo.config;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.Connection;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PG 族保留字表名修正配置（gaussdb / pg profile 生效）
 *
 * <p>根因：{@code user} 在 PG 族（PostgreSQL、GaussDB Kernel 503.1.0、PanWeiDB 等兼容模式 A 系）
 * 里是保留字/系统函数名。建表必须写 {@code create table "user" (...)}，否则报
 * {@code syntax error at or near "user"}；查询时裸 {@code user} 会被解析成内置系统函数
 * {@code user}（即 {@code current_user}，实测 {@code select count(*) from user} 返回 1 行，
 * 而 {@code select count(*) from "user"} 返回种子数据的 4 行），于是 demo 里所有
 * {@code @TableName("user")} 生成的 SQL 报 {@code column "id" does not exist} /
 * {@code column "deleted" does not exist}。
 *
 * <p>修法：在 MyBatis 层把表名 {@code user} 补成 {@code "user"}。
 * 没有用 MP 的 {@code DynamicTableNameInnerInterceptor + TableNameHandler}，原因是动态表名只覆盖
 * MP 自动生成的语句，而本 demo 还有大量手写 SQL 直接带表名（{@code UserMapper.xml} 的
 * {@code from user}/{@code update user}、{@code UserMapper} 的 {@code @Select("SELECT * FROM user ...")}、
 * {@code DepartmentMapper.xml}/{@code OrderMapper.xml} 的 join 子查询），这些不会被 TableNameHandler 改写。
 * 这里改为拦 {@link StatementHandler#prepare}，作用点是最终要执行的 SQL 文本，
 * 无论 SQL 来自 MP 注入、XML、注解还是 SqlProvider 都一并修正；分页 count 语句也在这一步之前生成完，
 * 因此 COUNT 包裹后的语句同样被改写。
 *
 * <p>只在 {@code from / into / update / join / table} 后面紧跟 {@code user} 整词时加引号：
 * 已带引号的 {@code "user"} 不重复加（{@code \s+} 后是引号，不匹配），
 * {@code user_role} / {@code user_id} 这类以下划线续写的标识符也不匹配（{@code \b} 在 {@code _} 前不成立）。
 *
 * @author SongRenShuo
 */
@Configuration
@Profile({"gaussdb", "pg"})
public class PgFamilyReservedWordConfig {

    /**
     * 注册保留字表名修正拦截器。
     * MyBatis-Spring 会把容器里的 {@link Interceptor} Bean 自动挂到 SqlSessionFactory 上，
     * 因此只需声明 Bean，不必手动 {@code configuration.addInterceptor}。
     */
    @Bean
    public Interceptor pgFamilyReservedWordInterceptor() {
        return new ReservedWordTableNameInterceptor();
    }

    /**
     * 把 SQL 里的裸 {@code user} 表名改写成 {@code "user"}。
     */
    @Intercepts(@Signature(type = StatementHandler.class, method = "prepare",
            args = {Connection.class, Integer.class}))
    public static class ReservedWordTableNameInterceptor implements Interceptor {

        /**
         * 表名引用关键字 + 裸 user 整词；$1 保留原关键字的大小写
         */
        private static final Pattern BARE_USER_TABLE =
                Pattern.compile("(?i)\\b(from|into|update|join|table)\\s+user\\b");

        @Override
        public Object intercept(Invocation invocation) throws Throwable {
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            // getBoundSql 是接口方法，即使 target 是 Plugin 代理也会转发到真实 StatementHandler；
            // 拿到 BoundSql 对象后直接改它的私有 sql 字段（MetaObject 走反射，与 MP 分页插件同一种做法）
            BoundSql boundSql = statementHandler.getBoundSql();
            MetaObject metaObject = SystemMetaObject.forObject(boundSql);
            String sql = (String) metaObject.getValue("sql");
            if (sql != null) {
                Matcher matcher = BARE_USER_TABLE.matcher(sql);
                if (matcher.find()) {
                    metaObject.setValue("sql", matcher.replaceAll("$1 \"user\""));
                }
            }
            return invocation.proceed();
        }

        @Override
        public Object plugin(Object target) {
            // 只包 StatementHandler，避免无谓地代理 Executor / ResultSetHandler
            return target instanceof StatementHandler ? Plugin.wrap(target, this) : target;
        }

        @Override
        public void setProperties(Properties properties) {
            // 无需外部配置
        }
    }
}
