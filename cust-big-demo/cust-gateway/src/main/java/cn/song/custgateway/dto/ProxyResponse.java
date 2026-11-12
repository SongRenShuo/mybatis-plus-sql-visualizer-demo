package cn.song.custgateway.dto;

import java.io.Serializable;

/**
 * 代理响应。
 */
public class ProxyResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 状态码 */
    private Integer status;

    /** 响应体 */
    private String body;

    /** 耗时毫秒 */
    private Long costMillis;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getCostMillis() {
        return costMillis;
    }

    public void setCostMillis(Long costMillis) {
        this.costMillis = costMillis;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProxyResponse{");
        sb.append("status=").append(status).append(", ");
        sb.append("body=").append(body).append(", ");
        sb.append("costMillis=").append(costMillis).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
