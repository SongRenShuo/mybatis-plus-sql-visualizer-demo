package cn.song.custcenter.controller;

import cn.song.custcommon.api.ApiResult;
import cn.song.custcenter.entity.SysDept;
import cn.song.custcenter.service.SysDeptService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 部门 接口层（MyBatis-Plus 服务）。
 */
public class SysDeptController {

    private final SysDeptService sysDeptService;

    public SysDeptController(SysDeptService sysDeptService) {
        this.sysDeptService = sysDeptService;
    }

    public ApiResult<List<SysDept>> list(Long tenantId) {
        return ApiResult.ok(sysDeptService.listByTenant(tenantId));
    }

    public ApiResult<IPage<SysDept>> page(long pageNo, long pageSize, Long tenantId, String keyword) {
        Page<SysDept> page = new Page<SysDept>(pageNo, pageSize);
        return ApiResult.ok(sysDeptService.pageByCondition(page, tenantId, keyword));
    }

    public ApiResult<Integer> updateStatus(Long id, String status) {
        return ApiResult.ok(Integer.valueOf(sysDeptService.updateStatus(id, status)));
    }
}
