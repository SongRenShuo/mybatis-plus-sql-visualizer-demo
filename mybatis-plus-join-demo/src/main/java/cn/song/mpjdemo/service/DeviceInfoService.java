package cn.song.mpjdemo.service;

import cn.song.mpjdemo.entity.DeviceInfoEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * 设备联查服务层（对齐插件 MpjJoinExtConverterTest 的 rightAlias / ext / MConsumer 形态）
 *
 * @author SongRenShuo
 */
public interface DeviceInfoService {

    /**
     * join 5 参 rightAlias：leftJoin(Class, "st", 左列, "t", 右列)
     */
    List<Map<String, Object>> joinRightAlias();

    /**
     * join ext 函数追加 ON 条件 + 子表 MConsumer 子查询 join
     */
    List<Map<String, Object>> joinExtAndSubTable();

    /**
     * from(子查询主表) + 联表分页（pageByMain）
     */
    IPage<Map<String, Object>> joinFromAndPage(Page<Map<String, Object>> page);

    /**
     * selectJoinOne / selectJoinCount 单条与计数
     */
    Map<String, Object> joinOneAndCount(Integer id);

    /**
     * 原生 selectJoinList（实体返回）
     */
    List<DeviceInfoEntity> joinListEntity();
}
