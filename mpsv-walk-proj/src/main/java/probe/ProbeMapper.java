package probe;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 走查用注解 SQL（一次性工程 mpsv-walk-proj）。
 *
 * 用途：runIde 沙盒里让插件的注解预览（gutter 图标）有对象可预览，从而走
 * ① O-59 的 GUI 半边（DELETE → 预览弹窗 → 执行 → 更多 → 回滚 SQL → 粘贴快照 → 回填 INSERT 带 identity 包装）
 * ② O-52 ② 的 SQL Server 回放（同上，两条是同一流程的两面）
 * ③ O-48 ④（对 DML 点「执行计划」应给提示且**不执行**）
 * ④ T-PerfSweep6 ①（千行 VALUES 的 INSERT 预览编辑是否可感卡顿）
 * ⑤ O-49 ③④（让预览执行失败时错误定位按钮的出现/不出现）
 *
 * 目标库：本机 Docker 容器 mpsv-mssql（SQL Server 2022，127.0.0.1:14333），库里已建
 * `dbo.[user]`（id INT IDENTITY 主键 + username/password/age/email 等列）与 `dbo.mpv_ident`。
 */
public interface ProbeMapper {

    /** O-59 / O-52 ②：回滚链的 DELETE（user.id 是自增列 ⇒ 回填 INSERT 必须带 SET IDENTITY_INSERT）。 */
    @Delete("DELETE FROM [user] WHERE id = #{id}")
    int deleteUserById(@Param("id") Integer id);

    /** O-48 ④：DML 点「执行计划」应给提示、不执行。 */
    @Delete("DELETE FROM mpv_ident WHERE id = #{id}")
    int deleteIdentById(@Param("id") Integer id);

    /** 预览基线（对照：SELECT 走「执行计划」是允许的）。 */
    @Select("SELECT id, username FROM [user] WHERE id = #{id}")
    Object selectUserById(@Param("id") Integer id);

    /** T-PerfSweep6 ①：千行 VALUES 的 INSERT 预览（编辑/切换参数的可感卡顿）。 */
    @Insert("<script>"
        + "INSERT INTO [user] (username, password, age, email) VALUES "
        + "<foreach collection='rows' item='r' separator=','>"
        + "(#{r.username}, #{r.password}, #{r.age}, #{r.email})"
        + "</foreach>"
        + "</script>")
    int batchInsert(@Param("rows") java.util.List<Object> rows);
}
