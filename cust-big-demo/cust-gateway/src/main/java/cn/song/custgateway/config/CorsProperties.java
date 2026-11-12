package cn.song.custgateway.config;

/**
 * 跨域参数。
 */
public class CorsProperties {

    private String allowedOrigin = "*";

    private String allowedMethod = "GET,POST,PUT,DELETE,OPTIONS";

    public String getAllowedOrigin() {
        return allowedOrigin;
    }

    public void setAllowedOrigin(String allowedOrigin) {
        this.allowedOrigin = allowedOrigin;
    }

    public String getAllowedMethod() {
        return allowedMethod;
    }

    public void setAllowedMethod(String allowedMethod) {
        this.allowedMethod = allowedMethod;
    }
}
