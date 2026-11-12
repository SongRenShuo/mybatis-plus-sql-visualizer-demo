package cn.song.custmetadata.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户订单ImportDTO 传输对象。
 *
 * <p>字段为查询/导出场景的扁平投影，仅保留 getter/setter 与 toString。
 */
public class CustOrderImportDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustOrderImportDTO{");
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
        sb.append("orderCount=").append(orderCount).append(", ");
        sb.append("orderRate=").append(orderRate).append(", ");
        sb.append("orderDate=").append(orderDate).append(", ");
        sb.append("orderTime=").append(orderTime).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
