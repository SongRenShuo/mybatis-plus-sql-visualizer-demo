package cn.song.mybatisplusdemo.controller;

import cn.song.mybatisplusdemo.entity.User;
import cn.song.mybatisplusdemo.service.PageSimService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 分页拦截器模拟语料入口（插件 R12 T-PaginationSim / T-CountSimToggle 回归用）
 *
 * <p>走查要点：预览各端点语句应出现「LIMIT 尾追 + COUNT 包裹」双产物；
 * searchCount=false 与手写 LIMIT 的端点只应有其一。
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/pageSim")
public class PageSimController {

    @Resource
    private PageSimService pageSimService;

    /** 注解 SQL + IPage 形参（@Select 路径分页模拟） */
    @GetMapping("/annotationPage")
    public IPage<User> annotationPage(@RequestParam(defaultValue = "1") int current,
                                      @RequestParam(defaultValue = "5") int size,
                                      @RequestParam(required = false) Integer status) {
        return pageSimService.annotationPage(current, size, status);
    }

    /** XML 分页（无手写 LIMIT，既有 selectUserPageXml 语料的对照组） */
    @GetMapping("/xmlPage")
    public IPage<User> xmlPage(@RequestParam(defaultValue = "1") int current,
                               @RequestParam(defaultValue = "5") int size,
                               @RequestParam(required = false) Integer status,
                               @RequestParam(required = false) String keyword) {
        return pageSimService.xmlPage(current, size, status, keyword);
    }

    /** XML 手写 LIMIT + IPage：不重复追加 LIMIT */
    @GetMapping("/xmlLimitPage")
    public IPage<User> xmlLimitPage(@RequestParam(defaultValue = "1") int current,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(required = false) Integer status) {
        return pageSimService.xmlLimitPage(current, size, status);
    }

    /** Page 三参构造 searchCount=false：无 COUNT 产物 */
    @GetMapping("/noCountPage")
    public IPage<User> noCountPage() {
        return pageSimService.noCountPage();
    }

    /** searchCount 缺省（true）对照：LIMIT + COUNT 双产物 */
    @GetMapping("/countOnPage")
    public IPage<User> countOnPage() {
        return pageSimService.countOnPage();
    }

    /** Page 四参构造（current, size, total, searchCount=false） */
    @GetMapping("/fourArgPage")
    public IPage<User> fourArgPage() {
        return pageSimService.fourArgPage();
    }

    /** selectList(page, wrapper) 消费形态（Page 布尔第三参识别） */
    @GetMapping("/selectListPage")
    public List<User> selectListPage(@RequestParam(defaultValue = "true") boolean searchCount) {
        return pageSimService.selectListPage(searchCount);
    }

    /** selectMaps(page, wrapper) 消费形态（Map 族分页） */
    @GetMapping("/selectMapsPage")
    public List<Map<String, Object>> selectMapsPage(@RequestParam(defaultValue = "true") boolean searchCount) {
        return pageSimService.selectMapsPage(searchCount);
    }
}
