package com.example.shadow.dao;

import com.example.shadow.model.WmsTask;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>JAR 内的 DAO 类</b>——本复现用例的缺陷触发点之一。
 *
 * <p>关键点：方法体内含一句 HQL 字面量，且紧跟一次以 {@code Dao} 结尾的 qualifier 调用
 * （{@code this.commonDao.findByQuery(hql, ...)}）。插件预览链的解析上下文取的是
 * <b>HQL 所在方法</b>（{@code info.method ?: anchor}），而这个方法在 JAR 里 ⇒
 * 平台 {@code getModuleForFile} 返回 null ⇒ 搜索作用域退到全工程 ⇒
 * 同 FQN 双份（JAR 版 + 宿主影子版）不被消解 ⇒ 实体不可解析、降级为 {@code task.*}。
 *
 * <p>本类同时满足任务书对 JAR 侧 DAO 的要求：方法签名形态与报障一致
 * （{@link CommonDao#findByQuery(String, String[], Object[])} 就是那双数组签名）。
 *
 * @author SongRenShuo
 */
@Repository
public class WmsTaskJarDao {

    private final CommonDao commonDao;

    public WmsTaskJarDao(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    /**
     * 按「状态 + 类型」查任务——HQL 字面量写在 <b>JAR 里的这个方法体内</b>（复现关键之一）。
     */
    public List<WmsTask> findByStatusAndType(String status, String type) {
        String hql = "FROM WmsTask task WHERE task.status = :status AND task.type = :type";
        return commonDao.findByQuery(hql, new String[]{"status", "type"}, new Object[]{status, type});
    }
}
