package cn.song.jpademo.service;

import cn.song.jpademo.entity.UserEntity;

import java.util.List;

/**
 * 用户写路径服务层
 * JPA CRUD（save/saveAll/findById/existsById/count/deleteById/deleteAllInBatch）、
 * EntityManager 写 API（persist/merge/remove/find）、CriteriaUpdate/CriteriaDelete、
 * Specification、Query By Example、锁读形态逐一演示（插件任务号见各方法 KDoc）。
 *
 * @author SongRenShuo
 */
public interface UserWriteService {

    // ------------------------------------------------------------------
    // Repository CRUD 写路径（T-J1）
    // ------------------------------------------------------------------

    /**
     * 单实体保存（T-J1：save → INSERT INTO user (...) VALUES (?, ...)）
     */
    UserEntity save(UserEntity user);

    /**
     * 批量保存（T-J1：saveAll → 逐条 INSERT 模板）
     */
    List<UserEntity> saveAll(List<UserEntity> users);

    /**
     * 主键查询（T-J1：findById → SELECT * FROM user WHERE id = ?）
     */
    UserEntity findById(Long id);

    /**
     * 主键存在性判断（T-J1：existsById → SELECT 1 FROM user WHERE id = ?）
     */
    boolean existsById(Long id);

    /**
     * 总数统计（T-J1：count → SELECT COUNT(*) FROM user）
     */
    long count();

    /**
     * 主键删除（T-J1：deleteById → DELETE FROM user WHERE id = ?）
     */
    void deleteById(Long id);

    /**
     * 实体删除（T-J1：delete(entity) → DELETE FROM user WHERE 主键等值）
     */
    void delete(UserEntity user);

    /**
     * 全表批量删除（T-J1：deleteAllInBatch → DELETE FROM user，无 WHERE）
     */
    void deleteAllInBatch();

    /**
     * 按创建时间倒序全量查询（T-J1：无 By/Order 混合形态 → ORDER BY create_time DESC）
     */
    List<UserEntity> findAllByCreateTimeDesc();

    // ------------------------------------------------------------------
    // @Modifying JPQL 写路径（T-J2）
    // ------------------------------------------------------------------

    /**
     * JPQL 批量更新状态（T-J2：@Modifying UPDATE JPQL → UPDATE user SET status = ? WHERE status = ?）
     */
    int updateStatusByJpql(Integer oldStatus, Integer newStatus);

    // ------------------------------------------------------------------
    // EntityManager 写 API（T-J6）
    // ------------------------------------------------------------------

    /**
     * em.persist 新增（T-J6：persist → INSERT 形态）
     */
    UserEntity persistEntity(UserEntity user);

    /**
     * em.merge 合并（T-J6：merge → 主键存在则 UPDATE / 不存在则 INSERT）
     */
    UserEntity mergeEntity(UserEntity user);

    /**
     * em.remove 删除（T-J6：remove → DELETE WHERE 主键等值）
     */
    void removeEntity(UserEntity user);

    /**
     * em.find 主键查询（T-J6：find → SELECT * FROM user WHERE id = ?）
     */
    UserEntity findEntity(Long id);

    // ------------------------------------------------------------------
    // CriteriaUpdate / CriteriaDelete（T-J6）
    // ------------------------------------------------------------------

    /**
     * CriteriaUpdate 单列更新（T-J6：cb.createCriteriaUpdate → UPDATE user SET status = ? WHERE id = ?）
     */
    int criteriaUpdateStatus(Long id, Integer newStatus);

    /**
     * CriteriaDelete 条件删除（T-J6：cb.createCriteriaDelete → DELETE FROM user WHERE status = ?）
     */
    int criteriaDeleteByStatus(Integer status);

    // ------------------------------------------------------------------
    // Specification / Query By Example / 锁读（T-J5 / T-J20）
    // ------------------------------------------------------------------

    /**
     * Specification 动态查询（T-J5/T-J20：findAll(spec) → WHERE like/ge/eq/isNull 组合）
     * 仿照 JpaQueryServiceImpl#specificationQuery 已有风格
     */
    List<UserEntity> specificationQuery(String username, Integer minAge, Integer status, Boolean emailNull);

    /**
     * Query By Example 探针查询（T-J20：Example.of → 非空属性等值 WHERE）
     */
    UserEntity exampleQuery(UserEntity probe);

    /**
     * 锁读形态（T-J6 写路径族：LockModeType.PESSIMISTIC_WRITE 传给 find 重载 → SELECT ... FOR UPDATE）
     */
    UserEntity findWithLock(Long id);
}
