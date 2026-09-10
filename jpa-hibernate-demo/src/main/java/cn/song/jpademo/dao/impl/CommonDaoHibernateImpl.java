package cn.song.jpademo.dao.impl;

import cn.song.jpademo.dao.CommonDao;
import cn.song.jpademo.entity.WmsAsn;
import cn.song.jpademo.entity.WmsDockBooking;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 老式 Spring DAO 实现类（HibernateDaoSupport + HibernateTemplate 全套示例）。
 *
 * 插件识别定位在 Service 层调用处（commonDao.findByQueryUniqueResult(...)），
 * 实现类里的 HibernateTemplate/session.createQuery 用法同时作为 API 参考示例：
 * HibernateTemplate 是 Spring 对 Hibernate Session 的模板封装（org.springframework.orm.hibernate5）。
 *
 * @author SongRenShuo
 */
@Repository
public class CommonDaoHibernateImpl extends HibernateDaoSupport implements CommonDao {

    /**
     * 注入方式：HibernateDaoSupport.setHibernateTemplate（@Resource 注入 Spring 容器中的 HibernateTemplate bean，
     * 见 cn.song.jpademo.config.HibernateTemplateConfig）。
     */
    @Resource
    public void setHibernateTemplateBean(HibernateTemplate hibernateTemplate) {
        super.setHibernateTemplate(hibernateTemplate);
    }

    /**
     * 查询唯一结果：HibernateTemplate.execute(HibernateCallback) + Session.createQuery + 按名绑定。
     *
     * 与用户反馈截图 2 的实现类逻辑一致：遍历参数名/值数组逐项 setParameter。
     *
     * @param hql        HQL 查询语句
     * @param paramNames 参数名数组
     * @param paramValues 参数值数组（与 paramNames 按索引一一对应）
     * @return 唯一结果
     */
    @Override
    public Object findByQueryUniqueResult(final String hql, final String[] paramNames, final Object[] paramValues) {
        return getHibernateTemplate().execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) {
                Query<?> query = session.createQuery(hql);
                if (paramNames != null) {
                    for (int i = 0; i < paramNames.length; i++) {
                        // 集合值走 setParameterList，单值走 setParameter（老代码通用写法）
                        if (paramValues[i] instanceof java.util.Collection) {
                            query.setParameterList(paramNames[i], (java.util.Collection<?>) paramValues[i]);
                        } else {
                            query.setParameter(paramNames[i], paramValues[i]);
                        }
                    }
                }
                return query.uniqueResult();
            }
        });
    }

    /**
     * 查询列表：HibernateTemplate.findByNamedParam（名字数组 + 值数组）。
     *
     * 变长参数若为 name-value 交替形态，先拆成名字/值两个数组再委托给 findByNamedParam。
     *
     * @param hql    HQL 查询语句
     * @param params name-value 交替参数 或 位置值（无名字）
     * @return 结果列表
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> findByQuery(String hql, Object... params) {
        if (params.length == 1 && params[0] instanceof java.util.Map) {
            // Map 单参数形态：每个 entry 一个命名参数
            java.util.Map<String, Object> paramMap = (java.util.Map<String, Object>) params[0];
            String[] mapNames = new String[paramMap.size()];
            Object[] mapValues = new Object[paramMap.size()];
            int idx = 0;
            for (java.util.Map.Entry<String, Object> entry : paramMap.entrySet()) {
                mapNames[idx] = entry.getKey();
                mapValues[idx] = entry.getValue();
                idx++;
            }
            return (List<T>) getHibernateTemplate().findByNamedParam(hql, mapNames, mapValues);
        }
        if (params.length >= 2 && params[0] instanceof String
                && hql.contains(":" + params[0])) {
            // name-value 交替形态：(name1, value1, name2, value2)
            // 判定依据：偶数下标是字符串且在 HQL 中以 :name 形式出现
            String[] names = new String[params.length / 2];
            Object[] values = new Object[params.length / 2];
            for (int i = 0; i + 1 < params.length; i += 2) {
                names[i / 2] = (String) params[i];
                values[i / 2] = params[i + 1];
            }
            return (List<T>) getHibernateTemplate().findByNamedParam(hql, names, values);
        }
        // 位置参数形态：?1 编号占位 + setParameter(1..n) 绑定。
        // 不能走 HibernateTemplate.find(String, Object...)——它按 0 起步 setParameter(i, value)，
        // Hibernate 5.2+ 位置参数从 1 起，会抛 "Could not locate ordinal parameter [0]"
        return (List<T>) getHibernateTemplate().execute(
                (org.springframework.orm.hibernate5.HibernateCallback<List<T>>) session -> {
                    org.hibernate.query.Query<T> query = session.createQuery(hql);
                    for (int i = 0; i < params.length; i++) {
                        query.setParameter(i + 1, params[i]);
                    }
                    return query.list();
                });
    }

    /**
     * UPDATE/DELETE 执行：HibernateTemplate.execute + createQuery.executeUpdate。
     *
     * @param hql    UPDATE/DELETE HQL
     * @param params name-value 交替参数
     * @return 受影响行数
     */
    @Override
    public int execute(final String hql, final Object... params) {
        return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
            @Override
            public Integer doInHibernate(Session session) {
                Query<?> query = session.createQuery(hql);
                for (int i = 0; i + 1 < params.length; i += 2) {
                    query.setParameter((String) params[i], params[i + 1]);
                }
                return query.executeUpdate();
            }
        });
    }

    /**
     * 命名参数查询：直接委托 HibernateTemplate.findByNamedParam。
     *
     * @param hql        HQL 查询语句
     * @param paramNames 参数名数组
     * @param paramValues 参数值数组
     * @return 结果列表
     */
    @Override
    public List<?> findByNamedParam(String hql, String[] paramNames, Object[] paramValues) {
        return getHibernateTemplate().findByNamedParam(hql, paramNames, paramValues);
    }

    // ------------------------------------------------------------------
    // HibernateTemplate 基础 CRUD API 示例（get/load/save/saveOrUpdate/update/delete/merge/deleteAll）
    // ------------------------------------------------------------------

    /**
     * HibernateTemplate.get：立即加载单条。
     */
    public WmsDockBooking getBooking(Long id) {
        return getHibernateTemplate().get(WmsDockBooking.class, id);
    }

    /**
     * HibernateTemplate.load：延迟加载单条（仅当实体存在，否则 ObjectNotFoundException）。
     */
    public WmsDockBooking loadBooking(Long id) {
        return getHibernateTemplate().load(WmsDockBooking.class, id);
    }

    /**
     * HibernateTemplate.load(Class, Serializable, LockMode)：带锁加载。
     */
    public WmsDockBooking loadWithLock(Long id) {
        return getHibernateTemplate().load(WmsDockBooking.class, id,
                org.hibernate.LockMode.PESSIMISTIC_WRITE);
    }

    /**
     * HibernateTemplate.save / saveOrUpdate / update / merge / delete / deleteAll。
     */
    public Serializable saveBooking(WmsDockBooking booking) {
        return getHibernateTemplate().save(booking);
    }

    public void saveOrUpdateBooking(WmsDockBooking booking) {
        getHibernateTemplate().saveOrUpdate(booking);
    }

    public void updateBooking(WmsDockBooking booking) {
        getHibernateTemplate().update(booking);
    }

    public WmsDockBooking mergeBooking(WmsDockBooking booking) {
        return getHibernateTemplate().merge(booking);
    }

    public void deleteBooking(WmsDockBooking booking) {
        getHibernateTemplate().delete(booking);
    }

    public void deleteAllBookings(List<WmsDockBooking> bookings) {
        getHibernateTemplate().deleteAll(bookings);
    }

    public void deleteAsnById(Long id) {
        getHibernateTemplate().delete(getHibernateTemplate().load(WmsAsn.class, id));
    }

    /**
     * HibernateTemplate.find(String)：无参 HQL 查询。
     */
    public List<?> findAllAsn() {
        return getHibernateTemplate().find("from WmsAsn");
    }

    /**
     * HibernateTemplate.find(String, Object...)：位置参数查询（已废弃，仅演示形态）。
     */
    @SuppressWarnings("deprecation")
    public List<?> findBookingByTypePositional(String type) {
        return getHibernateTemplate().find(
                "from WmsDockBooking booking where booking.type = ?", type);
    }

    /**
     * HibernateTemplate.findByValueBean：以实体属性为参数条件（属性名=参数名）。
     */
    public List<?> findBookingByValueBean(WmsDockBooking sample) {
        return getHibernateTemplate().findByValueBean(
                "from WmsDockBooking booking where booking.warehouseId = :warehouseId", sample);
    }

    /**
     * HibernateTemplate 实例级配置示例：setCacheQueries/setFetchSize/setMaxResults。
     * 注意：maxResults 是模板实例级属性，多调用方共享；分页应走 execute 回调内 query.setMaxResults。
     * （spring-orm 5.3.x 已无 FLUSH_AUTO 常量与 setAllowCreate——javap 实证，勿调用不存在的 API）
     */
    public void configureTemplate() {
        getHibernateTemplate().setCacheQueries(true);
        getHibernateTemplate().setFetchSize(50);
        getHibernateTemplate().setMaxResults(200);
    }

    // ------------------------------------------------------------------
    // execute 回调内 Session 全套 API（createQuery/setMaxResults/setFirstResult/setParameterList/
    // createSQLQuery）：分页示例 + IN 集合示例 + 原生 SQL 示例
    // ------------------------------------------------------------------

    /**
     * execute 回调内分页：session.createQuery + setFirstResult/setMaxResults。
     */
    public List<?> findBookingByPage(final String warehouseId, final int first, final int max) {
        return getHibernateTemplate().execute(new HibernateCallback<List<?>>() {
            @Override
            public List<?> doInHibernate(Session session) {
                Query<?> query = session.createQuery(
                        "from WmsDockBooking booking where booking.warehouseId = :warehouseId");
                query.setFirstResult(first);
                query.setMaxResults(max);
                return query.list();
            }
        });
    }

    /**
     * execute 回调内 IN 集合：setParameterList。
     */
    public List<?> findBookingByIdList(final List<Long> idList) {
        return getHibernateTemplate().execute(new HibernateCallback<List<?>>() {
            @Override
            public List<?> doInHibernate(Session session) {
                return session.createQuery(
                        "from WmsDockBooking booking where booking.id in (:idList)")
                        .setParameterList("idList", idList)
                        .list();
            }
        });
    }

    /**
     * execute 回调内原生 SQL：Session.createSQLQuery（HQL 之外的原生方言 SQL）。
     */
    public List<?> nativeCount(final String warehouseId) {
        return getHibernateTemplate().execute(new HibernateCallback<List<?>>() {
            @Override
            public List<?> doInHibernate(Session session) {
                return session.createSQLQuery(
                        "select status, count(1) from wms_dock_booking where warehouse_id = :warehouseId group by status")
                        .setParameter("warehouseId", warehouseId)
                        .list();
            }
        });
    }

    /**
     * 便捷批量示例：saveAll 循环 save。
     */
    public void saveAllBookings(List<WmsDockBooking> bookings) {
        for (WmsDockBooking booking : bookings) {
            getHibernateTemplate().save(booking);
        }
    }

    /**
     * 便捷清空示例：clear 清除一级缓存。
     */
    public void clearCache() {
        getHibernateTemplate().clear();
    }
}