package cn.song.custmetadata.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户资产SummaryDTO 传输对象。
 *
 * <p>字段为查询/导出场景的扁平投影，仅保留 getter/setter 与 toString。
 */
public class CustAssetSummaryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 结算日期 */
    private Date settleDate;

    /** 结算时间 */
    private Date settleTime;

    /** 结算标记 */
    private Boolean settleFlag;

    /** 结算说明 */
    private String settleRemark;

    /** 结算来源 */
    private String settleSource;

    /** 结算版本 */
    private Integer settleVersion;

    /** 结算区域 */
    private String settleRegion;

    /** 结算渠道 */
    private String settleChannel;

    /** 结算分组 */
    private String settleGroup;

    /** 结算标签 */
    private String settleTag;

    /** 结算负责人 */
    private String settleOwner;

    /** 审计编号 */
    private String auditNo;

    /** 审计名称 */
    private String auditName;

    /** 审计类型 */
    private String auditType;

    /** 审计编码 */
    private String auditCode;

    /** 审计级别 */
    private String auditLevel;

    /** 审计状态 */
    private String auditStatus;

    /** 审计金额 */
    private BigDecimal auditAmount;

    /** 审计数量 */
    private Integer auditCount;

    /** 审计比率 */
    private BigDecimal auditRate;

    /** 审计日期 */
    private Date auditDate;

    /** 审计时间 */
    private Date auditTime;

    /** 审计标记 */
    private Boolean auditFlag;

    /** 审计说明 */
    private String auditRemark;

    /** 审计来源 */
    private String auditSource;

    /** 审计版本 */
    private Integer auditVersion;

    /** 审计区域 */
    private String auditRegion;

    /** 审计渠道 */
    private String auditChannel;

    /** 审计分组 */
    private String auditGroup;

    /** 审计标签 */
    private String auditTag;

    /** 审计负责人 */
    private String auditOwner;

    /** 附件编号 */
    private String attachNo;

    /** 附件名称 */
    private String attachName;

    /** 附件类型 */
    private String attachType;

    /** 附件编码 */
    private String attachCode;

    /** 附件级别 */
    private String attachLevel;

    /** 附件状态 */
    private String attachStatus;

    /** 附件金额 */
    private BigDecimal attachAmount;

    /** 附件数量 */
    private Integer attachCount;

    /** 附件比率 */
    private BigDecimal attachRate;

    /** 附件日期 */
    private Date attachDate;

    /** 附件时间 */
    private Date attachTime;

    /** 附件标记 */
    private Boolean attachFlag;

    /** 附件说明 */
    private String attachRemark;

    /** 附件来源 */
    private String attachSource;

    /** 附件版本 */
    private Integer attachVersion;

    /** 附件区域 */
    private String attachRegion;

    /** 附件渠道 */
    private String attachChannel;

    /** 附件分组 */
    private String attachGroup;

    /** 附件标签 */
    private String attachTag;

    /** 附件负责人 */
    private String attachOwner;

    /** 备注编号 */
    private String noteNo;

    /** 备注名称 */
    private String noteName;

    /** 备注类型 */
    private String noteType;

    /** 备注编码 */
    private String noteCode;

    /** 备注级别 */
    private String noteLevel;

    /** 备注状态 */
    private String noteStatus;

    /** 备注金额 */
    private BigDecimal noteAmount;

    /** 备注数量 */
    private Integer noteCount;

    /** 备注比率 */
    private BigDecimal noteRate;

    public Date getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(Date settleDate) {
        this.settleDate = settleDate;
    }

    public Date getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }

    public Boolean getSettleFlag() {
        return settleFlag;
    }

    public void setSettleFlag(Boolean settleFlag) {
        this.settleFlag = settleFlag;
    }

    public String getSettleRemark() {
        return settleRemark;
    }

    public void setSettleRemark(String settleRemark) {
        this.settleRemark = settleRemark;
    }

    public String getSettleSource() {
        return settleSource;
    }

    public void setSettleSource(String settleSource) {
        this.settleSource = settleSource;
    }

    public Integer getSettleVersion() {
        return settleVersion;
    }

    public void setSettleVersion(Integer settleVersion) {
        this.settleVersion = settleVersion;
    }

    public String getSettleRegion() {
        return settleRegion;
    }

    public void setSettleRegion(String settleRegion) {
        this.settleRegion = settleRegion;
    }

    public String getSettleChannel() {
        return settleChannel;
    }

    public void setSettleChannel(String settleChannel) {
        this.settleChannel = settleChannel;
    }

    public String getSettleGroup() {
        return settleGroup;
    }

    public void setSettleGroup(String settleGroup) {
        this.settleGroup = settleGroup;
    }

    public String getSettleTag() {
        return settleTag;
    }

    public void setSettleTag(String settleTag) {
        this.settleTag = settleTag;
    }

    public String getSettleOwner() {
        return settleOwner;
    }

    public void setSettleOwner(String settleOwner) {
        this.settleOwner = settleOwner;
    }

    public String getAuditNo() {
        return auditNo;
    }

    public void setAuditNo(String auditNo) {
        this.auditNo = auditNo;
    }

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public String getAuditCode() {
        return auditCode;
    }

    public void setAuditCode(String auditCode) {
        this.auditCode = auditCode;
    }

    public String getAuditLevel() {
        return auditLevel;
    }

    public void setAuditLevel(String auditLevel) {
        this.auditLevel = auditLevel;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public BigDecimal getAuditAmount() {
        return auditAmount;
    }

    public void setAuditAmount(BigDecimal auditAmount) {
        this.auditAmount = auditAmount;
    }

    public Integer getAuditCount() {
        return auditCount;
    }

    public void setAuditCount(Integer auditCount) {
        this.auditCount = auditCount;
    }

    public BigDecimal getAuditRate() {
        return auditRate;
    }

    public void setAuditRate(BigDecimal auditRate) {
        this.auditRate = auditRate;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Boolean getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Boolean auditFlag) {
        this.auditFlag = auditFlag;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    public String getAuditSource() {
        return auditSource;
    }

    public void setAuditSource(String auditSource) {
        this.auditSource = auditSource;
    }

    public Integer getAuditVersion() {
        return auditVersion;
    }

    public void setAuditVersion(Integer auditVersion) {
        this.auditVersion = auditVersion;
    }

    public String getAuditRegion() {
        return auditRegion;
    }

    public void setAuditRegion(String auditRegion) {
        this.auditRegion = auditRegion;
    }

    public String getAuditChannel() {
        return auditChannel;
    }

    public void setAuditChannel(String auditChannel) {
        this.auditChannel = auditChannel;
    }

    public String getAuditGroup() {
        return auditGroup;
    }

    public void setAuditGroup(String auditGroup) {
        this.auditGroup = auditGroup;
    }

    public String getAuditTag() {
        return auditTag;
    }

    public void setAuditTag(String auditTag) {
        this.auditTag = auditTag;
    }

    public String getAuditOwner() {
        return auditOwner;
    }

    public void setAuditOwner(String auditOwner) {
        this.auditOwner = auditOwner;
    }

    public String getAttachNo() {
        return attachNo;
    }

    public void setAttachNo(String attachNo) {
        this.attachNo = attachNo;
    }

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    public String getAttachType() {
        return attachType;
    }

    public void setAttachType(String attachType) {
        this.attachType = attachType;
    }

    public String getAttachCode() {
        return attachCode;
    }

    public void setAttachCode(String attachCode) {
        this.attachCode = attachCode;
    }

    public String getAttachLevel() {
        return attachLevel;
    }

    public void setAttachLevel(String attachLevel) {
        this.attachLevel = attachLevel;
    }

    public String getAttachStatus() {
        return attachStatus;
    }

    public void setAttachStatus(String attachStatus) {
        this.attachStatus = attachStatus;
    }

    public BigDecimal getAttachAmount() {
        return attachAmount;
    }

    public void setAttachAmount(BigDecimal attachAmount) {
        this.attachAmount = attachAmount;
    }

    public Integer getAttachCount() {
        return attachCount;
    }

    public void setAttachCount(Integer attachCount) {
        this.attachCount = attachCount;
    }

    public BigDecimal getAttachRate() {
        return attachRate;
    }

    public void setAttachRate(BigDecimal attachRate) {
        this.attachRate = attachRate;
    }

    public Date getAttachDate() {
        return attachDate;
    }

    public void setAttachDate(Date attachDate) {
        this.attachDate = attachDate;
    }

    public Date getAttachTime() {
        return attachTime;
    }

    public void setAttachTime(Date attachTime) {
        this.attachTime = attachTime;
    }

    public Boolean getAttachFlag() {
        return attachFlag;
    }

    public void setAttachFlag(Boolean attachFlag) {
        this.attachFlag = attachFlag;
    }

    public String getAttachRemark() {
        return attachRemark;
    }

    public void setAttachRemark(String attachRemark) {
        this.attachRemark = attachRemark;
    }

    public String getAttachSource() {
        return attachSource;
    }

    public void setAttachSource(String attachSource) {
        this.attachSource = attachSource;
    }

    public Integer getAttachVersion() {
        return attachVersion;
    }

    public void setAttachVersion(Integer attachVersion) {
        this.attachVersion = attachVersion;
    }

    public String getAttachRegion() {
        return attachRegion;
    }

    public void setAttachRegion(String attachRegion) {
        this.attachRegion = attachRegion;
    }

    public String getAttachChannel() {
        return attachChannel;
    }

    public void setAttachChannel(String attachChannel) {
        this.attachChannel = attachChannel;
    }

    public String getAttachGroup() {
        return attachGroup;
    }

    public void setAttachGroup(String attachGroup) {
        this.attachGroup = attachGroup;
    }

    public String getAttachTag() {
        return attachTag;
    }

    public void setAttachTag(String attachTag) {
        this.attachTag = attachTag;
    }

    public String getAttachOwner() {
        return attachOwner;
    }

    public void setAttachOwner(String attachOwner) {
        this.attachOwner = attachOwner;
    }

    public String getNoteNo() {
        return noteNo;
    }

    public void setNoteNo(String noteNo) {
        this.noteNo = noteNo;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteType() {
        return noteType;
    }

    public void setNoteType(String noteType) {
        this.noteType = noteType;
    }

    public String getNoteCode() {
        return noteCode;
    }

    public void setNoteCode(String noteCode) {
        this.noteCode = noteCode;
    }

    public String getNoteLevel() {
        return noteLevel;
    }

    public void setNoteLevel(String noteLevel) {
        this.noteLevel = noteLevel;
    }

    public String getNoteStatus() {
        return noteStatus;
    }

    public void setNoteStatus(String noteStatus) {
        this.noteStatus = noteStatus;
    }

    public BigDecimal getNoteAmount() {
        return noteAmount;
    }

    public void setNoteAmount(BigDecimal noteAmount) {
        this.noteAmount = noteAmount;
    }

    public Integer getNoteCount() {
        return noteCount;
    }

    public void setNoteCount(Integer noteCount) {
        this.noteCount = noteCount;
    }

    public BigDecimal getNoteRate() {
        return noteRate;
    }

    public void setNoteRate(BigDecimal noteRate) {
        this.noteRate = noteRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustAssetSummaryDTO{");
        sb.append("settleDate=").append(settleDate).append(", ");
        sb.append("settleTime=").append(settleTime).append(", ");
        sb.append("settleFlag=").append(settleFlag).append(", ");
        sb.append("settleRemark=").append(settleRemark).append(", ");
        sb.append("settleSource=").append(settleSource).append(", ");
        sb.append("settleVersion=").append(settleVersion).append(", ");
        sb.append("settleRegion=").append(settleRegion).append(", ");
        sb.append("settleChannel=").append(settleChannel).append(", ");
        sb.append("settleGroup=").append(settleGroup).append(", ");
        sb.append("settleTag=").append(settleTag).append(", ");
        sb.append("settleOwner=").append(settleOwner).append(", ");
        sb.append("auditNo=").append(auditNo).append(", ");
        sb.append("auditName=").append(auditName).append(", ");
        sb.append("auditType=").append(auditType).append(", ");
        sb.append("auditCode=").append(auditCode).append(", ");
        sb.append("auditLevel=").append(auditLevel).append(", ");
        sb.append("auditStatus=").append(auditStatus).append(", ");
        sb.append("auditAmount=").append(auditAmount).append(", ");
        sb.append("auditCount=").append(auditCount).append(", ");
        sb.append("auditRate=").append(auditRate).append(", ");
        sb.append("auditDate=").append(auditDate).append(", ");
        sb.append("auditTime=").append(auditTime).append(", ");
        sb.append("auditFlag=").append(auditFlag).append(", ");
        sb.append("auditRemark=").append(auditRemark).append(", ");
        sb.append("auditSource=").append(auditSource).append(", ");
        sb.append("auditVersion=").append(auditVersion).append(", ");
        sb.append("auditRegion=").append(auditRegion).append(", ");
        sb.append("auditChannel=").append(auditChannel).append(", ");
        sb.append("auditGroup=").append(auditGroup).append(", ");
        sb.append("auditTag=").append(auditTag).append(", ");
        sb.append("auditOwner=").append(auditOwner).append(", ");
        sb.append("attachNo=").append(attachNo).append(", ");
        sb.append("attachName=").append(attachName).append(", ");
        sb.append("attachType=").append(attachType).append(", ");
        sb.append("attachCode=").append(attachCode).append(", ");
        sb.append("attachLevel=").append(attachLevel).append(", ");
        sb.append("attachStatus=").append(attachStatus).append(", ");
        sb.append("attachAmount=").append(attachAmount).append(", ");
        sb.append("attachCount=").append(attachCount).append(", ");
        sb.append("attachRate=").append(attachRate).append(", ");
        sb.append("attachDate=").append(attachDate).append(", ");
        sb.append("attachTime=").append(attachTime).append(", ");
        sb.append("attachFlag=").append(attachFlag).append(", ");
        sb.append("attachRemark=").append(attachRemark).append(", ");
        sb.append("attachSource=").append(attachSource).append(", ");
        sb.append("attachVersion=").append(attachVersion).append(", ");
        sb.append("attachRegion=").append(attachRegion).append(", ");
        sb.append("attachChannel=").append(attachChannel).append(", ");
        sb.append("attachGroup=").append(attachGroup).append(", ");
        sb.append("attachTag=").append(attachTag).append(", ");
        sb.append("attachOwner=").append(attachOwner).append(", ");
        sb.append("noteNo=").append(noteNo).append(", ");
        sb.append("noteName=").append(noteName).append(", ");
        sb.append("noteType=").append(noteType).append(", ");
        sb.append("noteCode=").append(noteCode).append(", ");
        sb.append("noteLevel=").append(noteLevel).append(", ");
        sb.append("noteStatus=").append(noteStatus).append(", ");
        sb.append("noteAmount=").append(noteAmount).append(", ");
        sb.append("noteCount=").append(noteCount).append(", ");
        sb.append("noteRate=").append(noteRate).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
