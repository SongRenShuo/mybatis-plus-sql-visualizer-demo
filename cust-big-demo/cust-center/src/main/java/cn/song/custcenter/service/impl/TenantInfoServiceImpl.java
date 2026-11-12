package cn.song.custcenter.service.impl;

import cn.song.custcenter.entity.TenantInfo;
import cn.song.custcenter.mapper.TenantInfoMapper;
import cn.song.custcenter.service.TenantInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import java.util.List;

/**
 * TenantInfo 服务实现（Wrapper / Page 压力档）。
 */
public class TenantInfoServiceImpl implements TenantInfoService {

    private final TenantInfoMapper tenantInfoMapper;

    public TenantInfoServiceImpl(TenantInfoMapper tenantInfoMapper) {
        this.tenantInfoMapper = tenantInfoMapper;
    }

    public List<TenantInfo> listByTenant(Long tenantId) {
        LambdaQueryWrapper<TenantInfo> wrapper = new LambdaQueryWrapper<TenantInfo>();
        wrapper.eq(TenantInfo::getTenantId, tenantId)
                .eq(TenantInfo::getDelFlag, "0")
                .orderByDesc(TenantInfo::getCreateTime);
        return tenantInfoMapper.selectList(wrapper);
    }

    public IPage<TenantInfo> pageByCondition(Page<TenantInfo> page, Long tenantId, String keyword) {
        QueryWrapper<TenantInfo> wrapper = new QueryWrapper<TenantInfo>();
        wrapper.eq("tenant_id", tenantId)
                .eq("del_flag", "0")
                .like("tenant_name", keyword)
                .orderByDesc("create_time");
        return tenantInfoMapper.selectPage(page, wrapper);
    }

    public int updateStatus(Long id, String status) {
        TenantInfo entity = new TenantInfo();
        entity.setStatus(status);
        entity.setUpdateTime(new Date());
        LambdaQueryWrapper<TenantInfo> wrapper = new LambdaQueryWrapper<TenantInfo>();
        wrapper.eq(TenantInfo::getId, id);
        return tenantInfoMapper.update(entity, wrapper);
    }

    public long countByKeyword(Long tenantId, String keyword) {
        QueryWrapper<TenantInfo> wrapper = new QueryWrapper<TenantInfo>();
        wrapper.eq("tenant_id", tenantId)
                .like("tenant_name", keyword);
        Long total = tenantInfoMapper.selectCount(wrapper);
        return total == null ? 0L : total.longValue();
    }

    public TenantInfo getOneByCode(Long tenantId, String code) {
        QueryWrapper<TenantInfo> wrapper = new QueryWrapper<TenantInfo>();
        wrapper.eq("tenant_id", tenantId)
                .eq("tenant_code", code)
                .last("limit 1");
        return tenantInfoMapper.selectOne(wrapper);
    }

}
