package com.example.shadow.service;

import com.example.shadow.dao.CommonDao;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <b>JAR 内的 service 类</b>——用户真实报障形态的复刻
 * （报障方法 {@code beAllocateSuccess}：本地变量持有 HQL + 紧跟 {@code this.commonDao.findByQuery(...)}）。
 *
 * <p>与 {@link com.example.shadow.dao.WmsTaskJarDao#findByStatusAndType} 一样，
 * 这里的方法体也落在 JAR 里，所以走同一条降级链。两个触发点形态略有差别
 * （DAO 名下的方法 vs service 名下的方法），用于确认「宿主在 JAR 内」才是必要条件，
 * 而不是某个特定类名/包名。
 *
 * @author SongRenShuo
 */
@Service
public class WmsTaskJarService {

    private final CommonDao commonDao;

    public WmsTaskJarService(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    /**
     * 按「状态集合 + 类型 + 任务号」查任务——承载形态：**本地变量持有 HQL**（报障同款）。
     */
    public List<?> beAllocateSuccess(String taskNo, String type) {
        String hql = "FROM WmsTask task WHERE task.status IN (:status) AND task.type = :type AND task.taskNo = :taskNo";
        return this.commonDao.findByQuery(
                hql,
                new String[]{"status", "type", "taskNo"},
                new Object[]{Arrays.asList("OP", "PA"), type, taskNo});
    }
}
