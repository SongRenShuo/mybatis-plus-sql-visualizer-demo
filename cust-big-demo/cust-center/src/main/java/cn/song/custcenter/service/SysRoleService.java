package cn.song.custcenter.service;

import cn.song.custcenter.entity.SysRole;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 角色 服务契约（MyBatis-Plus Wrapper / Page 形态）。
 */
public interface SysRoleService {

    List<SysRole> listByTenant(Long tenantId);

    IPage<SysRole> pageByCondition(Page<SysRole> page, Long tenantId, String keyword);

    int updateStatus(Long id, String status);

    long countByKeyword(Long tenantId, String keyword);

    SysRole getOneByCode(Long tenantId, String code);

}
