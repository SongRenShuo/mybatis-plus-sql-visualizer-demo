package cn.song.custcenter.service;

import cn.song.custcenter.entity.SysMenu;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 菜单 服务契约（MyBatis-Plus Wrapper / Page 形态）。
 */
public interface SysMenuService {

    List<SysMenu> listByTenant(Long tenantId);

    IPage<SysMenu> pageByCondition(Page<SysMenu> page, Long tenantId, String keyword);

    int updateStatus(Long id, String status);

    long countByKeyword(Long tenantId, String keyword);

    SysMenu getOneByCode(Long tenantId, String code);

}
