package cn.song.mybatisplusdemo.service.impl;

import cn.song.mybatisplusdemo.entity.User;
import cn.song.mybatisplusdemo.mapper.UserMapper;
import cn.song.mybatisplusdemo.service.PageSimService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 分页拦截器模拟语料实现（插件 R12 回归用，走查口径见 {@link PageSimService}）
 *
 * @author SongRenShuo
 */
@Service
public class PageSimServiceImpl implements PageSimService {

    @Resource
    private UserMapper userMapper;

    @Override
    public IPage<User> annotationPage(int current, int size, Integer status) {
        return userMapper.selectUserPageAnnotation(new Page<>(current, size), status);
    }

    @Override
    public IPage<User> xmlPage(int current, int size, Integer status, String keyword) {
        return userMapper.selectUserPageXml(new Page<>(current, size), status, keyword);
    }

    @Override
    public IPage<User> xmlLimitPage(int current, int size, Integer status) {
        // offset/pageSize 与 IPage 并存——「手写 LIMIT 分页 + IPage 计数」的真实双轨形态
        return userMapper.selectUserPageLimitXml(new Page<>(current, size), status, 0L, size);
    }

    @Override
    public IPage<User> noCountPage() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .eq(User::getDeleted, 0)
                .orderByDesc(User::getId);
        return userMapper.selectPage(new Page<>(1, 10, false), wrapper);
    }

    @Override
    public IPage<User> countOnPage() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .eq(User::getStatus, 1)
                .orderByDesc(User::getId);
        return userMapper.selectPage(new Page<>(2, 5), wrapper);
    }

    @Override
    public IPage<User> fourArgPage() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .eq(User::getDeleted, 0);
        // Page(current, size, total, searchCount)：total 预填 + 关计数
        return userMapper.selectPage(new Page<>(3, 5, 200L, false), wrapper);
    }

    @Override
    public List<User> selectListPage(boolean searchCount) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .eq(User::getDeleted, 0)
                .orderByAsc(User::getId);
        return userMapper.selectList(new Page<>(1, 20, searchCount), wrapper);
    }

    @Override
    public List<Map<String, Object>> selectMapsPage(boolean searchCount) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .select(User::getId, User::getUsername, User::getStatus)
                .eq(User::getDeleted, 0);
        return userMapper.selectMaps(new Page<>(1, 15, searchCount), wrapper);
    }
}
