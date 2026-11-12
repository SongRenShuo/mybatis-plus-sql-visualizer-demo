package cn.song.custcenter.controller;

import cn.song.custcommon.api.ApiResult;
import cn.song.custcenter.entity.SysMenu;
import cn.song.custcenter.service.SysMenuService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 菜单 接口层（MyBatis-Plus 服务）。
 */
public class SysMenuController {

    private final SysMenuService sysMenuService;

    public SysMenuController(SysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }

    public ApiResult<List<SysMenu>> list(Long tenantId) {
        return ApiResult.ok(sysMenuService.listByTenant(tenantId));
    }

    public ApiResult<IPage<SysMenu>> page(long pageNo, long pageSize, Long tenantId, String keyword) {
        Page<SysMenu> page = new Page<SysMenu>(pageNo, pageSize);
        return ApiResult.ok(sysMenuService.pageByCondition(page, tenantId, keyword));
    }

    public ApiResult<Integer> updateStatus(Long id, String status) {
        return ApiResult.ok(Integer.valueOf(sysMenuService.updateStatus(id, status)));
    }
}
