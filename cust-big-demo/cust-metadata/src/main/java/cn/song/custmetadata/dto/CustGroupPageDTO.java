package cn.song.custmetadata.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户群组PageDTO 传输对象。
 *
 * <p>字段为查询/导出场景的扁平投影，仅保留 getter/setter 与 toString。
 */
public class CustGroupPageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 评分来源 */
    private String scoreSource;

    /** 评分版本 */
    private Integer scoreVersion;

    /** 评分区域 */
    private String scoreRegion;

    /** 评分渠道 */
    private String scoreChannel;

    /** 评分分组 */
    private String scoreGroup;

    /** 评分标签 */
    private String scoreTag;

    /** 评分负责人 */
    private String scoreOwner;

    /** 客户编号 */
    private String custNo;

    /** 客户名称 */
    private String custName;

    /** 客户类型 */
    private String custType;

    /** 客户编码 */
    private String custCode;

    /** 客户级别 */
    private String custLevel;

    /** 客户状态 */
    private String custStatus;

    /** 客户金额 */
    private BigDecimal custAmount;

    /** 客户数量 */
    private Integer custCount;

    /** 客户比率 */
    private BigDecimal custRate;

    /** 客户日期 */
    private Date custDate;

    /** 客户时间 */
    private Date custTime;

    /** 客户标记 */
    private Boolean custFlag;

    /** 客户说明 */
    private String custRemark;

    /** 客户来源 */
    private String custSource;

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

    public String getScoreGroup() {
        return scoreGroup;
    }

    public void setScoreGroup(String scoreGroup) {
        this.scoreGroup = scoreGroup;
    }

    public String getScoreTag() {
        return scoreTag;
    }

    public void setScoreTag(String scoreTag) {
        this.scoreTag = scoreTag;
    }

    public String getScoreOwner() {
        return scoreOwner;
    }

    public void setScoreOwner(String scoreOwner) {
        this.scoreOwner = scoreOwner;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustStatus() {
        return custStatus;
    }

    public void setCustStatus(String custStatus) {
        this.custStatus = custStatus;
    }

    public BigDecimal getCustAmount() {
        return custAmount;
    }

    public void setCustAmount(BigDecimal custAmount) {
        this.custAmount = custAmount;
    }

    public Integer getCustCount() {
        return custCount;
    }

    public void setCustCount(Integer custCount) {
        this.custCount = custCount;
    }

    public BigDecimal getCustRate() {
        return custRate;
    }

    public void setCustRate(BigDecimal custRate) {
        this.custRate = custRate;
    }

    public Date getCustDate() {
        return custDate;
    }

    public void setCustDate(Date custDate) {
        this.custDate = custDate;
    }

    public Date getCustTime() {
        return custTime;
    }

    public void setCustTime(Date custTime) {
        this.custTime = custTime;
    }

    public Boolean getCustFlag() {
        return custFlag;
    }

    public void setCustFlag(Boolean custFlag) {
        this.custFlag = custFlag;
    }

    public String getCustRemark() {
        return custRemark;
    }

    public void setCustRemark(String custRemark) {
        this.custRemark = custRemark;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustGroupPageDTO{");
        sb.append("scoreSource=").append(scoreSource).append(", ");
        sb.append("scoreVersion=").append(scoreVersion).append(", ");
        sb.append("scoreRegion=").append(scoreRegion).append(", ");
        sb.append("scoreChannel=").append(scoreChannel).append(", ");
        sb.append("scoreGroup=").append(scoreGroup).append(", ");
        sb.append("scoreTag=").append(scoreTag).append(", ");
        sb.append("scoreOwner=").append(scoreOwner).append(", ");
        sb.append("custNo=").append(custNo).append(", ");
        sb.append("custName=").append(custName).append(", ");
        sb.append("custType=").append(custType).append(", ");
        sb.append("custCode=").append(custCode).append(", ");
        sb.append("custLevel=").append(custLevel).append(", ");
        sb.append("custStatus=").append(custStatus).append(", ");
        sb.append("custAmount=").append(custAmount).append(", ");
        sb.append("custCount=").append(custCount).append(", ");
        sb.append("custRate=").append(custRate).append(", ");
        sb.append("custDate=").append(custDate).append(", ");
        sb.append("custTime=").append(custTime).append(", ");
        sb.append("custFlag=").append(custFlag).append(", ");
        sb.append("custRemark=").append(custRemark).append(", ");
        sb.append("custSource=").append(custSource).append(", ");
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
        sb.append('}');
        return sb.toString();
    }
}
