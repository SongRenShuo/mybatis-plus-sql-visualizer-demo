package cn.song.selfdevdemo.util;

import cn.song.selfdevdemo.kernel.PlanTreeKernel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务侧「计划树构建器」的<b>目录态同构类</b>（E28 控制组）。
 *
 * <p>与 JAR 态的 {@code com.corp.shared.util.PlanTreeQueryBuilder} 逐行等价：
 * 同样在<b>业务工具类</b>里发出两处批量查询、之后纯内存组装树，
 * 差别只有两件事——本类编译进 {@code target/classes}（目录来源），
 * 且委托目录态 {@link PlanTreeKernel} 而非 JAR 内核。
 *
 * <p>期望落点：登记 {@code cn.song.selfdevdemo.kernel.}（框架层）后，
 * 主位置精确落在本类的两处调用行；而 E29（同形态、JAR 来源）会落到调用方 Service 一行。
 * 两者对比即「为什么同为业务代码，一个跳得对、一个跳不对」的单一变量证据。
 *
 * @author SongRenShuo
 */
public final class PlanTreeQueryBuilder {

    private static volatile PlanTreeKernel kernel;

    private PlanTreeQueryBuilder() {
    }

    /** 由装配期注入内核（与 {@code SqlKernel.init} 对称）。 */
    public static void init(PlanTreeKernel target) {
        kernel = target;
    }

    private static PlanTreeKernel kernel() {
        PlanTreeKernel current = kernel;
        if (current == null) {
            throw new IllegalStateException("PlanTreeQueryBuilder 未初始化：请确认 SharedLibConfiguration 已装配");
        }
        return current;
    }

    /**
     * 按负责人装配「计划 → 成员」两层树。
     *
     * <p>方法内<b>两处</b> SQL 调用点（形态对齐反馈里的两处批查），
     * 之后的树装配全在内存里完成，不再触库。
     */
    public static List<Map<String, Object>> buildTreeByOwner(String owner) {
        // 调用点①：负责人名下全部有效计划
        List<Map<String, Object>> plans = kernel().queryPlansByOwner(
                owner);

        List<String> planIds = new ArrayList<String>();
        for (Map<String, Object> plan : plans) {
            Object planId = plan.get("plan_id");
            if (planId != null) {
                planIds.add(String.valueOf(planId));
            }
        }

        // 调用点②：按编号批查成员，随后在内存里挂成 children
        Map<String, List<Map<String, Object>>> memberByPlanId =
                new LinkedHashMap<String, List<Map<String, Object>>>();
        if (!planIds.isEmpty()) {
            for (Map<String, Object> member : kernel().queryMembersByPlanIds(
                    planIds)) {
                String planId = String.valueOf(member.get("plan_id"));
                List<Map<String, Object>> bucket = memberByPlanId.get(planId);
                if (bucket == null) {
                    bucket = new ArrayList<Map<String, Object>>();
                    memberByPlanId.put(planId, bucket);
                }
                bucket.add(member);
            }
        }

        List<Map<String, Object>> tree = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> plan : plans) {
            Map<String, Object> node = new LinkedHashMap<String, Object>(plan);
            node.put("children", memberByPlanId.get(String.valueOf(plan.get("plan_id"))));
            tree.add(node);
        }
        return tree;
    }

    /**
     * 按编号批查计划并挂上成员。
     *
     * <p>目录态的「多调用方共用入口」，与 JAR 版同构，供 E30/E31 的对照档位使用。
     */
    public static List<Map<String, Object>> loadPlansByIds(List<String> planIds) {
        List<Map<String, Object>> plans = kernel().queryPlansByIds(planIds);
        List<String> loaded = new ArrayList<String>();
        for (Map<String, Object> plan : plans) {
            loaded.add(String.valueOf(plan.get("plan_id")));
        }
        for (Map<String, Object> plan : plans) {
            plan.put("memberCount", kernel().queryMembersByPlanIds(loaded).size());
        }
        return plans;
    }
}
