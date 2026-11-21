package cn.song.jdk16demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.song.jdk16demo.entity.User;
import cn.song.jdk16demo.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * 服务面回归（非 HTTP）：@SpringBootTest webEnvironment=NONE，
 * 直接验证「接口 → 实现类 → Mapper → MySQL」链路与 @Transactional 代理在真 JDK 6 下可用。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void interfaceImplAndDaoRoundTrip() {
        User user = new User();
        user.setName("赵六");
        user.setEmail("zhaoliu@example.com");
        user.setAge(Integer.valueOf(45));
        User saved = userService.create(user);
        assertNotNull("接口→实现→自增主键回填（useGeneratedKeys）应生效", saved.getId());
        assertNotNull("create 里补创建时间", saved.getCreatedTime());

        User fetched = userService.getById(saved.getId());
        assertNotNull(fetched);
        assertEquals("赵六", fetched.getName());
        assertEquals(Integer.valueOf(0), fetched.getStatus());

        // 动态 WHERE：LIKE「李」应命中种子李四（直连库参数化查询，无 URI 编码环节）
        List<User> hits = userService.search("李", null);
        assertTrue("关键字搜索应命中种子李四", hits.size() >= 1);

        // 注解 SQL 计数
        assertTrue("status=1 计数（注解 SQL）至少 1", userService.countByStatus(Integer.valueOf(1)) >= 1);

        assertTrue("按 id 删除应返回 1", userService.deleteById(saved.getId()) == 1);
        assertNull("删除后按 id 查询应为 null", userService.getById(saved.getId()));
    }
}
