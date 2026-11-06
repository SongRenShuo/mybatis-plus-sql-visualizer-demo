package cn.song.mpjdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 连接对象强转探针（T-ConnCastSafety 复现用）。
 *
 * <p>用途：绕开连接池，从驱动直接取原始连接，再按真实工程的写法**强转到驱动实现类**。
 * 增强捕获旧版本会在驱动 {@code connect} 出口把返回值换成 JDK 动态代理，而动态代理只能实现接口、
 * 无法伪装成驱动实现类，于是这里必抛：
 * <pre>
 * ClassCastException: com.sun.proxy.$ProxyN cannot be cast to dm.jdbc.driver.DmdbConnection
 * </pre>
 * 修复后的版本连接原样返回，强转成功。
 *
 * <p>为什么不用 {@code DataSource.getConnection()}：Hikari 自己也会返回代理对象，
 * 那层代理与插件无关，强转本来就会失败，测不出插件行为。必须走 {@link DriverManager}。
 *
 * <p>profile 无关：URL / 账号 / 驱动类全部读 {@code spring.datasource.*}，
 * mysql profile 与 dm profile 都能跑（dm 强转 {@code DmdbConnection}，mysql 强转 {@code ConnectionImpl}）。
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/probe")
public class ConnCastProbeController {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    /**
     * 取原始连接并强转到驱动实现类。
     *
     * <p>返回体字段：{@code driver} 驱动类、{@code connClass} 实际拿到的连接类、{@code castOk} 强转结果、
     * {@code castTarget} 强转目标实现类、{@code detail} 失败时的异常摘要。看 {@code connClass} 就能
     * 一眼判定是否被插件换成了 {@code com.sun.proxy.$ProxyN}。
     */
    @GetMapping("/conn-cast")
    public Map<String, Object> connCast() {
        final Map<String, Object> out = new LinkedHashMap<>();
        out.put("driver", driverClassName);
        out.put("url", maskPassword(url));
        Connection conn = null;
        try {
            Class.forName(driverClassName);
            conn = DriverManager.getConnection(url, username, password);
            out.put("connClass", conn.getClass().getName());
            out.put("agentMarker", System.getProperty("sqlvis.agent.active"));
            out.put("weaverLoaded", loadable("cn.song.mybatisplus.sqlvis.agent.SqlHookTransformer"));
            // 证据面：字节码校验开关（-Xverify:none/-noverify 会让织入出的坏帧不报错，直接改变复现形态）
            out.put("javaVersion", System.getProperty("java.version"));
            out.put("jvmArgs", java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments());
            if (java.lang.reflect.Proxy.isProxyClass(conn.getClass())) {
                final Object handler = java.lang.reflect.Proxy.getInvocationHandler(conn);
                out.put("proxyHandler", handler == null ? null : handler.getClass().getName());
                final StringBuilder ifaces = new StringBuilder();
                for (Class<?> i : conn.getClass().getInterfaces()) {
                    if (ifaces.length() > 0) {
                        ifaces.append(',');
                    }
                    ifaces.append(i.getName());
                }
                out.put("proxyInterfaces", ifaces.toString());
            }

            final String target;
            if (driverClassName.startsWith("dm.")) {
                target = "dm.jdbc.driver.DmdbConnection";
                final dm.jdbc.driver.DmdbConnection dmConn = (dm.jdbc.driver.DmdbConnection) conn;
                out.put("castOk", true);
                out.put("detail", "cast ok, class=" + dmConn.getClass().getName());
            } else if (driverClassName.startsWith("com.mysql")) {
                target = "com.mysql.cj.jdbc.ConnectionImpl";
                final com.mysql.cj.jdbc.ConnectionImpl mysqlConn = (com.mysql.cj.jdbc.ConnectionImpl) conn;
                out.put("castOk", true);
                out.put("detail", "cast ok, class=" + mysqlConn.getClass().getName());
            } else {
                target = "(未登记的强转目标)";
                out.put("castOk", false);
                out.put("detail", "该探针只覆盖 dm.* 与 com.mysql.* 驱动");
            }
            out.put("castTarget", target);
        } catch (Throwable t) {
            // 探针把失败如实报出来，不当异常抛（便于直接看响应）
            out.put("castOk", false);
            out.put("error", t.getClass().getName());
            out.put("detail", String.valueOf(t.getMessage()));
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Throwable ignore) {
                    // 探针不关心关闭语义
                }
            }
        }
        return out;
    }

    /** 类是否在当前 JVM 可见（判定织入通道是否在役，不触发初始化以外的副作用）。 */
    private static boolean loadable(String className) {
        try {
            Class.forName(className, false, ConnCastProbeController.class.getClassLoader());
            return true;
        } catch (Throwable t) {
            return false;
        }
    }

    /** URL 里可能带密码参数，回显时打码。 */    private static String maskPassword(String raw) {
        if (raw == null) {
            return null;
        }
        return raw.replaceAll("(?i)(password=)[^&;]*", "$1***");
    }
}
