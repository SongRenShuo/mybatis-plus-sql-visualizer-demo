package cn.song.mybatisplusdemo.mapper;

import cn.song.mybatisplusdemo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * 用户表(User)数据库访问层
 *
 * @author SongRenShuo
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 演示录制 N3 前置：DDL 条目（CREATE 段）进 SQL 日志
     */
    @Update("CREATE TABLE IF NOT EXISTS mpsv_tmp_ddl_demo (id INT)")
    int createDemoTable();

    /**
     * 演示录制 N3 前置：DDL 条目（DROP 段）进 SQL 日志
     */
    @Update("DROP TABLE IF EXISTS mpsv_tmp_ddl_demo")
    int dropDemoTable();

    /**
     * 注解 SQL：纯文本 + 参数占位
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectByAnnotationId(@Param("id") Integer id);

    @Select("SELECT id FROM user WHERE")
    List<Integer> selectInvalidForRecording();

    /**
     * 注解 SQL：script 动态标签（if + where）
     */
    @Select("<script>"
            + "SELECT * FROM user"
            + "<where>"
            + "  <if test=\"username != null and username != ''\">AND username = #{username}</if>"
            + "  <if test=\"status != null\">AND status = #{status}</if>"
            + "</where>"
            + "</script>")
    List<User> selectByAnnotationScript(@Param("username") String username, @Param("status") Integer status);

    /**
     * 注解 SQL：script + foreach 集合
     */
    @Select("<script>"
            + "SELECT * FROM user WHERE id IN"
            + "<foreach collection=\"ids\" item=\"id\" open=\"(\" separator=\",\" close=\")\">"
            + "  #{id}"
            + "</foreach>"
            + "</script>")
    List<User> selectByAnnotationForeach(@Param("ids") List<Integer> ids);

    /**
     * 注解 SQL：UPDATE + script 动态 set
     */
    @Update("<script>"
            + "UPDATE user"
            + "<set>"
            + "  <if test=\"username != null\">username = #{username},</if>"
            + "  <if test=\"status != null\">status = #{status},</if>"
            + "</set>"
            + "WHERE id = #{id}"
            + "</script>")
    int updateByAnnotationScript(User user);

    /**
     * 注解 SQL：DELETE 纯文本
     */
    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteByAnnotationId(@Param("id") Integer id);

    /**
     * 注解 SQL：INSERT 纯文本
     */
    @Insert("INSERT INTO user(username, password, age, status) VALUES (#{username}, #{password}, #{age}, #{status})")
    int insertByAnnotation(User user);

    /**
     * 注解 SQL：@SelectProvider + <script>（Provider 返回动态 SQL 文本）
     */
    @SelectProvider(type = cn.song.mybatisplusdemo.common.UserSqlProvider.class, method = "selectById")
    User selectByProviderId(@Param("id") Integer id);

    /**
     * 注解 SQL：@SelectProvider 条件拼接
     */
    @SelectProvider(type = cn.song.mybatisplusdemo.common.UserSqlProvider.class, method = "selectByCondition")
    List<User> selectByProviderCondition(@Param("username") String username, @Param("status") Integer status);

    /**
     * 注解 SQL：@InsertProvider
     */
    @InsertProvider(type = cn.song.mybatisplusdemo.common.UserSqlProvider.class, method = "insert")
    int insertByProvider(User user);

    /**
     * 注解 SQL：@UpdateProvider
     */
    @UpdateProvider(type = cn.song.mybatisplusdemo.common.UserSqlProvider.class, method = "updateStatus")
    int updateStatusByProvider(@Param("id") Integer id, @Param("status") Integer status);

    /**
     * 注解 SQL：@DeleteProvider
     */
    @DeleteProvider(type = cn.song.mybatisplusdemo.common.UserSqlProvider.class, method = "deleteByRoleIds")
    int deleteByProviderRoleIds(@Param("roleIds") List<Integer> roleIds);

    /**
     * XML 动态 SQL：where + if 组合查询（对应 UserMapper.xml selectUserListByXml）
     */
    List<User> selectUserListByXml(@Param("username") String username,
                                   @Param("status") Integer status,
                                   @Param("age") Integer age);

    /**
     * XML 动态 SQL：foreach 批量 IN 查询
     */
    List<User> selectUserBatchByIds(@Param("ids") List<Integer> ids);

    /**
     * XML 动态 SQL：set + if 动态更新
     */
    int updateUserByXml(User user);

    /**
     * XML 动态 SQL：trim 自定义前缀后缀
     */
    List<User> selectUserByTrim(@Param("username") String username,
                                @Param("roleId") Integer roleId,
                                @Param("deptId") Integer deptId);

    /**
     * XML 动态 SQL：choose/when/otherwise 分支
     */
    List<User> selectUserByChoose(@Param("username") String username,
                                  @Param("email") String email);

    /**
     * XML 动态 SQL：bind 变量 + 模糊查询
     */
    List<User> selectUserByBind(@Param("keyword") String keyword);

    /**
     * XML resultMap 一对多：用户 + 部门 + 订单列表（association + collection）
     */
    List<User> selectUserWithOrdersXml(@Param("status") Integer status);

    /**
     * XML 自定义分页查询（IPage 参数自动分页，无需手写 LIMIT）
     */
    com.baomidou.mybatisplus.core.metadata.IPage<User> selectUserPageXml(
            com.baomidou.mybatisplus.core.metadata.IPage<User> page,
            @Param("status") Integer status,
            @Param("keyword") String keyword);

    /**
     * XML 多参数查询（@Param 多个 + if）
     */
    List<User> selectByMultiParamXml(@Param("username") String username,
                                     @Param("status") Integer status,
                                     @Param("minAge") Integer minAge);

    /**
     * XML Map 参数查询（Map 作为唯一参数）
     */
    List<User> selectByMapParamXml(@Param("params") java.util.Map<String, Object> params);

    /**
     * 注解 SQL 分页（R12 分页模拟语料）：@Select 路径 + IPage 形参——
     * 预览应尾追 LIMIT 并并列产出 COUNT 包裹语句
     */
    @Select("SELECT id, username, age, status FROM user WHERE deleted = 0 AND status = #{status} ORDER BY id")
    com.baomidou.mybatisplus.core.metadata.IPage<User> selectUserPageAnnotation(
            com.baomidou.mybatisplus.core.metadata.IPage<User> page,
            @Param("status") Integer status);

    /**
     * XML 手写 LIMIT 分页（R12「手写 LIMIT 不重复追加」语料）：语句尾部已带 LIMIT，
     * IPage 形参在首位——预览应只产 COUNT，不再追加第二条 LIMIT
     */
    com.baomidou.mybatisplus.core.metadata.IPage<User> selectUserPageLimitXml(
            com.baomidou.mybatisplus.core.metadata.IPage<User> page,
            @Param("status") Integer status,
            @Param("offset") long offset,
            @Param("pageSize") int pageSize);

    /**
     * XML 时间范围查询（R3 日期族参数 ANSI 字面量还原语料）：
     * java.util.Date / Timestamp / java.sql.Date 混型参数，MyBatis 日志带类型标注
     */
    List<User> selectByTimeRangeXml(@Param("startTime") java.util.Date startTime,
                                    @Param("endTime") java.sql.Timestamp endTime,
                                    @Param("lastModified") java.sql.Date lastModified);

    /**
     * 自定义注入器批量插入（MybatisPlusConfig#defaultSqlInjector 追加 InsertBatchSomeColumn）
     */
    int insertBatchSomeColumn(@Param("list") List<User> list);
}
