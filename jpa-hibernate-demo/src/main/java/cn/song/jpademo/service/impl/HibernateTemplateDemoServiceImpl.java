package cn.song.jpademo.service.impl;

import cn.song.jpademo.dao.CommonDao;
import cn.song.jpademo.dao.impl.CommonDaoHibernateImpl;
import cn.song.jpademo.entity.WmsDockBooking;
import cn.song.jpademo.service.HibernateTemplateDemoService;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HibernateTemplate 老式 DAO 调用形态实现。
 *
 * 插件验证重点：光标置于下方各方法中 `commonDao.xxx(...)` 调用行时，
 * gutter 应显示 SQL 预览图标（qualifier=commonDao 匹配 DAO 模式 + 方法名含 Query/execute
 * + HQL 内容启发命中）。拼接与双数组形态为 2026-09-03 修复的用例。
 *
 * @author SongRenShuo
 */
@Service
public class HibernateTemplateDemoServiceImpl implements HibernateTemplateDemoService {

    /**
     * 老式自定义 DAO（实现基于 HibernateDaoSupport + HibernateTemplate）
     */
    @Resource
    private CommonDao commonDao;

    /**
     * DAO 实现类（原生 SQL / findByValueBean 等实现层特有方法演示）
     */
    @Resource
    private CommonDaoHibernateImpl commonDaoImpl;

    /**
     * HibernateTemplate 直接 API（基础 CRUD 形态演示）
     */
    @Resource
    private HibernateTemplate hibernateTemplate;

    // ------------------------------------------------------------------
    // 形态 1：用户反馈同款——拼接初始化式 + 名字数组/值数组双数组传参
    // ------------------------------------------------------------------

    @Override
    public Object[] getHeadData(String warehouseId, LocalDateTime startTime, LocalDateTime endTime) {
        String hql = "select count(case when booking.status = 'F' then 0 end), "
                + "count(case when booking.status = 'P' then 0 end), "
                + "count(case when booking.arrivalTime is not null "
                + "and booking.initialETA is not null "
                + "and booking.arrivalTime < booking.initialETA then 0 end), "
                + "count(case when booking.latestETA is not null and booking.ATD is not null then 0 end) "
                + "from WmsDockBooking booking "
                + "left join WmsAsn asn on asn.id = booking.relatedBillId "
                + "where booking.warehouseId = :warehouseId "
                + "and booking.type = 'R' "
                + "and booking.updateInfo.createdTime >= :startTime "
                + "and booking.updateInfo.createdTime < :endTime "
                + "and booking.ATD is not null";
        Object[] stats = (Object[]) commonDao.findByQueryUniqueResult(hql,
                new String[]{"warehouseId", "startTime", "endTime"},
                new Object[]{warehouseId, startTime, endTime});
        return stats;
    }

    // ------------------------------------------------------------------
    // 形态 2：字面量直传 + name-value 交替（HQL 单行字面量）
    // ------------------------------------------------------------------

    @Override
    public List<WmsDockBooking> listByStatus(String status) {
        return commonDao.findByQuery(
                "from WmsDockBooking booking where booking.status = :status",
                "status", status);
    }

    // ------------------------------------------------------------------
    // 形态 3：变量直字面量（String hql = "..."，非拼接）
    // ------------------------------------------------------------------

    @Override
    public List<WmsDockBooking> listByWarehouse(String warehouseId) {
        String hql = "from WmsDockBooking booking where booking.warehouseId = :warehouseId";
        return commonDao.findByQuery(hql, "warehouseId", warehouseId);
    }

    // ------------------------------------------------------------------
    // 形态 4：链式 `+` 单表达式（"a" + "b" + "c" 属于 PsiPolyadicExpression）
    // ------------------------------------------------------------------

    @Override
    public List<WmsDockBooking> listByStatusAndType(String status, String type) {
        String hql = "from WmsDockBooking booking "
                + "where booking.status = :status "
                + "and booking.type = :type";
        return commonDao.findByQuery(hql, "status", status, "type", type);
    }

    // ------------------------------------------------------------------
    // 形态 5：Map 单参数传参（hql + Map 命名参数）
    // ------------------------------------------------------------------

    @Override
    public List<WmsDockBooking> listActiveByWarehouse(String warehouseId, Integer status) {
        Map<String, Object> params = new HashMap<>();
        params.put("warehouseId", warehouseId);
        // booking.status 映射的是字符串列（F/P），Integer 直绑会抛
        // "Parameter value did not match expected type"，这里转成字符串再传
        params.put("status", String.valueOf(status));
        return commonDao.findByQuery(
                "from WmsDockBooking booking "
                        + "where booking.warehouseId = :warehouseId "
                        + "and booking.status = :status "
                        + "and booking.arrivalTime is not null",
                params);
    }

    // ------------------------------------------------------------------
    // 形态 6：UPDATE HQL（execute 方法，name-value 交替）
    // ------------------------------------------------------------------

    @Override
    @Transactional(transactionManager = "hibernateTransactionManager")
    public int updateStatusById(Long id, String newStatus) {
        return commonDao.execute(
                "update WmsDockBooking booking set booking.status = :newStatus where booking.id = :id",
                "newStatus", newStatus, "id", id);
    }

    // ------------------------------------------------------------------
    // 形态 7：DELETE HQL（execute 方法，name-value 交替）
    // ------------------------------------------------------------------

    @Override
    @Transactional(transactionManager = "hibernateTransactionManager")
    public int deleteAsnById(Long id) {
        return commonDao.execute(
                "delete from WmsAsn asn where asn.id = :id",
                "id", id);
    }

    // ------------------------------------------------------------------
    // 形态 8：IN 集合（:idList + name-value 传 List，实现内走 setParameterList）
    // ------------------------------------------------------------------

    @Override
    public List<WmsDockBooking> findByIdList(List<Long> idList) {
        String hql = "from WmsDockBooking booking where booking.id in (:idList)";
        return commonDao.findByQuery(hql, "idList", idList);
    }

    // ------------------------------------------------------------------
    // 形态 9：位置参数（?1 形态直接传值，find(String, Object...) deprecated 风格）
    // ------------------------------------------------------------------

    @Override
    public List<WmsDockBooking> findByStatusPositional(String status) {
        // Hibernate 5.2+ 不再支持裸 ? 占位（Legacy-style query parameters 抛 QueryException），
        // 位置形态统一用 ?1 编号占位，DAO 内按 setParameter(1..n) 绑定
        String hql = "from WmsDockBooking booking where booking.status = ?1";
        return commonDao.findByQuery(hql, status);
    }

    // ------------------------------------------------------------------
    // 形态 10：纯 FROM 无 SELECT（from Entity where ...）
    // ------------------------------------------------------------------

    @Override
    public List<WmsDockBooking> findByWarehouseFromOnly(String warehouseId) {
        String hql = "from WmsDockBooking booking where booking.warehouseId = :warehouseId";
        return commonDao.findByQuery(hql, "warehouseId", warehouseId);
    }

    // ------------------------------------------------------------------
    // 形态 11：原生 SQL（DAO 实现内 createSQLQuery，演示层委托）
    // ------------------------------------------------------------------

    @Override
    public List<?> nativeDockCount(String warehouseId) {
        // 原生 SQL 通过 HibernateTemplate 回调执行（Session.createSQLQuery，见 CommonDaoHibernateImpl.nativeCount）
        return commonDaoImpl.nativeCount(warehouseId);
    }

    // ------------------------------------------------------------------
    // 形态 12：findByValueBean（实体属性作为参数条件，属性名=参数名）
    // ------------------------------------------------------------------

    @Override
    public List<?> findByValueBeanDemo(WmsDockBooking sample) {
        // findByValueBean 以实体属性为参数条件（属性名=参数名），在 DAO 实现层执行
        return commonDaoImpl.findBookingByValueBean(sample);
    }

    // ------------------------------------------------------------------
    // 形态 13：HibernateTemplate 直接 API 基础 CRUD（save/load/update/delete/merge）
    // ------------------------------------------------------------------

    @Override
    @Transactional(transactionManager = "hibernateTransactionManager")
    public WmsDockBooking crudDemo(Long id, WmsDockBooking booking) {
        // get/load：单条读取（无记录时 load 抛 ObjectNotFoundException）
        WmsDockBooking loaded = hibernateTemplate.get(WmsDockBooking.class, id);
        // save：新增（返回主键）
        if (loaded == null) {
            hibernateTemplate.save(booking);
            return booking;
        }
        // 事务内 get 后 loaded 已处于托管态，直接 update 同 id 游离实体会抛
        // NonUniqueObjectException，先 evict 使其游离再演示 update
        hibernateTemplate.evict(loaded);
        // update：更新游离实体
        booking.setId(id);
        hibernateTemplate.update(booking);
        // merge：合并（存在则更新，不存在则插入）
        WmsDockBooking merged = hibernateTemplate.merge(booking);
        // saveOrUpdate：更新或新增
        hibernateTemplate.saveOrUpdate(merged);
        // delete：删除
        hibernateTemplate.delete(merged);
        return merged;
    }

    // ------------------------------------------------------------------
    // 形态 14：bulkUpdate（HQL 批量 UPDATE，?1 起算的序号参数，Hibernate 5.2+ 拒绝裸 ?）
    // ------------------------------------------------------------------

    @Override
    @Transactional(transactionManager = "hibernateTransactionManager")
    public int bulkUpdateStatus(String oldStatus, String newStatus) {
        return hibernateTemplate.bulkUpdate(
                "update WmsDockBooking booking set booking.status = ?2 where booking.status = ?1",
                oldStatus, newStatus);
    }

    // ------------------------------------------------------------------
    // 形态 15：findByNamedQueryAndNamedParam（hbm <query> 命名查询 :threshold）
    // ------------------------------------------------------------------

    @Override
    public List<?> findByNamedQueryLegacy() {
        return hibernateTemplate.findByNamedQueryAndNamedParam(
                "LegacyItem.findLowStockHql", "threshold", 20);
    }

    // ------------------------------------------------------------------
    // 形态 16：无别名 HQL + 嵌入段限定符位（O-71 用户报障同形）
    //  - 无别名写法 → 裸属性 warehouseId（T-01 裸属性映射）
    //  - 嵌入段开头的 updateInfo.createdTime（T-02 嵌入段限定符位剥离）
    // ------------------------------------------------------------------

    @Override
    public List<WmsDockBooking> findByNoAliasEmbedded(String warehouseId, LocalDateTime minTime) {
        String hql = "from WmsDockBooking where warehouseId = :warehouseId and updateInfo.createdTime >= :minTime";
        return commonDao.findByQuery(hql, "warehouseId", warehouseId, "minTime", minTime);
    }

    // ------------------------------------------------------------------
    // 形态 17：HQL UPDATE SET 子句嵌入段限定符位
    //  - SET 位 booking.updateInfo.createdTime（形态 6 的 SET 只落普通属性）
    //  - WHERE 位普通属性 id，对照 SET 位的嵌入段路径
    // ------------------------------------------------------------------

    @Override
    @Transactional(transactionManager = "hibernateTransactionManager")
    public int updateEmbeddedCreatedTime(Long id, LocalDateTime createdTime) {
        // bulkUpdate(String, Object...) 变参绑定从 0 起步，与 ?1/?2 编号占位不兼容
        // （实测抛 "Could not locate ordinal parameter [0], expecting one of [1, 2]"），
        // 与 iterateLegacyItems 同坑：改 executeWithNativeSession 回调内显式按序号绑定
        return hibernateTemplate.executeWithNativeSession(session -> session.createQuery(
                        "update WmsDockBooking booking set booking.updateInfo.createdTime = ?2 where booking.id = ?1")
                .setParameter(1, id)
                .setParameter(2, createdTime)
                .executeUpdate());
    }

    // ------------------------------------------------------------------
    // 形态 18：带 FROM 的 HQL DELETE + 嵌入段路径
    //  - `delete from WmsDockBooking booking where booking.updateInfo.createdTime < ?1`
    //  - JPQL 标准 DELETE 形态（带 FROM）：WHERE 位嵌入段路径
    //    booking.updateInfo.createdTime（T-02 剥离），与形态 7 普通属性 DELETE 对照
    // ------------------------------------------------------------------

    @Override
    @Transactional(transactionManager = "hibernateTransactionManager")
    public int deleteByEmbeddedCreatedTimeBefore(LocalDateTime maxTime) {
        // 形态 17 同款写法：executeWithNativeSession 回调内显式按序号绑定
        // （HQL 里 ?1 对应 setParameter 首参索引 1）
        return hibernateTemplate.executeWithNativeSession(session -> session.createQuery(
                        "delete from WmsDockBooking booking where booking.updateInfo.createdTime < ?1")
                .setParameter(1, maxTime)
                .executeUpdate());
    }

    // ------------------------------------------------------------------
    // 形态 19：带 FROM 的 SELECT + 嵌入段路径与普通属性混合（回归保护语料）
    //  - WHERE 位嵌入段 booking.updateInfo.createdTime 与普通属性 booking.warehouseId 混合
    //  - 带完整 FROM 的常规形态：验证嵌入段映射修复不影响既有普通属性映射
    // ------------------------------------------------------------------

    @Override
    public List<WmsDockBooking> findByEmbeddedCreatedTimeAndWarehouse(String warehouseId, LocalDateTime minTime) {
        return hibernateTemplate.executeWithNativeSession(session -> session.createQuery(
                        "select booking from WmsDockBooking booking where booking.updateInfo.createdTime >= ?1 and booking.warehouseId = ?2")
                .setParameter(1, minTime)
                .setParameter(2, warehouseId)
                .getResultList());
    }
}