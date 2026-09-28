package cn.song.jpademo.controller;

import cn.song.jpademo.dto.UserLiteDTO;
import cn.song.jpademo.entity.UserEntity;
import cn.song.jpademo.entity.WmsDockBooking;
import cn.song.jpademo.service.JpaDeepCoverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * JPA 深水区覆盖控制器
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/jpa/deep")
public class JpaDeepCoverageController {

    @Autowired
    private JpaDeepCoverageService jpaDeepCoverageService;

    /**
     * Criteria EXISTS 子查询
     * GET /jpa/deep/criteriaExists?minAmount=100
     */
    @GetMapping("/criteriaExists")
    public List<UserEntity> criteriaExistsSubquery(@RequestParam(defaultValue = "100") BigDecimal minAmount) {
        return jpaDeepCoverageService.criteriaExistsSubquery(minAmount);
    }

    /**
     * Criteria 表达式函数 coalesce/concat/length
     * GET /jpa/deep/criteriaFunctions
     */
    @GetMapping("/criteriaFunctions")
    public List<Map<String, Object>> criteriaExpressionFunctions() {
        return jpaDeepCoverageService.criteriaExpressionFunctions();
    }

    /**
     * Criteria fetch join
     * GET /jpa/deep/criteriaFetch?status=1
     */
    @GetMapping("/criteriaFetch")
    public List<UserEntity> criteriaFetchJoin(@RequestParam(defaultValue = "1") Integer status) {
        return jpaDeepCoverageService.criteriaFetchJoin(status);
    }

    /**
     * Specification 组合器 where/and/or/not
     * GET /jpa/deep/specCombinators?keyword=a&status=1&minAge=18
     */
    @GetMapping("/specCombinators")
    public List<UserEntity> specificationCombinators(@RequestParam(defaultValue = "a") String keyword,
                                                     @RequestParam(defaultValue = "1") Integer status,
                                                     @RequestParam(defaultValue = "18") Integer minAge) {
        return jpaDeepCoverageService.specificationCombinators(keyword, status, minAge);
    }

    /**
     * @Procedure 存储过程
     * GET /jpa/deep/procedureCount?status=1
     */
    @GetMapping("/procedureCount")
    public Integer procedureCountByStatus(@RequestParam(defaultValue = "1") Integer status) {
        return jpaDeepCoverageService.procedureCountByStatus(status);
    }

    /**
     * @NamedQueries 容器命名查询
     * GET /jpa/deep/namedQueryContainer?orderNo=SO2026
     */
    @GetMapping("/namedQueryContainer")
    public List<?> namedQueryContainer(@RequestParam(defaultValue = "SO2026001") String orderNo) {
        return jpaDeepCoverageService.namedQueryContainer(orderNo);
    }

    /**
     * DTO 构造器表达式投影
     * GET /jpa/deep/liteProjection?status=1
     */
    @GetMapping("/liteProjection")
    public List<UserLiteDTO> liteProjection(@RequestParam(defaultValue = "1") Integer status) {
        return jpaDeepCoverageService.liteProjection(status);
    }

    /**
     * Criteria 嵌入段路径（root.get("updateInfo").get("createdTime") 穿透 @Embedded）
     * GET /jpa/deep/criteriaEmbedded?warehouseId=WH001
     */
    @GetMapping("/criteriaEmbedded")
    public List<WmsDockBooking> criteriaEmbeddedPath(@RequestParam(defaultValue = "WH001") String warehouseId) {
        return jpaDeepCoverageService.criteriaEmbeddedPath(warehouseId);
    }

    /**
     * Specification 嵌入段路径组合条件
     * GET /jpa/deep/specEmbedded?warehouseId=WH001&minTime=2020-01-01T00:00:00
     */
    @GetMapping("/specEmbedded")
    public List<WmsDockBooking> specificationEmbeddedPath(
            @RequestParam(defaultValue = "WH001") String warehouseId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime minTime) {
        return jpaDeepCoverageService.specificationEmbeddedPath(warehouseId,
                minTime == null ? LocalDateTime.now().minusDays(1) : minTime);
    }
}
