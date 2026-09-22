package cn.song.selfdevdemo.service.impl;

import cn.song.selfdevdemo.common.SchemaCodes;
import cn.song.selfdevdemo.service.CrossQueryService;
import cn.song.selfdevdemo.service.DepthMiddleService;
import cn.song.selfdevdemo.service.SourceCaptureDepthService;
import cn.song.selfdevdemo.support.BizQuerySupport;

import com.corp.engine.DataUpdateTool;
import com.corp.meta.FilterExpression;
import com.corp.meta.Q;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * B 组语料实现：委托深度矩阵。
 *
 * @author SongRenShuo
 */
@Service
public class SourceCaptureDepthServiceImpl implements SourceCaptureDepthService {

    @Autowired
    private DepthMiddleService depthMiddleService;

    @Autowired
    private CrossQueryService crossQueryService;

    /**
     * 13. 浅层：本服务（Controller 之下第一层）直接触达门面。
     *
     * <p>业务帧只有本方法一层——登记前缀后主位置应精确落在下面的调用行。
     */
    @Override
    public List<Map<String, Object>> shallow(int status) {
        return DataUpdateTool.findByFilter(SchemaCodes.PROJECT_PLAN,
                Q.it("status", FilterExpression.Op.EQ, status));
    }

    /**
     * 14. 三层委托：本服务 → 中间层 → 内层 → 门面。
     *
     * <p>业务帧三层齐在栈上；登记前缀后主位置应为**最深**的
     * {@code DepthInnerServiceImpl#innerQuery}，候选列中另两层可作回退。
     */
    @Override
    public List<Map<String, Object>> deepThree(String planId) {
        return depthMiddleService.middleQuery(planId);
    }

    /**
     * 15. 跨服务：本服务 → 平级协作服务 → 门面。
     *
     * <p>与形态 14 的差别是「平级而非上下级」，验证跨类协作时栈形状同样完整。
     */
    @Override
    public List<Map<String, Object>> crossService(String owner, int limit) {
        return crossQueryService.crossQuery(owner, limit);
    }

    /**
     * 16. 业务包内委托壳（**负例**）。
     *
     * <p>正常落点应为 {@code BizQuerySupport#queryPlansByOwner}（业务帧）。
     * 若把业务包 {@code cn.song.selfdevdemo.} 登记进帧过滤前缀，业务帧会被一并跳过——
     * 实测候选池被过滤为空，主位置判定失败、**跳转能力直接消失**（不是落到更外层调用者，
     * 而是完全无位置）。本用例用于现场演示这一误用。
     */
    @Override
    public List<Map<String, Object>> viaBusinessDelegate(String owner) {
        return BizQuerySupport.queryPlansByOwner(owner);
    }
}
