package cn.song.jdk16demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.song.jdk16demo.entity.User;
import cn.song.jdk16demo.mapper.UserMapper;
import cn.song.jdk16demo.service.UserService;

/**
 * UserService 实现类：字段 @Autowired + @Transactional 的老式写法，
 * SQL 全部落到 UserMapper（XML 动态 SQL + 一条注解 SQL）。
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public User create(User user) {
        if (user.getStatus() == null) {
            user.setStatus(Integer.valueOf(0));
        }
        user.setCreatedTime(new Date());
        userMapper.insert(user);
        return user;
    }

    public User getById(Long id) {
        return userMapper.selectById(id);
    }

    public List<User> list(User query) {
        return userMapper.selectList(query);
    }

    @Transactional
    public User update(User user) {
        if (userMapper.updateById(user) == 0) {
            return null;
        }
        return userMapper.selectById(user.getId());
    }

    @Transactional
    public int deleteById(Long id) {
        return userMapper.deleteById(id);
    }

    public List<User> search(String keyword, List<Long> ids) {
        return userMapper.searchByKeyword(keyword, ids);
    }

    public int countByStatus(Integer status) {
        return userMapper.countByStatus(status);
    }
}
