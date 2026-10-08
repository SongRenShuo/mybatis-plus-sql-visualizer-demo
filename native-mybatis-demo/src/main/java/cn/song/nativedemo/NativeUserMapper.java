package cn.song.nativedemo;

import java.util.List;

/**
 * 原生 Mapper 接口（非 MP BaseMapper）：注入生成物落点约定——
 * 插件注入时在 {@code cn.song.nativedemo.config} 包生成 SqlSourceInterceptor 与
 * SqlVisualizerNativePlugin 两件，并把 {@code SqlVisualizerNativePlugin} 注册进
 * mybatis-config.xml 的 &lt;plugins&gt;。
 */
public interface NativeUserMapper {

    List<NativeUser> selectByStatus(Integer status);

    int countByStatus(Integer status);
}
