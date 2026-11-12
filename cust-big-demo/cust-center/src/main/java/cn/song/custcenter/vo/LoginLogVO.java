package cn.song.custcenter.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录日志 视图对象。
 */
public class LoginLogVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 关键字 */
    private String loginUser;

    /** 状态 */
    private String status;

    /** 创建时间 */
    private Date createTime;

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
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
        sb.append("LoginLogVO{");
        sb.append("loginUser=").append(loginUser).append(", ");
        sb.append("status=").append(status).append(", ");
        sb.append("createTime=").append(createTime).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
