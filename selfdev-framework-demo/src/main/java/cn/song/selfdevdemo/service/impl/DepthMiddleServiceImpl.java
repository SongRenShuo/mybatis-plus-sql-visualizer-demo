package cn.song.selfdevdemo.service.impl;

import cn.song.selfdevdemo.entity.ProjectPlanMemberView;
import cn.song.selfdevdemo.service.DepthInnerService;
import cn.song.selfdevdemo.service.DepthMiddleService;

import com.corp.meta.PaginQuery;
import com.corp.meta.PaginResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 业务中间层服务实现：只转发，不接触框架。
 *
 * @author SongRenShuo
 */
@Service
public class DepthMiddleServiceImpl implements DepthMiddleService {

    @Autowired
    private DepthInnerService depthInnerService;

    @Override
    public List<Map<String, Object>> middleQuery(String planId) {
        return depthInnerService.innerQuery(planId);
    }

    @Override
    public PaginResult<ProjectPlanMemberView> middlePage(String planId, PaginQuery page) {
        return depthInnerService.innerPage(planId, page);
    }
}
