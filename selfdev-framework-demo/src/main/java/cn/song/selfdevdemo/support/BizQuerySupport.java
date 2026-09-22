package cn.song.selfdevdemo.support;

import cn.song.selfdevdemo.common.SchemaCodes;

import com.corp.engine.DataUpdateTool;
import com.corp.meta.FilterExpression;
import com.corp.meta.Q;

import java.util.List;
import java.util.Map;

/**
 * 业务层查询委托壳（**不是框架的一部分**）。
 *
 * <p>用途有二：
 * <ol>
 *   <li>提供「业务侧再包一层」的调用形态——跳转应落在本类方法上，而不是框架帧；</li>
 *   <li>作为**负例**：本包（{@code cn.song.selfdevdemo.support}）属于业务代码，
 *       <b>不应</b>登记进「源码捕获帧过滤前缀」。实测（登记 {@code cn.song.selfdevdemo.} 后
 *       候选池被过滤为空）——真实业务帧被一并跳过，主位置判定直接失败，
 *       <b>跳转能力消失</b>（不是落到更外层调用者，而是完全无位置）。这是设置项最容易踩的误用。</li>
 * </ol>
 *
 * @author SongRenShuo
 */
public final class BizQuerySupport {

    private BizQuerySupport() {
    }

    /** 按负责人查询计划（业务侧包装壳）。 */
    public static List<Map<String, Object>> queryPlansByOwner(String owner) {
        FilterExpression filter = Q.and(
                Q.it("owner", FilterExpression.Op.EQ, owner),
                Q.it("status", FilterExpression.Op.NE, 0));
        return DataUpdateTool.findByFilter(SchemaCodes.PROJECT_PLAN, filter);
    }

    /** 按状态统计条数（业务侧包装壳）。 */
    public static long countByStatus(int status) {
        return DataUpdateTool.countByFilter(SchemaCodes.PROJECT_PLAN,
                Q.it("status", FilterExpression.Op.EQ, status));
    }
}
