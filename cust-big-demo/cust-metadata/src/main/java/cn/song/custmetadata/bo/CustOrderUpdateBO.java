package cn.song.custmetadata.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户订单UpdateBO 查询条件对象。
 *
 * <p>供 Service/Controller 逐层传递筛选条件，字段与查询页面对应。
 */
public class CustOrderUpdateBO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    /** 信用版本 */
    private Integer creditVersion;

    /** 信用区域 */
    private String creditRegion;

    /** 信用渠道 */
    private String creditChannel;

    /** 信用分组 */
    private String creditGroup;

    /** 信用标签 */
    private String creditTag;

    /** 信用负责人 */
    private String creditOwner;

    /** 行业编号 */
    private String industryNo;

    /** 行业名称 */
    private String industryName;

    /** 行业类型 */
    private String industryType;

    /** 行业编码 */
    private String industryCode;

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

    public Integer getCreditVersion() {
        return creditVersion;
    }

    public void setCreditVersion(Integer creditVersion) {
        this.creditVersion = creditVersion;
    }

    public String getCreditRegion() {
        return creditRegion;
    }

    public void setCreditRegion(String creditRegion) {
        this.creditRegion = creditRegion;
    }

    public String getCreditChannel() {
        return creditChannel;
    }

    public void setCreditChannel(String creditChannel) {
        this.creditChannel = creditChannel;
    }

    public String getCreditGroup() {
        return creditGroup;
    }

    public void setCreditGroup(String creditGroup) {
        this.creditGroup = creditGroup;
    }

    public String getCreditTag() {
        return creditTag;
    }

    public void setCreditTag(String creditTag) {
        this.creditTag = creditTag;
    }

    public String getCreditOwner() {
        return creditOwner;
    }

    public void setCreditOwner(String creditOwner) {
        this.creditOwner = creditOwner;
    }

    public String getIndustryNo() {
        return industryNo;
    }

    public void setIndustryNo(String industryNo) {
        this.industryNo = industryNo;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

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

    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustOrderUpdateBO{");
        sb.append("creditAmount=").append(creditAmount).append(", ");
        sb.append("creditCount=").append(creditCount).append(", ");
        sb.append("creditRate=").append(creditRate).append(", ");
        sb.append("creditDate=").append(creditDate).append(", ");
        sb.append("creditTime=").append(creditTime).append(", ");
        sb.append("creditFlag=").append(creditFlag).append(", ");
        sb.append("creditRemark=").append(creditRemark).append(", ");
        sb.append("creditSource=").append(creditSource).append(", ");
        sb.append("creditVersion=").append(creditVersion).append(", ");
        sb.append("creditRegion=").append(creditRegion).append(", ");
        sb.append("creditChannel=").append(creditChannel).append(", ");
        sb.append("creditGroup=").append(creditGroup).append(", ");
        sb.append("creditTag=").append(creditTag).append(", ");
        sb.append("creditOwner=").append(creditOwner).append(", ");
        sb.append("industryNo=").append(industryNo).append(", ");
        sb.append("industryName=").append(industryName).append(", ");
        sb.append("industryType=").append(industryType).append(", ");
        sb.append("industryCode=").append(industryCode).append(", ");
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
        sb.append('}');
        return sb.toString();
    }
}
