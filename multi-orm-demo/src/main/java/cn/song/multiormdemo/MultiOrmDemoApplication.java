package cn.song.multiormdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 多 ORM 测试 Demo 启动类
 * 一个应用内共存四家 ORM：Querydsl（JPA）、MyBatis Dynamic SQL（纯构建器）、
 * xbatis（MyBatis 体系）、Easy-Query（proxy 体系），共用同一数据源 orm_demo
 *
 * @author SongRenShuo
 */
@SpringBootApplication
public class MultiOrmDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiOrmDemoApplication.class, args);
    }
}
