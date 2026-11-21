package cn.song.jdk16demo.service;

import java.util.List;

import cn.song.jdk16demo.entity.User;

/**
 * 用户业务接口（老时代分层形态：接口 + impl 实现类）。
 */
public interface UserService {

    /** 新增：默认置状态 0、补创建时间，返回带回填主键的实体 */
    User create(User user);

    /** 按 id 查，不存在返回 null */
    User getById(Long id);

    /** 条件列表（属性直绑 User 查询对象） */
    List<User> list(User query);

    /** 按 id 更新非空字段，不存在返回 null */
    User update(User user);

    /** 按 id 删，返回影响行数 */
    int deleteById(Long id);

    /** 关键字（姓名/邮箱 LIKE）与可选 id 集合的组合搜索 */
    List<User> search(String keyword, List<Long> ids);

    /** 按状态计数 */
    int countByStatus(Integer status);
}
