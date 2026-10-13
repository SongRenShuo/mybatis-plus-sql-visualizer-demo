package cn.song.embedprefixdemo.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 库存数量（嵌入对象）。
 *
 * **故意不写 @Column / @AttributeOverride**：列名由 Hibernate 命名策略推导。
 * component-path 下 `qty.baseQty` 的真实列是 `qty_base_qty`（而不是 `base_qty`）——
 * 插件预览此前丢的就是 `qty_` 这一段前缀。
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
