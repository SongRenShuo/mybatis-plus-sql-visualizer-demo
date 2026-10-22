package com.example.shadow.web.service;

import com.example.shadow.dao.CommonDao;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 宿主工程里的调用方 service——<b>对照组</b>。
 *
 * <p>与 JAR 里那两个触发点（{@code WmsTaskJarDao#findByStatusAndType}、
 * {@code WmsTaskJarService#beAllocateSuccess}）的<b>唯一差别</b>是：本方法体在**工程内容**里
 * （{@code target/classes}），不在依赖 JAR 里。此时平台能拿到模块上下文，同 FQN 双份按
 * classpath 序消解，工程影子类胜出——所以本方法是**预期不会复现缺陷**的对照：
 * 预览应渲染 {@code wms_task_project} + {@code task_type}/{@code remark}。
 *
 * <p>两相对照即可确认：缺陷的必要条件是「HQL 所在方法落在 JAR 里」，而不是调用形态或类名。
 *
 * @author SongRenShuo
 */
@Service
public class ShadowTaskQueryService {

    private final CommonDao commonDao;

    public ShadowTaskQueryService(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    /**
     * 与 JAR 内 DAO 方法同形态（对照用）：HQL 在工程源码里，随后以 {@code Dao} 结尾的 qualifier 调用。
     */
    public List<?> findByStatusAndType(String status, String type) {
        String hql = "FROM WmsTask task WHERE task.status = :status AND task.type = :type";
        return commonDao.findByQuery(hql, new String[]{"status", "type"}, new Object[]{status, type});
    }
}
