package cn.song.jpademo.controller;

import cn.song.jpademo.entity.LegacyItem;
import cn.song.jpademo.service.JpaFullCoverageService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * JPA/Hibernate 场景全覆盖演示控制器
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/jpa/full")
public class JpaFullCoverageController {

    @Resource
    private JpaFullCoverageService jpaFullCoverageService;

    /**
     * createNamedQuery（实体 @NamedQuery + hbm &lt;query&gt;）
     */
    @GetMapping("/named")
    public Map<String, Object> named(String username, Integer threshold) {
        return jpaFullCoverageService.queryByNamedQuery(username, threshold);
    }

    /**
     * createNativeQuery 位置参数
     */
    @GetMapping("/native")
    public List<Object[]> nativeQuery(Integer minAge) {
        return jpaFullCoverageService.queryNativePositional(minAge);
    }

    /**
     * hbm 实体 HQL
     */
    @GetMapping("/hqlLegacy")
    public List<Object[]> hqlLegacy() {
        return jpaFullCoverageService.queryHqlOnLegacyEntity();
    }

    /**
     * HibernateTemplate.iterate
     */
    @GetMapping("/iterate")
    public List<LegacyItem> iterate(Integer maxQuantity) {
        return jpaFullCoverageService.iterateLegacyItems(maxQuantity);
    }

    /**
     * 派生查询补充关键字
     */
    @GetMapping("/derivedExt")
    public Map<String, Object> derivedExt(String fragment) {
        return jpaFullCoverageService.derivedQueryExt(fragment);
    }

    /**
     * @Query 构造器表达式
     */
    @GetMapping("/lite")
    public Map<String, Object> lite() {
        return jpaFullCoverageService.queryAnnotationExt();
    }

    /**
     * @Embedded 嵌入段派生查询（属性路径穿透内嵌对象）
     * GET /jpa/full/derivedEmbedded?time=2026-01-01T00:00:00
     */
    @GetMapping("/derivedEmbedded")
    public Map<String, Object> derivedEmbedded(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime time) {
        return jpaFullCoverageService.derivedQueryEmbedded(
                time == null ? LocalDateTime.now().minusDays(1) : time);
    }

    /**
     * @Query SELECT 投影 + ORDER BY 嵌入段路径
     * GET /jpa/full/queryEmbedded?warehouseId=WH001
     */
    @GetMapping("/queryEmbedded")
    public List<LocalDateTime> queryEmbedded(
            @RequestParam(defaultValue = "WH001") String warehouseId) {
        return jpaFullCoverageService.queryAnnotationEmbedded(warehouseId);
    }
}
