package cn.song.mpjdemo.service;

import cn.song.mpjdemo.entity.UserDO;
import cn.song.mpjdemo.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * CGLIB 类代理反解复现用服务（验收册 B6 / 插件 D217 T-HdAbsorb）。
 *
 * <p>刻意不实现接口：Spring Boot 默认 {@code spring.aop.proxy-target-class=true}，
 * {@code @Transactional} 触发的代理是 CGLIB 类增强——调用栈里该 bean 的帧类名是
 * {@code ProxyTraceHeavyService$$SpringCGLIB$$0}，经插件 D217 剥后缀后应显示为
 * {@code cn.song.mpjdemo.service.ProxyTraceHeavyService} 基类 FQCN，而不是带
 * {@code $$SpringCGLIB$$} 的增强类名。
 *
 * @author SongRenShuo
 */
@Service
public class ProxyTraceHeavyService {

    @Resource
    private UserMapper userMapper;

    /**
     * readOnly 查询事务：只为触发 Spring 给这个类建 CGLIB 代理（查询本身无副作用）。
     */
    @Transactional(readOnly = true)
    public UserDO queryHeavy(long id) {
        return userMapper.selectById(id);
    }
}
