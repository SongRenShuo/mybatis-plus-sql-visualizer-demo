package cn.song.selfdevdemo.entity;

import java.math.BigDecimal;

/**
 * 项目计划（主表 biz_project_plan 的映射）。
 *
 * <p>列名下划线转驼峰由 Spring {@code BeanPropertyRowMapper} 完成（其 {@code lowerCaseName}
 * 统一去下划线后小写比对），因此本类字段与列名一一对应即可。
 *
 * @author SongRenShuo
 */
public class ProjectPlan {

    private Long id;
    private String planId;
    private String schemaCode;
    private String projectName;
    private String owner;
    private Integer status;
    private BigDecimal amount;
    private Long createTime;
    private Long updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getSchemaCode() {
        return schemaCode;
    }

    public void setSchemaCode(String schemaCode) {
        this.schemaCode = schemaCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
