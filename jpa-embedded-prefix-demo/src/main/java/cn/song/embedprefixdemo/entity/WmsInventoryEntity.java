package cn.song.embedprefixdemo.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 库存实体（WmsInventory 精简版）——@Embedded 嵌入列前缀复现载体。
 *
 * 字段形态对齐用户报障截图：`@Embedded WmsMoveTool moveTool` / `@Embedded WmsInventoryQty qty`，
 * 配合 HQL `inv.moveTool.palletNo` / `inv.qty.baseQty`。
 *
 * 命名策略为 component-path（见 application.yml），故真库列名为
 * `move_tool_pallet_no` / `qty_base_qty` —— 嵌入对象与内层字段上都**没有**任何
 * @Column/@AttributeOverride，列名完全由策略推导，这是复现的关键前提。
 *
 * @author SongRenShuo
 */
@Entity
@Table(name = "wms_inventory_embed_demo")
public class WmsInventoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 仓库ID——普通列，对照组：不参与嵌入段路径，列名不受命名策略影响 */
    @Column(name = "warehouse_id", length = 32)
    private String warehouseId;

    /** 移动器具（嵌入对象，列名前缀 move_tool_） */
    @Embedded
    private WmsMoveTool moveTool;

    /** 库存数量（嵌入对象，列名前缀 qty_） */
    @Embedded
    private WmsInventoryQty qty;

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

    public WmsMoveTool getMoveTool() {
        return moveTool;
    }

    public void setMoveTool(WmsMoveTool moveTool) {
        this.moveTool = moveTool;
    }

    public WmsInventoryQty getQty() {
        return qty;
    }

    public void setQty(WmsInventoryQty qty) {
        this.qty = qty;
    }
}
