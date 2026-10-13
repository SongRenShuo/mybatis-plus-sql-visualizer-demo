package cn.song.mpjdemo.controller;

import cn.song.mpjdemo.entity.UserDO;
import cn.song.mpjdemo.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 慢查询 / N+1 演示端点（演示录制用素材）。
 *
 * <p>两个端点分别造出演示所需的两类运行期形态：
 * <ul>
 *   <li>{@code /mpj/perf/slow}：一条耗时 &gt;1s 的查询，用于「慢查询标红 + 慢查询计数 + 按耗时排序」演示；</li>
 *   <li>{@code /mpj/perf/n1}：同一模板连续触发 5 次，用于「同结构 N 条徽章」演示。</li>
 * </ul>
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/mpj/perf")
public class PerfDemoController {

    @Resource
    private UserMapper userMapper;

    /**
     * 模拟慢查询：SLEEP(1.2) 让这条语句稳定耗时 1.2s 左右，超过默认慢查询阈值 1000ms。
     */
    @GetMapping("/slow")
    public Integer slow() {
        return userMapper.simulateSlowQuery();
    }

    /**
     * N+1 形态：循环按 id 单查同一条模板 5 次（典型 N+1 触发方式）。
     */
    @GetMapping("/n1")
    public List<UserDO> n1() {
        List<UserDO> list = new ArrayList<>();
        for (long id = 1; id <= 5; id++) {
            UserDO user = userMapper.selectById(id);
            if (user != null) {
                list.add(user);
            }
        }
        return list;
    }
}
