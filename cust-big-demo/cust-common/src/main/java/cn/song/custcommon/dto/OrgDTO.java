package cn.song.custcommon.dto;

import java.io.Serializable;

/**
 * 组织节点。
 */
public class OrgDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 组织ID */
    private Long orgId;

    /** 组织编码 */
    private String orgCode;

    /** 组织名称 */
    private String orgName;

    /** 父组织ID */
    private Long parentId;

    /** 组织路径 */
    private String orgPath;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getOrgPath() {
        return orgPath;
    }

    public void setOrgPath(String orgPath) {
        this.orgPath = orgPath;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrgDTO{");
        sb.append("orgId=").append(orgId).append(", ");
        sb.append("orgCode=").append(orgCode).append(", ");
        sb.append("orgName=").append(orgName).append(", ");
        sb.append("parentId=").append(parentId).append(", ");
        sb.append("orgPath=").append(orgPath).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
