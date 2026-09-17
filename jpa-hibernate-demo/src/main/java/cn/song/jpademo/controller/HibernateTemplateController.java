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
}