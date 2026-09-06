package cn.song.jpademo.dao;

import cn.song.jpademo.entity.LegacyItem;

import java.util.List;

/**
 * 遗留库存项 DAO——自研 DAO 命名约定（*Dao + findByQuery/*Hql 方法名）
 * 插件 CustomDaoHqlLocator 识别场景：qualifier 后缀 Dao + 方法名 Hql/Query 后缀 + HQL 内容
 *
 * @author SongRenShuo
 */
public interface LegacyItemDao {

    /**
     * HQL 全量查询（方法名 findByQuery 命中插件自定义 DAO 规则）
     */
    List<LegacyItem> findByQuery(String hql);

    /**
     * HQL 条件查询（方法名 queryByHql）
     */
    List<LegacyItem> queryByHql(String hql, Object[] params);

    /**
     * HQL 分页查询
     */
    List<LegacyItem> queryByHqlPaged(String hql, int offset, int limit);
}
