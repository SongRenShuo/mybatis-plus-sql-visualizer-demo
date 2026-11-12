package cn.song.custcommon.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 操作人信息。
 */
public class OperatorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 操作人ID */
    private Long operatorId;

    /** 操作人姓名 */
    private String operatorName;

    /** 租户ID */
    private Long tenantId;

    /** 角色集合 */
    private java.util.List<String> roles;

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public java.util.List<String> getRoles() {
        return roles;
    }

    public void setRoles(java.util.List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OperatorDTO{");
        sb.append("operatorId=").append(operatorId).append(", ");
        sb.append("operatorName=").append(operatorName).append(", ");
        sb.append("tenantId=").append(tenantId).append(", ");
        sb.append("roles=").append(roles).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
