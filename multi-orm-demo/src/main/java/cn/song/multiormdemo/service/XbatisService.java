package cn.song.multiormdemo.service;

import cn.song.multiormdemo.entity.XbMember;

import java.util.List;

/**
 * xbatis 查询服务（QueryChain/UpdateChain/DeleteChain 语料）
 *
 * @author SongRenShuo
 */
public interface XbatisService {

    /**
     * QueryChain.of(mapper)：eq + gte + like(LikeMode) + orderByDesc + list
     */
    List<XbMember> queryActiveAdults(String nameFragment);

    /**
     * QueryChain.of(mapper, entityClass)：andNested 嵌套组
     */
    List<XbMember> queryByNested(Integer status, Integer minAge);

    /**
     * QueryChain.create()：count 终结
     */
    Integer countEnabled();

    /**
     * UpdateChain：set + eq + execute
     */
    int disableById(Long id);

    /**
     * DeleteChain：eq + execute
     */
    int deleteDisabled();
}
