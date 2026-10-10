package cn.song.mybatisplusdemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 混合注解实体的值对象（T-Embedded G3 语料）：jakarta {@code @Embeddable}——
 * 与 MP {@code @TableName} 宿主 {@link MixedProfile} 共存，插件应把值对象字段
 * 展平为宿主表列（theme / notify_email / max_retry），而非产出 setting 伪列。
 *
 * <p>注意：MP 3.5.7 运行期不解析 jakarta 注解，本实体组定位为<b>静态预览语料</b>（勿 curl）。
 *
 * @author SongRenShuo
 */
@jakarta.persistence.Embeddable
@Data
public class ProfileSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 界面主题（展平列 theme） */
    private String theme;

    /** 通知邮箱（展平列 notify_email） */
    private String notifyEmail;

    /** 最大重试次数（展平列 max_retry） */
    private Integer maxRetry;
}
