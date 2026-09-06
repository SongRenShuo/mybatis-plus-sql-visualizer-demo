package cn.song.mybatisplusdemo.mapper;

import cn.song.mybatisplusdemo.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 部门表(Department)数据库访问层
 *
 * @author SongRenShuo
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * XML 动态 SQL：choose/when/otherwise 分支查询
     */
    List<Department> selectByChoose(@Param("code") String code,
                                    @Param("name") String name,
                                    @Param("parentId") Integer parentId);

    /**
     * XML 动态 SQL：set + if 动态更新
     */
    int updateByDynamicSet(@Param("id") Integer id,
                           @Param("name") String name,
                           @Param("sort") Integer sort);

    /**
     * XML 动态 SQL：子查询 + 嵌套 foreach
     */
    List<Map<String, Object>> statDeptUserCount(@Param("deptIds") List<Integer> deptIds);
}
