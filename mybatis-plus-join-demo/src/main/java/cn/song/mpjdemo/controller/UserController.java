package cn.song.mpjdemo.controller;

import cn.song.mpjdemo.dto.UserDTO;
import cn.song.mpjdemo.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户联查（MPJ 用例）
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/mpj/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 三表联查（selectAll + selectAs + leftJoin + rightJoin + innerJoin）
     */
    @GetMapping("/joinList")
    public List<UserDTO> joinList() {
        return userService.selectJoinList();
    }

    /**
     * join 多条件 on + ext 扩展条件
     */
    @GetMapping("/joinOn")
    public List<UserDTO> joinOn() {
        return userService.selectJoinWithOnCondition();
    }

    /**
     * selectCollection 一对多映射
     */
    @GetMapping("/collection")
    public List<UserDTO> collection() {
        return userService.selectJoinCollection();
    }

    /**
     * 子查询 join（MConsumer 形态）
     */
    @GetMapping("/subQuery")
    public List<UserDTO> subQuery() {
        return userService.selectJoinSubQuery();
    }

    /**
     * from 子查询主表
     */
    @GetMapping("/from")
    public List<UserDTO> from() {
        return userService.selectJoinFrom();
    }

    /**
     * around + setTableName + pageByMain 综合分页
     */
    @GetMapping("/page")
    public IPage<UserDTO> page(Page<UserDTO> page) {
        return userService.selectJoinPage(page);
    }

    /**
     * selectFunc 聚合 + groupBy + having
     */
    @GetMapping("/func")
    public List<Map<String, Object>> func() {
        return userService.selectJoinFunc();
    }

    /**
     * updateJoin 联表更新
     */
    @GetMapping("/updateJoin")
    public int updateJoin() {
        return userService.updateJoin();
    }

    /**
     * deleteJoin 联表删除
     */
    @GetMapping("/deleteJoin")
    public int deleteJoin() {
        return userService.deleteJoin();
    }

    /**
     * fill 填充用例
     */
    @GetMapping("/fill")
    public List<UserDTO> fill() {
        return userService.selectFill();
    }
}
