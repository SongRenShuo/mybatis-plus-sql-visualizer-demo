package cn.song.custmetadata.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户渠道DetailDTO 传输对象。
 *
 * <p>字段为查询/导出场景的扁平投影，仅保留 getter/setter 与 toString。
 */
public class CustChannelDetailDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 银行版本 */
    private Integer bankVersion;

    /** 银行区域 */
    private String bankRegion;

    /** 银行渠道 */
    private String bankChannel;

    /** 银行分组 */
    private String bankGroup;

    /** 银行标签 */
    private String bankTag;

    /** 银行负责人 */
    private String bankOwner;

    /** 资产编号 */
    private String assetNo;

    /** 资产名称 */
    private String assetName;

    /** 资产类型 */
    private String assetType;

    /** 资产编码 */
    private String assetCode;

    /** 资产级别 */
    private String assetLevel;

    /** 资产状态 */
    private String assetStatus;

    /** 资产金额 */
    private BigDecimal assetAmount;

    /** 资产数量 */
    private Integer assetCount;

    /** 资产比率 */
    private BigDecimal assetRate;

    /** 资产日期 */
    private Date assetDate;

    /** 资产时间 */
    private Date assetTime;

    /** 资产标记 */
    private Boolean assetFlag;

    /** 资产说明 */
    private String assetRemark;

    /** 资产来源 */
    private String assetSource;

    /** 资产版本 */
    private Integer assetVersion;

    /** 资产区域 */
    private String assetRegion;

    /** 资产渠道 */
    private String assetChannel;

    /** 资产分组 */
    private String assetGroup;

    /** 资产标签 */
    private String assetTag;

    /** 资产负责人 */
    private String assetOwner;

    /** 风险编号 */
    private String riskNo;

    /** 风险名称 */
    private String riskName;

    /** 风险类型 */
    private String riskType;

    /** 风险编码 */
    private String riskCode;

    /** 风险级别 */
    private String riskLevel;

    /** 风险状态 */
    private String riskStatus;

    /** 风险金额 */
    private BigDecimal riskAmount;

    /** 风险数量 */
    private Integer riskCount;

    /** 风险比率 */
    private BigDecimal riskRate;

    /** 风险日期 */
    private Date riskDate;

    /** 风险时间 */
    private Date riskTime;

    /** 风险标记 */
    private Boolean riskFlag;

    /** 风险说明 */
    private String riskRemark;

    /** 风险来源 */
    private String riskSource;

    /** 风险版本 */
    private Integer riskVersion;

    /** 风险区域 */
    private String riskRegion;

    /** 风险渠道 */
    private String riskChannel;

    /** 风险分组 */
    private String riskGroup;

    /** 风险标签 */
    private String riskTag;

    /** 风险负责人 */
    private String riskOwner;

    /** 信用编号 */
    private String creditNo;

    /** 信用名称 */
    private String creditName;

    /** 信用类型 */
    private String creditType;

    /** 信用编码 */
    private String creditCode;

    /** 信用级别 */
    private String creditLevel;

    /** 信用状态 */
    private String creditStatus;

    /** 信用金额 */
    private BigDecimal creditAmount;

    /** 信用数量 */
    private Integer creditCount;

    /** 信用比率 */
    private BigDecimal creditRate;

    /** 信用日期 */
    private Date creditDate;

    /** 信用时间 */
    private Date creditTime;

    /** 信用标记 */
    private Boolean creditFlag;

    /** 信用说明 */
    private String creditRemark;

    /** 信用来源 */
    private String creditSource;

    public Integer getBankVersion() {
        return bankVersion;
    }

    public void setBankVersion(Integer bankVersion) {
        this.bankVersion = bankVersion;
    }

    public String getBankRegion() {
        return bankRegion;
    }

    public void setBankRegion(String bankRegion) {
        this.bankRegion = bankRegion;
    }

    public String getBankChannel() {
        return bankChannel;
    }

    public void setBankChannel(String bankChannel) {
        this.bankChannel = bankChannel;
    }

    public String getBankGroup() {
        return bankGroup;
    }

    public void setBankGroup(String bankGroup) {
        this.bankGroup = bankGroup;
    }

    public String getBankTag() {
        return bankTag;
    }

    public void setBankTag(String bankTag) {
        this.bankTag = bankTag;
    }

    public String getBankOwner() {
        return bankOwner;
    }

    public void setBankOwner(String bankOwner) {
        this.bankOwner = bankOwner;
    }

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getAssetLevel() {
        return assetLevel;
    }

    public void setAssetLevel(String assetLevel) {
        this.assetLevel = assetLevel;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }

    public BigDecimal getAssetAmount() {
        return assetAmount;
    }

    public void setAssetAmount(BigDecimal assetAmount) {
        this.assetAmount = assetAmount;
    }

    public Integer getAssetCount() {
        return assetCount;
    }

    public void setAssetCount(Integer assetCount) {
        this.assetCount = assetCount;
    }

    public BigDecimal getAssetRate() {
        return assetRate;
    }

    public void setAssetRate(BigDecimal assetRate) {
        this.assetRate = assetRate;
    }

    public Date getAssetDate() {
        return assetDate;
    }

    public void setAssetDate(Date assetDate) {
        this.assetDate = assetDate;
    }

    public Date getAssetTime() {
        return assetTime;
    }

    public void setAssetTime(Date assetTime) {
        this.assetTime = assetTime;
    }

    public Boolean getAssetFlag() {
        return assetFlag;
    }

    public void setAssetFlag(Boolean assetFlag) {
        this.assetFlag = assetFlag;
    }

    public String getAssetRemark() {
        return assetRemark;
    }

    public void setAssetRemark(String assetRemark) {
        this.assetRemark = assetRemark;
    }

    public String getAssetSource() {
        return assetSource;
    }

    public void setAssetSource(String assetSource) {
        this.assetSource = assetSource;
    }

    public Integer getAssetVersion() {
        return assetVersion;
    }

    public void setAssetVersion(Integer assetVersion) {
        this.assetVersion = assetVersion;
    }

    public String getAssetRegion() {
        return assetRegion;
    }

    public void setAssetRegion(String assetRegion) {
        this.assetRegion = assetRegion;
    }

    public String getAssetChannel() {
        return assetChannel;
    }

    public void setAssetChannel(String assetChannel) {
        this.assetChannel = assetChannel;
    }

    public String getAssetGroup() {
        return assetGroup;
    }

    public void setAssetGroup(String assetGroup) {
        this.assetGroup = assetGroup;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public String getAssetOwner() {
        return assetOwner;
    }

    public void setAssetOwner(String assetOwner) {
        this.assetOwner = assetOwner;
    }

    public String getRiskNo() {
        return riskNo;
    }

    public void setRiskNo(String riskNo) {
        this.riskNo = riskNo;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getRiskStatus() {
        return riskStatus;
    }

    public void setRiskStatus(String riskStatus) {
        this.riskStatus = riskStatus;
    }

    public BigDecimal getRiskAmount() {
        return riskAmount;
    }

    public void setRiskAmount(BigDecimal riskAmount) {
        this.riskAmount = riskAmount;
    }

    public Integer getRiskCount() {
        return riskCount;
    }

    public void setRiskCount(Integer riskCount) {
        this.riskCount = riskCount;
    }

    public BigDecimal getRiskRate() {
        return riskRate;
    }

    public void setRiskRate(BigDecimal riskRate) {
        this.riskRate = riskRate;
    }

    public Date getRiskDate() {
        return riskDate;
    }

    public void setRiskDate(Date riskDate) {
        this.riskDate = riskDate;
    }

    public Date getRiskTime() {
        return riskTime;
    }

    public void setRiskTime(Date riskTime) {
        this.riskTime = riskTime;
    }

    public Boolean getRiskFlag() {
        return riskFlag;
    }

    public void setRiskFlag(Boolean riskFlag) {
        this.riskFlag = riskFlag;
    }

    public String getRiskRemark() {
        return riskRemark;
    }

    public void setRiskRemark(String riskRemark) {
        this.riskRemark = riskRemark;
    }

    public String getRiskSource() {
        return riskSource;
    }

    public void setRiskSource(String riskSource) {
        this.riskSource = riskSource;
    }

    public Integer getRiskVersion() {
        return riskVersion;
    }

    public void setRiskVersion(Integer riskVersion) {
        this.riskVersion = riskVersion;
    }

    public String getRiskRegion() {
        return riskRegion;
    }

    public void setRiskRegion(String riskRegion) {
        this.riskRegion = riskRegion;
    }

    public String getRiskChannel() {
        return riskChannel;
    }

    public void setRiskChannel(String riskChannel) {
        this.riskChannel = riskChannel;
    }

    public String getRiskGroup() {
        return riskGroup;
    }

    public void setRiskGroup(String riskGroup) {
        this.riskGroup = riskGroup;
    }

    public String getRiskTag() {
        return riskTag;
    }

    public void setRiskTag(String riskTag) {
        this.riskTag = riskTag;
    }

    public String getRiskOwner() {
        return riskOwner;
    }

    public void setRiskOwner(String riskOwner) {
        this.riskOwner = riskOwner;
    }

    public String getCreditNo() {
        return creditNo;
    }

    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getCreditLevel() {
        return creditLevel;
    }

    public void setCreditLevel(String creditLevel) {
        this.creditLevel = creditLevel;
    }

    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Integer getCreditCount() {
        return creditCount;
    }

    public void setCreditCount(Integer creditCount) {
        this.creditCount = creditCount;
    }

    public BigDecimal getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(BigDecimal creditRate) {
        this.creditRate = creditRate;
    }

    public Date getCreditDate() {
        return creditDate;
    }

    public void setCreditDate(Date creditDate) {
        this.creditDate = creditDate;
    }

    public Date getCreditTime() {
        return creditTime;
    }

    public void setCreditTime(Date creditTime) {
        this.creditTime = creditTime;
    }

    public Boolean getCreditFlag() {
        return creditFlag;
    }

    public void setCreditFlag(Boolean creditFlag) {
        this.creditFlag = creditFlag;
    }

    public String getCreditRemark() {
        return creditRemark;
    }

    public void setCreditRemark(String creditRemark) {
        this.creditRemark = creditRemark;
    }

    public String getCreditSource() {
        return creditSource;
    }

    public void setCreditSource(String creditSource) {
        this.creditSource = creditSource;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustChannelDetailDTO{");
        sb.append("bankVersion=").append(bankVersion).append(", ");
        sb.append("bankRegion=").append(bankRegion).append(", ");
        sb.append("bankChannel=").append(bankChannel).append(", ");
        sb.append("bankGroup=").append(bankGroup).append(", ");
        sb.append("bankTag=").append(bankTag).append(", ");
        sb.append("bankOwner=").append(bankOwner).append(", ");
        sb.append("assetNo=").append(assetNo).append(", ");
        sb.append("assetName=").append(assetName).append(", ");
        sb.append("assetType=").append(assetType).append(", ");
        sb.append("assetCode=").append(assetCode).append(", ");
        sb.append("assetLevel=").append(assetLevel).append(", ");
        sb.append("assetStatus=").append(assetStatus).append(", ");
        sb.append("assetAmount=").append(assetAmount).append(", ");
        sb.append("assetCount=").append(assetCount).append(", ");
        sb.append("assetRate=").append(assetRate).append(", ");
        sb.append("assetDate=").append(assetDate).append(", ");
        sb.append("assetTime=").append(assetTime).append(", ");
        sb.append("assetFlag=").append(assetFlag).append(", ");
        sb.append("assetRemark=").append(assetRemark).append(", ");
        sb.append("assetSource=").append(assetSource).append(", ");
        sb.append("assetVersion=").append(assetVersion).append(", ");
        sb.append("assetRegion=").append(assetRegion).append(", ");
        sb.append("assetChannel=").append(assetChannel).append(", ");
        sb.append("assetGroup=").append(assetGroup).append(", ");
        sb.append("assetTag=").append(assetTag).append(", ");
        sb.append("assetOwner=").append(assetOwner).append(", ");
        sb.append("riskNo=").append(riskNo).append(", ");
        sb.append("riskName=").append(riskName).append(", ");
        sb.append("riskType=").append(riskType).append(", ");
        sb.append("riskCode=").append(riskCode).append(", ");
        sb.append("riskLevel=").append(riskLevel).append(", ");
        sb.append("riskStatus=").append(riskStatus).append(", ");
        sb.append("riskAmount=").append(riskAmount).append(", ");
        sb.append("riskCount=").append(riskCount).append(", ");
        sb.append("riskRate=").append(riskRate).append(", ");
        sb.append("riskDate=").append(riskDate).append(", ");
        sb.append("riskTime=").append(riskTime).append(", ");
        sb.append("riskFlag=").append(riskFlag).append(", ");
        sb.append("riskRemark=").append(riskRemark).append(", ");
        sb.append("riskSource=").append(riskSource).append(", ");
        sb.append("riskVersion=").append(riskVersion).append(", ");
        sb.append("riskRegion=").append(riskRegion).append(", ");
        sb.append("riskChannel=").append(riskChannel).append(", ");
        sb.append("riskGroup=").append(riskGroup).append(", ");
        sb.append("riskTag=").append(riskTag).append(", ");
        sb.append("riskOwner=").append(riskOwner).append(", ");
        sb.append("creditNo=").append(creditNo).append(", ");
        sb.append("creditName=").append(creditName).append(", ");
        sb.append("creditType=").append(creditType).append(", ");
        sb.append("creditCode=").append(creditCode).append(", ");
        sb.append("creditLevel=").append(creditLevel).append(", ");
        sb.append("creditStatus=").append(creditStatus).append(", ");
        sb.append("creditAmount=").append(creditAmount).append(", ");
        sb.append("creditCount=").append(creditCount).append(", ");
        sb.append("creditRate=").append(creditRate).append(", ");
        sb.append("creditDate=").append(creditDate).append(", ");
        sb.append("creditTime=").append(creditTime).append(", ");
        sb.append("creditFlag=").append(creditFlag).append(", ");
        sb.append("creditRemark=").append(creditRemark).append(", ");
        sb.append("creditSource=").append(creditSource).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
