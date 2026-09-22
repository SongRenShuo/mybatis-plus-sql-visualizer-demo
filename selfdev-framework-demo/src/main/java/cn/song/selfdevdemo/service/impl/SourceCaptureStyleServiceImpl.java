package cn.song.selfdevdemo.service.impl;

import cn.song.selfdevdemo.common.SchemaCodes;
import cn.song.selfdevdemo.service.SourceCaptureStyleService;
import cn.song.selfdevdemo.support.BizQuerySupport;

import com.corp.engine.DataAccessFacade;
import com.corp.engine.DataQueryTool;
import com.corp.engine.DataUpdateTool;
import com.corp.engine.EngineException;
import com.corp.engine.QueryCallback;
import com.corp.engine.QueryContext;
import com.corp.meta.FilterExpression;
import com.corp.meta.Q;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A 组语料实现：12 种进入自研框架门面的调用形态。
 *
 * <p>每种形态的注释都写明「登记前缀前 / 后」的落点预期，便于在 IDEA 中逐条对照走查。
 * 所有方法都真实发 SQL 到 MySQL（不是 mock），因此 agent 增强捕获必然产生事件。
 *
 * @author SongRenShuo
 */
@Service
public class SourceCaptureStyleServiceImpl implements SourceCaptureStyleService {

    /** 形态 10 的专属线程池：命名线程便于在插件面板的线程名列上分辨。 */
    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2, 4, 60L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(16),
            new ThreadFactory() {
                private final AtomicInteger seq = new AtomicInteger(0);

                @Override
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable, "selfdev-pool-" + seq.incrementAndGet());
                    thread.setDaemon(true);
                    return thread;
                }
            },
            new ThreadPoolExecutor.CallerRunsPolicy());

    @Autowired
    private DataQueryTool dataQueryTool;

    // ==================== 1. 静态门面直调 ====================

    /**
     * 形态 1：静态门面直调。
     *
     * <p>登记前缀前：主位置落到 {@code com.corp.engine.DmlRepository#query}（引擎最深层目录帧）；
     * 登记 {@code com.corp.engine.} 后：落到本方法内的 {@code DataUpdateTool.findByFilter} 调用行。
     */
    @Override
    public List<Map<String, Object>> staticCall(int status) {
        return DataUpdateTool.findByFilter(SchemaCodes.PROJECT_PLAN,
                Q.it("status", FilterExpression.Op.EQ, status));
    }

    // ==================== 2. 注入 Bean 门面 ====================

    /**
     * 形态 2：Spring Bean 门面（实例调用）。
     *
     * <p>与形态 1 引擎帧相同，差别只在门面是注入对象而非静态类——验证前缀对两种门面一视同仁。
     */
    @Override
    public List<Map<String, Object>> beanCall(int status) {
        FilterExpression filter = Q.and(
                Q.it("status", FilterExpression.Op.EQ, status),
                Q.isNotNull("owner"));
        return dataQueryTool.findByFilter(SchemaCodes.PROJECT_PLAN, filter);
    }

    // ==================== 3. 链式构建器 ====================

    /**
     * 形态 3：链式构建器（SQL 在终结方法 {@code list()} 才发出）。
     *
     * <p>登记前缀后主位置应落在链式终结那一行（{@code .list()}），而非链起点。
     */
    @Override
    public List<Map<String, Object>> fluentChain(String owner, int limit) {
        return DataUpdateTool.query(SchemaCodes.PROJECT_PLAN)
                .where(Q.it("owner", FilterExpression.Op.EQ, owner))
                .orderBy("create_time desc")
                .limit(limit)
                .list();
    }

    // ==================== 4. lambda 回调模板 ====================

    /**
     * 形态 4：lambda 回调模板。
     *
     * <p>业务 lambda 的帧类名即本类（方法名形如 {@code lambda$lambdaCallback$N}）——
     * 属业务帧，登记前缀后应被选为主位置。
     */
    @Override
    public List<Map<String, Object>> lambdaCallback(String planId) {
        return DataUpdateTool.executeInSchema(SchemaCodes.PROJECT_PLAN,
                ctx -> ctx.findByFilter(Q.it("plan_id", FilterExpression.Op.EQ, planId)));
    }

    // ==================== 5. 匿名内部类回调 ====================

    /**
     * 形态 5：匿名内部类回调。
     *
     * <p>帧类名形如 {@code SourceCaptureStyleServiceImpl$1}——同属业务帧；
     * 与形态 4 的 lambda 写法对照，验证两种匿名形态落点一致。
     */
    @Override
    public List<Map<String, Object>> anonymousCallback(String planId) {
        return DataUpdateTool.executeInSchema(SchemaCodes.PROJECT_PLAN,
                new QueryCallback<List<Map<String, Object>>>() {
                    @Override
                    public List<Map<String, Object>> apply(QueryContext context) {
                        return context.findByFilter(Q.it("plan_id", FilterExpression.Op.EQ, planId));
                    }
                });
    }

    // ==================== 6. JDK 动态代理 ====================

    /**
     * 形态 6：JDK 动态代理门面。
     *
     * <p>代理类为 {@code com.sun.proxy.$ProxyN}，被内置规则跳过；调用处理器落在
     * {@code com.corp.engine} 下，随引擎前缀一并跳过——最终落点仍是本方法。
     */
    @Override
    public List<Map<String, Object>> jdkProxyCall(int status) {
        DataAccessFacade facade = DataUpdateTool.facade();
        return facade.findByFilter(SchemaCodes.PROJECT_PLAN,
                Q.it("status", FilterExpression.Op.EQ, status));
    }

    // ==================== 7. 反射调用 ====================

    /**
     * 形态 7：反射调用门面。
     *
     * <p>反射帧（{@code jdk.internal.reflect.} / {@code sun.reflect.}）被内置规则跳过，
     * 业务帧（本方法）应被选中。
     */
    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Object> reflectionCall(String planId) {
        try {
            Method method = DataUpdateTool.class.getMethod(
                    "findOneByFilter", String.class, FilterExpression.class);
            return (Map<String, Object>) method.invoke(null, SchemaCodes.PROJECT_PLAN,
                    Q.it("plan_id", FilterExpression.Op.EQ, planId));
        } catch (ReflectiveOperationException e) {
            throw new EngineException("反射调用门面失败: " + e.getMessage(), e);
        }
    }

    // ==================== 8. 业务层包装壳 ====================

    /**
     * 形态 8：业务层包装壳（{@code support.BizQuerySupport}）。
     *
     * <p>登记前缀前落引擎帧，登记后落在**包装壳方法**（{@code BizQuerySupport#queryPlansByOwner}）
     * 而非本方法——业务帧多一层，这是「业务侧再包一层」的正常表现。
     */
    @Override
    public List<Map<String, Object>> helperWrapped(String owner) {
        return BizQuerySupport.queryPlansByOwner(owner);
    }

    // ==================== 9. 异步（CompletableFuture） ====================

    /**
     * 形态 9：{@code CompletableFuture.supplyAsync} 异线程执行。
     *
     * <p>栈底换成 ForkJoinPool 工作线程（{@code java.util.concurrent.} 已被内置规则跳过），
     * 业务 lambda 帧仍是本类——用于验证线程切换不影响落点。
     */
    @Override
    public List<Map<String, Object>> asyncFuture(int status) {
        try {
            return CompletableFuture.supplyAsync(() -> DataUpdateTool.findByFilter(
                    SchemaCodes.PROJECT_PLAN,
                    Q.it("status", FilterExpression.Op.EQ, status))).get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new EngineException("异步查询被中断", e);
        } catch (ExecutionException e) {
            throw new EngineException("异步查询失败: " + e.getMessage(), e);
        }
    }

    // ==================== 10. 自定义线程池 ====================

    /**
     * 形态 10：自定义线程池（命名线程 {@code selfdev-pool-N}）。
     *
     * <p>与形态 9 的区别在线程名可辨（面板线程列可见），且线程池帧同样被内置规则跳过。
     */
    @Override
    public List<Map<String, Object>> executorPool(String owner) {
        Future<List<Map<String, Object>>> future = executor.submit(
                () -> DataUpdateTool.findByFilter(SchemaCodes.PROJECT_PLAN,
                        Q.it("owner", FilterExpression.Op.EQ, owner)));
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new EngineException("线程池查询被中断", e);
        } catch (ExecutionException e) {
            throw new EngineException("线程池查询失败: " + e.getMessage(), e);
        }
    }

    // ==================== 11. 循环批量 ====================

    /**
     * 形态 11：同一方法内循环调用门面。
     *
     * <p>N 条语句共用同一个「首个非框架帧」key——用于验证插件面板的同帧去重行为
     * （同位置多次执行显示 {@code ×N} 徽标，而非无限堆叠）。
     */
    @Override
    public List<Map<String, Object>> batchLoop(List<String> planIds) {
        List<Map<String, Object>> all = new ArrayList<Map<String, Object>>();
        for (String planId : planIds) {
            all.addAll(DataUpdateTool.findByFilter(SchemaCodes.PROJECT_PLAN,
                    Q.it("plan_id", FilterExpression.Op.EQ, planId)));
        }
        return all;
    }

    // ==================== 12. 组合 / 嵌套 ====================

    /**
     * 形态 12：单方法内两次不同条件的门面调用。
     *
     * <p>两次调用的「首个非框架帧」相同（引擎汇聚帧），若缓存策略不当会把第一个调用者的
     * 位置服务给第二次——本形态是「缓存合流」缺陷（T-SourceJumpFunnel P0-3）的回归语料。
     */
    @Override
    public List<Map<String, Object>> combinedNested(String planId, String owner) {
        List<Map<String, Object>> byPlan = DataUpdateTool.findByFilter(SchemaCodes.PROJECT_PLAN,
                Q.it("plan_id", FilterExpression.Op.EQ, planId));
        List<Map<String, Object>> byOwner = DataUpdateTool.findByFilter(SchemaCodes.PROJECT_PLAN,
                Q.it("owner", FilterExpression.Op.EQ, owner));
        List<Map<String, Object>> merged = new ArrayList<Map<String, Object>>(byPlan);
        merged.addAll(byOwner);
        return merged;
    }

    @PreDestroy
    public void shutdownExecutor() {
        executor.shutdownNow();
    }
}
