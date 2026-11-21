package cn.song.mpjdemo.service;

import cn.song.mpjdemo.entity.UserDO;

/**
 * JDK 动态代理反解复现用业务接口（验收册 B6 / 插件 D217 T-HdAbsorb）。
 *
 * <p>为什么单独建接口：MyBatis 的 mapper 本身也是 JDK 代理（栈里天然有 {@code $ProxyN} 帧），
 * 但它的接口在 mapper 包、与业务代理混在一起不好单独观察；本接口让「业务接口」形态
 * 可以独立核对——agent 栈快照里的 {@code $ProxyN#queryUser} 帧经插件 D217 反解后应显示为
 * {@code cn.song.mpjdemo.service.ProxyTraceService#queryUser}（首个非框架接口），
 * 而不是 {@code com.sun.proxy.$ProxyN}。
 *
 * @author SongRenShuo
 */
public interface ProxyTraceService {

    UserDO queryUser(long id);
}
