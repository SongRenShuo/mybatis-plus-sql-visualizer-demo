package cn.song.custmetadata.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户规模PageDTO 传输对象。
 *
 * <p>字段为查询/导出场景的扁平投影，仅保留 getter/setter 与 toString。
 */
public class CustScalePageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    /** 评分类型 */
    private String scoreType;

    /** 评分编码 */
    private String scoreCode;

    /** 评分级别 */
    private String scoreLevel;

    /** 评分状态 */
    private String scoreStatus;

    /** 评分金额 */
    private BigDecimal scoreAmount;

    /** 评分数量 */
    private Integer scoreCount;

    /** 评分比率 */
    private BigDecimal scoreRate;

    /** 评分日期 */
    private Date scoreDate;

    /** 评分时间 */
    private Date scoreTime;

    /** 评分标记 */
    private Boolean scoreFlag;

    /** 评分说明 */
    private String scoreRemark;

    /** 评分来源 */
    private String scoreSource;

    /** 评分版本 */
    private Integer scoreVersion;

    /** 评分区域 */
    private String scoreRegion;

    /** 评分渠道 */
    private String scoreChannel;

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

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }

    public String getScoreCode() {
        return scoreCode;
    }

    public void setScoreCode(String scoreCode) {
        this.scoreCode = scoreCode;
    }

    public String getScoreLevel() {
        return scoreLevel;
    }

    public void setScoreLevel(String scoreLevel) {
        this.scoreLevel = scoreLevel;
    }

    public String getScoreStatus() {
        return scoreStatus;
    }

    public void setScoreStatus(String scoreStatus) {
        this.scoreStatus = scoreStatus;
    }

    public BigDecimal getScoreAmount() {
        return scoreAmount;
    }

    public void setScoreAmount(BigDecimal scoreAmount) {
        this.scoreAmount = scoreAmount;
    }

    public Integer getScoreCount() {
        return scoreCount;
    }

    public void setScoreCount(Integer scoreCount) {
        this.scoreCount = scoreCount;
    }

    public BigDecimal getScoreRate() {
        return scoreRate;
    }

    public void setScoreRate(BigDecimal scoreRate) {
        this.scoreRate = scoreRate;
    }

    public Date getScoreDate() {
        return scoreDate;
    }

    public void setScoreDate(Date scoreDate) {
        this.scoreDate = scoreDate;
    }

    public Date getScoreTime() {
        return scoreTime;
    }

    public void setScoreTime(Date scoreTime) {
        this.scoreTime = scoreTime;
    }

    public Boolean getScoreFlag() {
        return scoreFlag;
    }

    public void setScoreFlag(Boolean scoreFlag) {
        this.scoreFlag = scoreFlag;
    }

    public String getScoreRemark() {
        return scoreRemark;
    }

    public void setScoreRemark(String scoreRemark) {
        this.scoreRemark = scoreRemark;
    }

    public String getScoreSource() {
        return scoreSource;
    }

    public void setScoreSource(String scoreSource) {
        this.scoreSource = scoreSource;
    }

    public Integer getScoreVersion() {
        return scoreVersion;
    }

    public void setScoreVersion(Integer scoreVersion) {
        this.scoreVersion = scoreVersion;
    }

    public String getScoreRegion() {
        return scoreRegion;
    }

    public void setScoreRegion(String scoreRegion) {
        this.scoreRegion = scoreRegion;
    }

    public String getScoreChannel() {
        return scoreChannel;
    }

    public void setScoreChannel(String scoreChannel) {
        this.scoreChannel = scoreChannel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustScalePageDTO{");
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
        sb.append("scoreType=").append(scoreType).append(", ");
        sb.append("scoreCode=").append(scoreCode).append(", ");
        sb.append("scoreLevel=").append(scoreLevel).append(", ");
        sb.append("scoreStatus=").append(scoreStatus).append(", ");
        sb.append("scoreAmount=").append(scoreAmount).append(", ");
        sb.append("scoreCount=").append(scoreCount).append(", ");
        sb.append("scoreRate=").append(scoreRate).append(", ");
        sb.append("scoreDate=").append(scoreDate).append(", ");
        sb.append("scoreTime=").append(scoreTime).append(", ");
        sb.append("scoreFlag=").append(scoreFlag).append(", ");
        sb.append("scoreRemark=").append(scoreRemark).append(", ");
        sb.append("scoreSource=").append(scoreSource).append(", ");
        sb.append("scoreVersion=").append(scoreVersion).append(", ");
        sb.append("scoreRegion=").append(scoreRegion).append(", ");
        sb.append("scoreChannel=").append(scoreChannel).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
