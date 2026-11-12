package cn.song.custgateway.config;

/**
 * 网关参数。
 */
public class GatewayProperties {

    public static final int DEFAULT_TIMEOUT = 3000;

    public static final int MAX_RETRY = 2;

    public static final int MAX_BODY_SIZE = 1024 * 1024;

    private int timeout = DEFAULT_TIMEOUT;

    private int retry = MAX_RETRY;

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }
}
