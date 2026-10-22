package com.example.shadow.web;

import com.example.shadow.dao.WmsTaskJarDao;
import com.example.shadow.model.WmsTask;
import com.example.shadow.service.WmsTaskJarService;
import com.example.shadow.web.service.ShadowTaskQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import java.security.CodeSource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 复现用例的 HTTP 入口（端口 8089）——给走查提供「运行期真值」，用于和插件预览产物对照。
 *
 * <ul>
 *   <li>{@code GET /shadow/entity}  —— 回显运行期 {@code WmsTask.class} 的 {@code @Table}
 *       表名与 code source 路径：应看到 {@code wms_task_project} + 本模块 {@code target/classes}
 *       （证明同 FQN 下运行期生效的是宿主影子类）；</li>
 *   <li>{@code GET /shadow/columns} —— 读 information_schema，打印真库列清单；</li>
 *   <li>{@code GET /shadow/hql?mode=…} —— 真跑三个调用点：
 *       {@code jar-dao}（JAR 内 DAO 方法，缺陷触发点）、
 *       {@code jar-service}（JAR 内 service 方法，报障同款）、
 *       {@code host-service}（工程内调用方，对照组）。</li>
 * </ul>
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/shadow")
public class ShadowReproController {

    private static final String PROJECT_TABLE = "wms_task_project";
    private static final String JAR_TABLE = "wms_task_jar";

    private final WmsTaskJarDao wmsTaskJarDao;
    private final WmsTaskJarService wmsTaskJarService;
    private final ShadowTaskQueryService shadowTaskQueryService;

    @PersistenceContext
    private EntityManager entityManager;

    public ShadowReproController(WmsTaskJarDao wmsTaskJarDao,
                                 WmsTaskJarService wmsTaskJarService,
                                 ShadowTaskQueryService shadowTaskQueryService) {
        this.wmsTaskJarDao = wmsTaskJarDao;
        this.wmsTaskJarService = wmsTaskJarService;
        this.shadowTaskQueryService = shadowTaskQueryService;
    }

    /** 运行期真值：同 FQN 双份下，实际载入的是哪一份。 */
    @GetMapping("/entity")
    public Map<String, Object> entity() {
        Table table = WmsTask.class.getAnnotation(Table.class);
        CodeSource codeSource = WmsTask.class.getProtectionDomain().getCodeSource();
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("className", WmsTask.class.getName());
        body.put("tableName", table == null ? null : table.name());
        body.put("codeSource", codeSource == null || codeSource.getLocation() == null
                ? null : codeSource.getLocation().toString());
        body.put("expectation",
                "tableName 应为 wms_task_project（宿主影子版），codeSource 应指向本模块 target/classes；"
                        + "JAR 版是 wms_task_jar");
        return body;
    }

    /** 真库列清单（默认读宿主影子版的表）。 */
    @GetMapping("/columns")
    @SuppressWarnings("unchecked")
    public Map<String, Object> columns(@RequestParam(defaultValue = PROJECT_TABLE) String table) {
        List<String> names = entityManager.createNativeQuery(
                        "select column_name from information_schema.columns "
                                + "where table_schema = database() and table_name = :table order by ordinal_position")
                .setParameter("table", table)
                .getResultList();
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("table", table);
        body.put("columns", names);
        if (PROJECT_TABLE.equals(table)) {
            body.put("expectation", "应含 id / task_no / status / task_type / remark（宿主影子版的列清单）");
        } else if (JAR_TABLE.equals(table)) {
            body.put("expectation", "JAR 版的表名（wms_task_jar）——运行期不会被创建，本查询应返回空清单");
        }
        return body;
    }

    /** 真跑三个调用点：列名/表名不对会直接报错（Unknown column / table doesn't exist）。 */
    @GetMapping("/hql")
    public Map<String, Object> hql(@RequestParam(defaultValue = "OP") String status,
                                   @RequestParam(defaultValue = "PU") String type,
                                   @RequestParam(defaultValue = "T001") String taskNo,
                                   @RequestParam(defaultValue = "jar-dao") String mode) {
        final List<?> rows;
        switch (mode) {
            case "jar-service":
                rows = wmsTaskJarService.beAllocateSuccess(taskNo, type);
                break;
            case "host-service":
                rows = shadowTaskQueryService.findByStatusAndType(status, type);
                break;
            default:
                rows = wmsTaskJarDao.findByStatusAndType(status, type);
        }
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("mode", mode);
        body.put("status", status);
        body.put("type", type);
        body.put("taskNo", taskNo);
        body.put("rowCount", rows.size());
        body.put("rows", rows);
        body.put("note",
                "三个调用点都跑同一条链：HQL 里的实体名 WmsTask 运行期解析到宿主影子版，"
                        + "故真跑的 SQL 打的是 wms_task_project / task_type");
        return body;
    }
}
