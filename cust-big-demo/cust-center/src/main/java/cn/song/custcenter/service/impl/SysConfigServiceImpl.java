package cn.song.custcenter.service.impl;

import cn.song.custcenter.entity.SysConfig;
import cn.song.custcenter.mapper.SysConfigMapper;
import cn.song.custcenter.service.SysConfigService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import java.util.List;

/**
 * SysConfig 服务实现（Wrapper / Page 压力档）。
 */
public class SysConfigServiceImpl implements SysConfigService {

    private final SysConfigMapper sysConfigMapper;

    public SysConfigServiceImpl(SysConfigMapper sysConfigMapper) {
        this.sysConfigMapper = sysConfigMapper;
    }

    public List<SysConfig> listByTenant(Long tenantId) {
        LambdaQueryWrapper<SysConfig> wrapper = new LambdaQueryWrapper<SysConfig>();
        wrapper.eq(SysConfig::getTenantId, tenantId)
                .eq(SysConfig::getDelFlag, "0")
                .orderByDesc(SysConfig::getCreateTime);
        return sysConfigMapper.selectList(wrapper);
    }

    public IPage<SysConfig> pageByCondition(Page<SysConfig> page, Long tenantId, String keyword) {
        QueryWrapper<SysConfig> wrapper = new QueryWrapper<SysConfig>();
        wrapper.eq("tenant_id", tenantId)
                .eq("del_flag", "0")
                .like("config_desc", keyword)
                .orderByDesc("create_time");
        return sysConfigMapper.selectPage(page, wrapper);
    }

    public int updateStatus(Long id, String status) {
        SysConfig entity = new SysConfig();
        entity.setStatus(status);
        entity.setUpdateTime(new Date());
        LambdaQueryWrapper<SysConfig> wrapper = new LambdaQueryWrapper<SysConfig>();
        wrapper.eq(SysConfig::getId, id);
        return sysConfigMapper.update(entity, wrapper);
    }

    public long countByKeyword(Long tenantId, String keyword) {
        QueryWrapper<SysConfig> wrapper = new QueryWrapper<SysConfig>();
        wrapper.eq("tenant_id", tenantId)
                .like("config_desc", keyword);
        Long total = sysConfigMapper.selectCount(wrapper);
        return total == null ? 0L : total.longValue();
    }

    public SysConfig getOneByCode(Long tenantId, String code) {
        QueryWrapper<SysConfig> wrapper = new QueryWrapper<SysConfig>();
        wrapper.eq("tenant_id", tenantId)
                .eq("config_key", code)
                .last("limit 1");
        return sysConfigMapper.selectOne(wrapper);
    }

}
