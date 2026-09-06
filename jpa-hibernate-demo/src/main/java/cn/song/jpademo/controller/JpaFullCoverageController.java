package cn.song.jpademo.controller;

import cn.song.jpademo.entity.LegacyItem;
import cn.song.jpademo.service.JpaFullCoverageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
}
