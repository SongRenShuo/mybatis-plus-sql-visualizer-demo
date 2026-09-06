package cn.song.mybatisplusdemo.common;

import java.util.List;
import java.util.Map;

/**
 * 注解 SQL Provider 族演示（@SelectProvider 等引用的 SQL 构造器）
 *
 * @author SongRenShuo
 */
public class UserSqlProvider {

    /**
     * 对应 @SelectProvider(type = UserSqlProvider.class, method = "selectById")
     */
    public String selectById(Map<String, Object> params) {
        return "SELECT * FROM user WHERE id = #{id}";
    }

    /**
     * 对应 @SelectProvider：带条件拼接（ProviderContext 演示）
     */
    public String selectByCondition(Map<String, Object> params) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user WHERE deleted = 0");
        Object username = params.get("username");
        if (username != null && !username.toString().isEmpty()) {
            sql.append(" AND username LIKE CONCAT('%', #{username}, '%')");
        }
        Object status = params.get("status");
        if (status != null) {
            sql.append(" AND status = #{status}");
        }
        sql.append(" ORDER BY id DESC");
        return sql.toString();
    }

    /**
     * 对应 @InsertProvider
     */
    public String insert(Map<String, Object> params) {
        return "INSERT INTO user(username, password, age, email, status) "
                + "VALUES (#{username}, #{password}, #{age}, #{email}, #{status})";
    }

    /**
     * 对应 @UpdateProvider
     */
    public String updateStatus(Map<String, Object> params) {
        return "UPDATE user SET status = #{status}, update_time = now() WHERE id = #{id}";
    }

    /**
     * 对应 @DeleteProvider
     */
    public String deleteByRoleIds(List<Integer> roleIds) {
        return "DELETE FROM user WHERE role_id IN (" + joinIds(roleIds) + ")";
    }

    private String joinIds(List<Integer> ids) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ids.size(); i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(ids.get(i));
        }
        return sb.toString();
    }
}
