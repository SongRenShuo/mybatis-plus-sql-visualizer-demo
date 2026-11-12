package cn.song.custcenter.controller;

import cn.song.custcommon.api.ApiResult;
import cn.song.custcenter.entity.TenantInfo;
import cn.song.custcenter.service.TenantInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 租户 接口层（MyBatis-Plus 服务）。
 */
public class TenantInfoController {

    private final TenantInfoService tenantInfoService;

    public TenantInfoController(TenantInfoService tenantInfoService) {
        this.tenantInfoService = tenantInfoService;
    }

    public ApiResult<List<TenantInfo>> list(Long tenantId) {
        return ApiResult.ok(tenantInfoService.listByTenant(tenantId));
    }

    public ApiResult<IPage<TenantInfo>> page(long pageNo, long pageSize, Long tenantId, String keyword) {
        Page<TenantInfo> page = new Page<TenantInfo>(pageNo, pageSize);
        return ApiResult.ok(tenantInfoService.pageByCondition(page, tenantId, keyword));
    }

    public ApiResult<Integer> updateStatus(Long id, String status) {
        return ApiResult.ok(Integer.valueOf(tenantInfoService.updateStatus(id, status)));
    }
}
