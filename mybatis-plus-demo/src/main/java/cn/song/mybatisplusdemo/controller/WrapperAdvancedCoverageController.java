package cn.song.mybatisplusdemo.controller;

import cn.song.mybatisplusdemo.entity.User;
import cn.song.mybatisplusdemo.service.WrapperAdvancedCoverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Wrapper 高级定位与补充形态控制器
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/wrapperAdvanced")
public class WrapperAdvancedCoverageController {

    @Autowired
    private WrapperAdvancedCoverageService wrapperAdvancedCoverageService;

    /**
     * 跨方法工厂链
     * GET /wrapperAdvanced/factoryChain?minAge=18
     */
    @GetMapping("/factoryChain")
    public List<User> factoryChainAcrossMethods(@RequestParam(defaultValue = "18") Integer minAge) {
        return wrapperAdvancedCoverageService.factoryChainAcrossMethods(minAge);
    }

    /**
     * helper 方法就地修改 wrapper
     * GET /wrapperAdvanced/helperModified?username=li&roleId=1
     */
    @GetMapping("/helperModified")
    public List<User> helperModifiedWrapper(@RequestParam(required = false) String username,
                                            @RequestParam(defaultValue = "1") Integer roleId) {
        return wrapperAdvancedCoverageService.helperModifiedWrapper(username, roleId);
    }

    /**
     * clear() 截断后重建
     * GET /wrapperAdvanced/clearRebuild?status=1&deptId=2
     */
    @GetMapping("/clearRebuild")
    public List<User> clearThenRebuild(@RequestParam(defaultValue = "1") Integer status,
                                       @RequestParam(defaultValue = "1") Integer deptId) {
        return wrapperAdvancedCoverageService.clearThenRebuild(status, deptId);
    }

    /**
     * if/else 互斥分支
     * GET /wrapperAdvanced/exclusiveBranch?status=1&deptId=1
     */
    @GetMapping("/exclusiveBranch")
    public List<User> exclusiveBranchQuery(@RequestParam(required = false) Integer status,
                                           @RequestParam(defaultValue = "1") Integer deptId) {
        return wrapperAdvancedCoverageService.exclusiveBranchQuery(status, deptId);
    }

    /**
     * 字符串版 wrapper.lambda() 转换
     * GET /wrapperAdvanced/stringToLambda?status=1&minAge=18
     */
    @GetMapping("/stringToLambda")
    public List<User> stringWrapperToLambda(@RequestParam(defaultValue = "1") Integer status,
                                            @RequestParam(defaultValue = "18") Integer minAge) {
        return wrapperAdvancedCoverageService.stringWrapperToLambda(status, minAge);
    }

    /**
     * 分步续链
     * GET /wrapperAdvanced/stepByStep?deptId=1
     */
    @GetMapping("/stepByStep")
    public List<User> stepByStepBuild(@RequestParam(defaultValue = "1") Integer deptId) {
        return wrapperAdvancedCoverageService.stepByStepBuild(deptId, Arrays.asList(1, 2));
    }

    /**
     * select(Class, Predicate) 字段谓词过滤
     * GET /wrapperAdvanced/selectPredicate?status=1
     */
    @GetMapping("/selectPredicate")
    public List<User> selectByFieldPredicate(@RequestParam(defaultValue = "1") Integer status) {
        return wrapperAdvancedCoverageService.selectByFieldPredicate(status);
    }

    /**
     * allEq(Map, boolean) null 不生成 IS NULL
     * POST /wrapperAdvanced/allEqNullableOff  body: {"username":"a","status":1}
     */
    @PostMapping("/allEqNullableOff")
    public List<User> allEqNullableOff(@RequestBody Map<String, Object> params) {
        return wrapperAdvancedCoverageService.allEqNullableOff(params);
    }

    /**
     * 实体驱动 SET：update(entity, wrapper)
     * POST /wrapperAdvanced/updateEntitySet?id=1&email=new@qq.com&status=1
     */
    @PostMapping("/updateEntitySet")
    public int updateByEntitySet(@RequestParam Integer id,
                                 @RequestParam String email,
                                 @RequestParam Integer status) {
        return wrapperAdvancedCoverageService.updateByEntitySet(id, email, status);
    }

    /**
     * 实体驱动 SET：new UpdateWrapper<>(entity)
     * POST /wrapperAdvanced/updateWrapperEntity?id=1&age=30
     */
    @PostMapping("/updateWrapperEntity")
    public int updateByWrapperEntityConstructor(@RequestParam Integer id,
                                                @RequestParam Integer age) {
        return wrapperAdvancedCoverageService.updateByWrapperEntityConstructor(id, age);
    }

    /**
     * notLike 三族
     * GET /wrapperAdvanced/notLikeFamily?fragment=admin
     */
    @GetMapping("/notLikeFamily")
    public List<User> notLikeFamily(@RequestParam(defaultValue = "admin") String fragment) {
        return wrapperAdvancedCoverageService.notLikeFamily(fragment);
    }

    /**
     * insertBatchSomeColumn 批量插入
     * POST /wrapperAdvanced/batchInsertSome  body: 用户实体数组
     */
    @PostMapping("/batchInsertSome")
    public int batchInsertSome(@RequestBody List<User> users) {
        return wrapperAdvancedCoverageService.batchInsertSome(users);
    }
}
