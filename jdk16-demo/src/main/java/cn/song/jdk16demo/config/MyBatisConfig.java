package cn.song.jdk16demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * MyBatis 装配（2012~2014 时代形态：手写 SqlSessionFactoryBean + @MapperScan）。
 *
 * 为什么不用 mybatis-spring-boot-starter 自动装配（2026-11-21 实测）：其 1.3.x 的
 * MybatisAutoConfiguration 是构造器注入 ObjectProvider&lt;Interceptor[]&gt; 等参数，
 * 在宿主 JDK 17 跑构建时实例化失败——ObjectProvider 泛型实参被解析成裸 Object，
 * 报 NoUniqueBeanDefinitionException（&userMapper/systemEnvironment/contextParameters/
 * contextAttributes 四候选）；同代码 JDK 8 宿主对照通过，触发与否随 JVM 版本变化。
 * 规避＝本类的手写装配——老时代项目本来就是这套写法，与语料时代形态一致（读数见模块 README）。
 */
@Configuration
@MapperScan("cn.song.jdk16demo.mapper")
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*.xml"));
        factoryBean.setTypeAliasesPackage("cn.song.jdk16demo.entity");

        // 下划线列名 → 驼峰属性（XML 里的 resultMap 是并存的对照形态）
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        factoryBean.setConfiguration(configuration);

        return factoryBean.getObject();
    }
}
