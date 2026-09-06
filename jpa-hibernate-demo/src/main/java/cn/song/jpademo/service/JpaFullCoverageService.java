package cn.song.jpademo.service;

import cn.song.jpademo.entity.LegacyItem;
import cn.song.jpademo.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * JPA/Hibernate 场景全覆盖服务（补齐 JpaQueryService/HibernateTemplateDemoService 未覆盖形态）
 *
 * @author SongRenShuo
 */
public interface JpaFullCoverageService {

    /**
     * EntityManager.createNamedQuery：实体 @NamedQuery 与 hbm <query> 命名查询
     */
    Map<String, Object> queryByNamedQuery(String username, Integer threshold);

    /**
     * EntityManager.createNativeQuery：位置参数 ?1 绑定
     */
    List<Object[]> queryNativePositional(Integer minAge);

    /**
     * EntityManager.createQuery：hbm.xml 实体的 HQL + JOIN 形态
     */
    List<Object[]> queryHqlOnLegacyEntity();

    /**
     * HibernateTemplate.iterate：迭代查询（插件 HIBERNATE_HQL_METHODS 支持）
     */
    List<LegacyItem> iterateLegacyItems(Integer maxQuantity);

    /**
     * 派生查询补充关键字（Not/IsNotNull/NotIn/NotContaining/StartsWith/True）
     */
    Map<String, Object> derivedQueryExt(String fragment);

    /**
     * @Query 补形态：构造器表达式 SELECT NEW dto + createNativeQuery 联动
     */
    Map<String, Object> queryAnnotationExt();
}
