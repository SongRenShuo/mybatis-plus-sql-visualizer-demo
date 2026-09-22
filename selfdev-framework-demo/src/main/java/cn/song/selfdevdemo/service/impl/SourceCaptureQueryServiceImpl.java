package cn.song.selfdevdemo.service.impl;

import cn.song.selfdevdemo.common.SchemaCodes;
import cn.song.selfdevdemo.entity.ProjectPlan;
import cn.song.selfdevdemo.entity.ProjectPlanMemberView;
import cn.song.selfdevdemo.service.DepthMiddleService;
import cn.song.selfdevdemo.service.SourceCaptureQueryService;

import com.corp.engine.DataUpdateTool;
import com.corp.meta.FilterExpression;
import com.corp.meta.PaginQuery;
import com.corp.meta.PaginResult;
import com.corp.meta.Q;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * C 组语料实现：查询形态与多前缀矩阵。
 *
 * @author SongRenShuo
 */
@Service
public class SourceCaptureQueryServiceImpl implements SourceCaptureQueryService {

    @Autowired
    private DepthMiddleService depthMiddleService;

    /**
     * 17. 分页查询（分页对象流转）。
     *
     * <p>执行链：本方法 → {@code DataUpdateTool.findByFilterPaged} → {@code LocalDbService.queryPage}
     * → {@code DmlRepository.queryPaged} → {@code com.corp.meta.PaginSupport.wrapAndQuery} → JDBC。
     * 最深层在 {@code com.corp.meta} 包——只登记 {@code com.corp.engine.} 不足以回到业务帧。
     *
     * <p>注意：分页会发两条 SQL（总数 + 分页数据），面板上应看到同位置两条事件。
     */
    @Override
    public PaginResult<ProjectPlan> paged(String owner, int index, int size) {
        FilterExpression filter = Q.it("owner", FilterExpression.Op.EQ, owner);
        return DataUpdateTool.findByFilterPaged(SchemaCodes.PROJECT_PLAN, filter,
                new PaginQuery(index, size, "create_time desc"), ProjectPlan.class);
    }

    /**
     * 18. 分页 + 三层业务委托。
     *
     * <p>业务帧三层（本方法 → 中间层 → 内层）+ 分页最深层（{@code com.corp.meta}）同时在场，
     * 是两个维度叠加的最复杂形态：需要两个前缀才能落到 {@code DepthInnerServiceImpl#innerPage}。
     */
    @Override
    public PaginResult<ProjectPlanMemberView> pagedDeep(String planId, int index, int size) {
        return depthMiddleService.middlePage(planId, new PaginQuery(index, size, "id"));
    }

    /** 19. 聚合计数。 */
    @Override
    public long count(int status) {
        return DataUpdateTool.countByFilter(SchemaCodes.PROJECT_PLAN,
                Q.it("status", FilterExpression.Op.EQ, status));
    }

    /** 20. 分组聚合（按 status 统计条数与金额合计）。 */
    @Override
    public List<Map<String, Object>> aggregate() {
        return DataUpdateTool.groupSummary(SchemaCodes.PROJECT_PLAN, null, "status");
    }

    /**
     * 21. 两表 JOIN 动态 SQL。
     *
     * <p>业务侧只给 schemaCode 与逻辑字段名；JOIN 表达式与表别名由框架元数据登记，
     * 最终 SQL 形如 {@code SELECT p.id, ... FROM biz_project_plan p LEFT JOIN biz_project_member m ON ...}。
     */
    @Override
    public List<Map<String, Object>> join(String planId) {
        return DataUpdateTool.findByFilter(SchemaCodes.PROJECT_PLAN_MEMBER,
                Q.it("plan_id", FilterExpression.Op.EQ, planId));
    }

    /** 22. IN 条件（参数名逐个展开为 :p0 :p1 ...）。 */
    @Override
    public List<Map<String, Object>> inCondition(List<String> planIds) {
        FilterExpression filter = Q.and(
                Q.in("plan_id", planIds),
                Q.it("status", FilterExpression.Op.NE, 0));
        return DataUpdateTool.findByFilter(SchemaCodes.PROJECT_PLAN, filter);
    }

    /** 23. OR 嵌套条件树（分组节点递归渲染，SQL 中出现括号）。 */
    @Override
    public List<Map<String, Object>> orNested(String owner, int status) {
        FilterExpression filter = Q.and(
                Q.or(
                        Q.it("owner", FilterExpression.Op.EQ, owner),
                        Q.it("owner", FilterExpression.Op.EQ, "lisi")),
                Q.it("status", FilterExpression.Op.EQ, status));
        return DataUpdateTool.findByFilter(SchemaCodes.PROJECT_PLAN, filter);
    }

    /** 24. 排序 + 限制（排序字段走元数据白名单映射）。 */
    @Override
    public List<Map<String, Object>> orderLimit(String orderBy, int limit) {
        return DataUpdateTool.findByFilterOrdered(SchemaCodes.PROJECT_PLAN,
                Q.isNotNull("owner"), orderBy, limit);
    }
}
