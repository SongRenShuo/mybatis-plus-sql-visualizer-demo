package cn.song.jarlib.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 库存数量（嵌入对象，随实体一起打包进 JAR）。
 *
 * <p>**故意不写 @Column / @AttributeOverride**：列名由 Hibernate 命名策略推导。
 * component-path 下 {@code qty.baseQty} 的真实列是 {@code qty_base_qty}（而不是 {@code base_qty}）。
 *
 * @author SongRenShuo
 */
@Embeddable
public class WmsInventoryQty implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 基础数量 */
    private Long baseQty;

    public Long getBaseQty() {
        return baseQty;
    }

    public void setBaseQty(Long baseQty) {
        this.baseQty = baseQty;
    }
}
