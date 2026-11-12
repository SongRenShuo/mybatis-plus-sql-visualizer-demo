package cn.song.custgateway.filter;

/**
 * 访问日志过滤器。
 */
public class LogFilter implements GatewayFilter {

    public int order() {
        return 50;
    }

    public boolean accept(String path, String token) {
        return true;
    }
}
