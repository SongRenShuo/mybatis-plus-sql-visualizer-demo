package cn.song.custcenter.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志 视图对象。
 */
public class OperLogVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 关键字 */
    private String operModule;

    /** 状态 */
    private String status;

    /** 创建时间 */
    private Date createTime;

    public String getOperModule() {
        return operModule;
    }

    public void setOperModule(String operModule) {
        this.operModule = operModule;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OperLogVO{");
        sb.append("operModule=").append(operModule).append(", ");
        sb.append("status=").append(status).append(", ");
        sb.append("createTime=").append(createTime).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
