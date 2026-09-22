package cn.song.selfdevdemo.service;

import cn.song.selfdevdemo.entity.ProjectPlan;
import cn.song.selfdevdemo.entity.ProjectPlanMemberView;

import com.corp.meta.PaginResult;

import java.util.List;
import java.util.Map;

/**
 * C 组语料：**查询形态与多前缀**矩阵。
 *
 * <p>重点在分页两个用例——分页路径的执行链最深层落在 {@code com.corp.meta.PaginSupport}，
 * 因此要让主位置回到业务帧，帧过滤前缀必须**同时登记**
 * {@code com.corp.engine.} 与 {@code com.corp.meta.} 两行。
 * 这是「前缀需覆盖整条引擎链」的可复现证据。
 *
 * @author SongRenShuo
 */
public interface SourceCaptureQueryService {

    /** 17. 分页查询（普通路径 + 分页对象流转）。 */
    PaginResult<ProjectPlan> paged(String owner, int index, int size);

    /** 18. 分页 + 三层业务委托（业务候选更深）。 */
    PaginResult<ProjectPlanMemberView> pagedDeep(String planId, int index, int size);

    /** 19. 聚合计数。 */
    long count(int status);

    /** 20. 分组聚合。 */
    List<Map<String, Object>> aggregate();

    /** 21. 两表 JOIN 动态 SQL。 */
    List<Map<String, Object>> join(String planId);

    /** 22. IN 条件。 */
    List<Map<String, Object>> inCondition(List<String> planIds);

    /** 23. OR 嵌套条件树（递归渲染）。 */
    List<Map<String, Object>> orNested(String owner, int status);

    /** 24. 排序 + 限制。 */
    List<Map<String, Object>> orderLimit(String orderBy, int limit);
}
