package cn.song.mybatisplusdemo.controller;

import cn.song.mybatisplusdemo.common.PaginResult;
import cn.song.mybatisplusdemo.dto.ScheduleVO;
import cn.song.mybatisplusdemo.service.StringSqlDaoDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 自研框架字符串 SQL 预览示例控制器
 * 演示 Java 拼接 SQL + 自研 DAO 层（BeanCruder / BeanQuery）执行的 SQL 预览场景
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/stringSqlDao")
public class StringSqlDaoDemoController {

    @Autowired
    private StringSqlDaoDemoService stringSqlDaoDemoService;

    /**
     * 1. 形态一：方法内拼接 SQL + beanCruder.selectList
     * GET /stringSqlDao/scheduleList?userId=1
     */
    @GetMapping("/scheduleList")
    public List<ScheduleVO> getScheduleList(@RequestParam Long userId) {
        return stringSqlDaoDemoService.getScheduleList(userId);
    }

    /**
     * 2. 形态二：分页包装层（Class + sql + paramMap + index + size → PaginQuery → 委托）
     * POST /stringSqlDao/pagination
     */
    @PostMapping("/pagination")
    public PaginResult<ScheduleVO> selectListPagination(@RequestBody Map<String, Object> body) {
        String sql = String.valueOf(body.get("sql"));
        @SuppressWarnings("unchecked")
        Map<String, ?> paramMap = (Map<String, ?>) body.get("paramMap");
        int index = body.get("index") == null ? 1 : Integer.parseInt(String.valueOf(body.get("index")));
        int size = body.get("size") == null ? 10 : Integer.parseInt(String.valueOf(body.get("size")));
        return stringSqlDaoDemoService.selectListPagination(ScheduleVO.class, sql, paramMap, index, size);
    }

    /**
     * 3. 形态三：聚合统计 + beanCruder.selectOne
     * GET /stringSqlDao/summary?procDefKey=CoreApplyDuties
     */
    @GetMapping("/summary")
    public ScheduleVO selectOneSummary(@RequestParam String procDefKey) {
        return stringSqlDaoDemoService.selectOneSummary(procDefKey);
    }
}
