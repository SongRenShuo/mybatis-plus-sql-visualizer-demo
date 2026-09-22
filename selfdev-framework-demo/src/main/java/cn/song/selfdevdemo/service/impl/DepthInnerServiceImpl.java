package cn.song.selfdevdemo.service.impl;

import cn.song.selfdevdemo.common.SchemaCodes;
import cn.song.selfdevdemo.entity.ProjectPlanMemberView;
import cn.song.selfdevdemo.service.DepthInnerService;

import com.corp.engine.DataUpdateTool;
import com.corp.meta.FilterExpression;
import com.corp.meta.PaginQuery;
import com.corp.meta.PaginResult;
import com.corp.meta.Q;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 业务最内层服务实现：直接触达自研框架门面。
 *
 * @author SongRenShuo
 */
@Service
public class DepthInnerServiceImpl implements DepthInnerService {

    @Override
    public List<Map<String, Object>> innerQuery(String planId) {
        return DataUpdateTool.findByFilter(SchemaCodes.PROJECT_PLAN,
                Q.it("plan_id", FilterExpression.Op.EQ, planId));
    }

    @Override
    public PaginResult<ProjectPlanMemberView> innerPage(String planId, PaginQuery page) {
        return DataUpdateTool.findByFilterPaged(SchemaCodes.PROJECT_PLAN_MEMBER,
                Q.it("plan_id", FilterExpression.Op.EQ, planId),
                page, ProjectPlanMemberView.class);
    }
}
