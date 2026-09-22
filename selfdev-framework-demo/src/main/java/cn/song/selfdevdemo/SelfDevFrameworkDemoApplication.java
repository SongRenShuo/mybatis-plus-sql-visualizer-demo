package cn.song.selfdevdemo;

import com.corp.engine.config.EngineConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * 自研框架帧过滤前缀测试 Demo 启动类。
 *
 * <p>业务代码在 {@code cn.song.selfdevdemo} 下（组件扫描默认范围），模拟自研框架在
 * {@code com.corp.*} 下——框架包不在扫描范围内，故显式 {@code @Import} 其装配配置，
 * 等价于真实项目里框架经 starter / {@code spring.factories} 自动装配。
 *
 * @author SongRenShuo
 */
@SpringBootApplication
@Import(EngineConfiguration.class)
public class SelfDevFrameworkDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelfDevFrameworkDemoApplication.class, args);
    }
}
