package cn.song.custcenter.service;

import cn.song.custcenter.entity.TenantInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 租户 服务契约（MyBatis-Plus Wrapper / Page 形态）。
 */
public interface TenantInfoService {

    List<TenantInfo> listByTenant(Long tenantId);

    IPage<TenantInfo> pageByCondition(Page<TenantInfo> page, Long tenantId, String keyword);

    int updateStatus(Long id, String status);

    long countByKeyword(Long tenantId, String keyword);

    TenantInfo getOneByCode(Long tenantId, String code);

}
