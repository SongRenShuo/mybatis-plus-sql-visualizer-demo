package cn.song.mybatisplusdemo.common;

import cn.song.mybatisplusdemo.entity.User;

import java.util.List;

/**
 * 负例边界：非 Spring Data Repository 接口的 findByXxx 方法
 * （未继承 Repository/JpaRepository 基类，插件 DerivedMethodLocator 不应产出派生查询 gutter）
 *
 * @author SongRenShuo
 */
public interface FakeUserRepository {

    List<User> findByUsername(String username);

    List<User> findByStatusAndAgeGreaterThan(Integer status, Integer age);
}
