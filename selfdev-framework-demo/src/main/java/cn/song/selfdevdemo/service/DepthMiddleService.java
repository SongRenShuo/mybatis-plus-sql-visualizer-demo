package cn.song.selfdevdemo.service;

import cn.song.selfdevdemo.entity.ProjectPlanMemberView;

import com.corp.meta.PaginQuery;
import com.corp.meta.PaginResult;

import java.util.List;
import java.util.Map;

/**
 * 业务**中间层**服务：只负责转发到 {@link DepthInnerService}，不直接接触框架。
 *
 * @author SongRenShuo
 */
public interface DepthMiddleService {

    /** 中间层查询（转发内层）。 */
    List<Map<String, Object>> middleQuery(String planId);

    /** 中间层分页查询（转发内层）。 */
    PaginResult<ProjectPlanMemberView> middlePage(String planId, PaginQuery page);
}
