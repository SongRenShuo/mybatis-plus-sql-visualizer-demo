package cn.song.jpademo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 入库预约单实体（WmsDockBooking）。
 *
 * 字段形态对齐用户反馈截图中的 HQL 统计场景：status/type/warehouseId/
 * arrivalTime/initialETA/latestETA/ATD + 内嵌 updateInfo.createdTime，
 * 供 HQL 自定义 DAO 预览（findByQueryUniqueResult / findByQuery / execute）验证。
 *
 * @author SongRenShuo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "wms_dock_booking")
public class WmsDockBooking implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 关联单据ID（LEFT JOIN WmsAsn 的关联键）
     */
    @Column(name = "related_bill_id")
    private Long relatedBillId;

    /**
     * 仓库ID
     */
    @Column(name = "warehouse_id", length = 32)
    private String warehouseId;

    /**
     * 状态（F=已完成 P=进行中）
     */
    @Column(name = "status", length = 8)
    private String status;

    /**
     * 类型（R=入库）
     */
    @Column(name = "type", length = 8)
    private String type;

    /**
     * 到达时间
     */
    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    /**
     * 初始预计到达时间
     */
    @Column(name = "initial_eta")
    private LocalDateTime initialETA;

    /**
     * 最新预计到达时间
     */
    @Column(name = "latest_eta")
    private LocalDateTime latestETA;

    /**
     * 实际发车时间
     */
    @Column(name = "atd")
    private LocalDateTime ATD;

    /**
     * 更新信息（内嵌对象，HQL 用 booking.updateInfo.createdTime 访问）
     */
    @Embedded
    private UpdateInfo updateInfo = new UpdateInfo();
}