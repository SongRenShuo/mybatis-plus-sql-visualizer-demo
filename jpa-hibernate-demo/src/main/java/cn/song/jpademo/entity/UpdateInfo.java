package cn.song.jpademo.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/**
 * 预约单更新信息（@Embeddable 内嵌对象）。
 *
 * 对应 HQL 中 `booking.updateInfo.createdTime` 的嵌套属性访问形态。
 *
 * @author SongRenShuo
 */
@Data
@Embeddable
public class UpdateInfo {

    /**
     * 最后更新时间
     */
    private LocalDateTime createdTime;
}