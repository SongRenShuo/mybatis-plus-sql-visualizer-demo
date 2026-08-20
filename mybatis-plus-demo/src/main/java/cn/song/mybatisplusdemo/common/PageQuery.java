package cn.song.mybatisplusdemo.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 通用分页查询参数
 *
 * @author SongRenShuo
 */
@Data
public class PageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页码
     */
    private long current = 1;

    /**
     * 每页条数
     */
    private long size = 10;

    /**
     * 关键字（模糊搜索）
     */
    private String keyword;

    /**
     * ID 集合（IN 查询）
     */
    private List<Integer> ids;
}
