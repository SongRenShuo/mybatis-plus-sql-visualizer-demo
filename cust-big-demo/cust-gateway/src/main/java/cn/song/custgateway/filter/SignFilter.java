package cn.song.custgateway.filter;

/**
 * 签名校验过滤器。
 */
public class SignFilter implements GatewayFilter {

    public int order() {
        return 40;
    }

    public boolean accept(String path, String token) {
        if (path == null || token == null) {
            return false;
        }
        return token.indexOf('.') > 0;
    }
}
