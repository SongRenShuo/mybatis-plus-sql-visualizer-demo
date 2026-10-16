package cn.song.jarmodeldemo.controller;

import cn.song.jarmodeldemo.service.WmsInventoryJarQueryService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 「实体/嵌入类来自依赖 JAR」复现用例的 HTTP 入口（端口 8088）。
 *
 * <p>走查时先跑一遍，确认「真库列名确实带嵌入段前缀」——插件预览产物必须与这里一致：
 * <ul>
 *   <li>{@code GET /jar-model/columns} 读 information_schema，直接打印真库列名；</li>
 *   <li>{@code GET /jar-model/query}   真跑一次查询（列名不对会直接报 Unknown column），
 *       {@code ?mode=buffer} 走 StringBuffer 承载形态；</li>
 *   <li>{@code GET /jar-model/naming}  回显生效的隐式命名策略来自哪条路
 *       （yml 形态 A / 代码形态 B），用于切换 profile 时自证。</li>
 * </ul>
 *
 * <p>（待预览的 HQL 原文就在 {@link WmsInventoryJarQueryService} 的两个方法体里——
 * 在 IDE 里直接预览那两个调用即可，故不另设 hql 端点。）
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/jar-model")
public class JarModelReproController {

    private static final String DEMO_TABLE = "wms_inventory_jar_demo";

    private final WmsInventoryJarQueryService queryService;
    private final Environment environment;

    @PersistenceContext
    private EntityManager entityManager;

    public JarModelReproController(WmsInventoryJarQueryService queryService, Environment environment) {
        this.queryService = queryService;
        this.environment = environment;
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
        body.put("expectation",
                "应含 qty_base_qty / sku_inventory_status / item_key_lot_info_received_date（组件路径命名策略的产物）");
        return body;
    }

    /** 真跑一次查询：列名不对会报 Unknown column。`mode` 选承载形态：plain / buffer。 */
    @GetMapping("/query")
    public Map<String, Object> query(@RequestParam(defaultValue = "W01") String warehouseId,
                                     @RequestParam(defaultValue = "IN_STOCK") String inventoryStatus,
                                     @RequestParam(defaultValue = "plain") String mode) {
        final List<?> rows;
        switch (mode) {
            case "buffer":
                rows = queryService.findAvailableJarInventoryByBuffer(warehouseId, inventoryStatus);
                break;
            default:
                rows = queryService.findAvailableJarInventory(warehouseId, inventoryStatus);
        }
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("mode", mode);
        body.put("warehouseId", warehouseId);
        body.put("inventoryStatus", inventoryStatus);
        body.put("rowCount", rows.size());
        body.put("rows", rows);
        return body;
    }

    /**
     * 回显生效的隐式命名策略及其来源。
     *
     * <p>{@code valueType=String} 说明是 application.yml（形态 A，设置键写短名）；
     * {@code valueType=Class} 说明是 {@code HibernatePropertiesCustomizer} 代码式配置（形态 B）。
     */
    @GetMapping("/naming")
    public Map<String, Object> naming() {
        EntityManagerFactory emf = entityManager.getEntityManagerFactory();
        Object hibernateValue = emf.getProperties().get("hibernate.implicit_naming_strategy");
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("activeProfiles", Arrays.asList(environment.getActiveProfiles()));
        body.put("codeNamingProfileActive", environment.acceptsProfiles("code-naming"));
        body.put("ymlProperty",
                environment.getProperty("spring.jpa.properties.hibernate.implicit_naming_strategy"));
        body.put("hibernateProperty", String.valueOf(hibernateValue));
        body.put("valueType", hibernateValue == null ? "null" : hibernateValue.getClass().getName());
        return body;
    }
}
