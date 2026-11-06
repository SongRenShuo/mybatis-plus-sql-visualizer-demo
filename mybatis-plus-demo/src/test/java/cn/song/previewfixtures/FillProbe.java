package cn.song.previewfixtures;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

/** 仅供 IDE 静态预览；不注册实体或执行任何 MetaObjectHandler。 */
@TableName("ui_fill_probe")
public class FillProbe {
    @TableId(type = IdType.AUTO)
    private Long id;

    @Version
    private Integer revision;

    @TableField(fill = FieldFill.INSERT)
    private String createdBy;

    @TableField(fill = FieldFill.UPDATE)
    private String updatedBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long operatorId;

    @TableField(fill = FieldFill.DEFAULT)
    private String label;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getRevision() { return revision; }
    public void setRevision(Integer revision) { this.revision = revision; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    public String getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(String updatedBy) { this.updatedBy = updatedBy; }
    public Long getOperatorId() { return operatorId; }
    public void setOperatorId(Long operatorId) { this.operatorId = operatorId; }
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
}
