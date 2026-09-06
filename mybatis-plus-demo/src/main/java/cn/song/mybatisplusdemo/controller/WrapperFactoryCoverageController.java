package cn.song.mybatisplusdemo.controller;

import cn.song.mybatisplusdemo.entity.SysConfig;
import cn.song.mybatisplusdemo.entity.User;
import cn.song.mybatisplusdemo.service.WrapperFactoryCoverageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Wrapper 工厂/链式/工具类形态演示控制器
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/config/factory")
public class WrapperFactoryCoverageController {

    @Resource
    private WrapperFactoryCoverageService wrapperFactoryCoverageService;

    /**
     * Wrappers 工厂族
     */
    @GetMapping("/wrappers")
    public Map<String, Object> wrappers(String username) {
        return wrapperFactoryCoverageService.listByWrappersFactory(username);
    }

    /**
     * ChainWrappers 链式终结点
     */
    @GetMapping("/chain")
    public Map<String, Object> chain(String username) {
        return wrapperFactoryCoverageService.listByChainWrappers(username);
    }

    /**
     * Db kit 静态 CRUD
     */
    @GetMapping("/db")
    public Map<String, Object> db(String username) {
        return wrapperFactoryCoverageService.crudByDbKit(username);
    }

    /**
     * SimpleQuery 三形态
     */
    @GetMapping("/simpleQuery")
    public Map<String, Object> simpleQuery(String keyword) {
        return wrapperFactoryCoverageService.queryBySimpleQuery(keyword);
    }

    /**
     * ActiveRecord 形态
     */
    @PostMapping("/activeRecord")
    public Map<String, Object> activeRecord(@RequestBody SysConfig config) {
        return wrapperFactoryCoverageService.crudByActiveRecord(config);
    }

    /**
     * BaseMapper/IService CRUD 补形态
     */
    @GetMapping("/mapperMore")
    public Map<String, Object> mapperMore(String keyword) {
        return wrapperFactoryCoverageService.crudMapperMoreForms(keyword);
    }
}
