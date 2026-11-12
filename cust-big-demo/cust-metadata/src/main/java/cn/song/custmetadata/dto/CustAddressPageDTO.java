package cn.song.custmetadata.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户地址PageDTO 传输对象。
 *
 * <p>字段为查询/导出场景的扁平投影，仅保留 getter/setter 与 toString。
 */
public class CustAddressPageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    /** 拜访级别 */
    private String visitLevel;

    /** 拜访状态 */
    private String visitStatus;

    /** 拜访金额 */
    private BigDecimal visitAmount;

    /** 拜访数量 */
    private Integer visitCount;

    /** 拜访比率 */
    private BigDecimal visitRate;

    /** 拜访日期 */
    private Date visitDate;

    /** 拜访时间 */
    private Date visitTime;

    /** 拜访标记 */
    private Boolean visitFlag;

    /** 拜访说明 */
    private String visitRemark;

    /** 拜访来源 */
    private String visitSource;

    /** 拜访版本 */
    private Integer visitVersion;

    /** 拜访区域 */
    private String visitRegion;

    /** 拜访渠道 */
    private String visitChannel;

    /** 拜访分组 */
    private String visitGroup;

    /** 拜访标签 */
    private String visitTag;

    /** 拜访负责人 */
    private String visitOwner;

    /** 合同编号 */
    private String contractNo;

    /** 合同名称 */
    private String contractName;

    /** 合同类型 */
    private String contractType;

    /** 合同编码 */
    private String contractCode;

    /** 合同级别 */
    private String contractLevel;

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

    public String getVisitLevel() {
        return visitLevel;
    }

    public void setVisitLevel(String visitLevel) {
        this.visitLevel = visitLevel;
    }

    public String getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(String visitStatus) {
        this.visitStatus = visitStatus;
    }

    public BigDecimal getVisitAmount() {
        return visitAmount;
    }

    public void setVisitAmount(BigDecimal visitAmount) {
        this.visitAmount = visitAmount;
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    public BigDecimal getVisitRate() {
        return visitRate;
    }

    public void setVisitRate(BigDecimal visitRate) {
        this.visitRate = visitRate;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public Boolean getVisitFlag() {
        return visitFlag;
    }

    public void setVisitFlag(Boolean visitFlag) {
        this.visitFlag = visitFlag;
    }

    public String getVisitRemark() {
        return visitRemark;
    }

    public void setVisitRemark(String visitRemark) {
        this.visitRemark = visitRemark;
    }

    public String getVisitSource() {
        return visitSource;
    }

    public void setVisitSource(String visitSource) {
        this.visitSource = visitSource;
    }

    public Integer getVisitVersion() {
        return visitVersion;
    }

    public void setVisitVersion(Integer visitVersion) {
        this.visitVersion = visitVersion;
    }

    public String getVisitRegion() {
        return visitRegion;
    }

    public void setVisitRegion(String visitRegion) {
        this.visitRegion = visitRegion;
    }

    public String getVisitChannel() {
        return visitChannel;
    }

    public void setVisitChannel(String visitChannel) {
        this.visitChannel = visitChannel;
    }

    public String getVisitGroup() {
        return visitGroup;
    }

    public void setVisitGroup(String visitGroup) {
        this.visitGroup = visitGroup;
    }

    public String getVisitTag() {
        return visitTag;
    }

    public void setVisitTag(String visitTag) {
        this.visitTag = visitTag;
    }

    public String getVisitOwner() {
        return visitOwner;
    }

    public void setVisitOwner(String visitOwner) {
        this.visitOwner = visitOwner;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractLevel() {
        return contractLevel;
    }

    public void setContractLevel(String contractLevel) {
        this.contractLevel = contractLevel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustAddressPageDTO{");
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
        sb.append("visitLevel=").append(visitLevel).append(", ");
        sb.append("visitStatus=").append(visitStatus).append(", ");
        sb.append("visitAmount=").append(visitAmount).append(", ");
        sb.append("visitCount=").append(visitCount).append(", ");
        sb.append("visitRate=").append(visitRate).append(", ");
        sb.append("visitDate=").append(visitDate).append(", ");
        sb.append("visitTime=").append(visitTime).append(", ");
        sb.append("visitFlag=").append(visitFlag).append(", ");
        sb.append("visitRemark=").append(visitRemark).append(", ");
        sb.append("visitSource=").append(visitSource).append(", ");
        sb.append("visitVersion=").append(visitVersion).append(", ");
        sb.append("visitRegion=").append(visitRegion).append(", ");
        sb.append("visitChannel=").append(visitChannel).append(", ");
        sb.append("visitGroup=").append(visitGroup).append(", ");
        sb.append("visitTag=").append(visitTag).append(", ");
        sb.append("visitOwner=").append(visitOwner).append(", ");
        sb.append("contractNo=").append(contractNo).append(", ");
        sb.append("contractName=").append(contractName).append(", ");
        sb.append("contractType=").append(contractType).append(", ");
        sb.append("contractCode=").append(contractCode).append(", ");
        sb.append("contractLevel=").append(contractLevel).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
