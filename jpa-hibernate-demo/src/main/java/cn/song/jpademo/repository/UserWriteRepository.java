package cn.song.jpademo.repository;

import cn.song.jpademo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * 用户写路径 Repository
 * JPA CRUD 写路径（save/findById/existsById/count/deleteById/deleteAllInBatch）语料，
 * 供插件预览各写方法对应的 SQL 形态（插件任务号见各方法 KDoc）。
 *
 * <p>说明：findAll() / findById(Long) / existsById(Long) / count() / deleteById(Long) /
 * delete(UserEntity) / deleteAllInBatch() 均为 JpaRepository/CrudRepository 自带方法，
 * 在子接口里重复声明是合法的（Java 允许接口重新声明继承方法）——显式声明是为了给
 * 静态分析提供可锚定的符号（方法名 → 派生解析 / CRUD 语义映射）。
 *
 * @author SongRenShuo
 */
public interface UserWriteRepository extends JpaRepository<UserEntity, Long> {

    /**
     * 全量查询（JpaRepository 自带，显式重声明供静态分析锚定）
     * 无 By 形态：Subject find + All，无谓词 → SELECT * FROM user
     */
    List<UserEntity> findAll();

    /**
     * 主键查询（CrudRepository 自带，显式重声明供静态分析锚定）
     * → SELECT * FROM user WHERE id = ?
     */
    Optional<UserEntity> findById(Long id);

    /**
     * 主键存在性判断（CrudRepository 自带，显式重声明供静态分析锚定）
     * → SELECT 1 FROM user WHERE id = ?（EXISTS 语义）
     */
    boolean existsById(Long id);

    /**
     * 总数统计（CrudRepository 自带，显式重声明供静态分析锚定）
     * 裸 count 无 By 形态 → SELECT COUNT(*) FROM user
     */
    long count();

    /**
     * 主键删除（CrudRepository 自带，显式重声明供静态分析锚定）
     * → DELETE FROM user WHERE id = ?
     */
    void deleteById(Long id);

    /**
     * 实体删除（CrudRepository 自带，显式重声明供静态分析锚定）
     * 按主键等值 DELETE（实体主键静态不可得 → ? 占位）
     */
    void delete(UserEntity user);

    /**
     * 全表批量删除（JpaRepository 自带，显式重声明供静态分析锚定）
     * 单条 DELETE FROM user，无 WHERE（全表删除，UI 层需红色警示）
     */
    void deleteAllInBatch();

    /**
     * 按创建时间倒序全量查询（无 By/Order 混合形态：Subject findAll + 仅 OrderBy、无谓词）
     * → SELECT * FROM user ORDER BY create_time DESC
     */
    List<UserEntity> findAllByOrderByCreateTimeDesc();
}
