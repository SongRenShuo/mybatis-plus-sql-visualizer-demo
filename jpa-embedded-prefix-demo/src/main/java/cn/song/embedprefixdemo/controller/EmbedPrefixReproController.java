package cn.song.embedprefixdemo.controller;

import cn.song.embedprefixdemo.service.WmsInventoryQueryService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 嵌入列前缀复现用例的 HTTP 入口（端口 8087）。
 *
 * 走查时先跑一遍，确认「真库列名确实带嵌入段前缀」——插件预览产物必须与这里一致：
 *  - `GET /embed-prefix/columns` 读 information_schema，直接打印真库列名；
 *  - `GET /embed-prefix/hql`     返回待预览的 HQL 原文（可复制到插件里对照）；
 *  - `GET /embed-prefix/query`   真跑一次查询（列名不对会直接报 Unknown column）；
 *  - `GET /embed-prefix/naming`  回显生效的隐式命名策略。
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/embed-prefix")
public class EmbedPrefixReproController {

    private static final String DEMO_TABLE = "wms_inventory_embed_demo";

    private final WmsInventoryQueryService queryService;
    private final Environment environment;

    @PersistenceContext
    private EntityManager entityManager;

    public EmbedPrefixReproController(WmsInventoryQueryService queryService, Environment environment) {
        this.queryService = queryService;
        this.environment = environment;
    }

    /** 待预览的 HQL 原文。 */
    @GetMapping("/hql")
    public Map<String, Object> hql() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("hql", queryService.buildAvailableInventoryHql());
        body.put("previewExpectation",
                "预览应含 inv.move_tool_pallet_no 与 inv.qty_base_qty；出现 inv.pallet_no / inv.base_qty 即缺陷复现");
        return body;
    }

    /** 真库列名（复现的判据来源）。 */
    @GetMapping("/columns")
    @SuppressWarnings("unchecked")
    public Map<String, Object> columns() {
        List<String> names = entityManager.createNativeQuery(
                        "select column_name from information_schema.columns "
                                + "where table_schema = database() and table_name = :table order by ordinal_position")
                .setParameter("table", DEMO_TABLE)
                .getResultList();
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("table", DEMO_TABLE);
        body.put("columns", names);
        body.put("expectation", "应含 qty_base_qty 与 move_tool_pallet_no（组件路径命名策略的产物）");
        return body;
    }

    /** 真跑一次查询：列名不对会报 Unknown column。 */
    @GetMapping("/query")
    public Map<String, Object> query(@RequestParam(defaultValue = "W01") String warehouseId,
                                     @RequestParam(defaultValue = "P001") String palletNo) {
        List<?> rows = queryService.findAvailableInventory(warehouseId, palletNo);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("hql", queryService.buildAvailableInventoryHql());
        body.put("warehouseId", warehouseId);
        body.put("palletNo", palletNo);
        body.put("rowCount", rows.size());
        body.put("rows", rows);
        return body;
    }

    /** 回显生效的隐式命名策略（应为 component-path）。 */
    @GetMapping("/naming")
    public Map<String, Object> naming() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("implicitNamingStrategy",
                environment.getProperty("spring.jpa.properties.hibernate.implicit_naming_strategy"));
        return body;
    }
}
