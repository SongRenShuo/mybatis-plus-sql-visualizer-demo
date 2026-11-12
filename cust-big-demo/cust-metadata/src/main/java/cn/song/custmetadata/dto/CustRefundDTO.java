package cn.song.custmetadata.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户退款DTO 传输对象。
 *
 * <p>字段为查询/导出场景的扁平投影，仅保留 getter/setter 与 toString。
 */
public class CustRefundDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    /** 备注负责人 */
    private String noteOwner;

    /** 偏好编号 */
    private String preferNo;

    /** 偏好名称 */
    private String preferName;

    /** 偏好类型 */
    private String preferType;

    /** 偏好编码 */
    private String preferCode;

    /** 偏好级别 */
    private String preferLevel;

    /** 偏好状态 */
    private String preferStatus;

    /** 偏好金额 */
    private BigDecimal preferAmount;

    /** 偏好数量 */
    private Integer preferCount;

    /** 偏好比率 */
    private BigDecimal preferRate;

    /** 偏好日期 */
    private Date preferDate;

    /** 偏好时间 */
    private Date preferTime;

    /** 偏好标记 */
    private Boolean preferFlag;

    /** 偏好说明 */
    private String preferRemark;

    /** 偏好来源 */
    private String preferSource;

    /** 偏好版本 */
    private Integer preferVersion;

    /** 偏好区域 */
    private String preferRegion;

    /** 偏好渠道 */
    private String preferChannel;

    /** 偏好分组 */
    private String preferGroup;

    /** 偏好标签 */
    private String preferTag;

    /** 偏好负责人 */
    private String preferOwner;

    /** 评分编号 */
    private String scoreNo;

    /** 评分名称 */
    private String scoreName;

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

    public String getNoteOwner() {
        return noteOwner;
    }

    public void setNoteOwner(String noteOwner) {
        this.noteOwner = noteOwner;
    }

    public String getPreferNo() {
        return preferNo;
    }

    public void setPreferNo(String preferNo) {
        this.preferNo = preferNo;
    }

    public String getPreferName() {
        return preferName;
    }

    public void setPreferName(String preferName) {
        this.preferName = preferName;
    }

    public String getPreferType() {
        return preferType;
    }

    public void setPreferType(String preferType) {
        this.preferType = preferType;
    }

    public String getPreferCode() {
        return preferCode;
    }

    public void setPreferCode(String preferCode) {
        this.preferCode = preferCode;
    }

    public String getPreferLevel() {
        return preferLevel;
    }

    public void setPreferLevel(String preferLevel) {
        this.preferLevel = preferLevel;
    }

    public String getPreferStatus() {
        return preferStatus;
    }

    public void setPreferStatus(String preferStatus) {
        this.preferStatus = preferStatus;
    }

    public BigDecimal getPreferAmount() {
        return preferAmount;
    }

    public void setPreferAmount(BigDecimal preferAmount) {
        this.preferAmount = preferAmount;
    }

    public Integer getPreferCount() {
        return preferCount;
    }

    public void setPreferCount(Integer preferCount) {
        this.preferCount = preferCount;
    }

    public BigDecimal getPreferRate() {
        return preferRate;
    }

    public void setPreferRate(BigDecimal preferRate) {
        this.preferRate = preferRate;
    }

    public Date getPreferDate() {
        return preferDate;
    }

    public void setPreferDate(Date preferDate) {
        this.preferDate = preferDate;
    }

    public Date getPreferTime() {
        return preferTime;
    }

    public void setPreferTime(Date preferTime) {
        this.preferTime = preferTime;
    }

    public Boolean getPreferFlag() {
        return preferFlag;
    }

    public void setPreferFlag(Boolean preferFlag) {
        this.preferFlag = preferFlag;
    }

    public String getPreferRemark() {
        return preferRemark;
    }

    public void setPreferRemark(String preferRemark) {
        this.preferRemark = preferRemark;
    }

    public String getPreferSource() {
        return preferSource;
    }

    public void setPreferSource(String preferSource) {
        this.preferSource = preferSource;
    }

    public Integer getPreferVersion() {
        return preferVersion;
    }

    public void setPreferVersion(Integer preferVersion) {
        this.preferVersion = preferVersion;
    }

    public String getPreferRegion() {
        return preferRegion;
    }

    public void setPreferRegion(String preferRegion) {
        this.preferRegion = preferRegion;
    }

    public String getPreferChannel() {
        return preferChannel;
    }

    public void setPreferChannel(String preferChannel) {
        this.preferChannel = preferChannel;
    }

    public String getPreferGroup() {
        return preferGroup;
    }

    public void setPreferGroup(String preferGroup) {
        this.preferGroup = preferGroup;
    }

    public String getPreferTag() {
        return preferTag;
    }

    public void setPreferTag(String preferTag) {
        this.preferTag = preferTag;
    }

    public String getPreferOwner() {
        return preferOwner;
    }

    public void setPreferOwner(String preferOwner) {
        this.preferOwner = preferOwner;
    }

    public String getScoreNo() {
        return scoreNo;
    }

    public void setScoreNo(String scoreNo) {
        this.scoreNo = scoreNo;
    }

    public String getScoreName() {
        return scoreName;
    }

    public void setScoreName(String scoreName) {
        this.scoreName = scoreName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustRefundDTO{");
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
        sb.append("noteDate=").append(noteDate).append(", ");
        sb.append("noteTime=").append(noteTime).append(", ");
        sb.append("noteFlag=").append(noteFlag).append(", ");
        sb.append("noteRemark=").append(noteRemark).append(", ");
        sb.append("noteSource=").append(noteSource).append(", ");
        sb.append("noteVersion=").append(noteVersion).append(", ");
        sb.append("noteRegion=").append(noteRegion).append(", ");
        sb.append("noteChannel=").append(noteChannel).append(", ");
        sb.append("noteGroup=").append(noteGroup).append(", ");
        sb.append("noteTag=").append(noteTag).append(", ");
        sb.append("noteOwner=").append(noteOwner).append(", ");
        sb.append("preferNo=").append(preferNo).append(", ");
        sb.append("preferName=").append(preferName).append(", ");
        sb.append("preferType=").append(preferType).append(", ");
        sb.append("preferCode=").append(preferCode).append(", ");
        sb.append("preferLevel=").append(preferLevel).append(", ");
        sb.append("preferStatus=").append(preferStatus).append(", ");
        sb.append("preferAmount=").append(preferAmount).append(", ");
        sb.append("preferCount=").append(preferCount).append(", ");
        sb.append("preferRate=").append(preferRate).append(", ");
        sb.append("preferDate=").append(preferDate).append(", ");
        sb.append("preferTime=").append(preferTime).append(", ");
        sb.append("preferFlag=").append(preferFlag).append(", ");
        sb.append("preferRemark=").append(preferRemark).append(", ");
        sb.append("preferSource=").append(preferSource).append(", ");
        sb.append("preferVersion=").append(preferVersion).append(", ");
        sb.append("preferRegion=").append(preferRegion).append(", ");
        sb.append("preferChannel=").append(preferChannel).append(", ");
        sb.append("preferGroup=").append(preferGroup).append(", ");
        sb.append("preferTag=").append(preferTag).append(", ");
        sb.append("preferOwner=").append(preferOwner).append(", ");
        sb.append("scoreNo=").append(scoreNo).append(", ");
        sb.append("scoreName=").append(scoreName).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
