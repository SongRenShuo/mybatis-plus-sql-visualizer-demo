package cn.song.custcenter.controller;

import cn.song.custcommon.api.ApiResult;
import cn.song.custcenter.entity.CustTag;
import cn.song.custcenter.service.CustTagService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 客户标签 接口层（MyBatis-Plus 服务）。
 */
public class CustTagController {

    private final CustTagService custTagService;

    public CustTagController(CustTagService custTagService) {
        this.custTagService = custTagService;
    }

    public ApiResult<List<CustTag>> list(Long tenantId) {
        return ApiResult.ok(custTagService.listByTenant(tenantId));
    }

    public ApiResult<IPage<CustTag>> page(long pageNo, long pageSize, Long tenantId, String keyword) {
        Page<CustTag> page = new Page<CustTag>(pageNo, pageSize);
        return ApiResult.ok(custTagService.pageByCondition(page, tenantId, keyword));
    }

    public ApiResult<Integer> updateStatus(Long id, String status) {
        return ApiResult.ok(Integer.valueOf(custTagService.updateStatus(id, status)));
    }
}
