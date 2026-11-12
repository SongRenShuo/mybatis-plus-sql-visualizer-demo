package cn.song.custcenter.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 参数配置 视图对象。
 */
public class SysConfigVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 关键字 */
    private String configDesc;

    /** 状态 */
    private String status;

    /** 创建时间 */
    private Date createTime;

    public String getConfigDesc() {
        return configDesc;
    }

    public void setConfigDesc(String configDesc) {
        this.configDesc = configDesc;
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
        sb.append("SysConfigVO{");
        sb.append("configDesc=").append(configDesc).append(", ");
        sb.append("status=").append(status).append(", ");
        sb.append("createTime=").append(createTime).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
