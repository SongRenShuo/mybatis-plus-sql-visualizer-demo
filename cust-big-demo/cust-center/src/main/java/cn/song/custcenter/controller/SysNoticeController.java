package cn.song.custcenter.controller;

import cn.song.custcommon.api.ApiResult;
import cn.song.custcenter.entity.SysNotice;
import cn.song.custcenter.service.SysNoticeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 通知公告 接口层（MyBatis-Plus 服务）。
 */
public class SysNoticeController {

    private final SysNoticeService sysNoticeService;

    public SysNoticeController(SysNoticeService sysNoticeService) {
        this.sysNoticeService = sysNoticeService;
    }

    public ApiResult<List<SysNotice>> list(Long tenantId) {
        return ApiResult.ok(sysNoticeService.listByTenant(tenantId));
    }

    public ApiResult<IPage<SysNotice>> page(long pageNo, long pageSize, Long tenantId, String keyword) {
        Page<SysNotice> page = new Page<SysNotice>(pageNo, pageSize);
        return ApiResult.ok(sysNoticeService.pageByCondition(page, tenantId, keyword));
    }

    public ApiResult<Integer> updateStatus(Long id, String status) {
        return ApiResult.ok(Integer.valueOf(sysNoticeService.updateStatus(id, status)));
    }
}
