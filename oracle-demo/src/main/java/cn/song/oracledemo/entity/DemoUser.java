package cn.song.oracledemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/** 复现用实体：Oracle 未加引号的标识符按大写存储，这里显式写死列名，避免大小写折叠歧义。 */
@TableName("DEMO_USER")
public class DemoUser {

    @TableId(value = "ID", type = IdType.INPUT)
    private Long id;

    @TableField("NAME")
    private String name;

    @TableField("AGE")
    private Integer age;

    public DemoUser() {
    }

    public DemoUser(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "DemoUser{id=" + id + ", name='" + name + "', age=" + age + '}';
    }
}
