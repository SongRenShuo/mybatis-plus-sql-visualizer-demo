package cn.song.selfdevdemo.controller;

import cn.song.selfdevdemo.entity.ProjectPlan;
import cn.song.selfdevdemo.entity.ProjectPlanMemberView;
import cn.song.selfdevdemo.service.SourceCaptureDepthService;
import cn.song.selfdevdemo.service.SourceCaptureQueryService;
import cn.song.selfdevdemo.service.SourceCaptureStyleService;
import cn.song.selfdevdemo.service.SourceCaptureToolSiteService;
import cn.song.selfdevdemo.service.SourceCaptureWriteService;

import com.corp.meta.PaginResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 自研框架帧过滤前缀测试控制器：33 个用例端点 + 1 个索引端点。
 *
 * <p>所有端点都真实执行 SQL，用于在 IDEA 中配合插件的「增强捕获」观察
 * 「源码捕获帧过滤前缀」登记前后的跳转落点差异。逐用例的预期见各 Service 的方法注释，
 * 也可直接访问 {@code GET /selfdev/index} 取场景矩阵。
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/selfdev")
public class SelfDevFrameworkController {

    @Autowired
    private SourceCaptureStyleService styleService;

    @Autowired
    private SourceCaptureDepthService depthService;

    @Autowired
    private SourceCaptureQueryService queryService;

    @Autowired
    private SourceCaptureWriteService writeService;

    @Autowired
    private SourceCaptureToolSiteService toolSiteService;

    // ==================== 索引 ====================

    /**
     * GET /selfdev/index
     *
     * <p>返回五组用例的端点清单，便于逐条 curl 或逐条在 IDEA 中触发。
     */
    @GetMapping("/index")
    public Map<String, Object> index() {
        Map<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("A-调用形态", Arrays.asList(
                "GET  /selfdev/style/static-call?status=1",
                "GET  /selfdev/style/bean-call?status=1",
                "GET  /selfdev/style/fluent-chain?owner=lisi&limit=5",
                "GET  /selfdev/style/lambda-callback?planId=PLAN_2026001",
                "GET  /selfdev/style/anonymous-callback?planId=PLAN_2026001",
                "GET  /selfdev/style/jdk-proxy?status=1",
                "GET  /selfdev/style/reflection?planId=PLAN_2026001",
                "GET  /selfdev/style/helper-wrapped?owner=lisi",
                "GET  /selfdev/style/async-future?status=1",
                "GET  /selfdev/style/executor-pool?owner=lisi",
                "POST /selfdev/style/batch-loop?planIds=PLAN_2026001,PLAN_2026002,PLAN_2026003",
                "GET  /selfdev/style/combined-nested?planId=PLAN_2026001&owner=lisi"));
        result.put("B-委托深度", Arrays.asList(
                "GET  /selfdev/depth/shallow?status=1",
                "GET  /selfdev/depth/deep-three?planId=PLAN_2026001",
                "GET  /selfdev/depth/cross-service?owner=lisi&limit=5",
                "GET  /selfdev/depth/same-package-delegate?owner=lisi"));
        result.put("C-查询形态", Arrays.asList(
                "GET  /selfdev/query/paged?owner=lisi&index=1&size=2",
                "GET  /selfdev/query/paged-deep?planId=PLAN_2026001&index=1&size=5",
                "GET  /selfdev/query/count?status=1",
                "GET  /selfdev/query/aggregate",
                "GET  /selfdev/query/join?planId=PLAN_2026001",
                "GET  /selfdev/query/in-condition?planIds=PLAN_2026001,PLAN_2026002",
                "GET  /selfdev/query/or-nested?owner=zhangsan&status=1",
                "GET  /selfdev/query/order-limit?orderBy=amount%20desc&limit=3"));
        result.put("D-写路径", Arrays.asList(
                "POST /selfdev/write/update?planId=PLAN_2026005&projectName=quality-trace-updated",
                "POST /selfdev/write/delete?planId=PLAN_NOT_EXIST",
                "POST /selfdev/write/batch-update?planIds=PLAN_2026001,PLAN_2026002&status=1"));
        result.put("E-执行点在业务工具类", Arrays.asList(
                "GET  /selfdev/tool/directory-builder?owner=lisi                      ← 目录态对照，期望落构建器两处调用行",
                "GET  /selfdev/tool/jar-builder?owner=lisi                            ← JAR 态同形态，期望暴露上顶到本 Service",
                "GET  /selfdev/tool/jar-shared-first?planIds=PLAN_2026001,PLAN_2026002      ← 先触发",
                "GET  /selfdev/tool/jar-shared-second?planIds=PLAN_2026003,PLAN_2026004,PLAN_2026005 ← 后触发，期望暴露跨文件串位",
                "GET  /selfdev/tool/dir-shared-first?planIds=PLAN_2026001,PLAN_2026002      ← 32：目录态合流对照，先触发",
                "GET  /selfdev/tool/dir-shared-second?planIds=PLAN_2026003,PLAN_2026004,PLAN_2026005 ← 33：目录态合流对照，后触发"));
        result.put("前缀登记建议", Arrays.asList(
                "普通端点：登记 com.corp.engine.",
                "分页端点（paged / paged-deep）：额外登记 com.corp.meta.",
                "E 组目录态（28/32/33）：登记 cn.song.selfdevdemo.kernel.",
                "E 组 JAR 态（29/30/31）：登记 com.corp.platform.（登记与不登记，落点都停在 Service——这正是待查项）",
                "切勿登记业务包 cn.song.selfdevdemo.（会把真实业务帧一并跳过）"));
        return result;
    }

    // ==================== A 组：调用形态 ====================

    /** 1. 静态门面直调。 */
    @GetMapping("/style/static-call")
    public List<Map<String, Object>> staticCall(@RequestParam(defaultValue = "1") int status) {
        return styleService.staticCall(status);
    }

    /** 2. 注入的 Bean 门面调用。 */
    @GetMapping("/style/bean-call")
    public List<Map<String, Object>> beanCall(@RequestParam(defaultValue = "1") int status) {
        return styleService.beanCall(status);
    }

    /** 3. 链式构建器终结。 */
    @GetMapping("/style/fluent-chain")
    public List<Map<String, Object>> fluentChain(@RequestParam(defaultValue = "lisi") String owner,
                                                 @RequestParam(defaultValue = "5") int limit) {
        return styleService.fluentChain(owner, limit);
    }

    /** 4. lambda 回调模板。 */
    @GetMapping("/style/lambda-callback")
    public List<Map<String, Object>> lambdaCallback(
            @RequestParam(defaultValue = "PLAN_2026001") String planId) {
        return styleService.lambdaCallback(planId);
    }

    /** 5. 匿名内部类回调。 */
    @GetMapping("/style/anonymous-callback")
    public List<Map<String, Object>> anonymousCallback(
            @RequestParam(defaultValue = "PLAN_2026001") String planId) {
        return styleService.anonymousCallback(planId);
    }

    /** 6. JDK 动态代理门面。 */
    @GetMapping("/style/jdk-proxy")
    public List<Map<String, Object>> jdkProxyCall(@RequestParam(defaultValue = "1") int status) {
        return styleService.jdkProxyCall(status);
    }

    /** 7. 反射调用门面。 */
    @GetMapping("/style/reflection")
    public Map<String, Object> reflectionCall(
            @RequestParam(defaultValue = "PLAN_2026001") String planId) {
        return styleService.reflectionCall(planId);
    }

    /** 8. 业务层包装壳。 */
    @GetMapping("/style/helper-wrapped")
    public List<Map<String, Object>> helperWrapped(@RequestParam(defaultValue = "lisi") String owner) {
        return styleService.helperWrapped(owner);
    }

    /** 9. CompletableFuture 异线程执行。 */
    @GetMapping("/style/async-future")
    public List<Map<String, Object>> asyncFuture(@RequestParam(defaultValue = "1") int status) {
        return styleService.asyncFuture(status);
    }

    /** 10. 自定义线程池执行。 */
    @GetMapping("/style/executor-pool")
    public List<Map<String, Object>> executorPool(@RequestParam(defaultValue = "lisi") String owner) {
        return styleService.executorPool(owner);
    }

    /** 11. 循环批量调用。 */
    @PostMapping("/style/batch-loop")
    public List<Map<String, Object>> batchLoop(
            @RequestParam(defaultValue = "PLAN_2026001,PLAN_2026002,PLAN_2026003") String planIds) {
        return styleService.batchLoop(split(planIds));
    }

    /** 12. 单方法内两次不同条件调用。 */
    @GetMapping("/style/combined-nested")
    public List<Map<String, Object>> combinedNested(
            @RequestParam(defaultValue = "PLAN_2026001") String planId,
            @RequestParam(defaultValue = "lisi") String owner) {
        return styleService.combinedNested(planId, owner);
    }

    // ==================== B 组：委托深度 ====================

    /** 13. 浅层：服务直连门面。 */
    @GetMapping("/depth/shallow")
    public List<Map<String, Object>> shallow(@RequestParam(defaultValue = "1") int status) {
        return depthService.shallow(status);
    }

    /** 14. 三层业务委托。 */
    @GetMapping("/depth/deep-three")
    public List<Map<String, Object>> deepThree(
            @RequestParam(defaultValue = "PLAN_2026001") String planId) {
        return depthService.deepThree(planId);
    }

    /** 15. 跨服务协作。 */
    @GetMapping("/depth/cross-service")
    public List<Map<String, Object>> crossService(@RequestParam(defaultValue = "lisi") String owner,
                                                  @RequestParam(defaultValue = "5") int limit) {
        return depthService.crossService(owner, limit);
    }

    /** 16. 业务包内委托壳（负例：该包不应登记为前缀）。 */
    @GetMapping("/depth/same-package-delegate")
    public List<Map<String, Object>> samePackageDelegate(
            @RequestParam(defaultValue = "lisi") String owner) {
        return depthService.viaBusinessDelegate(owner);
    }

    // ==================== C 组：查询形态 ====================

    /** 17. 分页查询（需两个前缀）。 */
    @GetMapping("/query/paged")
    public PaginResult<ProjectPlan> paged(@RequestParam(defaultValue = "lisi") String owner,
                                          @RequestParam(defaultValue = "1") int index,
                                          @RequestParam(defaultValue = "2") int size) {
        return queryService.paged(owner, index, size);
    }

    /** 18. 分页 + 三层业务委托（需两个前缀）。 */
    @GetMapping("/query/paged-deep")
    public PaginResult<ProjectPlanMemberView> pagedDeep(
            @RequestParam(defaultValue = "PLAN_2026001") String planId,
            @RequestParam(defaultValue = "1") int index,
            @RequestParam(defaultValue = "5") int size) {
        return queryService.pagedDeep(planId, index, size);
    }

    /** 19. 聚合计数。 */
    @GetMapping("/query/count")
    public long count(@RequestParam(defaultValue = "1") int status) {
        return queryService.count(status);
    }

    /** 20. 分组聚合。 */
    @GetMapping("/query/aggregate")
    public List<Map<String, Object>> aggregate() {
        return queryService.aggregate();
    }

    /** 21. 两表 JOIN 动态 SQL。 */
    @GetMapping("/query/join")
    public List<Map<String, Object>> join(@RequestParam(defaultValue = "PLAN_2026001") String planId) {
        return queryService.join(planId);
    }

    /** 22. IN 条件。 */
    @GetMapping("/query/in-condition")
    public List<Map<String, Object>> inCondition(
            @RequestParam(defaultValue = "PLAN_2026001,PLAN_2026002") String planIds) {
        return queryService.inCondition(split(planIds));
    }

    /** 23. OR 嵌套条件树。 */
    @GetMapping("/query/or-nested")
    public List<Map<String, Object>> orNested(@RequestParam(defaultValue = "zhangsan") String owner,
                                              @RequestParam(defaultValue = "1") int status) {
        return queryService.orNested(owner, status);
    }

    /** 24. 排序 + 限制。 */
    @GetMapping("/query/order-limit")
    public List<Map<String, Object>> orderLimit(
            @RequestParam(defaultValue = "amount desc") String orderBy,
            @RequestParam(defaultValue = "3") int limit) {
        return queryService.orderLimit(orderBy, limit);
    }

    // ==================== D 组：写路径 ====================

    /** 25. 按条件更新。 */
    @PostMapping("/write/update")
    public int update(@RequestParam(defaultValue = "PLAN_2026005") String planId,
                      @RequestParam(defaultValue = "quality-trace-updated") String projectName) {
        return writeService.update(planId, projectName);
    }

    /** 26. 按条件删除（默认传不存在的编号，避免破坏后续用例的数据）。 */
    @PostMapping("/write/delete")
    public int delete(@RequestParam(defaultValue = "PLAN_NOT_EXIST") String planId) {
        return writeService.delete(planId);
    }

    /** 27. 循环更新。 */
    @PostMapping("/write/batch-update")
    public int batchUpdate(
            @RequestParam(defaultValue = "PLAN_2026001,PLAN_2026002") String planIds,
            @RequestParam(defaultValue = "1") int status) {
        return writeService.batchUpdate(split(planIds), status);
    }

    // ==================== E 组：执行点在业务工具类 ====================

    /** 28. 目录态构建器（控制组）：SQL 执行点在业务构建类里，期望落该类调用行。 */
    @GetMapping("/tool/directory-builder")
    public List<Map<String, Object>> directoryBuilder(
            @RequestParam(defaultValue = "lisi") String owner) {
        return toolSiteService.directoryBuilder(owner);
    }

    /** 29. JAR 态构建器：与 28 逐行同构，唯一差异是构建器与内核来自依赖 JAR。 */
    @GetMapping("/tool/jar-builder")
    public List<Map<String, Object>> jarBuilder(@RequestParam(defaultValue = "lisi") String owner) {
        return toolSiteService.jarBuilder(owner);
    }

    /** 30. JAR 态共用入口·先触发者（与 31 成对）。 */
    @GetMapping("/tool/jar-shared-first")
    public List<Map<String, Object>> jarSharedFirst(
            @RequestParam(defaultValue = "PLAN_2026001,PLAN_2026002") String planIds) {
        return toolSiteService.jarSharedKeyFirst(split(planIds));
    }

    /** 31. JAR 态共用入口·后触发者：预期仍跳到 30 的调用行（跨文件串位）。 */
    @GetMapping("/tool/jar-shared-second")
    public List<Map<String, Object>> jarSharedSecond(
            @RequestParam(defaultValue = "PLAN_2026003,PLAN_2026004,PLAN_2026005") String planIds) {
        return toolSiteService.jarSharedKeySecond(split(planIds));
    }

    /** 32. 30 的目录态对照（共用入口在目录里，先触发）。 */
    @GetMapping("/tool/dir-shared-first")
    public List<Map<String, Object>> dirSharedFirst(
            @RequestParam(defaultValue = "PLAN_2026001,PLAN_2026002") String planIds) {
        return toolSiteService.directorySharedKeyFirst(split(planIds));
    }

    /** 33. 31 的目录态对照（后触发，观察是否同样落到 32 的调用行）。 */
    @GetMapping("/tool/dir-shared-second")
    public List<Map<String, Object>> dirSharedSecond(
            @RequestParam(defaultValue = "PLAN_2026003,PLAN_2026004,PLAN_2026005") String planIds) {
        return toolSiteService.directorySharedKeySecond(split(planIds));
    }

    private List<String> split(String csv) {
        List<String> values = new ArrayList<String>();
        if (csv == null) {
            return values;
        }
        for (String part : csv.split(",")) {
            String trimmed = part.trim();
            if (!trimmed.isEmpty()) {
                values.add(trimmed);
            }
        }
        return values;
    }
}
