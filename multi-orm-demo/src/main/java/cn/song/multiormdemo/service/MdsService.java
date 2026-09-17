package cn.song.multiormdemo.service;

import java.util.List;
import java.util.Map;

/**
 * MyBatis Dynamic SQL 查询服务（SelectDSL/UpdateDSL/DeleteDSL 语料）
 *
 * @author SongRenShuo
 */
public interface MdsService {

    /**
     * SelectDSL：条件查询（渲染 Spring 命名参数后经 JdbcTemplate 执行）
     */
    List<Map<String, Object>> queryByStatus(Integer status, Integer minAge);

    /**
     * UpdateDSL：条件更新
     */
    int disableById(Long id);

    /**
     * DeleteDSL：条件删除
     */
    int deleteDisabled();
}
