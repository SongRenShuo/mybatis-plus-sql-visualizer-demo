package cn.song.custcenter.controller;

import cn.song.custcenter.mapper.CustInfoMapper;
import cn.song.custcommon.api.ApiResult;
import cn.song.custcenter.entity.CustInfo;
import cn.song.custcenter.service.CustInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 客户信息 接口层（MyBatis-Plus 服务）。
 */
public class CustInfoController {

    private final CustInfoService custInfoService;
    private final CustInfoMapper custInfoMapper;

    public CustInfoController(CustInfoService custInfoService, CustInfoMapper custInfoMapper) {
        this.custInfoService = custInfoService;
        this.custInfoMapper = custInfoMapper;
    }

    public ApiResult<List<CustInfo>> list(Long tenantId) {
        return ApiResult.ok(custInfoService.listByTenant(tenantId));
    }

    public ApiResult<CustInfo> list02(Long tenantId) {
        LambdaQueryWrapper<CustInfo> wrapper = new LambdaQueryWrapper<CustInfo>();
        wrapper.eq(CustInfo::getTenantId, tenantId);
        custInfoMapper.update(wrapper);

        CustInfo data = custInfoService.listByTenant02(wrapper);


        return ApiResult.ok(data);
    }

    public ApiResult<IPage<CustInfo>> page(long pageNo, long pageSize, Long tenantId, String keyword) {
        Page<CustInfo> page = new Page<CustInfo>(pageNo, pageSize);
        return ApiResult.ok(custInfoService.pageByCondition(page, tenantId, keyword));
    }

    public ApiResult<Integer> updateStatus(Long id, String status) {
        return ApiResult.ok(Integer.valueOf(custInfoService.updateStatus(id, status)));
    }
}
