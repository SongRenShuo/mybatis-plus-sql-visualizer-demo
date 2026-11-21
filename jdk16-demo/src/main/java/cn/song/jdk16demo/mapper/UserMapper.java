package cn.song.jdk16demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.song.jdk16demo.entity.User;

/**
 * 用户 Mapper：XML 动态 SQL 为主 + 一条注解 SQL（两种 SQL 承载形态并存）。
 * 语句实现见 resources/mapper/UserMapper.xml。
 */
public interface UserMapper {

    /** 新增（useGeneratedKeys 回填自增 id） */
    int insert(User user);

    /** 按 id 查（resultMap 列映射） */
    User selectById(@Param("id") Long id);

    /** 条件列表：XML &lt;where&gt;/&lt;if&gt; 动态拼接 */
    List<User> selectList(User query);

    /** 按 id 改：XML &lt;set&gt;/&lt;if&gt; 只更新非空字段 */
    int updateById(User user);

    /** 按 id 删 */
    int deleteById(@Param("id") Long id);

    /** 注解 SQL：按状态计数（参数面板回填 #{status}） */
    @Select("SELECT COUNT(*) FROM `user` WHERE status = #{status}")
    int countByStatus(@Param("status") Integer status);

    /** 关键字/IN 组合搜索：XML &lt;choose&gt; 分支 + &lt;foreach&gt; 展开 */
    List<User> searchByKeyword(@Param("keyword") String keyword, @Param("ids") List<Long> ids);
}
