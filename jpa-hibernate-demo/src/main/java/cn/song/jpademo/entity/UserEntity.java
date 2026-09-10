package cn.song.jpademo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户表(User)实体（JPA 注解映射）
 * 对齐插件 JPA 测试实体字段：username/email/firstName/lastName/age/status/departmentId/createTime
 *
 * @author SongRenShuo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "UserEntity.findByUsernameNamed",
                query = "SELECT u FROM UserEntity u WHERE u.username = :username"),
        @NamedQuery(name = "UserEntity.findActiveByAgeNamed",
                query = "SELECT u FROM UserEntity u WHERE u.status = 1 AND u.age >= :minAge ORDER BY u.age DESC")
})
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "username", length = 64)
    private String username;

    /**
     * 邮箱
     */
    @Column(name = "email", length = 128)
    private String email;

    /**
     * 姓
     */
    @Column(name = "first_name", length = 64)
    private String firstName;

    /**
     * 名
     */
    @Column(name = "last_name", length = 64)
    private String lastName;

    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;

    /**
     * 状态（0禁用 1启用）
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 部门ID
     */
    @Column(name = "department_id")
    private Long departmentId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 部门（多对一，JOIN 用例）。
     * open-in-view=false 时懒加载代理无法在 JSON 序列化阶段初始化，
     * 序列化会抛 LazyInitializationException，接口响应只输出 departmentId；
     * 关联属性本身保留，JPQL/HQL/Criteria 的 JOIN FETCH 用例不受影响。
     */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private DepartmentEntity department;

    /**
     * 非持久化字段（用于派生查询降级演示）
     */
    @Transient
    private String transientField;
}
