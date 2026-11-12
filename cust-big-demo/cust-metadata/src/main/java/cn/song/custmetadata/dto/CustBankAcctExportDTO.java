package cn.song.custmetadata.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户银行账户ExportDTO 传输对象。
 *
 * <p>字段为查询/导出场景的扁平投影，仅保留 getter/setter 与 toString。
 */
public class CustBankAcctExportDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 行业级别 */
    private String industryLevel;

    /** 行业状态 */
    private String industryStatus;

    /** 行业金额 */
    private BigDecimal industryAmount;

    /** 行业数量 */
    private Integer industryCount;

    /** 行业比率 */
    private BigDecimal industryRate;

    /** 行业日期 */
    private Date industryDate;

    /** 行业时间 */
    private Date industryTime;

    /** 行业标记 */
    private Boolean industryFlag;

    /** 行业说明 */
    private String industryRemark;

    /** 行业来源 */
    private String industrySource;

    /** 行业版本 */
    private Integer industryVersion;

    /** 行业区域 */
    private String industryRegion;

    /** 行业渠道 */
    private String industryChannel;

    /** 行业分组 */
    private String industryGroup;

    /** 行业标签 */
    private String industryTag;

    /** 行业负责人 */
    private String industryOwner;

    /** 渠道编号 */
    private String channelNo;

    /** 渠道名称 */
    private String channelName;

    /** 渠道类型 */
    private String channelType;

    /** 渠道编码 */
    private String channelCode;

    /** 渠道级别 */
    private String channelLevel;

    /** 渠道状态 */
    private String channelStatus;

    /** 渠道金额 */
    private BigDecimal channelAmount;

    /** 渠道数量 */
    private Integer channelCount;

    /** 渠道比率 */
    private BigDecimal channelRate;

    /** 渠道日期 */
    private Date channelDate;

    /** 渠道时间 */
    private Date channelTime;

    /** 渠道标记 */
    private Boolean channelFlag;

    /** 渠道说明 */
    private String channelRemark;

    /** 渠道来源 */
    private String channelSource;

    /** 渠道版本 */
    private Integer channelVersion;

    /** 渠道区域 */
    private String channelRegion;

    /** 渠道渠道 */
    private String channelChannel;

    /** 渠道分组 */
    private String channelGroup;

    /** 渠道标签 */
    private String channelTag;

    /** 渠道负责人 */
    private String channelOwner;

    /** 经理编号 */
    private String managerNo;

    /** 经理名称 */
    private String managerName;

    /** 经理类型 */
    private String managerType;

    /** 经理编码 */
    private String managerCode;

    /** 经理级别 */
    private String managerLevel;

    /** 经理状态 */
    private String managerStatus;

    /** 经理金额 */
    private BigDecimal managerAmount;

    /** 经理数量 */
    private Integer managerCount;

    /** 经理比率 */
    private BigDecimal managerRate;

    /** 经理日期 */
    private Date managerDate;

    /** 经理时间 */
    private Date managerTime;

    /** 经理标记 */
    private Boolean managerFlag;

    /** 经理说明 */
    private String managerRemark;

    /** 经理来源 */
    private String managerSource;

    /** 经理版本 */
    private Integer managerVersion;

    /** 经理区域 */
    private String managerRegion;

    /** 经理渠道 */
    private String managerChannel;

    /** 经理分组 */
    private String managerGroup;

    /** 经理标签 */
    private String managerTag;

    /** 经理负责人 */
    private String managerOwner;

    /** 拜访编号 */
    private String visitNo;

    /** 拜访名称 */
    private String visitName;

    /** 拜访类型 */
    private String visitType;

    /** 拜访编码 */
    private String visitCode;

    public String getIndustryLevel() {
        return industryLevel;
    }

    public void setIndustryLevel(String industryLevel) {
        this.industryLevel = industryLevel;
    }

    public String getIndustryStatus() {
        return industryStatus;
    }

    public void setIndustryStatus(String industryStatus) {
        this.industryStatus = industryStatus;
    }

    public BigDecimal getIndustryAmount() {
        return industryAmount;
    }

    public void setIndustryAmount(BigDecimal industryAmount) {
        this.industryAmount = industryAmount;
    }

    public Integer getIndustryCount() {
        return industryCount;
    }

    public void setIndustryCount(Integer industryCount) {
        this.industryCount = industryCount;
    }

    public BigDecimal getIndustryRate() {
        return industryRate;
    }

    public void setIndustryRate(BigDecimal industryRate) {
        this.industryRate = industryRate;
    }

    public Date getIndustryDate() {
        return industryDate;
    }

    public void setIndustryDate(Date industryDate) {
        this.industryDate = industryDate;
    }

    public Date getIndustryTime() {
        return industryTime;
    }

    public void setIndustryTime(Date industryTime) {
        this.industryTime = industryTime;
    }

    public Boolean getIndustryFlag() {
        return industryFlag;
    }

    public void setIndustryFlag(Boolean industryFlag) {
        this.industryFlag = industryFlag;
    }

    public String getIndustryRemark() {
        return industryRemark;
    }

    public void setIndustryRemark(String industryRemark) {
        this.industryRemark = industryRemark;
    }

    public String getIndustrySource() {
        return industrySource;
    }

    public void setIndustrySource(String industrySource) {
        this.industrySource = industrySource;
    }

    public Integer getIndustryVersion() {
        return industryVersion;
    }

    public void setIndustryVersion(Integer industryVersion) {
        this.industryVersion = industryVersion;
    }

    public String getIndustryRegion() {
        return industryRegion;
    }

    public void setIndustryRegion(String industryRegion) {
        this.industryRegion = industryRegion;
    }

    public String getIndustryChannel() {
        return industryChannel;
    }

    public void setIndustryChannel(String industryChannel) {
        this.industryChannel = industryChannel;
    }

    public String getIndustryGroup() {
        return industryGroup;
    }

    public void setIndustryGroup(String industryGroup) {
        this.industryGroup = industryGroup;
    }

    public String getIndustryTag() {
        return industryTag;
    }

    public void setIndustryTag(String industryTag) {
        this.industryTag = industryTag;
    }

    public String getIndustryOwner() {
        return industryOwner;
    }

    public void setIndustryOwner(String industryOwner) {
        this.industryOwner = industryOwner;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelLevel() {
        return channelLevel;
    }

    public void setChannelLevel(String channelLevel) {
        this.channelLevel = channelLevel;
    }

    public String getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(String channelStatus) {
        this.channelStatus = channelStatus;
    }

    public BigDecimal getChannelAmount() {
        return channelAmount;
    }

    public void setChannelAmount(BigDecimal channelAmount) {
        this.channelAmount = channelAmount;
    }

    public Integer getChannelCount() {
        return channelCount;
    }

    public void setChannelCount(Integer channelCount) {
        this.channelCount = channelCount;
    }

    public BigDecimal getChannelRate() {
        return channelRate;
    }

    public void setChannelRate(BigDecimal channelRate) {
        this.channelRate = channelRate;
    }

    public Date getChannelDate() {
        return channelDate;
    }

    public void setChannelDate(Date channelDate) {
        this.channelDate = channelDate;
    }

    public Date getChannelTime() {
        return channelTime;
    }

    public void setChannelTime(Date channelTime) {
        this.channelTime = channelTime;
    }

    public Boolean getChannelFlag() {
        return channelFlag;
    }

    public void setChannelFlag(Boolean channelFlag) {
        this.channelFlag = channelFlag;
    }

    public String getChannelRemark() {
        return channelRemark;
    }

    public void setChannelRemark(String channelRemark) {
        this.channelRemark = channelRemark;
    }

    public String getChannelSource() {
        return channelSource;
    }

    public void setChannelSource(String channelSource) {
        this.channelSource = channelSource;
    }

    public Integer getChannelVersion() {
        return channelVersion;
    }

    public void setChannelVersion(Integer channelVersion) {
        this.channelVersion = channelVersion;
    }

    public String getChannelRegion() {
        return channelRegion;
    }

    public void setChannelRegion(String channelRegion) {
        this.channelRegion = channelRegion;
    }

    public String getChannelChannel() {
        return channelChannel;
    }

    public void setChannelChannel(String channelChannel) {
        this.channelChannel = channelChannel;
    }

    public String getChannelGroup() {
        return channelGroup;
    }

    public void setChannelGroup(String channelGroup) {
        this.channelGroup = channelGroup;
    }

    public String getChannelTag() {
        return channelTag;
    }

    public void setChannelTag(String channelTag) {
        this.channelTag = channelTag;
    }

    public String getChannelOwner() {
        return channelOwner;
    }

    public void setChannelOwner(String channelOwner) {
        this.channelOwner = channelOwner;
    }

    public String getManagerNo() {
        return managerNo;
    }

    public void setManagerNo(String managerNo) {
        this.managerNo = managerNo;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerType() {
        return managerType;
    }

    public void setManagerType(String managerType) {
        this.managerType = managerType;
    }

    public String getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(String managerCode) {
        this.managerCode = managerCode;
    }

    public String getManagerLevel() {
        return managerLevel;
    }

    public void setManagerLevel(String managerLevel) {
        this.managerLevel = managerLevel;
    }

    public String getManagerStatus() {
        return managerStatus;
    }

    public void setManagerStatus(String managerStatus) {
        this.managerStatus = managerStatus;
    }

    public BigDecimal getManagerAmount() {
        return managerAmount;
    }

    public void setManagerAmount(BigDecimal managerAmount) {
        this.managerAmount = managerAmount;
    }

    public Integer getManagerCount() {
        return managerCount;
    }

    public void setManagerCount(Integer managerCount) {
        this.managerCount = managerCount;
    }

    public BigDecimal getManagerRate() {
        return managerRate;
    }

    public void setManagerRate(BigDecimal managerRate) {
        this.managerRate = managerRate;
    }

    public Date getManagerDate() {
        return managerDate;
    }

    public void setManagerDate(Date managerDate) {
        this.managerDate = managerDate;
    }

    public Date getManagerTime() {
        return managerTime;
    }

    public void setManagerTime(Date managerTime) {
        this.managerTime = managerTime;
    }

    public Boolean getManagerFlag() {
        return managerFlag;
    }

    public void setManagerFlag(Boolean managerFlag) {
        this.managerFlag = managerFlag;
    }

    public String getManagerRemark() {
        return managerRemark;
    }

    public void setManagerRemark(String managerRemark) {
        this.managerRemark = managerRemark;
    }

    public String getManagerSource() {
        return managerSource;
    }

    public void setManagerSource(String managerSource) {
        this.managerSource = managerSource;
    }

    public Integer getManagerVersion() {
        return managerVersion;
    }

    public void setManagerVersion(Integer managerVersion) {
        this.managerVersion = managerVersion;
    }

    public String getManagerRegion() {
        return managerRegion;
    }

    public void setManagerRegion(String managerRegion) {
        this.managerRegion = managerRegion;
    }

    public String getManagerChannel() {
        return managerChannel;
    }

    public void setManagerChannel(String managerChannel) {
        this.managerChannel = managerChannel;
    }

    public String getManagerGroup() {
        return managerGroup;
    }

    public void setManagerGroup(String managerGroup) {
        this.managerGroup = managerGroup;
    }

    public String getManagerTag() {
        return managerTag;
    }

    public void setManagerTag(String managerTag) {
        this.managerTag = managerTag;
    }

    public String getManagerOwner() {
        return managerOwner;
    }

    public void setManagerOwner(String managerOwner) {
        this.managerOwner = managerOwner;
    }

    public String getVisitNo() {
        return visitNo;
    }

    public void setVisitNo(String visitNo) {
        this.visitNo = visitNo;
    }

    public String getVisitName() {
        return visitName;
    }

    public void setVisitName(String visitName) {
        this.visitName = visitName;
    }

    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    public String getVisitCode() {
        return visitCode;
    }

    public void setVisitCode(String visitCode) {
        this.visitCode = visitCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustBankAcctExportDTO{");
        sb.append("industryLevel=").append(industryLevel).append(", ");
        sb.append("industryStatus=").append(industryStatus).append(", ");
        sb.append("industryAmount=").append(industryAmount).append(", ");
        sb.append("industryCount=").append(industryCount).append(", ");
        sb.append("industryRate=").append(industryRate).append(", ");
        sb.append("industryDate=").append(industryDate).append(", ");
        sb.append("industryTime=").append(industryTime).append(", ");
        sb.append("industryFlag=").append(industryFlag).append(", ");
        sb.append("industryRemark=").append(industryRemark).append(", ");
        sb.append("industrySource=").append(industrySource).append(", ");
        sb.append("industryVersion=").append(industryVersion).append(", ");
        sb.append("industryRegion=").append(industryRegion).append(", ");
        sb.append("industryChannel=").append(industryChannel).append(", ");
        sb.append("industryGroup=").append(industryGroup).append(", ");
        sb.append("industryTag=").append(industryTag).append(", ");
        sb.append("industryOwner=").append(industryOwner).append(", ");
        sb.append("channelNo=").append(channelNo).append(", ");
        sb.append("channelName=").append(channelName).append(", ");
        sb.append("channelType=").append(channelType).append(", ");
        sb.append("channelCode=").append(channelCode).append(", ");
        sb.append("channelLevel=").append(channelLevel).append(", ");
        sb.append("channelStatus=").append(channelStatus).append(", ");
        sb.append("channelAmount=").append(channelAmount).append(", ");
        sb.append("channelCount=").append(channelCount).append(", ");
        sb.append("channelRate=").append(channelRate).append(", ");
        sb.append("channelDate=").append(channelDate).append(", ");
        sb.append("channelTime=").append(channelTime).append(", ");
        sb.append("channelFlag=").append(channelFlag).append(", ");
        sb.append("channelRemark=").append(channelRemark).append(", ");
        sb.append("channelSource=").append(channelSource).append(", ");
        sb.append("channelVersion=").append(channelVersion).append(", ");
        sb.append("channelRegion=").append(channelRegion).append(", ");
        sb.append("channelChannel=").append(channelChannel).append(", ");
        sb.append("channelGroup=").append(channelGroup).append(", ");
        sb.append("channelTag=").append(channelTag).append(", ");
        sb.append("channelOwner=").append(channelOwner).append(", ");
        sb.append("managerNo=").append(managerNo).append(", ");
        sb.append("managerName=").append(managerName).append(", ");
        sb.append("managerType=").append(managerType).append(", ");
        sb.append("managerCode=").append(managerCode).append(", ");
        sb.append("managerLevel=").append(managerLevel).append(", ");
        sb.append("managerStatus=").append(managerStatus).append(", ");
        sb.append("managerAmount=").append(managerAmount).append(", ");
        sb.append("managerCount=").append(managerCount).append(", ");
        sb.append("managerRate=").append(managerRate).append(", ");
        sb.append("managerDate=").append(managerDate).append(", ");
        sb.append("managerTime=").append(managerTime).append(", ");
        sb.append("managerFlag=").append(managerFlag).append(", ");
        sb.append("managerRemark=").append(managerRemark).append(", ");
        sb.append("managerSource=").append(managerSource).append(", ");
        sb.append("managerVersion=").append(managerVersion).append(", ");
        sb.append("managerRegion=").append(managerRegion).append(", ");
        sb.append("managerChannel=").append(managerChannel).append(", ");
        sb.append("managerGroup=").append(managerGroup).append(", ");
        sb.append("managerTag=").append(managerTag).append(", ");
        sb.append("managerOwner=").append(managerOwner).append(", ");
        sb.append("visitNo=").append(visitNo).append(", ");
        sb.append("visitName=").append(visitName).append(", ");
        sb.append("visitType=").append(visitType).append(", ");
        sb.append("visitCode=").append(visitCode).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
