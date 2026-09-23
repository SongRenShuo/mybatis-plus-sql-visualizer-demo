package cn.song.selfdevdemo.service.impl;

import cn.song.selfdevdemo.service.SourceCaptureToolSiteService;
import cn.song.selfdevdemo.util.PlanTreeQueryBuilder;

import com.corp.platform.SqlKernel;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
     * <p>同一方法内两处调用点的「首个非框架帧」同为该构建器方法（key 只到 {@code class#method}、不含行号）——
     * agent 早期把结果帧整帧入缓存时，SQL② 会被冻在 SQL① 的行号上；v2026.9.23 起行号按当前栈现算，
     * 两处调用点各自落位（实测行号见模块 README E 组实测表），本用例兼作该修复的回归位。
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
     * 30. JAR 态共用入口·先触发者（与 31 成对，须按 30 → 31 顺序、同进程内连续触发）。
     *
     * <p>30 与 31 调的是同一个 JAR 构建器方法 {@code PlanTreeQueryBuilder#loadPlansByIds}，
     * 两条链在该方法处的栈形同构 ⇒ 「首个非框架帧」的 {@code class#method} 相同 ⇒ 命中同一份缓存。
     *
     * <p><b>这一对的定位＝缓存串用的回归护栏</b>：agent 早期把结果帧整帧入缓存，实测 31 会跳到
     * 30 的调用行（跨文件串位）；v2026.9.23 的 T-AgentSourceLocateStale T-01 改为
     * 「只缓存判定 + 行号按当前栈现算 + 身份在场校验」后，实测两条各落自己的调用行——
     * 本对用例用于防止该修复回退。
     */
    @Override
    public List<Map<String, Object>> jarSharedKeyFirst(List<String> planIds) {
        return com.corp.shared.util.PlanTreeQueryBuilder.loadPlansByIds(planIds);
    }

    /**
     * 31. JAR 态共用入口·后触发者。
     *
     * <p>串用维度见 30 号（当前版本已根治，此处为回归位）。<b>本用例同时是机制 A 的复现位</b>：
     * 期望落点是 JAR 里 {@code PlanTreeQueryBuilder#loadPlansByIds} 发 SQL 的那一行，
     * 实测停在下面这一行（调用方 Service）——JAR 帧被 L1 判为第三方，主位置沿栈上顶到第一个目录帧。
     */
    @Override
    public List<Map<String, Object>> jarSharedKeySecond(List<String> planIds) {
        return com.corp.shared.util.PlanTreeQueryBuilder.loadPlansByIds(planIds);
    }

    /** 32. 30 的目录态对照：同一构建器方法被两个调用方共用，但帧来自 {@code target/classes}。 */
    @Override
    public List<Map<String, Object>> directorySharedKeyFirst(List<String> planIds) {
        return PlanTreeQueryBuilder.loadPlansByIds(planIds);
    }

    /**
     * 33. 31 的目录态对照：登记 {@code cn.song.selfdevdemo.kernel.} 后，
     * 落点应为构建器自身的两处调用行（<b>不是</b>本 Service 行）——与 31 对照即可看出
     * 「同为共用入口，目录态落构建器、JAR 态落调用方」的差别只来自打包形态。
     */
    @Override
    public List<Map<String, Object>> directorySharedKeySecond(List<String> planIds) {
        return PlanTreeQueryBuilder.loadPlansByIds(planIds);
    }

    /**
     * 34. 混合来源——<b>真实现场的形状</b>：业务侧全在目录，只有平台内核在依赖 JAR，
     * 且同一个 Service 方法<b>先自己直发一条 SQL、再调业务工具类发第二条</b>。
     *
     * <p>期望落点：第一条＝本方法里 {@code SqlKernel.queryPlansByIds} 那一行；
     * 第二条＝构建器 {@code loadPlansViaPlatformKernel} 内发 SQL 的那一行。
     *
     * <p>实测（内核包<b>不登记</b>档位，见模块 README E 组实测表）：两条都落在本方法内，
     * 第二条恰好落在<b>「调用构建器」这一行</b>。成因不是 JAR 上顶，而是判定缓存：
     * 直发那条把「最深目录帧＝本方法」写进了共享 {@code entryKey} 的判定缓存；
     * 而本方法在第二条的栈上是构建器的<b>祖先帧、必然在场</b> ⇒ 「身份在场」校验形同虚设
     * ⇒ 主位置被钉在本方法，行号按当前栈现算＝本方法里调用构建器的那一行。
     * 登记 {@code com.corp.platform.} 让 entryKey 不再是共享帧后，落点恢复正确。
     */
    @Override
    public List<Map<String, Object>> mixedSourcePair(List<String> planIds) {
        SqlKernel.queryPlansByIds(planIds);
        List<String> more = new ArrayList<String>(planIds);
        more.add("PLAN_NOT_EXIST");
        return PlanTreeQueryBuilder.loadPlansViaPlatformKernel(more);
    }
}
