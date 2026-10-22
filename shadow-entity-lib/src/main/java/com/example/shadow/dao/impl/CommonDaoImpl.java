package com.example.shadow.dao.impl;

import com.example.shadow.dao.CommonDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * {@link CommonDao} 的实现（EntityManager 版）——<b>也在 JAR 里</b>。
 *
 * <p>运行期由宿主工程的组件扫描（{@code com.example.shadow}）装配本类；编译期
 * {@code javax.persistence} 由本模块 provided 作用域依赖提供。
 *
 * @author SongRenShuo
 */
@org.springframework.stereotype.Repository
public class CommonDaoImpl implements CommonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findByQuery(String hql, String[] paramNames, Object[] values) {
        Query query = entityManager.createQuery(hql);
        if (paramNames != null && values != null) {
            int size = Math.min(paramNames.length, values.length);
            for (int i = 0; i < size; i++) {
                query.setParameter(paramNames[i], values[i]);
            }
        }
        return query.getResultList();
    }
}
