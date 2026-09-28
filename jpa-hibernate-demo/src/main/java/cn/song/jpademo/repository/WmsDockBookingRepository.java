package cn.song.jpademo.repository;

import cn.song.jpademo.entity.WmsDockBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 入库预约单 Repository
 *
 * @Embedded 嵌入段语料对照用例（UpdateInfo 内嵌对象）：
 * 插件对「嵌入段限定符位」的映射剥离（updateInfo.createdTime → created_time）
 * 此前只有 HibernateTemplate HQL 链（形态 1 带别名 / 形态 16 无别名），
 * 这里补 Spring Data JPA 链的派生查询与 @Query SELECT 投影两个位。
 *
 * @author SongRenShuo
 */
public interface WmsDockBookingRepository
        extends JpaRepository<WmsDockBooking, Long>, JpaSpecificationExecutor<WmsDockBooking> {

    // ------------------------------------------------------------------
    // 派生查询（PartTree）嵌入段属性路径：findByUpdateInfoCreatedTimeAfter
    // 属性路径 updateInfo.createdTime 穿透 @Embedded 对象
    // ------------------------------------------------------------------

    /**
     * 嵌入段属性路径派生查询：updateInfo.createdTime &gt; :time
     */
    List<WmsDockBooking> findByUpdateInfoCreatedTimeAfter(LocalDateTime time);

    // ------------------------------------------------------------------
    // @Query JPQL SELECT 投影 + ORDER BY 嵌入段位
    // ------------------------------------------------------------------

    /**
     * SELECT 投影嵌入段（返回标量列）+ ORDER BY 嵌入段路径
     */
    @Query("select b.updateInfo.createdTime from WmsDockBooking b "
            + "where b.warehouseId = :warehouseId order by b.updateInfo.createdTime desc")
    List<LocalDateTime> findUpdateCreatedTimesByWarehouse(@Param("warehouseId") String warehouseId);
}
