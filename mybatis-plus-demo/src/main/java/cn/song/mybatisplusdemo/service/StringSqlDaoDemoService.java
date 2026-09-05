package cn.song.mybatisplusdemo.service;

import cn.song.mybatisplusdemo.common.PaginResult;
import cn.song.mybatisplusdemo.dto.ScheduleVO;

import java.util.List;
import java.util.Map;

/**
 * 自研框架字符串 SQL 预览示例 Service
 * 覆盖「Java 拼接 SQL + 自研 DAO 层执行」的 SQL 预览场景
 *
 * @author SongRenShuo
 */
public interface StringSqlDaoDemoService {

    /**
     * 形态一：方法内拼接 SQL 变量 → beanCruder.selectList(Class, sql, 名值对...)
     */
    List<ScheduleVO> getScheduleList(Long userId);

    /**
     * 形态二：分页包装层 —— (Class, sql, paramMap, index, size) → PaginQuery → 委托
     */
    PaginResult<ScheduleVO> selectListPagination(Class<ScheduleVO> classType, String sql,
                                                 Map<String, ?> paramMap, int index, int size);

    /**
     * 形态三：单条统计 —— beanCruder.selectOne(Class, sql, 名值对...)
     */
    ScheduleVO selectOneSummary(String procDefKey);
}
