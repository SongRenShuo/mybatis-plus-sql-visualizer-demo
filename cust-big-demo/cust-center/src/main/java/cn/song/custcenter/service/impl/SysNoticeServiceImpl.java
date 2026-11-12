package cn.song.custcenter.service.impl;

import cn.song.custcenter.entity.SysNotice;
import cn.song.custcenter.mapper.SysNoticeMapper;
import cn.song.custcenter.service.SysNoticeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import java.util.List;

/**
 * SysNotice 服务实现（Wrapper / Page 压力档）。
 */
public class SysNoticeServiceImpl implements SysNoticeService {

    private final SysNoticeMapper sysNoticeMapper;

    public SysNoticeServiceImpl(SysNoticeMapper sysNoticeMapper) {
        this.sysNoticeMapper = sysNoticeMapper;
    }

    public List<SysNotice> listByTenant(Long tenantId) {
        LambdaQueryWrapper<SysNotice> wrapper = new LambdaQueryWrapper<SysNotice>();
        wrapper.eq(SysNotice::getTenantId, tenantId)
                .eq(SysNotice::getDelFlag, "0")
                .orderByDesc(SysNotice::getCreateTime);
        return sysNoticeMapper.selectList(wrapper);
    }

    public IPage<SysNotice> pageByCondition(Page<SysNotice> page, Long tenantId, String keyword) {
        QueryWrapper<SysNotice> wrapper = new QueryWrapper<SysNotice>();
        wrapper.eq("tenant_id", tenantId)
                .eq("del_flag", "0")
                .like("notice_title", keyword)
                .orderByDesc("create_time");
        return sysNoticeMapper.selectPage(page, wrapper);
    }

    public int updateStatus(Long id, String status) {
        SysNotice entity = new SysNotice();
        entity.setStatus(status);
        entity.setUpdateTime(new Date());
        LambdaQueryWrapper<SysNotice> wrapper = new LambdaQueryWrapper<SysNotice>();
        wrapper.eq(SysNotice::getId, id);
        return sysNoticeMapper.update(entity, wrapper);
    }

    public long countByKeyword(Long tenantId, String keyword) {
        QueryWrapper<SysNotice> wrapper = new QueryWrapper<SysNotice>();
        wrapper.eq("tenant_id", tenantId)
                .like("notice_title", keyword);
        Long total = sysNoticeMapper.selectCount(wrapper);
        return total == null ? 0L : total.longValue();
    }

    public SysNotice getOneByCode(Long tenantId, String code) {
        QueryWrapper<SysNotice> wrapper = new QueryWrapper<SysNotice>();
        wrapper.eq("tenant_id", tenantId)
                .eq("notice_type", code)
                .last("limit 1");
        return sysNoticeMapper.selectOne(wrapper);
    }

}
