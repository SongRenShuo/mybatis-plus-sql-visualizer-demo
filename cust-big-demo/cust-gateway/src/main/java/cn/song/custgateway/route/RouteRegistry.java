package cn.song.custgateway.route;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 内存路由表。
 */
public class RouteRegistry {

    private final Map<String, RouteDefinition> routes = new LinkedHashMap<String, RouteDefinition>();

    public void register(RouteDefinition definition) {
        if (definition != null && definition.getRouteId() != null) {
            routes.put(definition.getRouteId(), definition);
        }
    }

    public RouteDefinition find(String routeId) {
        return routes.get(routeId);
    }

    public List<RouteDefinition> listAll() {
        return new ArrayList<RouteDefinition>(routes.values());
    }

    public int size() {
        return routes.size();
    }
}
