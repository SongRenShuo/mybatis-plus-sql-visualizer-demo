package cn.song.jpademo.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Embedded;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 嵌套嵌入深水区实体（T-Embedded G1/G2 语料）。
 *
 * <p>列名口径（插件预期，逐字段）：
 * <ul>
 *   <li>address（两级嵌入 + 点路径覆写）：cust_street（类级根点路径 address.street）、
 *       cust_zip（字段级相对点路径 zipcode.zip，规范例 2 形态）、area_code（嵌套裸列兜底）；</li>
 *   <li>bizAddress（SD 桩 @Embedded(prefix="biz_")）：biz_street / biz_zip / biz_area_code
 *       ——prefix 拼在每一列之前；JPA 侧同口径 @AttributeOverrides 仅为 Hibernate 运行期防撞列；</li>
 *   <li>contactInfo（SD 桩 @Embedded.Nullable 捷径）：created_time（无 prefix）；</li>
 *   <li>fallbackZip（SD 桩 @Embedded.Empty 捷径）：zip / area_code。</li>
 * </ul>
 *
 * @author SongRenShuo
 */
@Data
@Entity
@Table(name = "customer")
@AttributeOverride(name = "address.street", column = @Column(name = "cust_street"))
public class CustomerEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 两级嵌入：字段级相对点路径覆写 zipcode.zip → cust_zip（G2 修复点）
     */
    @javax.persistence.Embedded
    @AttributeOverride(name = "zipcode.zip", column = @Column(name = "cust_zip"))
    private Address address;

    /**
     * 同型值对象二次嵌入 + SD prefix 防撞（G1）：SD 桩 prefix=biz_ 生效于插件侧；
     * JPA 侧 @AttributeOverrides 同口径，保证 Hibernate 运行期两套 Address 列不撞
     */
    @Embedded(prefix = "biz_")
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "biz_street")),
            @AttributeOverride(name = "zipcode.zip", column = @Column(name = "biz_zip")),
            @AttributeOverride(name = "zipcode.areaCode", column = @Column(name = "biz_area_code"))
    })
    private Address bizAddress;

    /**
     * SD 捷径注解 @Embedded.Nullable（G1）：全列为 null 时整体为 null；无 prefix
     */
    @Embedded.Nullable
    private UpdateInfo contactInfo;

    /**
     * SD 捷径注解 @Embedded.Empty（G1）：全列为 null 时整体为空对象；无 prefix。
     * JPA 侧覆写 areaCode 防与 address 嵌套列 area_code 相撞
     */
    @Embedded.Empty
    @AttributeOverride(name = "areaCode", column = @Column(name = "fallback_area_code"))
    private Zipcode fallbackZip;
}
