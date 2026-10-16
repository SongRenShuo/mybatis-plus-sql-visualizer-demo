package cn.song.jarmodeldemo.config;

import cn.song.jarlib.entity.WmsInventoryEntity;
import cn.song.jarlib.entity.WmsInventoryQty;
import cn.song.jarlib.entity.WmsItemKey;
import cn.song.jarlib.entity.WmsSku;
import cn.song.jarmodeldemo.dao.WmsJarCommonDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * 演示数据 seed：表空时插两条，让 {@code /jar-model/query} 有结果可回。
 *
 * <p>实体类来自依赖 JAR——本类是宿主模块里唯一 new 出这些实体的地方，正好也自证
 * 「JAR 里的实体能被宿主的持久化单元正常映射」。
 *
 * <p>{@code @Transactional} 必须挂在本组件被 Spring 代理的方法上（写成启动类里的
 * {@code @Bean CommandLineRunner} 时事务对 lambda 不生效，persist 会抛
 * {@code TransactionRequiredException}——同仓 {@code jpa-embedded-prefix-demo} 已踩过）。
 *
 * @author SongRenShuo
 */
@Component
public class DemoDataSeeder implements CommandLineRunner {

    private final WmsJarCommonDao wmsJarCommonDao;

    public DemoDataSeeder(WmsJarCommonDao wmsJarCommonDao) {
        this.wmsJarCommonDao = wmsJarCommonDao;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (!wmsJarCommonDao.findByQuery("from WmsInventoryEntity inv order by inv.id").isEmpty()) {
            return;
        }
        wmsJarCommonDao.save(inventory("W01", "IN_STOCK", 120L, "LOT-2026-01"));
        wmsJarCommonDao.save(inventory("W01", "IN_STOCK", 0L, "LOT-2026-02"));
        wmsJarCommonDao.save(inventory("W02", "FROZEN", 55L, "LOT-2026-03"));
    }

    private WmsInventoryEntity inventory(String warehouseId, String inventoryStatus, Long baseQty, String lotNo) {
        WmsInventoryEntity entity = new WmsInventoryEntity();
        entity.setWarehouseId(warehouseId);

        WmsInventoryQty qty = new WmsInventoryQty();
        qty.setBaseQty(baseQty);
        entity.setQty(qty);

        WmsSku sku = new WmsSku();
        sku.setInventoryStatus(inventoryStatus);
        entity.setSku(sku);

        WmsItemKey.LotInfo lotInfo = new WmsItemKey.LotInfo();
        lotInfo.setReceivedDate(LocalDateTime.of(2026, 1, 1, 8, 30));
        WmsItemKey itemKey = new WmsItemKey();
        itemKey.setLotInfo(lotInfo);
        entity.setItemKey(itemKey);

        return entity;
    }
}
