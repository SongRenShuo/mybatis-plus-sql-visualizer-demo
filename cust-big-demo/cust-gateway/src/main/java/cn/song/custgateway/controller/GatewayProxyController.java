package cn.song.custgateway.controller;

import cn.song.custcommon.api.ApiResult;
import cn.song.custgateway.dto.ProxyRequest;
import cn.song.custgateway.dto.ProxyResponse;
import cn.song.custgateway.filter.GatewayFilter;
import cn.song.custgateway.route.RouteDefinition;
import cn.song.custgateway.route.RouteLocatorImpl;
import java.util.List;

/**
 * 网关代理入口。
 */
public class GatewayProxyController {

    private final RouteLocatorImpl routeLocator;

    private final List<GatewayFilter> filters;

    public GatewayProxyController(RouteLocatorImpl routeLocator, List<GatewayFilter> filters) {
        this.routeLocator = routeLocator;
        this.filters = filters;
    }

    public ApiResult<ProxyResponse> proxy(ProxyRequest request) {
        RouteDefinition definition = routeLocator.locate(request.getPath());
        if (definition == null) {
            return ApiResult.fail(404, "route not found");
        }
        for (GatewayFilter filter : filters) {
            if (!filter.accept(request.getPath(), request.getToken())) {
                return ApiResult.fail(403, "blocked by " + filter.getClass().getSimpleName());
            }
        }
        ProxyResponse response = new ProxyResponse();
        response.setStatus(Integer.valueOf(200));
        response.setBody(definition.getTargetUri());
        response.setCostMillis(Long.valueOf(0L));
        return ApiResult.ok(response);
    }
}
