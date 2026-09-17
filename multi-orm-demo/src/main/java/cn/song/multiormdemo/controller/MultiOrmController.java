package cn.song.multiormdemo.controller;

import cn.song.multiormdemo.entity.MemberEntity;
import cn.song.multiormdemo.entity.XbMember;
import cn.song.multiormdemo.service.EasyQueryService;
import cn.song.multiormdemo.service.MdsService;
import cn.song.multiormdemo.service.QuerydslService;
import cn.song.multiormdemo.service.XbatisService;

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
 * 多 ORM 覆盖控制器
 * Querydsl（Q 类表达式树）/ MDS（DSL 构建）/ xbatis（Chain）/ Easy-Query（proxy）四家语料入口
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/orm")
public class MultiOrmController {

    @Autowired
    private QuerydslService querydslService;

    @Autowired
    private MdsService mdsService;

    @Autowired
    private XbatisService xbatisService;

    @Autowired
    private EasyQueryService easyQueryService;

    // ==================== Querydsl ====================

    /**
     * GET /orm/querydsl/byStatus?status=1
     */
    @GetMapping("/querydsl/byStatus")
    public List<MemberEntity> querydslByStatus(@RequestParam(defaultValue = "1") Integer status) {
        return querydslService.queryByStatus(status);
    }

    /**
     * GET /orm/querydsl/booleanBuilder?city=hangzhou&maxAge=40
     */
    @GetMapping("/querydsl/booleanBuilder")
    public List<MemberEntity> querydslBooleanBuilder(@RequestParam(required = false) String city,
                                                     @RequestParam(required = false) Integer maxAge) {
        return querydslService.queryByBooleanBuilder(city, maxAge);
    }

    /**
     * GET /orm/querydsl/groupByCity
     */
    @GetMapping("/querydsl/groupByCity")
    public List<Map<String, Object>> querydslGroupByCity() {
        return querydslService.groupByCity();
    }

    /**
     * POST /orm/querydsl/disable?id=1
     */
    @PostMapping("/querydsl/disable")
    public long querydslDisable(@RequestParam Long id) {
        return querydslService.disableById(id);
    }

    /**
     * POST /orm/querydsl/deleteDisabled
     */
    @PostMapping("/querydsl/deleteDisabled")
    public long querydslDeleteDisabled() {
        return querydslService.deleteDisabled();
    }

    // ==================== MyBatis Dynamic SQL ====================

    /**
     * GET /orm/mds/byStatus?status=1&minAge=18
     */
    @GetMapping("/mds/byStatus")
    public List<Map<String, Object>> mdsByStatus(@RequestParam(defaultValue = "1") Integer status,
                                                 @RequestParam(defaultValue = "18") Integer minAge) {
        return mdsService.queryByStatus(status, minAge);
    }

    /**
     * POST /orm/mds/disable?id=1
     */
    @PostMapping("/mds/disable")
    public int mdsDisable(@RequestParam Long id) {
        return mdsService.disableById(id);
    }

    /**
     * POST /orm/mds/deleteDisabled
     */
    @PostMapping("/mds/deleteDisabled")
    public int mdsDeleteDisabled() {
        return mdsService.deleteDisabled();
    }

    // ==================== xbatis ====================

    /**
     * GET /orm/xbatis/activeAdults?nameFragment=zhang
     */
    @GetMapping("/xbatis/activeAdults")
    public List<XbMember> xbatisActiveAdults(@RequestParam(defaultValue = "") String nameFragment) {
        return xbatisService.queryActiveAdults(nameFragment);
    }

    /**
     * GET /orm/xbatis/nested?status=1&minAge=18
     */
    @GetMapping("/xbatis/nested")
    public List<XbMember> xbatisNested(@RequestParam(defaultValue = "1") Integer status,
                                       @RequestParam(defaultValue = "18") Integer minAge) {
        return xbatisService.queryByNested(status, minAge);
    }

    /**
     * GET /orm/xbatis/countEnabled
     */
    @GetMapping("/xbatis/countEnabled")
    public Integer xbatisCountEnabled() {
        return xbatisService.countEnabled();
    }

    /**
     * POST /orm/xbatis/disable?id=1
     */
    @PostMapping("/xbatis/disable")
    public int xbatisDisable(@RequestParam Long id) {
        return xbatisService.disableById(id);
    }

    /**
     * POST /orm/xbatis/deleteDisabled
     */
    @PostMapping("/xbatis/deleteDisabled")
    public int xbatisDeleteDisabled() {
        return xbatisService.deleteDisabled();
    }

    // ==================== Easy-Query ====================

    /**
     * GET /orm/easy/enabled
     */
    @GetMapping("/easy/enabled")
    public List<MemberEntity> easyEnabled() {
        return easyQueryService.queryEnabled();
    }

    /**
     * GET /orm/easy/byCityAndAge?city=hangzhou&minAge=18
     */
    @GetMapping("/easy/byCityAndAge")
    public List<MemberEntity> easyByCityAndAge(@RequestParam(defaultValue = "hangzhou") String city,
                                               @RequestParam(defaultValue = "18") Integer minAge) {
        return easyQueryService.queryByCityAndAge(city, minAge);
    }

    /**
     * POST /orm/easy/insert  body: 成员实体
     */
    @PostMapping("/easy/insert")
    public long easyInsert(@RequestBody MemberEntity member) {
        return easyQueryService.insertMember(member);
    }

    /**
     * POST /orm/easy/disable?id=1
     */
    @PostMapping("/easy/disable")
    public long easyDisable(@RequestParam Long id) {
        return easyQueryService.disableById(id);
    }

    /**
     * POST /orm/easy/deleteDisabled
     */
    @PostMapping("/easy/deleteDisabled")
    public long easyDeleteDisabled() {
        return easyQueryService.deleteDisabled();
    }
}
