package cn.song.custcenter.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色 视图对象。
 */
public class SysRoleVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 关键字 */
    private String roleName;

    /** 状态 */
    private String status;

    /** 创建时间 */
    private Date createTime;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
        sb.append("SysRoleVO{");
        sb.append("roleName=").append(roleName).append(", ");
        sb.append("status=").append(status).append(", ");
        sb.append("createTime=").append(createTime).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
