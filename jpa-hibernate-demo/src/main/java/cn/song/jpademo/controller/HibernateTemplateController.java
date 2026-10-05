package cn.song.jpademo.controller;

import cn.song.jpademo.entity.WmsDockBooking;
import cn.song.jpademo.service.HibernateTemplateDemoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * HibernateTemplate 老式 DAO 调用形态演示入口。
 *
 * 与 JpaQueryController 并列（/jpa/hib/...），各端点对应
 * HibernateTemplateDemoServiceImpl 中的一种调用形态。
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/jpa/hib")
public class HibernateTemplateController {

    @Resource
    private HibernateTemplateDemoService hibernateTemplateDemoService;

    /**
     * 形态 1（用户反馈同款）：拼接变量 + 名字数组/值数组传参
     */
    @GetMapping("/headData")
    public Object[] headData(
            @RequestParam String warehouseId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime) {
        return hibernateTemplateDemoService.getHeadData(warehouseId, startTime, endTime);
    }

    /**
     * 形态 2：字面量直传 + name-value 交替
     */
    @GetMapping("/byStatus")
    public List<WmsDockBooking> byStatus(@RequestParam String status) {
        return hibernateTemplateDemoService.listByStatus(status);
    }

    /**
     * 形态 5：Map 传参
     */
    @GetMapping("/activeByWarehouse")
    public List<WmsDockBooking> activeByWarehouse(
            @RequestParam String warehouseId, @RequestParam Integer status) {
        return hibernateTemplateDemoService.listActiveByWarehouse(warehouseId, status);
    }

    /**
     * 形态 6/7：UPDATE / DELETE
     */
    @PostMapping("/updateStatus")
    public Map<String, Object> updateStatus(@RequestParam Long id, @RequestParam String newStatus) {
        int rows = hibernateTemplateDemoService.updateStatusById(id, newStatus);
        return java.util.Collections.singletonMap("updated", rows);
    }

    @PostMapping("/deleteAsn")
    public Map<String, Object> deleteAsn(@RequestParam Long id) {
        int rows = hibernateTemplateDemoService.deleteAsnById(id);
        return java.util.Collections.singletonMap("deleted", rows);
    }

    /**
     * 形态 8：IN 集合
     */
    @GetMapping("/byIdList")
    public List<WmsDockBooking> byIdList(@RequestParam String ids) {
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(String::trim).map(Long::parseLong).collect(java.util.stream.Collectors.toList());
        return hibernateTemplateDemoService.findByIdList(idList);
    }

    /**
     * 形态 9：位置参数
     */
    @GetMapping("/byStatusPositional")
    public List<WmsDockBooking> byStatusPositional(@RequestParam String status) {
        return hibernateTemplateDemoService.findByStatusPositional(status);
    }

    /**
     * 形态 11：原生 SQL
     */
    @GetMapping("/nativeCount")
    public List<?> nativeCount(@RequestParam String warehouseId) {
        return hibernateTemplateDemoService.nativeDockCount(warehouseId);
    }

    /**
     * 形态 13：HibernateTemplate 基础 CRUD
     */
    @PostMapping("/crud")
    public WmsDockBooking crud(@RequestParam Long id, @RequestBody WmsDockBooking booking) {
        return hibernateTemplateDemoService.crudDemo(id, booking);
    }

    /**
     * 形态 14：bulkUpdate 批量 UPDATE
     * POST /jpa/hib/bulkUpdate?oldStatus=P&newStatus=C
     */
    @PostMapping("/bulkUpdate")
    public int bulkUpdate(@RequestParam String oldStatus, @RequestParam String newStatus) {
        return hibernateTemplateDemoService.bulkUpdateStatus(oldStatus, newStatus);
    }

    /**
     * 形态 15：findByNamedQueryAndNamedParam 命名查询
     * GET /jpa/hib/namedQueryLegacy
     */
    @GetMapping("/namedQueryLegacy")
    public List<?> findByNamedQueryLegacy() {
        return hibernateTemplateDemoService.findByNamedQueryLegacy();
    }

    /**
     * 形态 16：无别名 HQL + 嵌入段限定符位（O-71 用户报障同形）
     * GET /jpa/hib/byNoAliasEmbedded?warehouseId=WH001&minTime=2026-01-01T00:00:00
     */
    @GetMapping("/byNoAliasEmbedded")
    public List<WmsDockBooking> byNoAliasEmbedded(
            @RequestParam String warehouseId,
            @RequestParam(required = false) String minTime) {
        LocalDateTime min = minTime == null || minTime.isEmpty()
                ? LocalDateTime.now().minusDays(1)
                : LocalDateTime.parse(minTime);
        return hibernateTemplateDemoService.findByNoAliasEmbedded(warehouseId, min);
    }

    /**
     * 形态 17：HQL UPDATE SET 子句嵌入段限定符位
     * POST /jpa/hib/touchEmbedded?id=1&createdTime=2026-01-01T00:00:00
     */
    @PostMapping("/touchEmbedded")
    public Map<String, Object> touchEmbedded(
            @RequestParam Long id,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime createdTime) {
        int rows = hibernateTemplateDemoService.updateEmbeddedCreatedTime(id, createdTime);
        return java.util.Collections.singletonMap("updated", rows);
    }

    /**
     * 形态 18：带 FROM 的 HQL DELETE + 嵌入段路径
     * POST /jpa/hib/deleteByEmbeddedCreatedTime?maxTime=2026-01-01T00:00:00
     */
    @PostMapping("/deleteByEmbeddedCreatedTime")
    public Map<String, Object> deleteByEmbeddedCreatedTime(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime maxTime) {
        int rows = hibernateTemplateDemoService.deleteByEmbeddedCreatedTimeBefore(maxTime);
        return java.util.Collections.singletonMap("deleted", rows);
    }

    /**
     * 形态 19：带 FROM 的 SELECT + 嵌入段路径与普通属性混合
     * GET /jpa/hib/byEmbeddedCreatedTimeAndWarehouse?warehouseId=WH001&minTime=2026-01-01T00:00:00
     */
    @GetMapping("/byEmbeddedCreatedTimeAndWarehouse")
    public List<WmsDockBooking> byEmbeddedCreatedTimeAndWarehouse(
            @RequestParam String warehouseId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime minTime) {
        return hibernateTemplateDemoService.findByEmbeddedCreatedTimeAndWarehouse(warehouseId, minTime);
    }
}