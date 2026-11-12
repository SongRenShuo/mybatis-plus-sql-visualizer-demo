package cn.song.custgateway.dto;

import java.io.Serializable;

/**
 * 代理请求。
 */
public class ProxyRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /** HTTP 方法 */
    private String method;

    /** 请求路径 */
    private String path;

    /** 访问令牌 */
    private String token;

    /** 请求体 */
    private String body;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProxyRequest{");
        sb.append("method=").append(method).append(", ");
        sb.append("path=").append(path).append(", ");
        sb.append("token=").append(token).append(", ");
        sb.append("body=").append(body).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
