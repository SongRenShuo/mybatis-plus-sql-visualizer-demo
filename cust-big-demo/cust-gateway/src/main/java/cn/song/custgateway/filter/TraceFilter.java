package cn.song.custgateway.filter;

/**
 * 链路追踪过滤器。
 */
public class TraceFilter implements GatewayFilter {

    public int order() {
        return 20;
    }

    public boolean accept(String path, String token) {
        return path != null && path.startsWith("/api/");
    }
}
