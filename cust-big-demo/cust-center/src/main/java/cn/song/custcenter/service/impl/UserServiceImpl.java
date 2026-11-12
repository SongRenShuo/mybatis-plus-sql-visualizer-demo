package cn.song.custcenter.service.impl;

import cn.song.custcenter.entity.User;
import cn.song.custcenter.mapper.UserMapper;
import cn.song.custcenter.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import java.util.List;

/**
 * User 服务实现（Wrapper / Page 压力档）。
 */
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> listByTenant(Long tenantId) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
        wrapper.eq(User::getTenantId, tenantId)
                .eq(User::getDelFlag, "0")
                .orderByDesc(User::getCreateTime);
        return userMapper.selectList(wrapper);
    }

    public IPage<User> pageByCondition(Page<User> page, Long tenantId, String keyword) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("tenant_id", tenantId)
                .eq("del_flag", "0")
                .like("user_name", keyword)
                .orderByDesc("create_time");
        return userMapper.selectPage(page, wrapper);
    }

    public int updateStatus(Long id, String status) {
        User entity = new User();
        entity.setStatus(status);
        entity.setUpdateTime(new Date());
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
        wrapper.eq(User::getId, id);
        return userMapper.update(entity, wrapper);
    }

    public long countByKeyword(Long tenantId, String keyword) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("tenant_id", tenantId)
                .like("user_name", keyword);
        Long total = userMapper.selectCount(wrapper);
        return total == null ? 0L : total.longValue();
    }

    public User getOneByCode(Long tenantId, String code) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("tenant_id", tenantId)
                .eq("user_name", code)
                .last("limit 1");
        return userMapper.selectOne(wrapper);
    }

}
