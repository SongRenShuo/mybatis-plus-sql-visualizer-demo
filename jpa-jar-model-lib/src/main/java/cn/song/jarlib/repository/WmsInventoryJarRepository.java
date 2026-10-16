package cn.song.jarlib.repository;

import cn.song.jarlib.entity.WmsInventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA 仓库——**接口也在依赖 JAR 里**。
 *
 * <p>宿主工程的 {@code @EnableJpaRepositories} 指向本包，用来坐实「实体与仓库都不在宿主
 * 模块的源码树里」这一形态（宿主模块根不可知，插件只能靠工程级信号判命名约定）。
 *
 * <p>本接口不参与复现缺陷（复现走宿主的自定义 DAO HQL），只负责让
 * {@code @EnableJpaRepositories} 有真实扫描目标。
 *
 * @author SongRenShuo
 */
public interface WmsInventoryJarRepository extends JpaRepository<WmsInventoryEntity, Long> {
}
