package cn.song.jarlib.entity;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 物料键（嵌入对象，随实体一起打包进 JAR）——**内嵌第二层嵌入对象**。
 *
 * <p>里面还有一层 {@code @Embedded LotInfo lotInfo}，所以 HQL 里的属性路径是三段
 * {@code itemKey.lotInfo.receivedDate}；组件路径命名策略会把**每一段**都并进列名
 * （实测产物见模块 README 的验收清单）。
 *
 * <p>内层 {@link LotInfo} 用静态嵌套类承载（照用户工程形态），其字段同样
 * **零 @Column / @AttributeOverride**。
 *
 * @author SongRenShuo
 */
@Embeddable
public class WmsItemKey implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 批次信息（第二层嵌入对象，路径段 lotInfo） */
    @Embedded
    private LotInfo lotInfo;

    public LotInfo getLotInfo() {
        return lotInfo;
    }

    public void setLotInfo(LotInfo lotInfo) {
        this.lotInfo = lotInfo;
    }

    /**
     * 批次信息（静态嵌套嵌入类，路径段 lotInfo.receivedDate）。
     */
    @Embeddable
    public static class LotInfo implements Serializable {

        private static final long serialVersionUID = 1L;

        /** 收货时间 */
        private LocalDateTime receivedDate;

        public LocalDateTime getReceivedDate() {
            return receivedDate;
        }

        public void setReceivedDate(LocalDateTime receivedDate) {
            this.receivedDate = receivedDate;
        }
    }
}
