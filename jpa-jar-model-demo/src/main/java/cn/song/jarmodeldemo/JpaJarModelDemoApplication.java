package cn.song.jarmodeldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 「实体/嵌入类来自依赖 JAR」复现用例启动类（端口 8088）。
 *
 * <p>本模块的实体（{@code WmsInventoryEntity} 及其三个 {@code @Embeddable}）与 Spring Data
 * 仓库接口都在依赖 JAR {@code jpa-jar-model-lib} 里——宿主模块源码树里**没有**这些类。
 * 插件按「实体所在模块」找 {@code application.yml} 时模块根不可知，只能退到工程级信号判
 * 命名约定；本模块把这个形态备齐，用来验证那条退路。
 *
 * <p>{@link EntityScan} / {@link EnableJpaRepositories} 都必须显式指向 JAR 里的包：
 * Spring Boot 默认只扫启动类所在包，不指的话 JAR 里的实体不会被登记为受管类型。
 *
 * @author SongRenShuo
 */
@SpringBootApplication
@EntityScan(basePackages = "cn.song.jarlib.entity")
@EnableJpaRepositories(basePackages = "cn.song.jarlib.repository")
public class JpaJarModelDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaJarModelDemoApplication.class, args);
    }
}
