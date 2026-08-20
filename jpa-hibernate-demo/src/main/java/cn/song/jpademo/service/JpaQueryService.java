package cn.song.jpademo.service;

import cn.song.jpademo.entity.DepartmentEntity;
import cn.song.jpademo.entity.OrderEntity;
import cn.song.jpademo.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * JPA + Hibernate 查询服务层
 *
 * @author SongRenShuo
 */
public interface JpaQueryService {

    /**
     * 派生查询组合（Repository 层已声明，此处展示调用链）
     */
    List<UserEntity> derivedQuery(String lastName, Integer minAge, Integer status);

    /**
     * JPQL 命名参数 / 位置参数查询
     */
    List<UserEntity> jpqlQuery(String username, Integer minAge);

    /**
     * JPQL JOIN FETCH 查询
     */
    List<UserEntity> jpqlJoinFetch(String deptName);

    /**
     * CriteriaQuery 基础条件：eq/ne/gt/ge/lt/le
     */
    List<UserEntity> criteriaBasic(Integer minAge, Integer status);

    /**
     * CriteriaQuery 组合条件：and/or/not/between/in/like/isNull
     */
    List<UserEntity> criteriaGrouped(String username, Integer ageStart, Integer ageEnd, List<Integer> statuses);

    /**
     * CriteriaQuery JOIN 查询
     */
    List<UserEntity> criteriaJoin(String deptName, Integer status);

    /**
     * CriteriaQuery 聚合（COUNT / SUM）+ groupBy + having
     */
    List<Object[]> criteriaAggregate();

    /**
     * CriteriaQuery 动态排序 + 分页（setFirstResult/setMaxResults）
     */
    List<UserEntity> criteriaPaged(Integer status, Integer limit);

    /**
     * Hibernate HQL（Session.createQuery）命名参数
     */
    List<UserEntity> hibernateHql(String username);

    /**
     * Hibernate HQL JOIN FETCH + 位置参数
     */
    List<UserEntity> hibernateHqlJoinFetch(String deptName, Integer status);

    /**
     * Hibernate HQL 聚合查询
     */
    Map<String, Object> hibernateHqlAggregate(Integer status);

    /**
     * Hibernate HQL 更新（executeUpdate）
     */
    int hibernateHqlUpdate(Integer oldStatus, Integer newStatus);

    /**
     * 订单 JPQL NEW DTO 构造表达式查询
     */
    List<Object[]> orderStat();

    /**
     * 原生 SQL 查询（EntityManager.createNativeQuery）
     */
    List<UserEntity> nativeQuery(String keyword, Integer status);

    /**
     * 关联查询：部门 + 用户（一对多 JOIN）
     */
    List<DepartmentEntity> departmentWithUsers();

    // ------------------------------------------------------------------
    // 扩展用例：Specification / Criteria 子查询·on·case·Tuple / HQL 更多
    // ------------------------------------------------------------------

    /**
     * JPA Specification 动态查询（JpaSpecificationExecutor）
     */
    List<UserEntity> specificationQuery(String username, Integer minAge, Integer status, Boolean emailNull);

    /**
     * Criteria 子查询（Subquery + IN）
     */
    List<UserEntity> criteriaSubquery(String deptName, Integer minAmount);

    /**
     * Criteria join on 条件（显式 ON）+ left join
     */
    List<UserEntity> criteriaJoinOn(String deptName, Integer status);

    /**
     * Criteria CASE 表达式 + 返回 Object[]
     */
    List<Object[]> criteriaCase(Integer minAge);

    /**
     * Criteria Tuple 多列查询（root 字段 + join 字段）
     */
    List<javax.persistence.Tuple> criteriaTuple(Integer status);

    /**
     * HQL 更多：DISTINCT / IN / LIKE / BETWEEN / 子查询
     */
    List<UserEntity> hqlMore(List<Integer> statuses, Integer minAge, Integer maxAge, String keyword);

    /**
     * HQL 子查询（EXISTS）
     */
    List<UserEntity> hqlExistsSubquery(java.math.BigDecimal minAmount);

    /**
     * HQL LEFT JOIN FETCH 集合 + distinct
     */
    List<UserEntity> hqlJoinFetchDistinct(String deptName);

    /**
     * 派生查询分页 + Sort（Pageable 排序）
     */
    org.springframework.data.domain.Page<UserEntity> derivedPaged(Integer status, int page, int size, String sortField);
}
