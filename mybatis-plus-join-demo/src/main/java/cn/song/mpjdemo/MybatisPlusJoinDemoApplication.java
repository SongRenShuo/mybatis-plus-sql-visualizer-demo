package cn.song.mpjdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MyBatis-Plus-Join Demo 启动类
 *
 * @author SongRenShuo
 */
@SpringBootApplication
@MapperScan("cn.song.mpjdemo.mapper")
public class MybatisPlusJoinDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusJoinDemoApplication.class, args);
    }
}
