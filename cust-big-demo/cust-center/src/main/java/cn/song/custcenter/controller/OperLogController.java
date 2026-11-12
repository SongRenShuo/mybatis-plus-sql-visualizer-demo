package cn.song.custcenter.controller;

import cn.song.custcommon.api.ApiResult;
import cn.song.custcenter.entity.OperLog;
import cn.song.custcenter.service.OperLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 操作日志 接口层（MyBatis-Plus 服务）。
 */
public class OperLogController {

    private final OperLogService operLogService;

    public OperLogController(OperLogService operLogService) {
        this.operLogService = operLogService;
    }

    public ApiResult<List<OperLog>> list(Long tenantId) {
        return ApiResult.ok(operLogService.listByTenant(tenantId));
    }

    public ApiResult<IPage<OperLog>> page(long pageNo, long pageSize, Long tenantId, String keyword) {
        Page<OperLog> page = new Page<OperLog>(pageNo, pageSize);
        return ApiResult.ok(operLogService.pageByCondition(page, tenantId, keyword));
    }

    public ApiResult<Integer> updateStatus(Long id, String status) {
        return ApiResult.ok(Integer.valueOf(operLogService.updateStatus(id, status)));
    }
}
