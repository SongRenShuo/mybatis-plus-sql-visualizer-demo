package cn.song.custmetadata.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户信息DetailDTO 传输对象。
 *
 * <p>字段为查询/导出场景的扁平投影，仅保留 getter/setter 与 toString。
 */
public class CustInfoDetailDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 客户版本 */
    private Integer custVersion;

    /** 客户区域 */
    private String custRegion;

    /** 客户渠道 */
    private String custChannel;

    /** 客户分组 */
    private String custGroup;

    /** 客户标签 */
    private String custTag;

    /** 客户负责人 */
    private String custOwner;

    /** 证件编号 */
    private String certNo;

    /** 证件名称 */
    private String certName;

    /** 证件类型 */
    private String certType;

    /** 证件编码 */
    private String certCode;

    /** 证件级别 */
    private String certLevel;

    /** 证件状态 */
    private String certStatus;

    /** 证件金额 */
    private BigDecimal certAmount;

    /** 证件数量 */
    private Integer certCount;

    /** 证件比率 */
    private BigDecimal certRate;

    /** 证件日期 */
    private Date certDate;

    /** 证件时间 */
    private Date certTime;

    /** 证件标记 */
    private Boolean certFlag;

    /** 证件说明 */
    private String certRemark;

    /** 证件来源 */
    private String certSource;

    /** 证件版本 */
    private Integer certVersion;

    /** 证件区域 */
    private String certRegion;

    /** 证件渠道 */
    private String certChannel;

    /** 证件分组 */
    private String certGroup;

    /** 证件标签 */
    private String certTag;

    /** 证件负责人 */
    private String certOwner;

    /** 银行编号 */
    private String bankNo;

    /** 银行名称 */
    private String bankName;

    /** 银行类型 */
    private String bankType;

    /** 银行编码 */
    private String bankCode;

    /** 银行级别 */
    private String bankLevel;

    /** 银行状态 */
    private String bankStatus;

    /** 银行金额 */
    private BigDecimal bankAmount;

    /** 银行数量 */
    private Integer bankCount;

    /** 银行比率 */
    private BigDecimal bankRate;

    /** 银行日期 */
    private Date bankDate;

    /** 银行时间 */
    private Date bankTime;

    /** 银行标记 */
    private Boolean bankFlag;

    /** 银行说明 */
    private String bankRemark;

    /** 银行来源 */
    private String bankSource;

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

    public Integer getCustVersion() {
        return custVersion;
    }

    public void setCustVersion(Integer custVersion) {
        this.custVersion = custVersion;
    }

    public String getCustRegion() {
        return custRegion;
    }

    public void setCustRegion(String custRegion) {
        this.custRegion = custRegion;
    }

    public String getCustChannel() {
        return custChannel;
    }

    public void setCustChannel(String custChannel) {
        this.custChannel = custChannel;
    }

    public String getCustGroup() {
        return custGroup;
    }

    public void setCustGroup(String custGroup) {
        this.custGroup = custGroup;
    }

    public String getCustTag() {
        return custTag;
    }

    public void setCustTag(String custTag) {
        this.custTag = custTag;
    }

    public String getCustOwner() {
        return custOwner;
    }

    public void setCustOwner(String custOwner) {
        this.custOwner = custOwner;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String certCode) {
        this.certCode = certCode;
    }

    public String getCertLevel() {
        return certLevel;
    }

    public void setCertLevel(String certLevel) {
        this.certLevel = certLevel;
    }

    public String getCertStatus() {
        return certStatus;
    }

    public void setCertStatus(String certStatus) {
        this.certStatus = certStatus;
    }

    public BigDecimal getCertAmount() {
        return certAmount;
    }

    public void setCertAmount(BigDecimal certAmount) {
        this.certAmount = certAmount;
    }

    public Integer getCertCount() {
        return certCount;
    }

    public void setCertCount(Integer certCount) {
        this.certCount = certCount;
    }

    public BigDecimal getCertRate() {
        return certRate;
    }

    public void setCertRate(BigDecimal certRate) {
        this.certRate = certRate;
    }

    public Date getCertDate() {
        return certDate;
    }

    public void setCertDate(Date certDate) {
        this.certDate = certDate;
    }

    public Date getCertTime() {
        return certTime;
    }

    public void setCertTime(Date certTime) {
        this.certTime = certTime;
    }

    public Boolean getCertFlag() {
        return certFlag;
    }

    public void setCertFlag(Boolean certFlag) {
        this.certFlag = certFlag;
    }

    public String getCertRemark() {
        return certRemark;
    }

    public void setCertRemark(String certRemark) {
        this.certRemark = certRemark;
    }

    public String getCertSource() {
        return certSource;
    }

    public void setCertSource(String certSource) {
        this.certSource = certSource;
    }

    public Integer getCertVersion() {
        return certVersion;
    }

    public void setCertVersion(Integer certVersion) {
        this.certVersion = certVersion;
    }

    public String getCertRegion() {
        return certRegion;
    }

    public void setCertRegion(String certRegion) {
        this.certRegion = certRegion;
    }

    public String getCertChannel() {
        return certChannel;
    }

    public void setCertChannel(String certChannel) {
        this.certChannel = certChannel;
    }

    public String getCertGroup() {
        return certGroup;
    }

    public void setCertGroup(String certGroup) {
        this.certGroup = certGroup;
    }

    public String getCertTag() {
        return certTag;
    }

    public void setCertTag(String certTag) {
        this.certTag = certTag;
    }

    public String getCertOwner() {
        return certOwner;
    }

    public void setCertOwner(String certOwner) {
        this.certOwner = certOwner;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankLevel() {
        return bankLevel;
    }

    public void setBankLevel(String bankLevel) {
        this.bankLevel = bankLevel;
    }

    public String getBankStatus() {
        return bankStatus;
    }

    public void setBankStatus(String bankStatus) {
        this.bankStatus = bankStatus;
    }

    public BigDecimal getBankAmount() {
        return bankAmount;
    }

    public void setBankAmount(BigDecimal bankAmount) {
        this.bankAmount = bankAmount;
    }

    public Integer getBankCount() {
        return bankCount;
    }

    public void setBankCount(Integer bankCount) {
        this.bankCount = bankCount;
    }

    public BigDecimal getBankRate() {
        return bankRate;
    }

    public void setBankRate(BigDecimal bankRate) {
        this.bankRate = bankRate;
    }

    public Date getBankDate() {
        return bankDate;
    }

    public void setBankDate(Date bankDate) {
        this.bankDate = bankDate;
    }

    public Date getBankTime() {
        return bankTime;
    }

    public void setBankTime(Date bankTime) {
        this.bankTime = bankTime;
    }

    public Boolean getBankFlag() {
        return bankFlag;
    }

    public void setBankFlag(Boolean bankFlag) {
        this.bankFlag = bankFlag;
    }

    public String getBankRemark() {
        return bankRemark;
    }

    public void setBankRemark(String bankRemark) {
        this.bankRemark = bankRemark;
    }

    public String getBankSource() {
        return bankSource;
    }

    public void setBankSource(String bankSource) {
        this.bankSource = bankSource;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustInfoDetailDTO{");
        sb.append("custVersion=").append(custVersion).append(", ");
        sb.append("custRegion=").append(custRegion).append(", ");
        sb.append("custChannel=").append(custChannel).append(", ");
        sb.append("custGroup=").append(custGroup).append(", ");
        sb.append("custTag=").append(custTag).append(", ");
        sb.append("custOwner=").append(custOwner).append(", ");
        sb.append("certNo=").append(certNo).append(", ");
        sb.append("certName=").append(certName).append(", ");
        sb.append("certType=").append(certType).append(", ");
        sb.append("certCode=").append(certCode).append(", ");
        sb.append("certLevel=").append(certLevel).append(", ");
        sb.append("certStatus=").append(certStatus).append(", ");
        sb.append("certAmount=").append(certAmount).append(", ");
        sb.append("certCount=").append(certCount).append(", ");
        sb.append("certRate=").append(certRate).append(", ");
        sb.append("certDate=").append(certDate).append(", ");
        sb.append("certTime=").append(certTime).append(", ");
        sb.append("certFlag=").append(certFlag).append(", ");
        sb.append("certRemark=").append(certRemark).append(", ");
        sb.append("certSource=").append(certSource).append(", ");
        sb.append("certVersion=").append(certVersion).append(", ");
        sb.append("certRegion=").append(certRegion).append(", ");
        sb.append("certChannel=").append(certChannel).append(", ");
        sb.append("certGroup=").append(certGroup).append(", ");
        sb.append("certTag=").append(certTag).append(", ");
        sb.append("certOwner=").append(certOwner).append(", ");
        sb.append("bankNo=").append(bankNo).append(", ");
        sb.append("bankName=").append(bankName).append(", ");
        sb.append("bankType=").append(bankType).append(", ");
        sb.append("bankCode=").append(bankCode).append(", ");
        sb.append("bankLevel=").append(bankLevel).append(", ");
        sb.append("bankStatus=").append(bankStatus).append(", ");
        sb.append("bankAmount=").append(bankAmount).append(", ");
        sb.append("bankCount=").append(bankCount).append(", ");
        sb.append("bankRate=").append(bankRate).append(", ");
        sb.append("bankDate=").append(bankDate).append(", ");
        sb.append("bankTime=").append(bankTime).append(", ");
        sb.append("bankFlag=").append(bankFlag).append(", ");
        sb.append("bankRemark=").append(bankRemark).append(", ");
        sb.append("bankSource=").append(bankSource).append(", ");
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
        sb.append('}');
        return sb.toString();
    }
}
