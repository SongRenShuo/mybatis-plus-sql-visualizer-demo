package cn.song.selfdevdemo.entity;

import java.math.BigDecimal;

/**
 * 项目计划 + 成员（JOIN schema {@code SCHEMA_CODE_PROJECT_PLAN_MEMBER} 的行映射）。
 *
 * <p>比 {@link ProjectPlan} 多两列：{@code member_name} / {@code member_role}。
 * JOIN 表达式的表别名由框架元数据（{@code MetaRegistry}）登记，业务侧写条件时仍只用逻辑字段名。
 *
 * @author SongRenShuo
 */
public class ProjectPlanMemberView {

    private Long id;
    private String planId;
    private String projectName;
    private String owner;
    private Integer status;
    private BigDecimal amount;
    private String memberName;
    private String memberRole;

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

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }
}
