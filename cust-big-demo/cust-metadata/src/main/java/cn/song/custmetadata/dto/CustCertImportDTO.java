package cn.song.custmetadata.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户证件ImportDTO 传输对象。
 *
 * <p>字段为查询/导出场景的扁平投影，仅保留 getter/setter 与 toString。
 */
public class CustCertImportDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 订单名称 */
    private String orderName;

    /** 订单类型 */
    private String orderType;

    /** 订单编码 */
    private String orderCode;

    /** 订单级别 */
    private String orderLevel;

    /** 订单状态 */
    private String orderStatus;

    /** 订单金额 */
    private BigDecimal orderAmount;

    /** 订单数量 */
    private Integer orderCount;

    /** 订单比率 */
    private BigDecimal orderRate;

    /** 订单日期 */
    private Date orderDate;

    /** 订单时间 */
    private Date orderTime;

    /** 订单标记 */
    private Boolean orderFlag;

    /** 订单说明 */
    private String orderRemark;

    /** 订单来源 */
    private String orderSource;

    /** 订单版本 */
    private Integer orderVersion;

    /** 订单区域 */
    private String orderRegion;

    /** 订单渠道 */
    private String orderChannel;

    /** 订单分组 */
    private String orderGroup;

    /** 订单标签 */
    private String orderTag;

    /** 订单负责人 */
    private String orderOwner;

    /** 付款编号 */
    private String paymentNo;

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

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(String orderLevel) {
        this.orderLevel = orderLevel;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public BigDecimal getOrderRate() {
        return orderRate;
    }

    public void setOrderRate(BigDecimal orderRate) {
        this.orderRate = orderRate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Boolean getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(Boolean orderFlag) {
        this.orderFlag = orderFlag;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public Integer getOrderVersion() {
        return orderVersion;
    }

    public void setOrderVersion(Integer orderVersion) {
        this.orderVersion = orderVersion;
    }

    public String getOrderRegion() {
        return orderRegion;
    }

    public void setOrderRegion(String orderRegion) {
        this.orderRegion = orderRegion;
    }

    public String getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel;
    }

    public String getOrderGroup() {
        return orderGroup;
    }

    public void setOrderGroup(String orderGroup) {
        this.orderGroup = orderGroup;
    }

    public String getOrderTag() {
        return orderTag;
    }

    public void setOrderTag(String orderTag) {
        this.orderTag = orderTag;
    }

    public String getOrderOwner() {
        return orderOwner;
    }

    public void setOrderOwner(String orderOwner) {
        this.orderOwner = orderOwner;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustCertImportDTO{");
        sb.append("orderName=").append(orderName).append(", ");
        sb.append("orderType=").append(orderType).append(", ");
        sb.append("orderCode=").append(orderCode).append(", ");
        sb.append("orderLevel=").append(orderLevel).append(", ");
        sb.append("orderStatus=").append(orderStatus).append(", ");
        sb.append("orderAmount=").append(orderAmount).append(", ");
        sb.append("orderCount=").append(orderCount).append(", ");
        sb.append("orderRate=").append(orderRate).append(", ");
        sb.append("orderDate=").append(orderDate).append(", ");
        sb.append("orderTime=").append(orderTime).append(", ");
        sb.append("orderFlag=").append(orderFlag).append(", ");
        sb.append("orderRemark=").append(orderRemark).append(", ");
        sb.append("orderSource=").append(orderSource).append(", ");
        sb.append("orderVersion=").append(orderVersion).append(", ");
        sb.append("orderRegion=").append(orderRegion).append(", ");
        sb.append("orderChannel=").append(orderChannel).append(", ");
        sb.append("orderGroup=").append(orderGroup).append(", ");
        sb.append("orderTag=").append(orderTag).append(", ");
        sb.append("orderOwner=").append(orderOwner).append(", ");
        sb.append("paymentNo=").append(paymentNo).append(", ");
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
        sb.append('}');
        return sb.toString();
    }
}
