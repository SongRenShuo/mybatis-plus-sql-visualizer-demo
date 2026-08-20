package cn.song.mpjdemo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户联查结果 DTO（user + user_address + area 三表字段）
 *
 * @author SongRenShuo
 */
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Integer age;

    private Integer sex;

    /**
     * 地址表字段（selectAs 别名映射）
     */
    private String tel;

    private String address;

    /**
     * 地区表字段
     */
    private String province;

    private String city;

    /**
     * 一对多：地址集合（selectCollection 映射）
     */
    private List<AddressDTO> addressList;

    /**
     * 一对一：默认地址（selectAssociation 映射）
     */
    private AddressDTO defaultAddress;
}
