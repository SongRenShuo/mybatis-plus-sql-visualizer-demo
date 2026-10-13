package probe;

/**
 * 方法追踪真机走查夹具：嵌套类 + 常驻 main。
 * <p>
 * 用 IDEA 的 Application 运行配置启动（插件会把 -javaagent 与 cool.request.port 注入运行配置，
 * 所以必须从 IDE 里以运行配置启动，不能用 java -jar / 命令行）。JVM 常驻后：
 * 在 {@code Inner#ping} 上加追踪（右键 → Cool Request → Add Method To Trace），
 * 再用 Cool Request → Call this Method 调它，检查响应区 Trace 页签是否出现根节点
 * {@code TraceProbe.Inner.ping}。
 * <p>
 * 这一条专门验「嵌套类追踪」：嵌套类的 JVM 二进制名带 $（probe.TraceProbe$Inner），
 * 与 PSI 点号名（probe.TraceProbe.Inner）形态不同，两边不归一化就对不上。
 */
public class TraceProbe {

    /**
     * 常驻实例。插件的 Call this Method 对实例方法会向 agent 要「该类已加载的对象实例」，
     * JVM 里没有实例时只报 no object instances found，方法不会被调用、也就没有追踪帧。
     */
    public static final Inner INSTANCE = new Inner();

    public static class Inner {
        public String ping(String who) {
            return "pong:" + who;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("TraceProbe up, nested class = " + Inner.class.getName()
                + ", self-check = " + INSTANCE.ping("boot"));
        // 周期性调用被追踪的方法：插件发出请求时会把入口点钩子装到 agent 上，
        // 之后由本进程自己触发调用，帧就能回到插件（不依赖 Call this Method 的实例查找）。
        while (true) {
            INSTANCE.ping("tick-" + System.currentTimeMillis());
            Thread.sleep(1000L);
        }
    }
}
