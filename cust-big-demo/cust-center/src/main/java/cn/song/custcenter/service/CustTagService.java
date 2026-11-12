package cn.song.custcenter.service;

import cn.song.custcenter.entity.CustTag;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 客户标签 服务契约（MyBatis-Plus Wrapper / Page 形态）。
 */
public interface CustTagService {

    List<CustTag> listByTenant(Long tenantId);

    IPage<CustTag> pageByCondition(Page<CustTag> page, Long tenantId, String keyword);

    int updateStatus(Long id, String status);

    long countByKeyword(Long tenantId, String keyword);

    CustTag getOneByCode(Long tenantId, String code);

}
