package cn.song.custcenter.controller;

import cn.song.custcommon.api.ApiResult;
import cn.song.custcenter.entity.CustInfo;
import cn.song.custcenter.service.CustInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 客户信息 接口层（MyBatis-Plus 服务）。
 */
public class CustInfoController {

    private final CustInfoService custInfoService;

    public CustInfoController(CustInfoService custInfoService) {
        this.custInfoService = custInfoService;
    }

    public ApiResult<List<CustInfo>> list(Long tenantId) {
        return ApiResult.ok(custInfoService.listByTenant(tenantId));
    }

    public ApiResult<IPage<CustInfo>> page(long pageNo, long pageSize, Long tenantId, String keyword) {
        Page<CustInfo> page = new Page<CustInfo>(pageNo, pageSize);
        return ApiResult.ok(custInfoService.pageByCondition(page, tenantId, keyword));
    }

    public ApiResult<Integer> updateStatus(Long id, String status) {
        return ApiResult.ok(Integer.valueOf(custInfoService.updateStatus(id, status)));
    }
}
