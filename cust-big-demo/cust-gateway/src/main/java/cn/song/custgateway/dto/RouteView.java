package cn.song.custgateway.dto;

import java.io.Serializable;

/**
 * 路由视图。
 */
public class RouteView implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 路由ID */
    private String routeId;

    /** 路径模式 */
    private String pathPattern;

    /** 目标地址 */
    private String targetUri;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RouteView{");
        sb.append("routeId=").append(routeId).append(", ");
        sb.append("pathPattern=").append(pathPattern).append(", ");
        sb.append("targetUri=").append(targetUri).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
