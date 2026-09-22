package cn.song.selfdevdemo.service.impl;

import cn.song.selfdevdemo.common.SchemaCodes;
import cn.song.selfdevdemo.service.CrossQueryService;

import com.corp.engine.DataUpdateTool;
import com.corp.meta.FilterExpression;
import com.corp.meta.Q;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 业务横向协作服务实现：自身触达框架门面，供 {@link SourceCaptureDepthServiceImpl} 调用。
 *
 * @author SongRenShuo
 */
@Service
public class CrossQueryServiceImpl implements CrossQueryService {

    @Override
    public List<Map<String, Object>> crossQuery(String owner, int limit) {
        FilterExpression filter = Q.and(
                Q.it("owner", FilterExpression.Op.EQ, owner),
                Q.it("status", FilterExpression.Op.EQ, 1));
        return DataUpdateTool.findByFilterOrdered(SchemaCodes.PROJECT_PLAN, filter,
                "amount desc", limit);
    }
}
