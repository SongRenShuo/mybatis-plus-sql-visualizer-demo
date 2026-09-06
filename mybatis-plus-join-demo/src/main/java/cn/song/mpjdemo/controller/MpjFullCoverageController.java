package cn.song.mpjdemo.controller;

import cn.song.mpjdemo.dto.UserDTO;
import cn.song.mpjdemo.service.MpjFullCoverageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * MPJ 场景全覆盖演示控制器
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/mpj/full")
public class MpjFullCoverageController {

    @Resource
    private MpjFullCoverageService mpjFullCoverageService;

    /**
     * join 类型与重载：innerJoin/rightJoin/fullJoin/别名/rightAlias
     */
    @GetMapping("/joinKinds")
    public List<UserDTO> joinKinds() {
        return mpjFullCoverageService.joinKindsAndOverloads();
    }

    /**
     * 子查询条件族 (col, Class, wrapper)
     */
    @GetMapping("/subquery")
    public List<UserDTO> subquery() {
        return mpjFullCoverageService.subqueryConditions();
    }

    /**
     * IfExists 族
     */
    @GetMapping("/ifExists")
    public List<UserDTO> ifExists(Integer age, String tel) {
        return mpjFullCoverageService.ifExistsFamily(age, tel, Arrays.asList(1, 2, 3));
    }

    /**
     * 聚合列扩展
     */
    @GetMapping("/aggregate")
    public List<Map<String, Object>> aggregate() {
        return mpjFullCoverageService.aggregateExt();
    }

    /**
     * updateJoin 变体
     */
    @GetMapping("/updateJoin")
    public int updateJoin() {
        return mpjFullCoverageService.updateJoinExt();
    }

    /**
     * deleteJoin 变体
     */
    @GetMapping("/deleteJoin")
    public int deleteJoin() {
        return mpjFullCoverageService.deleteJoinExt();
    }

    /**
     * on lambda apply 子查询 + ext
     */
    @GetMapping("/onApply")
    public List<UserDTO> onApply() {
        return mpjFullCoverageService.onLambdaApply();
    }

    /**
     * MPJQueryWrapper 字符串形态补充
     */
    @GetMapping("/queryString")
    public List<UserDTO> queryString() {
        return mpjFullCoverageService.queryStringExt();
    }
}
