package cn.song.jarlib.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * SKU（嵌入对象，随实体一起打包进 JAR）。
 *
 * <p>**故意不写 @Column / @AttributeOverride**：component-path 下 {@code sku.inventoryStatus}
 * 的真实列是 {@code sku_inventory_status}。
 *
 * @author SongRenShuo
 */
@Embeddable
public class WmsSku implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 库存状态 */
    private String inventoryStatus;

    public String getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(String inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }
}
