package cn.song.jdk16demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * JDK 1.6 + Spring Boot 1.5.22 语料宿主。
 *
 * 启动前提：本机 MySQL（root/root）里存在 jdk16_demo 库；
 * db/schema.sql 随启动自动重建（Boot 1.x 对外部库也默认执行 schema 脚本）。
 */
@SpringBootApplication
@MapperScan("cn.song.jdk16demo.mapper")
public class Jdk16DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Jdk16DemoApplication.class, args);
    }
}
