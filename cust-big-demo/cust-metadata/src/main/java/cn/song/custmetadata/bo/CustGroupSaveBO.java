package cn.song.custmetadata.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户群组SaveBO 查询条件对象。
 *
 * <p>供 Service/Controller 逐层传递筛选条件，字段与查询页面对应。
 */
public class CustGroupSaveBO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    /** 合同状态 */
    private String contractStatus;

    /** 合同金额 */
    private BigDecimal contractAmount;

    /** 合同数量 */
    private Integer contractCount;

    /** 合同比率 */
    private BigDecimal contractRate;

    /** 合同日期 */
    private Date contractDate;

    /** 合同时间 */
    private Date contractTime;

    /** 合同标记 */
    private Boolean contractFlag;

    /** 合同说明 */
    private String contractRemark;

    /** 合同来源 */
    private String contractSource;

    /** 合同版本 */
    private Integer contractVersion;

    /** 合同区域 */
    private String contractRegion;

    /** 合同渠道 */
    private String contractChannel;

    /** 合同分组 */
    private String contractGroup;

    /** 合同标签 */
    private String contractTag;

    /** 合同负责人 */
    private String contractOwner;

    /** 订单编号 */
    private String orderNo;

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

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Integer getContractCount() {
        return contractCount;
    }

    public void setContractCount(Integer contractCount) {
        this.contractCount = contractCount;
    }

    public BigDecimal getContractRate() {
        return contractRate;
    }

    public void setContractRate(BigDecimal contractRate) {
        this.contractRate = contractRate;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public Date getContractTime() {
        return contractTime;
    }

    public void setContractTime(Date contractTime) {
        this.contractTime = contractTime;
    }

    public Boolean getContractFlag() {
        return contractFlag;
    }

    public void setContractFlag(Boolean contractFlag) {
        this.contractFlag = contractFlag;
    }

    public String getContractRemark() {
        return contractRemark;
    }

    public void setContractRemark(String contractRemark) {
        this.contractRemark = contractRemark;
    }

    public String getContractSource() {
        return contractSource;
    }

    public void setContractSource(String contractSource) {
        this.contractSource = contractSource;
    }

    public Integer getContractVersion() {
        return contractVersion;
    }

    public void setContractVersion(Integer contractVersion) {
        this.contractVersion = contractVersion;
    }

    public String getContractRegion() {
        return contractRegion;
    }

    public void setContractRegion(String contractRegion) {
        this.contractRegion = contractRegion;
    }

    public String getContractChannel() {
        return contractChannel;
    }

    public void setContractChannel(String contractChannel) {
        this.contractChannel = contractChannel;
    }

    public String getContractGroup() {
        return contractGroup;
    }

    public void setContractGroup(String contractGroup) {
        this.contractGroup = contractGroup;
    }

    public String getContractTag() {
        return contractTag;
    }

    public void setContractTag(String contractTag) {
        this.contractTag = contractTag;
    }

    public String getContractOwner() {
        return contractOwner;
    }

    public void setContractOwner(String contractOwner) {
        this.contractOwner = contractOwner;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

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

    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustGroupSaveBO{");
        sb.append("visitGroup=").append(visitGroup).append(", ");
        sb.append("visitTag=").append(visitTag).append(", ");
        sb.append("visitOwner=").append(visitOwner).append(", ");
        sb.append("contractNo=").append(contractNo).append(", ");
        sb.append("contractName=").append(contractName).append(", ");
        sb.append("contractType=").append(contractType).append(", ");
        sb.append("contractCode=").append(contractCode).append(", ");
        sb.append("contractLevel=").append(contractLevel).append(", ");
        sb.append("contractStatus=").append(contractStatus).append(", ");
        sb.append("contractAmount=").append(contractAmount).append(", ");
        sb.append("contractCount=").append(contractCount).append(", ");
        sb.append("contractRate=").append(contractRate).append(", ");
        sb.append("contractDate=").append(contractDate).append(", ");
        sb.append("contractTime=").append(contractTime).append(", ");
        sb.append("contractFlag=").append(contractFlag).append(", ");
        sb.append("contractRemark=").append(contractRemark).append(", ");
        sb.append("contractSource=").append(contractSource).append(", ");
        sb.append("contractVersion=").append(contractVersion).append(", ");
        sb.append("contractRegion=").append(contractRegion).append(", ");
        sb.append("contractChannel=").append(contractChannel).append(", ");
        sb.append("contractGroup=").append(contractGroup).append(", ");
        sb.append("contractTag=").append(contractTag).append(", ");
        sb.append("contractOwner=").append(contractOwner).append(", ");
        sb.append("orderNo=").append(orderNo).append(", ");
        sb.append("orderName=").append(orderName).append(", ");
        sb.append("orderType=").append(orderType).append(", ");
        sb.append("orderCode=").append(orderCode).append(", ");
        sb.append("orderLevel=").append(orderLevel).append(", ");
        sb.append("orderStatus=").append(orderStatus).append(", ");
        sb.append("orderAmount=").append(orderAmount).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
