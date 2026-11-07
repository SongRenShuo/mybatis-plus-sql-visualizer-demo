package cn.song.mybatisplusdemo.service;

import cn.song.mybatisplusdemo.entity.GoldenDbDevice;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * GoldenDB 方言演示服务（T-GoldenDbDemoCases）。
 *
 * <p>方法族刻意覆盖 GoldenDB 方言的关键语法面，既作插件 GUI 预览（Alt+Shift+Q）的捕获素材，
 * 也作增强捕获（attach 后 /logFeed）的执行素材。各方法注释均标注调研册页码依据：</p>
 * <ul>
 *     <li>分页 {@code LIMIT [offset,] count}，offset 0 起算（手册 p73）——MP 分页插件生成 LIMIT 形态；</li>
 *     <li>upsert {@code ON DUPLICATE KEY UPDATE}（手册 p66）——MP saveOrUpdate 语义映射为插入/更新两路；</li>
 *     <li>多行 VALUES 批量插入（手册 p66）——insertBatchSomeColumn 注入方法；</li>
 *     <li>{@code DELETE ... ORDER BY ... LIMIT n}（手册 p274 文法 / p276 示例）；</li>
 *     <li>反引号标识符 + 保留字列名（手册 p320 引用形态、p351-355 保留字清单）；</li>
 *     <li>事务 {@code START TRANSACTION} / COMMIT / ROLLBACK（手册 p83）。</li>
 * </ul>
 *
 * @author T-GoldenDbDemoCases
 */
public interface GoldenDbDialectDemoService {

    /**
     * 分页查询：LambdaQueryWrapper + MP 分页插件，生成 LIMIT offset,count（offset 0 起算，手册 p73）。
     */
    IPage<GoldenDbDevice> pageDevices(long current, long size);

    /**
     * upsert：insertOrUpdate 语义。主键命中走 UPDATE、未命中走 INSERT，
     * 真机 SQL 形态为 {@code INSERT ... ON DUPLICATE KEY UPDATE}（手册 p66）——由 MP 主键策略决定生成路径。
     */
    boolean upsertDevice(GoldenDbDevice device);

    /**
     * 多行 VALUES 批量插入（手册 p66）：insertBatchSomeColumn 生成单条多行 VALUES。
     */
    int insertBatch(List<GoldenDbDevice> devices);

    /**
     * DELETE ... ORDER BY ... LIMIT n（手册 p274/p276）：删最新 n 条。
     */
    int deleteNewest(int n);

    /**
     * 事务演示（手册 p83 START TRANSACTION 语义，Spring @Transactional 由连接层映射）：
     * rollback=true 时插入后抛异常回滚，验证事务边界；rollback=false 时正常提交。
     */
    GoldenDbDevice txDemo(boolean rollback);
}
