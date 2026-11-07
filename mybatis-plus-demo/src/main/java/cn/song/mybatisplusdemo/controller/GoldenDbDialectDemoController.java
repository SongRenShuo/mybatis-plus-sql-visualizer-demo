package cn.song.mybatisplusdemo.controller;

import cn.song.mybatisplusdemo.entity.GoldenDbDevice;
import cn.song.mybatisplusdemo.service.GoldenDbDialectDemoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * GoldenDB 方言演示端点（T-GoldenDbDemoCases）。
 *
 * <p>配合 {@code application-goldendb.yml} profile（GoldenDB 真机）或默认 MySQL 数据源（形态级对照）使用。
 * 每个端点执行一条覆盖 GoldenDB 方言面的调用链，供插件预览面板渲染与增强捕获喂料。</p>
 *
 * @author T-GoldenDbDemoCases
 */
@RestController
@RequestMapping("/goldendb")
public class GoldenDbDialectDemoController {

    @Autowired
    private GoldenDbDialectDemoService goldenDbDialectDemoService;

    /**
     * 分页查询：LIMIT offset,count（0 起算，手册 p73）。GET /goldendb/page?current=1&size=3
     */
    @GetMapping("/page")
    public IPage<GoldenDbDevice> page(@RequestParam(defaultValue = "1") long current,
                                      @RequestParam(defaultValue = "5") long size) {
        return goldenDbDialectDemoService.pageDevices(current, size);
    }

    /**
     * upsert：ON DUPLICATE KEY UPDATE（手册 p66）。POST /goldendb/upsert，body 为设备 JSON。
     */
    @PostMapping("/upsert")
    public boolean upsert(@RequestBody GoldenDbDevice device) {
        return goldenDbDialectDemoService.upsertDevice(device);
    }

    /**
     * 多行 VALUES 批量插入（手册 p66）。POST /goldendb/insertBatch，body 为设备 JSON 数组。
     */
    @PostMapping("/insertBatch")
    public int insertBatch(@RequestBody List<GoldenDbDevice> devices) {
        return goldenDbDialectDemoService.insertBatch(devices);
    }

    /**
     * DELETE ... ORDER BY ... LIMIT n（手册 p274/p276）。POST /goldendb/deleteNewest?n=2
     */
    @PostMapping("/deleteNewest")
    public int deleteNewest(@RequestParam(defaultValue = "1") int n) {
        return goldenDbDialectDemoService.deleteNewest(n);
    }

    /**
     * 事务边界演示：rollback=true 回滚（START TRANSACTION/ROLLBACK，手册 p83）。
     * GET /goldendb/tx?rollback=true
     */
    @GetMapping("/tx")
    public ResponseEntity<?> tx(@RequestParam(defaultValue = "false") boolean rollback) {
        try {
            return ResponseEntity.ok(goldenDbDialectDemoService.txDemo(rollback));
        } catch (IllegalStateException e) {
            // 回滚演示的预期异常：回滚后端点返回 200 + 说明，便于走查脚本断言（Java 8 无 Map.of，用 LinkedHashMap）
            java.util.Map<String, Object> body = new java.util.LinkedHashMap<>();
            body.put("rolledBack", true);
            body.put("message", e.getMessage());
            return ResponseEntity.ok(body);
        }
    }
}
