package cn.song.custgateway.filter;

/**
 * 限流过滤器。
 */
public class RateLimitFilter implements GatewayFilter {

    public int order() {
        return 30;
    }

    public boolean accept(String path, String token) {
        if (path == null) {
            return false;
        }
        return path.length() < 512;
    }
}
