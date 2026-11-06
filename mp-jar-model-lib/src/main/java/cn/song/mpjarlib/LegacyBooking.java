package cn.song.mpjarlib;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/** 类名不能推导表名；referenceCode 不能按驼峰推导列名。 */
@TableName("ui_reservation_ledger")
public class LegacyBooking {
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("booking_code")
    private String referenceCode;

    private Integer stateCode;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReferenceCode() { return referenceCode; }
    public void setReferenceCode(String referenceCode) { this.referenceCode = referenceCode; }
    public Integer getStateCode() { return stateCode; }
    public void setStateCode(Integer stateCode) { this.stateCode = stateCode; }
}
