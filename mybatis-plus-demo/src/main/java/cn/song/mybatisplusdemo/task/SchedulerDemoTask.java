package cn.song.mybatisplusdemo.task;

import cn.song.mybatisplusdemo.entity.User;
import cn.song.mybatisplusdemo.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务演示（演示录制 N5：SQL 日志「从调用栈跳转」的 scheduling-1 线程帧）
 *
 * <p>每 3 秒查一次 user 表，让增强捕获在 SQL 日志里持续产出线程名为
 * {@code scheduling-1} 的条目，供调用栈弹层演示。</p>
 *
 * @author SongRenShuo
 */
@Component
public class SchedulerDemoTask {

    private static final Logger log = LoggerFactory.getLogger(SchedulerDemoTask.class);

    private final UserMapper userMapper;

    public SchedulerDemoTask(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Scheduled(fixedRate = 3000)
    public void pollUser() {
        User user = userMapper.selectById(1);
        log.info("scheduled poll: {}", user == null ? "none" : user.getUsername());
    }
}
