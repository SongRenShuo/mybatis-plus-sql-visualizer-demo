package cn.song.custgateway.route;

/**
 * 路径匹配器。
 */
public class RouteMatcher {

    public boolean matches(RouteDefinition definition, String path) {
        if (definition == null || path == null) {
            return false;
        }
        if (!Boolean.TRUE.equals(definition.getEnabled())) {
            return false;
        }
        String pattern = definition.getPathPattern();
        if (pattern == null || pattern.length() == 0) {
            return false;
        }
        if (pattern.endsWith("/**")) {
            return path.startsWith(pattern.substring(0, pattern.length() - 3));
        }
        return pattern.equals(path);
    }
}
