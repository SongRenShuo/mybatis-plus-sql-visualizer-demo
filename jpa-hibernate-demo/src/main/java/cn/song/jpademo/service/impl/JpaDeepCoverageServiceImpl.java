package cn.song.jpademo.service.impl;

import cn.song.jpademo.dto.UserLiteDTO;
import cn.song.jpademo.entity.OrderEntity;
import cn.song.jpademo.entity.UserEntity;
import cn.song.jpademo.repository.UserRepository;
import cn.song.jpademo.service.JpaDeepCoverageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JPA 深水区覆盖服务实现类
 * 语料对照插件 CriteriaQueryLocator 条件/表达式函数全集与 Specification 组合器、@Procedure 渲染
 *
 * @author SongRenShuo
 */
@Service("jpaDeepCoverageService")
public class JpaDeepCoverageServiceImpl implements JpaDeepCoverageService {

    @Resource
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager em;

    /**
     * Criteria EXISTS 子查询：
     * SELECT u FROM UserEntity u WHERE EXISTS (SELECT o.id FROM OrderEntity o
     *   WHERE o.customerId = u.id AND o.totalAmount >= ?)
     */
    @Override
    public List<UserEntity> criteriaExistsSubquery(BigDecimal minAmount) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> root = cq.from(UserEntity.class);

        Subquery<Long> sub = cq.subquery(Long.class);
        Root<OrderEntity> orderRoot = sub.from(OrderEntity.class);
        sub.select(orderRoot.get("id"))
                .where(cb.and(
                        cb.equal(orderRoot.get("customerId"), root.get("id")),
                        cb.ge(orderRoot.get("totalAmount"), minAmount)));
        Predicate exists = cb.exists(sub);
        cq.select(root).where(exists);
        return em.createQuery(cq).getResultList();
    }

    /**
     * Criteria 表达式函数：coalesce / concat / length
     * SELECT u.username, CONCAT(u.username, '(@', u.email, ')'), COALESCE(u.email, 'N/A'), LENGTH(u.username)
     */
    @Override
    public List<Map<String, Object>> criteriaExpressionFunctions() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();
        Root<UserEntity> root = cq.from(UserEntity.class);

        cq.multiselect(
                root.get("username").alias("username"),
                cb.concat(cb.concat(root.get("username"), "(@"),
                        cb.concat(root.get("email"), ")")).alias("displayName"),
                cb.coalesce(root.get("email"), "N/A").alias("emailOrNa"),
                cb.length(root.get("username")).alias("nameLen"));

        List<Map<String, Object>> rows = new ArrayList<>();
        for (Tuple tuple : em.createQuery(cq).getResultList()) {
            Map<String, Object> row = new HashMap<>(4);
            row.put("username", tuple.get("username"));
            row.put("displayName", tuple.get("displayName"));
            row.put("emailOrNa", tuple.get("emailOrNa"));
            row.put("nameLen", tuple.get("nameLen"));
            rows.add(row);
        }
        return rows;
    }

    /**
     * Criteria fetch join：SELECT u FROM UserEntity u LEFT JOIN FETCH u.department WHERE u.status = ?
     */
    @Override
    public List<UserEntity> criteriaFetchJoin(Integer status) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> root = cq.from(UserEntity.class);
        root.fetch("department", javax.persistence.criteria.JoinType.LEFT);
        cq.select(root).where(cb.equal(root.get("status"), status));
        return em.createQuery(cq).getResultList();
    }

    /**
     * Specification 组合器：where / and / or / not
     * where(likeKeyword).and(eqStatus).or(not(geAge))
     */
    @Override
    public List<UserEntity> specificationCombinators(String keyword, Integer status, Integer minAge) {
        org.springframework.data.jpa.domain.Specification<UserEntity> likeKeyword = (root, query, cb) ->
                cb.like(root.get("username"), "%" + keyword + "%");
        org.springframework.data.jpa.domain.Specification<UserEntity> eqStatus = (root, query, cb) ->
                cb.equal(root.get("status"), status);
        org.springframework.data.jpa.domain.Specification<UserEntity> geAge = (root, query, cb) ->
                cb.ge(root.get("age"), minAge);

        org.springframework.data.jpa.domain.Specification<UserEntity> combined =
                org.springframework.data.jpa.domain.Specification.where(likeKeyword)
                        .and(eqStatus)
                        .or(org.springframework.data.jpa.domain.Specification.not(geAge));
        return userRepository.findAll(combined);
    }

    /**
     * @Procedure 存储过程调用（过程由 StoredProcedureConfig 初始化）
     */
    @Override
    @Transactional
    public Integer procedureCountByStatus(Integer status) {
        return userRepository.countUsersByStatusProcedure(status);
    }

    /**
     * @NamedQueries 容器注解命名查询（OrderEntity.findByOrderNoNamed）
     */
    @Override
    public List<?> namedQueryContainer(String orderNo) {
        return em.createNamedQuery("OrderEntity.findByOrderNoNamed", OrderEntity.class)
                .setParameter("orderNo", orderNo)
                .getResultList();
    }

    /**
     * DTO 构造器表达式投影（Tuple 双形态对照）
     */
    @Override
    public List<UserLiteDTO> liteProjection(Integer status) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserLiteDTO> cq = cb.createQuery(UserLiteDTO.class);
        Root<UserEntity> root = cq.from(UserEntity.class);
        Join<UserEntity, Object> deptJoin = root.join("department", javax.persistence.criteria.JoinType.LEFT);
        cq.select(cb.construct(UserLiteDTO.class, root.get("id"), root.get("username")))
                .where(cb.and(
                        cb.equal(root.get("status"), status),
                        cb.isNotNull(deptJoin.get("id"))));
        return em.createQuery(cq).getResultList();
    }
}
