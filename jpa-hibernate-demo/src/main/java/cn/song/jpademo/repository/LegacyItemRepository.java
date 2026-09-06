package cn.song.jpademo.repository;

import cn.song.jpademo.entity.LegacyItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * 遗留库存项 Repository——hbm.xml 映射实体的 Spring Data 派生查询
 * 实体经 spring.jpa.mapping-resources 注册（hbm/LegacyItem.hbm.xml），
 * 插件侧同时验证 DerivedMethodLocator（派生查询）与 HbmXmlEntityResolver（实体→表映射）
 *
 * @author SongRenShuo
 */
public interface LegacyItemRepository extends JpaRepository<LegacyItem, Long> {

    /**
     * findByItemCodeContaining：LIKE %..%
     */
    List<LegacyItem> findByItemCodeContaining(String codeFragment);

    /**
     * findByDeprecatedTrue / findByDeprecatedFalse：布尔 True/False 关键字
     */
    List<LegacyItem> findByDeprecatedTrue();

    List<LegacyItem> findByDeprecatedFalse();

    /**
     * findByQuantityBetween：BETWEEN
     */
    List<LegacyItem> findByQuantityBetween(Integer low, Integer high);

    /**
     * findByItemCodeIn：IN 集合
     */
    List<LegacyItem> findByItemCodeIn(Collection<String> codes);

    /**
     * findTop5ByOrderByQuantityDesc：Top N + 排序
     */
    List<LegacyItem> findTop5ByOrderByQuantityDesc();

    /**
     * findByItemNameNotAndQuantityGreaterThan：AND 组合
     */
    List<LegacyItem> findByItemNameNotAndQuantityGreaterThan(String itemName, Integer minQuantity);

    /**
     * countByDeprecatedFalse / existsByItemCode：聚合形态
     */
    long countByDeprecatedFalse();

    boolean existsByItemCode(String itemCode);
}
