package cn.song.mpjdemo.mapper;

import cn.song.mpjdemo.entity.UserDO;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * 用户表(User)MPJ 数据库访问层
 *
 * @author SongRenShuo
 */
public interface UserMapper extends MPJBaseMapper<UserDO> {

    /**
     * 模拟慢查询（演示素材）：SLEEP(1.2) 让语句稳定耗时 1.2s 左右，超过默认慢查询阈值 1000ms。
     */
    @Select("SELECT SLEEP(1.2)")
    Integer simulateSlowQuery();
}

