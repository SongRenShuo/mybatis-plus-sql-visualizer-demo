package cn.song.oracledemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Oracle 增强捕获复现语料的启动类（无 web，CommandLineRunner 跑完即退出）。 */
@SpringBootApplication
@MapperScan("cn.song.oracledemo.mapper")
public class OracleDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OracleDemoApplication.class, args);
    }
}
