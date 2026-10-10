package cn.song.jpademo.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

/**
 * 一级嵌入值对象（T-Embedded G2 语料）：street 自有列 + 嵌套 {@link Zipcode}——
 * 嵌套嵌入的列名覆写（name="zipcode.zip" 点路径）落在这条链上。
 *
 * @author SongRenShuo
 */
@Data
@Embeddable
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 街道（列 street） */
    private String street;

    /** 嵌套二级值对象（列 zip / area_code） */
    @Embedded
    private Zipcode zipcode;
}
