package cn.song.selfdevdemo.service;

import java.util.List;
import java.util.Map;

/**
 * E 组语料：SQL 执行点位于<b>业务工具/构建类</b>内（对齐真实用户反馈的场景形状）。
 *
 * <p>六条链按 2×2 实验设计排布——自变量只有两个：
 * <b>帧来源（目录 / JAR）</b>与<b>调用方是否唯一（单入口 / 多入口共用同一构建器方法）</b>。
 *
 * @author SongRenShuo
 */
public interface SourceCaptureToolSiteService {

    /** 28. 目录态构建器：两处调用点（控制组，期望落构建器）。 */
    List<Map<String, Object>> directoryBuilder(String owner);

    /** 29. JAR 态构建器：同 28 形态，仅打包形态不同（期望暴露「上顶到调用方」）。 */
    List<Map<String, Object>> jarBuilder(String owner);

    /** 30. JAR 态共用入口·先触发者（与 31 构成跨调用方合流对）。 */
    List<Map<String, Object>> jarSharedKeyFirst(List<String> planIds);

    /** 31. JAR 态共用入口·后触发者（期望暴露「跳到别人的调用行」）。 */
    List<Map<String, Object>> jarSharedKeySecond(List<String> planIds);

    /** 32. 目录态共用入口·先触发者（30 的目录态对照）。 */
    List<Map<String, Object>> directorySharedKeyFirst(List<String> planIds);

    /** 33. 目录态共用入口·后触发者（31 的目录态对照）。 */
    List<Map<String, Object>> directorySharedKeySecond(List<String> planIds);

    /**
     * 34. 混合来源（**真实现场形状**）：同一方法内先直发一条 SQL、再经业务工具类发第二条，
     * 而平台内核位于未登记的依赖 JAR 里。
     */
    List<Map<String, Object>> mixedSourcePair(List<String> planIds);
}
