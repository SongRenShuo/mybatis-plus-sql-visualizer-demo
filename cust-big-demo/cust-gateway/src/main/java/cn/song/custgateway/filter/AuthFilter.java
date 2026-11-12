package cn.song.custgateway.filter;

/**
 * 鉴权过滤器。
 */
public class AuthFilter implements GatewayFilter {

    public int order() {
        return 10;
    }

    public boolean accept(String path, String token) {
        if (path == null || path.length() == 0) {
            return false;
        }
        if (path.startsWith("/public/")) {
            return true;
        }
        return token != null && token.length() > 8;
    }
}
