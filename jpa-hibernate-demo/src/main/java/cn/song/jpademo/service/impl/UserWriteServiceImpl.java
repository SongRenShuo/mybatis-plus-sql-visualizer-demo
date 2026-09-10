package cn.song.jpademo.service.impl;

import cn.song.jpademo.entity.UserEntity;
import cn.song.jpademo.repository.UserRepository;
import cn.song.jpademo.repository.UserWriteRepository;
import cn.song.jpademo.service.UserWriteService;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 用户写路径服务实现类
 * 集中编写 JPA CRUD / EntityManager 写 API / CriteriaUpdate·Delete / Specification / QBE /
 * 锁读调用链，供插件预览写路径 SQL（插件任务号见接口各方法 KDoc）
 *
 * @author SongRenShuo
 */
@Service("userWriteService")
public class UserWriteServiceImpl implements UserWriteService {

    @PersistenceContext
    private EntityManager entityManager;

    private final UserWriteRepository userWriteRepository;

    private final UserRepository userRepository;

    public UserWriteServiceImpl(UserWriteRepository userWriteRepository, UserRepository userRepository) {
        this.userWriteRepository = userWriteRepository;
        this.userRepository = userRepository;
    }

    // ------------------------------------------------------------------
    // Repository CRUD 写路径（T-J1）
    // ------------------------------------------------------------------

    /**
     * 单实体保存：save → INSERT INTO user (...) VALUES (?, ...)
     */
    @Override
    @Transactional
    public UserEntity save(UserEntity user) {
        return userWriteRepository.save(user);
    }

    /**
     * 批量保存：saveAll → 逐条 INSERT 模板
     */
    @Override
    @Transactional
    public List<UserEntity> saveAll(List<UserEntity> users) {
        return userWriteRepository.saveAll(users);
    }

    /**
     * 主键查询：findById → SELECT * FROM user WHERE id = ?
     */
    @Override
    @Transactional(readOnly = true)
    public UserEntity findById(Long id) {
        Optional<UserEntity> found = userWriteRepository.findById(id);
        return found.orElse(null);
    }

    /**
     * 主键存在性判断：existsById → SELECT 1 FROM user WHERE id = ?
     */
    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return userWriteRepository.existsById(id);
    }

    /**
     * 总数统计：count → SELECT COUNT(*) FROM user
     */
    @Override
    @Transactional(readOnly = true)
    public long count() {
        return userWriteRepository.count();
    }

    /**
     * 主键删除：deleteById → DELETE FROM user WHERE id = ?
     */
    @Override
    @Transactional
    public void deleteById(Long id) {
        userWriteRepository.deleteById(id);
    }

    /**
     * 实体删除：delete(entity) → DELETE FROM user WHERE 主键等值
     */
    @Override
    @Transactional
    public void delete(UserEntity user) {
        userWriteRepository.delete(user);
    }

    /**
     * 全表批量删除：deleteAllInBatch → DELETE FROM user，无 WHERE（单条 SQL）
     */
    @Override
    @Transactional
    public void deleteAllInBatch() {
        userWriteRepository.deleteAllInBatch();
    }

    /**
     * 按创建时间倒序全量查询：findAllByOrderByCreateTimeDesc → ORDER BY create_time DESC
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> findAllByCreateTimeDesc() {
        return userWriteRepository.findAllByOrderByCreateTimeDesc();
    }

    // ------------------------------------------------------------------
    // @Modifying JPQL 写路径（T-J2）
    // ------------------------------------------------------------------

    /**
     * JPQL 批量更新状态：@Modifying UPDATE JPQL（UserRepository#updateStatusByJpql）
     */
    @Override
    @Transactional
    public int updateStatusByJpql(Integer oldStatus, Integer newStatus) {
        return userRepository.updateStatusByJpql(oldStatus, newStatus);
    }

    // ------------------------------------------------------------------
    // EntityManager 写 API（T-J6）
    // ------------------------------------------------------------------

    /**
     * em.persist：托管态新增，flush 时 INSERT
     */
    @Override
    @Transactional
    public UserEntity persistEntity(UserEntity user) {
        entityManager.persist(user);
        return user;
    }

    /**
     * em.merge：游离态合并，主键存在则 UPDATE、不存在则 INSERT。
     * 游离实体只带 id+email，直接 merge 会把 username 覆盖为 null
     * （user.username 是 NOT NULL，UPDATE 直接抛约束违例），
     * 因此先取托管实体回填 username 再 merge，保持「存在则更新」语义。
     */
    @Override
    @Transactional
    public UserEntity mergeEntity(UserEntity user) {
        UserEntity managed = entityManager.find(UserEntity.class, user.getId());
        if (managed != null) {
            managed.setEmail(user.getEmail());
            return entityManager.merge(managed);
        }
        if (user.getUsername() == null) {
            user.setUsername("merged-" + user.getId());
        }
        return entityManager.merge(user);
    }

    /**
     * em.remove：托管态删除，flush 时 DELETE WHERE 主键等值。
     * Controller 传入的实体来自另一个只读事务（已游离），
     * 直接 remove 抛 "Removing a detached instance"，
     * 与 SimpleJpaRepository.delete 同法：先 merge 回托管态再 remove。
     */
    @Override
    @Transactional
    public void removeEntity(UserEntity user) {
        UserEntity managed = entityManager.contains(user) ? user : entityManager.merge(user);
        entityManager.remove(managed);
    }

    /**
     * em.find：主键查询（一级缓存命中则免 SQL）
     */
    @Override
    @Transactional(readOnly = true)
    public UserEntity findEntity(Long id) {
        return entityManager.find(UserEntity.class, id);
    }

    // ------------------------------------------------------------------
    // CriteriaUpdate / CriteriaDelete（T-J6）
    // ------------------------------------------------------------------

    /**
     * CriteriaUpdate 单列更新：UPDATE user SET status = ? WHERE id = ?
     */
    @Override
    @Transactional
    public int criteriaUpdateStatus(Long id, Integer newStatus) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaUpdate<UserEntity> update = cb.createCriteriaUpdate(UserEntity.class);
        Root<UserEntity> root = update.from(UserEntity.class);

        update.set(root.get("status"), newStatus);
        update.where(cb.equal(root.get("id"), id));
        return entityManager.createQuery(update).executeUpdate();
    }

    /**
     * CriteriaDelete 条件删除：DELETE FROM user WHERE status = ?
     */
    @Override
    @Transactional
    public int criteriaDeleteByStatus(Integer status) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<UserEntity> delete = cb.createCriteriaDelete(UserEntity.class);
        Root<UserEntity> root = delete.from(UserEntity.class);

        delete.where(cb.equal(root.get("status"), status));
        return entityManager.createQuery(delete).executeUpdate();
    }

    // ------------------------------------------------------------------
    // Specification / Query By Example / 锁读（T-J5 / T-J20）
    // ------------------------------------------------------------------

    /**
     * Specification 动态查询：like/ge/eq/isNull 条件组合（JpaSpecificationExecutor.findAll）
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> specificationQuery(String username, Integer minAge, Integer status, Boolean emailNull) {
        Specification<UserEntity> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
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
            return cb.and(predicates.toArray(new Predicate[0]));
        };
        return userRepository.findAll(spec);
    }

    /**
     * Query By Example：非空属性等值匹配（JpaSpecificationExecutor.findOne(Example)）
     */
    @Override
    @Transactional(readOnly = true)
    public UserEntity exampleQuery(UserEntity probe) {
        Example<UserEntity> example = Example.of(probe);
        return userRepository.findOne(example).orElse(null);
    }

    /**
     * 锁读：PESSIMISTIC_WRITE 传给 find 重载 → SELECT ... FOR UPDATE
     */
    @Override
    @Transactional
    public UserEntity findWithLock(Long id) {
        return entityManager.find(UserEntity.class, id, LockModeType.PESSIMISTIC_WRITE);
    }
}
