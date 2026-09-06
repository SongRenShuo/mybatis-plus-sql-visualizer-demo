package cn.song.jpademo.dao.impl;

import cn.song.jpademo.dao.LegacyItemDao;
import cn.song.jpademo.entity.LegacyItem;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * 遗留库存项 DAO 实现——原生 Hibernate Session HQL（hbm.xml 实体）
 *
 * @author SongRenShuo
 */
@Repository("legacyItemDao")
public class LegacyItemDaoImpl implements LegacyItemDao {

    private final SessionFactory sessionFactory;

    public LegacyItemDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * HQL 查询 hbm.xml 实体（FROM LegacyItem ...）
     */
    @Override
    @SuppressWarnings({"unchecked", "deprecation"})
    public List<LegacyItem> findByQuery(String hql) {
        return sessionFactory.openSession().createQuery(hql).list();
    }

    /**
     * HQL 位置参数绑定
     */
    @Override
    @SuppressWarnings({"unchecked", "deprecation"})
    public List<LegacyItem> queryByHql(String hql, Object[] params) {
        org.hibernate.query.Query<LegacyItem> query = sessionFactory.openSession().createQuery(hql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        return query.list();
    }

    /**
     * HQL 分页（setFirstResult/setMaxResults）
     */
    @Override
    public List<LegacyItem> queryByHqlPaged(String hql, int offset, int limit) {
        TypedQuery<LegacyItem> query = sessionFactory
                .createEntityManager().createQuery(hql, LegacyItem.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }
}
