package cn.song.custcenter.service;

import cn.song.custcenter.entity.SysNotice;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 通知公告 服务契约（MyBatis-Plus Wrapper / Page 形态）。
 */
public interface SysNoticeService {

    List<SysNotice> listByTenant(Long tenantId);

    IPage<SysNotice> pageByCondition(Page<SysNotice> page, Long tenantId, String keyword);

    int updateStatus(Long id, String status);

    long countByKeyword(Long tenantId, String keyword);

    SysNotice getOneByCode(Long tenantId, String code);

}
