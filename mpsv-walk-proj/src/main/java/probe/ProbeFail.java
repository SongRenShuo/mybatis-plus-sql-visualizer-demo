package probe;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 走查用 Wrapper 链（一次性工程 mpsv-walk-proj）：**必然失败**的那一条。
 *
 * 生成的 SQL 是 `DELETE FROM no_such_table_xyz WHERE id = 1`——表不存在，执行必失败。
 * O-49 ③④ 要的就是这个失败：
 *  - ④ 锚点可解析（`deleteGhost` 里那行 `ghostMapper.delete(...)`）→ 错误条上的「定位」按钮应出现，点了跳到该行；
 *  - ③ 源文件失效（把本文件改名后刷新）→ 同一失败下按钮**不出现**。
 */
public class ProbeFail {

    private BaseMapper<Ghost> ghostMapper;

    /** 走查入口：光标置于此链内按 Alt+Shift+Q → 预览弹窗（DELETE FROM no_such_table_xyz WHERE id = 1）。 */
    public int deleteGhost() {
        return ghostMapper.delete(new LambdaQueryWrapper<Ghost>().eq(Ghost::getId, 1));
    }

}

