package com.example.shadow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <b>JAR 版</b> {@code WmsTask}——依赖 JAR 里那份实体（宿主工程另有一份同包同名的「影子类」）。
 *
 * <p>本复现用例要证明的读数落点是「表名与列清单取自哪一版」。两版刻意不同：
 * <ul>
 *   <li>本 JAR 版：表 {@code wms_task_jar}，列 {@code id / task_no / status / type}；</li>
 *   <li>宿主影子版（{@code shadow-entity-demo} 里同 FQN 的 {@code com.example.shadow.model.WmsTask}）：
 *       表 {@code wms_task_project}，列 {@code id / task_no / status / task_type / remark}。</li>
 * </ul>
 *
 * <p>字段名刻意与影子类保持一致的只有 HQL 引用到的 {@code status} / {@code type} /
 * {@code taskNo}，这样「解析到哪一版」的差异**只会**体现在表名与列清单上（影子版把
 * {@code type} 的物理列改名为 {@code task_type}，并多一个 {@code remark}），
 * 避免字段名本身不一致引入第二种降级原因。
 *
 * <p>运行期实际生效的是影子版：工程输出目录（{@code target/classes}）在 classpath 上
 * 先于依赖 JAR，同 FQN 的类以工程那份为准（详见宿主模块 README）。
 *
 * <p>注意：本类与影子类**同包同名**，两者不能出现在同一个编译单元的依赖里——
 * 一个在 JAR（本模块），一个在宿主工程源码，各编各的，互不引用。
 *
 * @author SongRenShuo
 */
@Entity
@Table(name = "wms_task_jar")
public class WmsTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "task_no")
    private String taskNo;

    @Column(name = "status")
    private String status;

    /** 影子版把这一列的物理名改成了 {@code task_type}（字段名保持 {@code type}，HQL 依旧可解析）。 */
    @Column(name = "type")
    private String type;

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
}
