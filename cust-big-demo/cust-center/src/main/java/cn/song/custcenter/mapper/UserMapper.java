package cn.song.custcenter.mapper;

import cn.song.custcenter.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 用户 Mapper（MyBatis-Plus BaseMapper + 少量自定义 SQL）。
 */
public interface UserMapper extends BaseMapper<User> {

    /** 查询启用中的用户（自定义 SQL） */
    List<User> selectActiveUsers();

}
