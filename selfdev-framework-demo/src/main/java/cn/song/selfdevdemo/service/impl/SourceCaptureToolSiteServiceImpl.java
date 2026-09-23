package cn.song.selfdevdemo.service.impl;

import cn.song.selfdevdemo.service.SourceCaptureToolSiteService;
import cn.song.selfdevdemo.util.PlanTreeQueryBuilder;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * E 组语料实现：SQL 执行点在业务工具类里，Service 只是它的调用方。
 *
 * <p>每条链的执行时刻栈形（深 → 浅）：
 *
 * <pre>
 * 内核帧   cn.song.selfdevdemo.kernel.PlanTreeKernel#execute      ← 目录态（28/32/33）
 *          com.corp.platform.SqlKernel#execute                    ← JAR 态（29/30/31）
 * 构建器帧 cn.song.selfdevdemo.util.PlanTreeQueryBuilder#…        ← 目录态
 *          com.corp.shared.util.PlanTreeQueryBuilder#…            ← JAR 态
 * 服务帧   本类各方法                                              ← 目录态
 * </pre>
 *
 * <p>插件的期望落点是<b>构建器帧的调用行</b>（真实反馈里就是那两处批查的行号）。
 * 本组三条 JAR 态用例把「落到了 Service 的调用行」这一现象做了单一变量复现，
 * 三条目录态用例是它的对照组。逐条预期见各方法注释；实测落点见模块 README §E 组。
 *
 * @author SongRenShuo
 */
@Service
public class SourceCaptureToolSiteServiceImpl implements SourceCaptureToolSiteService {

    /**
     * 28. 目录态构建器（控制组）。
     *
     * <p>登记 {@code cn.song.selfdevdemo.kernel.}（框架层，与 JAR 组登记
     * {@code com.corp.platform.} 对称）后，本用例两条 SQL 的<b>期望主位置</b>是
     * {@code PlanTreeQueryBuilder#buildTreeByOwner} 内的两处调用行，
     * 而不是下面这一行「调用构建器」的位置。
     *
     * <p>已知残面：两条 SQL 的「首个非框架帧」同为该构建器方法（key 只到 {@code class#method}，
     * 不含行号），故第二条的落点可能被整帧缓存冻结成第一条的行号——同文件内即可观察。
     */
    @Override
    public List<Map<String, Object>> directoryBuilder(String owner) {
        return PlanTreeQueryBuilder.buildTreeByOwner(owner);
    }

    /**
     * 29. JAR 态构建器（与 28 逐行同构，唯一差异是构建器与内核都在依赖 JAR 里）。
     *
     * <p><b>期望暴露的缺陷</b>：无论是否登记 {@code com.corp.platform.}（内核）、
     * 甚至把 {@code com.corp.shared.util.}（构建器本身）也登记进去，
     * agent 的 L1 来源过滤都会把这两个 JAR 帧判为第三方并跳过，
     * 主位置沿栈上顶到<b>下面这一行</b>——即用户反馈的「跳转到父方法被调用的地方」。
     *
     * <p>注意：登记构建器包名只会让它从候选池里消失，<b>不会</b>把落点送回它——
     * 「帧过滤前缀」只有「跳过」语义，没有「提升为业务帧」的反向语义，这是本用例给作者的需求缺口。
     */
    @Override
    public List<Map<String, Object>> jarBuilder(String owner) {
        return com.corp.shared.util.PlanTreeQueryBuilder.buildTreeByOwner(owner);
    }

    /**
     * 30. JAR 态共用入口·先触发者（与 31 成对，须按 30 → 31 顺序触发）。
     *
     * <p>30 与 31 调的是同一个 JAR 构建器方法 {@code PlanTreeQueryBuilder#loadPlansByIds}，
     * 栈形同构 ⇒ 「首个非框架帧」的 {@code class#method} 相同 ⇒ 共用一份整帧缓存。
     * 本方法先执行，其调用行会被冻结进缓存。
     */
    @Override
    public List<Map<String, Object>> jarSharedKeyFirst(List<String> planIds) {
        return com.corp.shared.util.PlanTreeQueryBuilder.loadPlansByIds(planIds);
    }

    /**
     * 31. JAR 态共用入口·后触发者（<b>跨文件串位</b>的观测位）。
     *
     * <p>先触发 30 再触发本端点：本端点执行的 SQL 的跳转位置预期仍是
     * <b>30 的调用行</b>（另一文件、另一方法），而不是下面这一行——
     * 与用户反馈的「跳到别处的调用方」同形，且与帧来源无关，纯粹是 key 粒度问题。
     */
    @Override
    public List<Map<String, Object>> jarSharedKeySecond(List<String> planIds) {
        return com.corp.shared.util.PlanTreeQueryBuilder.loadPlansByIds(planIds);
    }

    /** 32. 30 的目录态对照：共用入口在目录里，合流仍应发生（证明合流与帧来源无关）。 */
    @Override
    public List<Map<String, Object>> directorySharedKeyFirst(List<String> planIds) {
        return PlanTreeQueryBuilder.loadPlansByIds(planIds);
    }

    /** 33. 31 的目录态对照：先 32 后 33，观察 33 是否落到 32 的调用行。 */
    @Override
    public List<Map<String, Object>> directorySharedKeySecond(List<String> planIds) {
        return PlanTreeQueryBuilder.loadPlansByIds(planIds);
    }
}
