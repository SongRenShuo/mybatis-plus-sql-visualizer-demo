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
}