package cn.song.jpademo.entity;

import java.time.LocalDateTime;

/**
 * 遗留库存项（LegacyItem）——hbm.xml 映射演示实体
 * 无 JPA 注解，纯 POJO，由 resources/hbm/LegacyItem.hbm.xml 提供映射
 * （插件 HbmXmlEntityResolver 识别场景）
 *
 * @author SongRenShuo
 */
public class LegacyItem {

    private Long id;

    /**
     * 物料编码
     */
    private String itemCode;

    /**
     * 物料名称
     */
    private String itemName;

    /**
     * 库存数量
     */
    private Integer quantity;

    /**
     * 是否已废弃（派生查询 findByDeprecatedTrue 用）
     */
    private Boolean deprecated;

    /**
     * 入库时间
     */
    private LocalDateTime inTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getDeprecated() {
        return deprecated;
    }

    public void setDeprecated(Boolean deprecated) {
        this.deprecated = deprecated;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }

    public void setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }
}
