package cn.song.multiormdemo.service.impl;

import cn.song.multiormdemo.entity.MemberEntity;
import cn.song.multiormdemo.service.EasyQueryService;
import com.easy.query.api.proxy.client.EasyEntityQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Easy-Query 查询服务实现（插件 EasyQueryConverter 对齐用例）
 * proxy 风格：where(o -> o.status().eq(1))，proxy 类 MemberEntityTable 由 sql-processor 生成
 *
 * @author SongRenShuo
 */
@Service("easyQueryService")
public class EasyQueryServiceImpl implements EasyQueryService {

    @Resource
    private EasyEntityQuery easyEntityQuery;

    /**
     * queryable + where + toList
     * SELECT * FROM orm_member WHERE status = 1
     */
    @Override
    public List<MemberEntity> queryEnabled() {
        return easyEntityQuery.queryable(MemberEntity.class)
                .where(o -> o.status().eq(1))
                .toList();
    }

    /**
     * 多条件 proxy 链：语句块 lambda 内多个谓词语句（eq 返回 void，AND 即块内顺序语句）
     */
    @Override
    public List<MemberEntity> queryByCityAndAge(String city, Integer minAge) {
        return easyEntityQuery.queryable(MemberEntity.class)
                .where(o -> {
                    o.city().eq(city);
                    o.age().ge(minAge);
                })
                .toList();
    }

    /**
     * insertable：INSERT INTO orm_member(name, age, city, status) VALUES (?, ?, ?, ?)
     */
    @Override
    public long insertMember(MemberEntity member) {
        return easyEntityQuery.insertable(member).executeRows();
    }

    /**
     * updatable + setColumns：实体驱动 SET（UPDATE orm_member SET status = ? WHERE id = ?）
     * updatable(entity) + setColumns 指定参与 SET 的列，取值来自实体
     */
    @Override
    public long disableById(Long id) {
        MemberEntity patch = new MemberEntity();
        patch.setStatus(0);
        return easyEntityQuery.updatable(patch)
                .setColumns(u -> u.status())
                .where(o -> o.id().eq(id))
                .executeRows();
    }

    /**
     * deletable：DELETE FROM orm_member WHERE status = 0
     */
    @Override
    public long deleteDisabled() {
        return easyEntityQuery.deletable(MemberEntity.class)
                .where(o -> o.status().eq(0))
                .executeRows();
    }
}
