package com.corp.engine;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 自研框架 JDK 动态代理工厂：为门面接口生成运行期代理。
 *
 * <p>代理类形如 {@code com.sun.proxy.$ProxyN}——内置帧名单已按 {@code com.sun.proxy.} 与
 * {@code $Proxy} 双重规则跳过，因此代理不会污染主位置判定；调用处理器（本类的匿名内部类）
 * 落在 {@code com.corp.engine} 下，随引擎前缀一并被跳过。
 *
 * @author SongRenShuo
 */
public final class JdkProxyFactory {

    private JdkProxyFactory() {
    }

    /** 为给定门面实现生成 JDK 动态代理。 */
    public static DataAccessFacade proxy(final DataAccessFacade target) {
        return (DataAccessFacade) Proxy.newProxyInstance(
                DataAccessFacade.class.getClassLoader(),
                new Class<?>[]{DataAccessFacade.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try {
                            return method.invoke(target, args);
                        } catch (InvocationTargetException e) {
                            throw e.getCause() == null ? e : e.getCause();
                        }
                    }
                });
    }
}
