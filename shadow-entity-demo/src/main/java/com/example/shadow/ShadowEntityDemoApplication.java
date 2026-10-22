package com.example.shadow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * 「同包同名影子实体」复现用例启动类（端口 8089 / 库 jpa_demo）。
 *
 * <p>本模块专门复现：HQL 与执行它的 DAO 方法都在依赖 JAR 内、HQL 引用的实体也在同一个 JAR
 * 内，而宿主工程源码里又新增了一份同包同名（同 FQN）的类（「影子类」，字段有差异）。
 * 运行期实际生效的是宿主那份（工程输出目录在 classpath 上先于依赖 JAR）。
 *
 * <p>组件扫描与实体扫描都覆盖 {@code com.example.shadow}：
 * <ul>
 *   <li>{@code com.example.shadow.model}——宿主影子实体（JAR 里那份同 FQN 类被 classpath 序压过，不生效）；</li>
 *   <li>{@code com.example.shadow.dao} / {@code com.example.shadow.service}——JAR 里的 DAO 与 service
 *       （{@code @Repository} / {@code @Service} 由本次扫描装配）。</li>
 * </ul>
 *
 * <p>跑起来即自证：{@code GET /shadow/entity} 读运行期 {@code WmsTask.class} 上的
 * {@code @Table} 与 code source，会看到表名 {@code wms_task_project}、
 * 路径指向本模块 {@code target/classes} 而非依赖 JAR。
 *
 * @author SongRenShuo
 */
@SpringBootApplication
@EntityScan("com.example.shadow.model")
public class ShadowEntityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShadowEntityDemoApplication.class, args);
    }
}
