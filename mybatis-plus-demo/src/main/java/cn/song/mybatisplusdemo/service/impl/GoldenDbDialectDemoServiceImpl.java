package cn.song.mybatisplusdemo.service.impl;

import cn.song.mybatisplusdemo.entity.GoldenDbDevice;
import cn.song.mybatisplusdemo.mapper.GoldenDbDeviceMapper;
import cn.song.mybatisplusdemo.service.GoldenDbDialectDemoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * GoldenDB 方言演示服务实现（T-GoldenDbDemoCases），语料见接口 javadoc。
 *
 * @author T-GoldenDbDemoCases
 */
@Service("goldenDbDialectDemoService")
public class GoldenDbDialectDemoServiceImpl
        extends ServiceImpl<GoldenDbDeviceMapper, GoldenDbDevice>
        implements GoldenDbDialectDemoService {

    /**
     * 分页：PaginationInnerInterceptor 生成 LIMIT offset,count（offset 0 起算，手册 p73）。
     * 真机预览形态：SELECT ... FROM `gdb_device` ORDER BY `id` DESC LIMIT offset,size
     */
    @Override
    public IPage<GoldenDbDevice> pageDevices(long current, long size) {
        LambdaQueryWrapper<GoldenDbDevice> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(GoldenDbDevice::getId);
        return this.page(new Page<>(current, size), wrapper);
    }

    /**
     * upsert（手册 p66 ON DUPLICATE KEY UPDATE）：主键为空走 INSERT，命中已有主键走 UPDATE。
     */
    @Override
    public boolean upsertDevice(GoldenDbDevice device) {
        return this.saveOrUpdate(device);
    }

    /**
     * 多行 VALUES（手册 p66）：insertBatchSomeColumn 由 DefaultSqlInjector 注入（见 MybatisPlusConfig）。
     * 真机预览形态：INSERT INTO `gdb_device` (...) VALUES (...),(...),(...)
     */
    @Override
    public int insertBatch(List<GoldenDbDevice> devices) {
        return this.baseMapper.insertBatchSomeColumn(devices);
    }

    /**
     * DELETE ... ORDER BY ... LIMIT n（手册 p274 文法、p276 示例）。
     * 真机预览形态：DELETE FROM `gdb_device` ORDER BY `id` DESC LIMIT n
     */
    @Override
    public int deleteNewest(int n) {
        return this.baseMapper.deleteNewest(n);
    }

    /**
     * 事务边界演示：rollback=true 时抛出驱动回滚（ROLLBACK，手册 p83），
     * rollback=false 时两笔插入一起提交。验证「同事务原子性」的演示素材。
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public GoldenDbDevice txDemo(boolean rollback) {
        GoldenDbDevice first = new GoldenDbDevice()
                .setDeviceName("tx-demo-first")
                .setStoragedb("tx")
                .setOrder(1);
        this.baseMapper.insert(first);
        GoldenDbDevice second = new GoldenDbDevice()
                .setDeviceName("tx-demo-second")
                .setStoragedb("tx")
                .setOrder(2);
        this.baseMapper.insert(second);
        if (rollback) {
            throw new IllegalStateException("txDemo rollback 演示：两笔插入应一并回滚（START TRANSACTION/ROLLBACK，手册 p83）");
        }
        return first;
    }
}
