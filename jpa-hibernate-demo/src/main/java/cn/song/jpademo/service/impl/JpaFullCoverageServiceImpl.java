package cn.song.jpademo.service.impl;

import cn.song.jpademo.dto.UserLiteDTO;
import cn.song.jpademo.entity.LegacyItem;
import cn.song.jpademo.entity.UserEntity;
import cn.song.jpademo.repository.LegacyItemRepository;
import cn.song.jpademo.repository.UserRepository;
import cn.song.jpademo.service.JpaFullCoverageService;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * JPA/Hibernate 场景全覆盖服务实现类
 *
 * @author SongRenShuo
 */
@Service
public class JpaFullCoverageServiceImpl implements JpaFullCoverageService {

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private HibernateTemplate hibernateTemplate;

    @Resource
    private UserRepository userRepository;

    @Resource
    private LegacyItemRepository legacyItemRepository;

    /**
     * createNamedQuery：实体 @NamedQuery（UserEntity.*）与 hbm &lt;query&gt;（LegacyItem.*）
     */
    @Override
    public Map<String, Object> queryByNamedQuery(String username, Integer threshold) {
        Map<String, Object> result = new HashMap<>();
        List<UserEntity> users = entityManager
                .createNamedQuery("UserEntity.findByUsernameNamed", UserEntity.class)
                .setParameter("username", username)
                .getResultList();
        result.put("users", users);

        List<LegacyItem> items = entityManager
                .createNamedQuery("LegacyItem.findLowStockHql", LegacyItem.class)
                .setParameter("threshold", threshold)
                .getResultList();
        result.put("legacyItems", items);
        return result;
    }

    /**
     * createNativeQuery：位置参数 ?1 绑定（列元组投影）
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Object[]> queryNativePositional(Integer minAge) {
        return entityManager
                .createNativeQuery("SELECT id, username, age FROM user WHERE age >= ?1 ORDER BY age")
                .setParameter(1, minAge)
                .getResultList();
    }

    /**
     * createQuery：hbm.xml 实体的 HQL（实体名与列名由 LegacyItem.hbm.xml 解析）
     */
    @Override
    public List<Object[]> queryHqlOnLegacyEntity() {
        return entityManager
                .createQuery("SELECT li.itemCode, li.quantity FROM LegacyItem li "
                        + "WHERE li.deprecated = false AND li.quantity >= 10", Object[].class)
                .getResultList();
    }

    /**
     * HibernateTemplate.iterate：迭代查询（懒加载代理，逐条取值）。
     * 注意：HibernateTemplate.iterate(String, Object...) 变长重载是 0 起步的位置绑定
     * （javap 实证无名字数组重载），命名参数 :maxQ 会抛
     * "Could not locate ordinal parameter [0]"；这里改用 executeWithNativeSession 回调，
     * 方法加 @Transactional 使回调复用 Jpa 事务的当前 Session（iterate 游标需在会话关闭前消费完）。
     */
    @Override
    @Transactional(readOnly = true)
    public List<LegacyItem> iterateLegacyItems(Integer maxQuantity) {
        Iterator<LegacyItem> iterator = hibernateTemplate.executeWithNativeSession(
                (org.springframework.orm.hibernate5.HibernateCallback<Iterator<LegacyItem>>) session -> {
                    org.hibernate.query.Query<LegacyItem> query = session.createQuery(
                            "FROM LegacyItem li WHERE li.quantity < :maxQ ORDER BY li.id", LegacyItem.class);
                    query.setParameter("maxQ", maxQuantity);
                    return query.iterate();
                });
        List<LegacyItem> items = new ArrayList<>();
        while (iterator.hasNext()) {
            LegacyItem item = iterator.next();
            // iterate 只回读主键形成 ByteBuddy 懒代理：须在会话内先初始化并解包成真实实体
            // （代理类本身 Jackson 无法序列化，抛 Type definition error: ByteBuddyInterceptor）
            org.hibernate.Hibernate.initialize(item);
            items.add(org.hibernate.Hibernate.unproxy(item, LegacyItem.class));
        }
        return items;
    }

    /**
     * 派生查询补充关键字：Not/IsNotNull/NotIn/NotContaining/StartsWith/True/False
     */
    @Override
    public Map<String, Object> derivedQueryExt(String fragment) {
        Map<String, Object> result = new HashMap<>();
        result.put("statusNot", userRepository.findByStatusNot(0));
        result.put("emailNotNull", userRepository.findByEmailIsNotNull());
        result.put("ageNotIn", userRepository.findByAgeNotIn(java.util.Arrays.asList(10, 20)));
        result.put("lastNameNotContaining", userRepository.findByLastNameNotContaining(fragment));
        result.put("usernameStartsWith", userRepository.findByUsernameStartsWith(fragment));
        result.put("countByLastNameAndAge", userRepository.countByLastNameAndAgeLessThan("王", 60));

        result.put("deprecatedTrue", legacyItemRepository.findByDeprecatedTrue());
        result.put("deprecatedFalse", legacyItemRepository.findByDeprecatedFalse());
        result.put("itemCodeContaining", legacyItemRepository.findByItemCodeContaining(fragment));
        result.put("quantityBetween", legacyItemRepository.findByQuantityBetween(1, 500));
        result.put("top5", legacyItemRepository.findTop5ByOrderByQuantityDesc());
        result.put("countActive", legacyItemRepository.countByDeprecatedFalse());
        result.put("existsByCode", legacyItemRepository.existsByItemCode(fragment));
        return result;
    }

    /**
     * @Query 补形态：构造器表达式 SELECT NEW dto
     */
    @Override
    public Map<String, Object> queryAnnotationExt() {
        Map<String, Object> result = new HashMap<>();
        List<UserLiteDTO> lite = userRepository.findLiteByStatus(1);
        result.put("liteUsers", lite);
        result.put("nativeTuples", queryNativePositional(18));
        return result;
    }
}
