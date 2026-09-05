package cn.song.mybatisplusdemo.service.impl;

import cn.song.mybatisplusdemo.common.BeanCruder;
import cn.song.mybatisplusdemo.common.BeanQuery;
import cn.song.mybatisplusdemo.common.PaginResult;
import cn.song.mybatisplusdemo.dto.ScheduleVO;
import cn.song.mybatisplusdemo.service.StringSqlDaoDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 自研框架字符串 SQL 预览示例实现
 * <p>
 * 三个方法复刻用户真实项目三种形态（SQL 预览插件验收锚点）：
 * <ol>
 *   <li>{@link #getScheduleList}：方法内 UNION ALL / CASE WHEN 长拼接 + 命名参数
 *       {@code :CUR_USER}，经 {@code beanCruder.selectList(Class, sql, 名值对...)} 执行——
 *       插件应在调用行与方法定义名行均可预览拼接展开后的完整 SQL；</li>
 *   <li>{@link #selectListPagination(Class, String, Map, int, int)}：包装层把 sql 存入
 *       PaginQuery 后层层委托——SQL 以参数/对象字段形态流转，插件在方法定义名行提供入口；</li>
 *   <li>{@link #selectOneSummary}：聚合统计 SQL + {@code beanCruder.selectOne}。</li>
 * </ol>
 *
 * @author SongRenShuo
 */
@Service
public class StringSqlDaoDemoServiceImpl implements StringSqlDaoDemoService {

    @Autowired
    private BeanCruder beanCruder;

    @Autowired
    private BeanQuery beanQuery;

    /**
     * 形态一：拼接 SQL 变量 + beanCruder.selectList(Class, sql, "CUR_USER", userId)
     */
    @Override
    public List<ScheduleVO> getScheduleList(Long userId) {
        String sql = "SELECT " +
                "  ROW_NUMBER() OVER (ORDER BY wp.PROC_NAME) as task_id, " +
                "  wp.PROC_NAME as task_name, " +
                "  count(1) as task_number, " +
                "  wp.PROC_DEF_KEY as flow_key " +
                "FROM " +
                "  WKFL_TASK WT " +
                "JOIN WKFL_PROC wp ON WT.PROC_ID = wp.PROC_ID " +
                "LEFT JOIN WKFL_SOLICIT ws ON wp.PROC_ID = ws.PROC_ID " +
                "WHERE " +
                "  WT.FINISH_TYPE IS NULL " +
                "  AND WT.OWNER = :CUR_USER " +
                "GROUP BY " +
                "  wp.PROC_DEF_KEY " +
                "UNION ALL " +
                "SELECT " +
                "  ROW_NUMBER() OVER (ORDER BY wp.PROC_NAME) as task_id, " +
                "  CASE " +
                "    WHEN cd.policy_name LIKE '%创业担%' THEN '(创业担)担保函申请受理' " +
                "    ELSE '(非创业担)担保函申请受理' " +
                "  END AS task_name, " +
                "  count(1) as task_number, " +
                "  CASE " +
                "    WHEN cd.policy_name LIKE '%创业担%' THEN 'CoreApplyDutiesEntrep' " +
                "    ELSE 'CoreApplyDutiesNotEntrep' " +
                "  END AS flow_key " +
                "FROM " +
                "  WKFL_TASK WT " +
                "JOIN WKFL_PROC wp ON WT.PROC_ID = wp.PROC_ID " +
                "LEFT JOIN core_apply_duties cd ON wp.object_id = cd.apply_id " +
                "WHERE " +
                "  WT.FINISH_TYPE IS NULL " +
                "  AND WT.OWNER = :CUR_USER " +
                "GROUP BY " +
                "  CASE " +
                "    WHEN cd.policy_name LIKE '%创业担%' THEN '(创业担)担保函申请受理' " +
                "    ELSE '(非创业担)担保函申请受理' " +
                "  END ";
        List<ScheduleVO> scheduleVOList = beanCruder.selectList(ScheduleVO.class, sql, "CUR_USER", userId);
        return scheduleVOList;
    }

    /**
     * 形态二：分页包装层 —— 组装 PaginQuery 后委托执行层
     */
    @Override
    public PaginResult<ScheduleVO> selectListPagination(Class<ScheduleVO> classType, String sql,
                                                        Map<String, ?> paramMap, int index, int size) {
        PaginResult<ScheduleVO> result = beanQuery.selectListPagination(classType, sql, paramMap, index, size);
        return result;
    }

    /**
     * 形态三：聚合统计 + beanCruder.selectOne
     */
    @Override
    public ScheduleVO selectOneSummary(String procDefKey) {
        String sql = "SELECT wp.PROC_DEF_KEY as flow_key, count(1) as task_number " +
                "FROM WKFL_TASK WT " +
                "JOIN WKFL_PROC wp ON WT.PROC_ID = wp.PROC_ID " +
                "WHERE WT.FINISH_TYPE IS NULL AND wp.PROC_DEF_KEY = :procDefKey " +
                "GROUP BY wp.PROC_DEF_KEY ";
        return beanCruder.selectOne(ScheduleVO.class, sql, "procDefKey", procDefKey);
    }
}
