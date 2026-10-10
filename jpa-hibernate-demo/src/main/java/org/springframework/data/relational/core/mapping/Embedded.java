package org.springframework.data.relational.core.mapping;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <b>语料桩（非真实依赖）</b>：本类是 Sql Visualizer 插件 T-Embedded G1 语料的
 * 同 FQN 桩注解，形态对齐 Spring Data Relational 3.1 的
 * {@code org.springframework.data.relational.core.mapping.Embedded}。
 *
 * <p>背景：Boot 2.6.3 线（spring-data-relational 2.3）没有 {@code @Embedded.Nullable}/
 * {@code @Embedded.Empty} 捷径注解（3.1+ 才有，且 3.x 需 Java 17），真实引入会与 BOM 冲突。
 * 插件按「注解可解析走全名判定（轨 1）」识别本桩，demo 本地建类既保证编译通过、
 * 又精确复现「真实项目 classpath 有 SD jar」的 PSI 形态。
 *
 * <p>若 jpa-demo 未来升级 Boot 3 线，须<b>删除本桩</b>换真实依赖。
 *
 * @author SongRenShuo
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Embedded {

    /** 列名前缀：拼在嵌入对象每一列之前（同一值对象多处嵌入防撞车）；插件按官方语义读取 */
    String prefix() default "";

    /** 嵌入列缺失时的行为（桩内仅占位，插件不读取） */
    OnNotFound onNotFound() default OnNotFound.USE_NULL;

    /** 全部嵌入列为 null 时整体映射为空对象（快捷形态） */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface Empty {
    }

    /** 全部嵌入列为 null 时整体映射为 null（快捷形态） */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface Nullable {
    }

    /** 桩内占位枚举（对齐 SD OnNotFound 语义子集） */
    enum OnNotFound {
        /** 抛映射异常 */
        ERROR,
        /** 映射为 null */
        USE_NULL
    }
}
