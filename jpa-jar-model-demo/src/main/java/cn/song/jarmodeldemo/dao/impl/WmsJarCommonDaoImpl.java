package cn.song.jarmodeldemo.dao.impl;

import cn.song.jarmodeldemo.dao.WmsJarCommonDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * {@link WmsJarCommonDao} 实现（EntityManager 版）。
 *
 * <p>实现方式与插件识别无关——插件按「qualifier 名以 Dao 结尾 + 方法名含 Query +
 * 首参内容像 HQL」认领这条调用，不看实现体。
 *
 * @author SongRenShuo
 */
@org.springframework.stereotype.Repository
public class WmsJarCommonDaoImpl implements WmsJarCommonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findByQuery(String hql, Object... params) {
        Query query = entityManager.createQuery(hql);
        if (params != null) {
            bindNameValuePairs(query, params);
        }
        return query.getResultList();
    }

    @Override
    public List<?> findByQueryMaxNum(String hql, String[] paramNames, Object[] paramValues, int start, int max) {
        Query query = entityManager.createQuery(hql);
        bindArrays(query, paramNames, paramValues);
        if (start > 0) {
            query.setFirstResult(start);
        }
        if (max > 0) {
            query.setMaxResults(max);
        }
        return query.getResultList();
    }

    @Override
    public void save(Object entity) {
        entityManager.persist(entity);
    }

    /** name-value 交替：(name1, value1, name2, value2) */
    private void bindNameValuePairs(Query query, Object[] params) {
        for (int i = 0; i + 1 < params.length; i += 2) {
            query.setParameter(String.valueOf(params[i]), params[i + 1]);
        }
    }

    /** 名字数组 + 值数组（老式 DAO 双数组传参） */
    private void bindArrays(Query query, String[] paramNames, Object[] paramValues) {
        if (paramNames == null || paramValues == null) {
            return;
        }
        int size = Math.min(paramNames.length, paramValues.length);
        for (int i = 0; i < size; i++) {
            query.setParameter(paramNames[i], paramValues[i]);
        }
    }
}
