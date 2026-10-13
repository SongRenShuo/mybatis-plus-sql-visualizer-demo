package cn.song.embedprefixdemo.config;

import cn.song.embedprefixdemo.dao.CommonDao;
import cn.song.embedprefixdemo.entity.WmsInventoryEntity;
import cn.song.embedprefixdemo.entity.WmsInventoryQty;
import cn.song.embedprefixdemo.entity.WmsMoveTool;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 演示数据 seed：表空时插两条，让 `/embed-prefix/query` 有结果可回。
 *
 * 注意 `@Transactional` 必须挂在本组件被 Spring 代理的方法上——早先把它写成启动类里的
 * `@Bean CommandLineRunner` 时，事务对 lambda 不生效，`persist` 直接抛
 * `TransactionRequiredException`（已实测踩过），故单独成类。
 *
 * @author SongRenShuo
 */
@Component
public class DemoDataSeeder implements CommandLineRunner {

    private final CommonDao commonDao;

    public DemoDataSeeder(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (!commonDao.findByQuery("from WmsInventoryEntity inv order by inv.id").isEmpty()) {
            return;
        }
        commonDao.save(inventory("W01", "P001", 120L));
        commonDao.save(inventory("W01", "P002", 0L));
    }

    private WmsInventoryEntity inventory(String warehouseId, String palletNo, Long baseQty) {
        WmsInventoryEntity entity = new WmsInventoryEntity();
        entity.setWarehouseId(warehouseId);
        WmsMoveTool moveTool = new WmsMoveTool();
        moveTool.setPalletNo(palletNo);
        entity.setMoveTool(moveTool);
        WmsInventoryQty qty = new WmsInventoryQty();
        qty.setBaseQty(baseQty);
        entity.setQty(qty);
        return entity;
    }
}
