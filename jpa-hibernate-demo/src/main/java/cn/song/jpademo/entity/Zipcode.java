package cn.song.jpademo.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 二级嵌入值对象（T-Embedded G2 语料）：被 {@link Address} 嵌套，
 * 形成 宿主 → address → zipcode 的两级嵌入链——插件列名解析须经由点路径。
 *
 * @author SongRenShuo
 */
@Data
@Embeddable
public class Zipcode implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 邮政编码（列 zip） */
    private String zip;

    /** 区域代码（列 area_code） */
    private String areaCode;
}
