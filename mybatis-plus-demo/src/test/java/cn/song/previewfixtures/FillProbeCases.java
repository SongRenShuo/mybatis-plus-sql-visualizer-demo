package cn.song.previewfixtures;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * 静态预览调用点，无组件、测试注解或 main。不要在运行期调用这些方法。
 * 参数面板中对比 AUTO 主键、独立版本列、字符串/数值填充与显式 DEFAULT。
 */
public final class FillProbeCases {
    private FillProbeCases() { }

    public static void insert(FillProbeMapper mapper, FillProbe entity) {
        mapper.insert(entity);
    }

    public static void updateById(FillProbeMapper mapper, FillProbe entity) {
        mapper.updateById(entity);
    }

    public static void updateWhere(FillProbeMapper mapper, FillProbe entity) {
        mapper.update(entity, new LambdaUpdateWrapper<FillProbe>().eq(FillProbe::getId, 100L));
    }

    public static void select(FillProbeMapper mapper) {
        mapper.selectList(new LambdaQueryWrapper<FillProbe>().eq(FillProbe::getLabel, "preview,only"));
    }

    public static void delete(FillProbeMapper mapper) {
        mapper.deleteById(100L);
    }

    public static void saveBatch(IService<FillProbe> service, List<FillProbe> entities) {
        service.saveBatch(entities);
    }

    public static void updateBatchById(IService<FillProbe> service, List<FillProbe> entities) {
        service.updateBatchById(entities);
    }

    public static void saveOrUpdateBatch(IService<FillProbe> service, List<FillProbe> entities) {
        service.saveOrUpdateBatch(entities);
    }
}
