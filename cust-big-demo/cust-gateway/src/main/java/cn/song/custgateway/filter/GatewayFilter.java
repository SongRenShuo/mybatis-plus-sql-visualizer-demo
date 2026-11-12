package cn.song.custgateway.filter;

/**
 * 网关过滤器契约。
 */
public interface GatewayFilter {

    int order();

    boolean accept(String path, String token);
}
