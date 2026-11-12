package cn.song.custgateway.route;

import java.util.ArrayList;
import java.util.List;

/**
 * 路由定位器。
 */
public class RouteLocatorImpl {

    private final RouteRegistry registry;

    private final RouteMatcher matcher = new RouteMatcher();

    public RouteLocatorImpl(RouteRegistry registry) {
        this.registry = registry;
    }

    public RouteDefinition locate(String path) {
        List<RouteDefinition> definitions = registry.listAll();
        for (RouteDefinition definition : definitions) {
            if (matcher.matches(definition, path)) {
                return definition;
            }
        }
        return null;
    }

    public List<String> locateAll(List<String> paths) {
        List<String> result = new ArrayList<String>();
        for (String path : paths) {
            RouteDefinition definition = locate(path);
            if (definition != null) {
                result.add(definition.getRouteId());
            }
        }
        return result;
    }
}
