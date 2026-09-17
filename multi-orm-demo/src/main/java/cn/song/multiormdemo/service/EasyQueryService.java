package cn.song.multiormdemo.service;

import cn.song.multiormdemo.entity.MemberEntity;

import java.util.List;

/**
 * Easy-Query 查询服务（easyEntityQuery proxy 风格语料）
 *
 * @author SongRenShuo
 */
public interface EasyQueryService {

    /**
     * queryable + where proxy + toList
     */
    List<MemberEntity> queryEnabled();

    /**
     * 多条件 proxy 链
     */
    List<MemberEntity> queryByCityAndAge(String city, Integer minAge);

    /**
     * insertable 插入
     */
    long insertMember(MemberEntity member);

    /**
     * updatable + setColumns 表达式更新
     */
    long disableById(Long id);

    /**
     * deletable 条件删除
     */
    long deleteDisabled();
}
