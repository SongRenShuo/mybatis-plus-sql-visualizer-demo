package com.corp.shared.util;

import com.corp.platform.SqlKernel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务侧「计划树构建器」（**运行期来自依赖 JAR**）。
 *
 * <p>对齐一条真实反馈：<b>SQL 执行点不在 Service 里，而在业务自己的工具/构建类里</b>——
 * Service 只是这个构建器的一个调用方（真实项目里是「批量批查后纯内存组装树」的公共写法）。
 * 期望落点是本类的两处调用行，而不是 Service 里「调用本类」那一行。
 *
 * <p>与目录态同构类 {@code cn.song.selfdevdemo.util.PlanTreeQueryBuilder} 逐行等价，
 * 唯一差异是打包形态：本类经 {@code selfdev-shared-lib} 打成 JAR 后作为依赖加载，
 * 其 {@code ProtectionDomain.codeSource} 是 JAR —— 于是插件 agent 的 L1 来源过滤把本类
 * 连同 {@link SqlKernel} 一起当作第三方帧跳过，主位置向上顶到调用方 Service。
 * 这一对照即「跳转到父方法调用处」现象的单一变量复现。
 *
 * @author SongRenShuo
 */
public final class PlanTreeQueryBuilder {

    private PlanTreeQueryBuilder() {
    }

    /**
     * 按负责人装配「计划 → 成员」两层树。
     *
     * <p>方法内<b>两处</b> SQL 调用点（形态对齐反馈里的 :97 / :116 两处批查），
     * 之后的树装配全在内存里完成，不再触库。
     */
    public static List<Map<String, Object>> buildTreeByOwner(String owner) {
        // 调用点①：负责人名下全部有效计划
        List<Map<String, Object>> plans = SqlKernel.queryPlansByOwner(
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
            for (Map<String, Object> member : SqlKernel.queryMembersByPlanIds(
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
     * <p>E30 与 E31 两个<b>不同 Service 方法</b>都只调本方法、传不同实参——
     * 两条链在本方法处的栈形完全同构，故「首个非框架帧」的 {@code class#method} 相同，
     * 整帧缓存会把先触发者的位置服务给后触发者（跨文件串位）。
     */
    public static List<Map<String, Object>> loadPlansByIds(List<String> planIds) {
        List<Map<String, Object>> plans = SqlKernel.queryPlansByIds(planIds);
        List<String> loaded = new ArrayList<String>();
        for (Map<String, Object> plan : plans) {
            loaded.add(String.valueOf(plan.get("plan_id")));
        }
        for (Map<String, Object> plan : plans) {
            plan.put("memberCount", SqlKernel.queryMembersByPlanIds(loaded).size());
        }
        return plans;
    }
}
