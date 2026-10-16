package cn.song.jarlib.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 库存实体——**打包进依赖 JAR 的实体**（宿主工程里没有本类的源码）。
 *
 * <p>本类存在的唯一理由：复现「{@code @Entity} / {@code @Embeddable} 全部来自依赖 JAR，
 * 插件拿不到模块根（也就读不到模块自己的 {@code application.yml}）」时的嵌入列命名判定。
 *
 * <p>三个 {@code @Embedded} 字段全部**零注解**（嵌入类内部也不写 {@code @Column} /
 * {@code @AttributeOverride}），列名只能由工程的隐式命名策略推导——这是复现前提。
 *
 * <p>路径与组件路径命名策略（component-path）产物的对应关系见模块 README。
 *
 * @author SongRenShuo
 */
@Entity
@Table(name = "wms_inventory_jar_demo")
public class WmsInventoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 仓库ID——普通列，对照组：不参与嵌入段路径，列名不受命名策略影响 */
    @Column(name = "warehouse_id", length = 32)
    private String warehouseId;

    /** 库存数量（嵌入对象，路径段 qty） */
    @Embedded
    private WmsInventoryQty qty;

    /** SKU（嵌入对象，路径段 sku） */
    @Embedded
    private WmsSku sku;

    /** 物料键（嵌入对象，路径段 itemKey；其内部还有一层 lotInfo 嵌入） */
    @Embedded
    private WmsItemKey itemKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public WmsInventoryQty getQty() {
        return qty;
    }

    public void setQty(WmsInventoryQty qty) {
        this.qty = qty;
    }

    public WmsSku getSku() {
        return sku;
    }

    public void setSku(WmsSku sku) {
        this.sku = sku;
    }

    public WmsItemKey getItemKey() {
        return itemKey;
    }

    public void setItemKey(WmsItemKey itemKey) {
        this.itemKey = itemKey;
    }
}
