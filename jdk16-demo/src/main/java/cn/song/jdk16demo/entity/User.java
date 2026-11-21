package cn.song.jdk16demo.entity;

import java.util.Date;

/**
 * 用户实体（JDK 1.6 语料形态：显式 getter/setter，无 Lombok、无 lambda、无 try-with-resources）。
 * 对应表 user，建表脚本 db/schema.sql 随实体列同步维护。
 */
public class User {

    /** 主键（自增，insert 后由 useGeneratedKeys 回填） */
    private Long id;

    /** 姓名 */
    private String name;

    /** 邮箱 */
    private String email;

    /** 年龄 */
    private Integer age;

    /** 状态：0-正常 1-停用 */
    private Integer status;

    /** 创建时间 */
    private Date createdTime;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
