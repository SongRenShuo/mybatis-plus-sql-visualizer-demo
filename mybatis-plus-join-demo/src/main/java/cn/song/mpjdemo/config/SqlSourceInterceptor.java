package cn.song.mpjdemo.config;

import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.SQLException;
import java.util.Set;

/**
 * SQL Visualizer 源码位置捕获拦截器（自动生成）。
 *
 * 在 SQL 执行时捕获调用栈，打印源码标记行到控制台。
 * 插件解析后可实现「跳转到源码」精确跳转。
 *
 * 标记行格式：SQLVIS-SOURCE|&lt;相对路径&gt;|&lt;行号&gt;
 * 例：SQLVIS-SOURCE|src/main/java/com/example/service/UserService.java|87
 *
 * 自动生成于 SQL Visualizer 插件，可安全删除（删除后实时日志不再携带源码位置）。
 */
public class SqlSourceInterceptor implements InnerInterceptor {

    private final Set<String> appPackages;

    public SqlSourceInterceptor(Set<String> appPackages) {
        this.appPackages = appPackages;
    }

    /**
     * 查询前拦截——打印源码标记行。
     * 注意：不加 @Override，兼容不同 MP 版本的 InnerInterceptor 接口签名差异。
     */
    @SuppressWarnings("unused")
    public void beforeQuery(Executor executor, MappedStatement ms,
            Object parameter, RowBounds rowBounds,
            ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        emitSource();
    }

    /**
     * 更新前拦截——打印源码标记行。
     */
    @SuppressWarnings("unused")
    public void beforeUpdate(Executor executor, MappedStatement ms,
            Object parameter) throws SQLException {
        emitSource();
    }

    /** 把当前线程调用栈里的真实调用点打印成标记行。 */
    private void emitSource() {
        String[] src = locateSource();
        if (src != null) {
            System.out.println("SQLVIS-SOURCE|" + src[0] + "|" + src[1]);
        }
    }

    /** 沿调用栈跳过框架帧和拦截器自身，取第一个用户代码帧。返回 [相对路径, 行号] 或 null。 */
    private String[] locateSource() {
        for (StackTraceElement frame : Thread.currentThread().getStackTrace()) {
            String cn = frame.getClassName();
            if (isFrameworkFrame(cn)) continue;
            if (isSelf(cn)) continue;  // 跳过拦截器自身
            if (!appPackages.isEmpty() && startsWithNone(cn)) continue;
            String fileName = frame.getFileName();
            if (fileName == null) continue;
            String pkg = substringBeforeLast(cn, '.');
            String rel = pkg.isEmpty() ? fileName : pkg.replace('.', '/') + "/" + fileName;
            int line = frame.getLineNumber();
            if (line < 0) continue;
            return new String[]{rel, String.valueOf(line)};
        }
        return null;
    }

    /**
     * 是否为拦截器自身（跳过，避免捕获到自己的位置）。
     * 用运行时类名而非生成期包名常量——用户拷贝/改包/改类名后自跳过依旧生效
     * （历史缺陷：包名常量与运行类分叉时拦截器自身帧被当成调用点上报）。
     */
    private boolean isSelf(String cn) {
        return cn.equals(getClass().getName());
    }

    /** 取 str 中 delimiter 最后一次出现之前的子串（兼容 Java 8+，无 Kotlin 扩展方法）。 */
    private static String substringBeforeLast(String str, char delimiter) {
        int idx = str.lastIndexOf(delimiter);
        return idx < 0 ? "" : str.substring(0, idx);
    }

    /** 检查 cn 是否不以任何 appPackage 开头。 */
    private boolean startsWithNone(String cn) {
        for (String pkg : appPackages) {
            if (cn.startsWith(pkg)) return false;
        }
        return true;
    }

    /** 框架 / 基础设施帧一律跳过（不视为调用点）。 */
    private boolean isFrameworkFrame(String cn) {
        return cn.startsWith("java.") || cn.startsWith("javax.") || cn.startsWith("jdk.") ||
                cn.startsWith("sun.") || cn.startsWith("com.intellij.") || cn.startsWith("org.jetbrains.") ||
                cn.startsWith("cn.song.mybatisplus.visualizer.") || cn.startsWith("com.baomidou.") ||
                cn.startsWith("org.apache.ibatis.") || cn.startsWith("org.hibernate.") ||
                cn.startsWith("com.zaxxer.") || cn.startsWith("org.springframework.") ||
                cn.startsWith("com.sun.proxy.") || cn.startsWith("$Proxy");
    }
}