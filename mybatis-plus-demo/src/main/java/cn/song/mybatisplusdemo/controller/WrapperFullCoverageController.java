package cn.song.mybatisplusdemo.controller;

import cn.song.mybatisplusdemo.entity.User;
import cn.song.mybatisplusdemo.service.WrapperFullCoverageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Wrapper 条件方法全覆盖演示控制器
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/user/full")
public class WrapperFullCoverageController {

    @Resource
    private WrapperFullCoverageService wrapperFullCoverageService;

    /**
     * like 族：likeLeft/notLike/notLikeLeft/notLikeRight
     */
    @GetMapping("/likeFamily")
    public List<User> likeFamily(String keyword) {
        return wrapperFullCoverageService.listByLikeFamily(keyword);
    }

    /**
     * notBetween/isNotNull/ge/lt
     */
    @GetMapping("/range")
    public List<User> range(Integer low, Integer high) {
        return wrapperFullCoverageService.listByRangeConditions(low, high);
    }

    /**
     * geSql/ltSql
     */
    @GetMapping("/sqlFragmentExt")
    public List<User> sqlFragmentExt(String minAmount) {
        return wrapperFullCoverageService.listBySqlFragmentExt(minAmount);
    }

    /**
     * or 细粒度嵌套
     */
    @GetMapping("/orNesting")
    public List<User> orNesting(String username, Integer status) {
        return wrapperFullCoverageService.listByOrNesting(username, status);
    }

    /**
     * func consumer 批量接入
     */
    @GetMapping("/func")
    public List<User> func(String username, Integer age) {
        return wrapperFullCoverageService.listByFuncConsumer(username, age);
    }

    /**
     * apply 多参数占位 + exists {0}
     */
    @GetMapping("/applyParams")
    public List<User> applyParams(Integer years, Integer roleId) {
        return wrapperFullCoverageService.listByApplyParams(years, roleId);
    }

    /**
     * first/comment/last 三段直拼
     */
    @GetMapping("/firstCommentLast")
    public List<User> firstCommentLast(String keyword) {
        return wrapperFullCoverageService.listByFirstCommentLast(keyword);
    }

    /**
     * groupBy 多列 + having + orderBy 混排
     */
    @GetMapping("/groupOrder")
    public List<Map<String, Object>> groupOrder(Integer minAge) {
        return wrapperFullCoverageService.groupByMultiColumn(minAge);
    }

    /**
     * UpdateWrapper 全条件形态
     */
    @GetMapping("/updateFull")
    public int updateFull(String emailSuffix) {
        return wrapperFullCoverageService.updateByFullConditions(java.util.Arrays.asList(1, 2), emailSuffix);
    }

    /**
     * LambdaDeleteWrapper 条件删除
     */
    @GetMapping("/delete")
    public int delete(Integer status, String email) {
        return wrapperFullCoverageService.deleteByLambdaDeleteWrapper(status, email);
    }
}
