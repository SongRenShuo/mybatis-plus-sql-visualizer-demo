package cn.song.custcenter.service;

import cn.song.custcenter.entity.OperLog;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 操作日志 服务契约（MyBatis-Plus Wrapper / Page 形态）。
 */
public interface OperLogService {

    List<OperLog> listByTenant(Long tenantId);

    IPage<OperLog> pageByCondition(Page<OperLog> page, Long tenantId, String keyword);

    int updateStatus(Long id, String status);

    long countByKeyword(Long tenantId, String keyword);

    OperLog getOneByCode(Long tenantId, String code);

}
