package cn.song.ibatis2demo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import cn.song.ibatis2demo.model.User;

/**
 * {@link UserDao} 的实现：所有语句 id 都带 namespace 前缀 `User.`（sqlmap-config.xml 打开了
 * useStatementNamespaces，运行期 id 是 User.selectAll / User.selectById / …）。
 *
 * <p>语句 id 字符串字面量就是插件「XML 语句行 ↔ Java 调用行」跳转箭头的锚——改 id 时两侧要一起改。</p>
 */
public class UserDaoImpl implements UserDao {

    private final SqlMapClient client;

    public UserDaoImpl(SqlMapClient client) {
        this.client = client;
    }

    @Override
    public List<User> selectAll() throws SQLException {
        return client.queryForList("User.selectAll");
    }

    @Override
    public User selectById(int id) throws SQLException {
        return (User) client.queryForObject("User.selectById", id);
    }

    @Override
    public List<User> selectTwoSegment(String username) throws SQLException {
        return client.queryForList("User.selectTwoSegment", username);
    }

    @Override
    public List<User> selectThreeSegment(Integer age) throws SQLException {
        return client.queryForList("User.selectThreeSegment", age);
    }

    @Override
    public List<User> selectVarcharNullValue(String email) throws SQLException {
        return client.queryForList("User.selectVarcharNullValue", email);
    }

    @Override
    public List<User> selectByInclude(User query) throws SQLException {
        return client.queryForList("User.selectByInclude", query);
    }

    @Override
    public List<User> selectAdvancedSyntax(int id) throws SQLException {
        return client.queryForList("User.selectAdvancedSyntax", id);
    }

    @Override
    public List<User> selectOrderBy(String orderColumn) throws SQLException {
        return client.queryForList("User.selectOrderBy", orderColumn);
    }

    @Override
    public List<Map<String, Object>> selectEscapes() throws SQLException {
        return client.queryForList("User.selectEscapes");
    }

    @Override
    public List<User> selectByCondition(User query) throws SQLException {
        return client.queryForList("User.selectByCondition", query);
    }

    @Override
    public List<User> selectPrependNoSpace(User query) throws SQLException {
        return client.queryForList("User.selectPrependNoSpace", query);
    }

    @Override
    public List<User> selectPrependWithSpace(User query) throws SQLException {
        return client.queryForList("User.selectPrependWithSpace", query);
    }

    @Override
    public int updateUser(User u) throws SQLException {
        return client.update("User.updateUser", u);
    }

    @Override
    public int deleteUser(int id) throws SQLException {
        return client.delete("User.deleteUser", id);
    }

    @Override
    public List<User> selectByIterate(List<String> ids) throws SQLException {
        return client.queryForList("User.selectByIterate", ids);
    }

    @Override
    public int insertUser(User u) throws SQLException {
        // selectKey type=pre：insert() 返回的就是 selectKey 生成的主键（引擎语义）
        Object key = client.insert("User.insertUser", u);
        return key == null ? -1 : (Integer) key;
    }

    @Override
    public List<Map<String, Object>> viaParameterMapRawHash(User u) throws SQLException {
        // 形态语料：体内 #username# 被引擎原样下发（MySQL 里 # 是行注释）→ 执行会报语法错。
        // 结果映射也没有 resultMap/resultClass——iBatis 会按 Object[] / 失败处理，按需调整。
        return client.queryForList("User.viaParameterMapRawHash", u);
    }

    @Override
    public List<User> selectNullParamBranch() throws SQLException {
        // parameterObject 传 null：<isNull> 成立（iBatis 对 null 参数有显式短路）
        return client.queryForList("User.selectNullParamBranch", null);
    }

    @Override
    public List<User> selectNullParamBranch(User query) throws SQLException {
        return client.queryForList("User.selectNullParamBranch", query);
    }

    @Override
    public List<User> selectByDeptId(long deptId) throws SQLException {
        return client.queryForList("User.selectByDeptId", deptId);
    }

    @Override
    public void callUserProcedure(User u) throws SQLException {
        // procedure 形态语料：先在数据库建 PKG_USER 包才能执行
        client.update("User.callUserProcedure", u);
    }
}
