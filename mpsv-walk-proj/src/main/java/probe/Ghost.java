package probe;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 走查用实体（一次性工程 mpsv-walk-proj）：映射一张**不存在**的表。
 *
 * 用途＝O-49 ③④ 的错误定位按钮判据——让预览执行的 SQL 必然失败，从而进入错误呈现链：
 * 锚点可解析 → 按钮出现（④）；锚点不可解析（源文件失效）→ 按钮不出现（③）。
 * 两者必须用**同一条失败 SQL**，否则「按钮不出现」无法排除「错误根本没被识别成富错误」这条解释。
 */
@TableName("no_such_table_xyz")
public class Ghost {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
}
