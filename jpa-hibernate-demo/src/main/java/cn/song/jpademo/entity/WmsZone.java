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

/**
 * 库区实体（WmsZone，O-111 复现用例配套）。
 *
 * 字段形态对齐用户反馈截图中的 HQL join 场景：
 * `join WmsZone zone on zone.id = location.zoneId where zone.code = :zoneCode`。
 *
 * @author SongRenShuo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "wms_zone")
public class WmsZone implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 库区编码（截图场景值形态 KQ13）
     */
    @Column(name = "code", length = 32)
    private String code;

    /**
     * 库区名称
     */
    @Column(name = "name", length = 64)
    private String name;
}
