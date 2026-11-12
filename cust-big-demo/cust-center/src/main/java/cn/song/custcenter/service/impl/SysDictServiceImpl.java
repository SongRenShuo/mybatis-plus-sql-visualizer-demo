package cn.song.custcenter.service.impl;

import cn.song.custcenter.entity.SysDict;
import cn.song.custcenter.mapper.SysDictMapper;
import cn.song.custcenter.service.SysDictService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import java.util.List;

/**
 * SysDict 服务实现（Wrapper / Page 压力档）。
 */
public class SysDictServiceImpl implements SysDictService {

    private final SysDictMapper sysDictMapper;

    public SysDictServiceImpl(SysDictMapper sysDictMapper) {
        this.sysDictMapper = sysDictMapper;
    }

    public List<SysDict> listByTenant(Long tenantId) {
        LambdaQueryWrapper<SysDict> wrapper = new LambdaQueryWrapper<SysDict>();
        wrapper.eq(SysDict::getTenantId, tenantId)
                .eq(SysDict::getDelFlag, "0")
                .orderByDesc(SysDict::getCreateTime);
        return sysDictMapper.selectList(wrapper);
    }

    public IPage<SysDict> pageByCondition(Page<SysDict> page, Long tenantId, String keyword) {
        QueryWrapper<SysDict> wrapper = new QueryWrapper<SysDict>();
        wrapper.eq("tenant_id", tenantId)
                .eq("del_flag", "0")
                .like("dict_label", keyword)
                .orderByDesc("create_time");
        return sysDictMapper.selectPage(page, wrapper);
    }

    public int updateStatus(Long id, String status) {
        SysDict entity = new SysDict();
        entity.setStatus(status);
        entity.setUpdateTime(new Date());
        LambdaQueryWrapper<SysDict> wrapper = new LambdaQueryWrapper<SysDict>();
        wrapper.eq(SysDict::getId, id);
        return sysDictMapper.update(entity, wrapper);
    }

    public long countByKeyword(Long tenantId, String keyword) {
        QueryWrapper<SysDict> wrapper = new QueryWrapper<SysDict>();
        wrapper.eq("tenant_id", tenantId)
                .like("dict_label", keyword);
        Long total = sysDictMapper.selectCount(wrapper);
        return total == null ? 0L : total.longValue();
    }

    public SysDict getOneByCode(Long tenantId, String code) {
        QueryWrapper<SysDict> wrapper = new QueryWrapper<SysDict>();
        wrapper.eq("tenant_id", tenantId)
                .eq("dict_type", code)
                .last("limit 1");
        return sysDictMapper.selectOne(wrapper);
    }

}
