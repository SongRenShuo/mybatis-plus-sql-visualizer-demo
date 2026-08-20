package cn.song.jpademo.repository;

import cn.song.jpademo.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * 用户 Repository
 * 派生查询（PartTree）+ @Query JPQL / 原生 SQL + Specification 用例
 *
 * @author SongRenShuo
 */
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

    // ------------------------------------------------------------------
    // 派生查询（插件 PartTreeParser / DerivedQueryConverter 对齐用例）
    // ------------------------------------------------------------------

    /**
     * findByLastName：等值条件
     */
    List<UserEntity> findByLastName(String lastName);

    /**
     * findByLastNameAndFirstName：AND 连接
     */
    List<UserEntity> findByLastNameAndFirstName(String lastName, String firstName);

    /**
     * findByUsernameOrEmail：OR 连接
     */
    List<UserEntity> findByUsernameOrEmail(String username, String email);

    /**
     * findByAgeGreaterThan / LessThan / Between
     */
    List<UserEntity> findByAgeGreaterThan(Integer age);

    List<UserEntity> findByAgeLessThanEqual(Integer age);

    List<UserEntity> findByAgeBetween(Integer start, Integer end);

    /**
     * findByUsernameLike / Containing / StartingWith / EndingWith
     */
    List<UserEntity> findByUsernameLike(String username);

    List<UserEntity> findByUsernameContaining(String username);

    List<UserEntity> findByUsernameStartingWith(String prefix);

    List<UserEntity> findByUsernameEndingWith(String suffix);

    /**
     * findByStatusIn：IN 条件
     */
    List<UserEntity> findByStatusIn(Collection<Integer> statuses);

    /**
     * findByEmailIsNull：IS NULL 条件
     */
    List<UserEntity> findByEmailIsNull();

    /**
     * findFirstByOrderByIdDesc / findTop10ByOrderByCreateTimeDesc：LIMIT
     */
    UserEntity findFirstByOrderByIdDesc();

    List<UserEntity> findTop10ByOrderByCreateTimeDesc();

    /**
     * findByStatusOrderByIdDesc：ORDER BY
     */
    List<UserEntity> findByStatusOrderByIdDesc(Integer status);

    /**
     * countByStatus / existsByUsername：聚合类型
     */
    long countByStatus(Integer status);

    boolean existsByUsername(String username);

    /**
     * findByUsernameIgnoreCase：忽略大小写
     */
    List<UserEntity> findByUsernameIgnoreCase(String username);

    /**
     * deleteByStatus：DELETE 语句
     */
    @Transactional
    @Modifying
    void deleteByStatus(Integer status);

    /**
     * findByDepartmentIdAndStatusOrderByCreateTimeDesc：嵌套条件 + 排序（分页）
     */
    Page<UserEntity> findByDepartmentIdAndStatusOrderByCreateTimeDesc(Long departmentId, Integer status, Pageable pageable);

    // ------------------------------------------------------------------
    // @Query JPQL（插件 JpqlConverter 对齐用例）
    // ------------------------------------------------------------------

    /**
     * JPQL 命名参数
     */
    @Query("SELECT u FROM UserEntity u WHERE u.username = :username")
    UserEntity findByNameParam(@Param("username") String username);

    /**
     * JPQL 位置参数
     */
    @Query("SELECT u FROM UserEntity u WHERE u.username = ?1 AND u.age >= ?2")
    List<UserEntity> findByPositionalParams(String username, Integer minAge);

    /**
     * JPQL 多条件 + 排序
     */
    @Query("SELECT u FROM UserEntity u WHERE u.status = :status AND u.age BETWEEN :minAge AND :maxAge ORDER BY u.age DESC")
    List<UserEntity> findByStatusAndAgeRange(@Param("status") Integer status,
                                             @Param("minAge") Integer minAge,
                                             @Param("maxAge") Integer maxAge);

    /**
     * JPQL JOIN FETCH（多对一）
     */
    @Query("SELECT u FROM UserEntity u JOIN FETCH u.department d WHERE d.name = :deptName")
    List<UserEntity> findByDeptNameWithFetch(@Param("deptName") String deptName);

    /**
     * JPQL JOIN + ON 条件
     */
    @Query("SELECT u FROM UserEntity u JOIN u.department d WHERE u.status = :status AND d.code = :deptCode")
    List<UserEntity> findByDeptCode(@Param("status") Integer status, @Param("deptCode") String deptCode);

    /**
     * JPQL 聚合 COUNT
     */
    @Query("SELECT COUNT(u) FROM UserEntity u WHERE u.status = :status")
    long countByStatusJpql(@Param("status") Integer status);

    /**
     * JPQL 更新（@Modifying）
     */
    @Transactional
    @Modifying
    @Query("UPDATE UserEntity u SET u.status = :newStatus WHERE u.status = :oldStatus")
    int updateStatusByJpql(@Param("oldStatus") Integer oldStatus, @Param("newStatus") Integer newStatus);

    /**
     * JPQL 删除
     */
    @Transactional
    @Modifying
    @Query("DELETE FROM UserEntity u WHERE u.age < :maxAge")
    int deleteByAgeLessThanJpql(@Param("maxAge") Integer maxAge);

    /**
     * 原生 SQL 查询（nativeQuery）
     */
    @Query(value = "SELECT * FROM user WHERE username LIKE CONCAT('%', :keyword, '%') AND status = :status", nativeQuery = true)
    List<UserEntity> findByKeywordNative(@Param("keyword") String keyword, @Param("status") Integer status);

    // ------------------------------------------------------------------
    // 更多派生查询（Top / Distinct / In / 嵌套属性 / 分页 Sort）
    // ------------------------------------------------------------------

    /**
     * findTop3：LIMIT 前 3 条 + 排序
     */
    List<UserEntity> findTop3ByOrderByCreateTimeDesc();

    /**
     * findFirstBy + And：单条 + 多条件
     */
    UserEntity findFirstByStatusAndDepartmentIdOrderByIdDesc(Integer status, Long departmentId);

    /**
     * findDistinctBy：去重
     */
    List<UserEntity> findDistinctByStatus(Integer status);

    /**
     * findByAgeIn：IN 集合
     */
    List<UserEntity> findByAgeIn(Collection<Integer> ages);

    /**
     * 嵌套属性查询：findByDepartment_Name（通过关联对象属性）
     */
    List<UserEntity> findByDepartment_Name(String name);

    /**
     * findByDepartmentIdIn：关联外键 IN
     */
    List<UserEntity> findByDepartmentIdIn(Collection<Long> departmentIds);

    /**
     * findByCreateTimeAfter / Before：时间区间
     */
    List<UserEntity> findByCreateTimeAfter(LocalDateTime time);

    List<UserEntity> findByCreateTimeBefore(LocalDateTime time);

    /**
     * findByAgeGreaterThanEqualAndAgeLessThanEqual：区间（>= && <=）
     */
    List<UserEntity> findByAgeGreaterThanEqualAndAgeLessThanEqual(Integer start, Integer end);

    /**
     * findByStatusOrderByAgeAscCreateTimeDesc：多列排序
     */
    List<UserEntity> findByStatusOrderByAgeAscCreateTimeDesc(Integer status);

    /**
     * 分页 + Sort：Pageable 排序查询
     */
    Page<UserEntity> findByStatus(Integer status, Pageable pageable);

    // ------------------------------------------------------------------
    // @Query 更多（IN / BETWEEN / LIKE / 子查询）
    // ------------------------------------------------------------------

    /**
     * @Query IN 集合参数
     */
    @Query("SELECT u FROM UserEntity u WHERE u.status IN :statuses")
    List<UserEntity> findByStatusesIn(@Param("statuses") Collection<Integer> statuses);

    /**
     * @Query BETWEEN 区间
     */
    @Query("SELECT u FROM UserEntity u WHERE u.age BETWEEN :start AND :end")
    List<UserEntity> findByAgeRange(@Param("start") Integer start, @Param("end") Integer end);

    /**
     * @Query LIKE CONCAT 模糊
     */
    @Query("SELECT u FROM UserEntity u WHERE u.username LIKE CONCAT('%', :keyword, '%')")
    List<UserEntity> findByUsernameLikeJpql(@Param("keyword") String keyword);

    /**
     * @Query 子查询 EXISTS
     */
    @Query("SELECT u FROM UserEntity u WHERE EXISTS " +
            "(SELECT o FROM OrderEntity o WHERE o.customerId = u.id AND o.totalAmount >= :minAmount)")
    List<UserEntity> findWithOrderExists(@Param("minAmount") java.math.BigDecimal minAmount);

    /**
     * @Query 多表 LEFT JOIN（非 fetch）
     */
    @Query("SELECT u FROM UserEntity u LEFT JOIN u.department d WHERE d.id IS NOT NULL")
    List<UserEntity> findWithDepartment();

    /**
     * @Query IS NULL / IS NOT NULL
     */
    @Query("SELECT u FROM UserEntity u WHERE u.email IS NULL")
    List<UserEntity> findEmailNull();

    /**
     * @Query NOT IN
     */
    @Query("SELECT u FROM UserEntity u WHERE u.status NOT IN :excluded")
    List<UserEntity> findByStatusNotIn(@Param("excluded") Collection<Integer> excluded);

    /**
     * @Query DISTINCT
     */
    @Query("SELECT DISTINCT u.status FROM UserEntity u WHERE u.age > :minAge")
    List<Integer> findDistinctStatus(@Param("minAge") Integer minAge);
}
