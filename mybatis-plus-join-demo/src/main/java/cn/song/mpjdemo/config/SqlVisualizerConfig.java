package cn.song.mpjdemo.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Map;

/**
 * SQL Visualizer 源码位置捕获配置（自动生成）。
 *
 * 将 SqlSourceInterceptor 添加到 MyBatis-Plus 拦截器链中，
 * 使实时日志携带源码位置信息，支持精确跳转。
 *
 * 兼容三种场景：
 *  1. 用户已定义 MybatisPlusInterceptor bean（如 MyBatisPlusConfig）→ 追加拦截器
 *  2. MP 自动配置创建了 MybatisPlusInterceptor → 追加拦截器
 *  3. 无任何 MybatisPlusInterceptor → 自动创建并注册到容器
 *
 * 使用 SmartInitializingSingleton 确保所有 bean 初始化完成后注册，避免时序问题。
 *
 * 自动生成于 SQL Visualizer 插件，可安全删除。
 */
@Configuration
public class SqlVisualizerConfig {

    /** 定义 SqlSourceInterceptor bean（不创建 MybatisPlusInterceptor，避免 bean 名称冲突）。 */
    @Bean
    public SqlSourceInterceptor sqlSourceInterceptor() {
        return new SqlSourceInterceptor(Collections.singleton("cn.song.mpjdemo."));
    }

    /**
     * 在所有 singleton bean 初始化完成后，将 SqlSourceInterceptor 添加到 MybatisPlusInterceptor。
     *
     * - 遍历所有 MybatisPlusInterceptor bean 并追加（兼容多数据源）
     * - 无任何 MybatisPlusInterceptor 时，自动创建并注册到容器
     * - 去重检查避免重复添加
     */
    @Bean
    public SmartInitializingSingleton sqlVisualizerInterceptorRegistrar(
            ApplicationContext applicationContext) {
        return () -> {
            SqlSourceInterceptor sqlSourceInterceptor =
                    applicationContext.getBean(SqlSourceInterceptor.class);
            Map<String, MybatisPlusInterceptor> beans =
                    applicationContext.getBeansOfType(MybatisPlusInterceptor.class);

            if (beans.isEmpty()) {
                // 无任何 MybatisPlusInterceptor → 创建并注册
                MybatisPlusInterceptor newInterceptor = new MybatisPlusInterceptor();
                newInterceptor.addInnerInterceptor(sqlSourceInterceptor);
                ConfigurableListableBeanFactory factory =
                        ((ConfigurableApplicationContext) applicationContext).getBeanFactory();
                factory.registerSingleton("sqlVisualizerMybatisPlusInterceptor", newInterceptor);
            } else {
                // 追加到所有已有的 MybatisPlusInterceptor
                // 注意：不去重（兼容旧版 MP 无 getInnerInterceptors 方法）；
                // 重复添加仅导致重复打印标记行，插件只取第一个标记
                for (MybatisPlusInterceptor mpInterceptor : beans.values()) {
                    mpInterceptor.addInnerInterceptor(sqlSourceInterceptor);
                }
            }
        };
    }
}