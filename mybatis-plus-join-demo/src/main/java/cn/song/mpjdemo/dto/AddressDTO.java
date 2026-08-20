package cn.song.mpjdemo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 地址子 DTO（selectCollection 集合元素类型）
 *
 * @author SongRenShuo
 */
@Data
public class AddressDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId;

    private String tel;

    private String address;
}
