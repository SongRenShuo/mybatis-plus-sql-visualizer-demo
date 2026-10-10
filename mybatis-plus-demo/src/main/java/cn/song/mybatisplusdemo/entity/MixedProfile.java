package cn.song.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * MP 混合注解实体（T-Embedded G3 语料）：{@code @TableName} 与 jakarta
 * {@code @Embedded/@Embeddable} 共存——插件 Wrapper 预览、批量模板与 CRUD 生成
 * 应把 {@link ProfileSetting} 的字段展平为宿主表列，不产 {@code update_info} 式伪列。
 *
 * <p>注意：MP 3.5.7 运行期不解析 jakarta 注解，本实体<b>仅静态预览语料</b>——
 * 启动后涉及 t_mixed_profile 的真实调用会因伪列报错，勿 curl。
 *
 * @author SongRenShuo
 */
@Data
@TableName("t_mixed_profile")
public class MixedProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 宿主自有列 name */
    private String name;

    /** 嵌入值对象（jakarta @Embedded）——展平为 theme / notify_email / max_retry 三列 */
    @jakarta.persistence.Embedded
    private ProfileSetting setting;

    /** 宿主自有列 remark */
    private String remark;
}
