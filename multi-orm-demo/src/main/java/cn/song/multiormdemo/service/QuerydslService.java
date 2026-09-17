package cn.song.multiormdemo.service;

import cn.song.multiormdemo.entity.MemberEntity;

import java.util.List;

/**
 * Querydsl 查询服务（Q 类表达式树语料）
 *
 * @author SongRenShuo
 */
public interface QuerydslService {

    /**
     * selectFrom + where + orderBy + fetch
     */
    List<MemberEntity> queryByStatus(Integer status);

    /**
     * BooleanBuilder 动态条件组合
     */
    List<MemberEntity> queryByBooleanBuilder(String city, Integer maxAge);

    /**
     * 聚合投影（count + groupBy）
     */
    List<java.util.Map<String, Object>> groupByCity();

    /**
     * JPAUpdateClause 条件更新
     */
    long disableById(Long id);

    /**
     * JPADeleteClause 条件删除
     */
    long deleteDisabled();
}
