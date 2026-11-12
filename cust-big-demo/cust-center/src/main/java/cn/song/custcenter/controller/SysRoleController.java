package cn.song.custcenter.controller;

import cn.song.custcommon.api.ApiResult;
import cn.song.custcenter.entity.SysRole;
import cn.song.custcenter.service.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 角色 接口层（MyBatis-Plus 服务）。
 */
public class SysRoleController {

    private final SysRoleService sysRoleService;

    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    public ApiResult<List<SysRole>> list(Long tenantId) {
        return ApiResult.ok(sysRoleService.listByTenant(tenantId));
    }

    public ApiResult<IPage<SysRole>> page(long pageNo, long pageSize, Long tenantId, String keyword) {
        Page<SysRole> page = new Page<SysRole>(pageNo, pageSize);
        return ApiResult.ok(sysRoleService.pageByCondition(page, tenantId, keyword));
    }

    public ApiResult<Integer> updateStatus(Long id, String status) {
        return ApiResult.ok(Integer.valueOf(sysRoleService.updateStatus(id, status)));
    }
}
