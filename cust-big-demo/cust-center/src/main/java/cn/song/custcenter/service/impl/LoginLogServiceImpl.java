package cn.song.custcenter.service.impl;

import cn.song.custcenter.entity.LoginLog;
import cn.song.custcenter.mapper.LoginLogMapper;
import cn.song.custcenter.service.LoginLogService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import java.util.List;

/**
 * LoginLog 服务实现（Wrapper / Page 压力档）。
 */
public class LoginLogServiceImpl implements LoginLogService {

    private final LoginLogMapper loginLogMapper;

    public LoginLogServiceImpl(LoginLogMapper loginLogMapper) {
        this.loginLogMapper = loginLogMapper;
    }

    public List<LoginLog> listByTenant(Long tenantId) {
        LambdaQueryWrapper<LoginLog> wrapper = new LambdaQueryWrapper<LoginLog>();
        wrapper.eq(LoginLog::getTenantId, tenantId)
                .eq(LoginLog::getDelFlag, "0")
                .orderByDesc(LoginLog::getCreateTime);
        return loginLogMapper.selectList(wrapper);
    }

    public IPage<LoginLog> pageByCondition(Page<LoginLog> page, Long tenantId, String keyword) {
        QueryWrapper<LoginLog> wrapper = new QueryWrapper<LoginLog>();
        wrapper.eq("tenant_id", tenantId)
                .eq("del_flag", "0")
                .like("login_user", keyword)
                .orderByDesc("create_time");
        return loginLogMapper.selectPage(page, wrapper);
    }

    public int updateStatus(Long id, String status) {
        LoginLog entity = new LoginLog();
        entity.setStatus(status);
        entity.setUpdateTime(new Date());
        LambdaQueryWrapper<LoginLog> wrapper = new LambdaQueryWrapper<LoginLog>();
        wrapper.eq(LoginLog::getId, id);
        return loginLogMapper.update(entity, wrapper);
    }

    public long countByKeyword(Long tenantId, String keyword) {
        QueryWrapper<LoginLog> wrapper = new QueryWrapper<LoginLog>();
        wrapper.eq("tenant_id", tenantId)
                .like("login_user", keyword);
        Long total = loginLogMapper.selectCount(wrapper);
        return total == null ? 0L : total.longValue();
    }

    public LoginLog getOneByCode(Long tenantId, String code) {
        QueryWrapper<LoginLog> wrapper = new QueryWrapper<LoginLog>();
        wrapper.eq("tenant_id", tenantId)
                .eq("login_user", code)
                .last("limit 1");
        return loginLogMapper.selectOne(wrapper);
    }

}
