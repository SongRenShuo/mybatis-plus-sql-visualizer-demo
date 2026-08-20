package cn.song.jpademo.controller;

import cn.song.jpademo.entity.DepartmentEntity;
import cn.song.jpademo.entity.UserEntity;
import cn.song.jpademo.service.JpaQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * JPA + Hibernate 查询演示（CriteriaQuery / HQL / 派生查询用例）
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/jpa/user")
public class JpaQueryController {

    @Resource
    private JpaQueryService jpaQueryService;

    /**
     * 派生查询组合
     */
    @GetMapping("/derived")
    public List<UserEntity> derived(String lastName, Integer minAge, Integer status) {
        return jpaQueryService.derivedQuery(lastName, minAge, status);
    }

    /**
     * JPQL 命名/位置参数
     */
    @GetMapping("/jpql")
    public List<UserEntity> jpql(String username, Integer minAge) {
        return jpaQueryService.jpqlQuery(username, minAge);
    }

    /**
     * JPQL JOIN FETCH
     */
    @GetMapping("/jpqlJoinFetch")
    public List<UserEntity> jpqlJoinFetch(String deptName) {
        return jpaQueryService.jpqlJoinFetch(deptName);
    }

    /**
     * CriteriaQuery 基础条件
     */
    @GetMapping("/criteria/basic")
    public List<UserEntity> criteriaBasic(Integer minAge, Integer status) {
        return jpaQueryService.criteriaBasic(minAge, status);
    }

    /**
     * CriteriaQuery 组合条件（and/or/not/between/in/like）
     */
    @GetMapping("/criteria/grouped")
    public List<UserEntity> criteriaGrouped(String username, Integer ageStart, Integer ageEnd, List<Integer> statuses) {
        return jpaQueryService.criteriaGrouped(username, ageStart, ageEnd, statuses);
    }

    /**
     * CriteriaQuery JOIN
     */
    @GetMapping("/criteria/join")
    public List<UserEntity> criteriaJoin(String deptName, Integer status) {
        return jpaQueryService.criteriaJoin(deptName, status);
    }

    /**
     * CriteriaQuery 聚合
     */
    @GetMapping("/criteria/aggregate")
    public List<Object[]> criteriaAggregate() {
        return jpaQueryService.criteriaAggregate();
    }

    /**
     * CriteriaQuery 分页
     */
    @GetMapping("/criteria/paged")
    public List<UserEntity> criteriaPaged(Integer status, Integer limit) {
        return jpaQueryService.criteriaPaged(status, limit);
    }

    /**
     * Hibernate HQL
     */
    @GetMapping("/hql")
    public List<UserEntity> hql(String username) {
        return jpaQueryService.hibernateHql(username);
    }

    /**
     * Hibernate HQL JOIN FETCH
     */
    @GetMapping("/hqlJoinFetch")
    public List<UserEntity> hqlJoinFetch(String deptName, Integer status) {
        return jpaQueryService.hibernateHqlJoinFetch(deptName, status);
    }

    /**
     * Hibernate HQL 聚合
     */
    @GetMapping("/hqlAggregate")
    public Map<String, Object> hqlAggregate(Integer status) {
        return jpaQueryService.hibernateHqlAggregate(status);
    }

    /**
     * 原生 SQL
     */
    @GetMapping("/native")
    public List<UserEntity> nativeQuery(String keyword, Integer status) {
        return jpaQueryService.nativeQuery(keyword, status);
    }

    /**
     * 部门列表（关联用户）
     */
    @GetMapping("/departments")
    public List<DepartmentEntity> departments() {
        return jpaQueryService.departmentWithUsers();
    }

    // ------------------------------------------------------------------
    // 扩展用例：Specification / Criteria 子查询·on·case·Tuple / HQL 更多
    // ------------------------------------------------------------------

    /**
     * JPA Specification 动态查询
     */
    @GetMapping("/specification")
    public List<UserEntity> specification(String username, Integer minAge, Integer status, Boolean emailNull) {
        return jpaQueryService.specificationQuery(username, minAge, status, emailNull);
    }

    /**
     * Criteria 子查询（Subquery + IN）
     */
    @GetMapping("/criteria/subquery")
    public List<UserEntity> criteriaSubquery(String deptName, Integer minAmount) {
        return jpaQueryService.criteriaSubquery(deptName, minAmount);
    }

    /**
     * Criteria join on 条件（显式 ON）+ left join
     */
    @GetMapping("/criteria/joinOn")
    public List<UserEntity> criteriaJoinOn(String deptName, Integer status) {
        return jpaQueryService.criteriaJoinOn(deptName, status);
    }

    /**
     * Criteria CASE 表达式
     */
    @GetMapping("/criteria/case")
    public List<Object[]> criteriaCase(Integer minAge) {
        return jpaQueryService.criteriaCase(minAge);
    }

    /**
     * Criteria Tuple 多列查询
     */
    @GetMapping("/criteria/tuple")
    public List<javax.persistence.Tuple> criteriaTuple(Integer status) {
        return jpaQueryService.criteriaTuple(status);
    }

    /**
     * HQL 更多：DISTINCT / IN / LIKE / BETWEEN
     */
    @GetMapping("/hqlMore")
    public List<UserEntity> hqlMore(List<Integer> statuses, Integer minAge, Integer maxAge, String keyword) {
        return jpaQueryService.hqlMore(statuses, minAge, maxAge, keyword);
    }

    /**
     * HQL 子查询（EXISTS）
     */
    @GetMapping("/hqlExists")
    public List<UserEntity> hqlExists(java.math.BigDecimal minAmount) {
        return jpaQueryService.hqlExistsSubquery(minAmount);
    }

    /**
     * HQL LEFT JOIN FETCH 集合 + distinct
     */
    @GetMapping("/hqlJoinFetchDistinct")
    public List<UserEntity> hqlJoinFetchDistinct(String deptName) {
        return jpaQueryService.hqlJoinFetchDistinct(deptName);
    }

    /**
     * 派生查询分页 + Sort
     */
    @GetMapping("/derivedPaged")
    public org.springframework.data.domain.Page<UserEntity> derivedPaged(Integer status, Integer page, Integer size, String sortField) {
        return jpaQueryService.derivedPaged(status,
                page == null ? 0 : page,
                size == null ? 10 : size,
                sortField == null ? "id" : sortField);
    }
}
