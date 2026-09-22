package cn.song.selfdevdemo.service.impl;

import cn.song.selfdevdemo.common.SchemaCodes;
import cn.song.selfdevdemo.service.SourceCaptureWriteService;

import com.corp.engine.DataUpdateTool;
import com.corp.meta.FilterExpression;
import com.corp.meta.Q;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * D 组语料实现：写路径矩阵。
 *
 * @author SongRenShuo
 */
@Service
public class SourceCaptureWriteServiceImpl implements SourceCaptureWriteService {

    /**
     * 25. 按 plan_id 更新项目名与更新时间。
     *
     * <p>登记前缀前主位置落 {@code DmlRepository#update}；登记后落本方法内的门面调用行。
     */
    @Override
    public int update(String planId, String projectName) {
        Map<String, Object> values = new LinkedHashMap<String, Object>();
        values.put("project_name", projectName);
        values.put("update_time", System.currentTimeMillis() / 1000L);
        return DataUpdateTool.updateByFilter(SchemaCodes.PROJECT_PLAN,
                Q.it("plan_id", FilterExpression.Op.EQ, planId), values);
    }

    /**
     * 26. 按 plan_id 删除。
     *
     * <p>框架对空条件做全表删除拦截（{@code LocalDbService#delete}），
     * 因此本用例即使传入不存在的编号也只会返回 0 行，不会误删数据。
     */
    @Override
    public int delete(String planId) {
        return DataUpdateTool.deleteByFilter(SchemaCodes.PROJECT_PLAN,
                Q.it("plan_id", FilterExpression.Op.EQ, planId));
    }

    /**
     * 27. 循环更新（批量）。
     *
     * <p>N 条 UPDATE 共用同一个「首个非框架帧」key，用于验证写路径下的同帧去重行为。
     */
    @Override
    public int batchUpdate(List<String> planIds, int status) {
        int affected = 0;
        for (String planId : planIds) {
            Map<String, Object> values = new LinkedHashMap<String, Object>();
            values.put("status", status);
            values.put("update_time", System.currentTimeMillis() / 1000L);
            affected += DataUpdateTool.updateByFilter(SchemaCodes.PROJECT_PLAN,
                    Q.it("plan_id", FilterExpression.Op.EQ, planId), values);
        }
        return affected;
    }
}
