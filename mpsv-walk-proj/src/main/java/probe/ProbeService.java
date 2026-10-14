package probe;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 走查用 Wrapper 链（一次性工程）：给插件的「Convert to SQL」(Alt+Shift+Q) 一个可预览对象。
 *
 * 用 DELETE 形态（`delete(wrapper)`）——O-59 的 GUI 半边要的就是「DELETE → 预览面板执行 → 更多 → 回滚 SQL
 * → 粘贴快照 → 回填 INSERT 带 SET IDENTITY_INSERT」。
 */
public class ProbeService {

    private BaseMapper<User> userMapper;

    /** 走查入口：光标置于此链内按 Alt+Shift+Q → 预览弹窗（DELETE FROM user WHERE id = ?）。 */
    public int deleteOne() {
        return userMapper.delete(new LambdaQueryWrapper<User>().eq(User::getId, 1));
    }

    /** 对照：SELECT 链（回滚为 UNABLE，用于区分「执行计划」可用与否）。 */
    public Object selectOne() {
        return userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getId, 1));
    }
}
