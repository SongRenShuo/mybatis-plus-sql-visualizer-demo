package cn.song.mybatisplusdemo.mapper;

import cn.song.mybatisplusdemo.entity.GoldenDbDevice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * GoldenDB 方言演示 Mapper（T-GoldenDbDemoCases）。
 *
 * <p>多行 VALUES 批量插入 {@code insertBatchSomeColumn(List)} 由 {@code MybatisPlusConfig}
 * 里注册的自定义 {@code DefaultSqlInjector}（InsertBatchSomeColumn）注入到本接口，
 * 生成真正的「INSERT INTO ... VALUES (...),(...),(...)」多行 VALUES 形态
 * （GoldenDB 开发支持手册 p66），供插件预览面捕获。</p>
 *
 * @author T-GoldenDbDemoCases
 */
public interface GoldenDbDeviceMapper extends BaseMapper<GoldenDbDevice> {

    /**
     * 多行 VALUES 批量插入（方法体由 InsertBatchSomeColumn 注入器生成，手册 p66）。
     */
    int insertBatchSomeColumn(List<GoldenDbDevice> entityList);

    /**
     * DELETE ... ORDER BY ... LIMIT n：GoldenDB DELETE 文法带 ORDER BY/LIMIT 子句（手册 p274，示例 p276）。
     * 删最新 n 条（id 最大者先删），供插件预览捕获 DELETE+LIMIT 形态。
     */
    @Delete("DELETE FROM `gdb_device` ORDER BY `id` DESC LIMIT #{n}")
    int deleteNewest(@Param("n") int n);
}
