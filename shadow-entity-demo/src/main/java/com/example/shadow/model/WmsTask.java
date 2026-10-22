package com.example.shadow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <b>宿主影子版</b> {@code WmsTask}——与依赖 JAR 里的 {@code com.example.shadow.model.WmsTask}
 * <b>同包同名</b>（同 FQN），是运行期实际生效的那一份。
 *
 * <p>与 JAR 版的差异（走查时一眼可判）：
 * <table border="1">
 *   <caption>两版对照</caption>
 *   <tr><th></th><th>JAR 版（shadow-entity-lib）</th><th>宿主影子版（本类）</th></tr>
 *   <tr><td>表名</td><td>{@code wms_task_jar}</td><td>{@code wms_task_project}</td></tr>
 *   <tr><td>列清单</td><td>{@code id / task_no / status / type}</td>
 *       <td>{@code id / task_no / status / task_type / remark}</td></tr>
 *   <tr><td>{@code type} 的物理列</td><td>{@code type}</td><td>{@code task_type}</td></tr>
 *   <tr><td>额外列</td><td>—</td><td>{@code remark}</td></tr>
 * </table>
 *
 * <p>字段名与 JAR 版保持一致的只有 HQL 引用到的 {@code status} / {@code type} / {@code taskNo}——
 * 这样「插件解析到哪一版」的差异**只会**体现在表名与列清单上，不会被「字段名对不上」这第二种
 * 降级原因污染。
 *
 * @author SongRenShuo
 */
@Entity
@Table(name = "wms_task_project")
public class WmsTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "task_no")
    private String taskNo;

    @Column(name = "status")
    private String status;

    /** 与 JAR 版同名字段，但物理列改名为 {@code task_type}（这是两版列清单差异之一）。 */
    @Column(name = "task_type")
    private String type;

    /** 影子版独有的列（JAR 版没有）。 */
    @Column(name = "remark")
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
