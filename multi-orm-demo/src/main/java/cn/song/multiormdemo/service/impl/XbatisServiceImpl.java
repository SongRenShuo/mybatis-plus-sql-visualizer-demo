package cn.song.multiormdemo.service.impl;

import cn.song.multiormdemo.entity.XbMember;
import cn.song.multiormdemo.mapper.XbMemberMapper;
import cn.song.multiormdemo.service.XbatisService;
import cn.xbatis.core.sql.executor.chain.DeleteChain;
import cn.xbatis.core.sql.executor.chain.QueryChain;
import cn.xbatis.core.sql.executor.chain.UpdateChain;
import db.sql.api.cmd.LikeMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * xbatis 查询服务实现（插件 XbatisConverter 对齐用例）
 * 条件方法名与 MP 高度重合，gte/lte、like(LikeMode,...)、andNested 由插件归一化
 *
 * @author SongRenShuo
 */
@Service("xbatisService")
public class XbatisServiceImpl implements XbatisService {

    @Resource
    private XbMemberMapper xbMemberMapper;

    /**
     * QueryChain.of(mapper)：
     * SELECT * FROM orm_member WHERE status = 1 AND age >= 18 AND name LIKE '%?%' ORDER BY id DESC
     */
    @Override
    public List<XbMember> queryActiveAdults(String nameFragment) {
        return QueryChain.of(xbMemberMapper)
                .eq(XbMember::getStatus, 1)
                .gte(XbMember::getAge, 18)
                .like(LikeMode.DEFAULT, XbMember::getName, nameFragment)
                .orderByDesc(XbMember::getId)
                .list();
    }

    /**
     * QueryChain.of(mapper, entityClass) + andNested 嵌套条件组
     */
    @Override
    public List<XbMember> queryByNested(Integer status, Integer minAge) {
        return QueryChain.of(xbMemberMapper, XbMember.class)
                .eq(XbMember::getStatus, status)
                .andNested(where -> where.gte(XbMember::getAge, minAge)
                        .isNotNull(XbMember::getCity))
                .list();
    }

    /**
     * QueryChain.of(mapper, entityClass) + count 终结
     * （create() 无实体上下文会抛 you need specify entityType，故 count 场景用 of 两参形态）
     */
    @Override
    public Integer countEnabled() {
        return QueryChain.of(xbMemberMapper, XbMember.class)
                .eq(XbMember::getStatus, 1)
                .count();
    }

    /**
     * UpdateChain：UPDATE orm_member SET status = 0 WHERE id = ?
     */
    @Override
    @Transactional
    public int disableById(Long id) {
        return UpdateChain.of(xbMemberMapper)
                .set(XbMember::getStatus, 0)
                .eq(XbMember::getId, id)
                .execute();
    }

    /**
     * DeleteChain：DELETE FROM orm_member WHERE status = 0
     */
    @Override
    @Transactional
    public int deleteDisabled() {
        return DeleteChain.of(xbMemberMapper)
                .eq(XbMember::getStatus, 0)
                .execute();
    }
}
