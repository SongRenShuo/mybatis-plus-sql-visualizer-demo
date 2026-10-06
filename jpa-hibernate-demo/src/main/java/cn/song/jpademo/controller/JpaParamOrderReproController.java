package cn.song.jpademo.controller;

import cn.song.jpademo.entity.WmsLocation;
import cn.song.jpademo.entity.WmsLocationAGVPositionType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * JPA 链式 setParameter 写重复现控制器（O-111 / 计划 20261006-1048 V83 真机复验载体）
 *
 * <p>复刻用户反馈截图同款形态：entityManager.createQuery(HQL 拼接, Long.class) 链式
 * setParameter 共 6 次、5 个唯一参数名，其中 locationStatus <b>写重两次</b>；
 * HQL 含 join 与 order by。旧版插件该场景预览渲染整体错位（warehouse_id='TC'
 * 这类张冠李戴）、面板「表：」误显 long；修复版应逐位正确。
 *
 * <p><b>静态预览验证步骤</b>（装修复版插件后）：
 * <ol>
 *   <li>光标放在 {@link #occupyEmptyTcLocation} 的 createQuery 调用上触发 SQL 预览面板</li>
 *   <li>参数面板应 5 行（locationStatus 只一行）：locationStatus / zoneCode / emptyFullDegree /
 *       positionType 四行应<b>自动预填代码里的常量值</b>（E / KQ13 / 0 / TC）；
 *       warehouseId 是方法变量、保持空待手填 1</li>
 *   <li>渲染 SQL 逐位验收（只需手填 warehouseId 后）：warehouse_id = 1（数值不带引号）、
 *       status = 'E'、zone.code = 'KQ13'、full_degree = '0'、agv_position_type = 'TC'</li>
 *   <li>面板「表：」应显示 WMS_LOCATION</li>
 *   <li>参数区尾部应有灰字提示：同名参数多次设置（运行时以最后一次为准）：locationStatus</li>
 *   <li>「复制可执行 SQL」与面板渲染逐字一致</li>
 * </ol>
 *
 * <p><b>运行时验证</b>：GET /jpa/paramOrder/occupyEmptyTcLocation?warehouseId=1
 * ——Hibernate 对同名重复 setParameter 是覆盖语义，应正常执行返回 200（空表返回 null）。
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/jpa/paramOrder")
public class JpaParamOrderReproController {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 复现入口（截图同款业务方法形态：occupyEmptyTcLocation）
     *
     * GET /jpa/paramOrder/occupyEmptyTcLocation?warehouseId=1
     */
    @GetMapping("/occupyEmptyTcLocation")
    public WmsLocation occupyEmptyTcLocationEndpoint(@RequestParam(required = false) Long warehouseId) {
        return occupyEmptyTcLocation(warehouseId);
    }

    /**
     * 截图同款私有业务方法：拣货作业占用空 TC 库位
     */
    private WmsLocation occupyEmptyTcLocation(Long warehouseId) {
        if (warehouseId == null) {
            throw new IllegalArgumentException("拣货作业单仓库不能为空");
        }
        List<Long> candidateIds = this.entityManager.createQuery(
                "select location.id from WmsLocation location "
                    + "join WmsZone zone on zone.id = location.zoneId "
                    + "where location.warehouseId = :warehouseId "
                    + "and location.status = :locationStatus "
                    + "and zone.code = :zoneCode "
                    + "and location.fullDegree = :emptyFullDegree "
                    + "and location.agvPositionType = :positionType "
                    + "order by location.putawaySequence asc, location.id asc",
                Long.class)
            .setParameter("warehouseId", warehouseId)
            .setParameter("locationStatus", "E")
            .setParameter("zoneCode", "KQ13")
            .setParameter("locationStatus", "E")
            .setParameter("emptyFullDegree", 0)
            .setParameter("positionType", WmsLocationAGVPositionType.TC)
            .getResultList();
        if (candidateIds.isEmpty()) {
            return null;
        }
        return entityManager.find(WmsLocation.class, candidateIds.get(0));
    }
}
