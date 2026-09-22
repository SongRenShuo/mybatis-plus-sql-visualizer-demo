package cn.song.selfdevdemo.service;

import java.util.List;
import java.util.Map;

/**
 * A 组语料：**调用形态**矩阵（12 种进入自研框架门面的书写方式）。
 *
 * <p>每种形态的引擎帧完全相同，差别只在业务帧的书写位置与调用栈形状——
 * 用于验证「源码捕获帧过滤前缀」登记后，主位置是否稳定回到业务行。
 *
 * @author SongRenShuo
 */
public interface SourceCaptureStyleService {

    /** 1. 静态门面直调。 */
    List<Map<String, Object>> staticCall(int status);

    /** 2. 注入的 Bean 门面调用。 */
    List<Map<String, Object>> beanCall(int status);

    /** 3. 链式构建器终结。 */
    List<Map<String, Object>> fluentChain(String owner, int limit);

    /** 4. lambda 回调模板。 */
    List<Map<String, Object>> lambdaCallback(String planId);

    /** 5. 匿名内部类回调。 */
    List<Map<String, Object>> anonymousCallback(String planId);

    /** 6. JDK 动态代理门面。 */
    List<Map<String, Object>> jdkProxyCall(int status);

    /** 7. 反射调用门面。 */
    Map<String, Object> reflectionCall(String planId);

    /** 8. 业务层包装壳（业务帧，非框架帧）。 */
    List<Map<String, Object>> helperWrapped(String owner);

    /** 9. CompletableFuture 异线程执行。 */
    List<Map<String, Object>> asyncFuture(int status);

    /** 10. 自定义线程池（命名线程）执行。 */
    List<Map<String, Object>> executorPool(String owner);

    /** 11. 同一方法内循环批量调用（同帧 key）。 */
    List<Map<String, Object>> batchLoop(List<String> planIds);

    /** 12. 单方法内两次不同条件调用（组合/嵌套）。 */
    List<Map<String, Object>> combinedNested(String planId, String owner);
}
