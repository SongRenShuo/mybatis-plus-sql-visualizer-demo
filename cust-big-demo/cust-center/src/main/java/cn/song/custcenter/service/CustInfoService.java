package cn.song.custcenter.service;

import cn.song.custcenter.entity.CustInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 客户信息 服务契约（MyBatis-Plus Wrapper / Page 形态）。
 */
public interface CustInfoService {

    List<CustInfo> listByTenant(Long tenantId);

    IPage<CustInfo> pageByCondition(Page<CustInfo> page, Long tenantId, String keyword);

    int updateStatus(Long id, String status);

    long countByKeyword(Long tenantId, String keyword);

    CustInfo getOneByCode(Long tenantId, String code);

}
