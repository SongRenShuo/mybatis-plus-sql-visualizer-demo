package cn.song.custcenter.service.impl;

import cn.song.custcenter.entity.SysMenu;
import cn.song.custcenter.mapper.SysMenuMapper;
import cn.song.custcenter.service.SysMenuService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import java.util.List;

/**
 * SysMenu 服务实现（Wrapper / Page 压力档）。
 */
public class SysMenuServiceImpl implements SysMenuService {

    private final SysMenuMapper sysMenuMapper;

    public SysMenuServiceImpl(SysMenuMapper sysMenuMapper) {
        this.sysMenuMapper = sysMenuMapper;
    }

    public List<SysMenu> listByTenant(Long tenantId) {
        LambdaQueryWrapper<SysMenu> wrapper = new LambdaQueryWrapper<SysMenu>();
        wrapper.eq(SysMenu::getTenantId, tenantId)
                .eq(SysMenu::getDelFlag, "0")
                .orderByDesc(SysMenu::getCreateTime);
        return sysMenuMapper.selectList(wrapper);
    }

    public IPage<SysMenu> pageByCondition(Page<SysMenu> page, Long tenantId, String keyword) {
        QueryWrapper<SysMenu> wrapper = new QueryWrapper<SysMenu>();
        wrapper.eq("tenant_id", tenantId)
                .eq("del_flag", "0")
                .like("menu_name", keyword)
                .orderByDesc("create_time");
        return sysMenuMapper.selectPage(page, wrapper);
    }

    public int updateStatus(Long id, String status) {
        SysMenu entity = new SysMenu();
        entity.setStatus(status);
        entity.setUpdateTime(new Date());
        LambdaQueryWrapper<SysMenu> wrapper = new LambdaQueryWrapper<SysMenu>();
        wrapper.eq(SysMenu::getId, id);
        return sysMenuMapper.update(entity, wrapper);
    }

    public long countByKeyword(Long tenantId, String keyword) {
        QueryWrapper<SysMenu> wrapper = new QueryWrapper<SysMenu>();
        wrapper.eq("tenant_id", tenantId)
                .like("menu_name", keyword);
        Long total = sysMenuMapper.selectCount(wrapper);
        return total == null ? 0L : total.longValue();
    }

    public SysMenu getOneByCode(Long tenantId, String code) {
        QueryWrapper<SysMenu> wrapper = new QueryWrapper<SysMenu>();
        wrapper.eq("tenant_id", tenantId)
                .eq("menu_code", code)
                .last("limit 1");
        return sysMenuMapper.selectOne(wrapper);
    }

}
