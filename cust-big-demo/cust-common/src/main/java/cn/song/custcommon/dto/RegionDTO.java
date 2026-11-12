package cn.song.custcommon.dto;

import java.io.Serializable;

/**
 * 行政区划。
 */
public class RegionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 区划编码 */
    private String regionCode;

    /** 区划名称 */
    private String regionName;

    /** 上级区划 */
    private String parentCode;

    /** 区划层级 */
    private Integer regionLevel;

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public Integer getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Integer regionLevel) {
        this.regionLevel = regionLevel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RegionDTO{");
        sb.append("regionCode=").append(regionCode).append(", ");
        sb.append("regionName=").append(regionName).append(", ");
        sb.append("parentCode=").append(parentCode).append(", ");
        sb.append("regionLevel=").append(regionLevel).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
