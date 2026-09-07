package cn.song.kotlindemo

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Kotlin 场景模块启动类
 *
 * @author SongRenShuo
 */
@SpringBootApplication
@MapperScan("cn.song.kotlindemo.mapper")
class KotlinDemoApplication

fun main(args: Array<String>) {
    runApplication<KotlinDemoApplication>(*args)
}
