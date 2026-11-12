package cn.song.custcenter.service.impl;

import cn.song.custcenter.entity.SysDept;
import cn.song.custcenter.mapper.SysDeptMapper;
import cn.song.custcenter.service.SysDeptService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import java.util.List;

/**
 * SysDept 服务实现（Wrapper / Page 压力档）。
 */
public class SysDeptServiceImpl implements SysDeptService {

    private final SysDeptMapper sysDeptMapper;

    public SysDeptServiceImpl(SysDeptMapper sysDeptMapper) {
        this.sysDeptMapper = sysDeptMapper;
    }

    public List<SysDept> listByTenant(Long tenantId) {
        LambdaQueryWrapper<SysDept> wrapper = new LambdaQueryWrapper<SysDept>();
        wrapper.eq(SysDept::getTenantId, tenantId)
                .eq(SysDept::getDelFlag, "0")
                .orderByDesc(SysDept::getCreateTime);
        return sysDeptMapper.selectList(wrapper);
    }

    public IPage<SysDept> pageByCondition(Page<SysDept> page, Long tenantId, String keyword) {
        QueryWrapper<SysDept> wrapper = new QueryWrapper<SysDept>();
        wrapper.eq("tenant_id", tenantId)
                .eq("del_flag", "0")
                .like("dept_name", keyword)
                .orderByDesc("create_time");
        return sysDeptMapper.selectPage(page, wrapper);
    }

    public int updateStatus(Long id, String status) {
        SysDept entity = new SysDept();
        entity.setStatus(status);
        entity.setUpdateTime(new Date());
        LambdaQueryWrapper<SysDept> wrapper = new LambdaQueryWrapper<SysDept>();
        wrapper.eq(SysDept::getId, id);
        return sysDeptMapper.update(entity, wrapper);
    }

    public long countByKeyword(Long tenantId, String keyword) {
        QueryWrapper<SysDept> wrapper = new QueryWrapper<SysDept>();
        wrapper.eq("tenant_id", tenantId)
                .like("dept_name", keyword);
        Long total = sysDeptMapper.selectCount(wrapper);
        return total == null ? 0L : total.longValue();
    }

    public SysDept getOneByCode(Long tenantId, String code) {
        QueryWrapper<SysDept> wrapper = new QueryWrapper<SysDept>();
        wrapper.eq("tenant_id", tenantId)
                .eq("dept_code", code)
                .last("limit 1");
        return sysDeptMapper.selectOne(wrapper);
    }

}
