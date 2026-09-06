package cn.song.jpademo.controller;

import cn.song.jpademo.entity.UserEntity;
import cn.song.jpademo.service.UserWriteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户写路径演示（JPA CRUD / EntityManager 写 API / CriteriaUpdate·Delete / Specification / QBE / 锁读）
 * 仅提供 GET 端点便于浏览器触发预览，不做真实写保护
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/jpa/user-write")
public class UserWriteController {

    @Resource
    private UserWriteService userWriteService;

    /**
     * 单实体保存（T-J1：save → INSERT 模板）
     */
    @GetMapping("/save")
    public UserEntity save(String username, String email, Integer age) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setEmail(email);
        user.setAge(age);
        return userWriteService.save(user);
    }

    /**
     * 批量保存（T-J1：saveAll → 逐条 INSERT）
     */
    @GetMapping("/saveAll")
    public List<UserEntity> saveAll(String username, Integer age) {
        List<UserEntity> users = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            UserEntity user = new UserEntity();
            user.setUsername(username + i);
            user.setAge(age);
            users.add(user);
        }
        return userWriteService.saveAll(users);
    }

    /**
     * 主键查询（T-J1：findById → SELECT WHERE id = ?）
     */
    @GetMapping("/findById")
    public UserEntity findById(Long id) {
        return userWriteService.findById(id);
    }

    /**
     * 主键存在性判断（T-J1：existsById）
     */
    @GetMapping("/exists")
    public boolean exists(Long id) {
        return userWriteService.existsById(id);
    }

    /**
     * 总数统计（T-J1：count）
     */
    @GetMapping("/count")
    public long count() {
        return userWriteService.count();
    }

    /**
     * 主键删除（T-J1：deleteById → DELETE WHERE id = ?）
     */
    @GetMapping("/deleteById")
    public String deleteById(Long id) {
        userWriteService.deleteById(id);
        return "deleted: " + id;
    }

    /**
     * 实体删除（T-J1：delete(entity)）
     */
    @GetMapping("/delete")
    public String delete(Long id) {
        UserEntity user = userWriteService.findEntity(id);
        userWriteService.delete(user);
        return "deleted entity: " + id;
    }

    /**
     * 全表批量删除（T-J1：deleteAllInBatch → DELETE FROM 无 WHERE）
     */
    @GetMapping("/deleteAllInBatch")
    public String deleteAllInBatch() {
        userWriteService.deleteAllInBatch();
        return "deleted all";
    }

    /**
     * 按创建时间倒序全量查询（T-J1：无 By/Order 混合形态）
     */
    @GetMapping("/findAllByCreateTimeDesc")
    public List<UserEntity> findAllByCreateTimeDesc() {
        return userWriteService.findAllByCreateTimeDesc();
    }

    /**
     * JPQL 批量更新状态（T-J2：@Modifying UPDATE JPQL）
     */
    @GetMapping("/updateStatusByJpql")
    public int updateStatusByJpql(Integer oldStatus, Integer newStatus) {
        return userWriteService.updateStatusByJpql(oldStatus, newStatus);
    }

    /**
     * em.persist 新增（T-J6）
     */
    @GetMapping("/persist")
    public UserEntity persist(String username, String email) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setEmail(email);
        return userWriteService.persistEntity(user);
    }

    /**
     * em.merge 合并（T-J6）
     */
    @GetMapping("/merge")
    public UserEntity merge(Long id, String email) {
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setEmail(email);
        return userWriteService.mergeEntity(user);
    }

    /**
     * em.remove 删除（T-J6）
     */
    @GetMapping("/remove")
    public String remove(Long id) {
        UserEntity user = userWriteService.findEntity(id);
        userWriteService.removeEntity(user);
        return "removed: " + id;
    }

    /**
     * em.find 主键查询（T-J6）
     */
    @GetMapping("/find")
    public UserEntity find(Long id) {
        return userWriteService.findEntity(id);
    }

    /**
     * CriteriaUpdate 单列更新（T-J6）
     */
    @GetMapping("/criteriaUpdate")
    public int criteriaUpdate(Long id, Integer newStatus) {
        return userWriteService.criteriaUpdateStatus(id, newStatus);
    }

    /**
     * CriteriaDelete 条件删除（T-J6）
     */
    @GetMapping("/criteriaDelete")
    public int criteriaDelete(Integer status) {
        return userWriteService.criteriaDeleteByStatus(status);
    }

    /**
     * Specification 动态查询（T-J5/T-J20）
     */
    @GetMapping("/specification")
    public List<UserEntity> specification(String username, Integer minAge, Integer status, Boolean emailNull) {
        return userWriteService.specificationQuery(username, minAge, status, emailNull);
    }

    /**
     * Query By Example 探针查询（T-J20：Example.of）
     */
    @GetMapping("/example")
    public UserEntity example(String username) {
        UserEntity probe = new UserEntity();
        probe.setUsername(username);
        return userWriteService.exampleQuery(probe);
    }

    /**
     * 锁读（T-J6 写路径族：PESSIMISTIC_WRITE find 重载）
     */
    @GetMapping("/findWithLock")
    public UserEntity findWithLock(Long id) {
        return userWriteService.findWithLock(id);
    }
}
