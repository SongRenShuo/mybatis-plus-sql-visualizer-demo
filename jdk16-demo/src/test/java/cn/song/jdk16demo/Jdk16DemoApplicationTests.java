package cn.song.jdk16demo;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.song.jdk16demo.entity.User;
import cn.song.jdk16demo.mapper.UserMapper;
import cn.song.jdk16demo.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * 全链路回归（HTTP 面）：内嵌 Tomcat 7 随机端口 → Controller → Service 接口/实现 →
 * Mapper（XML 动态 SQL + 注解 SQL）→ MySQL 8。
 * surefire 经 toolchain 把本测试拉在真 JDK 6 的 JVM 里跑（见模块 README）。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Jdk16DemoApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    /** 种子数据：schema.sql 随启动重建，张三(0)/李四(1) 两个 status 各一条必然在库 */
    @Test
    public void listSeedsAndCountByStatus() {
        List<?> users = restTemplate.getForObject("/users", List.class);
        assertNotNull(users);
        assertTrue("种子数据应至少两条（张三/李四）", users.size() >= 2);

        int zeroCount = restTemplate.getForObject("/users/count?status=0", Integer.class).intValue();
        int oneCount = restTemplate.getForObject("/users/count?status=1", Integer.class).intValue();
        assertTrue("status=0 计数（注解 SQL）至少 1", zeroCount >= 1);
        assertTrue("status=1 计数（注解 SQL）至少 1", oneCount >= 1);
    }

    /** CRUD 回环：新增 → 查 → 改 → 动态搜索（含 IN）→ 删 → Mapper 确认删净 */
    @Test
    public void crudRoundTrip() {
        User created = new User();
        created.setName("王五");
        created.setEmail("wangwu@example.com");
        created.setAge(Integer.valueOf(31));
        User saved = restTemplate.postForObject("/users", created, User.class);
        assertNotNull("新增应返回带回填主键的实体", saved);
        assertNotNull(saved.getId());

        User fetched = restTemplate.getForObject("/users/" + saved.getId(), User.class);
        assertNotNull(fetched);
        assertEquals("王五", fetched.getName());
        assertEquals(Integer.valueOf(31), fetched.getAge());
        assertEquals("create 里默认置 0", Integer.valueOf(0), fetched.getStatus());
        assertNotNull("create 里补创建时间", fetched.getCreatedTime());

        fetched.setAge(Integer.valueOf(32));
        fetched.setStatus(Integer.valueOf(1));
        ResponseEntity<User> putResp = restTemplate.exchange("/users/" + saved.getId(), HttpMethod.PUT,
                new HttpEntity<User>(fetched), User.class);
        assertEquals("按 id 更新非空字段后应回读最新值", Integer.valueOf(32), putResp.getBody().getAge());
        assertEquals(Integer.valueOf(1), putResp.getBody().getStatus());

        // 关键字搜索走 ASCII 邮箱关键词（中文形态由 POST 中文体与服务面「李」搜索覆盖）。
        // 注：URL 里预编码的 %E7.. 会被 RestTemplate 的 URI 模板展开二次编码成 %25E7..，
        // 服务端拿到的是字面 "%E7%8E%8B"，实测 JDK8/JDK6 都命不中——中文查询参数走直连库用例。
        List<?> hits = restTemplate.getForObject("/users/search?keyword=wangwu", List.class);
        assertTrue("关键字搜索（邮箱 LIKE）应命中新建的「王五」", containsId(hits, saved.getId()));

        // 叠加 IN 集合：按本条 id 收范围，结果应是且仅是这一行
        List<?> scoped = restTemplate.getForObject("/users/search?keyword=wangwu&ids=" + saved.getId(), List.class);
        assertEquals("IN 收范围后应恰好命中一行", 1, scoped.size());

        ResponseEntity<Map> delResp = restTemplate.exchange("/users/" + saved.getId(), HttpMethod.DELETE,
                null, Map.class);
        assertEquals("删除应影响一行", 1, ((Number) delResp.getBody().get("deleted")).intValue());

        assertNull("HTTP 链路删完后 Mapper 直查应查无此行", userMapper.selectById(saved.getId()));
    }

    private static boolean containsId(List<?> rows, Long expectedId) {
        boolean found = false;
        for (Object row : rows) {
            Map<?, ?> rowMap = (Map<?, ?>) row;
            Object idValue = rowMap.get("id");
            if (idValue instanceof Number && ((Number) idValue).longValue() == expectedId.longValue()) {
                found = true;
            }
        }
        return found;
    }
}
