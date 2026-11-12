package cn.song.custmetadata.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户持有人关系PageDTO 传输对象。
 *
 * <p>字段为查询/导出场景的扁平投影，仅保留 getter/setter 与 toString。
 */
public class CustHolderRelPageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 付款名称 */
    private String paymentName;

    /** 付款类型 */
    private String paymentType;

    /** 付款编码 */
    private String paymentCode;

    /** 付款级别 */
    private String paymentLevel;

    /** 付款状态 */
    private String paymentStatus;

    /** 付款金额 */
    private BigDecimal paymentAmount;

    /** 付款数量 */
    private Integer paymentCount;

    /** 付款比率 */
    private BigDecimal paymentRate;

    /** 付款日期 */
    private Date paymentDate;

    /** 付款时间 */
    private Date paymentTime;

    /** 付款标记 */
    private Boolean paymentFlag;

    /** 付款说明 */
    private String paymentRemark;

    /** 付款来源 */
    private String paymentSource;

    /** 付款版本 */
    private Integer paymentVersion;

    /** 付款区域 */
    private String paymentRegion;

    /** 付款渠道 */
    private String paymentChannel;

    /** 付款分组 */
    private String paymentGroup;

    /** 付款标签 */
    private String paymentTag;

    /** 付款负责人 */
    private String paymentOwner;

    /** 发票编号 */
    private String invoiceNo;

    /** 发票名称 */
    private String invoiceName;

    /** 发票类型 */
    private String invoiceType;

    /** 发票编码 */
    private String invoiceCode;

    /** 发票级别 */
    private String invoiceLevel;

    /** 发票状态 */
    private String invoiceStatus;

    /** 发票金额 */
    private BigDecimal invoiceAmount;

    /** 发票数量 */
    private Integer invoiceCount;

    /** 发票比率 */
    private BigDecimal invoiceRate;

    /** 发票日期 */
    private Date invoiceDate;

    /** 发票时间 */
    private Date invoiceTime;

    /** 发票标记 */
    private Boolean invoiceFlag;

    /** 发票说明 */
    private String invoiceRemark;

    /** 发票来源 */
    private String invoiceSource;

    /** 发票版本 */
    private Integer invoiceVersion;

    /** 发票区域 */
    private String invoiceRegion;

    /** 发票渠道 */
    private String invoiceChannel;

    /** 发票分组 */
    private String invoiceGroup;

    /** 发票标签 */
    private String invoiceTag;

    /** 发票负责人 */
    private String invoiceOwner;

    /** 结算编号 */
    private String settleNo;

    /** 结算名称 */
    private String settleName;

    /** 结算类型 */
    private String settleType;

    /** 结算编码 */
    private String settleCode;

    /** 结算级别 */
    private String settleLevel;

    /** 结算状态 */
    private String settleStatus;

    /** 结算金额 */
    private BigDecimal settleAmount;

    /** 结算数量 */
    private Integer settleCount;

    /** 结算比率 */
    private BigDecimal settleRate;

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

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getPaymentLevel() {
        return paymentLevel;
    }

    public void setPaymentLevel(String paymentLevel) {
        this.paymentLevel = paymentLevel;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Integer getPaymentCount() {
        return paymentCount;
    }

    public void setPaymentCount(Integer paymentCount) {
        this.paymentCount = paymentCount;
    }

    public BigDecimal getPaymentRate() {
        return paymentRate;
    }

    public void setPaymentRate(BigDecimal paymentRate) {
        this.paymentRate = paymentRate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Boolean getPaymentFlag() {
        return paymentFlag;
    }

    public void setPaymentFlag(Boolean paymentFlag) {
        this.paymentFlag = paymentFlag;
    }

    public String getPaymentRemark() {
        return paymentRemark;
    }

    public void setPaymentRemark(String paymentRemark) {
        this.paymentRemark = paymentRemark;
    }

    public String getPaymentSource() {
        return paymentSource;
    }

    public void setPaymentSource(String paymentSource) {
        this.paymentSource = paymentSource;
    }

    public Integer getPaymentVersion() {
        return paymentVersion;
    }

    public void setPaymentVersion(Integer paymentVersion) {
        this.paymentVersion = paymentVersion;
    }

    public String getPaymentRegion() {
        return paymentRegion;
    }

    public void setPaymentRegion(String paymentRegion) {
        this.paymentRegion = paymentRegion;
    }

    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public String getPaymentGroup() {
        return paymentGroup;
    }

    public void setPaymentGroup(String paymentGroup) {
        this.paymentGroup = paymentGroup;
    }

    public String getPaymentTag() {
        return paymentTag;
    }

    public void setPaymentTag(String paymentTag) {
        this.paymentTag = paymentTag;
    }

    public String getPaymentOwner() {
        return paymentOwner;
    }

    public void setPaymentOwner(String paymentOwner) {
        this.paymentOwner = paymentOwner;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceLevel() {
        return invoiceLevel;
    }

    public void setInvoiceLevel(String invoiceLevel) {
        this.invoiceLevel = invoiceLevel;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Integer getInvoiceCount() {
        return invoiceCount;
    }

    public void setInvoiceCount(Integer invoiceCount) {
        this.invoiceCount = invoiceCount;
    }

    public BigDecimal getInvoiceRate() {
        return invoiceRate;
    }

    public void setInvoiceRate(BigDecimal invoiceRate) {
        this.invoiceRate = invoiceRate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getInvoiceTime() {
        return invoiceTime;
    }

    public void setInvoiceTime(Date invoiceTime) {
        this.invoiceTime = invoiceTime;
    }

    public Boolean getInvoiceFlag() {
        return invoiceFlag;
    }

    public void setInvoiceFlag(Boolean invoiceFlag) {
        this.invoiceFlag = invoiceFlag;
    }

    public String getInvoiceRemark() {
        return invoiceRemark;
    }

    public void setInvoiceRemark(String invoiceRemark) {
        this.invoiceRemark = invoiceRemark;
    }

    public String getInvoiceSource() {
        return invoiceSource;
    }

    public void setInvoiceSource(String invoiceSource) {
        this.invoiceSource = invoiceSource;
    }

    public Integer getInvoiceVersion() {
        return invoiceVersion;
    }

    public void setInvoiceVersion(Integer invoiceVersion) {
        this.invoiceVersion = invoiceVersion;
    }

    public String getInvoiceRegion() {
        return invoiceRegion;
    }

    public void setInvoiceRegion(String invoiceRegion) {
        this.invoiceRegion = invoiceRegion;
    }

    public String getInvoiceChannel() {
        return invoiceChannel;
    }

    public void setInvoiceChannel(String invoiceChannel) {
        this.invoiceChannel = invoiceChannel;
    }

    public String getInvoiceGroup() {
        return invoiceGroup;
    }

    public void setInvoiceGroup(String invoiceGroup) {
        this.invoiceGroup = invoiceGroup;
    }

    public String getInvoiceTag() {
        return invoiceTag;
    }

    public void setInvoiceTag(String invoiceTag) {
        this.invoiceTag = invoiceTag;
    }

    public String getInvoiceOwner() {
        return invoiceOwner;
    }

    public void setInvoiceOwner(String invoiceOwner) {
        this.invoiceOwner = invoiceOwner;
    }

    public String getSettleNo() {
        return settleNo;
    }

    public void setSettleNo(String settleNo) {
        this.settleNo = settleNo;
    }

    public String getSettleName() {
        return settleName;
    }

    public void setSettleName(String settleName) {
        this.settleName = settleName;
    }

    public String getSettleType() {
        return settleType;
    }

    public void setSettleType(String settleType) {
        this.settleType = settleType;
    }

    public String getSettleCode() {
        return settleCode;
    }

    public void setSettleCode(String settleCode) {
        this.settleCode = settleCode;
    }

    public String getSettleLevel() {
        return settleLevel;
    }

    public void setSettleLevel(String settleLevel) {
        this.settleLevel = settleLevel;
    }

    public String getSettleStatus() {
        return settleStatus;
    }

    public void setSettleStatus(String settleStatus) {
        this.settleStatus = settleStatus;
    }

    public BigDecimal getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(BigDecimal settleAmount) {
        this.settleAmount = settleAmount;
    }

    public Integer getSettleCount() {
        return settleCount;
    }

    public void setSettleCount(Integer settleCount) {
        this.settleCount = settleCount;
    }

    public BigDecimal getSettleRate() {
        return settleRate;
    }

    public void setSettleRate(BigDecimal settleRate) {
        this.settleRate = settleRate;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustHolderRelPageDTO{");
        sb.append("paymentName=").append(paymentName).append(", ");
        sb.append("paymentType=").append(paymentType).append(", ");
        sb.append("paymentCode=").append(paymentCode).append(", ");
        sb.append("paymentLevel=").append(paymentLevel).append(", ");
        sb.append("paymentStatus=").append(paymentStatus).append(", ");
        sb.append("paymentAmount=").append(paymentAmount).append(", ");
        sb.append("paymentCount=").append(paymentCount).append(", ");
        sb.append("paymentRate=").append(paymentRate).append(", ");
        sb.append("paymentDate=").append(paymentDate).append(", ");
        sb.append("paymentTime=").append(paymentTime).append(", ");
        sb.append("paymentFlag=").append(paymentFlag).append(", ");
        sb.append("paymentRemark=").append(paymentRemark).append(", ");
        sb.append("paymentSource=").append(paymentSource).append(", ");
        sb.append("paymentVersion=").append(paymentVersion).append(", ");
        sb.append("paymentRegion=").append(paymentRegion).append(", ");
        sb.append("paymentChannel=").append(paymentChannel).append(", ");
        sb.append("paymentGroup=").append(paymentGroup).append(", ");
        sb.append("paymentTag=").append(paymentTag).append(", ");
        sb.append("paymentOwner=").append(paymentOwner).append(", ");
        sb.append("invoiceNo=").append(invoiceNo).append(", ");
        sb.append("invoiceName=").append(invoiceName).append(", ");
        sb.append("invoiceType=").append(invoiceType).append(", ");
        sb.append("invoiceCode=").append(invoiceCode).append(", ");
        sb.append("invoiceLevel=").append(invoiceLevel).append(", ");
        sb.append("invoiceStatus=").append(invoiceStatus).append(", ");
        sb.append("invoiceAmount=").append(invoiceAmount).append(", ");
        sb.append("invoiceCount=").append(invoiceCount).append(", ");
        sb.append("invoiceRate=").append(invoiceRate).append(", ");
        sb.append("invoiceDate=").append(invoiceDate).append(", ");
        sb.append("invoiceTime=").append(invoiceTime).append(", ");
        sb.append("invoiceFlag=").append(invoiceFlag).append(", ");
        sb.append("invoiceRemark=").append(invoiceRemark).append(", ");
        sb.append("invoiceSource=").append(invoiceSource).append(", ");
        sb.append("invoiceVersion=").append(invoiceVersion).append(", ");
        sb.append("invoiceRegion=").append(invoiceRegion).append(", ");
        sb.append("invoiceChannel=").append(invoiceChannel).append(", ");
        sb.append("invoiceGroup=").append(invoiceGroup).append(", ");
        sb.append("invoiceTag=").append(invoiceTag).append(", ");
        sb.append("invoiceOwner=").append(invoiceOwner).append(", ");
        sb.append("settleNo=").append(settleNo).append(", ");
        sb.append("settleName=").append(settleName).append(", ");
        sb.append("settleType=").append(settleType).append(", ");
        sb.append("settleCode=").append(settleCode).append(", ");
        sb.append("settleLevel=").append(settleLevel).append(", ");
        sb.append("settleStatus=").append(settleStatus).append(", ");
        sb.append("settleAmount=").append(settleAmount).append(", ");
        sb.append("settleCount=").append(settleCount).append(", ");
        sb.append("settleRate=").append(settleRate).append(", ");
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
        sb.append('}');
        return sb.toString();
    }
}
