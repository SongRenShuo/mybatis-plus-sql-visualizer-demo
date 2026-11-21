package cn.song.mpjdemo.controller;

import cn.song.mpjdemo.entity.UserDO;
import cn.song.mpjdemo.mapper.UserMapper;
import cn.song.mpjdemo.service.ProxyTraceHeavyService;
import cn.song.mpjdemo.service.ProxyTraceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Proxy;

/**
 * 调用栈代理帧反解复现端点（验收册 B6 / 插件 D217 T-HdAbsorb）。
 *
 * <p>两条路径各造一种动态代理形态，SQL 都经 {@link UserMapper} 真实查库——agent 在 JDBC
 * 执行点拍栈快照，栈里必然含代理帧；SQL 日志条目的调用栈弹层里核对反解结果：
 * <ul>
 *   <li>{@code /mpj/proxy/trace/jdk}：手工 JDK 代理实现 {@link ProxyTraceService}。
 *       栈帧 {@code $ProxyN#queryUser} 反解后应显示业务接口 FQCN；</li>
 *   <li>{@code /mpj/proxy/trace/cglib}：{@code @Transactional} 触发 Spring CGLIB 类代理
 *       （{@code proxy-target-class} 默认 true）包装 {@link ProxyTraceHeavyService}。
 *       栈帧 {@code ...$$SpringCGLIB$$0#queryHeavy} 反解后应显示基类 FQCN。</li>
 * </ul>
 *
 * <p>为什么 JDK 路径用手工 {@link Proxy#newProxyInstance} 而不是切
 * {@code @EnableAspectJAutoProxy(proxyTargetClass = false)}：那是全局开关，会把 demo 里
 * 所有被 AOP 拦截的 bean 一起改成接口代理，无接口的 bean 直接启动失败；手工代理是真实
 * JDK 动态代理（运行期生成的真实 {@code $ProxyN} 类，栈帧与插件单测同源），且零扰动。
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/mpj/proxy/trace")
public class ProxyTraceController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ProxyTraceHeavyService heavyService;

    /**
     * JDK 代理形态：栈里同时有业务代理帧与 MyBatis mapper 代理帧（两个 $ProxyN 各自反解）。
     */
    @GetMapping("/jdk")
    public UserDO jdk() {
        ProxyTraceService proxy = (ProxyTraceService) Proxy.newProxyInstance(
                ProxyTraceService.class.getClassLoader(),
                new Class<?>[]{ProxyTraceService.class},
                (p, method, args) -> userMapper.selectById((Long) args[0]));
        return proxy.queryUser(1L);
    }

    /**
     * CGLIB 形态：事务代理进方法 → mapper 查库，栈里该层是增强类帧。
     */
    @GetMapping("/cglib")
    public UserDO cglib() {
        return heavyService.queryHeavy(1L);
    }
}
