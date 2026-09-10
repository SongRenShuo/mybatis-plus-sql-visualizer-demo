package cn.song.mpjdemo.service.impl;

import cn.song.mpjdemo.entity.DeviceInfoEntity;
import cn.song.mpjdemo.entity.StationInfoEntity;
import cn.song.mpjdemo.mapper.DeviceInfoMapper;
import cn.song.mpjdemo.service.DeviceInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 设备联查服务实现类
 * 对齐插件测试 T-M21-02：join 5 参 rightAlias / 4 参 rightAlias / ext MFunction / 子表 MConsumer；
 * T-M21-07：from(子查询主表)；T-M21-09：around / setTableName / pageByMain
 *
 * @author SongRenShuo
 */
@Service("deviceInfoService")
public class DeviceInfoServiceImpl implements DeviceInfoService {

    @Resource
    private DeviceInfoMapper deviceInfoMapper;

    /**
     * join 5 参 rightAlias：leftJoin(Class, "st", 左列, "t", 右列) → ON st.左列 = t.右列
     * （右别名 "t" 作用于右列所在表——主表；显式别名 "st" 作用于左列所在表——关联表）
     */
    @Override
    public List<Map<String, Object>> joinRightAlias() {
        MPJLambdaWrapper<DeviceInfoEntity> wrapper = JoinWrappers.lambda(DeviceInfoEntity.class)
                .selectAll(DeviceInfoEntity.class)
                .select(StationInfoEntity::getStationName)
                .leftJoin(StationInfoEntity.class, "st",
                        StationInfoEntity::getStationId, "t", DeviceInfoEntity::getId)
                .eq(DeviceInfoEntity::getId, 1);
        return deviceInfoMapper.selectJoinMaps(wrapper);
    }

    /**
     * join ext 函数追加 ON 条件 + 子表 MConsumer 子查询 join
     * - leftJoin(Class, 左列, 右列, ext -> ext.eq(...))：ext 内条件追加到 ON 条件组
     * - leftJoin(Class, t -> t.setAlias("tt").selectAll().ge(...), 左列, 右列)：子表渲染子查询 join
     */
    @Override
    public List<Map<String, Object>> joinExtAndSubTable() {
        MPJLambdaWrapper<DeviceInfoEntity> wrapper = JoinWrappers.lambda(DeviceInfoEntity.class)
                .selectAll(DeviceInfoEntity.class)
                .leftJoin(StationInfoEntity.class,
                        StationInfoEntity::getId, DeviceInfoEntity::getStationId,
                        ext -> ext.eq(StationInfoEntity::getStationName, "中心站"))
                .leftJoin(StationInfoEntity.class, t -> t
                                .setAlias("tt")
                                .selectAll()
                                .ge(StationInfoEntity::getMerchantId, 0),
                        StationInfoEntity::getStationId, DeviceInfoEntity::getStationId)
                .eq(DeviceInfoEntity::getId, 1);
        return deviceInfoMapper.selectJoinMaps(wrapper);
    }

    /**
     * from(子查询主表) + setTableName + around + pageByMain 综合
     */
    @Override
    public IPage<Map<String, Object>> joinFromAndPage(Page<Map<String, Object>> page) {
        MPJLambdaWrapper<DeviceInfoEntity> wrapper = JoinWrappers.lambda(DeviceInfoEntity.class)
                .selectAll()
                .from(from -> from
                        .selectAll()
                        .ge(DeviceInfoEntity::getId, 0)
                        .last("LIMIT 100"))
                .leftJoin(StationInfoEntity.class, StationInfoEntity::getStationId, DeviceInfoEntity::getStationId)
                .around("/* mpj hint */ ", " /* end */");
        return deviceInfoMapper.selectJoinMapsPage(page, wrapper);
    }

    /**
     * selectJoinOne / selectJoinCount
     */
    @Override
    public Map<String, Object> joinOneAndCount(Integer id) {
        MPJLambdaWrapper<DeviceInfoEntity> wrapper = JoinWrappers.lambda(DeviceInfoEntity.class)
                .selectAll(DeviceInfoEntity.class)
                .select(StationInfoEntity::getStationName, StationInfoEntity::getMerchantId)
                .leftJoin(StationInfoEntity.class, StationInfoEntity::getStationId, DeviceInfoEntity::getStationId)
                .eq(DeviceInfoEntity::getId, id);
        Map<String, Object> one = deviceInfoMapper.selectJoinMap(wrapper);
        // selectJoinCount 会复用 wrapper 的 select 列，须用不含 select 列的 wrapper 计数
        Long count = deviceInfoMapper.selectJoinCount(JoinWrappers.lambda(DeviceInfoEntity.class)
                .leftJoin(StationInfoEntity.class, StationInfoEntity::getStationId, DeviceInfoEntity::getStationId)
                .eq(DeviceInfoEntity::getId, id));
        one.put("count", count);
        return one;
    }

    /**
     * 实体返回 selectJoinList
     */
    @Override
    public List<DeviceInfoEntity> joinListEntity() {
        MPJLambdaWrapper<DeviceInfoEntity> wrapper = JoinWrappers.lambda(DeviceInfoEntity.class)
                .selectAll(DeviceInfoEntity.class)
                .selectAs(StationInfoEntity::getStationName,DeviceInfoEntity::getDeviceName)
                .leftJoin(StationInfoEntity.class, StationInfoEntity::getStationId, DeviceInfoEntity::getStationId)
                .eq(DeviceInfoEntity::getShareSchemeId, 1)
                .orderByAsc(DeviceInfoEntity::getId);
        return deviceInfoMapper.selectJoinList(DeviceInfoEntity.class, wrapper);
    }
}
