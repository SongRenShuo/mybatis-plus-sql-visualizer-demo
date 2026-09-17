package cn.song.multiormdemo.service.impl;

import cn.song.multiormdemo.service.MdsService;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * MyBatis Dynamic SQL 服务实现（插件 MdsConverter 对齐用例）
 * SqlTable 常量 + DSL 构建 + render 渲染 + JdbcTemplate 执行
 *
 * @author SongRenShuo
 */
@Service("mdsService")
public class MdsServiceImpl implements MdsService {

    /**
     * 表与列常量（SqlTable 静态声明形态，column(String) 泛型按赋值目标推断）
     */
    private static final SqlTable MEMBER = SqlTable.of("orm_member");
    private static final SqlColumn<Long> ID = MEMBER.column("id");
    private static final SqlColumn<String> NAME = MEMBER.column("name");
    private static final SqlColumn<Integer> AGE = MEMBER.column("age");
    private static final SqlColumn<Integer> STATUS = MEMBER.column("status");

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * SelectDSL：SELECT id, name FROM orm_member WHERE status = :p1 AND age > :p2 ORDER BY id DESC
     * render(SPRING_NAMED_PARAMETER) 产出命名参数，须经 NamedParameterJdbcTemplate 执行
     */
    @Override
    public List<Map<String, Object>> queryByStatus(Integer status, Integer minAge) {
        SelectStatementProvider provider = SqlBuilder.select(ID, NAME)
                .from(MEMBER)
                .where(STATUS, SqlBuilder.isEqualTo(status))
                .and(AGE, SqlBuilder.isGreaterThan(minAge))
                .orderBy(ID.descending())
                .build()
                .render(RenderingStrategies.SPRING_NAMED_PARAMETER);
        return namedParameterJdbcTemplate.queryForList(provider.getSelectStatement(), provider.getParameters());
    }

    /**
     * UpdateDSL：UPDATE orm_member SET status = :p1 WHERE id = :p2
     */
    @Override
    public int disableById(Long id) {
        UpdateStatementProvider provider = SqlBuilder.update(MEMBER)
                .set(STATUS).equalTo(0)
                .where(ID, SqlBuilder.isEqualTo(id))
                .build()
                .render(RenderingStrategies.SPRING_NAMED_PARAMETER);
        return namedParameterJdbcTemplate.update(provider.getUpdateStatement(), provider.getParameters());
    }

    /**
     * DeleteDSL：DELETE FROM orm_member WHERE status = :p1
     */
    @Override
    public int deleteDisabled() {
        DeleteStatementProvider provider = SqlBuilder.deleteFrom(MEMBER)
                .where(STATUS, SqlBuilder.isEqualTo(0))
                .build()
                .render(RenderingStrategies.SPRING_NAMED_PARAMETER);
        return namedParameterJdbcTemplate.update(provider.getDeleteStatement(), provider.getParameters());
    }
}
