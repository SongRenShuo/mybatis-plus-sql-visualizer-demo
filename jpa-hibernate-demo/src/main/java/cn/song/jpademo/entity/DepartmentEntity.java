package cn.song.jpademo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 部门表(Department)实体
 *
 * @author SongRenShuo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "department")
public class DepartmentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 部门名称
     */
    @Column(name = "name", length = 64)
    private String name;

    /**
     * 部门编码
     */
    @Column(name = "code", length = 32)
    private String code;

    /**
     * 上级部门ID
     */
    @Column(name = "parent_id")
    private Long parentId;
}
