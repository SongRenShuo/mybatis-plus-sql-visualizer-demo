package cn.song.custcenter.service;

import cn.song.custcenter.entity.SysConfig;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 参数配置 服务契约（MyBatis-Plus Wrapper / Page 形态）。
 */
public interface SysConfigService {

    List<SysConfig> listByTenant(Long tenantId);

    IPage<SysConfig> pageByCondition(Page<SysConfig> page, Long tenantId, String keyword);

    int updateStatus(Long id, String status);

    long countByKeyword(Long tenantId, String keyword);

    SysConfig getOneByCode(Long tenantId, String code);

}
