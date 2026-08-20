package cn.song.mpjdemo.service;

import cn.song.mpjdemo.dto.UserDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * 用户联查服务层（MPJ 用例）
 *
 * @author SongRenShuo
 */
public interface UserService {

    /**
     * 三表联查：selectAll + select + selectAs + leftJoin + rightJoin + innerJoin
     */
    List<UserDTO> selectJoinList();

    /**
     * join 多条件 on + ext 扩展条件
     */
    List<UserDTO> selectJoinWithOnCondition();

    /**
     * selectCollection 一对多映射（user → 多个地址）
     */
    List<UserDTO> selectJoinCollection();

    /**
     * 子查询 join（MConsumer 形态）
     */
    List<UserDTO> selectJoinSubQuery();

    /**
     * from 子查询主表
     */
    List<UserDTO> selectJoinFrom();

    /**
     * around + setTableName + pageByMain 综合
     */
    IPage<UserDTO> selectJoinPage(Page<UserDTO> page);

    /**
     * selectFunc 聚合 + groupBy + having
     */
    List<Map<String, Object>> selectJoinFunc();

    /**
     * updateJoin 联表更新
     */
    int updateJoin();

    /**
     * deleteJoin 联表删除
     */
    int deleteJoin();

    /**
     * fill 填充用例（MPJ 1.5.1+）
     */
    List<UserDTO> selectFill();
}
