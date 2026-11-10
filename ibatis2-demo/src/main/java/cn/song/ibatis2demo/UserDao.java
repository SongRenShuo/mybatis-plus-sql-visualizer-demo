package cn.song.ibatis2demo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.song.ibatis2demo.model.User;

/**
 * iBatis 2 DAO 接口——语句 id 与 sqlmap/User.xml 的 <sqlMap namespace="User"> 一一对应
 * （sqlmap-config.xml 打开了 useStatementNamespaces，运行期 id 全部带 User. 前缀）。
 *
 * <p>用途：①给「XML 语句行 ↔ Java 调用行」双向跳转箭头提供真实的调用点（语句 id 字符串字面量
 * 就是箭头的锚）；②给「真实调用 + SQL 捕获」提供可运行的入口（Ibatis2ExecMain）。</p>
 *
 * <p>注意两处**刻意的形态语料**（执行会失败，是语料本意，不是缺陷）：</p>
 * <ul>
 *   <li>{@link #viaParameterMapRawHash}：声明了 parameterMap 的语句体内 `#username#` 会被引擎
 *       原样发给数据库（MySQL 里 # 是行注释，执行必然报错）——用于验证「parameterMap ⇒ # 不转 ?」；</li>
 *   <li>{@link #callUserProcedure}：`{call PKG_USER.SYNC_USER(?,?,?)}` 需要数据库里先建包，
 *       本语料只验 statement 形态。</li>
 * </ul>
 */
public interface UserDao {

    List<User> selectAll() throws SQLException;

    User selectById(int id) throws SQLException;

    /** 两段式 #username:VARCHAR# */
    List<User> selectTwoSegment(String username) throws SQLException;

    /** 三段式 #age:INTEGER:0#（nullValue=0） */
    List<User> selectThreeSegment(Integer age) throws SQLException;

    /** 三段式 VARCHAR + nullValue=0（对照：三段式判定只看冒号数量） */
    List<User> selectVarcharNullValue(String email) throws SQLException;

    /** <include refid="userActiveCondition"/>：片段里带 #status# */
    List<User> selectByInclude(User query) throws SQLException;

    /** 高级语法 #id,jdbcType=INTEGER# */
    List<User> selectAdvancedSyntax(int id) throws SQLException;

    /** $orderColumn$ 字符串直替（null 时静默丢弃——ORDER BY 段会消失，引擎行为） */
    List<User> selectOrderBy(String orderColumn) throws SQLException;

    /** ## / $$ 转义字面量（渲染应为 A#B / C$D） */
    List<Map<String, Object>> selectEscapes() throws SQLException;

    /** <dynamic> 四条件共存：勾选哪些条件由参数对象的属性决定（Probe 判定） */
    List<User> selectByCondition(User query) throws SQLException;

    /** prepend 逐字拼接不补空格——真实项目必须写 "AND "（带尾随空格），否则执行报语法错 */
    List<User> selectPrependNoSpace(User query) throws SQLException;

    /** 与 {@link #selectPrependNoSpace} 的可执行对照：prepend 带尾随空格，执行不会报错 */
    List<User> selectPrependWithSpace(User query) throws SQLException;

    /** UPDATE（CRUD 完整面） */
    int updateUser(User u) throws SQLException;

    /** DELETE（CRUD 完整面） */
    int deleteUser(int id) throws SQLException;

    /** <iterate> + #ids[]# 下标占位 */
    List<User> selectByIterate(List<String> ids) throws SQLException;

    /** <selectKey type="pre">：先执行序列取号再 INSERT。序列形态是 Oracle 的
     *  SELECT SEQ_USER_ID.NEXTVAL FROM DUAL——在 MySQL 上执行会在 selectKey 一步失败（语料本意）。 */
    int insertUser(User u) throws SQLException;

    /** parameterMap + 手写 ? + 体内保留 #username#（形态语料：执行会失败，见接口注释） */
    List<Map<String, Object>> viaParameterMapRawHash(User u) throws SQLException;

    /** <isNull>/<isNotNull> 对 null 参数的显式短路：parameterObject 传 null 走 isNull 分支 */
    List<User> selectNullParamBranch() throws SQLException;

    /** 同上，但传非 null 参数对象 —— 走 isNotNull 分支（两态对照） */
    List<User> selectNullParamBranch(User query) throws SQLException;

    /** N+1 嵌套查询的目标语句 */
    List<User> selectByDeptId(long deptId) throws SQLException;

    /** procedure 形态语料：{call PKG_USER.SYNC_USER(?,?,?)}——执行需要先建包 */
    void callUserProcedure(User u) throws SQLException;
}
