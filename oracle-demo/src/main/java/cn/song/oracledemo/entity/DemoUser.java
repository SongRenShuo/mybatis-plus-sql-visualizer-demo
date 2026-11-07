package cn.song.oracledemo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

/** 复现用实体：Oracle 未加引号的标识符按大写存储，这里显式写死列名，避免大小写折叠歧义。 */
@TableName("DEMO_USER")
public class DemoUser {

    @TableId(value = "ID", type = IdType.INPUT)
    private Long id;

    @TableField("NAME")
    private String name;

    @TableField("AGE")
    private Integer age;

    /**
     * 创建时间（插入时由 DemoMetaObjectHandler 自动填充）
     */
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间（插入/更新时由 DemoMetaObjectHandler 自动填充）
     */
    @TableField(value = "UPDATE_TIME", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "DemoUser{id=" + id + ", name='" + name + "', age=" + age
                + ", createTime=" + createTime + ", updateTime=" + updateTime + '}';
    }
}
