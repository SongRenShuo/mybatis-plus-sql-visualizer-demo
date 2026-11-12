package cn.song.custcenter.service.impl;

import cn.song.custcenter.entity.SysRole;
import cn.song.custcenter.mapper.SysRoleMapper;
import cn.song.custcenter.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import java.util.List;

/**
 * SysRole 服务实现（Wrapper / Page 压力档）。
 */
public class SysRoleServiceImpl implements SysRoleService {

    private final SysRoleMapper sysRoleMapper;

    public SysRoleServiceImpl(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    public List<SysRole> listByTenant(Long tenantId) {
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<SysRole>();
        wrapper.eq(SysRole::getTenantId, tenantId)
                .eq(SysRole::getDelFlag, "0")
                .orderByDesc(SysRole::getCreateTime);
        return sysRoleMapper.selectList(wrapper);
    }

    public IPage<SysRole> pageByCondition(Page<SysRole> page, Long tenantId, String keyword) {
        QueryWrapper<SysRole> wrapper = new QueryWrapper<SysRole>();
        wrapper.eq("tenant_id", tenantId)
                .eq("del_flag", "0")
                .like("role_name", keyword)
                .orderByDesc("create_time");
        return sysRoleMapper.selectPage(page, wrapper);
    }

    public int updateStatus(Long id, String status) {
        SysRole entity = new SysRole();
        entity.setStatus(status);
        entity.setUpdateTime(new Date());
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<SysRole>();
        wrapper.eq(SysRole::getId, id);
        return sysRoleMapper.update(entity, wrapper);
    }

    public long countByKeyword(Long tenantId, String keyword) {
        QueryWrapper<SysRole> wrapper = new QueryWrapper<SysRole>();
        wrapper.eq("tenant_id", tenantId)
                .like("role_name", keyword);
        Long total = sysRoleMapper.selectCount(wrapper);
        return total == null ? 0L : total.longValue();
    }

    public SysRole getOneByCode(Long tenantId, String code) {
        QueryWrapper<SysRole> wrapper = new QueryWrapper<SysRole>();
        wrapper.eq("tenant_id", tenantId)
                .eq("role_code", code)
                .last("limit 1");
        return sysRoleMapper.selectOne(wrapper);
    }

}
