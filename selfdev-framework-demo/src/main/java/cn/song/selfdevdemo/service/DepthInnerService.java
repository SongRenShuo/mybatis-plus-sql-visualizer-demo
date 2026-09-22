package cn.song.selfdevdemo.service;

import cn.song.selfdevdemo.entity.ProjectPlanMemberView;

import com.corp.meta.PaginQuery;
import com.corp.meta.PaginResult;

import java.util.List;
import java.util.Map;

/**
 * 业务**最内层**服务：直接触达自研框架门面（调用栈中紧贴框架帧的业务层）。
 *
 * <p>登记前缀后，本类方法就是「最深业务帧」——主位置应落在这一层，而不是外层调用者。
 *
 * @author SongRenShuo
 */
public interface DepthInnerService {

    /** 最内层查询。 */
    List<Map<String, Object>> innerQuery(String planId);

    /** 最内层分页查询（JOIN schema）。 */
    PaginResult<ProjectPlanMemberView> innerPage(String planId, PaginQuery page);
}
