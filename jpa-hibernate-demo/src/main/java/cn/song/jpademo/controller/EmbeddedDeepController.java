package cn.song.jpademo.controller;

import cn.song.jpademo.entity.CustomerEntity;
import cn.song.jpademo.service.EmbeddedDeepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 嵌套嵌入深水区语料入口（T-Embedded G1/G2 回归用）
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/embedded")
public class EmbeddedDeepController {

    @Resource
    private EmbeddedDeepService embeddedDeepService;

    /** 嵌套段派生查询（WHERE cust_zip = ?） */
    @GetMapping("/derivedNestedZip")
    public List<CustomerEntity> derivedNestedZip(@RequestParam(defaultValue = "310000") String zip) {
        return embeddedDeepService.derivedNestedZip(zip);
    }

    /** prefix 双嵌入派生查询（WHERE biz_street = ?） */
    @GetMapping("/derivedPrefixStreet")
    public List<CustomerEntity> derivedPrefixStreet(@RequestParam(defaultValue = "Nanjing-Road") String street) {
        return embeddedDeepService.derivedPrefixStreet(street);
    }

    /** @Query JPQL 嵌套段对照 */
    @GetMapping("/queryNestedArea")
    public List<CustomerEntity> queryNestedArea(@RequestParam(defaultValue = "021") String areaCode) {
        return embeddedDeepService.queryNestedArea(areaCode);
    }

    /** 汇总走查 */
    @GetMapping("/all")
    public Map<String, List<CustomerEntity>> all(@RequestParam(defaultValue = "310000") String zip,
                                                 @RequestParam(defaultValue = "Nanjing-Road") String street,
                                                 @RequestParam(defaultValue = "021") String areaCode) {
        return embeddedDeepService.all(zip, street, areaCode);
    }
}
