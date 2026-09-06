package cn.song.jpademo.dto;

import java.io.Serializable;

/**
 * 用户精简 DTO——JPQL 构造器表达式（SELECT NEW）演示
 *
 * @author SongRenShuo
 */
public class UserLiteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    public UserLiteDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
