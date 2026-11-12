package cn.song.custcenter.controller;

import cn.song.custcommon.api.ApiResult;
import cn.song.custcenter.entity.LoginLog;
import cn.song.custcenter.service.LoginLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 登录日志 接口层（MyBatis-Plus 服务）。
 */
public class LoginLogController {

    private final LoginLogService loginLogService;

    public LoginLogController(LoginLogService loginLogService) {
        this.loginLogService = loginLogService;
    }

    public ApiResult<List<LoginLog>> list(Long tenantId) {
        return ApiResult.ok(loginLogService.listByTenant(tenantId));
    }

    public ApiResult<IPage<LoginLog>> page(long pageNo, long pageSize, Long tenantId, String keyword) {
        Page<LoginLog> page = new Page<LoginLog>(pageNo, pageSize);
        return ApiResult.ok(loginLogService.pageByCondition(page, tenantId, keyword));
    }

    public ApiResult<Integer> updateStatus(Long id, String status) {
        return ApiResult.ok(Integer.valueOf(loginLogService.updateStatus(id, status)));
    }
}
