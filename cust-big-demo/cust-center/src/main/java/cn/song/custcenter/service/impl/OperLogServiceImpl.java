package cn.song.custcenter.service.impl;

import cn.song.custcenter.entity.OperLog;
import cn.song.custcenter.mapper.OperLogMapper;
import cn.song.custcenter.service.OperLogService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import java.util.List;

/**
 * OperLog 服务实现（Wrapper / Page 压力档）。
 */
public class OperLogServiceImpl implements OperLogService {

    private final OperLogMapper operLogMapper;

    public OperLogServiceImpl(OperLogMapper operLogMapper) {
        this.operLogMapper = operLogMapper;
    }

    public List<OperLog> listByTenant(Long tenantId) {
        LambdaQueryWrapper<OperLog> wrapper = new LambdaQueryWrapper<OperLog>();
        wrapper.eq(OperLog::getTenantId, tenantId)
                .eq(OperLog::getDelFlag, "0")
                .orderByDesc(OperLog::getCreateTime);
        return operLogMapper.selectList(wrapper);
    }

    public IPage<OperLog> pageByCondition(Page<OperLog> page, Long tenantId, String keyword) {
        QueryWrapper<OperLog> wrapper = new QueryWrapper<OperLog>();
        wrapper.eq("tenant_id", tenantId)
                .eq("del_flag", "0")
                .like("oper_module", keyword)
                .orderByDesc("create_time");
        return operLogMapper.selectPage(page, wrapper);
    }

    public int updateStatus(Long id, String status) {
        OperLog entity = new OperLog();
        entity.setStatus(status);
        entity.setUpdateTime(new Date());
        LambdaQueryWrapper<OperLog> wrapper = new LambdaQueryWrapper<OperLog>();
        wrapper.eq(OperLog::getId, id);
        return operLogMapper.update(entity, wrapper);
    }

    public long countByKeyword(Long tenantId, String keyword) {
        QueryWrapper<OperLog> wrapper = new QueryWrapper<OperLog>();
        wrapper.eq("tenant_id", tenantId)
                .like("oper_module", keyword);
        Long total = operLogMapper.selectCount(wrapper);
        return total == null ? 0L : total.longValue();
    }

    public OperLog getOneByCode(Long tenantId, String code) {
        QueryWrapper<OperLog> wrapper = new QueryWrapper<OperLog>();
        wrapper.eq("tenant_id", tenantId)
                .eq("oper_module", code)
                .last("limit 1");
        return operLogMapper.selectOne(wrapper);
    }

}
