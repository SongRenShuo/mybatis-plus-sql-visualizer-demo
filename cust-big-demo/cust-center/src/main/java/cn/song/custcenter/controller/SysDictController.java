package cn.song.custcenter.controller;

import cn.song.custcommon.api.ApiResult;
import cn.song.custcenter.entity.SysDict;
import cn.song.custcenter.service.SysDictService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 字典 接口层（MyBatis-Plus 服务）。
 */
public class SysDictController {

    private final SysDictService sysDictService;

    public SysDictController(SysDictService sysDictService) {
        this.sysDictService = sysDictService;
    }

    public ApiResult<List<SysDict>> list(Long tenantId) {
        return ApiResult.ok(sysDictService.listByTenant(tenantId));
    }

    public ApiResult<IPage<SysDict>> page(long pageNo, long pageSize, Long tenantId, String keyword) {
        Page<SysDict> page = new Page<SysDict>(pageNo, pageSize);
        return ApiResult.ok(sysDictService.pageByCondition(page, tenantId, keyword));
    }

    public ApiResult<Integer> updateStatus(Long id, String status) {
        return ApiResult.ok(Integer.valueOf(sysDictService.updateStatus(id, status)));
    }
}
