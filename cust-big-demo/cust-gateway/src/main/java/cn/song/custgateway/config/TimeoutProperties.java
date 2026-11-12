package cn.song.custgateway.config;

/**
 * 超时参数。
 */
public class TimeoutProperties {

    private int connectTimeout = 1000;

    private int readTimeout = 3000;

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }
}
