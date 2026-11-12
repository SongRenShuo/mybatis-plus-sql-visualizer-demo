package cn.song.custmetadata.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户经理关系SaveBO 查询条件对象。
 *
 * <p>供 Service/Controller 逐层传递筛选条件，字段与查询页面对应。
 */
public class CustManagerRelSaveBO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    /** 备注日期 */
    private Date noteDate;

    /** 备注时间 */
    private Date noteTime;

    /** 备注标记 */
    private Boolean noteFlag;

    /** 备注说明 */
    private String noteRemark;

    /** 备注来源 */
    private String noteSource;

    /** 备注版本 */
    private Integer noteVersion;

    /** 备注区域 */
    private String noteRegion;

    /** 备注渠道 */
    private String noteChannel;

    /** 备注分组 */
    private String noteGroup;

    /** 备注标签 */
    private String noteTag;

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

    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    public Date getNoteTime() {
        return noteTime;
    }

    public void setNoteTime(Date noteTime) {
        this.noteTime = noteTime;
    }

    public Boolean getNoteFlag() {
        return noteFlag;
    }

    public void setNoteFlag(Boolean noteFlag) {
        this.noteFlag = noteFlag;
    }

    public String getNoteRemark() {
        return noteRemark;
    }

    public void setNoteRemark(String noteRemark) {
        this.noteRemark = noteRemark;
    }

    public String getNoteSource() {
        return noteSource;
    }

    public void setNoteSource(String noteSource) {
        this.noteSource = noteSource;
    }

    public Integer getNoteVersion() {
        return noteVersion;
    }

    public void setNoteVersion(Integer noteVersion) {
        this.noteVersion = noteVersion;
    }

    public String getNoteRegion() {
        return noteRegion;
    }

    public void setNoteRegion(String noteRegion) {
        this.noteRegion = noteRegion;
    }

    public String getNoteChannel() {
        return noteChannel;
    }

    public void setNoteChannel(String noteChannel) {
        this.noteChannel = noteChannel;
    }

    public String getNoteGroup() {
        return noteGroup;
    }

    public void setNoteGroup(String noteGroup) {
        this.noteGroup = noteGroup;
    }

    public String getNoteTag() {
        return noteTag;
    }

    public void setNoteTag(String noteTag) {
        this.noteTag = noteTag;
    }

    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustManagerRelSaveBO{");
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
        sb.append('}');
        return sb.toString();
    }
}
