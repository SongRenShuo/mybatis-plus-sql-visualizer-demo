package cn.song.custcenter.service;

import cn.song.custcenter.entity.SysDict;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 字典 服务契约（MyBatis-Plus Wrapper / Page 形态）。
 */
public interface SysDictService {

    List<SysDict> listByTenant(Long tenantId);

    IPage<SysDict> pageByCondition(Page<SysDict> page, Long tenantId, String keyword);

    int updateStatus(Long id, String status);

    long countByKeyword(Long tenantId, String keyword);

    SysDict getOneByCode(Long tenantId, String code);

}
