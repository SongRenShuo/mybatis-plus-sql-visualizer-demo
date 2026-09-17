package cn.song.multiormdemo.service.impl;

import cn.song.multiormdemo.entity.MemberEntity;
import cn.song.multiormdemo.entity.QMemberEntity;
import cn.song.multiormdemo.service.QuerydslService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Querydsl 查询服务实现（Q 类表达式树语料，插件 QuerydslConverter 对齐用例）
 *
 * @author SongRenShuo
 */
@Service("querydslService")
public class QuerydslServiceImpl implements QuerydslService {

    @Resource
    private JPAQueryFactory queryFactory;

    /**
     * selectFrom + where + orderBy + fetch
     * SELECT ... FROM orm_member WHERE status = ? ORDER BY id DESC
     */
    @Override
    public List<MemberEntity> queryByStatus(Integer status) {
        QMemberEntity member = QMemberEntity.memberEntity;
        return queryFactory.selectFrom(member)
                .where(member.status.eq(status))
                .orderBy(member.id.desc())
                .fetch();
    }

    /**
     * BooleanBuilder 动态条件组合
     */
    @Override
    public List<MemberEntity> queryByBooleanBuilder(String city, Integer maxAge) {
        QMemberEntity member = QMemberEntity.memberEntity;
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(member.status.eq(1));
        if (city != null) {
            builder.and(member.city.eq(city));
        }
        if (maxAge != null) {
            builder.and(member.age.loe(maxAge));
        }
        return queryFactory.selectFrom(member)
                .where(builder)
                .fetch();
    }

    /**
     * 聚合投影：SELECT city, COUNT(*) FROM orm_member GROUP BY city
     */
    @Override
    public List<Map<String, Object>> groupByCity() {
        QMemberEntity member = QMemberEntity.memberEntity;
        List<Tuple> tuples = queryFactory.select(member.city, member.id.count())
                .from(member)
                .groupBy(member.city)
                .fetch();
        List<Map<String, Object>> rows = new ArrayList<>();
        for (Tuple tuple : tuples) {
            Map<String, Object> row = new HashMap<>(2);
            row.put("city", tuple.get(member.city));
            row.put("cnt", tuple.get(member.id.count()));
            rows.add(row);
        }
        return rows;
    }

    /**
     * JPAUpdateClause：UPDATE orm_member SET status = 0 WHERE id = ?
     */
    @Override
    @Transactional
    public long disableById(Long id) {
        QMemberEntity member = QMemberEntity.memberEntity;
        JPAUpdateClause update = queryFactory.update(member);
        return update.where(member.id.eq(id))
                .set(member.status, 0)
                .execute();
    }

    /**
     * JPADeleteClause：DELETE FROM orm_member WHERE status = 0
     */
    @Override
    @Transactional
    public long deleteDisabled() {
        QMemberEntity member = QMemberEntity.memberEntity;
        JPADeleteClause delete = queryFactory.delete(member);
        return delete.where(member.status.eq(0))
                .execute();
    }
}
