package cn.song.mybatisplusdemo.controller;

import cn.song.mybatisplusdemo.common.PageQuery;
import cn.song.mybatisplusdemo.entity.User;
import cn.song.mybatisplusdemo.service.WrapperExtService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Wrapper 扩展写法演示（eqSql/inSql/apply/allEq/链式/XML 高级映射等）
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/user/ext")
public class WrapperExtController {

    @Resource
    private WrapperExtService wrapperExtService;

    /**
     * eqSql/neSql/gtSql/geSql/ltSql/leSql SQL 片段
     */
    @GetMapping("/sqlFragment")
    public List<User> sqlFragment(Integer minAge) {
        return wrapperExtService.listBySqlFragment(minAge);
    }

    /**
     * inSql / notInSql 子查询
     */
    @GetMapping("/inSql")
    public List<User> inSql() {
        return wrapperExtService.listByInSql();
    }

    /**
     * apply + exists + notExists + last
     */
    @GetMapping("/applyExists")
    public List<User> applyExists(String emailDomain) {
        return wrapperExtService.listByApplyAndExists(emailDomain);
    }

    /**
     * allEq Map 等值条件
     */
    @GetMapping("/allEq")
    public List<User> allEq(Integer status, Integer age) {
        Map<String, Object> params = new HashMap<>();
        params.put("status", status);
        params.put("age", age);
        return wrapperExtService.listByAllEq(params);
    }

    /**
     * not + nested 多层嵌套
     */
    @GetMapping("/notNested")
    public List<User> notNested(String username, Integer roleId) {
        return wrapperExtService.listByNotAndNested(username, roleId);
    }

    /**
     * select 排除字段 + selectObjs
     */
    @GetMapping("/selectObjs")
    public List<Object> selectObjs() {
        return wrapperExtService.listObjsBySelectExclude();
    }

    /**
     * 链式 lambdaQuery count
     */
    @GetMapping("/chainCount")
    public Long chainCount(String username) {
        return wrapperExtService.countByChain(username);
    }

    /**
     * 链式 lambdaUpdate set + eq + update
     */
    @GetMapping("/chainUpdate")
    public boolean chainUpdate(Integer id, Integer status) {
        return wrapperExtService.updateByChain(id, status);
    }

    /**
     * 链式 lambdaUpdate remove
     */
    @GetMapping("/chainRemove")
    public boolean chainRemove(Integer status) {
        return wrapperExtService.removeByChain(status);
    }

    /**
     * 显式 LambdaDeleteWrapper
     */
    @GetMapping("/lambdaDelete")
    public boolean lambdaDelete(Integer maxAge, List<Integer> roleIds) {
        return wrapperExtService.removeByLambdaDelete(maxAge, roleIds);
    }

    /**
     * IService 更多方法
     */
    @PostMapping("/iservice")
    public Map<String, Object> iservice(@RequestBody User user) {
        return wrapperExtService.iserviceMore(user, java.util.Arrays.asList(1, 2),
                java.util.Collections.singletonMap("status", 1));
    }

    /**
     * getOne 不抛异常
     */
    @GetMapping("/getOneSilent")
    public User getOneSilent(String username) {
        return wrapperExtService.getOneSilent(username);
    }

    /**
     * XML 一对多 resultMap（association + collection）
     */
    @GetMapping("/xmlWithOrders")
    public List<User> xmlWithOrders(Integer status) {
        return wrapperExtService.selectUserWithOrdersXml(status);
    }

    /**
     * XML 自定义分页
     */
    @GetMapping("/xmlPage")
    public IPage<User> xmlPage(PageQuery pageQuery, Integer status) {
        return wrapperExtService.pageByXml(pageQuery, status);
    }

    /**
     * XML 多参数查询
     */
    @GetMapping("/xmlMultiParam")
    public List<User> xmlMultiParam(String username, Integer status, Integer minAge) {
        return wrapperExtService.selectByMultiParamXml(username, status, minAge);
    }

    /**
     * XML Map 参数查询
     */
    @GetMapping("/xmlMapParam")
    public List<User> xmlMapParam(String username, Integer status) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("status", status);
        return wrapperExtService.selectByMapParamXml(params);
    }
}
