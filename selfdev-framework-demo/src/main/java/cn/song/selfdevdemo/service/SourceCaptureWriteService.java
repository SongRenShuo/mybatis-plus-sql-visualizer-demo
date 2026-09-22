package cn.song.selfdevdemo.service;

import java.util.List;

/**
 * D 组语料：**写路径**矩阵（更新 / 删除 / 循环更新）。
 *
 * <p>写路径的引擎帧与查询完全一致（{@code DmlRepository#update}），
 * 但 SQL 以 UPDATE/DELETE 形态出现——用于验证前缀登记对写语句同样生效。
 *
 * @author SongRenShuo
 */
public interface SourceCaptureWriteService {

    /** 25. 按条件更新（返回受影响行数）。 */
    int update(String planId, String projectName);

    /** 26. 按条件删除（返回受影响行数）。 */
    int delete(String planId);

    /** 27. 循环更新（同帧 key 多条 SQL）。 */
    int batchUpdate(List<String> planIds, int status);
}
