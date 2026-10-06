package cn.song.jpademo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 库位实体（WmsLocation，O-111 复现用例配套）。
 *
 * 字段形态对齐用户反馈截图中的 HQL 查询场景：warehouseId/status/zoneId/
 * fullDegree/agvPositionType/putawaySequence，供链式 setParameter 写重预览复现
 * （20261006 计划 20261006-1048 / O-111）。
 *
 * @author SongRenShuo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "wms_location")
public class WmsLocation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 仓库ID
     */
    @Column(name = "warehouse_id", length = 32)
    private Long warehouseId;

    /**
     * 库区ID（join WmsZone 的关联键，普通列 join 形态）
     */
    @Column(name = "zone_id")
    private Long zoneId;

    /**
     * 库位状态（E=空位 等）
     */
    @Column(name = "status", length = 8)
    private String status;

    /**
     * 满盘度（0~N；截图 HQL 以 :emptyFullDegree 绑定 0）
     */
    @Column(name = "full_degree")
    private Integer fullDegree;

    /**
     * AGV 位置类型
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "agv_position_type", length = 16)
    private WmsLocationAGVPositionType agvPositionType;

    /**
     * 上架顺序号（order by putawaySequence asc）
     */
    @Column(name = "putaway_sequence")
    private Integer putawaySequence;
}
