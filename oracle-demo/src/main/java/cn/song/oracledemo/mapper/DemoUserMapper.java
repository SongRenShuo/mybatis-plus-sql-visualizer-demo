package cn.song.oracledemo.mapper;

import cn.song.oracledemo.entity.DemoUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/** MyBatis-Plus BaseMapper：insert / selectById / selectList / updateById 全部走 PreparedStatement。 */
public interface DemoUserMapper extends BaseMapper<DemoUser> {
}
