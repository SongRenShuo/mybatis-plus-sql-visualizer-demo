package cn.song.jpademo.service.impl;

import cn.song.jpademo.entity.DepartmentEntity;
import cn.song.jpademo.entity.UserEntity;
import cn.song.jpademo.repository.UserRepository;
import cn.song.jpademo.service.JpaQueryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JPA + Hibernate 查询服务实现类
 * 集中编写 CriteriaQuery / HQL / 原生 SQL 调用链，供插件预览 SQL
 *
 * @author SongRenShuo
 */
@Service("jpaQueryService")
public class JpaQueryServiceImpl implements JpaQueryService {

    @PersistenceContext
    private EntityManager entityManager;

    private final UserRepository userRepository;
    private final SessionFactory sessionFactory;

    public JpaQueryServiceImpl(UserRepository userRepository, SessionFactory sessionFactory) {
        this.userRepository = userRepository;
        this.sessionFactory = sessionFactory;
    }

    // ------------------------------------------------------------------
    // 派生查询
    // ------------------------------------------------------------------

    /**
     * 派生查询组合：findByLastNameAndFirstName + findByAgeGreaterThan
     */
    @Override
    public List<UserEntity> derivedQuery(String lastName, Integer minAge, Integer status) {
        List<UserEntity> byName = userRepository.findByLastNameAndFirstName(lastName, "张");
        List<UserEntity> byAge = userRepository.findByAgeGreaterThan(minAge);
        return userRepository.findByStatusOrderByIdDesc(status);
    }

    // ------------------------------------------------------------------
    // JPQL（EntityManager）
    // ------------------------------------------------------------------

    /**
     * JPQL 命名参数 / 位置参数
     */
    @Override
    public List<UserEntity> jpqlQuery(String username, Integer minAge) {
        javax.persistence.Query named = entityManager.createQuery(
                "SELECT u FROM UserEntity u WHERE u.username = :username")
                .setParameter("username", username);
        javax.persistence.Query positional = entityManager.createQuery(
                "SELECT u FROM UserEntity u WHERE u.username = ?1 AND u.age >= ?2")
                .setParameter(1, username)
                .setParameter(2, minAge);
        return named.getResultList();
    }

    /**
     * JPQL JOIN FETCH
     */
    @Override
    public List<UserEntity> jpqlJoinFetch(String deptName) {
        javax.persistence.Query query = entityManager.createQuery(
                "SELECT u FROM UserEntity u JOIN FETCH u.department d WHERE d.name = :deptName")
                .setParameter("deptName", deptName);
        return query.getResultList();
    }

    // ------------------------------------------------------------------
    // CriteriaQuery
    // ------------------------------------------------------------------

    /**
     * CriteriaQuery 基础条件：eq/ne/gt/ge/lt/le
     */
    @Override
    public List<UserEntity> criteriaBasic(Integer minAge, Integer status) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> root = cq.from(UserEntity.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.greaterThanOrEqualTo(root.get("age"), minAge));
        predicates.add(cb.lessThan(root.get("age"), 100));
        predicates.add(cb.equal(root.get("status"), status));
        predicates.add(cb.notEqual(root.get("firstName"), "测试"));

        cq.where(predicates.toArray(new Predicate[0]));
        cq.orderBy(cb.desc(root.get("id")));
        return entityManager.createQuery(cq).getResultList();
    }

    /**
     * CriteriaQuery 组合条件：and/or/not/between/in/like/isNull
     */
    @Override
    public List<UserEntity> criteriaGrouped(String username, Integer ageStart, Integer ageEnd, List<Integer> statuses) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> root = cq.from(UserEntity.class);

        Predicate nameLike = cb.like(root.get("username"), "%" + username + "%");
        Predicate ageBetween = cb.between(root.get("age"), ageStart, ageEnd);
        Predicate statusIn = cb.in(root.get("status")).value(statuses);
        Predicate emailNull = cb.isNull(root.get("email"));
        Predicate notGroup = cb.not(cb.equal(root.get("status"), 0));

        cq.where(cb.and(nameLike, cb.or(ageBetween, statusIn), cb.and(emailNull, notGroup)));
        cq.orderBy(cb.asc(root.get("createTime")));
        return entityManager.createQuery(cq).getResultList();
    }

    /**
     * CriteriaQuery JOIN 查询
     */
    @Override
    public List<UserEntity> criteriaJoin(String deptName, Integer status) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> root = cq.from(UserEntity.class);
        Join<Object, Object> deptJoin = root.join("department", JoinType.INNER);

        cq.where(cb.and(
                cb.equal(deptJoin.get("name"), deptName),
                cb.equal(root.get("status"), status)));
        cq.orderBy(cb.desc(deptJoin.get("id")));
        return entityManager.createQuery(cq).getResultList();
    }

    /**
     * CriteriaQuery 聚合：COUNT + groupBy + having
     */
    @Override
    public List<Object[]> criteriaAggregate() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<UserEntity> root = cq.from(UserEntity.class);

        cq.multiselect(
                root.get("status"),
                cb.count(root.get("id")),
                cb.max(root.get("age")),
                cb.sum(root.get("age")));
        cq.groupBy(root.get("status"));
        cq.having(cb.gt(cb.count(root.get("id")), 1L));
        return entityManager.createQuery(cq).getResultList();
    }

    /**
     * CriteriaQuery 动态排序 + 分页
     */
    @Override
    public List<UserEntity> criteriaPaged(Integer status, Integer limit) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> root = cq.from(UserEntity.class);

        cq.where(cb.equal(root.get("status"), status));
        cq.orderBy(cb.asc(root.get("createTime")), cb.desc(root.get("id")));
        return entityManager.createQuery(cq)
                .setFirstResult(0)
                .setMaxResults(limit)
                .getResultList();
    }

    // ------------------------------------------------------------------
    // Hibernate HQL（Session）
    // ------------------------------------------------------------------

    /**
     * Hibernate HQL 命名参数
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> hibernateHql(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<UserEntity> query = session.createQuery(
                "SELECT u FROM UserEntity u WHERE u.username = :username", UserEntity.class);
        query.setParameter("username", username);
        return query.getResultList();
    }

    /**
     * Hibernate HQL JOIN FETCH + 位置参数
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> hibernateHqlJoinFetch(String deptName, Integer status) {
        Session session = sessionFactory.getCurrentSession();
        Query<UserEntity> query = session.createQuery(
                "SELECT u FROM UserEntity u JOIN FETCH u.department d WHERE d.name = ?1 AND u.status = ?2",
                UserEntity.class);
        query.setParameter(1, deptName);
        query.setParameter(2, status);
        return query.getResultList();
    }

    /**
     * Hibernate HQL 聚合查询
     */
    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> hibernateHqlAggregate(Integer status) {
        Session session = sessionFactory.getCurrentSession();
        Query<Object[]> query = session.createQuery(
                "SELECT COUNT(u), MAX(u.age), AVG(u.age) FROM UserEntity u WHERE u.status = :status",
                Object[].class);
        query.setParameter("status", status);
        Object[] row = query.uniqueResult();
        Map<String, Object> result = new HashMap<>();
        result.put("count", row[0]);
        result.put("maxAge", row[1]);
        result.put("avgAge", row[2]);
        return result;
    }

    /**
     * Hibernate HQL 更新（executeUpdate）
     */
    @Override
    @Transactional
    public int hibernateHqlUpdate(Integer oldStatus, Integer newStatus) {
        Session session = sessionFactory.getCurrentSession();
        Query<?> query = session.createQuery(
                "UPDATE UserEntity u SET u.status = :newStatus WHERE u.status = :oldStatus");
        query.setParameter("newStatus", newStatus);
        query.setParameter("oldStatus", oldStatus);
        return query.executeUpdate();
    }

    // ------------------------------------------------------------------
    // 其它
    // ------------------------------------------------------------------

    /**
     * 订单统计：JPQL NEW DTO 构造表达式
     */
    @Override
    public List<Object[]> orderStat() {
        javax.persistence.Query query = entityManager.createQuery(
                "SELECT NEW cn.song.jpademo.dto.OrderStatDTO(o.customerId, COUNT(o), SUM(o.totalAmount)) " +
                        "FROM OrderEntity o GROUP BY o.customerId HAVING COUNT(o) > 1");
        return query.getResultList();
    }

    /**
     * 原生 SQL 查询
     */
    @Override
    public List<UserEntity> nativeQuery(String keyword, Integer status) {
        javax.persistence.Query query = entityManager.createNativeQuery(
                "SELECT * FROM user WHERE username LIKE CONCAT('%', :keyword, '%') AND status = :status",
                UserEntity.class);
        query.setParameter("keyword", keyword);
        query.setParameter("status", status);
        return query.getResultList();
    }

    /**
     * 部门 + 用户 一对多 JOIN（CriteriaQuery Tuple）
     */
    @Override
    public List<DepartmentEntity> departmentWithUsers() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DepartmentEntity> cq = cb.createQuery(DepartmentEntity.class);
        Root<DepartmentEntity> root = cq.from(DepartmentEntity.class);

        cq.where(cb.greaterThan(root.get("id"), 0L));
        cq.orderBy(cb.asc(root.get("id")));
        return entityManager.createQuery(cq).getResultList();
    }

    // ------------------------------------------------------------------
    // 扩展用例：Specification / Criteria 子查询·on·case·Tuple / HQL 更多
    // ------------------------------------------------------------------

    /**
     * JPA Specification 动态查询（JpaSpecificationExecutor.findAll）
     * 动态拼装 eq/like/ge/isNull 条件
     */
    @Override
    public List<UserEntity> specificationQuery(String username, Integer minAge, Integer status, Boolean emailNull) {
        org.springframework.data.jpa.domain.Specification<UserEntity> spec = (root, query, cb) -> {
            java.util.List<javax.persistence.criteria.Predicate> predicates = new java.util.ArrayList<>();
            if (username != null && !username.isEmpty()) {
                predicates.add(cb.like(root.get("username"), "%" + username + "%"));
            }
            if (minAge != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("age"), minAge));
            }
            if (status != null) {
                predicates.add(cb.equal(root.get("status"), status));
            }
            if (Boolean.TRUE.equals(emailNull)) {
                predicates.add(cb.isNull(root.get("email")));
            }
            return cb.and(predicates.toArray(new javax.persistence.criteria.Predicate[0]));
        };
        return userRepository.findAll(spec);
    }

    /**
     * Criteria 子查询（Subquery + IN）：
     * WHERE u.id IN (SELECT o.customerId FROM OrderEntity o WHERE o.totalAmount >= :min)
     */
    @Override
    public List<UserEntity> criteriaSubquery(String deptName, Integer minAmount) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> root = cq.from(UserEntity.class);

        javax.persistence.criteria.Subquery<Long> sub = cq.subquery(Long.class);
        javax.persistence.criteria.Root<cn.song.jpademo.entity.OrderEntity> subRoot = sub.from(cn.song.jpademo.entity.OrderEntity.class);
        sub.select(subRoot.get("customerId"));
        sub.where(cb.greaterThan(subRoot.get("totalAmount"), minAmount));

        cq.where(cb.in(root.get("id")).value(sub));
        cq.orderBy(cb.asc(root.get("id")));
        return entityManager.createQuery(cq).getResultList();
    }

    /**
     * Criteria join on 条件（显式 ON）+ left join + 关联表条件
     */
    @Override
    public List<UserEntity> criteriaJoinOn(String deptName, Integer status) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> root = cq.from(UserEntity.class);
        javax.persistence.criteria.Join<Object, Object> deptJoin = root.join("department", javax.persistence.criteria.JoinType.LEFT);
        // 显式 ON 条件：d.name = deptName
        deptJoin.on(cb.equal(deptJoin.get("name"), deptName));

        cq.where(cb.and(
                cb.equal(root.get("status"), status),
                cb.isNotNull(deptJoin.get("id"))));
        cq.orderBy(cb.desc(deptJoin.get("id")));
        return entityManager.createQuery(cq).getResultList();
    }

    /**
     * Criteria CASE 表达式：按年龄分段返回标签（CASE WHEN ... THEN ... ELSE）
     */
    @Override
    public List<Object[]> criteriaCase(Integer minAge) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<UserEntity> root = cq.from(UserEntity.class);

        javax.persistence.criteria.Expression<String> ageLevel = cb.<String>selectCase()
                .when(cb.lessThan(root.get("age"), 18), "未成年")
                .when(cb.lessThan(root.get("age"), 30), "青年")
                .otherwise("中年以上");

        cq.multiselect(root.get("username"), root.get("age"), ageLevel);
        cq.where(cb.greaterThanOrEqualTo(root.get("age"), minAge));
        cq.orderBy(cb.asc(root.get("age")));
        return entityManager.createQuery(cq).getResultList();
    }

    /**
     * Criteria Tuple 多列查询（root 字段 + join 字段）
     */
    @Override
    public List<javax.persistence.Tuple> criteriaTuple(Integer status) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<javax.persistence.Tuple> cq = cb.createTupleQuery();
        Root<UserEntity> root = cq.from(UserEntity.class);
        javax.persistence.criteria.Join<Object, Object> deptJoin = root.join("department", javax.persistence.criteria.JoinType.LEFT);

        cq.multiselect(
                root.get("id"),
                root.get("username"),
                root.get("age"),
                deptJoin.get("name"),
                deptJoin.get("code"));
        cq.where(cb.equal(root.get("status"), status));
        cq.orderBy(cb.asc(root.get("id")));
        return entityManager.createQuery(cq).getResultList();
    }

    /**
     * HQL 更多：DISTINCT / IN / LIKE / BETWEEN
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> hqlMore(List<Integer> statuses, Integer minAge, Integer maxAge, String keyword) {
        Session session = sessionFactory.getCurrentSession();
        org.hibernate.query.Query<UserEntity> query = session.createQuery(
                "SELECT DISTINCT u FROM UserEntity u WHERE u.status IN :statuses " +
                        "AND u.age BETWEEN :minAge AND :maxAge " +
                        "AND u.username LIKE CONCAT('%', :keyword, '%') " +
                        "ORDER BY u.id",
                UserEntity.class);
        query.setParameter("statuses", statuses);
        query.setParameter("minAge", minAge);
        query.setParameter("maxAge", maxAge);
        query.setParameter("keyword", keyword);
        return query.getResultList();
    }

    /**
     * HQL 子查询（EXISTS）：WHERE EXISTS (SELECT o FROM OrderEntity o WHERE o.customerId = u.id AND o.totalAmount >= :min)
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> hqlExistsSubquery(java.math.BigDecimal minAmount) {
        Session session = sessionFactory.getCurrentSession();
        org.hibernate.query.Query<UserEntity> query = session.createQuery(
                "SELECT u FROM UserEntity u WHERE EXISTS " +
                        "(SELECT o FROM OrderEntity o WHERE o.customerId = u.id AND o.totalAmount >= :minAmount)",
                UserEntity.class);
        query.setParameter("minAmount", minAmount);
        return query.getResultList();
    }

    /**
     * HQL LEFT JOIN FETCH 集合 + distinct
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> hqlJoinFetchDistinct(String deptName) {
        Session session = sessionFactory.getCurrentSession();
        org.hibernate.query.Query<UserEntity> query = session.createQuery(
                "SELECT DISTINCT u FROM UserEntity u LEFT JOIN FETCH u.department d WHERE d.name = :deptName",
                UserEntity.class);
        query.setParameter("deptName", deptName);
        return query.getResultList();
    }

    /**
     * 派生查询分页 + Sort（Pageable 排序）
     */
    @Override
    public org.springframework.data.domain.Page<UserEntity> derivedPaged(Integer status, int page, int size, String sortField) {
        org.springframework.data.domain.Sort sort = org.springframework.data.domain.Sort.by(
                org.springframework.data.domain.Sort.Direction.DESC, sortField);
        org.springframework.data.domain.Pageable pageable = org.springframework.data.domain.PageRequest.of(page, size, sort);
        return userRepository.findByStatus(status, pageable);
    }
}
