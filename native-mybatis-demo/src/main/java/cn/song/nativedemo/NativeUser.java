package cn.song.nativedemo;

/**
 * 原生 MyBatis 语料实体（表 mp_demo.user 的瘦身映射）。
 */
public class NativeUser {
    private Long id;
    private String username;
    private Integer age;
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "NativeUser{id=" + id + ", username='" + username + "', age=" + age + ", status=" + status + '}';
    }
}
