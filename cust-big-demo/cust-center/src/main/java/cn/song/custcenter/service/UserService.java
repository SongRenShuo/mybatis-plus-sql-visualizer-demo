package cn.song.custcenter.service;

import cn.song.custcenter.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 用户 服务契约（MyBatis-Plus Wrapper / Page 形态）。
 */
public interface UserService {

    List<User> listByTenant(Long tenantId);

    IPage<User> pageByCondition(Page<User> page, Long tenantId, String keyword);

    int updateStatus(Long id, String status);

    long countByKeyword(Long tenantId, String keyword);

    User getOneByCode(Long tenantId, String code);

}
