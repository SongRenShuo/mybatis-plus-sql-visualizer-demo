package cn.song.mpjdemo.controller;

import cn.song.mpjdemo.entity.DeviceInfoEntity;
import cn.song.mpjdemo.service.DeviceInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 设备联查（MPJ rightAlias / ext / MConsumer / from 用例）
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/mpj/device")
public class DeviceInfoController {

    @Resource
    private DeviceInfoService deviceInfoService;

    /**
     * join 5 参 rightAlias 形态
     */
    @GetMapping("/rightAlias")
    public List<Map<String, Object>> rightAlias() {
        return deviceInfoService.joinRightAlias();
    }

    /**
     * ext 扩展 ON 条件 + 子表 MConsumer 子查询 join
     */
    @GetMapping("/extSub")
    public List<Map<String, Object>> extSub() {
        return deviceInfoService.joinExtAndSubTable();
    }

    /**
     * from 子查询主表 + setTableName + around + pageByMain 分页
     */
    @GetMapping("/fromPage")
    public IPage<Map<String, Object>> fromPage(Page<Map<String, Object>> page) {
        return deviceInfoService.joinFromAndPage(page);
    }

    /**
     * selectJoinMap + selectJoinCount
     */
    @GetMapping("/one/{id}")
    public Map<String, Object> one(@PathVariable Integer id) {
        return deviceInfoService.joinOneAndCount(id);
    }

    /**
     * 实体返回 selectJoinList
     */
    @GetMapping("/entityList")
    public List<DeviceInfoEntity> entityList() {
        return deviceInfoService.joinListEntity();
    }
}
