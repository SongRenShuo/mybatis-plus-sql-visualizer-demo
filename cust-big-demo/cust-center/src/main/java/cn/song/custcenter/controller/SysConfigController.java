package cn.song.custcenter.controller;

import cn.song.custcommon.api.ApiResult;
import cn.song.custcenter.entity.SysConfig;
import cn.song.custcenter.service.SysConfigService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 参数配置 接口层（MyBatis-Plus 服务）。
 */
public class SysConfigController {

    private final SysConfigService sysConfigService;

    public SysConfigController(SysConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
    }

    public ApiResult<List<SysConfig>> list(Long tenantId) {
        return ApiResult.ok(sysConfigService.listByTenant(tenantId));
    }

    public ApiResult<IPage<SysConfig>> page(long pageNo, long pageSize, Long tenantId, String keyword) {
        Page<SysConfig> page = new Page<SysConfig>(pageNo, pageSize);
        return ApiResult.ok(sysConfigService.pageByCondition(page, tenantId, keyword));
    }

    public ApiResult<Integer> updateStatus(Long id, String status) {
        return ApiResult.ok(Integer.valueOf(sysConfigService.updateStatus(id, status)));
    }
}
