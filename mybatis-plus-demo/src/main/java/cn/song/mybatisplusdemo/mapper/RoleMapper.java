package cn.song.mybatisplusdemo.mapper;

import cn.song.mybatisplusdemo.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色表(Role)数据库访问层
 *
 * @author SongRenShuo
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * XML 动态 SQL：sql 片段 + include 复用
     */
    List<Role> selectByIncludeFragment(@Param("keyword") String keyword);

    /**
     * XML 动态 SQL：foreach 批量插入
     */
    int insertBatch(@Param("roles") List<Role> roles);
}
