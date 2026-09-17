package cn.song.mpjdemo.controller;

import cn.song.mpjdemo.dto.UserDTO;
import cn.song.mpjdemo.service.MpjLocatorCoverageService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * MPJ 定位器与终结点覆盖控制器
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/mpj/locator")
public class MpjLocatorCoverageController {

    @Autowired
    private MpjLocatorCoverageService mpjLocatorCoverageService;

    /**
     * MPJWrappers.lambdaJoin 工厂链
     * GET /mpj/locator/lambdaJoin
     */
    @GetMapping("/lambdaJoin")
    public List<UserDTO> mpjWrappersLambdaJoin() {
        return mpjLocatorCoverageService.mpjWrappersLambdaJoin();
    }

    /**
     * MPJWrappers.queryJoin 工厂链（字符串列）
     * GET /mpj/locator/queryJoin
     */
    @GetMapping("/queryJoin")
    public List<Map<String, Object>> mpjWrappersQueryJoin() {
        return mpjLocatorCoverageService.mpjWrappersQueryJoin();
    }

    /**
     * JoinWrappers.update 工厂 + updateAndNull 终结
     * POST /mpj/locator/updateAndNull?userId=1
     */
    @PostMapping("/updateAndNull")
    public int updateJoinAndNull(@RequestParam Integer userId) {
        return mpjLocatorCoverageService.updateJoinAndNull(userId);
    }

    /**
     * Chain 终结点 first/one/count
     * GET /mpj/locator/firstOneCount?userId=1
     */
    @GetMapping("/firstOneCount")
    public Map<String, Object> terminalFirstOneCount(@RequestParam(defaultValue = "1") Integer userId) {
        return mpjLocatorCoverageService.terminalFirstOneCount(userId);
    }

    /**
     * Chain 终结点 mapOne/mapFirst/mapList
     * GET /mpj/locator/mapFamily?maxAge=40
     */
    @GetMapping("/mapFamily")
    public List<Map<String, Object>> terminalMapFamily(@RequestParam(defaultValue = "40") Integer maxAge) {
        return mpjLocatorCoverageService.terminalMapFamily(maxAge);
    }

    /**
     * Chain 终结点 mapPage
     * GET /mpj/locator/mapPage?current=1&size=10
     */
    @GetMapping("/mapPage")
    public Page<Map<String, Object>> terminalMapPage(@RequestParam(defaultValue = "1") long current,
                                                     @RequestParam(defaultValue = "10") long size) {
        return mpjLocatorCoverageService.terminalMapPage(current, size);
    }

    /**
     * 构造别名 new MPJLambdaWrapper<>(UserDO.class, "u")
     * GET /mpj/locator/constructorAlias
     */
    @GetMapping("/constructorAlias")
    public List<UserDTO> constructorAlias() {
        return mpjLocatorCoverageService.constructorAlias();
    }

    /**
     * 字符串 join {0} 参数替换
     * GET /mpj/locator/joinPlaceholder?tel=138
     */
    @GetMapping("/joinPlaceholder")
    public List<UserDTO> joinWithPlaceholder(@RequestParam(defaultValue = "138") String tel) {
        return mpjLocatorCoverageService.joinWithPlaceholder(tel);
    }
}
