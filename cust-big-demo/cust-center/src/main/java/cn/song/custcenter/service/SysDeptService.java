package cn.song.custcenter.service;

import cn.song.custcenter.entity.SysDept;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 部门 服务契约（MyBatis-Plus Wrapper / Page 形态）。
 */
public interface SysDeptService {

    List<SysDept> listByTenant(Long tenantId);

    IPage<SysDept> pageByCondition(Page<SysDept> page, Long tenantId, String keyword);

    int updateStatus(Long id, String status);

    long countByKeyword(Long tenantId, String keyword);

    SysDept getOneByCode(Long tenantId, String code);

}
