package cn.song.custcenter.service.impl;

import cn.song.custcenter.entity.CustTag;
import cn.song.custcenter.mapper.CustTagMapper;
import cn.song.custcenter.service.CustTagService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import java.util.List;

/**
 * CustTag 服务实现（Wrapper / Page 压力档）。
 */
public class CustTagServiceImpl implements CustTagService {

    private final CustTagMapper custTagMapper;

    public CustTagServiceImpl(CustTagMapper custTagMapper) {
        this.custTagMapper = custTagMapper;
    }

    public List<CustTag> listByTenant(Long tenantId) {
        LambdaQueryWrapper<CustTag> wrapper = new LambdaQueryWrapper<CustTag>();
        wrapper.eq(CustTag::getTenantId, tenantId)
                .eq(CustTag::getDelFlag, "0")
                .orderByDesc(CustTag::getCreateTime);
        return custTagMapper.selectList(wrapper);
    }

    public IPage<CustTag> pageByCondition(Page<CustTag> page, Long tenantId, String keyword) {
        QueryWrapper<CustTag> wrapper = new QueryWrapper<CustTag>();
        wrapper.eq("tenant_id", tenantId)
                .eq("del_flag", "0")
                .like("tag_name", keyword)
                .orderByDesc("create_time");
        return custTagMapper.selectPage(page, wrapper);
    }

    public int updateStatus(Long id, String status) {
        CustTag entity = new CustTag();
        entity.setStatus(status);
        entity.setUpdateTime(new Date());
        LambdaQueryWrapper<CustTag> wrapper = new LambdaQueryWrapper<CustTag>();
        wrapper.eq(CustTag::getId, id);
        return custTagMapper.update(entity, wrapper);
    }

    public long countByKeyword(Long tenantId, String keyword) {
        QueryWrapper<CustTag> wrapper = new QueryWrapper<CustTag>();
        wrapper.eq("tenant_id", tenantId)
                .like("tag_name", keyword);
        Long total = custTagMapper.selectCount(wrapper);
        return total == null ? 0L : total.longValue();
    }

    public CustTag getOneByCode(Long tenantId, String code) {
        QueryWrapper<CustTag> wrapper = new QueryWrapper<CustTag>();
        wrapper.eq("tenant_id", tenantId)
                .eq("tag_code", code)
                .last("limit 1");
        return custTagMapper.selectOne(wrapper);
    }

}
