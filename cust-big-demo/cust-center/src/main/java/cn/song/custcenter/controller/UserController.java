package cn.song.custcenter.controller;

import cn.song.custcommon.api.ApiResult;
import cn.song.custcenter.entity.User;
import cn.song.custcenter.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 用户 接口层（MyBatis-Plus 服务）。
 */
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public ApiResult<List<User>> list(Long tenantId) {
        return ApiResult.ok(userService.listByTenant(tenantId));
    }

    public ApiResult<IPage<User>> page(long pageNo, long pageSize, Long tenantId, String keyword) {
        Page<User> page = new Page<User>(pageNo, pageSize);
        return ApiResult.ok(userService.pageByCondition(page, tenantId, keyword));
    }

    public ApiResult<Integer> updateStatus(Long id, String status) {
        return ApiResult.ok(Integer.valueOf(userService.updateStatus(id, status)));
    }
}
