package cn.song.custgateway.route;

import java.io.Serializable;

/**
 * 路由定义。
 */
public class RouteDefinition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 路由ID */
    private String routeId;

    /** 路径模式 */
    private String pathPattern;

    /** 目标地址 */
    private String targetUri;

    /** 是否启用 */
    private Boolean enabled;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getPathPattern() {
        return pathPattern;
    }

    public void setPathPattern(String pathPattern) {
        this.pathPattern = pathPattern;
    }

    public String getTargetUri() {
        return targetUri;
    }

    public void setTargetUri(String targetUri) {
        this.targetUri = targetUri;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RouteDefinition{");
        sb.append("routeId=").append(routeId).append(", ");
        sb.append("pathPattern=").append(pathPattern).append(", ");
        sb.append("targetUri=").append(targetUri).append(", ");
        sb.append("enabled=").append(enabled).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
