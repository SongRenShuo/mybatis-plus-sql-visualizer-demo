package cn.song.mpjdemo.controller;

import cn.song.mpjdemo.dto.UserDTO;
import cn.song.mpjdemo.service.MpjExtService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MPJ 扩展写法演示（MPJQueryWrapper 字符串 / selectAssociation / union / selectSub / distinct / 链式等）
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/mpj/ext")
public class MpjExtController {

    @Resource
    private MpjExtService mpjExtService;

    /**
     * MPJQueryWrapper 字符串写法
     */
    @GetMapping("/queryWrapperString")
    public List<UserDTO> queryWrapperString() {
        return mpjExtService.queryWrapperString();
    }

    /**
     * selectAssociation 一对一映射
     */
    @GetMapping("/association")
    public List<UserDTO> association() {
        return mpjExtService.selectAssociation();
    }

    /**
     * selectCollection 带 prefix + 关联表过滤
     */
    @GetMapping("/collectionFilter")
    public List<UserDTO> collectionFilter() {
        return mpjExtService.selectCollectionWithFilter();
    }

    /**
     * union / unionAll 合并查询
     */
    @GetMapping("/union")
    public List<UserDTO> union() {
        return mpjExtService.unionQuery();
    }

    /**
     * selectSub 子查询列
     */
    @GetMapping("/selectSub")
    public List<UserDTO> selectSub() {
        return mpjExtService.selectSubQuery();
    }

    /**
     * distinct 去重 + selectFunc 聚合
     */
    @GetMapping("/distinctFunc")
    public List<Map<String, Object>> distinctFunc() {
        return mpjExtService.distinctAndFunc();
    }

    /**
     * 自定义 join + apply + last
     */
    @GetMapping("/customJoin")
    public List<UserDTO> customJoin() {
        return mpjExtService.customJoinAndApply();
    }

    /**
     * 逻辑删除开关
     */
    @GetMapping("/logicDelSwitch")
    public List<UserDTO> logicDelSwitch() {
        return mpjExtService.logicDelSwitch();
    }

    /**
     * 链式 count / one / list / page
     */
    @GetMapping("/chain")
    public Map<String, Object> chain(@RequestParam(defaultValue = "1") Integer id) {
        return mpjExtService.chainCountOneList(id);
    }

    /**
     * 更多条件：allEq / and-or 嵌套 / exists / notExists / between / in
     */
    @GetMapping("/moreConditions")
    public List<UserDTO> moreConditions(Integer minAge, Integer maxAge,
                                        @RequestParam(required = false) List<Integer> ids) {
        Map<com.baomidou.mybatisplus.core.toolkit.support.SFunction<cn.song.mpjdemo.entity.UserDO, ?>, Object> allEq = new HashMap<>();
        allEq.put(cn.song.mpjdemo.entity.UserDO::getSex, 1);
        allEq.put(cn.song.mpjdemo.entity.UserDO::getAge, 20);
        return mpjExtService.moreConditions(allEq, minAge, maxAge,
                ids == null ? Arrays.asList(1, 2, 3) : ids);
    }
}
