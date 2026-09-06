package cn.song.jpademo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 预约单（WmsAsn）实体，HQL LEFT JOIN 关联目标。
 *
 * 对应反馈 HQL：`left join WmsAsn asn on asn.id = booking.relatedBillId`。
 *
 * @author SongRenShuo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "wms_asn")
public class WmsAsn implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键（join 键）
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 预约单号
     */
    @Column(name = "asn_code", length = 64)
    private String asnCode;

    /**
     * 仓库ID
     */
    @Column(name = "warehouse_id", length = 32)
    private String warehouseId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createdTime;
}