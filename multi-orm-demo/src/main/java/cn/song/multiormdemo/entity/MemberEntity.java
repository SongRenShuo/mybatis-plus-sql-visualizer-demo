package cn.song.multiormdemo.entity;

import cn.song.multiormdemo.entity.proxy.MemberEntityProxy;
import com.easy.query.core.proxy.ProxyEntityAvailable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 成员实体（orm_member 表）
 * 同一实体三用：JPA/Hibernate（@Entity）、Querydsl（APT 生成 QMemberEntity）、
 * Easy-Query（@EntityProxy 触发 APT 生成 entity.proxy.MemberEntityProxy，
 * implements ProxyEntityAvailable 满足 queryable 的泛型约束）
 *
 * 注意：本类不使用 Lombok——sql-processor 与 Lombok 同轮注解处理时会因 getter
 * 尚未生成而静默跳过 proxy 生成，故显式书写 getter/setter。
 *
 * @author SongRenShuo
 */
@Entity
@Table(name = "orm_member")
@com.easy.query.core.annotation.Table("orm_member")
@com.easy.query.core.annotation.EntityProxy
public class MemberEntity implements Serializable,
        ProxyEntityAvailable<MemberEntity, MemberEntityProxy> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键（easy-query 元数据须 @Column(primaryKey=true)，否则实体更新找不到主键）
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @com.easy.query.core.annotation.Column(value = "id", primaryKey = true, generatedKey = true)
    private Long id;

    /**
     * 成员名
     */
    @Column(name = "name")
    @com.easy.query.core.annotation.Column("name")
    private String name;

    /**
     * 年龄
     */
    @Column(name = "age")
    @com.easy.query.core.annotation.Column("age")
    private Integer age;

    /**
     * 城市
     */
    @Column(name = "city")
    @com.easy.query.core.annotation.Column("city")
    private String city;

    /**
     * 状态（0禁用 1启用）
     */
    @Column(name = "status")
    @com.easy.query.core.annotation.Column("status")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
