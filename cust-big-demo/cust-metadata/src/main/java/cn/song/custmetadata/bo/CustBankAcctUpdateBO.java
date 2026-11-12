package cn.song.custmetadata.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户银行账户UpdateBO 查询条件对象。
 *
 * <p>供 Service/Controller 逐层传递筛选条件，字段与查询页面对应。
 */
public class CustBankAcctUpdateBO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustBankAcctUpdateBO{");
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
        sb.append('}');
        return sb.toString();
    }
}
