package cn.song.custcenter.service;

import cn.song.custcenter.entity.LoginLog;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 登录日志 服务契约（MyBatis-Plus Wrapper / Page 形态）。
 */
public interface LoginLogService {

    List<LoginLog> listByTenant(Long tenantId);

    IPage<LoginLog> pageByCondition(Page<LoginLog> page, Long tenantId, String keyword);

    int updateStatus(Long id, String status);

    long countByKeyword(Long tenantId, String keyword);

    LoginLog getOneByCode(Long tenantId, String code);

}
